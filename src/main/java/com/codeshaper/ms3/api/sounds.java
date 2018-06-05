package com.codeshaper.ms3.api;

import org.python.core.PyString;
import org.python.core.PyList;

import com.codeshaper.ms3.apiBuilder.annotation.PythonClass;
import com.codeshaper.ms3.apiBuilder.annotation.PythonDocString;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFieldGenerated;
import com.codeshaper.ms3.apiBuilder.annotation.PythonFunction;

@PythonClass
@PythonDocString("A list of all the vanilla Sound names.")
public class sounds {

    private static PyList names = new PyList();

    private sounds() { }

    @PythonFieldGenerated
    public static final String AMBIENT_CAVE = func("minecraft:ambient.cave");
    @PythonFieldGenerated
    public static final String BLOCK_ANVIL_BREAK = func("minecraft:block.anvil.break");
    @PythonFieldGenerated
    public static final String BLOCK_ANVIL_DESTROY = func("minecraft:block.anvil.destroy");
    @PythonFieldGenerated
    public static final String BLOCK_ANVIL_FALL = func("minecraft:block.anvil.fall");
    @PythonFieldGenerated
    public static final String BLOCK_ANVIL_HIT = func("minecraft:block.anvil.hit");
    @PythonFieldGenerated
    public static final String BLOCK_ANVIL_LAND = func("minecraft:block.anvil.land");
    @PythonFieldGenerated
    public static final String BLOCK_ANVIL_PLACE = func("minecraft:block.anvil.place");
    @PythonFieldGenerated
    public static final String BLOCK_ANVIL_STEP = func("minecraft:block.anvil.step");
    @PythonFieldGenerated
    public static final String BLOCK_ANVIL_USE = func("minecraft:block.anvil.use");
    @PythonFieldGenerated
    public static final String BLOCK_BREWING_STAND_BREW = func("minecraft:block.brewing_stand.brew");
    @PythonFieldGenerated
    public static final String BLOCK_CHEST_CLOSE = func("minecraft:block.chest.close");
    @PythonFieldGenerated
    public static final String BLOCK_CHEST_LOCKED = func("minecraft:block.chest.locked");
    @PythonFieldGenerated
    public static final String BLOCK_CHEST_OPEN = func("minecraft:block.chest.open");
    @PythonFieldGenerated
    public static final String BLOCK_CHORUS_FLOWER_DEATH = func("minecraft:block.chorus_flower.death");
    @PythonFieldGenerated
    public static final String BLOCK_CHORUS_FLOWER_GROW = func("minecraft:block.chorus_flower.grow");
    @PythonFieldGenerated
    public static final String BLOCK_CLOTH_BREAK = func("minecraft:block.cloth.break");
    @PythonFieldGenerated
    public static final String BLOCK_CLOTH_FALL = func("minecraft:block.cloth.fall");
    @PythonFieldGenerated
    public static final String BLOCK_CLOTH_HIT = func("minecraft:block.cloth.hit");
    @PythonFieldGenerated
    public static final String BLOCK_CLOTH_PLACE = func("minecraft:block.cloth.place");
    @PythonFieldGenerated
    public static final String BLOCK_CLOTH_STEP = func("minecraft:block.cloth.step");
    @PythonFieldGenerated
    public static final String BLOCK_COMPARATOR_CLICK = func("minecraft:block.comparator.click");
    @PythonFieldGenerated
    public static final String BLOCK_DISPENSER_DISPENSE = func("minecraft:block.dispenser.dispense");
    @PythonFieldGenerated
    public static final String BLOCK_DISPENSER_FAIL = func("minecraft:block.dispenser.fail");
    @PythonFieldGenerated
    public static final String BLOCK_DISPENSER_LAUNCH = func("minecraft:block.dispenser.launch");
    @PythonFieldGenerated
    public static final String BLOCK_ENCHANTMENT_TABLE_USE = func("minecraft:block.enchantment_table.use");
    @PythonFieldGenerated
    public static final String BLOCK_END_GATEWAY_SPAWN = func("minecraft:block.end_gateway.spawn");
    @PythonFieldGenerated
    public static final String BLOCK_END_PORTAL_SPAWN = func("minecraft:block.end_portal.spawn");
    @PythonFieldGenerated
    public static final String BLOCK_END_PORTAL_FRAME_FILL = func("minecraft:block.end_portal_frame.fill");
    @PythonFieldGenerated
    public static final String BLOCK_ENDERCHEST_CLOSE = func("minecraft:block.enderchest.close");
    @PythonFieldGenerated
    public static final String BLOCK_ENDERCHEST_OPEN = func("minecraft:block.enderchest.open");
    @PythonFieldGenerated
    public static final String BLOCK_FENCE_GATE_CLOSE = func("minecraft:block.fence_gate.close");
    @PythonFieldGenerated
    public static final String BLOCK_FENCE_GATE_OPEN = func("minecraft:block.fence_gate.open");
    @PythonFieldGenerated
    public static final String BLOCK_FIRE_AMBIENT = func("minecraft:block.fire.ambient");
    @PythonFieldGenerated
    public static final String BLOCK_FIRE_EXTINGUISH = func("minecraft:block.fire.extinguish");
    @PythonFieldGenerated
    public static final String BLOCK_FURNACE_FIRE_CRACKLE = func("minecraft:block.furnace.fire_crackle");
    @PythonFieldGenerated
    public static final String BLOCK_GLASS_BREAK = func("minecraft:block.glass.break");
    @PythonFieldGenerated
    public static final String BLOCK_GLASS_FALL = func("minecraft:block.glass.fall");
    @PythonFieldGenerated
    public static final String BLOCK_GLASS_HIT = func("minecraft:block.glass.hit");
    @PythonFieldGenerated
    public static final String BLOCK_GLASS_PLACE = func("minecraft:block.glass.place");
    @PythonFieldGenerated
    public static final String BLOCK_GLASS_STEP = func("minecraft:block.glass.step");
    @PythonFieldGenerated
    public static final String BLOCK_GRASS_BREAK = func("minecraft:block.grass.break");
    @PythonFieldGenerated
    public static final String BLOCK_GRASS_FALL = func("minecraft:block.grass.fall");
    @PythonFieldGenerated
    public static final String BLOCK_GRASS_HIT = func("minecraft:block.grass.hit");
    @PythonFieldGenerated
    public static final String BLOCK_GRASS_PLACE = func("minecraft:block.grass.place");
    @PythonFieldGenerated
    public static final String BLOCK_GRASS_STEP = func("minecraft:block.grass.step");
    @PythonFieldGenerated
    public static final String BLOCK_GRAVEL_BREAK = func("minecraft:block.gravel.break");
    @PythonFieldGenerated
    public static final String BLOCK_GRAVEL_FALL = func("minecraft:block.gravel.fall");
    @PythonFieldGenerated
    public static final String BLOCK_GRAVEL_HIT = func("minecraft:block.gravel.hit");
    @PythonFieldGenerated
    public static final String BLOCK_GRAVEL_PLACE = func("minecraft:block.gravel.place");
    @PythonFieldGenerated
    public static final String BLOCK_GRAVEL_STEP = func("minecraft:block.gravel.step");
    @PythonFieldGenerated
    public static final String BLOCK_IRON_DOOR_CLOSE = func("minecraft:block.iron_door.close");
    @PythonFieldGenerated
    public static final String BLOCK_IRON_DOOR_OPEN = func("minecraft:block.iron_door.open");
    @PythonFieldGenerated
    public static final String BLOCK_IRON_TRAPDOOR_CLOSE = func("minecraft:block.iron_trapdoor.close");
    @PythonFieldGenerated
    public static final String BLOCK_IRON_TRAPDOOR_OPEN = func("minecraft:block.iron_trapdoor.open");
    @PythonFieldGenerated
    public static final String BLOCK_LADDER_BREAK = func("minecraft:block.ladder.break");
    @PythonFieldGenerated
    public static final String BLOCK_LADDER_FALL = func("minecraft:block.ladder.fall");
    @PythonFieldGenerated
    public static final String BLOCK_LADDER_HIT = func("minecraft:block.ladder.hit");
    @PythonFieldGenerated
    public static final String BLOCK_LADDER_PLACE = func("minecraft:block.ladder.place");
    @PythonFieldGenerated
    public static final String BLOCK_LADDER_STEP = func("minecraft:block.ladder.step");
    @PythonFieldGenerated
    public static final String BLOCK_LAVA_AMBIENT = func("minecraft:block.lava.ambient");
    @PythonFieldGenerated
    public static final String BLOCK_LAVA_EXTINGUISH = func("minecraft:block.lava.extinguish");
    @PythonFieldGenerated
    public static final String BLOCK_LAVA_POP = func("minecraft:block.lava.pop");
    @PythonFieldGenerated
    public static final String BLOCK_LEVER_CLICK = func("minecraft:block.lever.click");
    @PythonFieldGenerated
    public static final String BLOCK_METAL_BREAK = func("minecraft:block.metal.break");
    @PythonFieldGenerated
    public static final String BLOCK_METAL_FALL = func("minecraft:block.metal.fall");
    @PythonFieldGenerated
    public static final String BLOCK_METAL_HIT = func("minecraft:block.metal.hit");
    @PythonFieldGenerated
    public static final String BLOCK_METAL_PLACE = func("minecraft:block.metal.place");
    @PythonFieldGenerated
    public static final String BLOCK_METAL_STEP = func("minecraft:block.metal.step");
    @PythonFieldGenerated
    public static final String BLOCK_METAL_PRESSUREPLATE_CLICK_OFF = func("minecraft:block.metal_pressureplate.click_off");
    @PythonFieldGenerated
    public static final String BLOCK_METAL_PRESSUREPLATE_CLICK_ON = func("minecraft:block.metal_pressureplate.click_on");
    @PythonFieldGenerated
    public static final String BLOCK_NOTE_BASEDRUM = func("minecraft:block.note.basedrum");
    @PythonFieldGenerated
    public static final String BLOCK_NOTE_BASS = func("minecraft:block.note.bass");
    @PythonFieldGenerated
    public static final String BLOCK_NOTE_BELL = func("minecraft:block.note.bell");
    @PythonFieldGenerated
    public static final String BLOCK_NOTE_CHIME = func("minecraft:block.note.chime");
    @PythonFieldGenerated
    public static final String BLOCK_NOTE_FLUTE = func("minecraft:block.note.flute");
    @PythonFieldGenerated
    public static final String BLOCK_NOTE_GUITAR = func("minecraft:block.note.guitar");
    @PythonFieldGenerated
    public static final String BLOCK_NOTE_HARP = func("minecraft:block.note.harp");
    @PythonFieldGenerated
    public static final String BLOCK_NOTE_HAT = func("minecraft:block.note.hat");
    @PythonFieldGenerated
    public static final String BLOCK_NOTE_PLING = func("minecraft:block.note.pling");
    @PythonFieldGenerated
    public static final String BLOCK_NOTE_SNARE = func("minecraft:block.note.snare");
    @PythonFieldGenerated
    public static final String BLOCK_NOTE_XYLOPHONE = func("minecraft:block.note.xylophone");
    @PythonFieldGenerated
    public static final String BLOCK_PISTON_CONTRACT = func("minecraft:block.piston.contract");
    @PythonFieldGenerated
    public static final String BLOCK_PISTON_EXTEND = func("minecraft:block.piston.extend");
    @PythonFieldGenerated
    public static final String BLOCK_PORTAL_AMBIENT = func("minecraft:block.portal.ambient");
    @PythonFieldGenerated
    public static final String BLOCK_PORTAL_TRAVEL = func("minecraft:block.portal.travel");
    @PythonFieldGenerated
    public static final String BLOCK_PORTAL_TRIGGER = func("minecraft:block.portal.trigger");
    @PythonFieldGenerated
    public static final String BLOCK_REDSTONE_TORCH_BURNOUT = func("minecraft:block.redstone_torch.burnout");
    @PythonFieldGenerated
    public static final String BLOCK_SAND_BREAK = func("minecraft:block.sand.break");
    @PythonFieldGenerated
    public static final String BLOCK_SAND_FALL = func("minecraft:block.sand.fall");
    @PythonFieldGenerated
    public static final String BLOCK_SAND_HIT = func("minecraft:block.sand.hit");
    @PythonFieldGenerated
    public static final String BLOCK_SAND_PLACE = func("minecraft:block.sand.place");
    @PythonFieldGenerated
    public static final String BLOCK_SAND_STEP = func("minecraft:block.sand.step");
    @PythonFieldGenerated
    public static final String BLOCK_SHULKER_BOX_CLOSE = func("minecraft:block.shulker_box.close");
    @PythonFieldGenerated
    public static final String BLOCK_SHULKER_BOX_OPEN = func("minecraft:block.shulker_box.open");
    @PythonFieldGenerated
    public static final String BLOCK_SLIME_BREAK = func("minecraft:block.slime.break");
    @PythonFieldGenerated
    public static final String BLOCK_SLIME_FALL = func("minecraft:block.slime.fall");
    @PythonFieldGenerated
    public static final String BLOCK_SLIME_HIT = func("minecraft:block.slime.hit");
    @PythonFieldGenerated
    public static final String BLOCK_SLIME_PLACE = func("minecraft:block.slime.place");
    @PythonFieldGenerated
    public static final String BLOCK_SLIME_STEP = func("minecraft:block.slime.step");
    @PythonFieldGenerated
    public static final String BLOCK_SNOW_BREAK = func("minecraft:block.snow.break");
    @PythonFieldGenerated
    public static final String BLOCK_SNOW_FALL = func("minecraft:block.snow.fall");
    @PythonFieldGenerated
    public static final String BLOCK_SNOW_HIT = func("minecraft:block.snow.hit");
    @PythonFieldGenerated
    public static final String BLOCK_SNOW_PLACE = func("minecraft:block.snow.place");
    @PythonFieldGenerated
    public static final String BLOCK_SNOW_STEP = func("minecraft:block.snow.step");
    @PythonFieldGenerated
    public static final String BLOCK_STONE_BREAK = func("minecraft:block.stone.break");
    @PythonFieldGenerated
    public static final String BLOCK_STONE_FALL = func("minecraft:block.stone.fall");
    @PythonFieldGenerated
    public static final String BLOCK_STONE_HIT = func("minecraft:block.stone.hit");
    @PythonFieldGenerated
    public static final String BLOCK_STONE_PLACE = func("minecraft:block.stone.place");
    @PythonFieldGenerated
    public static final String BLOCK_STONE_STEP = func("minecraft:block.stone.step");
    @PythonFieldGenerated
    public static final String BLOCK_STONE_BUTTON_CLICK_OFF = func("minecraft:block.stone_button.click_off");
    @PythonFieldGenerated
    public static final String BLOCK_STONE_BUTTON_CLICK_ON = func("minecraft:block.stone_button.click_on");
    @PythonFieldGenerated
    public static final String BLOCK_STONE_PRESSUREPLATE_CLICK_OFF = func("minecraft:block.stone_pressureplate.click_off");
    @PythonFieldGenerated
    public static final String BLOCK_STONE_PRESSUREPLATE_CLICK_ON = func("minecraft:block.stone_pressureplate.click_on");
    @PythonFieldGenerated
    public static final String BLOCK_TRIPWIRE_ATTACH = func("minecraft:block.tripwire.attach");
    @PythonFieldGenerated
    public static final String BLOCK_TRIPWIRE_CLICK_OFF = func("minecraft:block.tripwire.click_off");
    @PythonFieldGenerated
    public static final String BLOCK_TRIPWIRE_CLICK_ON = func("minecraft:block.tripwire.click_on");
    @PythonFieldGenerated
    public static final String BLOCK_TRIPWIRE_DETACH = func("minecraft:block.tripwire.detach");
    @PythonFieldGenerated
    public static final String BLOCK_WATER_AMBIENT = func("minecraft:block.water.ambient");
    @PythonFieldGenerated
    public static final String BLOCK_WATERLILY_PLACE = func("minecraft:block.waterlily.place");
    @PythonFieldGenerated
    public static final String BLOCK_WOOD_BREAK = func("minecraft:block.wood.break");
    @PythonFieldGenerated
    public static final String BLOCK_WOOD_FALL = func("minecraft:block.wood.fall");
    @PythonFieldGenerated
    public static final String BLOCK_WOOD_HIT = func("minecraft:block.wood.hit");
    @PythonFieldGenerated
    public static final String BLOCK_WOOD_PLACE = func("minecraft:block.wood.place");
    @PythonFieldGenerated
    public static final String BLOCK_WOOD_STEP = func("minecraft:block.wood.step");
    @PythonFieldGenerated
    public static final String BLOCK_WOOD_BUTTON_CLICK_OFF = func("minecraft:block.wood_button.click_off");
    @PythonFieldGenerated
    public static final String BLOCK_WOOD_BUTTON_CLICK_ON = func("minecraft:block.wood_button.click_on");
    @PythonFieldGenerated
    public static final String BLOCK_WOOD_PRESSUREPLATE_CLICK_OFF = func("minecraft:block.wood_pressureplate.click_off");
    @PythonFieldGenerated
    public static final String BLOCK_WOOD_PRESSUREPLATE_CLICK_ON = func("minecraft:block.wood_pressureplate.click_on");
    @PythonFieldGenerated
    public static final String BLOCK_WOODEN_DOOR_CLOSE = func("minecraft:block.wooden_door.close");
    @PythonFieldGenerated
    public static final String BLOCK_WOODEN_DOOR_OPEN = func("minecraft:block.wooden_door.open");
    @PythonFieldGenerated
    public static final String BLOCK_WOODEN_TRAPDOOR_CLOSE = func("minecraft:block.wooden_trapdoor.close");
    @PythonFieldGenerated
    public static final String BLOCK_WOODEN_TRAPDOOR_OPEN = func("minecraft:block.wooden_trapdoor.open");
    @PythonFieldGenerated
    public static final String ENCHANT_THORNS_HIT = func("minecraft:enchant.thorns.hit");
    @PythonFieldGenerated
    public static final String ENTITY_ARMORSTAND_BREAK = func("minecraft:entity.armorstand.break");
    @PythonFieldGenerated
    public static final String ENTITY_ARMORSTAND_FALL = func("minecraft:entity.armorstand.fall");
    @PythonFieldGenerated
    public static final String ENTITY_ARMORSTAND_HIT = func("minecraft:entity.armorstand.hit");
    @PythonFieldGenerated
    public static final String ENTITY_ARMORSTAND_PLACE = func("minecraft:entity.armorstand.place");
    @PythonFieldGenerated
    public static final String ENTITY_ARROW_HIT = func("minecraft:entity.arrow.hit");
    @PythonFieldGenerated
    public static final String ENTITY_ARROW_HIT_PLAYER = func("minecraft:entity.arrow.hit_player");
    @PythonFieldGenerated
    public static final String ENTITY_ARROW_SHOOT = func("minecraft:entity.arrow.shoot");
    @PythonFieldGenerated
    public static final String ENTITY_BAT_AMBIENT = func("minecraft:entity.bat.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_BAT_DEATH = func("minecraft:entity.bat.death");
    @PythonFieldGenerated
    public static final String ENTITY_BAT_HURT = func("minecraft:entity.bat.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_BAT_LOOP = func("minecraft:entity.bat.loop");
    @PythonFieldGenerated
    public static final String ENTITY_BAT_TAKEOFF = func("minecraft:entity.bat.takeoff");
    @PythonFieldGenerated
    public static final String ENTITY_BLAZE_AMBIENT = func("minecraft:entity.blaze.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_BLAZE_BURN = func("minecraft:entity.blaze.burn");
    @PythonFieldGenerated
    public static final String ENTITY_BLAZE_DEATH = func("minecraft:entity.blaze.death");
    @PythonFieldGenerated
    public static final String ENTITY_BLAZE_HURT = func("minecraft:entity.blaze.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_BLAZE_SHOOT = func("minecraft:entity.blaze.shoot");
    @PythonFieldGenerated
    public static final String ENTITY_BOAT_PADDLE_LAND = func("minecraft:entity.boat.paddle_land");
    @PythonFieldGenerated
    public static final String ENTITY_BOAT_PADDLE_WATER = func("minecraft:entity.boat.paddle_water");
    @PythonFieldGenerated
    public static final String ENTITY_BOBBER_RETRIEVE = func("minecraft:entity.bobber.retrieve");
    @PythonFieldGenerated
    public static final String ENTITY_BOBBER_SPLASH = func("minecraft:entity.bobber.splash");
    @PythonFieldGenerated
    public static final String ENTITY_BOBBER_THROW = func("minecraft:entity.bobber.throw");
    @PythonFieldGenerated
    public static final String ENTITY_CAT_AMBIENT = func("minecraft:entity.cat.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_CAT_DEATH = func("minecraft:entity.cat.death");
    @PythonFieldGenerated
    public static final String ENTITY_CAT_HISS = func("minecraft:entity.cat.hiss");
    @PythonFieldGenerated
    public static final String ENTITY_CAT_HURT = func("minecraft:entity.cat.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_CAT_PURR = func("minecraft:entity.cat.purr");
    @PythonFieldGenerated
    public static final String ENTITY_CAT_PURREOW = func("minecraft:entity.cat.purreow");
    @PythonFieldGenerated
    public static final String ENTITY_CHICKEN_AMBIENT = func("minecraft:entity.chicken.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_CHICKEN_DEATH = func("minecraft:entity.chicken.death");
    @PythonFieldGenerated
    public static final String ENTITY_CHICKEN_EGG = func("minecraft:entity.chicken.egg");
    @PythonFieldGenerated
    public static final String ENTITY_CHICKEN_HURT = func("minecraft:entity.chicken.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_CHICKEN_STEP = func("minecraft:entity.chicken.step");
    @PythonFieldGenerated
    public static final String ENTITY_COW_AMBIENT = func("minecraft:entity.cow.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_COW_DEATH = func("minecraft:entity.cow.death");
    @PythonFieldGenerated
    public static final String ENTITY_COW_HURT = func("minecraft:entity.cow.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_COW_MILK = func("minecraft:entity.cow.milk");
    @PythonFieldGenerated
    public static final String ENTITY_COW_STEP = func("minecraft:entity.cow.step");
    @PythonFieldGenerated
    public static final String ENTITY_CREEPER_DEATH = func("minecraft:entity.creeper.death");
    @PythonFieldGenerated
    public static final String ENTITY_CREEPER_HURT = func("minecraft:entity.creeper.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_CREEPER_PRIMED = func("minecraft:entity.creeper.primed");
    @PythonFieldGenerated
    public static final String ENTITY_DONKEY_AMBIENT = func("minecraft:entity.donkey.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_DONKEY_ANGRY = func("minecraft:entity.donkey.angry");
    @PythonFieldGenerated
    public static final String ENTITY_DONKEY_CHEST = func("minecraft:entity.donkey.chest");
    @PythonFieldGenerated
    public static final String ENTITY_DONKEY_DEATH = func("minecraft:entity.donkey.death");
    @PythonFieldGenerated
    public static final String ENTITY_DONKEY_HURT = func("minecraft:entity.donkey.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_EGG_THROW = func("minecraft:entity.egg.throw");
    @PythonFieldGenerated
    public static final String ENTITY_ELDER_GUARDIAN_AMBIENT = func("minecraft:entity.elder_guardian.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_ELDER_GUARDIAN_AMBIENT_LAND = func("minecraft:entity.elder_guardian.ambient_land");
    @PythonFieldGenerated
    public static final String ENTITY_ELDER_GUARDIAN_CURSE = func("minecraft:entity.elder_guardian.curse");
    @PythonFieldGenerated
    public static final String ENTITY_ELDER_GUARDIAN_DEATH = func("minecraft:entity.elder_guardian.death");
    @PythonFieldGenerated
    public static final String ENTITY_ELDER_GUARDIAN_DEATH_LAND = func("minecraft:entity.elder_guardian.death_land");
    @PythonFieldGenerated
    public static final String ENTITY_ELDER_GUARDIAN_FLOP = func("minecraft:entity.elder_guardian.flop");
    @PythonFieldGenerated
    public static final String ENTITY_ELDER_GUARDIAN_HURT = func("minecraft:entity.elder_guardian.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_ELDER_GUARDIAN_HURT_LAND = func("minecraft:entity.elder_guardian.hurt_land");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERDRAGON_AMBIENT = func("minecraft:entity.enderdragon.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERDRAGON_DEATH = func("minecraft:entity.enderdragon.death");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERDRAGON_FLAP = func("minecraft:entity.enderdragon.flap");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERDRAGON_GROWL = func("minecraft:entity.enderdragon.growl");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERDRAGON_HURT = func("minecraft:entity.enderdragon.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERDRAGON_SHOOT = func("minecraft:entity.enderdragon.shoot");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERDRAGON_FIREBALL_EXPLODE = func("minecraft:entity.enderdragon_fireball.explode");
    @PythonFieldGenerated
    public static final String ENTITY_ENDEREYE_DEATH = func("minecraft:entity.endereye.death");
    @PythonFieldGenerated
    public static final String ENTITY_ENDEREYE_LAUNCH = func("minecraft:entity.endereye.launch");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERMEN_AMBIENT = func("minecraft:entity.endermen.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERMEN_DEATH = func("minecraft:entity.endermen.death");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERMEN_HURT = func("minecraft:entity.endermen.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERMEN_SCREAM = func("minecraft:entity.endermen.scream");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERMEN_STARE = func("minecraft:entity.endermen.stare");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERMEN_TELEPORT = func("minecraft:entity.endermen.teleport");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERMITE_AMBIENT = func("minecraft:entity.endermite.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERMITE_DEATH = func("minecraft:entity.endermite.death");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERMITE_HURT = func("minecraft:entity.endermite.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERMITE_STEP = func("minecraft:entity.endermite.step");
    @PythonFieldGenerated
    public static final String ENTITY_ENDERPEARL_THROW = func("minecraft:entity.enderpearl.throw");
    @PythonFieldGenerated
    public static final String ENTITY_EVOCATION_FANGS_ATTACK = func("minecraft:entity.evocation_fangs.attack");
    @PythonFieldGenerated
    public static final String ENTITY_EVOCATION_ILLAGER_AMBIENT = func("minecraft:entity.evocation_illager.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_EVOCATION_ILLAGER_CAST_SPELL = func("minecraft:entity.evocation_illager.cast_spell");
    @PythonFieldGenerated
    public static final String ENTITY_EVOCATION_ILLAGER_DEATH = func("minecraft:entity.evocation_illager.death");
    @PythonFieldGenerated
    public static final String ENTITY_EVOCATION_ILLAGER_HURT = func("minecraft:entity.evocation_illager.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_EVOCATION_ILLAGER_PREPARE_ATTACK = func("minecraft:entity.evocation_illager.prepare_attack");
    @PythonFieldGenerated
    public static final String ENTITY_EVOCATION_ILLAGER_PREPARE_SUMMON = func("minecraft:entity.evocation_illager.prepare_summon");
    @PythonFieldGenerated
    public static final String ENTITY_EVOCATION_ILLAGER_PREPARE_WOLOLO = func("minecraft:entity.evocation_illager.prepare_wololo");
    @PythonFieldGenerated
    public static final String ENTITY_EXPERIENCE_BOTTLE_THROW = func("minecraft:entity.experience_bottle.throw");
    @PythonFieldGenerated
    public static final String ENTITY_EXPERIENCE_ORB_PICKUP = func("minecraft:entity.experience_orb.pickup");
    @PythonFieldGenerated
    public static final String ENTITY_FIREWORK_BLAST = func("minecraft:entity.firework.blast");
    @PythonFieldGenerated
    public static final String ENTITY_FIREWORK_BLAST_FAR = func("minecraft:entity.firework.blast_far");
    @PythonFieldGenerated
    public static final String ENTITY_FIREWORK_LARGE_BLAST = func("minecraft:entity.firework.large_blast");
    @PythonFieldGenerated
    public static final String ENTITY_FIREWORK_LARGE_BLAST_FAR = func("minecraft:entity.firework.large_blast_far");
    @PythonFieldGenerated
    public static final String ENTITY_FIREWORK_LAUNCH = func("minecraft:entity.firework.launch");
    @PythonFieldGenerated
    public static final String ENTITY_FIREWORK_SHOOT = func("minecraft:entity.firework.shoot");
    @PythonFieldGenerated
    public static final String ENTITY_FIREWORK_TWINKLE = func("minecraft:entity.firework.twinkle");
    @PythonFieldGenerated
    public static final String ENTITY_FIREWORK_TWINKLE_FAR = func("minecraft:entity.firework.twinkle_far");
    @PythonFieldGenerated
    public static final String ENTITY_GENERIC_BIG_FALL = func("minecraft:entity.generic.big_fall");
    @PythonFieldGenerated
    public static final String ENTITY_GENERIC_BURN = func("minecraft:entity.generic.burn");
    @PythonFieldGenerated
    public static final String ENTITY_GENERIC_DEATH = func("minecraft:entity.generic.death");
    @PythonFieldGenerated
    public static final String ENTITY_GENERIC_DRINK = func("minecraft:entity.generic.drink");
    @PythonFieldGenerated
    public static final String ENTITY_GENERIC_EAT = func("minecraft:entity.generic.eat");
    @PythonFieldGenerated
    public static final String ENTITY_GENERIC_EXPLODE = func("minecraft:entity.generic.explode");
    @PythonFieldGenerated
    public static final String ENTITY_GENERIC_EXTINGUISH_FIRE = func("minecraft:entity.generic.extinguish_fire");
    @PythonFieldGenerated
    public static final String ENTITY_GENERIC_HURT = func("minecraft:entity.generic.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_GENERIC_SMALL_FALL = func("minecraft:entity.generic.small_fall");
    @PythonFieldGenerated
    public static final String ENTITY_GENERIC_SPLASH = func("minecraft:entity.generic.splash");
    @PythonFieldGenerated
    public static final String ENTITY_GENERIC_SWIM = func("minecraft:entity.generic.swim");
    @PythonFieldGenerated
    public static final String ENTITY_GHAST_AMBIENT = func("minecraft:entity.ghast.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_GHAST_DEATH = func("minecraft:entity.ghast.death");
    @PythonFieldGenerated
    public static final String ENTITY_GHAST_HURT = func("minecraft:entity.ghast.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_GHAST_SCREAM = func("minecraft:entity.ghast.scream");
    @PythonFieldGenerated
    public static final String ENTITY_GHAST_SHOOT = func("minecraft:entity.ghast.shoot");
    @PythonFieldGenerated
    public static final String ENTITY_GHAST_WARN = func("minecraft:entity.ghast.warn");
    @PythonFieldGenerated
    public static final String ENTITY_GUARDIAN_AMBIENT = func("minecraft:entity.guardian.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_GUARDIAN_AMBIENT_LAND = func("minecraft:entity.guardian.ambient_land");
    @PythonFieldGenerated
    public static final String ENTITY_GUARDIAN_ATTACK = func("minecraft:entity.guardian.attack");
    @PythonFieldGenerated
    public static final String ENTITY_GUARDIAN_DEATH = func("minecraft:entity.guardian.death");
    @PythonFieldGenerated
    public static final String ENTITY_GUARDIAN_DEATH_LAND = func("minecraft:entity.guardian.death_land");
    @PythonFieldGenerated
    public static final String ENTITY_GUARDIAN_FLOP = func("minecraft:entity.guardian.flop");
    @PythonFieldGenerated
    public static final String ENTITY_GUARDIAN_HURT = func("minecraft:entity.guardian.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_GUARDIAN_HURT_LAND = func("minecraft:entity.guardian.hurt_land");
    @PythonFieldGenerated
    public static final String ENTITY_HORSE_AMBIENT = func("minecraft:entity.horse.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_HORSE_ANGRY = func("minecraft:entity.horse.angry");
    @PythonFieldGenerated
    public static final String ENTITY_HORSE_ARMOR = func("minecraft:entity.horse.armor");
    @PythonFieldGenerated
    public static final String ENTITY_HORSE_BREATHE = func("minecraft:entity.horse.breathe");
    @PythonFieldGenerated
    public static final String ENTITY_HORSE_DEATH = func("minecraft:entity.horse.death");
    @PythonFieldGenerated
    public static final String ENTITY_HORSE_EAT = func("minecraft:entity.horse.eat");
    @PythonFieldGenerated
    public static final String ENTITY_HORSE_GALLOP = func("minecraft:entity.horse.gallop");
    @PythonFieldGenerated
    public static final String ENTITY_HORSE_HURT = func("minecraft:entity.horse.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_HORSE_JUMP = func("minecraft:entity.horse.jump");
    @PythonFieldGenerated
    public static final String ENTITY_HORSE_LAND = func("minecraft:entity.horse.land");
    @PythonFieldGenerated
    public static final String ENTITY_HORSE_SADDLE = func("minecraft:entity.horse.saddle");
    @PythonFieldGenerated
    public static final String ENTITY_HORSE_STEP = func("minecraft:entity.horse.step");
    @PythonFieldGenerated
    public static final String ENTITY_HORSE_STEP_WOOD = func("minecraft:entity.horse.step_wood");
    @PythonFieldGenerated
    public static final String ENTITY_HOSTILE_BIG_FALL = func("minecraft:entity.hostile.big_fall");
    @PythonFieldGenerated
    public static final String ENTITY_HOSTILE_DEATH = func("minecraft:entity.hostile.death");
    @PythonFieldGenerated
    public static final String ENTITY_HOSTILE_HURT = func("minecraft:entity.hostile.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_HOSTILE_SMALL_FALL = func("minecraft:entity.hostile.small_fall");
    @PythonFieldGenerated
    public static final String ENTITY_HOSTILE_SPLASH = func("minecraft:entity.hostile.splash");
    @PythonFieldGenerated
    public static final String ENTITY_HOSTILE_SWIM = func("minecraft:entity.hostile.swim");
    @PythonFieldGenerated
    public static final String ENTITY_HUSK_AMBIENT = func("minecraft:entity.husk.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_HUSK_DEATH = func("minecraft:entity.husk.death");
    @PythonFieldGenerated
    public static final String ENTITY_HUSK_HURT = func("minecraft:entity.husk.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_HUSK_STEP = func("minecraft:entity.husk.step");
    @PythonFieldGenerated
    public static final String ENTITY_ILLUSION_ILLAGER_AMBIENT = func("minecraft:entity.illusion_illager.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_ILLUSION_ILLAGER_CAST_SPELL = func("minecraft:entity.illusion_illager.cast_spell");
    @PythonFieldGenerated
    public static final String ENTITY_ILLUSION_ILLAGER_DEATH = func("minecraft:entity.illusion_illager.death");
    @PythonFieldGenerated
    public static final String ENTITY_ILLUSION_ILLAGER_HURT = func("minecraft:entity.illusion_illager.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_ILLUSION_ILLAGER_MIRROR_MOVE = func("minecraft:entity.illusion_illager.mirror_move");
    @PythonFieldGenerated
    public static final String ENTITY_ILLUSION_ILLAGER_PREPARE_BLINDNESS = func("minecraft:entity.illusion_illager.prepare_blindness");
    @PythonFieldGenerated
    public static final String ENTITY_ILLUSION_ILLAGER_PREPARE_MIRROR = func("minecraft:entity.illusion_illager.prepare_mirror");
    @PythonFieldGenerated
    public static final String ENTITY_IRONGOLEM_ATTACK = func("minecraft:entity.irongolem.attack");
    @PythonFieldGenerated
    public static final String ENTITY_IRONGOLEM_DEATH = func("minecraft:entity.irongolem.death");
    @PythonFieldGenerated
    public static final String ENTITY_IRONGOLEM_HURT = func("minecraft:entity.irongolem.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_IRONGOLEM_STEP = func("minecraft:entity.irongolem.step");
    @PythonFieldGenerated
    public static final String ENTITY_ITEM_BREAK = func("minecraft:entity.item.break");
    @PythonFieldGenerated
    public static final String ENTITY_ITEM_PICKUP = func("minecraft:entity.item.pickup");
    @PythonFieldGenerated
    public static final String ENTITY_ITEMFRAME_ADD_ITEM = func("minecraft:entity.itemframe.add_item");
    @PythonFieldGenerated
    public static final String ENTITY_ITEMFRAME_BREAK = func("minecraft:entity.itemframe.break");
    @PythonFieldGenerated
    public static final String ENTITY_ITEMFRAME_PLACE = func("minecraft:entity.itemframe.place");
    @PythonFieldGenerated
    public static final String ENTITY_ITEMFRAME_REMOVE_ITEM = func("minecraft:entity.itemframe.remove_item");
    @PythonFieldGenerated
    public static final String ENTITY_ITEMFRAME_ROTATE_ITEM = func("minecraft:entity.itemframe.rotate_item");
    @PythonFieldGenerated
    public static final String ENTITY_LEASHKNOT_BREAK = func("minecraft:entity.leashknot.break");
    @PythonFieldGenerated
    public static final String ENTITY_LEASHKNOT_PLACE = func("minecraft:entity.leashknot.place");
    @PythonFieldGenerated
    public static final String ENTITY_LIGHTNING_IMPACT = func("minecraft:entity.lightning.impact");
    @PythonFieldGenerated
    public static final String ENTITY_LIGHTNING_THUNDER = func("minecraft:entity.lightning.thunder");
    @PythonFieldGenerated
    public static final String ENTITY_LINGERINGPOTION_THROW = func("minecraft:entity.lingeringpotion.throw");
    @PythonFieldGenerated
    public static final String ENTITY_LLAMA_AMBIENT = func("minecraft:entity.llama.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_LLAMA_ANGRY = func("minecraft:entity.llama.angry");
    @PythonFieldGenerated
    public static final String ENTITY_LLAMA_CHEST = func("minecraft:entity.llama.chest");
    @PythonFieldGenerated
    public static final String ENTITY_LLAMA_DEATH = func("minecraft:entity.llama.death");
    @PythonFieldGenerated
    public static final String ENTITY_LLAMA_EAT = func("minecraft:entity.llama.eat");
    @PythonFieldGenerated
    public static final String ENTITY_LLAMA_HURT = func("minecraft:entity.llama.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_LLAMA_SPIT = func("minecraft:entity.llama.spit");
    @PythonFieldGenerated
    public static final String ENTITY_LLAMA_STEP = func("minecraft:entity.llama.step");
    @PythonFieldGenerated
    public static final String ENTITY_LLAMA_SWAG = func("minecraft:entity.llama.swag");
    @PythonFieldGenerated
    public static final String ENTITY_MAGMACUBE_DEATH = func("minecraft:entity.magmacube.death");
    @PythonFieldGenerated
    public static final String ENTITY_MAGMACUBE_HURT = func("minecraft:entity.magmacube.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_MAGMACUBE_JUMP = func("minecraft:entity.magmacube.jump");
    @PythonFieldGenerated
    public static final String ENTITY_MAGMACUBE_SQUISH = func("minecraft:entity.magmacube.squish");
    @PythonFieldGenerated
    public static final String ENTITY_MINECART_INSIDE = func("minecraft:entity.minecart.inside");
    @PythonFieldGenerated
    public static final String ENTITY_MINECART_RIDING = func("minecraft:entity.minecart.riding");
    @PythonFieldGenerated
    public static final String ENTITY_MOOSHROOM_SHEAR = func("minecraft:entity.mooshroom.shear");
    @PythonFieldGenerated
    public static final String ENTITY_MULE_AMBIENT = func("minecraft:entity.mule.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_MULE_CHEST = func("minecraft:entity.mule.chest");
    @PythonFieldGenerated
    public static final String ENTITY_MULE_DEATH = func("minecraft:entity.mule.death");
    @PythonFieldGenerated
    public static final String ENTITY_MULE_HURT = func("minecraft:entity.mule.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_PAINTING_BREAK = func("minecraft:entity.painting.break");
    @PythonFieldGenerated
    public static final String ENTITY_PAINTING_PLACE = func("minecraft:entity.painting.place");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_AMBIENT = func("minecraft:entity.parrot.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_DEATH = func("minecraft:entity.parrot.death");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_EAT = func("minecraft:entity.parrot.eat");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_FLY = func("minecraft:entity.parrot.fly");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_HURT = func("minecraft:entity.parrot.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_BLAZE = func("minecraft:entity.parrot.imitate.blaze");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_CREEPER = func("minecraft:entity.parrot.imitate.creeper");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_ELDER_GUARDIAN = func("minecraft:entity.parrot.imitate.elder_guardian");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_ENDERDRAGON = func("minecraft:entity.parrot.imitate.enderdragon");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_ENDERMAN = func("minecraft:entity.parrot.imitate.enderman");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_ENDERMITE = func("minecraft:entity.parrot.imitate.endermite");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_EVOCATION_ILLAGER = func("minecraft:entity.parrot.imitate.evocation_illager");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_GHAST = func("minecraft:entity.parrot.imitate.ghast");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_HUSK = func("minecraft:entity.parrot.imitate.husk");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_ILLUSION_ILLAGER = func("minecraft:entity.parrot.imitate.illusion_illager");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_MAGMACUBE = func("minecraft:entity.parrot.imitate.magmacube");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_POLAR_BEAR = func("minecraft:entity.parrot.imitate.polar_bear");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_SHULKER = func("minecraft:entity.parrot.imitate.shulker");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_SILVERFISH = func("minecraft:entity.parrot.imitate.silverfish");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_SKELETON = func("minecraft:entity.parrot.imitate.skeleton");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_SLIME = func("minecraft:entity.parrot.imitate.slime");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_SPIDER = func("minecraft:entity.parrot.imitate.spider");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_STRAY = func("minecraft:entity.parrot.imitate.stray");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_VEX = func("minecraft:entity.parrot.imitate.vex");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_VINDICATION_ILLAGER = func("minecraft:entity.parrot.imitate.vindication_illager");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_WITCH = func("minecraft:entity.parrot.imitate.witch");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_WITHER = func("minecraft:entity.parrot.imitate.wither");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_WITHER_SKELETON = func("minecraft:entity.parrot.imitate.wither_skeleton");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_WOLF = func("minecraft:entity.parrot.imitate.wolf");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_ZOMBIE = func("minecraft:entity.parrot.imitate.zombie");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_ZOMBIE_PIGMAN = func("minecraft:entity.parrot.imitate.zombie_pigman");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_IMITATE_ZOMBIE_VILLAGER = func("minecraft:entity.parrot.imitate.zombie_villager");
    @PythonFieldGenerated
    public static final String ENTITY_PARROT_STEP = func("minecraft:entity.parrot.step");
    @PythonFieldGenerated
    public static final String ENTITY_PIG_AMBIENT = func("minecraft:entity.pig.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_PIG_DEATH = func("minecraft:entity.pig.death");
    @PythonFieldGenerated
    public static final String ENTITY_PIG_HURT = func("minecraft:entity.pig.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_PIG_SADDLE = func("minecraft:entity.pig.saddle");
    @PythonFieldGenerated
    public static final String ENTITY_PIG_STEP = func("minecraft:entity.pig.step");
    @PythonFieldGenerated
    public static final String ENTITY_PLAYER_ATTACK_CRIT = func("minecraft:entity.player.attack.crit");
    @PythonFieldGenerated
    public static final String ENTITY_PLAYER_ATTACK_KNOCKBACK = func("minecraft:entity.player.attack.knockback");
    @PythonFieldGenerated
    public static final String ENTITY_PLAYER_ATTACK_NODAMAGE = func("minecraft:entity.player.attack.nodamage");
    @PythonFieldGenerated
    public static final String ENTITY_PLAYER_ATTACK_STRONG = func("minecraft:entity.player.attack.strong");
    @PythonFieldGenerated
    public static final String ENTITY_PLAYER_ATTACK_SWEEP = func("minecraft:entity.player.attack.sweep");
    @PythonFieldGenerated
    public static final String ENTITY_PLAYER_ATTACK_WEAK = func("minecraft:entity.player.attack.weak");
    @PythonFieldGenerated
    public static final String ENTITY_PLAYER_BIG_FALL = func("minecraft:entity.player.big_fall");
    @PythonFieldGenerated
    public static final String ENTITY_PLAYER_BREATH = func("minecraft:entity.player.breath");
    @PythonFieldGenerated
    public static final String ENTITY_PLAYER_BURP = func("minecraft:entity.player.burp");
    @PythonFieldGenerated
    public static final String ENTITY_PLAYER_DEATH = func("minecraft:entity.player.death");
    @PythonFieldGenerated
    public static final String ENTITY_PLAYER_HURT = func("minecraft:entity.player.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_PLAYER_HURT_DROWN = func("minecraft:entity.player.hurt_drown");
    @PythonFieldGenerated
    public static final String ENTITY_PLAYER_HURT_ON_FIRE = func("minecraft:entity.player.hurt_on_fire");
    @PythonFieldGenerated
    public static final String ENTITY_PLAYER_LEVELUP = func("minecraft:entity.player.levelup");
    @PythonFieldGenerated
    public static final String ENTITY_PLAYER_SMALL_FALL = func("minecraft:entity.player.small_fall");
    @PythonFieldGenerated
    public static final String ENTITY_PLAYER_SPLASH = func("minecraft:entity.player.splash");
    @PythonFieldGenerated
    public static final String ENTITY_PLAYER_SWIM = func("minecraft:entity.player.swim");
    @PythonFieldGenerated
    public static final String ENTITY_POLAR_BEAR_AMBIENT = func("minecraft:entity.polar_bear.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_POLAR_BEAR_BABY_AMBIENT = func("minecraft:entity.polar_bear.baby_ambient");
    @PythonFieldGenerated
    public static final String ENTITY_POLAR_BEAR_DEATH = func("minecraft:entity.polar_bear.death");
    @PythonFieldGenerated
    public static final String ENTITY_POLAR_BEAR_HURT = func("minecraft:entity.polar_bear.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_POLAR_BEAR_STEP = func("minecraft:entity.polar_bear.step");
    @PythonFieldGenerated
    public static final String ENTITY_POLAR_BEAR_WARNING = func("minecraft:entity.polar_bear.warning");
    @PythonFieldGenerated
    public static final String ENTITY_RABBIT_AMBIENT = func("minecraft:entity.rabbit.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_RABBIT_ATTACK = func("minecraft:entity.rabbit.attack");
    @PythonFieldGenerated
    public static final String ENTITY_RABBIT_DEATH = func("minecraft:entity.rabbit.death");
    @PythonFieldGenerated
    public static final String ENTITY_RABBIT_HURT = func("minecraft:entity.rabbit.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_RABBIT_JUMP = func("minecraft:entity.rabbit.jump");
    @PythonFieldGenerated
    public static final String ENTITY_SHEEP_AMBIENT = func("minecraft:entity.sheep.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_SHEEP_DEATH = func("minecraft:entity.sheep.death");
    @PythonFieldGenerated
    public static final String ENTITY_SHEEP_HURT = func("minecraft:entity.sheep.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_SHEEP_SHEAR = func("minecraft:entity.sheep.shear");
    @PythonFieldGenerated
    public static final String ENTITY_SHEEP_STEP = func("minecraft:entity.sheep.step");
    @PythonFieldGenerated
    public static final String ENTITY_SHULKER_AMBIENT = func("minecraft:entity.shulker.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_SHULKER_CLOSE = func("minecraft:entity.shulker.close");
    @PythonFieldGenerated
    public static final String ENTITY_SHULKER_DEATH = func("minecraft:entity.shulker.death");
    @PythonFieldGenerated
    public static final String ENTITY_SHULKER_HURT = func("minecraft:entity.shulker.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_SHULKER_HURT_CLOSED = func("minecraft:entity.shulker.hurt_closed");
    @PythonFieldGenerated
    public static final String ENTITY_SHULKER_OPEN = func("minecraft:entity.shulker.open");
    @PythonFieldGenerated
    public static final String ENTITY_SHULKER_SHOOT = func("minecraft:entity.shulker.shoot");
    @PythonFieldGenerated
    public static final String ENTITY_SHULKER_TELEPORT = func("minecraft:entity.shulker.teleport");
    @PythonFieldGenerated
    public static final String ENTITY_SHULKER_BULLET_HIT = func("minecraft:entity.shulker_bullet.hit");
    @PythonFieldGenerated
    public static final String ENTITY_SHULKER_BULLET_HURT = func("minecraft:entity.shulker_bullet.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_SILVERFISH_AMBIENT = func("minecraft:entity.silverfish.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_SILVERFISH_DEATH = func("minecraft:entity.silverfish.death");
    @PythonFieldGenerated
    public static final String ENTITY_SILVERFISH_HURT = func("minecraft:entity.silverfish.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_SILVERFISH_STEP = func("minecraft:entity.silverfish.step");
    @PythonFieldGenerated
    public static final String ENTITY_SKELETON_AMBIENT = func("minecraft:entity.skeleton.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_SKELETON_DEATH = func("minecraft:entity.skeleton.death");
    @PythonFieldGenerated
    public static final String ENTITY_SKELETON_HURT = func("minecraft:entity.skeleton.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_SKELETON_SHOOT = func("minecraft:entity.skeleton.shoot");
    @PythonFieldGenerated
    public static final String ENTITY_SKELETON_STEP = func("minecraft:entity.skeleton.step");
    @PythonFieldGenerated
    public static final String ENTITY_SKELETON_HORSE_AMBIENT = func("minecraft:entity.skeleton_horse.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_SKELETON_HORSE_DEATH = func("minecraft:entity.skeleton_horse.death");
    @PythonFieldGenerated
    public static final String ENTITY_SKELETON_HORSE_HURT = func("minecraft:entity.skeleton_horse.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_SLIME_ATTACK = func("minecraft:entity.slime.attack");
    @PythonFieldGenerated
    public static final String ENTITY_SLIME_DEATH = func("minecraft:entity.slime.death");
    @PythonFieldGenerated
    public static final String ENTITY_SLIME_HURT = func("minecraft:entity.slime.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_SLIME_JUMP = func("minecraft:entity.slime.jump");
    @PythonFieldGenerated
    public static final String ENTITY_SLIME_SQUISH = func("minecraft:entity.slime.squish");
    @PythonFieldGenerated
    public static final String ENTITY_SMALL_MAGMACUBE_DEATH = func("minecraft:entity.small_magmacube.death");
    @PythonFieldGenerated
    public static final String ENTITY_SMALL_MAGMACUBE_HURT = func("minecraft:entity.small_magmacube.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_SMALL_MAGMACUBE_SQUISH = func("minecraft:entity.small_magmacube.squish");
    @PythonFieldGenerated
    public static final String ENTITY_SMALL_SLIME_DEATH = func("minecraft:entity.small_slime.death");
    @PythonFieldGenerated
    public static final String ENTITY_SMALL_SLIME_HURT = func("minecraft:entity.small_slime.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_SMALL_SLIME_JUMP = func("minecraft:entity.small_slime.jump");
    @PythonFieldGenerated
    public static final String ENTITY_SMALL_SLIME_SQUISH = func("minecraft:entity.small_slime.squish");
    @PythonFieldGenerated
    public static final String ENTITY_SNOWBALL_THROW = func("minecraft:entity.snowball.throw");
    @PythonFieldGenerated
    public static final String ENTITY_SNOWMAN_AMBIENT = func("minecraft:entity.snowman.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_SNOWMAN_DEATH = func("minecraft:entity.snowman.death");
    @PythonFieldGenerated
    public static final String ENTITY_SNOWMAN_HURT = func("minecraft:entity.snowman.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_SNOWMAN_SHOOT = func("minecraft:entity.snowman.shoot");
    @PythonFieldGenerated
    public static final String ENTITY_SPIDER_AMBIENT = func("minecraft:entity.spider.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_SPIDER_DEATH = func("minecraft:entity.spider.death");
    @PythonFieldGenerated
    public static final String ENTITY_SPIDER_HURT = func("minecraft:entity.spider.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_SPIDER_STEP = func("minecraft:entity.spider.step");
    @PythonFieldGenerated
    public static final String ENTITY_SPLASH_POTION_BREAK = func("minecraft:entity.splash_potion.break");
    @PythonFieldGenerated
    public static final String ENTITY_SPLASH_POTION_THROW = func("minecraft:entity.splash_potion.throw");
    @PythonFieldGenerated
    public static final String ENTITY_SQUID_AMBIENT = func("minecraft:entity.squid.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_SQUID_DEATH = func("minecraft:entity.squid.death");
    @PythonFieldGenerated
    public static final String ENTITY_SQUID_HURT = func("minecraft:entity.squid.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_STRAY_AMBIENT = func("minecraft:entity.stray.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_STRAY_DEATH = func("minecraft:entity.stray.death");
    @PythonFieldGenerated
    public static final String ENTITY_STRAY_HURT = func("minecraft:entity.stray.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_STRAY_STEP = func("minecraft:entity.stray.step");
    @PythonFieldGenerated
    public static final String ENTITY_TNT_PRIMED = func("minecraft:entity.tnt.primed");
    @PythonFieldGenerated
    public static final String ENTITY_VEX_AMBIENT = func("minecraft:entity.vex.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_VEX_CHARGE = func("minecraft:entity.vex.charge");
    @PythonFieldGenerated
    public static final String ENTITY_VEX_DEATH = func("minecraft:entity.vex.death");
    @PythonFieldGenerated
    public static final String ENTITY_VEX_HURT = func("minecraft:entity.vex.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_VILLAGER_AMBIENT = func("minecraft:entity.villager.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_VILLAGER_DEATH = func("minecraft:entity.villager.death");
    @PythonFieldGenerated
    public static final String ENTITY_VILLAGER_HURT = func("minecraft:entity.villager.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_VILLAGER_NO = func("minecraft:entity.villager.no");
    @PythonFieldGenerated
    public static final String ENTITY_VILLAGER_TRADING = func("minecraft:entity.villager.trading");
    @PythonFieldGenerated
    public static final String ENTITY_VILLAGER_YES = func("minecraft:entity.villager.yes");
    @PythonFieldGenerated
    public static final String ENTITY_VINDICATION_ILLAGER_AMBIENT = func("minecraft:entity.vindication_illager.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_VINDICATION_ILLAGER_DEATH = func("minecraft:entity.vindication_illager.death");
    @PythonFieldGenerated
    public static final String ENTITY_VINDICATION_ILLAGER_HURT = func("minecraft:entity.vindication_illager.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_WITCH_AMBIENT = func("minecraft:entity.witch.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_WITCH_DEATH = func("minecraft:entity.witch.death");
    @PythonFieldGenerated
    public static final String ENTITY_WITCH_DRINK = func("minecraft:entity.witch.drink");
    @PythonFieldGenerated
    public static final String ENTITY_WITCH_HURT = func("minecraft:entity.witch.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_WITCH_THROW = func("minecraft:entity.witch.throw");
    @PythonFieldGenerated
    public static final String ENTITY_WITHER_AMBIENT = func("minecraft:entity.wither.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_WITHER_BREAK_BLOCK = func("minecraft:entity.wither.break_block");
    @PythonFieldGenerated
    public static final String ENTITY_WITHER_DEATH = func("minecraft:entity.wither.death");
    @PythonFieldGenerated
    public static final String ENTITY_WITHER_HURT = func("minecraft:entity.wither.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_WITHER_SHOOT = func("minecraft:entity.wither.shoot");
    @PythonFieldGenerated
    public static final String ENTITY_WITHER_SPAWN = func("minecraft:entity.wither.spawn");
    @PythonFieldGenerated
    public static final String ENTITY_WITHER_SKELETON_AMBIENT = func("minecraft:entity.wither_skeleton.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_WITHER_SKELETON_DEATH = func("minecraft:entity.wither_skeleton.death");
    @PythonFieldGenerated
    public static final String ENTITY_WITHER_SKELETON_HURT = func("minecraft:entity.wither_skeleton.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_WITHER_SKELETON_STEP = func("minecraft:entity.wither_skeleton.step");
    @PythonFieldGenerated
    public static final String ENTITY_WOLF_AMBIENT = func("minecraft:entity.wolf.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_WOLF_DEATH = func("minecraft:entity.wolf.death");
    @PythonFieldGenerated
    public static final String ENTITY_WOLF_GROWL = func("minecraft:entity.wolf.growl");
    @PythonFieldGenerated
    public static final String ENTITY_WOLF_HOWL = func("minecraft:entity.wolf.howl");
    @PythonFieldGenerated
    public static final String ENTITY_WOLF_HURT = func("minecraft:entity.wolf.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_WOLF_PANT = func("minecraft:entity.wolf.pant");
    @PythonFieldGenerated
    public static final String ENTITY_WOLF_SHAKE = func("minecraft:entity.wolf.shake");
    @PythonFieldGenerated
    public static final String ENTITY_WOLF_STEP = func("minecraft:entity.wolf.step");
    @PythonFieldGenerated
    public static final String ENTITY_WOLF_WHINE = func("minecraft:entity.wolf.whine");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_AMBIENT = func("minecraft:entity.zombie.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_ATTACK_DOOR_WOOD = func("minecraft:entity.zombie.attack_door_wood");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_ATTACK_IRON_DOOR = func("minecraft:entity.zombie.attack_iron_door");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_BREAK_DOOR_WOOD = func("minecraft:entity.zombie.break_door_wood");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_DEATH = func("minecraft:entity.zombie.death");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_HURT = func("minecraft:entity.zombie.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_INFECT = func("minecraft:entity.zombie.infect");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_STEP = func("minecraft:entity.zombie.step");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_HORSE_AMBIENT = func("minecraft:entity.zombie_horse.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_HORSE_DEATH = func("minecraft:entity.zombie_horse.death");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_HORSE_HURT = func("minecraft:entity.zombie_horse.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_PIG_AMBIENT = func("minecraft:entity.zombie_pig.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_PIG_ANGRY = func("minecraft:entity.zombie_pig.angry");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_PIG_DEATH = func("minecraft:entity.zombie_pig.death");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_PIG_HURT = func("minecraft:entity.zombie_pig.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_VILLAGER_AMBIENT = func("minecraft:entity.zombie_villager.ambient");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_VILLAGER_CONVERTED = func("minecraft:entity.zombie_villager.converted");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_VILLAGER_CURE = func("minecraft:entity.zombie_villager.cure");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_VILLAGER_DEATH = func("minecraft:entity.zombie_villager.death");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_VILLAGER_HURT = func("minecraft:entity.zombie_villager.hurt");
    @PythonFieldGenerated
    public static final String ENTITY_ZOMBIE_VILLAGER_STEP = func("minecraft:entity.zombie_villager.step");
    @PythonFieldGenerated
    public static final String ITEM_ARMOR_EQUIP_CHAIN = func("minecraft:item.armor.equip_chain");
    @PythonFieldGenerated
    public static final String ITEM_ARMOR_EQUIP_DIAMOND = func("minecraft:item.armor.equip_diamond");
    @PythonFieldGenerated
    public static final String ITEM_ARMOR_EQUIP_ELYTRA = func("minecraft:item.armor.equip_elytra");
    @PythonFieldGenerated
    public static final String ITEM_ARMOR_EQUIP_GENERIC = func("minecraft:item.armor.equip_generic");
    @PythonFieldGenerated
    public static final String ITEM_ARMOR_EQUIP_GOLD = func("minecraft:item.armor.equip_gold");
    @PythonFieldGenerated
    public static final String ITEM_ARMOR_EQUIP_IRON = func("minecraft:item.armor.equip_iron");
    @PythonFieldGenerated
    public static final String ITEM_ARMOR_EQUIP_LEATHER = func("minecraft:item.armor.equip_leather");
    @PythonFieldGenerated
    public static final String ITEM_BOTTLE_EMPTY = func("minecraft:item.bottle.empty");
    @PythonFieldGenerated
    public static final String ITEM_BOTTLE_FILL = func("minecraft:item.bottle.fill");
    @PythonFieldGenerated
    public static final String ITEM_BOTTLE_FILL_DRAGONBREATH = func("minecraft:item.bottle.fill_dragonbreath");
    @PythonFieldGenerated
    public static final String ITEM_BUCKET_EMPTY = func("minecraft:item.bucket.empty");
    @PythonFieldGenerated
    public static final String ITEM_BUCKET_EMPTY_LAVA = func("minecraft:item.bucket.empty_lava");
    @PythonFieldGenerated
    public static final String ITEM_BUCKET_FILL = func("minecraft:item.bucket.fill");
    @PythonFieldGenerated
    public static final String ITEM_BUCKET_FILL_LAVA = func("minecraft:item.bucket.fill_lava");
    @PythonFieldGenerated
    public static final String ITEM_CHORUS_FRUIT_TELEPORT = func("minecraft:item.chorus_fruit.teleport");
    @PythonFieldGenerated
    public static final String ITEM_ELYTRA_FLYING = func("minecraft:item.elytra.flying");
    @PythonFieldGenerated
    public static final String ITEM_FIRECHARGE_USE = func("minecraft:item.firecharge.use");
    @PythonFieldGenerated
    public static final String ITEM_FLINTANDSTEEL_USE = func("minecraft:item.flintandsteel.use");
    @PythonFieldGenerated
    public static final String ITEM_HOE_TILL = func("minecraft:item.hoe.till");
    @PythonFieldGenerated
    public static final String ITEM_SHIELD_BLOCK = func("minecraft:item.shield.block");
    @PythonFieldGenerated
    public static final String ITEM_SHIELD_BREAK = func("minecraft:item.shield.break");
    @PythonFieldGenerated
    public static final String ITEM_SHOVEL_FLATTEN = func("minecraft:item.shovel.flatten");
    @PythonFieldGenerated
    public static final String ITEM_TOTEM_USE = func("minecraft:item.totem.use");
    @PythonFieldGenerated
    public static final String MUSIC_CREATIVE = func("minecraft:music.creative");
    @PythonFieldGenerated
    public static final String MUSIC_CREDITS = func("minecraft:music.credits");
    @PythonFieldGenerated
    public static final String MUSIC_DRAGON = func("minecraft:music.dragon");
    @PythonFieldGenerated
    public static final String MUSIC_END = func("minecraft:music.end");
    @PythonFieldGenerated
    public static final String MUSIC_GAME = func("minecraft:music.game");
    @PythonFieldGenerated
    public static final String MUSIC_MENU = func("minecraft:music.menu");
    @PythonFieldGenerated
    public static final String MUSIC_NETHER = func("minecraft:music.nether");
    @PythonFieldGenerated
    public static final String RECORD_11 = func("minecraft:record.11");
    @PythonFieldGenerated
    public static final String RECORD_13 = func("minecraft:record.13");
    @PythonFieldGenerated
    public static final String RECORD_BLOCKS = func("minecraft:record.blocks");
    @PythonFieldGenerated
    public static final String RECORD_CAT = func("minecraft:record.cat");
    @PythonFieldGenerated
    public static final String RECORD_CHIRP = func("minecraft:record.chirp");
    @PythonFieldGenerated
    public static final String RECORD_FAR = func("minecraft:record.far");
    @PythonFieldGenerated
    public static final String RECORD_MALL = func("minecraft:record.mall");
    @PythonFieldGenerated
    public static final String RECORD_MELLOHI = func("minecraft:record.mellohi");
    @PythonFieldGenerated
    public static final String RECORD_STAL = func("minecraft:record.stal");
    @PythonFieldGenerated
    public static final String RECORD_STRAD = func("minecraft:record.strad");
    @PythonFieldGenerated
    public static final String RECORD_WAIT = func("minecraft:record.wait");
    @PythonFieldGenerated
    public static final String RECORD_WARD = func("minecraft:record.ward");
    @PythonFieldGenerated
    public static final String UI_BUTTON_CLICK = func("minecraft:ui.button.click");
    @PythonFieldGenerated
    public static final String UI_TOAST_IN = func("minecraft:ui.toast.in");
    @PythonFieldGenerated
    public static final String UI_TOAST_OUT = func("minecraft:ui.toast.out");
    @PythonFieldGenerated
    public static final String UI_TOAST_CHALLENGE_COMPLETE = func("minecraft:ui.toast.challenge_complete");
    @PythonFieldGenerated
    public static final String WEATHER_RAIN = func("minecraft:weather.rain");
    @PythonFieldGenerated
    public static final String WEATHER_RAIN_ABOVE = func("minecraft:weather.rain.above");

    @PythonFunction
    @PythonDocString("Returns a list of all the vanilla Sounds.")
    public static PyList getAllSounds() {
        return names;
    }

    private static String func(String s) {
        names.add(new PyString(s));
        return s;
    }
}