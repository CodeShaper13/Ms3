package com.codeshaper.ms3;

import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.UUID;

import com.codeshaper.ms3.api.biomes;
import com.codeshaper.ms3.api.blocks;
import com.codeshaper.ms3.api.items;
import com.codeshaper.ms3.api.sounds;
import com.codeshaper.ms3.apiBuilder.ApiBuilder;
import com.codeshaper.ms3.bindScriptAction.BindScriptAction;
import com.codeshaper.ms3.command.CommandBindScript;
import com.codeshaper.ms3.command.CommandExec;
import com.codeshaper.ms3.command.CommandScript;
import com.codeshaper.ms3.drawing.EventHandlerDrawing;
import com.codeshaper.ms3.interpreter.PyInterpreter;
import com.codeshaper.ms3.interpreter.PyInterpreterManager;
import com.codeshaper.ms3.items.ItemScriptBinder;
import com.codeshaper.ms3.proxy.ProxyCommon;
import com.codeshaper.ms3.update.Release;
import com.codeshaper.ms3.update.UpdateChecker;
import com.codeshaper.ms3.update.Version;
import com.google.gson.stream.MalformedJsonException;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
 * DEVELOPER NOTE:
 * If the parameter names are arg followed by a number in the generated Python files,
 * you need to setX under Project -> Properties -> Java Compiler -> Store information
 * about method parameters.
 */

/**
 * Main class for the Ms3 mod.
 * 
 * @author CodeShaper
 */
@Mod(modid = Ms3.MOD_ID, name = Ms3.MOD_ID, version = Ms3.MOD_VERSION, dependencies = "after:*")
public class Ms3 {

	public static boolean DEBUG_MODE = true;

	public static final String MOD_NAME = "Ms3";
	public static final String MOD_ID = "ms3";
	public static final String AUTHOR = "codeshaper";
	/** String identifier for the version. Make sure to update mcmod.info */
	public static final String MOD_VERSION = "1.0.0";
	public static final Version API_VERSION = new Version(1, 0, 0);
	public static final Version RELEASE = new Version(Ms3.MOD_VERSION);

	@Mod.Instance(Ms3.MOD_ID)
	public static Ms3 instance;

	@SidedProxy(clientSide = "com.codeshaper.ms3.proxy.ProxyClient", serverSide = "com.codeshaper.ms3.proxy.ProxyCommon")
	public static ProxyCommon proxy;

	public static DirectoryManager dirManager;
	public static Ms3Properties ms3Props;
	public static Config configManager;
	public static ApiBuilder apiBuilder;
	public static UpdateChecker updateChecker;

	/** Reference to the script binder item. */
	public static ItemScriptBinder itemScriptBinder = new ItemScriptBinder("script_binder");

	/**
	 * Hashmap of actions set by players through the bindScript command. This is null
	 * on the client side!
	 */
	public static HashMap<UUID, BindScriptAction> players = new HashMap<>();

	/** Singleton reference to the Python Interpreter.  This is null on the client side. */
	public PyInterpreterManager interpreterManager;

	// Used to debug the update checker.
	public static void main(String[] args) throws MalformedURLException, NumberFormatException, MalformedJsonException {
		Ms3.updateChecker = new UpdateChecker("https://raw.githubusercontent.com/CodeShaper13/Ms3/master/src/main/java/version.json");
		System.out.println("Is outdates: " + Ms3.updateChecker.isOutdated(new Version(Ms3.MOD_VERSION)));
	}
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) throws MalformedURLException {
		Ms3.dirManager = new DirectoryManager(event);
		Ms3.ms3Props = new Ms3Properties();
		Ms3.configManager = new Config(new File(Ms3.dirManager.getMs3Folder(), "config.cfg"));
		Ms3.apiBuilder = new ApiBuilder(Ms3.dirManager.getApiFolder());
		
		this.interpreterManager = new PyInterpreterManager();

		// Make sure the classes are loaded by the class loader before Jython tries to
		// look up a field with reflection.
		biomes.getAllBiomes();
		blocks.getAllBlocks();
		items.getAllItems();
		sounds.getAllSounds();
		
		Ms3.updateChecker = new UpdateChecker("https://raw.githubusercontent.com/CodeShaper13/Ms3/master/src/main/java/version.json");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		Ms3.proxy.init();

		MinecraftForge.EVENT_BUS.register(new EventHandler());
		MinecraftForge.EVENT_BUS.register(new EventHandlerDrawing());
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Ms3.apiBuilder.buildApiIfNeeded();
	}

	@Mod.EventBusSubscriber
	public static class RegistrationHandler {

		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			event.getRegistry().register(itemScriptBinder);
		}

		@SubscribeEvent
		public static void registerItem(ModelRegistryEvent event) {
			Ms3.proxy.registerItemRenderer(Ms3.itemScriptBinder, 0, Ms3.itemScriptBinder.registryName);
		}
	}

	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandBindScript());
		event.registerServerCommand(new CommandScript());
		event.registerServerCommand(new CommandExec());
	}
	
	/**
	 * Gets the Default (and currently only) interpreter to use for running scripts.
	 */
	public static PyInterpreter getDefaultInterpreter() {
		return Ms3.instance.interpreterManager.getInterpreter(PyInterpreterManager.DEFAULT_NAME);
	}

	// ClassLoader cl = Loader.instance().getModClassLoader();
}