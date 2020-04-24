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
		@PythonDocString("Returns a tuple of (blockName as a string, meta as an int).")
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
			if (biomeId < 0 || biomeId > 255) { // TODO does Forge remove or change the cap?
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
		@PythonDocString("Returns the ID of the Biome at x and z as an int")
		public int getBiome(int x, int z) {
			BlockPos pos = new BlockPos(x, 0, z);

			this.tryThrowNotLoaded(pos);

			return Biome.getIdForBiome(this.worldObj.getBiomeForCoordsBody(pos));
		}

		@PythonFunction
		@PythonDocString("Returns the light level at x, y, z as an int.")
		public int getLight(int x, int y, int z) {
			BlockPos pos = new BlockPos(x, y, z);

			this.tryThrowNotLoaded(pos);

			return this.worldObj.getLight(pos);
		}

		@PythonFunction
		@PythonDocString("Spawns an Entity into the World and returns it.  nbtString can be None.")
		public entity.Base<? extends Entity> spawnEntity(String entityIdentifier, float x, float y, float z, String nbtString) {
			// Make sure the position is loaded.
			this.tryThrowNotLoaded(new BlockPos(x, y, z), "Can't spawn Entity, position not loaded");

			NBTTagCompound nbttagcompound = new NBTTagCompound();
			boolean hasNbtData = false;

			if (!StringUtils.isNullOrEmpty(nbtString)) {
				try {
					nbttagcompound = JsonToNBT.getTagFromJson(nbtString);
					hasNbtData = true;
				} catch (NBTException nbtexception) {
					throw Py.ValueError(nbtexception.getMessage());
				}
			}

			// Hacky fix to stop items from being killed instantly because the stack field
			// is null.
			if (entityIdentifier.equals(entityList.ITEM) && hasNbtData == false) {
				try {
					nbttagcompound = JsonToNBT.getTagFromJson("{Item:{id:stone,Count:1,Damage:0}}");
				} catch (NBTException e) {
					e.printStackTrace();
				}
			}

			nbttagcompound.setString("id", entityIdentifier);
			Entity javaEntity = AnvilChunkLoader.readWorldEntityPos(nbttagcompound, this.worldObj, x, y, z, true);

			if (javaEntity == null) {
				throw new PyException(new PyString("Could not summon Entity, the identifier " + entityIdentifier + " was invalid"));
			} else {
				javaEntity.setLocationAndAngles(x, y, z, javaEntity.rotationYaw, javaEntity.rotationPitch);

				if (!hasNbtData && javaEntity instanceof EntityLiving) {
					((EntityLiving) javaEntity).onInitialSpawn(
							this.worldObj.getDifficultyForLocation(new BlockPos(javaEntity)), (IEntityLivingData) null);
				}

				return entity.createWrapperClassForEntity(javaEntity);
			}
		}

		@PythonFunction
		@PythonDocString("Kills the passed Entity.")
		public void killEntity(@Nonnull entity.Base<Entity> entity) {
			if(entity == null) {
				throw Py.ValueError("Can not pass None");
			}
			entity.mcEntity.onKillCommand();
		}

		@PythonFunction
		@PythonDocString("Returns the closest Entity of type entityFilterName to (x, y, z) within the radius.  None is returned if no Entities that match can be found.  Pass None for all entity types.")
		@Nullable
		public entity.Base<? extends Entity> getClosestEntity(double x, double y, double z, float maxRadius,
				@Nullable String entityFilterName) {			
			double closestDistance = maxRadius + 1;
			Entity closestEntity = null;
			for (Entity temp : this.worldObj.loadedEntityList) {
				double d = temp.getDistance(x, y, z);
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
				return entity.createWrapperClassForEntity(closestEntity);
			}
		}

		@PythonFunction
		@PythonDocString("Returns a list of all the Entities within the passed coordinates.  Pass None for all entity types.")
		public PyList getAllEntites(float x1, float y1, float z1, float x2, float y2, float z2,
				@Nullable String entityFilterName) {
			List<Entity> list = this.worldObj.getEntitiesWithinAABB(Entity.class,
					new AxisAlignedBB(x1, y1, z1, x2, y2, z2), null);

			PyList returnList = new PyList();
			for (Entity temp : list) {
				if (this.checkEntityType(temp, entityFilterName)) {
					returnList.add(entity.createWrapperClassForEntity(temp));
				}
			}
			return returnList;
		}

		@PythonFunction
		@PythonDocString("Returns the passed tileEntity at x, y, z, or None if there isn't a tileEntity there.")
		@Nullable
		public tileEntity.TileEntityBase<? extends TileEntity> getTileEntity(int x, int y, int z) {
			TileEntity te = this.worldObj.getTileEntity(new BlockPos(x, y, z));
			if (te == null) {
				return null;
			} else {
				return tileEntity.getWrapperClassForTileEntity(te);
			}
		}

		@PythonFunction
		@PythonDocString("Spawns a particle effect.  See particleType.py for a list of types.")
		public void spawnParticle(String particleType, double x, double y, double z) {
			this.spawnParticle(particleType, x, y, z, 1, 0, 0, 0, 0, 0);
		}

		@PythonFunction
		@PythonDocString("Spawns a particle effect.  See particleType.py for a list of types.")
		public void spawnParticle(String particleType, double x, double y, double z, int count) {
			this.spawnParticle(particleType, x, y, z, count, 0, 0, 0, 0, 0);
		}

		@PythonFunction
		@PythonDocString("Spawns a particle effect.  See particleType.py for a list of types.")
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
		@PythonDocString("Returns this World's dimension id.  0 for the Overworld, -1 for the Nether and 1 for the End.  Other values may be returned for custom dimensions.")
		public int getDimensionId() {
			return this.worldObj.provider.getDimension();
		}

		@PythonFunction
		@PythonDocString("Returns the world time as an int.")
		public long getWorldTime() {
			return this.worldObj.getWorldTime();
		}

		@PythonFunction
		@PythonDocString("Plays a sound.  categoryName is for what volume setting should be used.  See soundCategory.py for a list of sound categories.")
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

		/**
		 * Checks if the passed filter name matches the passed entity.
		 */
		private boolean checkEntityType(Entity entity, @Nullable String entityFilterName) {
			if (entityFilterName != null) {
				if ((entity instanceof EntityPlayer && entityFilterName.endsWith(entityList.PLAYER))) {
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
