package com.codeshaper.ms3;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import com.codeshaper.ms3.api.biomes;
import com.codeshaper.ms3.api.blocks;
import com.codeshaper.ms3.api.items;
import com.codeshaper.ms3.api.sounds;
import com.codeshaper.ms3.apiBuilder.ApiBuilder;
import com.codeshaper.ms3.bindScriptAction.BindScriptAction;
import com.codeshaper.ms3.command.CommandBindScript;
import com.codeshaper.ms3.command.CommandScript;
import com.codeshaper.ms3.interpreter.PyInterpreter;
import com.codeshaper.ms3.items.ItemScriptBinder;
import com.codeshaper.ms3.proxy.ProxyCommon;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = MS3.MOD_ID, name = "MS3", version = MS3.VERSION)
public class MS3 {

	public static final String MOD_ID = "ms3";
	/** String identifier for the version.  Changes with every update. */
	public static final String VERSION = "Beta_1_0";
	public static final String AUTHOR = "codeshaper";

	@Mod.Instance(MOD_ID)
	public static MS3 instance;

	@SidedProxy(clientSide = "com.codeshaper.ms3.proxy.ProxyClient", serverSide = "com.codeshaper.ms3.proxy.ProxyCommon")
	public static ProxyCommon proxy;

	public static DirectoryManager dirManager;
	public static Config configManager;
	public static ApiBuilder apiBuilder;

	/** Reference to the script binder item. */
	public static ItemScriptBinder itemScriptBinder = new ItemScriptBinder("script_binder");

	/** Hashmap of actions set by players through the bindScript command. Note, null on the client side! */
	public static HashMap<UUID, BindScriptAction> players = new HashMap<>();

	/**
	 * Single reference to the Python Interpreter. Note, null on the client side.
	 */
	public PyInterpreter interpreter;


	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MS3.dirManager = new DirectoryManager(event);
		MS3.configManager = new Config(new File(MS3.dirManager.ms3Folder, "config.cfg"));
		MS3.apiBuilder = new ApiBuilder();
		this.interpreter = new PyInterpreter("default");
		
		// Make sure the classes are loaded by the class loader before Jython tries to
		// look up a field with reflection.
		biomes.getAllBiomes();
		blocks.getAllBlocks();
		items.getAllItems();
		sounds.getAllSounds();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		this.proxy.init();

		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {		
		MS3.apiBuilder.buildApiIfNeeded();
	}

	@Mod.EventBusSubscriber
	public static class RegistrationHandler {

		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			event.getRegistry().register(itemScriptBinder);
		}

		@SubscribeEvent
		public static void registerItem(ModelRegistryEvent event) {
			MS3.proxy.registerItemRenderer(MS3.itemScriptBinder, 0, MS3.itemScriptBinder.registryName);
		}
	}

	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandBindScript());
		event.registerServerCommand(new CommandScript());
	}

	public static PyInterpreter getInterpreter() {
		return MS3.instance.interpreter;
	}

	// ClassLoader cl = Loader.instance().getModClassLoader();
}