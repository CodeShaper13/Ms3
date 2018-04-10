package com.codeshaper.ms3.api;

import java.lang.reflect.Field;
import java.util.UUID;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.python.core.Py;
import org.python.core.PyBoolean;
import org.python.core.PyException;
import org.python.core.PyFloat;
import org.python.core.PyInteger;
import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.core.PyTuple;

import com.codeshaper.ms3.api.exception.MissingScriptException;
import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonExcludeType;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.capability.EntityMs3DataProvider;
import com.codeshaper.ms3.capability.IEntityMs3Data;
import com.codeshaper.ms3.util.NbtHelper;
import com.codeshaper.ms3.util.Util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.dragon.phase.PhaseList;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.AbstractChestHorse;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.passive.EntityZombieHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StringUtils;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.GameType;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class entity {

	public static final entity instance = new entity();

	public static entity.Base<? extends Entity> getWrapperClassForEntity(@Nonnull Entity javaEntity) {
		// Specific types:
		if (javaEntity instanceof AbstractChestHorse) { // Donkey, mule and llama.
			return entity.instance.new ChestHorse((AbstractChestHorse) javaEntity);
		} else if (javaEntity instanceof EntityArmorStand) {
			return entity.instance.new ArmorStand((EntityArmorStand) javaEntity);
		} else if (javaEntity instanceof EntityBat) {
			return entity.instance.new Bat((EntityBat) javaEntity);
		} else if (javaEntity instanceof EntityBoat) {
			return entity.instance.new Boat((EntityBoat) javaEntity);
		} else if (javaEntity instanceof EntityChicken) {
			return entity.instance.new Chicken((EntityChicken) javaEntity);
		} else if (javaEntity instanceof EntityCreeper) {
			return entity.instance.new Creeper((EntityCreeper) javaEntity);
		} else if (javaEntity instanceof EntityEnderman) {
			return entity.instance.new Enderman((EntityEnderman) javaEntity);
		} else if (javaEntity instanceof EntityDragon) {
			return entity.instance.new EnderDragon((EntityDragon) javaEntity);
		} else if (javaEntity instanceof EntityEndermite) {
			return entity.instance.new Endermite((EntityEndermite) javaEntity);
		} else if (javaEntity instanceof EntityGhast) {
			return entity.instance.new Ghast((EntityGhast) javaEntity);
		} else if (javaEntity instanceof EntityHorse || javaEntity instanceof EntityZombieHorse) {
			return entity.instance.new Horse((EntityHorse) javaEntity);
		} else if (javaEntity instanceof EntityItem) {
			return entity.instance.new ItemEntity((EntityItem) javaEntity);
		} else if (javaEntity instanceof EntityOcelot) {
			return entity.instance.new Ocelot((EntityOcelot) javaEntity);
		} else if(javaEntity instanceof EntityPainting) {
			return entity.instance.new Painting((EntityPainting) javaEntity);
		} else if (javaEntity instanceof EntityParrot) {
			return entity.instance.new Parrot((EntityParrot) javaEntity);
		} else if (javaEntity instanceof EntityPig) {
			return entity.instance.new Pig((EntityPig) javaEntity);
		} else if (javaEntity instanceof EntityPlayer) {
			return entity.instance.new Player((EntityPlayerMP) javaEntity);
		} else if (javaEntity instanceof EntityRabbit) {
			return entity.instance.new Rabbit((EntityRabbit) javaEntity);
		} else if (javaEntity instanceof EntitySheep) {
			return entity.instance.new Sheep((EntitySheep) javaEntity);
		} else if (javaEntity instanceof EntityShulker) {
			return entity.instance.new Shulker((EntityShulker) javaEntity);
		} else if (javaEntity instanceof EntitySkeletonHorse) {
			return entity.instance.new SkeletonHorse((EntitySkeletonHorse) javaEntity);
		} else if(javaEntity instanceof EntityTNTPrimed) {
			return entity.instance.new Tnt((EntityTNTPrimed) javaEntity);
		} else if (javaEntity instanceof EntitySlime || javaEntity instanceof EntityMagmaCube) {
			return entity.instance.new Slime((EntitySlime) javaEntity);
		} else if (javaEntity instanceof EntitySnowman) {
			return entity.instance.new Snowman((EntitySnowman) javaEntity);
		} else if (javaEntity instanceof EntityVillager) {
			return entity.instance.new Villager((EntityVillager) javaEntity);
		} else if (javaEntity instanceof EntityWolf) {
			return entity.instance.new Wolf((EntityWolf) javaEntity);
		} else if (javaEntity instanceof EntityZombie || javaEntity instanceof EntityHusk) {
			return entity.instance.new Zombie<EntityZombie>((EntityZombie) javaEntity);
		} else if (javaEntity instanceof EntityZombieVillager) {
			return entity.instance.new ZombieVillager((EntityZombieVillager) javaEntity);
		}

		// More generic types:

		else if (javaEntity instanceof EntityTameable) {
			return entity.instance.new Tameable<EntityTameable>((EntityTameable) javaEntity);
		} else if (javaEntity instanceof EntityAnimal) {
			return entity.instance.new Animal<EntityAnimal>((EntityAnimal) javaEntity);
		} else if(javaEntity instanceof EntityHanging) {
			return entity.instance.new Hanging<EntityHanging>((EntityHanging) javaEntity);
		} else if (javaEntity instanceof EntityLiving) {
			return entity.instance.new Living<EntityLiving>((EntityLiving) javaEntity);
		} else if (javaEntity instanceof EntityLivingBase) {
			return entity.instance.new LivingBase<EntityLivingBase>((EntityLivingBase) javaEntity);
		} else {
			return entity.instance.new Base<Entity>(javaEntity);
		}
	}

	/**
	 * Equivalent to {@link net.minecraft.entity.Entity}.
	 */
	@PythonClass
	public class Base<T extends Entity> extends PyObject {

		private static final long serialVersionUID = 4773038377439473236L;
		
		public T mcEntity;

		public Base(T entity) {
			this.mcEntity = entity;
		}

		@PythonFunction
		@PythonDocString("Returns the Entity's internal java instance.  For advanced users only!")
		public T getJavaEntity() {
			return this.mcEntity;
		}

		@PythonFunction
		@PythonDocString("Returns the entity's name as seen in entityList.py.")
		public String getMobName() {
			return EntityList.getKey(this.mcEntity).getResourcePath();
		}

		@PythonFunction
		@PythonDocString("Returns the Entity's X position.")
		public double getX() {
			return this.mcEntity.posX;
		}

		@PythonFunction
		@PythonDocString("Returns the Entity's Y position.")
		public double getY() {
			return this.mcEntity.posY;
		}

		@PythonFunction
		@PythonDocString("Returns the Entity's Z position.")
		public double getZ() {
			return this.mcEntity.posZ;
		}

		@PythonFunction
		@PythonDocString("Returns the Entity's position as a tuple.")
		public PyTuple getPosition() {
			return new PyTuple(new PyFloat(this.getX()), new PyFloat(this.getY()), new PyFloat(this.getZ()));
		}

		@PythonFunction
		@PythonDocString("Returns the Entity's rotation as a tuple of (yaw, pitch).")
		public PyTuple getRotation() {
			return new PyTuple(new PyFloat(this.mcEntity.rotationYaw), new PyFloat(this.mcEntity.rotationPitch));
		}

		@PythonFunction
		@PythonDocString("Returns the Entity's motion as a tuple.")
		public PyTuple getMotion() {
			return new PyTuple(new PyFloat(this.mcEntity.motionX), new PyFloat(this.mcEntity.motionY),
					new PyFloat(this.mcEntity.motionZ));
		}

		@PythonFunction
		@PythonDocString("Sets the Entity's position.  Note, due to a Minecraft bug, this function will not work on Entities spawned on the same tick.")
		public void setPosition(double x, double y, double z) {
			this.mcEntity.setLocationAndAngles(x, y, z, this.mcEntity.rotationYaw, this.mcEntity.rotationPitch);
		}

		@PythonFunction
		@PythonDocString("Sets the Entity's yaw and pitch in degrees.  Yaw is y axis (side to side) and pitch x axis (up and down).")
		public void setRotation(float yaw, float pitch) {
			yaw = MathHelper.wrapDegrees(yaw);
			pitch = MathHelper.wrapDegrees(pitch);
			this.mcEntity.rotationYaw = yaw;
			this.mcEntity.rotationPitch = pitch;
			this.mcEntity.setRotationYawHead(yaw);
		}

		@PythonFunction
		public void setMotion(float x, float y, float z) {
			this.mcEntity.motionX = x;
			this.mcEntity.motionY = y;
			this.mcEntity.motionZ = z;
		}

		@PythonFunction
		public boolean isInvulnerable() {
			return this.mcEntity.getIsInvulnerable();
		}

		@PythonFunction
		public void setInvulnerable(boolean flag) {
			this.mcEntity.setEntityInvulnerable(flag);
		}

		@PythonFunction
		public boolean isSilent() {
			return this.mcEntity.isSilent();
		}

		@PythonFunction
		public void setSilent(boolean isSilent) {
			this.mcEntity.setSilent(isSilent);
		}

		@PythonFunction
		public boolean isNoGravity() {
			return this.mcEntity.hasNoGravity();
		}

		@PythonFunction
		public void setNoGravity(boolean noGravity) {
			this.mcEntity.setNoGravity(noGravity);
		}

		@PythonFunction
		public String getCustomName() {
			return this.mcEntity.getCustomNameTag();
		}

		@PythonFunction
		public void setCustomName(String name) {
			this.mcEntity.setCustomNameTag(Util.correctColorCode(name));
		}

		@PythonFunction
		public boolean isCustomNameVisible() {
			return this.mcEntity.getAlwaysRenderNameTag();
		}

		@PythonFunction
		public void setCustomNameVisible(boolean alwaysRenderNameTag) {
			this.mcEntity.setAlwaysRenderNameTag(alwaysRenderNameTag);
		}

		@PythonFunction
		public boolean isGlowing() {
			return this.mcEntity.isGlowing();
		}

		@PythonFunction
		public void setGlowing(boolean isGlowing) {
			this.mcEntity.setGlowing(isGlowing);
		}

		@PythonFunction
		@PythonDocString("Returns the value of an nbt tag.  If the tag can't be found, None is returned.")
		@Nullable
		public Object getTag(String tagKey) {
			NBTBase tag = CommandBase.entityToNBT(this.mcEntity).getTag(tagKey);
			return NbtHelper.nbtToObject(tag);
		}

		@PythonFunction
		@PythonDocString("Sets an NBT tag for the entity.  For byte tags that represtend boolean values 1/0, \"true\"/\"false\" or True/False will work.  For nested tags type them like you would for the /entitydata command, but without the beginning and ending curly braces {}")
		public void setTag(String tagKey, @PythonExcludeType Object value) {
			NBTTagCompound nbttagcompound = CommandBase.entityToNBT(this.mcEntity);
			NBTTagCompound nbtTagCopy = nbttagcompound.copy();
			NBTTagCompound nbttagcompound2;

			try {
				nbttagcompound2 = JsonToNBT.getTagFromJson("{" + tagKey + ":" + value.toString() + "}");
			} catch (NBTException nbtexception) {
				throw Py.ValueError("Nbt was not in valid JSON format!");
			}

			UUID uuid = this.mcEntity.getUniqueID();
			nbttagcompound.merge(nbttagcompound2);
			this.mcEntity.setUniqueId(uuid);

			if (nbttagcompound.equals(nbtTagCopy)) {
				throw Py.ValueError("commands.entitydata.failed");
			} else {
				this.mcEntity.readFromNBT(nbttagcompound);
			}
		}

		@PythonFunction
		@PythonDocString("Sends a message to the entity.  For Players this will show up in chat for them.")
		public void sendMessage(String message) {
			this.mcEntity.sendMessage(new TextComponentString(message.replace('&', Util.SECTION_SIGN)));
		}

		@PythonFunction
		@PythonDocString("Binds a script to the entity, so it will execute every tick.")
		public void bindScript(String scriptPath, @Nullable PyList args) throws PyException, MissingScriptException {
			IEntityMs3Data bs = this.mcEntity.getCapability(EntityMs3DataProvider.ENTITY_MS3_DATA_CAP, null);
			bs.addScript(scriptPath, args);
		}

		@PythonFunction
		@PythonDocString("Removes all scripts that are bound to this entity.")
		public void clearAllBoundScripts() {
			IEntityMs3Data bs = this.mcEntity.getCapability(EntityMs3DataProvider.ENTITY_MS3_DATA_CAP, null);
			bs.setClearMethodCall();
		}

		@PythonFunction
		@PythonDocString("Returns the custom property, or None if the property can't be found.")
		public Object getProperty(String propertyName) {
			if (StringUtils.isNullOrEmpty(propertyName)) {
				throw Py.ValueError("propertyName may not be None or empty");
			}

			IEntityMs3Data bs = this.mcEntity.getCapability(EntityMs3DataProvider.ENTITY_MS3_DATA_CAP, null);
			return bs.getCustomProperty(propertyName);
		}

		@PythonFunction
		@PythonDocString("Sets a custom property, overriding the previous one if it exists.  Pass None for value to remove the property.")
		public void setProperty(String propertyName, @PythonExcludeType Object value) {
			if (StringUtils.isNullOrEmpty(propertyName)) {
				throw Py.ValueError("propertyName may not be None or empty");
			}

			IEntityMs3Data bs = this.mcEntity.getCapability(EntityMs3DataProvider.ENTITY_MS3_DATA_CAP, null);
			if (value == null) {
				bs.removeCustomProperty(propertyName);
			} else {
				if (value instanceof Number || value instanceof String || value instanceof entity.Base) {
					bs.setCustomProperty(propertyName, value);
				} else {
					throw Py.ValueError("value must be a string, number, instance of Base or or None");
				}
			}
		}

		@PythonFunction
		@PythonDocString("")
		public boolean isAlive() {
			return this.mcEntity.isEntityAlive();
		}

		@Override
		public PyObject __eq__(PyObject other) {
			if (other == null) {
				return Py.False;
			}
			if (other instanceof Base) {
				Base<?> e = (Base<?>) other;
				return new PyBoolean(e.mcEntity.getUniqueID().equals(this.mcEntity.getUniqueID()));
			}
			return Py.False;
		}
		
		@Override
		public PyObject __ne__(PyObject other) {
			return Util.pyNotHelper(this.__eq__(other));
		}

		/**
		 * Used to check that slot indices are in bounds.
		 * 
		 * @param index
		 * @param upperSize
		 */
		protected void func_05(int index, int upperSize) {
			if (index < 0 || index > upperSize) {
				throw Py.ValueError(
						"Index is invalid, it must be between 0 and " + upperSize + " inclusive and was " + index);
			}
		}
	}

	/**
	 * Equivalent to {@link net.minecraft.entity.EntityLivingBase}.
	 */
	@PythonClass
	public class LivingBase<T extends EntityLivingBase> extends Base<T> {

		private static final long serialVersionUID = 6576870800969843533L;

		public LivingBase(T entity) {
			super(entity);
		}

		@PythonFunction
		public float getHealth() {
			return this.mcEntity.getHealth();
		}

		@PythonFunction
		public void setHealth(float health) {
			this.mcEntity.setHealth(health);
		}
	}

	/**
	 * Equivalent to {@link net.minecraft.entity.EntityLiving}.
	 */
	@PythonClass
	public class Living<T extends EntityLiving> extends LivingBase<T> implements IHasEquipment {

		private static final long serialVersionUID = -7574703220388172933L;

		public Living(T entity) {
			super(entity);
		}

		@PythonFunction
		@PythonDocString("Makes the entity look at the passed position.  yawSpeed and pitchSpeed are how fast the entity will look at the target.")
		public void lookAt(PyTuple position, float yawSpeed, float pitchSpeed) {
			this.mcEntity.getLookHelper().setLookPosition((double) position.get(0), (double) position.get(1),
					(double) position.get(2), yawSpeed, pitchSpeed);
		}

		@PythonFunction
		public boolean isNoAi() {
			return this.mcEntity.isAIDisabled();
		}

		@PythonFunction
		public void setNoAi(boolean noAi) {
			this.mcEntity.setNoAI(noAi);
		}

		@PythonFunction
		public boolean getCanPickUpLoot() {
			return this.mcEntity.canPickUpLoot();
		}

		@PythonFunction
		public void setCanPickUpLoot(boolean canPickUpLoot) {
			this.mcEntity.setCanPickUpLoot(canPickUpLoot);
		}

		@PythonFunction
		@PythonDocString("Returns True if the Entity is left handed.")
		public boolean isLeftHanded() {
			return this.mcEntity.isLeftHanded();
		}

		@PythonFunction
		public void setLeftHanded(boolean leftHanded) {
			this.mcEntity.setLeftHanded(leftHanded);
		}

		@PythonFunction
		@PythonDocString("See equipmentSlot.py for index constants.")
		@Override
		public PyTuple getSlotContents(int slotIndex) {
			this.func_05(slotIndex, 6);
			return itemUtils
					.tupleFromItemStack(this.mcEntity.getItemStackFromSlot(equipmentSlot.indexToEnum(slotIndex)));
		}

		@PythonFunction
		@PythonDocString("See equipmentSlot.py for index constants.")
		@Override
		public void setSlotContents(int slotIndex, @Nullable PyTuple itemStack) {
			this.func_05(slotIndex, 6);
			ItemStack s;
			if (itemStack == null) {
				s = ItemStack.EMPTY;
			} else {
				s = itemUtils.itemStackFromTuple(itemStack);
			}
			this.mcEntity.setItemStackToSlot(equipmentSlot.indexToEnum(slotIndex), s);
		}
	}

	/**
	 * Equivalent to {@link net.minecraft.entity.passive.EntityAnimal}.
	 */
	@PythonClass
	public class Animal<T extends EntityAnimal> extends Living<T> {

		private static final long serialVersionUID = -7740390218861739942L;

		public Animal(T entity) {
			super(entity);
		}

		@PythonFunction
		public boolean isInLove() {
			return this.mcEntity.isInLove();
		}

		@PythonFunction
		@PythonDocString("entityPlayer is whoever set the entity into love, used for achievements and stats.  Pass an instance of entity.Player, net.minecraft.entity.player.EntityPlayer or None.")
		public void setInLove(@Nullable @PythonExcludeType Object entityPlayer) {
			if (entityPlayer instanceof EntityPlayer) {
				this.mcEntity.setInLove((EntityPlayer) entityPlayer);
			} else if (entityPlayer instanceof Player) {
				this.mcEntity.setInLove(((Player) entityPlayer).mcEntity);
			} else {
				this.mcEntity.setInLove(null);
			}
		}

		@PythonFunction
		public int getAge() {
			return this.mcEntity.getGrowingAge();
		}

		@PythonFunction
		public void setAge(int age) {
			this.mcEntity.setGrowingAge(age);
		}

		// ForcedAge is protected.
	}

	@PythonClass
	public class ArmorStand extends LivingBase<EntityArmorStand> {

		private static final long serialVersionUID = 5645396411684790277L;

		public ArmorStand(EntityArmorStand entity) {
			super(entity);
		}

		@PythonFunction
		public boolean isNoGravity() {
			return this.mcEntity.hasNoGravity();
		}

		@PythonFunction
		public void setNoGravity(boolean noGravity) {
			this.mcEntity.setNoGravity(noGravity);
		}

		@PythonFunction
		public boolean isNoBaseplate() {
			return this.mcEntity.hasNoBasePlate();
		}

		@PythonFunction
		public boolean isMarker() {
			return this.mcEntity.hasMarker();
		}
	}

	@PythonClass
	public class Bat extends Living<EntityBat> {

		private static final long serialVersionUID = -4486350108913718292L;

		public Bat(EntityBat entity) {
			super(entity);
		}

		@PythonFunction
		public boolean isHanging() {
			return this.mcEntity.getIsBatHanging();
		}

		@PythonFunction
		@PythonDocString("Sets tag \"BatFlags\" to 1 for True, or 0 for False.")
		public void setHanging(boolean isHanging) {
			this.mcEntity.setIsBatHanging(isHanging);
		}
	}

	@PythonClass
	public class Boat extends Base<EntityBoat> {

		private static final long serialVersionUID = -9198241601349531102L;

		@PythonField
		public static final String TYPE_OAK = "oak";
		@PythonField
		public static final String TYPE_SPRUCE = "spruce";
		@PythonField
		public static final String TYPE_BIRCH = "birch";
		@PythonField
		public static final String TYPE_JUNGLE = "jungle";
		@PythonField
		public static final String TYPE_ACACIA = "acacia";
		@PythonField
		public static final String TYPE_DARK_OAK = "dark_oak";

		public Boat(EntityBoat entity) {
			super(entity);
		}

		@PythonFunction
		@PythonDocString("Sets the boats type.  Defaults to 'oak' if the name is invalid.")
		public void setBoatType(String type) {
			this.mcEntity.setBoatType(EntityBoat.Type.getTypeFromString(type));
		}

		@PythonFunction
		public String getBoatType() {
			return this.mcEntity.getBoatType().getName();
		}
	}

	@PythonClass
	public class Chicken extends Animal<EntityChicken> {

		private static final long serialVersionUID = 1241156688676494683L;

		public Chicken(EntityChicken entity) {
			super(entity);
		}

		@PythonFunction
		@PythonDocString("Returns the number of ticks until an egg is layed.")
		public int getEggLayTime() {
			return this.mcEntity.timeUntilNextEgg;
		}

		@PythonFunction
		@PythonDocString("Sets the number of ticks until an egg is layed.")
		public void setEggLayTime(int eggLayTime) {
			this.mcEntity.timeUntilNextEgg = eggLayTime;
		}

		@PythonFunction
		public boolean isChickenJockey() {
			return this.mcEntity.isChickenJockey();
		}

		@PythonFunction
		public void setChickenJockey(boolean isChickenJockey) {
			this.mcEntity.setChickenJockey(isChickenJockey);
		}
	}

	@PythonClass
	public class Creeper extends Living<EntityCreeper> {

		private static final long serialVersionUID = -7320650346138191612L;

		public Creeper(EntityCreeper entity) {
			super(entity);
		}

		@PythonFunction
		public boolean isCharged() {
			return (boolean) this.getTag("powered");
		}

		@PythonFunction
		public void setCharged(boolean ignited) {
			this.setTag("powered", ignited);
		}

		@PythonFunction
		public int getExplosionRadius() {
			return (int) this.getTag("ExplosionRadius");
		}

		@PythonFunction
		public void setExplosionRadius(int radius) {
			this.setTag("ExplosionRadius", radius);
		}

		@PythonFunction
		public boolean isIgnited() {
			return this.mcEntity.hasIgnited();
		}

		@PythonFunction
		public void setIgnited(boolean ignited) {
			this.setTag("ignited", ignited);
		}
	}

	@PythonClass
	public class EnderDragon extends Living<EntityDragon> {

		private static final long serialVersionUID = -5955391820741486510L;

		@PythonField
		public static final int PHASE_CIRCLING = 0;
		@PythonField
		public static final int PHASE_STRAFING_PLAYER = 1;
		@PythonField
		public static final int PHASE_LANDING_APPROACH = 2;
		@PythonField
		public static final int PHASE_LANDING = 3;
		@PythonField
		public static final int PHASE_TAKEOFF = 4;
		@PythonField
		public static final int PHASE_SITTING_FLAMING = 5;
		@PythonField
		public static final int PHASE_SITTING_SCANNING = 6;
		@PythonField
		public static final int PHASE_SITTING = 7;
		@PythonField
		public static final int PHASE_CHARGING_PLAYER = 8;
		@PythonField
		public static final int PHASE_DYING = 9;
		@PythonField
		public static final int PHASE_HOVER = 10;

		public EnderDragon(EntityDragon entity) {
			super(entity);
		}

		@PythonFunction
		public int getPhase() {
			return this.mcEntity.getPhaseManager().getCurrentPhase().getType().getId();
		}

		@PythonFunction
		public void setPhase(int phase) {
			this.mcEntity.getPhaseManager().setPhase(PhaseList.getById(phase));
		}

	}

	@PythonClass
	public class Enderman extends Living<EntityEnderman> {

		private static final long serialVersionUID = 1688539848618858505L;

		public Enderman(EntityEnderman entity) {
			super(entity);
		}

		@PythonFunction
		@PythonDocString("Returns an item stack tuple of what it's carrying, or None if it isn't carrying anything.")
		@Nullable
		public PyTuple getCarried() {
			IBlockState state = this.mcEntity.getHeldBlockState();
			if (state != null) {
				Block block = state.getBlock();
				return itemUtils.tupleFromItemStack(new ItemStack(block, 1, block.getMetaFromState(state)));
			} else {
				return null;
			}
		}

		@PythonFunction
		@PythonDocString("Sets the Enderman's carried block, taking an item stack tuple, or None if it shouldn't carry anything.")
		@Nullable
		public void setCarried(PyTuple tuple) {
			if (tuple == null) {
				this.mcEntity.setHeldBlockState(null);
			} else {
				ItemStack stack = itemUtils.itemStackFromTuple(tuple);
				if (stack.getItem() instanceof ItemBlock) {
					ItemBlock ib = (ItemBlock) stack.getItem();
					this.mcEntity.setHeldBlockState(ib.getBlock().getStateFromMeta(stack.getMetadata()));
				} else {
					throw Py.ValueError("Enderman can not carry items, only blocks");
				}
			}
		}
	}

	@PythonClass
	public class Endermite extends Living<EntityEndermite> {

		private static final long serialVersionUID = 8466553682345667521L;

		public Endermite(EntityEndermite entity) {
			super(entity);
		}

		@PythonFunction
		public boolean isPlayerSpawned() {
			return this.mcEntity.isSpawnedByPlayer();
		}

		@PythonFunction
		public void setPlayerSpawned(boolean spawnedByPlayer) {
			this.mcEntity.setSpawnedByPlayer(spawnedByPlayer);
		}

		// lifetime is private.
	}

	@PythonClass
	public class Ghast extends Living<EntityGhast> {

		private static final long serialVersionUID = 2108228874635569063L;

		public Ghast(EntityGhast entity) {
			super(entity);
		}

		@PythonFunction
		public int getExplosionRadius() {
			return this.mcEntity.getFireballStrength();
		}

		@PythonFunction
		public void setExplosionRadius(int power) {
			this.setTag("ExplosionPower", power);
		}
	}

	@PythonClass
	public class ItemEntity extends Base<EntityItem> {

		private static final long serialVersionUID = -6818003122558490506L;

		public ItemEntity(EntityItem entity) {
			super(entity);
		}

		@PythonFunction
		@PythonDocString("Sets the Item's age.  Once it's age reaches 6000 the item is destroyed.")
		public int getAge() {
			return this.mcEntity.getAge();
		}

		@PythonFunction
		@PythonDocString("Returns a tuple representing the stack as (itemName, count, meta).")
		public PyTuple getStack() {
			return itemUtils.tupleFromItemStack(this.mcEntity.getItem());
		}

		@PythonFunction
		public void setStack(PyTuple stack) {
			this.mcEntity.setItem(itemUtils.itemStackFromTuple(stack));
		}

		@PythonFunction
		@PythonDocString("Sets the item's PickupDelay to 32767 to stop it from being able to be picked up.")
		public void setInfinitePickupDelay() {
			this.mcEntity.setInfinitePickupDelay();
		}

		@PythonFunction
		@PythonDocString("Sets the item's age to -6000 to stop it from despawning.")
		public void setNoDespawn() {
			this.setNoDespawn();
		}
	}

	/**
	 * Equivalent to {@link net.minecraft.entity.passive.AbstractHorse}.
	 */
	@PythonClass
	public class GenericHorse<T extends AbstractHorse> extends Animal<T> {

		private static final long serialVersionUID = 1473603312420702937L;

		public GenericHorse(T entity) {
			super(entity);
		}

		@PythonFunction
		public boolean isBreeding() {
			return this.mcEntity.isBreeding();
		}

		@PythonFunction
		public void setBreeding(boolean breeding) {
			this.mcEntity.setBreeding(breeding);
		}

		@PythonFunction
		public boolean isEatingHaystack() {
			return this.mcEntity.isEatingHaystack();
		}

		@PythonFunction
		public void setEatingHaystack(boolean eating) {
			this.mcEntity.setEatingHaystack(eating);
		}

		@PythonFunction
		public boolean isTame() {
			return this.mcEntity.isTame();
		}

		@PythonFunction
		public void setTamed(boolean tamed) {
			this.mcEntity.setHorseTamed(tamed);
		}

		@PythonFunction
		public int getTemper() {
			return this.mcEntity.getTemper();
		}

		@PythonFunction
		public void setTemper(int temper) {
			this.mcEntity.setTemper(temper);
		}

		@PythonFunction
		public boolean isSaddled() {
			return this.mcEntity.isHorseSaddled();
		}

		@PythonFunction
		public void setSaddled(boolean saddled) {
			this.mcEntity.setHorseSaddled(saddled);
		}

		// TODO Armor.
	}

	@PythonClass
	public class Hanging<T extends EntityHanging> extends Base<T> {

		private static final long serialVersionUID = -8908455875060292148L;

		public Hanging(T entity) {
			super(entity);
		}

		@PythonFunction
		public int getFacing() {
			return this.mcEntity.facingDirection.getHorizontalIndex();
		}

		@PythonFunction
		public void setFacing(int facing) {
			this.setTag("Facing", EnumFacing.getHorizontal(facing));
		}
		
		@PythonFunction
		public PyTuple getTilePos() {
			BlockPos p = this.mcEntity.getHangingPosition();
			return new PyTuple(new PyInteger(p.getX()), new PyInteger(p.getY()), new PyInteger(p.getZ()));
		}

		@PythonFunction
		public void setTilePos(int x, int y, int z) {
			this.mcEntity.setPosition(x, y, z);
		}
	}
	
	@PythonClass
	public class Horse extends GenericHorse<EntityHorse> {

		private static final long serialVersionUID = 7147534040184529530L;

		@PythonField
		public static final int COLOR_WHITE = 0;
		@PythonField
		public static final int COLOR_CREAMY = 1;
		@PythonField
		public static final int COLOR_CHESTNUT = 2;
		@PythonField
		public static final int COLOR_BROWN = 3;
		@PythonField
		public static final int COLOR_BLACK = 4;
		@PythonField
		public static final int COLOR_GRAY = 5;
		@PythonField
		public static final int COLOR_DARK_BROWN = 6;

		@PythonField
		public static final int MARKING_NONE = 0;
		@PythonField
		public static final int MARKING_WHITE = 1;
		@PythonField
		public static final int MARKING_WHITE_FIELD = 2;
		@PythonField
		public static final int MARKING_WHITE_DOTS = 3;
		@PythonField
		public static final int MARKING_BLACK_DOTS = 4;

		public Horse(EntityHorse entity) {
			super(entity);
		}

		@PythonFunction
		public int getVariant() {
			return this.mcEntity.getHorseVariant();
		}

		@PythonFunction
		@PythonDocString("Use computeVariantFlag to get a variant to pass in.")
		public void setVariant(int variant) {
			this.mcEntity.setHorseVariant(variant);
		}

		@PythonFunction
		@PythonDocString("Returns a variant from a color and markings.  Algorithm (color | markings << 8)")
		public int computeVariantFlag(int color, int markings) {
			int variant = color | markings << 8;
			return variant;
		}
	}

	@PythonClass
	public class ChestHorse extends GenericHorse<AbstractChestHorse> {

		private static final long serialVersionUID = 2212092842255803485L;

		public ChestHorse(AbstractChestHorse entity) {
			super(entity);
		}

		@PythonFunction
		public boolean isChestedHorse() {
			return this.mcEntity.hasChest();
		}

		@PythonFunction
		public void setChestedHorse(boolean chested) {
			this.mcEntity.setChested(chested);
		}
	}

	@PythonClass
	public class SkeletonHorse extends GenericHorse<EntitySkeletonHorse> {

		private static final long serialVersionUID = 1221084166010555928L;

		public SkeletonHorse(EntitySkeletonHorse entity) {
			super(entity);
		}

		@PythonFunction
		public boolean isSkeletonTrap() {
			return this.mcEntity.isTrap();
		}

		@PythonFunction
		public void setSkeletonTrap(boolean isTrapped) {
			this.mcEntity.setTrap(isTrapped);
		}
	}

	@PythonClass
	public class Ocelot extends Tameable<EntityOcelot> {

		private static final long serialVersionUID = -3752886054446835931L;

		@PythonField
		public static final int TYPE_WILD = 0;
		@PythonField
		public static final int TYPE_TUXEDO = 01;
		@PythonField
		public static final int TYPE_TABBY = 2;
		@PythonField
		public static final int TYPE_SIAMESE = 3;

		public Ocelot(EntityOcelot entity) {
			super(entity);
		}

		@PythonFunction
		public int getCatType() {
			return this.mcEntity.getTameSkin();
		}

		@PythonFunction
		public void setCatType(int catType) {
			this.mcEntity.setTameSkin(catType);
		}
	}

	@PythonClass
	public class Painting extends Hanging<EntityPainting> {
		
		private static final long serialVersionUID = 7791696705579553157L;
		
		@PythonField
		public static final String KEBAB = "Kebab";
		@PythonField
		public static final String AZTEC = "Aztec";
		@PythonField
		public static final String ALBAN = "Alban";
		@PythonField
		public static final String AZTEC_2 = "Aztec2";
		@PythonField
		public static final String BOMB = "Bomb";
		@PythonField
		public static final String PLANT = "Plant";
		@PythonField
		public static final String WASTELAND = "Wasteland";
		@PythonField
		public static final String POOL = "Pool";
		@PythonField
		public static final String COURBET = "Courbet";
		@PythonField
		public static final String SEA = "Sea";
		@PythonField
		public static final String SUNSET = "Sunset";
		@PythonField
		public static final String CREEBET = "Creebet";
		@PythonField
		public static final String WANDERER = "Wanderer";
		@PythonField
		public static final String GRAHAM = "Graham";
		@PythonField
		public static final String MATCH = "Match";
		@PythonField
		public static final String BUST = "Bust";
		@PythonField
		public static final String STAGE = "Stage";
		@PythonField
		public static final String VOID = "Void";
		@PythonField
		public static final String SKULL_AND_ROSES = "SkullAndRoses";
		@PythonField
		public static final String WITHER = "Wither";
		@PythonField
		public static final String FIGHTERS = "Fighters";
		@PythonField
		public static final String POINTER = "Pointer";
		@PythonField
		public static final String PIGSCENE = "Pigscene";
		@PythonField
		public static final String BURNING_SKULL = "BurningSkull";
		@PythonField
		public static final String SKELETON = "Skeleton";
		@PythonField
		public static final String DONKEY_KONG = "DonkeyKong";

		public Painting(EntityPainting entity) {
			super(entity);
		}

		@PythonFunction
		@PythonDocString("Returns the name of the art as a string.")
		public String getArtName() {
			return this.mcEntity.art.title;
		}

		@PythonFunction
		public void setArt(String artName) {
			for (EntityPainting.EnumArt art : EntityPainting.EnumArt.values()) {
				if (art.title.equals(artName)) {
					this.mcEntity.art = art;
				}
			}
			if (this.mcEntity.art == null) {
				this.mcEntity.art = EntityPainting.EnumArt.KEBAB;
			}
		}
	}

	@PythonClass
	public class Parrot extends Tameable<EntityParrot> {

		private static final long serialVersionUID = -8273033504720739347L;

		@PythonField
		public static final int COLOR_RED = 0;
		@PythonField
		public static final int COLOR_BLUE = 1;
		@PythonField
		public static final int COLOR_GREEN = 2;
		@PythonField
		public static final int COLOR_CYAN = 3;
		@PythonField
		public static final int COLOR_SILVEr = 4;

		public Parrot(EntityParrot entity) {
			super(entity);
		}

		@PythonFunction
		public int getVariant() {
			return this.mcEntity.getVariant();
		}

		@PythonFunction
		public void setVariant(int variant) {
			this.mcEntity.setVariant(variant);
		}
	}

	@PythonClass
	public class Pig extends Animal<EntityPig> {

		private static final long serialVersionUID = 8368727781457142488L;

		public Pig(EntityPig entity) {
			super(entity);
		}

		@PythonFunction
		public boolean getSaddled() {
			return this.mcEntity.getSaddled();
		}

		@PythonFunction
		public void setSaddled(boolean saddled) {
			this.mcEntity.setSaddled(saddled);
		}
	}

	@PythonClass
	public class Player extends LivingBase<EntityPlayerMP> implements IHasEquipment {

		private static final long serialVersionUID = -8557759903366434251L;

		public Player(EntityPlayerMP entity) {
			super(entity);
		}

		@PythonFunction
		@PythonDocString("Returns the index (0-8 inclusive) of the selected hotbar slot.")
		public int getHeldIndex() {
			return this.mcEntity.inventory.currentItem;
		}

		@PythonFunction
		@PythonDocString("Returns the held item of the player, or None if they're not holding anything.  Same as getSlotContents with a slotIndex of 0")
		public PyTuple getHeldStack() {
			return itemUtils.tupleFromItemStack(this.mcEntity.inventory.getCurrentItem());
		}

		@PythonFunction
		@PythonDocString("Returns a piece or armor, held item or offhand item.")
		@Override
		public PyTuple getSlotContents(int slotIndex) {
			this.func_05(slotIndex, 6);
			return itemUtils
					.tupleFromItemStack(this.mcEntity.getItemStackFromSlot(equipmentSlot.indexToEnum(slotIndex)));
		}

		@PythonFunction
		@PythonDocString("Sets a piece or armor, held item or offhand item.")
		@Override
		public void setSlotContents(int slotIndex, PyTuple itemStack) {
			this.func_05(slotIndex, 6);
			this.mcEntity.setItemStackToSlot(equipmentSlot.indexToEnum(slotIndex),
					itemUtils.itemStackFromTuple(itemStack));
			this.mcEntity.inventoryContainer.detectAndSendChanges();
		}

		@PythonFunction
		@PythonDocString("Returns an item stack in the player's main inventory.  slotIndex is 0-35 inclusive.")
		public PyTuple getInventoryStack(int slotIndex) {
			this.func_05(slotIndex, 36);
			return itemUtils.tupleFromItemStack(this.mcEntity.inventory.mainInventory.get(slotIndex));
		}

		@PythonFunction
		@PythonDocString("Sets an item stack in the player's main inventory.  slotIndex is 0-35 inclusive.")
		public void setInventoryStack(int slotIndex, PyTuple itemStack) {
			this.func_05(slotIndex, 36);
			this.mcEntity.inventory.mainInventory.set(slotIndex, itemUtils.itemStackFromTuple(itemStack));
			this.mcEntity.inventoryContainer.detectAndSendChanges();
		}

		@PythonFunction
		@PythonDocString("Adds an item stack to the player's main inventory.  Returns the leftover items that couldn't be added, or None if all the items were added.")
		public PyTuple addItemStack(PyTuple itemStack) {
			this.mcEntity.inventory.addItemStackToInventory(itemUtils.itemStackFromTuple(itemStack));
			return itemStack;
		}

		@PythonFunction
		@PythonDocString("Returns true if the passed itemStack is in the player's main inventory.")
		public boolean hasItemStack(PyTuple itemStack) {
			return this.mcEntity.inventory.hasItemStack(itemUtils.itemStackFromTuple(itemStack));
		}

		@PythonFunction
		public int getFood() {
			return this.mcEntity.getFoodStats().getFoodLevel();
		}

		@PythonFunction
		public void setFood(int foodLevel) {
			this.mcEntity.getFoodStats().setFoodLevel(foodLevel);
		}

		@PythonFunction
		public int getGameMode() {
			this.mcEntity.interactionManager.getGameType().getID();
			return 0;
		}

		@PythonFunction
		public void setGameMode(int gamemode) {
			if (gamemode < 0 || gamemode > 3) {
				throw Py.ValueError("game mode must be between 0 and 3");
			}
			this.mcEntity.setGameType(GameType.getByID(gamemode));
		}
	}

	@PythonClass
	public class Rabbit extends Animal<EntityRabbit> {

		private static final long serialVersionUID = 7640215810890520120L;

		@PythonField
		public static final int TYPE_BROWN = 0;
		@PythonField
		public static final int TYPE_WHITE = 1;
		@PythonField
		public static final int TYPE_BLACK = 2;
		@PythonField
		public static final int TYPE_BLACK_WHITE = 3;
		@PythonField
		public static final int TYPE_GOLD = 4;
		@PythonField
		public static final int TYPE_SALT_PEPPER = 5;
		@PythonField
		public static final int TYPE_KILLER = 99;

		public Rabbit(EntityRabbit entity) {
			super(entity);
		}

		@PythonFunction
		public int getRabbitType() {
			return this.mcEntity.getRabbitType();
		}

		@PythonFunction
		public void setRabbitType(int rabbitType) {
			this.mcEntity.setRabbitType(rabbitType);
		}
	}

	@PythonClass
	public class Sheep extends Animal<EntitySheep> {

		private static final long serialVersionUID = 3270857116516304734L;

		public Sheep(EntitySheep entity) {
			super(entity);
		}

		@PythonFunction
		public int getColor() {
			return this.mcEntity.getFleeceColor().getMetadata();
		}

		@PythonFunction
		public void setColor(int color) {
			this.mcEntity.setFleeceColor(EnumDyeColor.byDyeDamage(color));
		}

		@PythonFunction
		public boolean isSheared() {
			return this.mcEntity.getSheared();
		}

		@PythonFunction
		public void setSheared(boolean isSheared) {
			this.mcEntity.setSheared(isSheared);
		}
	}

	@PythonClass
	public class Shulker extends Living<EntityShulker> {

		private static final long serialVersionUID = -3505352210734560534L;

		public Shulker(EntityShulker entity) {
			super(entity);
		}

		@PythonFunction
		public int getColor() {
			return this.mcEntity.getColor().getMetadata();
		}

		@PythonFunction
		public void setColor(int color) {
			this.setTag("Color", color);
		}
	}

	@PythonClass
	public class Slime extends Living<EntitySlime> {

		private static final long serialVersionUID = 8553917442304661280L;

		public Slime(EntitySlime entity) {
			super(entity);
		}

		@PythonFunction
		@PythonDocString("Sets the slime's size. 0, 1 and 3 are the default sizes.")
		public int getSize() {
			return this.mcEntity.getSlimeSize();
		}

		@PythonFunction
		public void setSize(int size) {
			this.setTag("Size", size);
		}
	}

	@PythonClass
	public class Snowman extends Living<EntitySnowman> {

		private static final long serialVersionUID = -6550695206594909228L;

		public Snowman(EntitySnowman entity) {
			super(entity);
		}

		@PythonFunction
		public boolean getPumpkin() {
			return this.mcEntity.isPumpkinEquipped();
		}

		@PythonFunction
		public void setPumpkin(boolean pumpkinEquipped) {
			this.mcEntity.setPumpkinEquipped(pumpkinEquipped);
		}
	}

	@PythonClass
	public class Tameable<T extends EntityTameable> extends Animal<T> {

		private static final long serialVersionUID = -5756209361574406506L;

		public Tameable(T entity) {
			super(entity);
		}

		@PythonFunction
		public boolean isSitting() {
			return this.mcEntity.isSitting();
		}

		@PythonFunction
		public void setSitting(boolean isSitting) {
			this.mcEntity.setSitting(isSitting);
		}

		@PythonFunction
		@PythonDocString("Sets the Player who owns this Entity.  Must be an instance of entity.Player or net.minecraft.entity.player.EntityPlayer")
		public void setOwner(@PythonExcludeType Object owner) {
			if (owner instanceof EntityPlayer) {
				this.mcEntity.setTamedBy((EntityPlayer) owner);
			} else if (owner instanceof Player) {
				this.mcEntity.setTamedBy(((Player) owner).mcEntity);
			} else {
				throw Py.ValueError(
						"owner must be an instance of entity.Player or net.minecraft.entity.player.EntityPlayer");
			}
		}
	}
	
	@PythonClass
	public class Tnt extends Base<EntityTNTPrimed> {

		private static final long serialVersionUID = 1L;

		public Tnt(EntityTNTPrimed entity) {
			super(entity);
		}

		@PythonFunction
		public int getFuse() {
			return this.mcEntity.getFuse();
		}

		@PythonFunction
		public void setFuse(int fuse) {
			this.mcEntity.setFuse(fuse);
		}
	}

	@PythonClass
	public class Villager extends Living<EntityVillager> {

		private static final long serialVersionUID = 6785232030225149328L;

		private Field field;

		@PythonField
		public static final int PROFESSION_FARMER = 0;
		@PythonField
		public static final int PROFESSION_LIBRARIAN = 1;
		@PythonField
		public static final int PROFESSION_PRIEST = 2;
		@PythonField
		public static final int PROFESSION_BLACKSMITH = 3;
		@PythonField
		public static final int PROFESSION_BUTCHER = 4;
		@PythonField
		public static final int PROFESSION_NITWIT = 5;

		@PythonField
		public static final int CAREER_FARMER = 1;
		@PythonField
		public static final int CAREER_FISHERMAN = 2;
		@PythonField
		public static final int CAREER_SHEPHERD = 3;
		@PythonField
		public static final int CAREER_FLETCHER = 4;
		@PythonField
		public static final int CAREER_LIBRARIAN = 1;
		@PythonField
		public static final int CAREER_CARTOGRAPHER = 2;
		@PythonField
		public static final int CAREER_CLERIC = 1;
		@PythonField
		public static final int CAREER_ARMORER = 1;
		@PythonField
		public static final int CAREER_WEAPON_SMITH = 2;
		@PythonField
		public static final int CAREER_TOOL_SMITH = 3;
		@PythonField
		public static final int CAREER_BUTCHER = 1;
		@PythonField
		public static final int CAREER_LEATHERWORKER = 2;
		@PythonField
		public static final int CAREER_NITWIT = 1;

		public Villager(EntityVillager entity) {
			super(entity);
		}

		@PythonFunction
		public int getProfession() {
			return this.mcEntity.getProfession();
		}

		@PythonFunction
		public void setProfession(int profession) {
			this.mcEntity.setProfession(profession);
		}

		@PythonFunction
		public int getCareer() {
			return (int) this.getTag("Career");
		}

		@PythonFunction
		public void setCareer(int career) {
			this.setTag("Career", career);
			this.addNewTrade(null, null);
		}

		@PythonFunction
		@PythonDocString("Adds a new trade to the Villager.  Item stacks are represented as tuples like (item_id, [optional]amount, [optional]meta)."
				+ "\n  First Arg: A Tuple of Item Stacks that the villager buys, up to 2 long."
				+ "\n  Second Arg: The ItemStack that the villager buys."
				+ "\n  Third Arg: (Optional) The number of times the trade can be used.  If not specified or it's -1, a random number between 2 and 12 is used."
				+ "\n  Fourth Arg: (Optional) The numbers of times this trade has been used.")
		public void addNewTrade(PyTuple buyTuple, PyTuple sellTuple, Object... args) {
			if (this.field == null) {
				this.field = ReflectionHelper.findField(EntityVillager.class,
						new String[] { "buyingList", "field_70963_i" });
			}
			MerchantRecipeList rl = null;
			try {
				rl = (MerchantRecipeList) this.field.get(this.mcEntity);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}

			if (rl == null) {
				rl = new MerchantRecipeList();
			}

			// Add recipe:

			// Default values.
			ItemStack buy1;
			ItemStack buy2 = ItemStack.EMPTY;
			ItemStack sell;
			int timesTradeUsed = 0;
			int maxTrades;
			// TODO give XP

			// Parse args:
			buy1 = itemUtils.itemStackFromTuple((PyTuple) buyTuple.get(0));
			if (buyTuple.size() > 1) {
				buy2 = itemUtils.itemStackFromTuple((PyTuple) buyTuple.get(1));
			}
			if (buyTuple.size() > 2) {
				throw Py.ValueError("Buy list may not contain more than 2 items!");
			}

			sell = itemUtils.itemStackFromTuple(sellTuple);
			if (args.length > 0 && (int) args[0] != -1) {
				maxTrades = (int) args[0];
			} else {
				// Default Minecraft random value.
				maxTrades = this.mcEntity.getRNG().nextInt(11) + 2;
			}
			if (args.length > 1) {
				timesTradeUsed = (int) args[1];
			}

			// Add trade to list.
			rl.add(new MerchantRecipe(buy1, buy2, sell, /* NBT "uses" */ timesTradeUsed, maxTrades));

			// Set the field within the villager.
			try {
				this.field.set(this.mcEntity, rl);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	@PythonClass
	public class Wolf extends Tameable<EntityWolf> {

		private static final long serialVersionUID = -5259915680673182799L;

		public Wolf(EntityWolf entity) {
			super(entity);
		}

		@PythonFunction
		@PythonDocString("Uses dye meta, default is 1 for red.")
		public int getCollarColor() {
			return this.mcEntity.getCollarColor().getDyeDamage();
		}

		@PythonFunction
		@PythonDocString("Uses dye meta, default is 1 for red.")
		public void setCollarColor(int dyeColor) {
			this.mcEntity.setCollarColor(EnumDyeColor.byDyeDamage(dyeColor));
		}

		@PythonFunction
		public boolean isAngry() {
			return this.mcEntity.isAngry();
		}

		@PythonFunction
		public void setAngry(boolean isAngry) {
			this.mcEntity.setAngry(isAngry);
		}
	}

	@PythonClass
	public class Zombie<T extends EntityZombie> extends Living<T> {

		private static final long serialVersionUID = 361288394972301593L;

		public Zombie(T entity) {
			super(entity);
		}

		@PythonFunction
		public boolean isBaby() {
			return this.mcEntity.isChild();
		}

		@PythonFunction
		public void setIsBaby(boolean isBaby) {
			this.mcEntity.setChild(isBaby);
		}

		@PythonFunction
		public boolean getCanBreakDoors() {
			return this.mcEntity.isBreakDoorsTaskSet();
		}

		@PythonFunction
		public void setCanBreakDoors(boolean canBreakDoors) {
			this.mcEntity.setBreakDoorsAItask(canBreakDoors);
		}
	}

	@PythonClass
	public class ZombieVillager extends Zombie<EntityZombieVillager> {

		private static final long serialVersionUID = 4714016270839795244L;

		public ZombieVillager(EntityZombieVillager entity) {
			super(entity);
		}

		@PythonFunction
		public String getProfession() {
			return this.mcEntity.getForgeProfession().getRegistryName().toString();
		}

		@PythonFunction
		@PythonDocString("See entity.Villager for profession ids.")
		public void setProfession(int profession) {
			this.mcEntity.setProfession(profession);
		}
	}

	// Internal beyond here.

	private interface IHasEquipment {

		@PythonFunction
		public PyTuple getSlotContents(int slotIndex);

		@PythonFunction
		public void setSlotContents(int slotIndex, PyTuple itemStack);
	}
}