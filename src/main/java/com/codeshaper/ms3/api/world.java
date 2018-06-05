package com.codeshaper.ms3.api;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.python.core.Py;
import org.python.core.PyException;
import org.python.core.PyInteger;
import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonTypeExclude;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.tileentity.TileEntityNote;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.StringUtils;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;

public class world {

	private world() {
	}

	@PythonClass
	public static class World extends PyObject {

		private net.minecraft.world.WorldServer worldObj;

		public World(net.minecraft.world.WorldServer javaWorldServerObject) {
			this.worldObj = javaWorldServerObject;
		}

		@PythonFunction
		@PythonDocString("Sets a Block in the World.")
		public void setBlockState(String blockName, int meta, int x, int y, int z) {
			BlockPos pos = new BlockPos(x, y, z);

			this.tryThrowNotLoaded(pos);

			Block b = Block.getBlockFromName(blockName);
			this.worldObj.setBlockState(pos, b.getStateFromMeta(meta));
		}

		@PythonFunction
		@PythonDocString("Returns a tuple of (blockName, meta).")
		public PyTuple getBlockState(int x, int y, int z) {
			BlockPos pos = new BlockPos(x, y, z);

			this.tryThrowNotLoaded(pos);

			IBlockState state = this.worldObj.getBlockState(pos);
			Block block = state.getBlock();
			return new PyTuple(new PyString(block.getRegistryName().toString()),
					new PyInteger(block.getMetaFromState(state)));
		}

		@PythonFunction
		@PythonDocString("Sets a columns biomes.  See biomeList.py for biome id constants.")
		public void setBiome(int biomeId, int x, int z) {
			if (biomeId < 0 || biomeId > 255) { // TODO does forge remove or change the cap?
				throw Py.ValueError("biomeId can't be less than 0 or greater than 255.");
			}
			BlockPos pos = new BlockPos(x, 0, z);

			this.tryThrowNotLoaded(pos);

			Chunk chunk = this.worldObj.getChunkFromBlockCoords(pos);
			byte[] biomeArray = chunk.getBiomeArray();
			biomeArray[(pos.getZ() & 15) << 4 | (pos.getX() & 15)] = (byte) (biomeId & 255);
			chunk.setBiomeArray(biomeArray);
		}

		/**
		 * Throws a Py.ValueError if the coordinates are not loaded.
		 */
		private void tryThrowNotLoaded(@Nonnull BlockPos pos) {
			this.tryThrowNotLoaded(pos, null);
		}

		private void tryThrowNotLoaded(@Nonnull BlockPos pos, @Nullable String message) {
			if (!this.worldObj.isBlockLoaded(pos)) {
				throw Py.ValueError("Coordinates of (" + pos.getX() + "," + pos.getY() + "," + pos.getZ()
						+ ") are not loaded!" + (message != null ? " " + message : ""));
			}
		}

		@PythonFunction
		@PythonDocString("Returns the ID of the Biome at x, z.")
		public int getBiome(int x, int z) {
			BlockPos pos = new BlockPos(x, 0, z);

			this.tryThrowNotLoaded(pos);

			return Biome.getIdForBiome(this.worldObj.getBiomeForCoordsBody(pos));
		}

		@PythonFunction
		@PythonDocString("Returns the light level at x, y, z.")
		public int getLight(int x, int y, int z) {
			BlockPos pos = new BlockPos(x, y, z);

			this.tryThrowNotLoaded(pos);

			return this.worldObj.getLight(pos);
		}

