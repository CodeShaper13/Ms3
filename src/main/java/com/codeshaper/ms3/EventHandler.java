package com.codeshaper.ms3;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.codeshaper.ms3.api.executor;
import com.codeshaper.ms3.api.util;
import com.codeshaper.ms3.bindScriptAction.Action;
import com.codeshaper.ms3.bindScriptAction.BindScriptAction;
import com.codeshaper.ms3.capability.BoundScriptProvider;
import com.codeshaper.ms3.capability.IBoundScript;
import com.codeshaper.ms3.gui.GuiWarning;
import com.codeshaper.ms3.interpreter.PyInterpreter;
import com.codeshaper.ms3.script.RunnableScript;
import com.codeshaper.ms3.script.ScheduledScript;
import com.codeshaper.ms3.util.Logger;
import com.codeshaper.ms3.util.Util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.command.CommandException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
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

	public static boolean showWarning = true;
	public static final ResourceLocation BOUND_SCRIPT_CAP = new ResourceLocation(MS3.MOD_ID, "boundScript");

	public EventHandler() {
		File f = new File(MS3.dirManager.internalFolder, "settings.properties");

		if (f.exists()) {
			Properties config = new Properties();
			try {
				config.load(new FileInputStream(f));
			} catch (Exception e) {
				e.printStackTrace();
			}
			EventHandler.showWarning = config.getProperty("showWarning", "true").equals("true");
		}
	}

	@SubscribeEvent
	public void onEntityClick(PlayerInteractEvent.EntityInteract event) {
		Entity clickedEntity = event.getTarget();
		EntityPlayer player = event.getEntityPlayer();

		if (!event.getWorld().isRemote && event.getHand() == EnumHand.MAIN_HAND) {
			IBoundScript bs = clickedEntity.getCapability(BoundScriptProvider.BOUND_SCRIPT_CAP, null);

			if (event.getItemStack().getItem() == MS3.itemScriptBinder) {
				// Bind a script to the entity.
				BindScriptAction bsa = MS3.instance.players.get(player.getUniqueID());
				if (bsa != null) {
					if (bsa.getAction() == Action.CHECK) {
						this.boundScriptCheck(player, bs);
					} else {
						RunnableScript runnableScript = bsa.getRunnableScript();
						if (!runnableScript.exists()) {
							player.sendMessage(Util.withColor(
									"Script with name " + runnableScript.getFile().getPath() + " could not be found",
									TextFormatting.RED));
						} else {
							Action action = bsa.getAction();
							if (action == Action.ADD) {
								this.addBoundScript(player, bs, runnableScript, clickedEntity);
							} else { // Remove.
								this.removeBoundScript(player, bs, runnableScript);
							}
						}
					}
				} else {
					player.sendMessage(Util.withColor("ms3.stick.useBindscriptFirst", TextFormatting.RED));
				}
				event.setCancellationResult(EnumActionResult.FAIL);
			} else {
				bs.runAllOnClick(clickedEntity, player);
				// TODO cancel event based on function return value?
				event.setCancellationResult(EnumActionResult.FAIL);
			}
		}
	}

	@SubscribeEvent
	public void initGui(GuiScreenEvent.InitGuiEvent.Pre event) {
		if (event.getGui() instanceof GuiMainMenu && EventHandler.showWarning) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiWarning(event.getGui()));
		}
	}

	@SubscribeEvent
	public void worldTickEvent(WorldTickEvent event) {
		if (event.side == Side.SERVER) {
			if (event.phase == Phase.END) {

				// Update Entities with bound scripts.
				Entity entity;
				IBoundScript boundScript;
				List<Entity> entityList = event.world.getLoadedEntityList();
				for (int i = 0; i < entityList.size(); i++) {
					entity = entityList.get(i);
					boundScript = entity.getCapability(BoundScriptProvider.BOUND_SCRIPT_CAP, null);
					if (boundScript != null) {
						boundScript.runAllExecute(entity);
					} else {
						Logger.err("No Capability on Entity!!!"); // This should never happen!
					}
				}

				// Update scheduled scripts.
				ScheduledScript scheduledScript;
				Iterator<ScheduledScript> iter = util.scripts.iterator();
				for (int i = util.scripts.size() - 1; i >= 0; i--) {
					scheduledScript = util.scripts.get(i);

					if (scheduledScript.reduceTime()) {
						executor.Executor executor = scheduledScript.getExecutor();
						PyInterpreter interpreter = MS3.getInterpreter();

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
		event.addCapability(BOUND_SCRIPT_CAP, new BoundScriptProvider());
	}

	private void boundScriptCheck(EntityPlayer player, IBoundScript bs) {
		List<RunnableScript> list = bs.getScriptList();
		if (list.size() == 0) {
			player.sendMessage(Util.withColor("ms3.stick.noScripts", TextFormatting.YELLOW));
		} else {
			player.sendMessage(Util.withColor("ms3.stick.totalScriptCount", TextFormatting.YELLOW, list.size(), list.size() > 1 ? "" : "s"));
			int i = 0;
			for (RunnableScript rs : list) {
				i++;
				player.sendMessage(Util.withColor("> " + rs.getFile().getPath(), TextFormatting.YELLOW));
			}
		}
	}

	private void addBoundScript(EntityPlayer player, IBoundScript bs, RunnableScript runnableScript,
			Entity clickedEntity) {
		if (bs.getScriptList().contains(runnableScript)) {
			player.sendMessage(Util.withColor("ms3.stick.cantAddDuplicate", TextFormatting.RED));
		} else {
			if(MS3.getInterpreter().runOnBind(runnableScript, player, clickedEntity)) {
				bs.addScript(runnableScript);				
				player.sendMessage(Util.withColor("ms3.stick.successfulBind", TextFormatting.GREEN));
			} else {
				// More code because it must be in bold.
				ITextComponent itc = new TextComponentTranslation("ms3.stick.bindingError");
				itc.getStyle().setBold(true).setColor(TextFormatting.RED);
				player.sendMessage(itc);
			}
		}
	}

	private void removeBoundScript(EntityPlayer player, IBoundScript bs, RunnableScript runnableScript) {
		List<RunnableScript> list = bs.getScriptList();
		if (list.contains(runnableScript)) {
			list.remove(runnableScript);
		} else {
			player.sendMessage(Util.withColor("ms3.stick.noScriptOnEntity", TextFormatting.RED));
		}
	}
}
