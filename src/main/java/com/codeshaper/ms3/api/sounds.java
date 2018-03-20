package com.codeshaper.ms3.api;

import org.python.core.PyString;
import org.python.core.PyList;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonField;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

@PythonClass
@PythonDocString("A list of all the vanilla Sound names.")
public class sounds {

    private static PyList names = new PyList();

    private sounds() { }

    @PythonField("minecraft:ambient.cave")
    public static final String AMBIENT_CAVE = func("minecraft:ambient.cave");
    @PythonField("minecraft:block.anvil.break")
    public static final String BLOCK_ANVIL_BREAK = func("minecraft:block.anvil.break");
    @PythonField("minecraft:block.anvil.destroy")
    public static final String BLOCK_ANVIL_DESTROY = func("minecraft:block.anvil.destroy");
    @PythonField("minecraft:block.anvil.fall")
    public static final String BLOCK_ANVIL_FALL = func("minecraft:block.anvil.fall");
    @PythonField("minecraft:block.anvil.hit")
    public static final String BLOCK_ANVIL_HIT = func("minecraft:block.anvil.hit");
    @PythonField("minecraft:block.anvil.land")
    public static final String BLOCK_ANVIL_LAND = func("minecraft:block.anvil.land");
    @PythonField("minecraft:block.anvil.place")
    public static final String BLOCK_ANVIL_PLACE = func("minecraft:block.anvil.place");
    @PythonField("minecraft:block.anvil.step")
    public static final String BLOCK_ANVIL_STEP = func("minecraft:block.anvil.step");
    @PythonField("minecraft:block.anvil.use")
    public static final String BLOCK_ANVIL_USE = func("minecraft:block.anvil.use");
    @PythonField("minecraft:block.brewing_stand.brew")
    public static final String BLOCK_BREWING_STAND_BREW = func("minecraft:block.brewing_stand.brew");
    @PythonField("minecraft:block.chest.close")
    public static final String BLOCK_CHEST_CLOSE = func("minecraft:block.chest.close");
    @PythonField("minecraft:block.chest.locked")
    public static final String BLOCK_CHEST_LOCKED = func("minecraft:block.chest.locked");
    @PythonField("minecraft:block.chest.open")
    public static final String BLOCK_CHEST_OPEN = func("minecraft:block.chest.open");
    @PythonField("minecraft:block.chorus_flower.death")
    public static final String BLOCK_CHORUS_FLOWER_DEATH = func("minecraft:block.chorus_flower.death");
    @PythonField("minecraft:block.chorus_flower.grow")
    public static final String BLOCK_CHORUS_FLOWER_GROW = func("minecraft:block.chorus_flower.grow");
    @PythonField("minecraft:block.cloth.break")
    public static final String BLOCK_CLOTH_BREAK = func("minecraft:block.cloth.break");
    @PythonField("minecraft:block.cloth.fall")
    public static final String BLOCK_CLOTH_FALL = func("minecraft:block.cloth.fall");
    @PythonField("minecraft:block.cloth.hit")
    public static final String BLOCK_CLOTH_HIT = func("minecraft:block.cloth.hit");
    @PythonField("minecraft:block.cloth.place")
    public static final String BLOCK_CLOTH_PLACE = func("minecraft:block.cloth.place");
    @PythonField("minecraft:block.cloth.step")
    public static final String BLOCK_CLOTH_STEP = func("minecraft:block.cloth.step");
    @PythonField("minecraft:block.comparator.click")
    public static final String BLOCK_COMPARATOR_CLICK = func("minecraft:block.comparator.click");
    @PythonField("minecraft:block.dispenser.dispense")
    public static final String BLOCK_DISPENSER_DISPENSE = func("minecraft:block.dispenser.dispense");
    @PythonField("minecraft:block.dispenser.fail")
    public static final String BLOCK_DISPENSER_FAIL = func("minecraft:block.dispenser.fail");
    @PythonField("minecraft:block.dispenser.launch")
    public static final String BLOCK_DISPENSER_LAUNCH = func("minecraft:block.dispenser.launch");
    @PythonField("minecraft:block.enchantment_table.use")
    public static final String BLOCK_ENCHANTMENT_TABLE_USE = func("minecraft:block.enchantment_table.use");
    @PythonField("minecraft:block.end_gateway.spawn")
    public static final String BLOCK_END_GATEWAY_SPAWN = func("minecraft:block.end_gateway.spawn");
    @PythonField("minecraft:block.end_portal.spawn")
    public static final String BLOCK_END_PORTAL_SPAWN = func("minecraft:block.end_portal.spawn");
    @PythonField("minecraft:block.end_portal_frame.fill")
    public static final String BLOCK_END_PORTAL_FRAME_FILL = func("minecraft:block.end_portal_frame.fill");
    @PythonField("minecraft:block.enderchest.close")
    public static final String BLOCK_ENDERCHEST_CLOSE = func("minecraft:block.enderchest.close");
    @PythonField("minecraft:block.enderchest.open")
    public static final String BLOCK_ENDERCHEST_OPEN = func("minecraft:block.enderchest.open");
    @PythonField("minecraft:block.fence_gate.close")
    public static final String BLOCK_FENCE_GATE_CLOSE = func("minecraft:block.fence_gate.close");
    @PythonField("minecraft:block.fence_gate.open")
    public static final String BLOCK_FENCE_GATE_OPEN = func("minecraft:block.fence_gate.open");
    @PythonField("minecraft:block.fire.ambient")
    public static final String BLOCK_FIRE_AMBIENT = func("minecraft:block.fire.ambient");
    @PythonField("minecraft:block.fire.extinguish")
    public static final String BLOCK_FIRE_EXTINGUISH = func("minecraft:block.fire.extinguish");
    @PythonField("minecraft:block.furnace.fire_crackle")
    public static final String BLOCK_FURNACE_FIRE_CRACKLE = func("minecraft:block.furnace.fire_crackle");
    @PythonField("minecraft:block.glass.break")
    public static final String BLOCK_GLASS_BREAK = func("minecraft:block.glass.break");
    @PythonField("minecraft:block.glass.fall")
    public static final String BLOCK_GLASS_FALL = func("minecraft:block.glass.fall");
    @PythonField("minecraft:block.glass.hit")
    public static final String BLOCK_GLASS_HIT = func("minecraft:block.glass.hit");
    @PythonField("minecraft:block.glass.place")
    public static final String BLOCK_GLASS_PLACE = func("minecraft:block.glass.place");
    @PythonField("minecraft:block.glass.step")
    public static final String BLOCK_GLASS_STEP = func("minecraft:block.glass.step");
    @PythonField("minecraft:block.grass.break")
    public static final String BLOCK_GRASS_BREAK = func("minecraft:block.grass.break");
    @PythonField("minecraft:block.grass.fall")
    public static final String BLOCK_GRASS_FALL = func("minecraft:block.grass.fall");
    @PythonField("minecraft:block.grass.hit")
    public static final String BLOCK_GRASS_HIT = func("minecraft:block.grass.hit");
    @PythonField("minecraft:block.grass.place")
    public static final String BLOCK_GRASS_PLACE = func("minecraft:block.grass.place");
    @PythonField("minecraft:block.grass.step")
    public static final String BLOCK_GRASS_STEP = func("minecraft:block.grass.step");
    @PythonField("minecraft:block.gravel.break")
    public static final String BLOCK_GRAVEL_BREAK = func("minecraft:block.gravel.break");
    @PythonField("minecraft:block.gravel.fall")
    public static final String BLOCK_GRAVEL_FALL = func("minecraft:block.gravel.fall");
    @PythonField("minecraft:block.gravel.hit")
    public static final String BLOCK_GRAVEL_HIT = func("minecraft:block.gravel.hit");
    @PythonField("minecraft:block.gravel.place")
    public static final String BLOCK_GRAVEL_PLACE = func("minecraft:block.gravel.place");
    @PythonField("minecraft:block.gravel.step")
    public static final String BLOCK_GRAVEL_STEP = func("minecraft:block.gravel.step");
    @PythonField("minecraft:block.iron_door.close")
    public static final String BLOCK_IRON_DOOR_CLOSE = func("minecraft:block.iron_door.close");
    @PythonField("minecraft:block.iron_door.open")
    public static final String BLOCK_IRON_DOOR_OPEN = func("minecraft:block.iron_door.open");
    @PythonField("minecraft:block.iron_trapdoor.close")
    public static final String BLOCK_IRON_TRAPDOOR_CLOSE = func("minecraft:block.iron_trapdoor.close");
    @PythonField("minecraft:block.iron_trapdoor.open")
    public static final String BLOCK_IRON_TRAPDOOR_OPEN = func("minecraft:block.iron_trapdoor.open");
    @PythonField("minecraft:block.ladder.break")
    public static final String BLOCK_LADDER_BREAK = func("minecraft:block.ladder.break");
    @PythonField("minecraft:block.ladder.fall")
    public static final String BLOCK_LADDER_FALL = func("minecraft:block.ladder.fall");
    @PythonField("minecraft:block.ladder.hit")
    public static final String BLOCK_LADDER_HIT = func("minecraft:block.ladder.hit");
    @PythonField("minecraft:block.ladder.place")
    public static final String BLOCK_LADDER_PLACE = func("minecraft:block.ladder.place");
    @PythonField("minecraft:block.ladder.step")
    public static final String BLOCK_LADDER_STEP = func("minecraft:block.ladder.step");
    @PythonField("minecraft:block.lava.ambient")
    public static final String BLOCK_LAVA_AMBIENT = func("minecraft:block.lava.ambient");
    @PythonField("minecraft:block.lava.extinguish")
    public static final String BLOCK_LAVA_EXTINGUISH = func("minecraft:block.lava.extinguish");
    @PythonField("minecraft:block.lava.pop")
    public static final String BLOCK_LAVA_POP = func("minecraft:block.lava.pop");
    @PythonField("minecraft:block.lever.click")
    public static final String BLOCK_LEVER_CLICK = func("minecraft:block.lever.click");
    @PythonField("minecraft:block.metal.break")
    public static final String BLOCK_METAL_BREAK = func("minecraft:block.metal.break");
    @PythonField("minecraft:block.metal.fall")
    public static final String BLOCK_METAL_FALL = func("minecraft:block.metal.fall");
    @PythonField("minecraft:block.metal.hit")
    public static final String BLOCK_METAL_HIT = func("minecraft:block.metal.hit");
    @PythonField("minecraft:block.metal.place")
    public static final String BLOCK_METAL_PLACE = func("minecraft:block.metal.place");
    @PythonField("minecraft:block.metal.step")
    public static final String BLOCK_METAL_STEP = func("minecraft:block.metal.step");
    @PythonField("minecraft:block.metal_pressureplate.click_off")
    public static final String BLOCK_METAL_PRESSUREPLATE_CLICK_OFF = func("minecraft:block.metal_pressureplate.click_off");
    @PythonField("minecraft:block.metal_pressureplate.click_on")
    public static final String BLOCK_METAL_PRESSUREPLATE_CLICK_ON = func("minecraft:block.metal_pressureplate.click_on");
    @PythonField("minecraft:block.note.basedrum")
    public static final String BLOCK_NOTE_BASEDRUM = func("minecraft:block.note.basedrum");
    @PythonField("minecraft:block.note.bass")
    public static final String BLOCK_NOTE_BASS = func("minecraft:block.note.bass");
    @PythonField("minecraft:block.note.bell")
    public static final String BLOCK_NOTE_BELL = func("minecraft:block.note.bell");
    @PythonField("minecraft:block.note.chime")
    public static final String BLOCK_NOTE_CHIME = func("minecraft:block.note.chime");
    @PythonField("minecraft:block.note.flute")
    public static final String BLOCK_NOTE_FLUTE = func("minecraft:block.note.flute");
    @PythonField("minecraft:block.note.guitar")
    public static final String BLOCK_NOTE_GUITAR = func("minecraft:block.note.guitar");
    @PythonField("minecraft:block.note.harp")
    public static final String BLOCK_NOTE_HARP = func("minecraft:block.note.harp");
    @PythonField("minecraft:block.note.hat")
    public static final String BLOCK_NOTE_HAT = func("minecraft:block.note.hat");
    @PythonField("minecraft:block.note.pling")
    public static final String BLOCK_NOTE_PLING = func("minecraft:block.note.pling");
    @PythonField("minecraft:block.note.snare")
    public static final String BLOCK_NOTE_SNARE = func("minecraft:block.note.snare");
    @PythonField("minecraft:block.note.xylophone")
    public static final String BLOCK_NOTE_XYLOPHONE = func("minecraft:block.note.xylophone");
    @PythonField("minecraft:block.piston.contract")
    public static final String BLOCK_PISTON_CONTRACT = func("minecraft:block.piston.contract");
    @PythonField("minecraft:block.piston.extend")
    public static final String BLOCK_PISTON_EXTEND = func("minecraft:block.piston.extend");
    @PythonField("minecraft:block.portal.ambient")
    public static final String BLOCK_PORTAL_AMBIENT = func("minecraft:block.portal.ambient");
    @PythonField("minecraft:block.portal.travel")
    public static final String BLOCK_PORTAL_TRAVEL = func("minecraft:block.portal.travel");
    @PythonField("minecraft:block.portal.trigger")
    public static final String BLOCK_PORTAL_TRIGGER = func("minecraft:block.portal.trigger");
    @PythonField("minecraft:block.redstone_torch.burnout")
    public static final String BLOCK_REDSTONE_TORCH_BURNOUT = func("minecraft:block.redstone_torch.burnout");
    @PythonField("minecraft:block.sand.break")
    public static final String BLOCK_SAND_BREAK = func("minecraft:block.sand.break");
    @PythonField("minecraft:block.sand.fall")
    public static final String BLOCK_SAND_FALL = func("minecraft:block.sand.fall");
    @PythonField("minecraft:block.sand.hit")
    public static final String BLOCK_SAND_HIT = func("minecraft:block.sand.hit");
    @PythonField("minecraft:block.sand.place")
    public static final String BLOCK_SAND_PLACE = func("minecraft:block.sand.place");
    @PythonField("minecraft:block.sand.step")
    public static final String BLOCK_SAND_STEP = func("minecraft:block.sand.step");
    @PythonField("minecraft:block.shulker_box.close")
    public static final String BLOCK_SHULKER_BOX_CLOSE = func("minecraft:block.shulker_box.close");
    @PythonField("minecraft:block.shulker_box.open")
    public static final String BLOCK_SHULKER_BOX_OPEN = func("minecraft:block.shulker_box.open");
    @PythonField("minecraft:block.slime.break")
    public static final String BLOCK_SLIME_BREAK = func("minecraft:block.slime.break");
    @PythonField("minecraft:block.slime.fall")
    public static final String BLOCK_SLIME_FALL = func("minecraft:block.slime.fall");
    @PythonField("minecraft:block.slime.hit")
    public static final String BLOCK_SLIME_HIT = func("minecraft:block.slime.hit");
    @PythonField("minecraft:block.slime.place")
    public static final String BLOCK_SLIME_PLACE = func("minecraft:block.slime.place");
    @PythonField("minecraft:block.slime.step")
    public static final String BLOCK_SLIME_STEP = func("minecraft:block.slime.step");
    @PythonField("minecraft:block.snow.break")
    public static final String BLOCK_SNOW_BREAK = func("minecraft:block.snow.break");
    @PythonField("minecraft:block.snow.fall")
    public static final String BLOCK_SNOW_FALL = func("minecraft:block.snow.fall");
    @PythonField("minecraft:block.snow.hit")
    public static final String BLOCK_SNOW_HIT = func("minecraft:block.snow.hit");
    @PythonField("minecraft:block.snow.place")
    public static final String BLOCK_SNOW_PLACE = func("minecraft:block.snow.place");
    @PythonField("minecraft:block.snow.step")
    public static final String BLOCK_SNOW_STEP = func("minecraft:block.snow.step");
    @PythonField("minecraft:block.stone.break")
    public static final String BLOCK_STONE_BREAK = func("minecraft:block.stone.break");
    @PythonField("minecraft:block.stone.fall")
    public static final String BLOCK_STONE_FALL = func("minecraft:block.stone.fall");
    @PythonField("minecraft:block.stone.hit")
    public static final String BLOCK_STONE_HIT = func("minecraft:block.stone.hit");
    @PythonField("minecraft:block.stone.place")
    public static final String BLOCK_STONE_PLACE = func("minecraft:block.stone.place");
    @PythonField("minecraft:block.stone.step")
    public static final String BLOCK_STONE_STEP = func("minecraft:block.stone.step");
    @PythonField("minecraft:block.stone_button.click_off")
    public static final String BLOCK_STONE_BUTTON_CLICK_OFF = func("minecraft:block.stone_button.click_off");
    @PythonField("minecraft:block.stone_button.click_on")
    public static final String BLOCK_STONE_BUTTON_CLICK_ON = func("minecraft:block.stone_button.click_on");
    @PythonField("minecraft:block.stone_pressureplate.click_off")
    public static final String BLOCK_STONE_PRESSUREPLATE_CLICK_OFF = func("minecraft:block.stone_pressureplate.click_off");
    @PythonField("minecraft:block.stone_pressureplate.click_on")
    public static final String BLOCK_STONE_PRESSUREPLATE_CLICK_ON = func("minecraft:block.stone_pressureplate.click_on");
    @PythonField("minecraft:block.tripwire.attach")
    public static final String BLOCK_TRIPWIRE_ATTACH = func("minecraft:block.tripwire.attach");
    @PythonField("minecraft:block.tripwire.click_off")
    public static final String BLOCK_TRIPWIRE_CLICK_OFF = func("minecraft:block.tripwire.click_off");
    @PythonField("minecraft:block.tripwire.click_on")
    public static final String BLOCK_TRIPWIRE_CLICK_ON = func("minecraft:block.tripwire.click_on");
    @PythonField("minecraft:block.tripwire.detach")
    public static final String BLOCK_TRIPWIRE_DETACH = func("minecraft:block.tripwire.detach");
    @PythonField("minecraft:block.water.ambient")
    public static final String BLOCK_WATER_AMBIENT = func("minecraft:block.water.ambient");
    @PythonField("minecraft:block.waterlily.place")
    public static final String BLOCK_WATERLILY_PLACE = func("minecraft:block.waterlily.place");
    @PythonField("minecraft:block.wood.break")
    public static final String BLOCK_WOOD_BREAK = func("minecraft:block.wood.break");
    @PythonField("minecraft:block.wood.fall")
    public static final String BLOCK_WOOD_FALL = func("minecraft:block.wood.fall");
    @PythonField("minecraft:block.wood.hit")
    public static final String BLOCK_WOOD_HIT = func("minecraft:block.wood.hit");
    @PythonField("minecraft:block.wood.place")
    public static final String BLOCK_WOOD_PLACE = func("minecraft:block.wood.place");
    @PythonField("minecraft:block.wood.step")
    public static final String BLOCK_WOOD_STEP = func("minecraft:block.wood.step");
    @PythonField("minecraft:block.wood_button.click_off")
    public static final String BLOCK_WOOD_BUTTON_CLICK_OFF = func("minecraft:block.wood_button.click_off");
    @PythonField("minecraft:block.wood_button.click_on")
    public static final String BLOCK_WOOD_BUTTON_CLICK_ON = func("minecraft:block.wood_button.click_on");
    @PythonField("minecraft:block.wood_pressureplate.click_off")
    public static final String BLOCK_WOOD_PRESSUREPLATE_CLICK_OFF = func("minecraft:block.wood_pressureplate.click_off");
    @PythonField("minecraft:block.wood_pressureplate.click_on")
    public static final String BLOCK_WOOD_PRESSUREPLATE_CLICK_ON = func("minecraft:block.wood_pressureplate.click_on");
    @PythonField("minecraft:block.wooden_door.close")
    public static final String BLOCK_WOODEN_DOOR_CLOSE = func("minecraft:block.wooden_door.close");
    @PythonField("minecraft:block.wooden_door.open")
    public static final String BLOCK_WOODEN_DOOR_OPEN = func("minecraft:block.wooden_door.open");
    @PythonField("minecraft:block.wooden_trapdoor.close")
    public static final String BLOCK_WOODEN_TRAPDOOR_CLOSE = func("minecraft:block.wooden_trapdoor.close");
    @PythonField("minecraft:block.wooden_trapdoor.open")
    public static final String BLOCK_WOODEN_TRAPDOOR_OPEN = func("minecraft:block.wooden_trapdoor.open");
    @PythonField("minecraft:enchant.thorns.hit")
    public static final String ENCHANT_THORNS_HIT = func("minecraft:enchant.thorns.hit");
    @PythonField("minecraft:entity.armorstand.break")
    public static final String ENTITY_ARMORSTAND_BREAK = func("minecraft:entity.armorstand.break");
    @PythonField("minecraft:entity.armorstand.fall")
    public static final String ENTITY_ARMORSTAND_FALL = func("minecraft:entity.armorstand.fall");
    @PythonField("minecraft:entity.armorstand.hit")
    public static final String ENTITY_ARMORSTAND_HIT = func("minecraft:entity.armorstand.hit");
    @PythonField("minecraft:entity.armorstand.place")
    public static final String ENTITY_ARMORSTAND_PLACE = func("minecraft:entity.armorstand.place");
    @PythonField("minecraft:entity.arrow.hit")
    public static final String ENTITY_ARROW_HIT = func("minecraft:entity.arrow.hit");
    @PythonField("minecraft:entity.arrow.hit_player")
    public static final String ENTITY_ARROW_HIT_PLAYER = func("minecraft:entity.arrow.hit_player");
    @PythonField("minecraft:entity.arrow.shoot")
    public static final String ENTITY_ARROW_SHOOT = func("minecraft:entity.arrow.shoot");
    @PythonField("minecraft:entity.bat.ambient")
    public static final String ENTITY_BAT_AMBIENT = func("minecraft:entity.bat.ambient");
    @PythonField("minecraft:entity.bat.death")
    public static final String ENTITY_BAT_DEATH = func("minecraft:entity.bat.death");
    @PythonField("minecraft:entity.bat.hurt")
    public static final String ENTITY_BAT_HURT = func("minecraft:entity.bat.hurt");
    @PythonField("minecraft:entity.bat.loop")
    public static final String ENTITY_BAT_LOOP = func("minecraft:entity.bat.loop");
    @PythonField("minecraft:entity.bat.takeoff")
    public static final String ENTITY_BAT_TAKEOFF = func("minecraft:entity.bat.takeoff");
    @PythonField("minecraft:entity.blaze.ambient")
    public static final String ENTITY_BLAZE_AMBIENT = func("minecraft:entity.blaze.ambient");
    @PythonField("minecraft:entity.blaze.burn")
    public static final String ENTITY_BLAZE_BURN = func("minecraft:entity.blaze.burn");
    @PythonField("minecraft:entity.blaze.death")
    public static final String ENTITY_BLAZE_DEATH = func("minecraft:entity.blaze.death");
    @PythonField("minecraft:entity.blaze.hurt")
    public static final String ENTITY_BLAZE_HURT = func("minecraft:entity.blaze.hurt");
    @PythonField("minecraft:entity.blaze.shoot")
    public static final String ENTITY_BLAZE_SHOOT = func("minecraft:entity.blaze.shoot");
    @PythonField("minecraft:entity.boat.paddle_land")
    public static final String ENTITY_BOAT_PADDLE_LAND = func("minecraft:entity.boat.paddle_land");
    @PythonField("minecraft:entity.boat.paddle_water")
    public static final String ENTITY_BOAT_PADDLE_WATER = func("minecraft:entity.boat.paddle_water");
    @PythonField("minecraft:entity.bobber.retrieve")
    public static final String ENTITY_BOBBER_RETRIEVE = func("minecraft:entity.bobber.retrieve");
    @PythonField("minecraft:entity.bobber.splash")
    public static final String ENTITY_BOBBER_SPLASH = func("minecraft:entity.bobber.splash");
    @PythonField("minecraft:entity.bobber.throw")
    public static final String ENTITY_BOBBER_THROW = func("minecraft:entity.bobber.throw");
    @PythonField("minecraft:entity.cat.ambient")
    public static final String ENTITY_CAT_AMBIENT = func("minecraft:entity.cat.ambient");
    @PythonField("minecraft:entity.cat.death")
    public static final String ENTITY_CAT_DEATH = func("minecraft:entity.cat.death");
    @PythonField("minecraft:entity.cat.hiss")
    public static final String ENTITY_CAT_HISS = func("minecraft:entity.cat.hiss");
    @PythonField("minecraft:entity.cat.hurt")
    public static final String ENTITY_CAT_HURT = func("minecraft:entity.cat.hurt");
    @PythonField("minecraft:entity.cat.purr")
    public static final String ENTITY_CAT_PURR = func("minecraft:entity.cat.purr");
    @PythonField("minecraft:entity.cat.purreow")
    public static final String ENTITY_CAT_PURREOW = func("minecraft:entity.cat.purreow");
    @PythonField("minecraft:entity.chicken.ambient")
    public static final String ENTITY_CHICKEN_AMBIENT = func("minecraft:entity.chicken.ambient");
    @PythonField("minecraft:entity.chicken.death")
    public static final String ENTITY_CHICKEN_DEATH = func("minecraft:entity.chicken.death");
    @PythonField("minecraft:entity.chicken.egg")
    public static final String ENTITY_CHICKEN_EGG = func("minecraft:entity.chicken.egg");
    @PythonField("minecraft:entity.chicken.hurt")
    public static final String ENTITY_CHICKEN_HURT = func("minecraft:entity.chicken.hurt");
    @PythonField("minecraft:entity.chicken.step")
    public static final String ENTITY_CHICKEN_STEP = func("minecraft:entity.chicken.step");
    @PythonField("minecraft:entity.cow.ambient")
    public static final String ENTITY_COW_AMBIENT = func("minecraft:entity.cow.ambient");
    @PythonField("minecraft:entity.cow.death")
    public static final String ENTITY_COW_DEATH = func("minecraft:entity.cow.death");
    @PythonField("minecraft:entity.cow.hurt")
    public static final String ENTITY_COW_HURT = func("minecraft:entity.cow.hurt");
    @PythonField("minecraft:entity.cow.milk")
    public static final String ENTITY_COW_MILK = func("minecraft:entity.cow.milk");
    @PythonField("minecraft:entity.cow.step")
    public static final String ENTITY_COW_STEP = func("minecraft:entity.cow.step");
    @PythonField("minecraft:entity.creeper.death")
    public static final String ENTITY_CREEPER_DEATH = func("minecraft:entity.creeper.death");
    @PythonField("minecraft:entity.creeper.hurt")
    public static final String ENTITY_CREEPER_HURT = func("minecraft:entity.creeper.hurt");
    @PythonField("minecraft:entity.creeper.primed")
    public static final String ENTITY_CREEPER_PRIMED = func("minecraft:entity.creeper.primed");
    @PythonField("minecraft:entity.donkey.ambient")
    public static final String ENTITY_DONKEY_AMBIENT = func("minecraft:entity.donkey.ambient");
    @PythonField("minecraft:entity.donkey.angry")
    public static final String ENTITY_DONKEY_ANGRY = func("minecraft:entity.donkey.angry");
    @PythonField("minecraft:entity.donkey.chest")
    public static final String ENTITY_DONKEY_CHEST = func("minecraft:entity.donkey.chest");
    @PythonField("minecraft:entity.donkey.death")
    public static final String ENTITY_DONKEY_DEATH = func("minecraft:entity.donkey.death");
    @PythonField("minecraft:entity.donkey.hurt")
    public static final String ENTITY_DONKEY_HURT = func("minecraft:entity.donkey.hurt");
    @PythonField("minecraft:entity.egg.throw")
    public static final String ENTITY_EGG_THROW = func("minecraft:entity.egg.throw");
    @PythonField("minecraft:entity.elder_guardian.ambient")
    public static final String ENTITY_ELDER_GUARDIAN_AMBIENT = func("minecraft:entity.elder_guardian.ambient");
    @PythonField("minecraft:entity.elder_guardian.ambient_land")
    public static final String ENTITY_ELDER_GUARDIAN_AMBIENT_LAND = func("minecraft:entity.elder_guardian.ambient_land");
    @PythonField("minecraft:entity.elder_guardian.curse")
    public static final String ENTITY_ELDER_GUARDIAN_CURSE = func("minecraft:entity.elder_guardian.curse");
    @PythonField("minecraft:entity.elder_guardian.death")
    public static final String ENTITY_ELDER_GUARDIAN_DEATH = func("minecraft:entity.elder_guardian.death");
    @PythonField("minecraft:entity.elder_guardian.death_land")
    public static final String ENTITY_ELDER_GUARDIAN_DEATH_LAND = func("minecraft:entity.elder_guardian.death_land");
    @PythonField("minecraft:entity.elder_guardian.flop")
    public static final String ENTITY_ELDER_GUARDIAN_FLOP = func("minecraft:entity.elder_guardian.flop");
    @PythonField("minecraft:entity.elder_guardian.hurt")
    public static final String ENTITY_ELDER_GUARDIAN_HURT = func("minecraft:entity.elder_guardian.hurt");
    @PythonField("minecraft:entity.elder_guardian.hurt_land")
    public static final String ENTITY_ELDER_GUARDIAN_HURT_LAND = func("minecraft:entity.elder_guardian.hurt_land");
    @PythonField("minecraft:entity.enderdragon.ambient")
    public static final String ENTITY_ENDERDRAGON_AMBIENT = func("minecraft:entity.enderdragon.ambient");
    @PythonField("minecraft:entity.enderdragon.death")
    public static final String ENTITY_ENDERDRAGON_DEATH = func("minecraft:entity.enderdragon.death");
    @PythonField("minecraft:entity.enderdragon.flap")
    public static final String ENTITY_ENDERDRAGON_FLAP = func("minecraft:entity.enderdragon.flap");
    @PythonField("minecraft:entity.enderdragon.growl")
    public static final String ENTITY_ENDERDRAGON_GROWL = func("minecraft:entity.enderdragon.growl");
    @PythonField("minecraft:entity.enderdragon.hurt")
    public static final String ENTITY_ENDERDRAGON_HURT = func("minecraft:entity.enderdragon.hurt");
    @PythonField("minecraft:entity.enderdragon.shoot")
    public static final String ENTITY_ENDERDRAGON_SHOOT = func("minecraft:entity.enderdragon.shoot");
    @PythonField("minecraft:entity.enderdragon_fireball.explode")
    public static final String ENTITY_ENDERDRAGON_FIREBALL_EXPLODE = func("minecraft:entity.enderdragon_fireball.explode");
    @PythonField("minecraft:entity.endereye.death")
    public static final String ENTITY_ENDEREYE_DEATH = func("minecraft:entity.endereye.death");
    @PythonField("minecraft:entity.endereye.launch")
    public static final String ENTITY_ENDEREYE_LAUNCH = func("minecraft:entity.endereye.launch");
    @PythonField("minecraft:entity.endermen.ambient")
    public static final String ENTITY_ENDERMEN_AMBIENT = func("minecraft:entity.endermen.ambient");
    @PythonField("minecraft:entity.endermen.death")
    public static final String ENTITY_ENDERMEN_DEATH = func("minecraft:entity.endermen.death");
    @PythonField("minecraft:entity.endermen.hurt")
    public static final String ENTITY_ENDERMEN_HURT = func("minecraft:entity.endermen.hurt");
    @PythonField("minecraft:entity.endermen.scream")
    public static final String ENTITY_ENDERMEN_SCREAM = func("minecraft:entity.endermen.scream");
    @PythonField("minecraft:entity.endermen.stare")
    public static final String ENTITY_ENDERMEN_STARE = func("minecraft:entity.endermen.stare");
    @PythonField("minecraft:entity.endermen.teleport")
    public static final String ENTITY_ENDERMEN_TELEPORT = func("minecraft:entity.endermen.teleport");
    @PythonField("minecraft:entity.endermite.ambient")
    public static final String ENTITY_ENDERMITE_AMBIENT = func("minecraft:entity.endermite.ambient");
    @PythonField("minecraft:entity.endermite.death")
    public static final String ENTITY_ENDERMITE_DEATH = func("minecraft:entity.endermite.death");
    @PythonField("minecraft:entity.endermite.hurt")
    public static final String ENTITY_ENDERMITE_HURT = func("minecraft:entity.endermite.hurt");
    @PythonField("minecraft:entity.endermite.step")
    public static final String ENTITY_ENDERMITE_STEP = func("minecraft:entity.endermite.step");
    @PythonField("minecraft:entity.enderpearl.throw")
    public static final String ENTITY_ENDERPEARL_THROW = func("minecraft:entity.enderpearl.throw");
    @PythonField("minecraft:entity.evocation_fangs.attack")
    public static final String ENTITY_EVOCATION_FANGS_ATTACK = func("minecraft:entity.evocation_fangs.attack");
    @PythonField("minecraft:entity.evocation_illager.ambient")
    public static final String ENTITY_EVOCATION_ILLAGER_AMBIENT = func("minecraft:entity.evocation_illager.ambient");
    @PythonField("minecraft:entity.evocation_illager.cast_spell")
    public static final String ENTITY_EVOCATION_ILLAGER_CAST_SPELL = func("minecraft:entity.evocation_illager.cast_spell");
    @PythonField("minecraft:entity.evocation_illager.death")
    public static final String ENTITY_EVOCATION_ILLAGER_DEATH = func("minecraft:entity.evocation_illager.death");
    @PythonField("minecraft:entity.evocation_illager.hurt")
    public static final String ENTITY_EVOCATION_ILLAGER_HURT = func("minecraft:entity.evocation_illager.hurt");
    @PythonField("minecraft:entity.evocation_illager.prepare_attack")
    public static final String ENTITY_EVOCATION_ILLAGER_PREPARE_ATTACK = func("minecraft:entity.evocation_illager.prepare_attack");
    @PythonField("minecraft:entity.evocation_illager.prepare_summon")
    public static final String ENTITY_EVOCATION_ILLAGER_PREPARE_SUMMON = func("minecraft:entity.evocation_illager.prepare_summon");
    @PythonField("minecraft:entity.evocation_illager.prepare_wololo")
    public static final String ENTITY_EVOCATION_ILLAGER_PREPARE_WOLOLO = func("minecraft:entity.evocation_illager.prepare_wololo");
    @PythonField("minecraft:entity.experience_bottle.throw")
    public static final String ENTITY_EXPERIENCE_BOTTLE_THROW = func("minecraft:entity.experience_bottle.throw");
    @PythonField("minecraft:entity.experience_orb.pickup")
    public static final String ENTITY_EXPERIENCE_ORB_PICKUP = func("minecraft:entity.experience_orb.pickup");
    @PythonField("minecraft:entity.firework.blast")
    public static final String ENTITY_FIREWORK_BLAST = func("minecraft:entity.firework.blast");
    @PythonField("minecraft:entity.firework.blast_far")
    public static final String ENTITY_FIREWORK_BLAST_FAR = func("minecraft:entity.firework.blast_far");
    @PythonField("minecraft:entity.firework.large_blast")
    public static final String ENTITY_FIREWORK_LARGE_BLAST = func("minecraft:entity.firework.large_blast");
    @PythonField("minecraft:entity.firework.large_blast_far")
    public static final String ENTITY_FIREWORK_LARGE_BLAST_FAR = func("minecraft:entity.firework.large_blast_far");
    @PythonField("minecraft:entity.firework.launch")
    public static final String ENTITY_FIREWORK_LAUNCH = func("minecraft:entity.firework.launch");
    @PythonField("minecraft:entity.firework.shoot")
    public static final String ENTITY_FIREWORK_SHOOT = func("minecraft:entity.firework.shoot");
    @PythonField("minecraft:entity.firework.twinkle")
    public static final String ENTITY_FIREWORK_TWINKLE = func("minecraft:entity.firework.twinkle");
    @PythonField("minecraft:entity.firework.twinkle_far")
    public static final String ENTITY_FIREWORK_TWINKLE_FAR = func("minecraft:entity.firework.twinkle_far");
    @PythonField("minecraft:entity.generic.big_fall")
    public static final String ENTITY_GENERIC_BIG_FALL = func("minecraft:entity.generic.big_fall");
    @PythonField("minecraft:entity.generic.burn")
    public static final String ENTITY_GENERIC_BURN = func("minecraft:entity.generic.burn");
    @PythonField("minecraft:entity.generic.death")
    public static final String ENTITY_GENERIC_DEATH = func("minecraft:entity.generic.death");
    @PythonField("minecraft:entity.generic.drink")
    public static final String ENTITY_GENERIC_DRINK = func("minecraft:entity.generic.drink");
    @PythonField("minecraft:entity.generic.eat")
    public static final String ENTITY_GENERIC_EAT = func("minecraft:entity.generic.eat");
    @PythonField("minecraft:entity.generic.explode")
    public static final String ENTITY_GENERIC_EXPLODE = func("minecraft:entity.generic.explode");
    @PythonField("minecraft:entity.generic.extinguish_fire")
    public static final String ENTITY_GENERIC_EXTINGUISH_FIRE = func("minecraft:entity.generic.extinguish_fire");
    @PythonField("minecraft:entity.generic.hurt")
    public static final String ENTITY_GENERIC_HURT = func("minecraft:entity.generic.hurt");
    @PythonField("minecraft:entity.generic.small_fall")
    public static final String ENTITY_GENERIC_SMALL_FALL = func("minecraft:entity.generic.small_fall");
    @PythonField("minecraft:entity.generic.splash")
    public static final String ENTITY_GENERIC_SPLASH = func("minecraft:entity.generic.splash");
    @PythonField("minecraft:entity.generic.swim")
    public static final String ENTITY_GENERIC_SWIM = func("minecraft:entity.generic.swim");
    @PythonField("minecraft:entity.ghast.ambient")
    public static final String ENTITY_GHAST_AMBIENT = func("minecraft:entity.ghast.ambient");
    @PythonField("minecraft:entity.ghast.death")
    public static final String ENTITY_GHAST_DEATH = func("minecraft:entity.ghast.death");
    @PythonField("minecraft:entity.ghast.hurt")
    public static final String ENTITY_GHAST_HURT = func("minecraft:entity.ghast.hurt");
    @PythonField("minecraft:entity.ghast.scream")
    public static final String ENTITY_GHAST_SCREAM = func("minecraft:entity.ghast.scream");
    @PythonField("minecraft:entity.ghast.shoot")
    public static final String ENTITY_GHAST_SHOOT = func("minecraft:entity.ghast.shoot");
    @PythonField("minecraft:entity.ghast.warn")
    public static final String ENTITY_GHAST_WARN = func("minecraft:entity.ghast.warn");
    @PythonField("minecraft:entity.guardian.ambient")
    public static final String ENTITY_GUARDIAN_AMBIENT = func("minecraft:entity.guardian.ambient");
    @PythonField("minecraft:entity.guardian.ambient_land")
    public static final String ENTITY_GUARDIAN_AMBIENT_LAND = func("minecraft:entity.guardian.ambient_land");
    @PythonField("minecraft:entity.guardian.attack")
    public static final String ENTITY_GUARDIAN_ATTACK = func("minecraft:entity.guardian.attack");
    @PythonField("minecraft:entity.guardian.death")
    public static final String ENTITY_GUARDIAN_DEATH = func("minecraft:entity.guardian.death");
    @PythonField("minecraft:entity.guardian.death_land")
    public static final String ENTITY_GUARDIAN_DEATH_LAND = func("minecraft:entity.guardian.death_land");
    @PythonField("minecraft:entity.guardian.flop")
    public static final String ENTITY_GUARDIAN_FLOP = func("minecraft:entity.guardian.flop");
    @PythonField("minecraft:entity.guardian.hurt")
    public static final String ENTITY_GUARDIAN_HURT = func("minecraft:entity.guardian.hurt");
    @PythonField("minecraft:entity.guardian.hurt_land")
    public static final String ENTITY_GUARDIAN_HURT_LAND = func("minecraft:entity.guardian.hurt_land");
    @PythonField("minecraft:entity.horse.ambient")
    public static final String ENTITY_HORSE_AMBIENT = func("minecraft:entity.horse.ambient");
    @PythonField("minecraft:entity.horse.angry")
    public static final String ENTITY_HORSE_ANGRY = func("minecraft:entity.horse.angry");
    @PythonField("minecraft:entity.horse.armor")
    public static final String ENTITY_HORSE_ARMOR = func("minecraft:entity.horse.armor");
    @PythonField("minecraft:entity.horse.breathe")
    public static final String ENTITY_HORSE_BREATHE = func("minecraft:entity.horse.breathe");
    @PythonField("minecraft:entity.horse.death")
    public static final String ENTITY_HORSE_DEATH = func("minecraft:entity.horse.death");
    @PythonField("minecraft:entity.horse.eat")
    public static final String ENTITY_HORSE_EAT = func("minecraft:entity.horse.eat");
    @PythonField("minecraft:entity.horse.gallop")
    public static final String ENTITY_HORSE_GALLOP = func("minecraft:entity.horse.gallop");
    @PythonField("minecraft:entity.horse.hurt")
    public static final String ENTITY_HORSE_HURT = func("minecraft:entity.horse.hurt");
    @PythonField("minecraft:entity.horse.jump")
    public static final String ENTITY_HORSE_JUMP = func("minecraft:entity.horse.jump");
    @PythonField("minecraft:entity.horse.land")
    public static final String ENTITY_HORSE_LAND = func("minecraft:entity.horse.land");
    @PythonField("minecraft:entity.horse.saddle")
    public static final String ENTITY_HORSE_SADDLE = func("minecraft:entity.horse.saddle");
    @PythonField("minecraft:entity.horse.step")
    public static final String ENTITY_HORSE_STEP = func("minecraft:entity.horse.step");
    @PythonField("minecraft:entity.horse.step_wood")
    public static final String ENTITY_HORSE_STEP_WOOD = func("minecraft:entity.horse.step_wood");
    @PythonField("minecraft:entity.hostile.big_fall")
    public static final String ENTITY_HOSTILE_BIG_FALL = func("minecraft:entity.hostile.big_fall");
    @PythonField("minecraft:entity.hostile.death")
    public static final String ENTITY_HOSTILE_DEATH = func("minecraft:entity.hostile.death");
    @PythonField("minecraft:entity.hostile.hurt")
    public static final String ENTITY_HOSTILE_HURT = func("minecraft:entity.hostile.hurt");
    @PythonField("minecraft:entity.hostile.small_fall")
    public static final String ENTITY_HOSTILE_SMALL_FALL = func("minecraft:entity.hostile.small_fall");
    @PythonField("minecraft:entity.hostile.splash")
    public static final String ENTITY_HOSTILE_SPLASH = func("minecraft:entity.hostile.splash");
    @PythonField("minecraft:entity.hostile.swim")
    public static final String ENTITY_HOSTILE_SWIM = func("minecraft:entity.hostile.swim");
    @PythonField("minecraft:entity.husk.ambient")
    public static final String ENTITY_HUSK_AMBIENT = func("minecraft:entity.husk.ambient");
    @PythonField("minecraft:entity.husk.death")
    public static final String ENTITY_HUSK_DEATH = func("minecraft:entity.husk.death");
    @PythonField("minecraft:entity.husk.hurt")
    public static final String ENTITY_HUSK_HURT = func("minecraft:entity.husk.hurt");
    @PythonField("minecraft:entity.husk.step")
    public static final String ENTITY_HUSK_STEP = func("minecraft:entity.husk.step");
    @PythonField("minecraft:entity.illusion_illager.ambient")
    public static final String ENTITY_ILLUSION_ILLAGER_AMBIENT = func("minecraft:entity.illusion_illager.ambient");
    @PythonField("minecraft:entity.illusion_illager.cast_spell")
    public static final String ENTITY_ILLUSION_ILLAGER_CAST_SPELL = func("minecraft:entity.illusion_illager.cast_spell");
    @PythonField("minecraft:entity.illusion_illager.death")
    public static final String ENTITY_ILLUSION_ILLAGER_DEATH = func("minecraft:entity.illusion_illager.death");
    @PythonField("minecraft:entity.illusion_illager.hurt")
    public static final String ENTITY_ILLUSION_ILLAGER_HURT = func("minecraft:entity.illusion_illager.hurt");
    @PythonField("minecraft:entity.illusion_illager.mirror_move")
    public static final String ENTITY_ILLUSION_ILLAGER_MIRROR_MOVE = func("minecraft:entity.illusion_illager.mirror_move");
    @PythonField("minecraft:entity.illusion_illager.prepare_blindness")
    public static final String ENTITY_ILLUSION_ILLAGER_PREPARE_BLINDNESS = func("minecraft:entity.illusion_illager.prepare_blindness");
    @PythonField("minecraft:entity.illusion_illager.prepare_mirror")
    public static final String ENTITY_ILLUSION_ILLAGER_PREPARE_MIRROR = func("minecraft:entity.illusion_illager.prepare_mirror");
    @PythonField("minecraft:entity.irongolem.attack")
    public static final String ENTITY_IRONGOLEM_ATTACK = func("minecraft:entity.irongolem.attack");
    @PythonField("minecraft:entity.irongolem.death")
    public static final String ENTITY_IRONGOLEM_DEATH = func("minecraft:entity.irongolem.death");
    @PythonField("minecraft:entity.irongolem.hurt")
    public static final String ENTITY_IRONGOLEM_HURT = func("minecraft:entity.irongolem.hurt");
    @PythonField("minecraft:entity.irongolem.step")
    public static final String ENTITY_IRONGOLEM_STEP = func("minecraft:entity.irongolem.step");
    @PythonField("minecraft:entity.item.break")
    public static final String ENTITY_ITEM_BREAK = func("minecraft:entity.item.break");
    @PythonField("minecraft:entity.item.pickup")
    public static final String ENTITY_ITEM_PICKUP = func("minecraft:entity.item.pickup");
    @PythonField("minecraft:entity.itemframe.add_item")
    public static final String ENTITY_ITEMFRAME_ADD_ITEM = func("minecraft:entity.itemframe.add_item");
    @PythonField("minecraft:entity.itemframe.break")
    public static final String ENTITY_ITEMFRAME_BREAK = func("minecraft:entity.itemframe.break");
    @PythonField("minecraft:entity.itemframe.place")
    public static final String ENTITY_ITEMFRAME_PLACE = func("minecraft:entity.itemframe.place");
    @PythonField("minecraft:entity.itemframe.remove_item")
    public static final String ENTITY_ITEMFRAME_REMOVE_ITEM = func("minecraft:entity.itemframe.remove_item");
    @PythonField("minecraft:entity.itemframe.rotate_item")
    public static final String ENTITY_ITEMFRAME_ROTATE_ITEM = func("minecraft:entity.itemframe.rotate_item");
    @PythonField("minecraft:entity.leashknot.break")
    public static final String ENTITY_LEASHKNOT_BREAK = func("minecraft:entity.leashknot.break");
    @PythonField("minecraft:entity.leashknot.place")
    public static final String ENTITY_LEASHKNOT_PLACE = func("minecraft:entity.leashknot.place");
    @PythonField("minecraft:entity.lightning.impact")
    public static final String ENTITY_LIGHTNING_IMPACT = func("minecraft:entity.lightning.impact");
    @PythonField("minecraft:entity.lightning.thunder")
    public static final String ENTITY_LIGHTNING_THUNDER = func("minecraft:entity.lightning.thunder");
    @PythonField("minecraft:entity.lingeringpotion.throw")
    public static final String ENTITY_LINGERINGPOTION_THROW = func("minecraft:entity.lingeringpotion.throw");
    @PythonField("minecraft:entity.llama.ambient")
    public static final String ENTITY_LLAMA_AMBIENT = func("minecraft:entity.llama.ambient");
    @PythonField("minecraft:entity.llama.angry")
    public static final String ENTITY_LLAMA_ANGRY = func("minecraft:entity.llama.angry");
    @PythonField("minecraft:entity.llama.chest")
    public static final String ENTITY_LLAMA_CHEST = func("minecraft:entity.llama.chest");
    @PythonField("minecraft:entity.llama.death")
    public static final String ENTITY_LLAMA_DEATH = func("minecraft:entity.llama.death");
    @PythonField("minecraft:entity.llama.eat")
    public static final String ENTITY_LLAMA_EAT = func("minecraft:entity.llama.eat");
    @PythonField("minecraft:entity.llama.hurt")
    public static final String ENTITY_LLAMA_HURT = func("minecraft:entity.llama.hurt");
    @PythonField("minecraft:entity.llama.spit")
    public static final String ENTITY_LLAMA_SPIT = func("minecraft:entity.llama.spit");
    @PythonField("minecraft:entity.llama.step")
    public static final String ENTITY_LLAMA_STEP = func("minecraft:entity.llama.step");
    @PythonField("minecraft:entity.llama.swag")
    public static final String ENTITY_LLAMA_SWAG = func("minecraft:entity.llama.swag");
    @PythonField("minecraft:entity.magmacube.death")
    public static final String ENTITY_MAGMACUBE_DEATH = func("minecraft:entity.magmacube.death");
    @PythonField("minecraft:entity.magmacube.hurt")
    public static final String ENTITY_MAGMACUBE_HURT = func("minecraft:entity.magmacube.hurt");
    @PythonField("minecraft:entity.magmacube.jump")
    public static final String ENTITY_MAGMACUBE_JUMP = func("minecraft:entity.magmacube.jump");
    @PythonField("minecraft:entity.magmacube.squish")
    public static final String ENTITY_MAGMACUBE_SQUISH = func("minecraft:entity.magmacube.squish");
    @PythonField("minecraft:entity.minecart.inside")
    public static final String ENTITY_MINECART_INSIDE = func("minecraft:entity.minecart.inside");
    @PythonField("minecraft:entity.minecart.riding")
    public static final String ENTITY_MINECART_RIDING = func("minecraft:entity.minecart.riding");
    @PythonField("minecraft:entity.mooshroom.shear")
    public static final String ENTITY_MOOSHROOM_SHEAR = func("minecraft:entity.mooshroom.shear");
    @PythonField("minecraft:entity.mule.ambient")
    public static final String ENTITY_MULE_AMBIENT = func("minecraft:entity.mule.ambient");
    @PythonField("minecraft:entity.mule.chest")
    public static final String ENTITY_MULE_CHEST = func("minecraft:entity.mule.chest");
    @PythonField("minecraft:entity.mule.death")
    public static final String ENTITY_MULE_DEATH = func("minecraft:entity.mule.death");
    @PythonField("minecraft:entity.mule.hurt")
    public static final String ENTITY_MULE_HURT = func("minecraft:entity.mule.hurt");
    @PythonField("minecraft:entity.painting.break")
    public static final String ENTITY_PAINTING_BREAK = func("minecraft:entity.painting.break");
    @PythonField("minecraft:entity.painting.place")
    public static final String ENTITY_PAINTING_PLACE = func("minecraft:entity.painting.place");
    @PythonField("minecraft:entity.parrot.ambient")
    public static final String ENTITY_PARROT_AMBIENT = func("minecraft:entity.parrot.ambient");
    @PythonField("minecraft:entity.parrot.death")
    public static final String ENTITY_PARROT_DEATH = func("minecraft:entity.parrot.death");
    @PythonField("minecraft:entity.parrot.eat")
    public static final String ENTITY_PARROT_EAT = func("minecraft:entity.parrot.eat");
    @PythonField("minecraft:entity.parrot.fly")
    public static final String ENTITY_PARROT_FLY = func("minecraft:entity.parrot.fly");
    @PythonField("minecraft:entity.parrot.hurt")
    public static final String ENTITY_PARROT_HURT = func("minecraft:entity.parrot.hurt");
    @PythonField("minecraft:entity.parrot.imitate.blaze")
    public static final String ENTITY_PARROT_IMITATE_BLAZE = func("minecraft:entity.parrot.imitate.blaze");
    @PythonField("minecraft:entity.parrot.imitate.creeper")
    public static final String ENTITY_PARROT_IMITATE_CREEPER = func("minecraft:entity.parrot.imitate.creeper");
    @PythonField("minecraft:entity.parrot.imitate.elder_guardian")
    public static final String ENTITY_PARROT_IMITATE_ELDER_GUARDIAN = func("minecraft:entity.parrot.imitate.elder_guardian");
    @PythonField("minecraft:entity.parrot.imitate.enderdragon")
    public static final String ENTITY_PARROT_IMITATE_ENDERDRAGON = func("minecraft:entity.parrot.imitate.enderdragon");
    @PythonField("minecraft:entity.parrot.imitate.enderman")
    public static final String ENTITY_PARROT_IMITATE_ENDERMAN = func("minecraft:entity.parrot.imitate.enderman");
    @PythonField("minecraft:entity.parrot.imitate.endermite")
    public static final String ENTITY_PARROT_IMITATE_ENDERMITE = func("minecraft:entity.parrot.imitate.endermite");
    @PythonField("minecraft:entity.parrot.imitate.evocation_illager")
    public static final String ENTITY_PARROT_IMITATE_EVOCATION_ILLAGER = func("minecraft:entity.parrot.imitate.evocation_illager");
    @PythonField("minecraft:entity.parrot.imitate.ghast")
    public static final String ENTITY_PARROT_IMITATE_GHAST = func("minecraft:entity.parrot.imitate.ghast");
    @PythonField("minecraft:entity.parrot.imitate.husk")
    public static final String ENTITY_PARROT_IMITATE_HUSK = func("minecraft:entity.parrot.imitate.husk");
    @PythonField("minecraft:entity.parrot.imitate.illusion_illager")
    public static final String ENTITY_PARROT_IMITATE_ILLUSION_ILLAGER = func("minecraft:entity.parrot.imitate.illusion_illager");
    @PythonField("minecraft:entity.parrot.imitate.magmacube")
    public static final String ENTITY_PARROT_IMITATE_MAGMACUBE = func("minecraft:entity.parrot.imitate.magmacube");
    @PythonField("minecraft:entity.parrot.imitate.polar_bear")
    public static final String ENTITY_PARROT_IMITATE_POLAR_BEAR = func("minecraft:entity.parrot.imitate.polar_bear");
    @PythonField("minecraft:entity.parrot.imitate.shulker")
    public static final String ENTITY_PARROT_IMITATE_SHULKER = func("minecraft:entity.parrot.imitate.shulker");
    @PythonField("minecraft:entity.parrot.imitate.silverfish")
    public static final String ENTITY_PARROT_IMITATE_SILVERFISH = func("minecraft:entity.parrot.imitate.silverfish");
    @PythonField("minecraft:entity.parrot.imitate.skeleton")
    public static final String ENTITY_PARROT_IMITATE_SKELETON = func("minecraft:entity.parrot.imitate.skeleton");
    @PythonField("minecraft:entity.parrot.imitate.slime")
    public static final String ENTITY_PARROT_IMITATE_SLIME = func("minecraft:entity.parrot.imitate.slime");
    @PythonField("minecraft:entity.parrot.imitate.spider")
    public static final String ENTITY_PARROT_IMITATE_SPIDER = func("minecraft:entity.parrot.imitate.spider");
    @PythonField("minecraft:entity.parrot.imitate.stray")
    public static final String ENTITY_PARROT_IMITATE_STRAY = func("minecraft:entity.parrot.imitate.stray");
    @PythonField("minecraft:entity.parrot.imitate.vex")
    public static final String ENTITY_PARROT_IMITATE_VEX = func("minecraft:entity.parrot.imitate.vex");
    @PythonField("minecraft:entity.parrot.imitate.vindication_illager")
    public static final String ENTITY_PARROT_IMITATE_VINDICATION_ILLAGER = func("minecraft:entity.parrot.imitate.vindication_illager");
    @PythonField("minecraft:entity.parrot.imitate.witch")
    public static final String ENTITY_PARROT_IMITATE_WITCH = func("minecraft:entity.parrot.imitate.witch");
    @PythonField("minecraft:entity.parrot.imitate.wither")
    public static final String ENTITY_PARROT_IMITATE_WITHER = func("minecraft:entity.parrot.imitate.wither");
    @PythonField("minecraft:entity.parrot.imitate.wither_skeleton")
    public static final String ENTITY_PARROT_IMITATE_WITHER_SKELETON = func("minecraft:entity.parrot.imitate.wither_skeleton");
    @PythonField("minecraft:entity.parrot.imitate.wolf")
    public static final String ENTITY_PARROT_IMITATE_WOLF = func("minecraft:entity.parrot.imitate.wolf");
    @PythonField("minecraft:entity.parrot.imitate.zombie")
    public static final String ENTITY_PARROT_IMITATE_ZOMBIE = func("minecraft:entity.parrot.imitate.zombie");
    @PythonField("minecraft:entity.parrot.imitate.zombie_pigman")
    public static final String ENTITY_PARROT_IMITATE_ZOMBIE_PIGMAN = func("minecraft:entity.parrot.imitate.zombie_pigman");
    @PythonField("minecraft:entity.parrot.imitate.zombie_villager")
    public static final String ENTITY_PARROT_IMITATE_ZOMBIE_VILLAGER = func("minecraft:entity.parrot.imitate.zombie_villager");
    @PythonField("minecraft:entity.parrot.step")
    public static final String ENTITY_PARROT_STEP = func("minecraft:entity.parrot.step");
    @PythonField("minecraft:entity.pig.ambient")
    public static final String ENTITY_PIG_AMBIENT = func("minecraft:entity.pig.ambient");
    @PythonField("minecraft:entity.pig.death")
    public static final String ENTITY_PIG_DEATH = func("minecraft:entity.pig.death");
    @PythonField("minecraft:entity.pig.hurt")
    public static final String ENTITY_PIG_HURT = func("minecraft:entity.pig.hurt");
    @PythonField("minecraft:entity.pig.saddle")
    public static final String ENTITY_PIG_SADDLE = func("minecraft:entity.pig.saddle");
    @PythonField("minecraft:entity.pig.step")
    public static final String ENTITY_PIG_STEP = func("minecraft:entity.pig.step");
    @PythonField("minecraft:entity.player.attack.crit")
    public static final String ENTITY_PLAYER_ATTACK_CRIT = func("minecraft:entity.player.attack.crit");
    @PythonField("minecraft:entity.player.attack.knockback")
    public static final String ENTITY_PLAYER_ATTACK_KNOCKBACK = func("minecraft:entity.player.attack.knockback");
    @PythonField("minecraft:entity.player.attack.nodamage")
    public static final String ENTITY_PLAYER_ATTACK_NODAMAGE = func("minecraft:entity.player.attack.nodamage");
    @PythonField("minecraft:entity.player.attack.strong")
    public static final String ENTITY_PLAYER_ATTACK_STRONG = func("minecraft:entity.player.attack.strong");
    @PythonField("minecraft:entity.player.attack.sweep")
    public static final String ENTITY_PLAYER_ATTACK_SWEEP = func("minecraft:entity.player.attack.sweep");
    @PythonField("minecraft:entity.player.attack.weak")
    public static final String ENTITY_PLAYER_ATTACK_WEAK = func("minecraft:entity.player.attack.weak");
    @PythonField("minecraft:entity.player.big_fall")
    public static final String ENTITY_PLAYER_BIG_FALL = func("minecraft:entity.player.big_fall");
    @PythonField("minecraft:entity.player.breath")
    public static final String ENTITY_PLAYER_BREATH = func("minecraft:entity.player.breath");
    @PythonField("minecraft:entity.player.burp")
    public static final String ENTITY_PLAYER_BURP = func("minecraft:entity.player.burp");
    @PythonField("minecraft:entity.player.death")
    public static final String ENTITY_PLAYER_DEATH = func("minecraft:entity.player.death");
    @PythonField("minecraft:entity.player.hurt")
    public static final String ENTITY_PLAYER_HURT = func("minecraft:entity.player.hurt");
    @PythonField("minecraft:entity.player.hurt_drown")
    public static final String ENTITY_PLAYER_HURT_DROWN = func("minecraft:entity.player.hurt_drown");
    @PythonField("minecraft:entity.player.hurt_on_fire")
    public static final String ENTITY_PLAYER_HURT_ON_FIRE = func("minecraft:entity.player.hurt_on_fire");
    @PythonField("minecraft:entity.player.levelup")
    public static final String ENTITY_PLAYER_LEVELUP = func("minecraft:entity.player.levelup");
    @PythonField("minecraft:entity.player.small_fall")
    public static final String ENTITY_PLAYER_SMALL_FALL = func("minecraft:entity.player.small_fall");
    @PythonField("minecraft:entity.player.splash")
    public static final String ENTITY_PLAYER_SPLASH = func("minecraft:entity.player.splash");
    @PythonField("minecraft:entity.player.swim")
    public static final String ENTITY_PLAYER_SWIM = func("minecraft:entity.player.swim");
    @PythonField("minecraft:entity.polar_bear.ambient")
    public static final String ENTITY_POLAR_BEAR_AMBIENT = func("minecraft:entity.polar_bear.ambient");
    @PythonField("minecraft:entity.polar_bear.baby_ambient")
    public static final String ENTITY_POLAR_BEAR_BABY_AMBIENT = func("minecraft:entity.polar_bear.baby_ambient");
    @PythonField("minecraft:entity.polar_bear.death")
    public static final String ENTITY_POLAR_BEAR_DEATH = func("minecraft:entity.polar_bear.death");
    @PythonField("minecraft:entity.polar_bear.hurt")
    public static final String ENTITY_POLAR_BEAR_HURT = func("minecraft:entity.polar_bear.hurt");
    @PythonField("minecraft:entity.polar_bear.step")
    public static final String ENTITY_POLAR_BEAR_STEP = func("minecraft:entity.polar_bear.step");
    @PythonField("minecraft:entity.polar_bear.warning")
    public static final String ENTITY_POLAR_BEAR_WARNING = func("minecraft:entity.polar_bear.warning");
    @PythonField("minecraft:entity.rabbit.ambient")
    public static final String ENTITY_RABBIT_AMBIENT = func("minecraft:entity.rabbit.ambient");
    @PythonField("minecraft:entity.rabbit.attack")
    public static final String ENTITY_RABBIT_ATTACK = func("minecraft:entity.rabbit.attack");
    @PythonField("minecraft:entity.rabbit.death")
    public static final String ENTITY_RABBIT_DEATH = func("minecraft:entity.rabbit.death");
    @PythonField("minecraft:entity.rabbit.hurt")
    public static final String ENTITY_RABBIT_HURT = func("minecraft:entity.rabbit.hurt");
    @PythonField("minecraft:entity.rabbit.jump")
    public static final String ENTITY_RABBIT_JUMP = func("minecraft:entity.rabbit.jump");
    @PythonField("minecraft:entity.sheep.ambient")
    public static final String ENTITY_SHEEP_AMBIENT = func("minecraft:entity.sheep.ambient");
    @PythonField("minecraft:entity.sheep.death")
    public static final String ENTITY_SHEEP_DEATH = func("minecraft:entity.sheep.death");
    @PythonField("minecraft:entity.sheep.hurt")
    public static final String ENTITY_SHEEP_HURT = func("minecraft:entity.sheep.hurt");
    @PythonField("minecraft:entity.sheep.shear")
    public static final String ENTITY_SHEEP_SHEAR = func("minecraft:entity.sheep.shear");
    @PythonField("minecraft:entity.sheep.step")
    public static final String ENTITY_SHEEP_STEP = func("minecraft:entity.sheep.step");
    @PythonField("minecraft:entity.shulker.ambient")
    public static final String ENTITY_SHULKER_AMBIENT = func("minecraft:entity.shulker.ambient");
    @PythonField("minecraft:entity.shulker.close")
    public static final String ENTITY_SHULKER_CLOSE = func("minecraft:entity.shulker.close");
    @PythonField("minecraft:entity.shulker.death")
    public static final String ENTITY_SHULKER_DEATH = func("minecraft:entity.shulker.death");
    @PythonField("minecraft:entity.shulker.hurt")
    public static final String ENTITY_SHULKER_HURT = func("minecraft:entity.shulker.hurt");
    @PythonField("minecraft:entity.shulker.hurt_closed")
    public static final String ENTITY_SHULKER_HURT_CLOSED = func("minecraft:entity.shulker.hurt_closed");
    @PythonField("minecraft:entity.shulker.open")
    public static final String ENTITY_SHULKER_OPEN = func("minecraft:entity.shulker.open");
    @PythonField("minecraft:entity.shulker.shoot")
    public static final String ENTITY_SHULKER_SHOOT = func("minecraft:entity.shulker.shoot");
    @PythonField("minecraft:entity.shulker.teleport")
    public static final String ENTITY_SHULKER_TELEPORT = func("minecraft:entity.shulker.teleport");
    @PythonField("minecraft:entity.shulker_bullet.hit")
    public static final String ENTITY_SHULKER_BULLET_HIT = func("minecraft:entity.shulker_bullet.hit");
    @PythonField("minecraft:entity.shulker_bullet.hurt")
    public static final String ENTITY_SHULKER_BULLET_HURT = func("minecraft:entity.shulker_bullet.hurt");
    @PythonField("minecraft:entity.silverfish.ambient")
    public static final String ENTITY_SILVERFISH_AMBIENT = func("minecraft:entity.silverfish.ambient");
    @PythonField("minecraft:entity.silverfish.death")
    public static final String ENTITY_SILVERFISH_DEATH = func("minecraft:entity.silverfish.death");
    @PythonField("minecraft:entity.silverfish.hurt")
    public static final String ENTITY_SILVERFISH_HURT = func("minecraft:entity.silverfish.hurt");
    @PythonField("minecraft:entity.silverfish.step")
    public static final String ENTITY_SILVERFISH_STEP = func("minecraft:entity.silverfish.step");
    @PythonField("minecraft:entity.skeleton.ambient")
    public static final String ENTITY_SKELETON_AMBIENT = func("minecraft:entity.skeleton.ambient");
    @PythonField("minecraft:entity.skeleton.death")
    public static final String ENTITY_SKELETON_DEATH = func("minecraft:entity.skeleton.death");
    @PythonField("minecraft:entity.skeleton.hurt")
    public static final String ENTITY_SKELETON_HURT = func("minecraft:entity.skeleton.hurt");
    @PythonField("minecraft:entity.skeleton.shoot")
    public static final String ENTITY_SKELETON_SHOOT = func("minecraft:entity.skeleton.shoot");
    @PythonField("minecraft:entity.skeleton.step")
    public static final String ENTITY_SKELETON_STEP = func("minecraft:entity.skeleton.step");
    @PythonField("minecraft:entity.skeleton_horse.ambient")
    public static final String ENTITY_SKELETON_HORSE_AMBIENT = func("minecraft:entity.skeleton_horse.ambient");
    @PythonField("minecraft:entity.skeleton_horse.death")
    public static final String ENTITY_SKELETON_HORSE_DEATH = func("minecraft:entity.skeleton_horse.death");
    @PythonField("minecraft:entity.skeleton_horse.hurt")
    public static final String ENTITY_SKELETON_HORSE_HURT = func("minecraft:entity.skeleton_horse.hurt");
    @PythonField("minecraft:entity.slime.attack")
    public static final String ENTITY_SLIME_ATTACK = func("minecraft:entity.slime.attack");
    @PythonField("minecraft:entity.slime.death")
    public static final String ENTITY_SLIME_DEATH = func("minecraft:entity.slime.death");
    @PythonField("minecraft:entity.slime.hurt")
    public static final String ENTITY_SLIME_HURT = func("minecraft:entity.slime.hurt");
    @PythonField("minecraft:entity.slime.jump")
    public static final String ENTITY_SLIME_JUMP = func("minecraft:entity.slime.jump");
    @PythonField("minecraft:entity.slime.squish")
    public static final String ENTITY_SLIME_SQUISH = func("minecraft:entity.slime.squish");
    @PythonField("minecraft:entity.small_magmacube.death")
    public static final String ENTITY_SMALL_MAGMACUBE_DEATH = func("minecraft:entity.small_magmacube.death");
    @PythonField("minecraft:entity.small_magmacube.hurt")
    public static final String ENTITY_SMALL_MAGMACUBE_HURT = func("minecraft:entity.small_magmacube.hurt");
    @PythonField("minecraft:entity.small_magmacube.squish")
    public static final String ENTITY_SMALL_MAGMACUBE_SQUISH = func("minecraft:entity.small_magmacube.squish");
    @PythonField("minecraft:entity.small_slime.death")
    public static final String ENTITY_SMALL_SLIME_DEATH = func("minecraft:entity.small_slime.death");
    @PythonField("minecraft:entity.small_slime.hurt")
    public static final String ENTITY_SMALL_SLIME_HURT = func("minecraft:entity.small_slime.hurt");
    @PythonField("minecraft:entity.small_slime.jump")
    public static final String ENTITY_SMALL_SLIME_JUMP = func("minecraft:entity.small_slime.jump");
    @PythonField("minecraft:entity.small_slime.squish")
    public static final String ENTITY_SMALL_SLIME_SQUISH = func("minecraft:entity.small_slime.squish");
    @PythonField("minecraft:entity.snowball.throw")
    public static final String ENTITY_SNOWBALL_THROW = func("minecraft:entity.snowball.throw");
    @PythonField("minecraft:entity.snowman.ambient")
    public static final String ENTITY_SNOWMAN_AMBIENT = func("minecraft:entity.snowman.ambient");
    @PythonField("minecraft:entity.snowman.death")
    public static final String ENTITY_SNOWMAN_DEATH = func("minecraft:entity.snowman.death");
    @PythonField("minecraft:entity.snowman.hurt")
    public static final String ENTITY_SNOWMAN_HURT = func("minecraft:entity.snowman.hurt");
    @PythonField("minecraft:entity.snowman.shoot")
    public static final String ENTITY_SNOWMAN_SHOOT = func("minecraft:entity.snowman.shoot");
    @PythonField("minecraft:entity.spider.ambient")
    public static final String ENTITY_SPIDER_AMBIENT = func("minecraft:entity.spider.ambient");
    @PythonField("minecraft:entity.spider.death")
    public static final String ENTITY_SPIDER_DEATH = func("minecraft:entity.spider.death");
    @PythonField("minecraft:entity.spider.hurt")
    public static final String ENTITY_SPIDER_HURT = func("minecraft:entity.spider.hurt");
    @PythonField("minecraft:entity.spider.step")
    public static final String ENTITY_SPIDER_STEP = func("minecraft:entity.spider.step");
    @PythonField("minecraft:entity.splash_potion.break")
    public static final String ENTITY_SPLASH_POTION_BREAK = func("minecraft:entity.splash_potion.break");
    @PythonField("minecraft:entity.splash_potion.throw")
    public static final String ENTITY_SPLASH_POTION_THROW = func("minecraft:entity.splash_potion.throw");
    @PythonField("minecraft:entity.squid.ambient")
    public static final String ENTITY_SQUID_AMBIENT = func("minecraft:entity.squid.ambient");
    @PythonField("minecraft:entity.squid.death")
    public static final String ENTITY_SQUID_DEATH = func("minecraft:entity.squid.death");
    @PythonField("minecraft:entity.squid.hurt")
    public static final String ENTITY_SQUID_HURT = func("minecraft:entity.squid.hurt");
    @PythonField("minecraft:entity.stray.ambient")
    public static final String ENTITY_STRAY_AMBIENT = func("minecraft:entity.stray.ambient");
    @PythonField("minecraft:entity.stray.death")
    public static final String ENTITY_STRAY_DEATH = func("minecraft:entity.stray.death");
    @PythonField("minecraft:entity.stray.hurt")
    public static final String ENTITY_STRAY_HURT = func("minecraft:entity.stray.hurt");
    @PythonField("minecraft:entity.stray.step")
    public static final String ENTITY_STRAY_STEP = func("minecraft:entity.stray.step");
    @PythonField("minecraft:entity.tnt.primed")
    public static final String ENTITY_TNT_PRIMED = func("minecraft:entity.tnt.primed");
    @PythonField("minecraft:entity.vex.ambient")
    public static final String ENTITY_VEX_AMBIENT = func("minecraft:entity.vex.ambient");
    @PythonField("minecraft:entity.vex.charge")
    public static final String ENTITY_VEX_CHARGE = func("minecraft:entity.vex.charge");
    @PythonField("minecraft:entity.vex.death")
    public static final String ENTITY_VEX_DEATH = func("minecraft:entity.vex.death");
    @PythonField("minecraft:entity.vex.hurt")
    public static final String ENTITY_VEX_HURT = func("minecraft:entity.vex.hurt");
    @PythonField("minecraft:entity.villager.ambient")
    public static final String ENTITY_VILLAGER_AMBIENT = func("minecraft:entity.villager.ambient");
    @PythonField("minecraft:entity.villager.death")
    public static final String ENTITY_VILLAGER_DEATH = func("minecraft:entity.villager.death");
    @PythonField("minecraft:entity.villager.hurt")
    public static final String ENTITY_VILLAGER_HURT = func("minecraft:entity.villager.hurt");
    @PythonField("minecraft:entity.villager.no")
    public static final String ENTITY_VILLAGER_NO = func("minecraft:entity.villager.no");
    @PythonField("minecraft:entity.villager.trading")
    public static final String ENTITY_VILLAGER_TRADING = func("minecraft:entity.villager.trading");
    @PythonField("minecraft:entity.villager.yes")
    public static final String ENTITY_VILLAGER_YES = func("minecraft:entity.villager.yes");
    @PythonField("minecraft:entity.vindication_illager.ambient")
    public static final String ENTITY_VINDICATION_ILLAGER_AMBIENT = func("minecraft:entity.vindication_illager.ambient");
    @PythonField("minecraft:entity.vindication_illager.death")
    public static final String ENTITY_VINDICATION_ILLAGER_DEATH = func("minecraft:entity.vindication_illager.death");
    @PythonField("minecraft:entity.vindication_illager.hurt")
    public static final String ENTITY_VINDICATION_ILLAGER_HURT = func("minecraft:entity.vindication_illager.hurt");
    @PythonField("minecraft:entity.witch.ambient")
    public static final String ENTITY_WITCH_AMBIENT = func("minecraft:entity.witch.ambient");
    @PythonField("minecraft:entity.witch.death")
    public static final String ENTITY_WITCH_DEATH = func("minecraft:entity.witch.death");
    @PythonField("minecraft:entity.witch.drink")
    public static final String ENTITY_WITCH_DRINK = func("minecraft:entity.witch.drink");
    @PythonField("minecraft:entity.witch.hurt")
    public static final String ENTITY_WITCH_HURT = func("minecraft:entity.witch.hurt");
    @PythonField("minecraft:entity.witch.throw")
    public static final String ENTITY_WITCH_THROW = func("minecraft:entity.witch.throw");
    @PythonField("minecraft:entity.wither.ambient")
    public static final String ENTITY_WITHER_AMBIENT = func("minecraft:entity.wither.ambient");
    @PythonField("minecraft:entity.wither.break_block")
    public static final String ENTITY_WITHER_BREAK_BLOCK = func("minecraft:entity.wither.break_block");
    @PythonField("minecraft:entity.wither.death")
    public static final String ENTITY_WITHER_DEATH = func("minecraft:entity.wither.death");
    @PythonField("minecraft:entity.wither.hurt")
    public static final String ENTITY_WITHER_HURT = func("minecraft:entity.wither.hurt");
    @PythonField("minecraft:entity.wither.shoot")
    public static final String ENTITY_WITHER_SHOOT = func("minecraft:entity.wither.shoot");
    @PythonField("minecraft:entity.wither.spawn")
    public static final String ENTITY_WITHER_SPAWN = func("minecraft:entity.wither.spawn");
    @PythonField("minecraft:entity.wither_skeleton.ambient")
    public static final String ENTITY_WITHER_SKELETON_AMBIENT = func("minecraft:entity.wither_skeleton.ambient");
    @PythonField("minecraft:entity.wither_skeleton.death")
    public static final String ENTITY_WITHER_SKELETON_DEATH = func("minecraft:entity.wither_skeleton.death");
    @PythonField("minecraft:entity.wither_skeleton.hurt")
    public static final String ENTITY_WITHER_SKELETON_HURT = func("minecraft:entity.wither_skeleton.hurt");
    @PythonField("minecraft:entity.wither_skeleton.step")
    public static final String ENTITY_WITHER_SKELETON_STEP = func("minecraft:entity.wither_skeleton.step");
    @PythonField("minecraft:entity.wolf.ambient")
    public static final String ENTITY_WOLF_AMBIENT = func("minecraft:entity.wolf.ambient");
    @PythonField("minecraft:entity.wolf.death")
    public static final String ENTITY_WOLF_DEATH = func("minecraft:entity.wolf.death");
    @PythonField("minecraft:entity.wolf.growl")
    public static final String ENTITY_WOLF_GROWL = func("minecraft:entity.wolf.growl");
    @PythonField("minecraft:entity.wolf.howl")
    public static final String ENTITY_WOLF_HOWL = func("minecraft:entity.wolf.howl");
    @PythonField("minecraft:entity.wolf.hurt")
    public static final String ENTITY_WOLF_HURT = func("minecraft:entity.wolf.hurt");
    @PythonField("minecraft:entity.wolf.pant")
    public static final String ENTITY_WOLF_PANT = func("minecraft:entity.wolf.pant");
    @PythonField("minecraft:entity.wolf.shake")
    public static final String ENTITY_WOLF_SHAKE = func("minecraft:entity.wolf.shake");
    @PythonField("minecraft:entity.wolf.step")
    public static final String ENTITY_WOLF_STEP = func("minecraft:entity.wolf.step");
    @PythonField("minecraft:entity.wolf.whine")
    public static final String ENTITY_WOLF_WHINE = func("minecraft:entity.wolf.whine");
    @PythonField("minecraft:entity.zombie.ambient")
    public static final String ENTITY_ZOMBIE_AMBIENT = func("minecraft:entity.zombie.ambient");
    @PythonField("minecraft:entity.zombie.attack_door_wood")
    public static final String ENTITY_ZOMBIE_ATTACK_DOOR_WOOD = func("minecraft:entity.zombie.attack_door_wood");
    @PythonField("minecraft:entity.zombie.attack_iron_door")
    public static final String ENTITY_ZOMBIE_ATTACK_IRON_DOOR = func("minecraft:entity.zombie.attack_iron_door");
    @PythonField("minecraft:entity.zombie.break_door_wood")
    public static final String ENTITY_ZOMBIE_BREAK_DOOR_WOOD = func("minecraft:entity.zombie.break_door_wood");
    @PythonField("minecraft:entity.zombie.death")
    public static final String ENTITY_ZOMBIE_DEATH = func("minecraft:entity.zombie.death");
    @PythonField("minecraft:entity.zombie.hurt")
    public static final String ENTITY_ZOMBIE_HURT = func("minecraft:entity.zombie.hurt");
    @PythonField("minecraft:entity.zombie.infect")
    public static final String ENTITY_ZOMBIE_INFECT = func("minecraft:entity.zombie.infect");
    @PythonField("minecraft:entity.zombie.step")
    public static final String ENTITY_ZOMBIE_STEP = func("minecraft:entity.zombie.step");
    @PythonField("minecraft:entity.zombie_horse.ambient")
    public static final String ENTITY_ZOMBIE_HORSE_AMBIENT = func("minecraft:entity.zombie_horse.ambient");
    @PythonField("minecraft:entity.zombie_horse.death")
    public static final String ENTITY_ZOMBIE_HORSE_DEATH = func("minecraft:entity.zombie_horse.death");
    @PythonField("minecraft:entity.zombie_horse.hurt")
    public static final String ENTITY_ZOMBIE_HORSE_HURT = func("minecraft:entity.zombie_horse.hurt");
    @PythonField("minecraft:entity.zombie_pig.ambient")
    public static final String ENTITY_ZOMBIE_PIG_AMBIENT = func("minecraft:entity.zombie_pig.ambient");
    @PythonField("minecraft:entity.zombie_pig.angry")
    public static final String ENTITY_ZOMBIE_PIG_ANGRY = func("minecraft:entity.zombie_pig.angry");
    @PythonField("minecraft:entity.zombie_pig.death")
    public static final String ENTITY_ZOMBIE_PIG_DEATH = func("minecraft:entity.zombie_pig.death");
    @PythonField("minecraft:entity.zombie_pig.hurt")
    public static final String ENTITY_ZOMBIE_PIG_HURT = func("minecraft:entity.zombie_pig.hurt");
    @PythonField("minecraft:entity.zombie_villager.ambient")
    public static final String ENTITY_ZOMBIE_VILLAGER_AMBIENT = func("minecraft:entity.zombie_villager.ambient");
    @PythonField("minecraft:entity.zombie_villager.converted")
    public static final String ENTITY_ZOMBIE_VILLAGER_CONVERTED = func("minecraft:entity.zombie_villager.converted");
    @PythonField("minecraft:entity.zombie_villager.cure")
    public static final String ENTITY_ZOMBIE_VILLAGER_CURE = func("minecraft:entity.zombie_villager.cure");
    @PythonField("minecraft:entity.zombie_villager.death")
    public static final String ENTITY_ZOMBIE_VILLAGER_DEATH = func("minecraft:entity.zombie_villager.death");
    @PythonField("minecraft:entity.zombie_villager.hurt")
    public static final String ENTITY_ZOMBIE_VILLAGER_HURT = func("minecraft:entity.zombie_villager.hurt");
    @PythonField("minecraft:entity.zombie_villager.step")
    public static final String ENTITY_ZOMBIE_VILLAGER_STEP = func("minecraft:entity.zombie_villager.step");
    @PythonField("minecraft:item.armor.equip_chain")
    public static final String ITEM_ARMOR_EQUIP_CHAIN = func("minecraft:item.armor.equip_chain");
    @PythonField("minecraft:item.armor.equip_diamond")
    public static final String ITEM_ARMOR_EQUIP_DIAMOND = func("minecraft:item.armor.equip_diamond");
    @PythonField("minecraft:item.armor.equip_elytra")
    public static final String ITEM_ARMOR_EQUIP_ELYTRA = func("minecraft:item.armor.equip_elytra");
    @PythonField("minecraft:item.armor.equip_generic")
    public static final String ITEM_ARMOR_EQUIP_GENERIC = func("minecraft:item.armor.equip_generic");
    @PythonField("minecraft:item.armor.equip_gold")
    public static final String ITEM_ARMOR_EQUIP_GOLD = func("minecraft:item.armor.equip_gold");
    @PythonField("minecraft:item.armor.equip_iron")
    public static final String ITEM_ARMOR_EQUIP_IRON = func("minecraft:item.armor.equip_iron");
    @PythonField("minecraft:item.armor.equip_leather")
    public static final String ITEM_ARMOR_EQUIP_LEATHER = func("minecraft:item.armor.equip_leather");
    @PythonField("minecraft:item.bottle.empty")
    public static final String ITEM_BOTTLE_EMPTY = func("minecraft:item.bottle.empty");
    @PythonField("minecraft:item.bottle.fill")
    public static final String ITEM_BOTTLE_FILL = func("minecraft:item.bottle.fill");
    @PythonField("minecraft:item.bottle.fill_dragonbreath")
    public static final String ITEM_BOTTLE_FILL_DRAGONBREATH = func("minecraft:item.bottle.fill_dragonbreath");
    @PythonField("minecraft:item.bucket.empty")
    public static final String ITEM_BUCKET_EMPTY = func("minecraft:item.bucket.empty");
    @PythonField("minecraft:item.bucket.empty_lava")
    public static final String ITEM_BUCKET_EMPTY_LAVA = func("minecraft:item.bucket.empty_lava");
    @PythonField("minecraft:item.bucket.fill")
    public static final String ITEM_BUCKET_FILL = func("minecraft:item.bucket.fill");
    @PythonField("minecraft:item.bucket.fill_lava")
    public static final String ITEM_BUCKET_FILL_LAVA = func("minecraft:item.bucket.fill_lava");
    @PythonField("minecraft:item.chorus_fruit.teleport")
    public static final String ITEM_CHORUS_FRUIT_TELEPORT = func("minecraft:item.chorus_fruit.teleport");
    @PythonField("minecraft:item.elytra.flying")
    public static final String ITEM_ELYTRA_FLYING = func("minecraft:item.elytra.flying");
    @PythonField("minecraft:item.firecharge.use")
    public static final String ITEM_FIRECHARGE_USE = func("minecraft:item.firecharge.use");
    @PythonField("minecraft:item.flintandsteel.use")
    public static final String ITEM_FLINTANDSTEEL_USE = func("minecraft:item.flintandsteel.use");
    @PythonField("minecraft:item.hoe.till")
    public static final String ITEM_HOE_TILL = func("minecraft:item.hoe.till");
    @PythonField("minecraft:item.shield.block")
    public static final String ITEM_SHIELD_BLOCK = func("minecraft:item.shield.block");
    @PythonField("minecraft:item.shield.break")
    public static final String ITEM_SHIELD_BREAK = func("minecraft:item.shield.break");
    @PythonField("minecraft:item.shovel.flatten")
    public static final String ITEM_SHOVEL_FLATTEN = func("minecraft:item.shovel.flatten");
    @PythonField("minecraft:item.totem.use")
    public static final String ITEM_TOTEM_USE = func("minecraft:item.totem.use");
    @PythonField("minecraft:music.creative")
    public static final String MUSIC_CREATIVE = func("minecraft:music.creative");
    @PythonField("minecraft:music.credits")
    public static final String MUSIC_CREDITS = func("minecraft:music.credits");
    @PythonField("minecraft:music.dragon")
    public static final String MUSIC_DRAGON = func("minecraft:music.dragon");
    @PythonField("minecraft:music.end")
    public static final String MUSIC_END = func("minecraft:music.end");
    @PythonField("minecraft:music.game")
    public static final String MUSIC_GAME = func("minecraft:music.game");
    @PythonField("minecraft:music.menu")
    public static final String MUSIC_MENU = func("minecraft:music.menu");
    @PythonField("minecraft:music.nether")
    public static final String MUSIC_NETHER = func("minecraft:music.nether");
    @PythonField("minecraft:record.11")
    public static final String RECORD_11 = func("minecraft:record.11");
    @PythonField("minecraft:record.13")
    public static final String RECORD_13 = func("minecraft:record.13");
    @PythonField("minecraft:record.blocks")
    public static final String RECORD_BLOCKS = func("minecraft:record.blocks");
    @PythonField("minecraft:record.cat")
    public static final String RECORD_CAT = func("minecraft:record.cat");
    @PythonField("minecraft:record.chirp")
    public static final String RECORD_CHIRP = func("minecraft:record.chirp");
    @PythonField("minecraft:record.far")
    public static final String RECORD_FAR = func("minecraft:record.far");
    @PythonField("minecraft:record.mall")
    public static final String RECORD_MALL = func("minecraft:record.mall");
    @PythonField("minecraft:record.mellohi")
    public static final String RECORD_MELLOHI = func("minecraft:record.mellohi");
    @PythonField("minecraft:record.stal")
    public static final String RECORD_STAL = func("minecraft:record.stal");
    @PythonField("minecraft:record.strad")
    public static final String RECORD_STRAD = func("minecraft:record.strad");
    @PythonField("minecraft:record.wait")
    public static final String RECORD_WAIT = func("minecraft:record.wait");
    @PythonField("minecraft:record.ward")
    public static final String RECORD_WARD = func("minecraft:record.ward");
    @PythonField("minecraft:ui.button.click")
    public static final String UI_BUTTON_CLICK = func("minecraft:ui.button.click");
    @PythonField("minecraft:ui.toast.in")
    public static final String UI_TOAST_IN = func("minecraft:ui.toast.in");
    @PythonField("minecraft:ui.toast.out")
    public static final String UI_TOAST_OUT = func("minecraft:ui.toast.out");
    @PythonField("minecraft:ui.toast.challenge_complete")
    public static final String UI_TOAST_CHALLENGE_COMPLETE = func("minecraft:ui.toast.challenge_complete");
    @PythonField("minecraft:weather.rain")
    public static final String WEATHER_RAIN = func("minecraft:weather.rain");
    @PythonField("minecraft:weather.rain.above")
    public static final String WEATHER_RAIN_ABOVE = func("minecraft:weather.rain.above");

    @PythonFunction
    @PythonDocString("Returns a list of all the vanilla Soundss.")
    public static PyList getAllSounds() {
        return names;
    }

    private static String func(String s) {
        names.add(new PyString(s));
        return s;
    }
}