		@PythonFunction
		@PythonDocString("Spawns an Entity into the World and returns it.  Entity can be an instance of net.minecraft.entity.Entity, PyEntity or it's string name.")
		public entity.Base<? extends Entity> spawnEntity(@PythonTypeExclude @Nonnull Object entityIdentifier, float x, float y, float z, String nbt) {
			// Get a string identifier for the entity from the passed argument.
			String entityStringName = null;
			if (entityIdentifier instanceof Entity) {
				entityStringName = this.entityToStringName((Entity) entityIdentifier);
			} else if (entityIdentifier instanceof String) {
				entityStringName = (String) entityIdentifier;
			} else if (entityIdentifier instanceof entity.Base) {
				entityStringName = this.entityToStringName(((entity.Base<?>) entityIdentifier).mcEntity);
			}

			BlockPos pos = new BlockPos(x, y, z);

			this.tryThrowNotLoaded(pos, "Could not summon Entity!");

			NBTTagCompound nbttagcompound = new NBTTagCompound();
			boolean flag = false;

			if (!StringUtils.isNullOrEmpty(nbt)) { //args.length >= 5) {
				try {
					nbttagcompound = JsonToNBT.getTagFromJson(nbt);
					flag = true;
				} catch (NBTException nbtexception) {
					throw Py.ValueError(nbtexception.getMessage());
				}
			}

			// Hacky fix to stop items from being killed instantly because the stack field
			// is null.
			if (entityStringName.equals(entityList.ITEM) && flag == false) {
				try {
					nbttagcompound = JsonToNBT.getTagFromJson("{Item:{id:stone,Count:1,Damage:0}}");
				} catch (NBTException e) {
					e.printStackTrace();
				}
			}

			nbttagcompound.setString("id", entityStringName);
			Entity javaEntity = AnvilChunkLoader.readWorldEntityPos(nbttagcompound, this.worldObj, x, y, z, true);

			if (javaEntity == null) {
				throw new PyException(new PyString("Could not summon Entity! (The identifier " + entityStringName + " was invalid!)"));
			} else {
				javaEntity.setLocationAndAngles(x, y, z, javaEntity.rotationYaw, javaEntity.rotationPitch);

				if (!flag && javaEntity instanceof EntityLiving) {
					((EntityLiving) javaEntity).onInitialSpawn(
							this.worldObj.getDifficultyForLocation(new BlockPos(javaEntity)), (IEntityLivingData) null);
				}

				return entity.getWrapperClassForEntity(javaEntity);
			}
		}

		@PythonFunction
		@PythonDocString("Kills the passed Entity.")
		public void killEntity(@Nonnull entity.Base<Entity> entity) {
			entity.mcEntity.onKillCommand();
		}

		@PythonFunction
		@PythonDocString("Returns the closest Entity of type entityFilterName to (x, y, z) within the radius, or None if none are found.  Pass None for all entity types.")
		@Nullable
		public entity.Base<? extends Entity> getClosestEntity(double x, double y, double z, float maxRadius,
				@Nullable String entityFilterName) {
			double closestDistance = maxRadius + 1;
			Entity closestEntity = null;
			Entity temp;
			for (int i = 0; i < this.worldObj.loadedEntityList.size(); i++) {
				temp = this.worldObj.loadedEntityList.get(i);
				double d = temp.getDistanceSq(x, y, z);
				if (d <= maxRadius && d < closestDistance) {
					// This entity is closer, make sure it's the right type.
					if (this.checkEntityType(temp, entityFilterName)) {
						closestDistance = d;
						closestEntity = temp;
					}
				}
			}

			if (closestEntity == null) {
				return null;
			} else {
				return entity.getWrapperClassForEntity(closestEntity);
			}
		}

		@PythonFunction
		@PythonDocString("Returns a list of all the Entities within the passes radius around (x, y, z) as a list.  Pass None for all entity types.")
		public PyList getAllEntites(float x1, float y1, float z1, float x2, float y2, float z2,
				@Nullable String entityFilterName) {
			List<Entity> list = this.worldObj.getEntitiesWithinAABB(Entity.class,
					new AxisAlignedBB(x1, y1, z1, x2, y2, z2), null);

			PyList returnList = new PyList();
			for (Entity temp : list) {

				if (this.checkEntityType(temp, entityFilterName)) {
					returnList.add(entity.getWrapperClassForEntity(temp));
				}
			}
			return returnList;
		}

		@PythonFunction
		@PythonDocString("Returns the passed tileEntity at x, y, z, or None if there isn't any.")
		@Nullable
		public tileEntity.TileEntityBase<? extends TileEntity> getTileEntity(int x, int y, int z) {
			TileEntity te = this.worldObj.getTileEntity(new BlockPos(x, y, z));
			if (te == null) {
				return null;
			} else {
				return this.getWrapperClassForTileEntity(te);
			}
		}

		@PythonFunction
		public void spawnParticle(String particleType, double x, double y, double z) {
			this.spawnParticle(particleType, x, y, z, 1, 0, 0, 0, 0, 0);
		}

		@PythonFunction
		public void spawnParticle(String particleType, double x, double y, double z, int count) {
			this.spawnParticle(particleType, x, y, z, count, 0, 0, 0, 0, 0);
		}

