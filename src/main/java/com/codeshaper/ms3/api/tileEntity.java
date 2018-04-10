package com.codeshaper.ms3.api;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import org.python.core.Py;
import org.python.core.PyInteger;
import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PyTuple;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonExcludeType;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;
import com.codeshaper.ms3.util.NbtHelper;
import com.mojang.authlib.GameProfile;

import net.minecraft.block.state.IBlockState;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
		public PyTuple getItem(int slot) {
			int i = this.getContainerSize();
			if (slot < 0 || slot > (i - 1)) {
				throw Py.ValueError("Index must be between 0 and " + (i - 1));
			}
			return itemUtils.tupleFromItemStack(this.mcTileEntity.getStackInSlot(slot));
		}

		@PythonFunction
		public void setItem(int slot, PyTuple itemStack) {
			int i = this.getContainerSize();
			if (slot < 0 || slot > (i - 1)) {
				throw Py.ValueError("Index must be between 0 and " + (i - 1));
			}
			this.mcTileEntity.setInventorySlotContents(slot, itemUtils.itemStackFromTuple(itemStack));
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
		@PythonDocString("Returns the Container's name, or it's unlocalized name if it has none.")
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
		@PythonDocString("Returns the effect id.  See effectList.py")
		public int getEffect(boolean isPrimary) {
			return this.mcTileEntity.getField(isPrimary ? 1 : 2);
		}

		@PythonFunction
		@PythonDocString("Sets the beacon's effect.  See effectList.py")
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
		public int getColor() {
			return this.mcTileEntity.getColor().getMetadata();
		}

		@PythonFunction
		public void setColor(int color) {
			this.mcTileEntity.setColor(EnumDyeColor.byMetadata(color));
		}
	}

	@PythonClass
	public class BrewingStand extends Lockable<TileEntityBrewingStand> {

		private static final long serialVersionUID = -4501498464782181069L;

		@PythonField
		public static final int ID_LEFT = 0;
		@PythonField
		public static final int ID_MIDDLE = 1;
		@PythonField
		public static final int ID_RIGHT = 2;
		@PythonField
		public static final int ID_INGREDIENT = 3;
		@PythonField
		public static final int ID_FUEL = 4;

		public BrewingStand(TileEntityBrewingStand tileEntity) {
			super(tileEntity);
		}

		@PythonFunction
		public int getBrewTime() {
			return this.mcTileEntity.getField(0);
		}

		@PythonFunction
		public void setBrewTime(int brewTime) {
			this.mcTileEntity.setField(0, brewTime);
		}

		@PythonFunction
		public int getFuel() {
			return this.mcTileEntity.getField(1);
		}

		@PythonFunction
		public void setFuelTime(int fuel) {
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
		@PythonDocString("Returns a tuple of (itemName, meta) or None if it is empty.")
		@Nullable
		public PyTuple getPotContents() {
			Item item = this.mcTileEntity.getFlowerPotItem();
			if (item == null) {
				return null;
			} else {
				return new PyTuple(new PyString(item.getUnlocalizedName()),
						new PyInteger(this.mcTileEntity.getFlowerPotData()));
			}
		}

		@PythonFunction
		// TODO not updated on client.
		public void setPotContents(String item, int meta) {
			this.mcTileEntity.setItemStack(new ItemStack(Item.getByNameOrId(item), 1, meta));
			this.mcTileEntity.markDirty();
			IBlockState state = this.mcTileEntity.getWorld().getBlockState(this.mcTileEntity.getPos());
			this.mcTileEntity.getWorld().notifyBlockUpdate(this.mcTileEntity.getPos(), state, state, 3);

		}
	}

	@PythonClass
	public class Furnace extends Lockable<TileEntityFurnace> {

		private static final long serialVersionUID = 7367812229820446548L;

		@PythonField
		public static final int ID_SMELT = 0;
		@PythonField
		public static final int ID_FUEL = 1;
		@PythonField
		public static final int ID_RESULT = 2;

		public Furnace(TileEntityFurnace tileEntity) {
			super(tileEntity);
		}
	}

	@PythonClass
	public class Hopper extends LockableLoot<TileEntityHopper> {

		private static final long serialVersionUID = 3097927657009612724L;

		public Hopper(TileEntityHopper tileEntity) {
			super(tileEntity);
		}

		@PythonFunction
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
		@PythonDocString("Takes a list of tuples of (entity name, weight).  Weight must be greater than 1")
		public void setSpawnPotentials(PyList list) {
			List<WeightedSpawnerEntity> list1 = new ArrayList<>();

			Object obj, entityIdentifier;
			PyTuple tuple;
			NBTTagCompound tag;
			for (int i = 0; i < list.size(); i++) {
				obj = list.get(i);
				if (!(obj instanceof PyTuple)) {
					throw Py.ValueError("Non tuple type found in the list");
				} else {
					tuple = (PyTuple) obj;

					tag = new NBTTagCompound();
					entityIdentifier = tuple.get(0);
					if (!(entityIdentifier instanceof String)) {
						throw Py.ValueError("Entity identifier must be a string"); // is string a subclass of pyString?
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
		public int getNote() {
			return this.mcTileEntity.note;
		}

		@PythonFunction
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
		@PythonDocString("lineNumber is 1-4.")
		public String getText(int lineNumber) {
			if (lineNumber < 1 || lineNumber > 4) {
				throw Py.ValueError("lineNumber must be between 1 and 4 inclusive!");
			}
			return ITextComponent.Serializer.componentToJson(this.mcTileEntity.signText[lineNumber - 1]);
		}

		@PythonFunction
		@PythonDocString("lineNumber is 1-4")
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
		@PythonDocString("Takes an integer id for skull type, of a player's name to represent.")
		public void setSkullType(@PythonExcludeType Object type) {
			if (type instanceof String) {
				this.mcTileEntity.setPlayerProfile(new GameProfile((UUID) null, (String) type));
			} else if (type instanceof Integer) {
				this.mcTileEntity.setType((int) type);
			} else {
				throw Py.ValueError("type must be an integer or string.");
			}
			this.dirtyAndUpdate();
		}

		@PythonFunction
		public int getRotation() {
			return this.mcTileEntity.getSkullRotation();
		}

		@PythonFunction
		public void setRotation(int rotation) {
			if (rotation < 0 || rotation > 15) {
				throw Py.ValueError("rotation must be between 0 and 15.");
			}
			this.mcTileEntity.setSkullRotation(rotation);
			this.dirtyAndUpdate();
		}
	}
}
