package com.codeshaper.ms3;

import java.util.List;

import javax.annotation.Nullable;

import com.codeshaper.ms3.api.executor;
import com.codeshaper.ms3.api.util;
import com.codeshaper.ms3.bindScriptAction.BSAction;
import com.codeshaper.ms3.bindScriptAction.BindScriptAction;
import com.codeshaper.ms3.capability.EntityMs3DataProvider;
import com.codeshaper.ms3.capability.IEntityMs3Data;
import com.codeshaper.ms3.gui.GuiUpdate;
import com.codeshaper.ms3.gui.GuiWarning;
import com.codeshaper.ms3.interpreter.PyInterpreter;
import com.codeshaper.ms3.script.RunnableScript;
import com.codeshaper.ms3.script.ScheduledScript;
import com.codeshaper.ms3.update.UpdateChecker;
import com.codeshaper.ms3.util.Logger;
import com.codeshaper.ms3.util.textBuilder.TextBuilder;
import com.codeshaper.ms3.util.textBuilder.TextBuilderTrans;

import net.minecraft.client.Minecraft;
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
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraftforge.fml.relauncher.Side;

public class EventHandler {

	private static final ResourceLocation CAPABILITY_RS = new ResourceLocation(Ms3.MOD_ID, "entityMs3Data");

	@SubscribeEvent
	public void onEntityClick(PlayerInteractEvent.EntityInteract event) {
		Entity clickedEntity = event.getTarget();
		EntityPlayer player = event.getEntityPlayer();

		if (!event.getWorld().isRemote && event.getHand() == EnumHand.MAIN_HAND) {
			IEntityMs3Data capData = clickedEntity.getCapability(EntityMs3DataProvider.ENTITY_MS3_DATA_CAP, null);

			if (event.getItemStack().getItem() == Ms3.itemScriptBinder) {
				// Bind a script to the entity.
				BindScriptAction bsa = Ms3.players.get(player.getUniqueID());
				if (bsa != null) {
					if (bsa.getAction() == BSAction.CHECK) {
						this.boundScriptCheck(player, capData);
					} else {
						RunnableScript runnableScript = bsa.getRunnableScript();
						if (!runnableScript.exists()) {
							player.sendMessage(new TextBuilder(
									"Script with name \" + runnableScript.getFile().getPath() + \" could not be found")
											.color(TextFormatting.RED).get());
						} else {
							BSAction action = bsa.getAction();
							if (action == BSAction.ADD) {
								this.addBoundScript(player, capData, runnableScript, clickedEntity);
							} else if (action == BSAction.REMOVE) {
								this.removeBoundScript(player, capData, runnableScript);
							}
						}
					}
				} else {
					player.sendMessage(new TextBuilderTrans("ms3.stick.useBindscriptFirst").color(TextFormatting.RED).get());
				}
				event.setCancellationResult(EnumActionResult.FAIL);
			} else {
				capData.runAllOnClick(clickedEntity, player);
				// TODO cancel event based on function return value?
				event.setCancellationResult(EnumActionResult.FAIL);
			}
		}
	}

	private boolean flag;

	@SubscribeEvent
	public void initGui(GuiScreenEvent.InitGuiEvent.Pre event) {
		if (event.getGui() instanceof GuiMainMenu) {
			Minecraft mc = Minecraft.getMinecraft();
			if (Ms3.ms3Props.showWarning()) {
				mc.displayGuiScreen(new GuiWarning(event.getGui()));
			} else if (!flag && Ms3.ms3Props.promptDownload() && UpdateChecker.isOutdated(Ms3.RELEASE)) {
				flag = false;
				mc.displayGuiScreen(new GuiUpdate(event.getGui()));
			}
		}
	}