		@PythonFunction
		@PythonDocString("Summons a particle effect")
		public void spawnParticle(String particleType, double x, double y, double z, int count, double areaSizeX,
				double areaSizeY, double areaSizeZ, double speed, @Nullable int params) {

			this.tryThrowNotLoaded(new BlockPos(x, y, z));

			EnumParticleTypes type = EnumParticleTypes.getByName(particleType);
			if (type != null) {
				this.worldObj.spawnParticle(type, x, y, z, count, areaSizeX, areaSizeY, areaSizeZ, speed, params);
			} else {
				throw Py.ValueError("Unknown particle type: \"" + particleType + "\"");
			}
		}

		@PythonFunction
		@PythonDocString("Returns the World's dimension id.  0 for the Overworld, -1 for the Nether and 1 for the End.  Other values may be returned for custom dimensions.")
		public int getDimensionId() {
			return this.worldObj.provider.getDimension();
		}

		@PythonFunction
		@PythonDocString("Returns the world time.")
		public long getWorldTime() {
			return this.worldObj.getWorldTime();
		}

		@PythonFunction
		@PythonDocString("Plays a sound.  categoryName if for what volume setting should be used.  See coundCategory.py for a list of sound categories.")
		public void playSound(String soundName, String categoryName, double x, double y, double z, float volume,
				float pitch) {

			SoundEvent soundEvent = SoundEvent.REGISTRY.getObject(new ResourceLocation(soundName));
			if (soundEvent == null) {
				throw Py.ValueError("Sound \"" + soundName + "\" could not be found");
			}
			SoundCategory category = SoundCategory.getByName(categoryName);
			if (category == null) {
				throw Py.ValueError("Category \"" + categoryName + "\" cound not be found");
			}

			this.worldObj.playSound(null, x, y, z, soundEvent, category, volume, pitch);
		}

		private tileEntity.TileEntityBase<? extends TileEntity> getWrapperClassForTileEntity(@Nonnull TileEntity te) {
			// Specific types:
			if (te instanceof TileEntityBeacon) {
				return tileEntity.instance.new Beacon((TileEntityBeacon) te);
			} else if (te instanceof TileEntityBed) {
				return tileEntity.instance.new Bed((TileEntityBed) te);
			} else if (te instanceof TileEntityBrewingStand) {
				return tileEntity.instance.new BrewingStand((TileEntityBrewingStand) te);
			} else if (te instanceof TileEntityCommandBlock) {
				return tileEntity.instance.new CommandBlock((TileEntityCommandBlock) te);
			} else if (te instanceof TileEntityFlowerPot) {
				return tileEntity.instance.new FlowerPot((TileEntityFlowerPot) te);
			} else if (te instanceof TileEntityFurnace) {
				return tileEntity.instance.new Furnace((TileEntityFurnace) te);
			} else if (te instanceof TileEntityHopper) {
				return tileEntity.instance.new Hopper((TileEntityHopper) te);
			} else if (te instanceof TileEntityMobSpawner) {
				return tileEntity.instance.new Spawner((TileEntityMobSpawner) te);
			} else if (te instanceof TileEntityNote) {
				return tileEntity.instance.new NoteBlock((TileEntityNote) te);
			} else if (te instanceof TileEntitySign) {
				return tileEntity.instance.new Sign((TileEntitySign) te);
			} else if (te instanceof TileEntitySkull) {
				return tileEntity.instance.new Skull((TileEntitySkull) te);
			}

			// More generic type:
			else if (te instanceof TileEntityLockableLoot) {
				return tileEntity.instance.new LockableLoot<TileEntityLockableLoot>((TileEntityLockableLoot) te);
			} else if (te instanceof TileEntityLockable) {
				return tileEntity.instance.new Lockable<TileEntityLockable>((TileEntityLockable) te);
			} else {
				return tileEntity.instance.new TileEntityBase<TileEntity>(te);
			}
		}


		private String entityToStringName(Entity entity) {
			ResourceLocation resourcelocation = EntityList.getKey(entity);
			return (resourcelocation == null ? null : resourcelocation.toString());
		}

		/**
		 * Checks if the passed filter name matches the passed entity.
		 */
		private boolean checkEntityType(Entity entity, String entityFilterName) {
			if (entityFilterName != null) {
				if ((entity instanceof EntityPlayer && entityFilterName.endsWith("player"))) {
					return true;
				} else {
					ResourceLocation location = EntityList.getKey(entity);
					if (location != null && location.getResourcePath().equals(entityFilterName)) {
						return true;
					}
				}
			} else {
				return true;
			}

			return false;
		}
	}
}
