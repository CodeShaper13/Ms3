package com.codeshaper.ms3;

import java.util.List;

import javax.annotation.Nullable;

import org.python.core.PyObject;

import com.codeshaper.ms3.api.BoundObject;
import com.codeshaper.ms3.api.entity;
import com.codeshaper.ms3.api.executor;
import com.codeshaper.ms3.api.util;
import com.codeshaper.ms3.bindScriptAction.BSAction;
import com.codeshaper.ms3.bindScriptAction.BindScriptAction;
import com.codeshaper.ms3.capability.AttachedScript;
import com.codeshaper.ms3.capability.AttachedScriptList;
import com.codeshaper.ms3.capability.EntityMs3DataProvider;
import com.codeshaper.ms3.capability.IEntityMs3Data;
import com.codeshaper.ms3.gui.GuiUpdate;
import com.codeshaper.ms3.gui.GuiWarning;
import com.codeshaper.ms3.interpreter.PyInterpreter;
import com.codeshaper.ms3.script.RunnableScript;
import com.codeshaper.ms3.script.ScheduledScript;
import com.codeshaper.ms3.update.UpdateChecker;
import com.codeshaper.ms3.util.Logger;
import com.codeshaper.ms3.util.MessageUtil;
import com.codeshaper.ms3.util.textBuilder.TextBuilder;
import com.codeshaper.ms3.util.textBuilder.TextBuilderTrans;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraftforge.fml.relauncher.Side;

public class EventHandler {

	private static final ResourceLocation CAPABILITY_RS = new ResourceLocation(Ms3.MOD_ID, "entityMs3Data");

	/** If true, the update gui has been shown this session. */
	private boolean flag = false;

	@SubscribeEvent
	public void onEntityClick(PlayerInteractEvent.EntityInteract event) {
		Entity clickedEntity = event.getTarget();
		EntityPlayer player = event.getEntityPlayer();

		if (!event.getWorld().isRemote && event.getHand() == EnumHand.MAIN_HAND) {
			IEntityMs3Data capData = clickedEntity.getCapability(EntityMs3DataProvider.ENTITY_MS3_DATA_CAP, null);

			if (event.getItemStack().getItem() == Ms3.itemScriptBinder) {
				this.handleScriptBinderStickClick(player, clickedEntity, capData);
				event.setCancellationResult(EnumActionResult.FAIL);
			} else {
				capData.runCallback(EnumCallbackType.ON_CLICK, player);
				// TODO cancel event based on function return value?
				event.setCancellationResult(EnumActionResult.FAIL);
			}
		}
	}

	private void handleScriptBinderStickClick(EntityPlayer player, Entity clickedEntity, IEntityMs3Data ms3Data) {
		// Bind a script to the entity.
		BindScriptAction bsa = Ms3.players.get(player.getUniqueID());
		if (bsa != null) {
			BSAction bsAction = bsa.getAction();
			if (bsAction == BSAction.CHECK) {
				this.boundObjectCheck(player, ms3Data);
			}
			else if (bsAction == BSAction.CLEAR) {
				this.boundScriptClear(player, ms3Data);
			}
			else if (bsAction == BSAction.ADD || bsAction == BSAction.REMOVE) {
				RunnableScript runnableScript = bsa.getRunnableScript();
				if (!runnableScript.exists()) {
					player.sendMessage(new TextBuilder(
							"Script with name \"" + runnableScript.getFile().getPath() + "\" could not be found.")
									.color(TextFormatting.RED).get());
				}
				else {
					BSAction action = bsa.getAction();
					if (action == BSAction.ADD) {
						this.addBoundScript(player, ms3Data, runnableScript, clickedEntity);
					} else if (action == BSAction.REMOVE) {
						this.removeBoundScript(player, ms3Data, runnableScript);
					}
				}
			}
		}
		else {
			player.sendMessage(new TextBuilderTrans("ms3.stick.useBindscriptFirst").color(TextFormatting.RED).get());
		}
	}

	@SubscribeEvent
	public void initGui(GuiScreenEvent.InitGuiEvent.Pre event) {
		if (event.getGui() instanceof GuiMainMenu) {
			Minecraft mc = Minecraft.getMinecraft();
			if (Ms3.ms3Props.showWarning()) {
				mc.displayGuiScreen(new GuiWarning(event.getGui()));
			} else if (!this.flag) {
				try {
					if (Ms3.updateChecker.isOutdated(new Version(Ms3.MOD_VERSION))) {
						this.flag = true;
						mc.displayGuiScreen(new GuiUpdate(event.getGui()));
					}
				} catch (NumberFormatException | MalformedJsonException e) {
					System.out.println("Could not check for an update!");
					e.printStackTrace();
				}
			}
		}
	}

	@SubscribeEvent
	public void worldTickEvent(WorldTickEvent event) {
		if (event.side == Side.SERVER && event.phase == Phase.END) {
			this.triggerEventFunction(event.world, EnumCallbackType.ON_TICK);

			// Update scheduled scripts.
			ScheduledScript scheduledScript;
			for (int i = util.scheduledScripts.size() - 1; i >= 0; i--) {
				scheduledScript = util.scheduledScripts.get(i);

				if (scheduledScript.reduceTime()) {
					executor.Executor executor = scheduledScript.getExecutor();
					PyInterpreter interpreter = Ms3.getDefaultInterpreter();

					// TODO who should the error be printed to?
					if (!scheduledScript.exists()) {
						executor.sendMessage(new TextComponentTranslation("pycraft.scheduledScript.scriptNotFound",
								scheduledScript.getFile().getPath()));
					}

					try {
						scheduledScript.runExecuteFunction(interpreter, executor.getSenderObj());
					} catch (CommandException e) {
						executor.sendMessage(new TextComponentTranslation("pycraft.scheduledScript.noExecuteFunction", 
								scheduledScript.getFile().getPath()));
					}

					util.scheduledScripts.remove(i);
				}
			}
		}
	}