	@SubscribeEvent
	public void worldTickEvent(WorldTickEvent event) {
		if (event.side == Side.SERVER) {
			if (event.phase == Phase.END) {

				// Update Entities with bound scripts.
				Entity entity;
				IEntityMs3Data ms3Data;
				List<Entity> entityList = event.world.getLoadedEntityList();
				for (int i = 0; i < entityList.size(); i++) {
					entity = entityList.get(i);
					ms3Data = entity.getCapability(EntityMs3DataProvider.ENTITY_MS3_DATA_CAP, null);
					if (ms3Data != null) {
						ms3Data.runAllExecute(entity);
					} else {
						Logger.err("No Capability on Entity!!!"); // This should never happen!
					}
				}

				// Update scheduled scripts.
				ScheduledScript scheduledScript;
				for (int i = util.scripts.size() - 1; i >= 0; i--) {
					scheduledScript = util.scripts.get(i);

					if (scheduledScript.reduceTime()) {
						executor.Executor executor = scheduledScript.getExecutor();
						PyInterpreter interpreter = Ms3.getInterpreter();

						// TODO who should the error be printed to?
						if (!scheduledScript.exists()) {
							executor.sendMessage(new TextComponentTranslation("pycraft.scheduledScript.scriptNotFound",
									scheduledScript.getFile().getPath()));
						}

						try {
							interpreter.runExecute(scheduledScript, executor.getSenderObj());
						} catch (CommandException exception) {
							executor.sendMessage(new TextComponentTranslation(
									"pycraft.scheduledScript.noExecuteFunction", scheduledScript.getFile().getPath()));
						}

						util.scripts.remove(i);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
		event.addCapability(CAPABILITY_RS, new EntityMs3DataProvider());
	}

	/**
	 * Sends the player messages listing all the scripts bound to the passed entity.
	 * 
	 * @param player
	 * @param capabilityData
	 */
	private void boundScriptCheck(ICommandSender player, IEntityMs3Data capabilityData) {
		List<RunnableScript> list = capabilityData.getScriptList();
		if (list.size() == 0) {
			player.sendMessage(new TextBuilderTrans("ms3.stick.noScripts").color(TextFormatting.YELLOW).get());
		} else {
			player.sendMessage(new TextBuilderTrans("ms3.stick.totalScriptCount", list.size(), list.size() > 1 ? "" : "s").color(TextFormatting.YELLOW).get());
			for (RunnableScript rs : list) {
				player.sendMessage(new TextBuilderTrans("> " + rs.getFile().getPath()).color(TextFormatting.YELLOW).get());
			}
		}
	}

	/**
	 * Binds a script to an entity.
	 * 
	 * @param player
	 *            The player who preformed the click.
	 * @param capabilityData
	 * @param runnableScript
	 *            The script to bind.
	 * @param clickedEntity
	 *            The entity that was clicked.
	 */
	private void addBoundScript(@Nullable ICommandSender player, IEntityMs3Data capabilityData,
			RunnableScript runnableScript, Entity clickedEntity) {
		if (capabilityData.getScriptList().contains(runnableScript)) {
			this.safeSendMessage(player, new TextBuilder("ms3.stick.cantAddDuplicate").color(TextFormatting.RED).get());
		} else {
			if (Ms3.getInterpreter().runOnBind(runnableScript, player, clickedEntity)) {
				capabilityData.addScript(runnableScript);
				this.safeSendMessage(player, new TextBuilder("ms3.stick.successfulBind").color(TextFormatting.GREEN).get());
			} else {
				// More code because it must be in bold.
				ITextComponent itc = new TextComponentTranslation("ms3.stick.bindingError");
				itc.getStyle().setBold(true).setColor(TextFormatting.RED);
				this.safeSendMessage(player, itc);
			}
		}
	}

	/**
	 * Removes a bound script from an entity, printing out a message to the player
	 * if the script isn't found.
	 * 
	 * @param player
	 *            The player who preformed the click.
	 * @param capabilityData
	 * @param runnableScript
	 *            The script to try and remove.
	 */
	private void removeBoundScript(@Nullable ICommandSender player, IEntityMs3Data capabilityData,
			RunnableScript runnableScript) {
		List<RunnableScript> list = capabilityData.getScriptList();
		if (list.contains(runnableScript)) {
			list.remove(runnableScript);
		} else {
			this.safeSendMessage(player, new TextBuilder("ms3.stick.noScriptOnEntity").color(TextFormatting.RED).get());
		}
	}

	private void safeSendMessage(@Nullable ICommandSender sender, ITextComponent component) {
		if (sender != null) {
			sender.sendMessage(component);
		}
	}
}
