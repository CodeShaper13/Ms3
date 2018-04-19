package com.codeshaper.ms3.api;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.python.core.Py;
import org.python.core.PyInteger;
import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonTypeExclude;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.util.NbtHelper;
import com.mojang.authlib.GameProfile;

import net.minecraft.block.state.IBlockState;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.CommandBlockBaseLogic;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
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
import net.minecraft.util.WeightedSpawnerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.LockCode;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class tileEntity {

	public static final tileEntity instance = new tileEntity();

	@PythonClass
	public class TileEntityBase<T extends TileEntity> extends PyObject {

		private static final long serialVersionUID = -4299819910380054469L;

		public T mcTileEntity;

		public TileEntityBase(T tileEntity) {
			this.mcTileEntity = tileEntity;
		}

		@PythonFunction
		@PythonDocString("Returns the TileEntity's position on the X axis as an int.")
		public int getX() {
			return this.mcTileEntity.getPos().getX();
		}

		@PythonFunction
		@PythonDocString("Returns the TileEntity's position on the Y axis as an int.")
		public int getY() {
			return this.mcTileEntity.getPos().getY();
		}

		@PythonFunction
		@PythonDocString("Returns the TileEntity's position on the Z axis as an int.")
		public int getZ() {
			return this.mcTileEntity.getPos().getZ();
		}

		@PythonFunction
		@PythonDocString("Returns the value of an nbt tag.  If the tag can't be found, None is returned.")
		@Nullable
		public Object getTag(String tagKey) {
			NBTTagCompound nbttagcompound = this.mcTileEntity.writeToNBT(new NBTTagCompound());
			NBTBase tag = nbttagcompound.getTag(tagKey);
			return NbtHelper.nbtToObject(tag);
		}

		@PythonFunction
		@PythonDocString("Sets an NBT tag for the entity.  For byte tags that represtend boolean values 1/0, \"true\"/\"false\" or True/False will work.  For nested tags type them like you would for the /entitydata command, but without the beginning and ending curly braces {}")
		public void setTag(String tagKey, Object value) {
			NBTTagCompound nbttagcompound = this.mcTileEntity.writeToNBT(new NBTTagCompound());
			NBTTagCompound nbttagcompound1 = nbttagcompound.copy();
			NBTTagCompound nbttagcompound2;

			try {
				nbttagcompound2 = JsonToNBT.getTagFromJson("{" + tagKey + ":" + value.toString() + "}");
			} catch (NBTException nbtexception) {
				throw Py.ValueError("Nbt was not in valid JSON format!");
			}

			nbttagcompound.merge(nbttagcompound2);
			nbttagcompound.setInteger("x", this.getX());
			nbttagcompound.setInteger("y", this.getY());
			nbttagcompound.setInteger("z", this.getZ());

			if (nbttagcompound.equals(nbttagcompound1)) {
				throw Py.ValueError("commands.blockdata.failed");
			} else {
				this.mcTileEntity.readFromNBT(nbttagcompound);
				this.mcTileEntity.markDirty();
				World w = this.mcTileEntity.getWorld();
				IBlockState iblockstate = w.getBlockState(this.mcTileEntity.getPos());
				w.notifyBlockUpdate(this.mcTileEntity.getPos(), iblockstate, iblockstate, 3);
			}
		}

		protected void dirtyAndUpdate() {
			this.mcTileEntity.markDirty();
			IBlockState state = this.mcTileEntity.getWorld().getBlockState(this.mcTileEntity.getPos());
			this.mcTileEntity.getWorld().notifyBlockUpdate(this.mcTileEntity.getPos(), state, state, 3);
		}
	}

	@PythonClass
	public class Lockable<T extends TileEntityLockable & IInventory> extends TileEntityBase<T> {

		private static final long serialVersionUID = 7494001262819308455L;

		public Lockable(T tileEntity) {
			super(tileEntity);
		}

		@PythonFunction
		@PythonDocString("Returns an empty string if there is no lock code.")
		public PyString getLockCode() {
			return new PyString(this.mcTileEntity.getLockCode().getLock());
		}

		@PythonFunction
		@PythonDocString("Pass an empty string to remove the lock.")
		public void setLockCode(String lock) {
			if (lock == null) {
				throw Py.ValueError("lock may not be None!");
			}
			this.mcTileEntity.setLockCode(new LockCode(lock));
		}

		@PythonFunction
		@PythonDocString("Returns the contents of a slot as an itemStack.")
		public itemStack getItem(int slot) {
			int i = this.getContainerSize();
			if (slot < 0 || slot > (i - 1)) {
				throw Py.ValueError("Index must be between 0 and " + (i - 1));
			}
			return new itemStack(this.mcTileEntity.getStackInSlot(slot));
		}

		@PythonFunction
		@PythonDocString("Sets the contents of a slot to the value of the passed itemStack.")
		public void setItem(int slot, itemStack itemStack) {
			int i = this.getContainerSize();
			if (slot < 0 || slot > (i - 1)) {
				throw Py.ValueError("Index must be between 0 and " + (i - 1));
			}
			this.mcTileEntity.setInventorySlotContents(slot, itemStack.getMcStack());
		}

		@PythonFunction
		@PythonDocString("Returns the number of slots in the container.")
		public final int getContainerSize() {
			return this.mcTileEntity.getSizeInventory();
		}
	}

	@PythonClass
	public class LockableLoot<T extends TileEntityLockableLoot> extends Lockable<T> {

		private static final long serialVersionUID = 5861176632306201482L;

		public LockableLoot(T tileEntity) {
			super(tileEntity);
		}

		@PythonFunction
		@PythonDocString("Returns the Container's name, or it's unlocalized name if it has no custom none.")
		public PyString getCustomName() {
			return new PyString(this.mcTileEntity.getName());
		}

		@PythonFunction
		@PythonDocString("Set's the Container's name.  Pass None to set it back to it's default name.")
		public void setCustomName(String name) {
			this.mcTileEntity.setCustomName(name);
		}
	}

	@PythonClass
	public class Beacon extends Lockable<TileEntityBeacon> {

		private static final long serialVersionUID = -6547554580596062244L;

		public Beacon(TileEntityBeacon tileEntity) {
			super(tileEntity);
		}

		@PythonFunction
		@PythonDocString("Returns the effect id.  See effectList.py for effect ID's.")
		public int getEffect(boolean isPrimary) {
			return this.mcTileEntity.getField(isPrimary ? 1 : 2);
		}

		@PythonFunction
		@PythonDocString("Sets the beacon's effect.  See effectList.py for effect ID's.")
		public void setEffect(boolean isPrimary, int effectId) {
			this.mcTileEntity.setField(isPrimary ? 1 : 2, effectId);
		}
	}

	@PythonClass
	public class Bed extends TileEntityBase<TileEntityBed> {

		private static final long serialVersionUID = -2362034535699233202L;

		public Bed(TileEntityBed tileEntity) {
			super(tileEntity);
		}

		@PythonFunction
		@PythonDocString("Returns the bed's color ID.  See colors.py for color ID's.")
		public int getColor() {
			return this.mcTileEntity.getColor().getMetadata();
		}

		@PythonFunction
		@PythonDocString("Sets the bed's color ID.  See colors.py for color ID's.")
		public void setColor(int color) {
			this.mcTileEntity.setColor(EnumDyeColor.byMetadata(color));
		}
	}

	@PythonClass
	public class BrewingStand extends Lockable<TileEntityBrewingStand> {

		private static final long serialVersionUID = -4501498464782181069L;

		@PythonField
		@PythonDocString("Numeric constant with the left slot ID.")
		public static final int ID_LEFT = 0;
		@PythonField
		@PythonDocString("Numeric constant with the middle slot ID.")
		public static final int ID_MIDDLE = 1;
		@PythonField
		@PythonDocString("Numeric constant with the right slot ID.")
		public static final int ID_RIGHT = 2;
		@PythonField
		@PythonDocString("Numeric constant with the ingredient slot ID.")
		public static final int ID_INGREDIENT = 3;
		@PythonField
		@PythonDocString("Numeric constant with the fuel slot ID.")
		public static final int ID_FUEL = 4;

		public BrewingStand(TileEntityBrewingStand tileEntity) {
			super(tileEntity);
		}

		@PythonFunction
		@PythonDocString("Returns the time left in game ticks until the potion is finished.")
		public int getBrewTime() {
			return this.mcTileEntity.getField(0);
		}

		@PythonFunction
		@PythonDocString("Sets the time left in game ticks until the potion is finished.")
		public void setBrewTime(int brewTime) {
			this.mcTileEntity.setField(0, brewTime);
		}

		@PythonFunction
		@PythonDocString("Returns how much fuel is left in the Brewing Stand.")
		public int getFuel() {
			return this.mcTileEntity.getField(1);
		}

		@PythonFunction
		@PythonDocString("Sets the fuel amount in the Brewing Stand.")
		public void setFuel(int fuel) {
			this.mcTileEntity.setField(1, fuel);
		}
	}

	@PythonClass
	public class CommandBlock extends TileEntityBase<TileEntityCommandBlock> {

		private static final long serialVersionUID = 1666817160387319102L;

		private final String[] FIELD_NAMES = new String[] { "commandBlockLogic", "field_145824_a" };

		public CommandBlock(TileEntityCommandBlock tileEntity) {
			super(tileEntity);
		}

		@PythonFunction
		@PythonDocString("Sets the command within the Command Block.")
		public void setCommand(String command) {
			CommandBlockBaseLogic cbbl = (CommandBlockBaseLogic) ReflectionHelper
					.getPrivateValue(TileEntityCommandBlock.class, this.mcTileEntity, FIELD_NAMES);
			cbbl.setCommand(command);
		}
	}

	@PythonClass
	public class FlowerPot extends TileEntityBase<TileEntityFlowerPot> {

		private static final long serialVersionUID = 5646847644719526649L;

		public FlowerPot(TileEntityFlowerPot tileEntity) {
			super(tileEntity);
		}

		@PythonFunction
		@PythonDocString("Returns the Pot's contents as an itemStack, or None if it is empty.")
		@Nullable
		public itemStack getPotContents() {
			Item item = this.mcTileEntity.getFlowerPotItem();
			if (item == null) {
				return null;
			} else {
				return new itemStack(item, this.mcTileEntity.getFlowerPotData());
			}
		}

		@PythonFunction
		@PythonDocString("Sets the Pot's contents as the passed itemStack.  Note, not all items will be visible, only \"plant\" items.")
		// TODO not updated on client?
		public void setPotContents(itemStack stack) {
			this.mcTileEntity.setItemStack(stack.getMcStack());
			this.dirtyAndUpdate();
		}
	}

	@PythonClass
	public class Furnace extends Lockable<TileEntityFurnace> {

		private static final long serialVersionUID = 7367812229820446548L;

		@PythonField
		@PythonDocString("Numeric constant with the ingredient slot ID.")
		public static final int ID_SMELT = 0;
		@PythonField
		@PythonDocString("Numeric constant with the fuel slot ID.")
		public static final int ID_FUEL = 1;
		@PythonField
		@PythonDocString("Numeric constant with the result slot ID.")
		public static final int ID_RESULT = 2;

		public Furnace(TileEntityFurnace tileEntity) {
			super(tileEntity);
		}

		@PythonFunction
		@PythonDocString("Return the number of ticks until the fuel runs out.")
		public int getBurnTime() {
			return this.mcTileEntity.getField(0);
		}

		@PythonFunction
		@PythonDocString("Sets how many ticks are left until the fuel runs out.")
		public void setBurnTime(int burnTime) {
			this.mcTileEntity.setField(0, burnTime);
		}

		@PythonFunction
		@PythonDocString("Returns how many ticks the item has been smelting for.")
		public int getCookTime() {
			return this.mcTileEntity.getField(2);
		}

		@PythonFunction
		@PythonDocString("Sets how many ticks the item has been smelting.")
		public void setCookTime(int cookTime) {
			this.mcTileEntity.setField(2, cookTime);
		}
	}

	@PythonClass
	public class Hopper extends LockableLoot<TileEntityHopper> {

		private static final long serialVersionUID = 3097927657009612724L;

		public Hopper(TileEntityHopper tileEntity) {
			super(tileEntity);
		}

		@PythonFunction
		@PythonDocString("Sets how many tikcs until the next item is transfered.  0 means items transfer instantly")
		public void setTransferTime(int ticks) {
			this.mcTileEntity.setTransferCooldown(ticks);
		}
	}

	@PythonClass
	public class Spawner extends TileEntityBase<TileEntityMobSpawner> {

		private static final long serialVersionUID = 6463338206694416736L;

		private final String[] FIELD_NAMES = new String[] { "potentialSpawns", "field_98285_e" };

		public Spawner(TileEntityMobSpawner tileEntity) {
			super(tileEntity);
		}

		@PythonFunction
		@PythonDocString("Returns a tuple of the spawn potentials.  See setSpawnPotentials() for the tuple format.")
		public PyList getSpawnPotentials() {
			Object obj = ReflectionHelper.getPrivateValue(MobSpawnerBaseLogic.class,
					this.mcTileEntity.getSpawnerBaseLogic(), FIELD_NAMES);

			List<WeightedSpawnerEntity> list = ((List<WeightedSpawnerEntity>) obj);

			PyList list1 = new PyList();
			for (WeightedSpawnerEntity weightedSpawnerEntity : list) {
				list1.add(new PyTuple(new PyString(weightedSpawnerEntity.getNbt().getString("id")),
						new PyInteger(weightedSpawnerEntity.itemWeight)));
			}

			return list1;
		}

		@PythonFunction
		@PythonDocString("Takes a list of tuples of (entity_id, weight).  Weight must be greater than 1.")
		// TODO add option to set entity tags
		public void setSpawnPotentials(PyList list) {
			List<WeightedSpawnerEntity> list1 = new ArrayList<>();

			Object entityIdentifier;
			PyTuple tuple;
			NBTTagCompound tag;
			for (Object obj : list) {
				if (!(obj instanceof PyTuple)) {
					throw Py.ValueError("Non tuple type found in the list");
				} else {
					tuple = (PyTuple) obj;

					tag = new NBTTagCompound();
					entityIdentifier = tuple.get(0);
					if (!(entityIdentifier instanceof String)) {
						throw Py.ValueError("Entity identifier must be a string");
					}
					tag.setString("id", (String) tuple.get(0));
					int weight = (int) tuple.get(1);
					if (weight < 1) {
						throw Py.ValueError("Spawn weight must be greater than 1");
					}

					list1.add(new WeightedSpawnerEntity(weight, tag));
				}
			}

			ReflectionHelper.setPrivateValue(MobSpawnerBaseLogic.class, this.mcTileEntity.getSpawnerBaseLogic(), list1,
					FIELD_NAMES);
		}
	}

	@PythonClass
	public class NoteBlock extends TileEntityBase<TileEntityNote> {

		private static final long serialVersionUID = -3298764120818473440L;

		public NoteBlock(TileEntityNote tileEntity) {
			super(tileEntity);
		}

		@PythonFunction
		@PythonDocString("Returns the note that the Note Block will play.")
		public int getNote() {
			return this.mcTileEntity.note;
		}

		@PythonFunction
		@PythonDocString("Sets the note that the Note Block will play.  note must be between 0 and 24")
		public void setNote(int note) {
			if (note < 0 || note > 24) {
				throw Py.ValueError("note must be between 0 and 24.");
			}
			// More or less a copy of TileEntityNote.changePitch()
			byte old = (byte) note;
			this.mcTileEntity.note = (byte) ((this.mcTileEntity.note + 1) % 25);
			if (!net.minecraftforge.common.ForgeHooks.onNoteChange(this.mcTileEntity, old))
				return;
			this.mcTileEntity.markDirty();
		}

	}

	@PythonClass
	public class Sign extends TileEntityBase<TileEntitySign> {

		private static final long serialVersionUID = -3977002864117163137L;

		public Sign(TileEntitySign tileEntity) {
			super(tileEntity);
		}

		@PythonFunction
		@PythonDocString("Returns the text as a string.  lineNumber must be between 1 and 4 inclusive.")
		public String getText(int lineNumber) {
			if (lineNumber < 1 || lineNumber > 4) {
				throw Py.ValueError("lineNumber must be between 1 and 4 inclusive!");
			}
			return ITextComponent.Serializer.componentToJson(this.mcTileEntity.signText[lineNumber - 1]);
		}

		@PythonFunction
		@PythonDocString("Sets the text.  text accepts formatting codes, lineNumber must be between 1 and 4 inclusive")
		public void setText(String text, int lineNumber) {
			if (lineNumber < 1 || lineNumber > 4) {
				throw Py.ValueError("lineNumber must be between 1 and 4 inclusive!");
			}
			this.mcTileEntity.signText[lineNumber - 1] = new TextComponentString(text);
			this.mcTileEntity.markDirty();
			IBlockState state = this.mcTileEntity.getWorld().getBlockState(this.mcTileEntity.getPos());
			this.mcTileEntity.getWorld().notifyBlockUpdate(this.mcTileEntity.getPos(), state, state, 3);
		}
	}

	@PythonClass
	public class Skull extends TileEntityBase<TileEntitySkull> {

		private static final long serialVersionUID = -4226105205783622653L;

		@PythonField
		public static final String ALEX = "MHF_Alex";
		@PythonField
		public static final String BLAZE = "MHF_Blaze";
		@PythonField
		public static final String CAVE_SPIDER = "MHF_CaveSpider";
		@PythonField
		public static final String CHICKEN = "MHF_Chicken";
		@PythonField
		public static final String COW = "MHF_Cow";
		@PythonField
		public static final String CREEPER = "MHF_Creeper";
		@PythonField
		public static final String ENDERMAN = "MHF_Enderman";
		@PythonField
		public static final String GHAST = "MHF_Ghast";
		@PythonField
		public static final String GOLEM = "MHF_Golem";
		@PythonField
		public static final String HEROBRINE = "MHF_Herobrine";
		@PythonField
		public static final String MAGMA_CUBE = "MHF_LavaSlime";
		@PythonField
		public static final String MUSHROOM_COW = "MHF_MushroomCow";
		@PythonField
		public static final String OCELOT = "HF_Ocelot";
		@PythonField
		public static final String PIG = "MHF_Pig";
		@PythonField
		public static final String PIG_ZOMBIE = "MHF_PigZombie";
		@PythonField
		public static final String SHEEP = "MHF_Sheep";
		@PythonField
		public static final String SKELETON = "MHF_Skeleton";
		@PythonField
		public static final String SLIME = "MHF_Slime";
		@PythonField
		public static final String SPIDER = "MHF_Spider";
		@PythonField
		public static final String SQUID = "MHF_Squid";
		@PythonField
		public static final String STEVE = "MHF_Steve";
		@PythonField
		public static final String VILLAGER = "MHF_Villager";
		@PythonField
		public static final String WITHER_SKELETON = "MHF_WSkeleton";
		@PythonField
		public static final String ZOMBIE = "MHF_Zombie";
		@PythonField
		public static final String CACTUS = "MHF_Cactus";
		@PythonField
		public static final String CAKE = "MHF_Cake";
		@PythonField
		public static final String CHEST = "MHF_Chest";
		@PythonField
		public static final String COCONUT_BROWN = "MHF_CoconutB";
		@PythonField
		public static final String COCONUT_GREEN = "MHF_CoconutG";
		@PythonField
		public static final String MELON = "MHF_Melon";
		@PythonField
		public static final String OAK_LOG = "MHF_OakLog";
		@PythonField
		public static final String PRESENT_1 = "MHF_Present1";
		@PythonField
		public static final String PRESENT_2 = "MHF_Present2";
		@PythonField
		public static final String PUMPKIN = "MHF_Pumpkin";
		@PythonField
		public static final String TNT = "MHF_TNT";
		@PythonField
		public static final String TNT2 = "MHF_TNT2";
		@PythonField
		public static final String ARROW_UP = "MHF_ArrowUp";
		@PythonField
		public static final String ARROW_DOWN = "MHF_ArrowDown";
		@PythonField
		public static final String ARROW_LEFT = "MHF_ArrowLeft";
		@PythonField
		public static final String ARROW_RIGHT = "MHF_ArrowRight";
		@PythonField
		public static final String EXCLAMATION = "MHF_Exclamation";
		@PythonField
		public static final String QUESTION = "MHF_Question";

		public Skull(TileEntitySkull tileEntity) {
			super(tileEntity);
		}

		@PythonFunction
		public int getSkullType() {
			return this.mcTileEntity.getSkullType();
		}

		@PythonFunction
		@PythonDocString("Takes an integer ID for skull type, or a player's name to represent.")
		public void setSkullType(@PythonTypeExclude Object type) {
			if (type instanceof String) {
				String s = ((String)type);
				if(StringUtils.isBlank(s)) {
					throw Py.ValueError("type can not be empty or only whitespaces");
				} else {
					this.mcTileEntity.setPlayerProfile(new GameProfile((UUID) null, (String) type));					
				}
			} else if (type instanceof Integer) {
				this.mcTileEntity.setType((int) type);
			} else {
				throw Py.ValueError("type must be an integer or string.");
			}
			this.dirtyAndUpdate();
		}

		@PythonFunction
		@PythonDocString("Returns the rotation of the skill as an int (0-15).")
		public int getRotation() {
			return this.mcTileEntity.getSkullRotation();
		}

		@PythonFunction
		@PythonDocString("Sets the rotation (0-15) of the skull.")
		public void setRotation(int rotation) {
			if (rotation < 0 || rotation > 15) {
				throw Py.ValueError("rotation must be between 0 and 15.");
			}
			this.mcTileEntity.setSkullRotation(rotation);
			this.dirtyAndUpdate();
		}
	}
}