	/**
	 * This event attaches the {@link IEntityMs3Data} capability to an Entity when triggered.
	 * 
	 * @param event
	 */
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
		Entity e = event.getObject();
		if(!(e instanceof EntityPlayer)) {
			event.addCapability(CAPABILITY_RS, new EntityMs3DataProvider(e));			
		}
	}
	
	

	/**
	 * Searches the world for every loaded Entities and calls a specific event function for every {@link BoundObject} bound to the Entity.
	 * 
	 * @param world
	 * @param type
	 */
	private void triggerEventFunction(World world, EnumCallbackType type) {
		IEntityMs3Data ms3Data;
		for (Entity entity : world.loadedEntityList) {
			if(!(entity instanceof EntityPlayer)) {
				ms3Data = entity.getCapability(EntityMs3DataProvider.ENTITY_MS3_DATA_CAP, null);
				if (ms3Data != null) {
					ms3Data.runCallback(type);
				} else {
					Logger.warn(
							"Error looking up data about Entity!  Internally this means the IEntityMs3Data capability could not be found!");
				}	
			}
		}
	}

	/**
	 * Sends the player messages listing all the objects bound to the passed entity.
	 * 
	 * @param player
	 * @param capabilityData
	 */
	private void boundObjectCheck(ICommandSender player, IEntityMs3Data capabilityData) {
		AttachedScriptList list = capabilityData.getScriptList();
		if (list.size() == 0) {
			player.sendMessage(new TextBuilderTrans("ms3.stick.noScripts").color(TextFormatting.YELLOW).get());
		} else {
			player.sendMessage(
					new TextBuilderTrans("ms3.stick.totalScriptCount", list.size(), list.size() > 1 ? "" : "s")
							.color(TextFormatting.YELLOW).get());
			for (AttachedScript as : list) {
				player.sendMessage(
						new TextBuilder("> " + as.getLocation().getFile().getPath()).color(TextFormatting.YELLOW).get());
			}
		}
	}

	/**
	 * Clears all {@link BoundObject}s that have been bound to the passed entity.
	 * 
	 * @param player
	 * @param capabilityData
	 */
	private void boundScriptClear(ICommandSender player, IEntityMs3Data capabilityData) {
		capabilityData.getScriptList().removeAll();
		MessageUtil.sendMessage(player,
				new TextBuilderTrans("ms3.stick.allScriptsCleared").color(TextFormatting.YELLOW));
	}

	/**
	 * Binds a script to an entity.
	 * 
	 * @param player         The player who performed the click.
	 * @param ms3EntityData
	 * @param runnableScript The script to bind.
	 * @param clickedEntity  The entity that was clicked.
	 */
	private void addBoundScript(@Nullable ICommandSender player, IEntityMs3Data ms3EntityData, RunnableScript runnableScript, Entity clickedEntity) {
		// Make sure the entity doesn't already have the same script bound to it.
		if (ms3EntityData.getScriptList().containsScript(runnableScript)) {
			MessageUtil.sendMessage(player, new TextBuilder("ms3.stick.cantAddDuplicate").color(TextFormatting.RED));
		}
		else {
			// Try to bind the script.
			PyInterpreter interpreter = Ms3.getDefaultInterpreter();
			ms3EntityData.addBoundScript(entity.getWrapperClassForEntity(clickedEntity), runnableScript);
			
			/*
			boolean flag = interpreter.runOnBind(runnableScript, player, clickedEntity);
			if (flag) {
				PyObject obj = Ms3.getDefaultInterpreter().func(runnableScript, player);
				if (obj != null) {
					ms3EntityData.addBoundObject(obj, entity.getWrapperClassForEntity(clickedEntity));
					MessageUtil.sendMessage(player, new TextBuilderTrans("ms3.stick.successfulBind").color(TextFormatting.GREEN));
				} else {
					MessageUtil.sendMessage(player, new TextBuilder("Script must define a class with the same name as the script file.").color(TextFormatting.GREEN));
				}
				
				
			} else {
				// More code because it must be in bold.
				ITextComponent itc = new TextComponentTranslation("ms3.stick.bindingError");
				itc.getStyle().setBold(true).setColor(TextFormatting.RED);

				MessageUtil.sendMessage(player, itc);
			}
			*/
		}
	}

	/**
	 * Removes a bound script from an entity, printing out a message to the player
	 * if the script isn't found.
	 * 
	 * @param player         The player who performed the click.
	 * @param capabilityData
	 * @param runnableScript The script to try and remove.
	 */
	private void removeBoundScript(@Nullable ICommandSender player, IEntityMs3Data capabilityData,
			RunnableScript runnableScript) {
		AttachedScriptList list = capabilityData.getScriptList();
		if (list.containsScript(runnableScript)) {
			list.remove(runnableScript);
		} else {
			MessageUtil.sendMessage(player, new TextBuilder("ms3.stick.noScriptOnEntity").color(TextFormatting.RED));
		}
	}
}
