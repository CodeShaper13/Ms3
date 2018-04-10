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

    @PythonField
    public static final String AMBIENT_CAVE = func("minecraft:ambient.cave");
    @PythonField
    public static final String BLOCK_ANVIL_BREAK = func("minecraft:block.anvil.break");
    @PythonField
    public static final String BLOCK_ANVIL_DESTROY = func("minecraft:block.anvil.destroy");
    @PythonField
    public static final String BLOCK_ANVIL_FALL = func("minecraft:block.anvil.fall");
    @PythonField
    public static final String BLOCK_ANVIL_HIT = func("minecraft:block.anvil.hit");
    @PythonField
    public static final String BLOCK_ANVIL_LAND = func("minecraft:block.anvil.land");
    @PythonField
    public static final String BLOCK_ANVIL_PLACE = func("minecraft:block.anvil.place");
    @PythonField
    public static final String BLOCK_ANVIL_STEP = func("minecraft:block.anvil.step");
    @PythonField
    public static final String BLOCK_ANVIL_USE = func("minecraft:block.anvil.use");
    @PythonField
    public static final String BLOCK_BREWING_STAND_BREW = func("minecraft:block.brewing_stand.brew");
    @PythonField
    public static final String BLOCK_CHEST_CLOSE = func("minecraft:block.chest.close");
    @PythonField
    public static final String BLOCK_CHEST_LOCKED = func("minecraft:block.chest.locked");
    @PythonField
    public static final String BLOCK_CHEST_OPEN = func("minecraft:block.chest.open");
    @PythonField
    public static final String BLOCK_CHORUS_FLOWER_DEATH = func("minecraft:block.chorus_flower.death");
    @PythonField
    public static final String BLOCK_CHORUS_FLOWER_GROW = func("minecraft:block.chorus_flower.grow");
    @PythonField
    public static final String BLOCK_CLOTH_BREAK = func("minecraft:block.cloth.break");
    @PythonField
    public static final String BLOCK_CLOTH_FALL = func("minecraft:block.cloth.fall");
    @PythonField
    public static final String BLOCK_CLOTH_HIT = func("minecraft:block.cloth.hit");
    @PythonField
    public static final String BLOCK_CLOTH_PLACE = func("minecraft:block.cloth.place");
    @PythonField
    public static final String BLOCK_CLOTH_STEP = func("minecraft:block.cloth.step");
    @PythonField
    public static final String BLOCK_COMPARATOR_CLICK = func("minecraft:block.comparator.click");
    @PythonField
    public static final String BLOCK_DISPENSER_DISPENSE = func("minecraft:block.dispenser.dispense");
    @PythonField
    public static final String BLOCK_DISPENSER_FAIL = func("minecraft:block.dispenser.fail");
    @PythonField
    public static final String BLOCK_DISPENSER_LAUNCH = func("minecraft:block.dispenser.launch");
    @PythonField
    public static final String BLOCK_ENCHANTMENT_TABLE_USE = func("minecraft:block.enchantment_table.use");
    @PythonField
    public static final String BLOCK_END_GATEWAY_SPAWN = func("minecraft:block.end_gateway.spawn");
    @PythonField
    public static final String BLOCK_END_PORTAL_SPAWN = func("minecraft:block.end_portal.spawn");
    @PythonField
    public static final String BLOCK_END_PORTAL_FRAME_FILL = func("minecraft:block.end_portal_frame.fill");
    @PythonField
    public static final String BLOCK_ENDERCHEST_CLOSE = func("minecraft:block.enderchest.close");
    @PythonField
    public static final String BLOCK_ENDERCHEST_OPEN = func("minecraft:block.enderchest.open");
    @PythonField
    public static final String BLOCK_FENCE_GATE_CLOSE = func("minecraft:block.fence_gate.close");
    @PythonField
    public static final String BLOCK_FENCE_GATE_OPEN = func("minecraft:block.fence_gate.open");
    @PythonField
    public static final String BLOCK_FIRE_AMBIENT = func("minecraft:block.fire.ambient");
    @PythonField
    public static final String BLOCK_FIRE_EXTINGUISH = func("minecraft:block.fire.extinguish");
    @PythonField
    public static final String BLOCK_FURNACE_FIRE_CRACKLE = func("minecraft:block.furnace.fire_crackle");
    @PythonField
    public static final String BLOCK_GLASS_BREAK = func("minecraft:block.glass.break");
    @PythonField
    public static final String BLOCK_GLASS_FALL = func("minecraft:block.glass.fall");
    @PythonField
    public static final String BLOCK_GLASS_HIT = func("minecraft:block.glass.hit");
    @PythonField
    public static final String BLOCK_GLASS_PLACE = func("minecraft:block.glass.place");
    @PythonField
    public static final String BLOCK_GLASS_STEP = func("minecraft:block.glass.step");
    @PythonField
    public static final String BLOCK_GRASS_BREAK = func("minecraft:block.grass.break");
    @PythonField
    public static final String BLOCK_GRASS_FALL = func("minecraft:block.grass.fall");
    @PythonField
    public static final String BLOCK_GRASS_HIT = func("minecraft:block.grass.hit");
    @PythonField
    public static final String BLOCK_GRASS_PLACE = func("minecraft:block.grass.place");
    @PythonField
    public static final String BLOCK_GRASS_STEP = func("minecraft:block.grass.step");
    @PythonField
    public static final String BLOCK_GRAVEL_BREAK = func("minecraft:block.gravel.break");
    @PythonField
    public static final String BLOCK_GRAVEL_FALL = func("minecraft:block.gravel.fall");
    @PythonField
    public static final String BLOCK_GRAVEL_HIT = func("minecraft:block.gravel.hit");
    @PythonField
    public static final String BLOCK_GRAVEL_PLACE = func("minecraft:block.gravel.place");
    @PythonField
    public static final String BLOCK_GRAVEL_STEP = func("minecraft:block.gravel.step");
    @PythonField
    public static final String BLOCK_IRON_DOOR_CLOSE = func("minecraft:block.iron_door.close");
    @PythonField
    public static final String BLOCK_IRON_DOOR_OPEN = func("minecraft:block.iron_door.open");
    @PythonField
    public static final String BLOCK_IRON_TRAPDOOR_CLOSE = func("minecraft:block.iron_trapdoor.close");
    @PythonField
    public static final String BLOCK_IRON_TRAPDOOR_OPEN = func("minecraft:block.iron_trapdoor.open");
    @PythonField
    public static final String BLOCK_LADDER_BREAK = func("minecraft:block.ladder.break");
    @PythonField
    public static final String BLOCK_LADDER_FALL = func("minecraft:block.ladder.fall");
    @PythonField
    public static final String BLOCK_LADDER_HIT = func("minecraft:block.ladder.hit");
    @PythonField
    public static final String BLOCK_LADDER_PLACE = func("minecraft:block.ladder.place");
    @PythonField
    public static final String BLOCK_LADDER_STEP = func("minecraft:block.ladder.step");
    @PythonField
    public static final String BLOCK_LAVA_AMBIENT = func("minecraft:block.lava.ambient");
    @PythonField
    public static final String BLOCK_LAVA_EXTINGUISH = func("minecraft:block.lava.extinguish");
    @PythonField
    public static final String BLOCK_LAVA_POP = func("minecraft:block.lava.pop");
    @PythonField
    public static final String BLOCK_LEVER_CLICK = func("minecraft:block.lever.click");
    @PythonField
    public static final String BLOCK_METAL_BREAK = func("minecraft:block.metal.break");
    @PythonField
    public static final String BLOCK_METAL_FALL = func("minecraft:block.metal.fall");
    @PythonField
    public static final String BLOCK_METAL_HIT = func("minecraft:block.metal.hit");
    @PythonField
    public static final String BLOCK_METAL_PLACE = func("minecraft:block.metal.place");
    @PythonField
    public static final String BLOCK_METAL_STEP = func("minecraft:block.metal.step");
    @PythonField
    public static final String BLOCK_METAL_PRESSUREPLATE_CLICK_OFF = func("minecraft:block.metal_pressureplate.click_off");
    @PythonField
    public static final String BLOCK_METAL_PRESSUREPLATE_CLICK_ON = func("minecraft:block.metal_pressureplate.click_on");
    @PythonField
    public static final String BLOCK_NOTE_BASEDRUM = func("minecraft:block.note.basedrum");
    @PythonField
    public static final String BLOCK_NOTE_BASS = func("minecraft:block.note.bass");
    @PythonField
    public static final String BLOCK_NOTE_BELL = func("minecraft:block.note.bell");
    @PythonField
    public static final String BLOCK_NOTE_CHIME = func("minecraft:block.note.chime");
    @PythonField
    public static final String BLOCK_NOTE_FLUTE = func("minecraft:block.note.flute");
    @PythonField
    public static final String BLOCK_NOTE_GUITAR = func("minecraft:block.note.guitar");
    @PythonField
    public static final String BLOCK_NOTE_HARP = func("minecraft:block.note.harp");
    @PythonField
    public static final String BLOCK_NOTE_HAT = func("minecraft:block.note.hat");
    @PythonField
    public static final String BLOCK_NOTE_PLING = func("minecraft:block.note.pling");
    @PythonField
    public static final String BLOCK_NOTE_SNARE = func("minecraft:block.note.snare");
    @PythonField
    public static final String BLOCK_NOTE_XYLOPHONE = func("minecraft:block.note.xylophone");
    @PythonField
    public static final String BLOCK_PISTON_CONTRACT = func("minecraft:block.piston.contract");
    @PythonField
    public static final String BLOCK_PISTON_EXTEND = func("minecraft:block.piston.extend");
    @PythonField
    public static final String BLOCK_PORTAL_AMBIENT = func("minecraft:block.portal.ambient");
    @PythonField
    public static final String BLOCK_PORTAL_TRAVEL = func("minecraft:block.portal.travel");
    @PythonField
    public static final String BLOCK_PORTAL_TRIGGER = func("minecraft:block.portal.trigger");
    @PythonField
    public static final String BLOCK_REDSTONE_TORCH_BURNOUT = func("minecraft:block.redstone_torch.burnout");
    @PythonField
    public static final String BLOCK_SAND_BREAK = func("minecraft:block.sand.break");
    @PythonField
    public static final String BLOCK_SAND_FALL = func("minecraft:block.sand.fall");
    @PythonField
    public static final String BLOCK_SAND_HIT = func("minecraft:block.sand.hit");
    @PythonField
    public static final String BLOCK_SAND_PLACE = func("minecraft:block.sand.place");
    @PythonField
    public static final String BLOCK_SAND_STEP = func("minecraft:block.sand.step");
    @PythonField
    public static final String BLOCK_SHULKER_BOX_CLOSE = func("minecraft:block.shulker_box.close");
    @PythonField
    public static final String BLOCK_SHULKER_BOX_OPEN = func("minecraft:block.shulker_box.open");
    @PythonField
    public static final String BLOCK_SLIME_BREAK = func("minecraft:block.slime.break");
    @PythonField
    public static final String BLOCK_SLIME_FALL = func("minecraft:block.slime.fall");
    @PythonField
    public static final String BLOCK_SLIME_HIT = func("minecraft:block.slime.hit");
    @PythonField
    public static final String BLOCK_SLIME_PLACE = func("minecraft:block.slime.place");
    @PythonField
    public static final String BLOCK_SLIME_STEP = func("minecraft:block.slime.step");
    @PythonField
    public static final String BLOCK_SNOW_BREAK = func("minecraft:block.snow.break");
    @PythonField
    public static final String BLOCK_SNOW_FALL = func("minecraft:block.snow.fall");
    @PythonField
    public static final String BLOCK_SNOW_HIT = func("minecraft:block.snow.hit");
    @PythonField
    public static final String BLOCK_SNOW_PLACE = func("minecraft:block.snow.place");
    @PythonField
    public static final String BLOCK_SNOW_STEP = func("minecraft:block.snow.step");
    @PythonField
    public static final String BLOCK_STONE_BREAK = func("minecraft:block.stone.break");
    @PythonField
    public static final String BLOCK_STONE_FALL = func("minecraft:block.stone.fall");
    @PythonField
    public static final String BLOCK_STONE_HIT = func("minecraft:block.stone.hit");
    @PythonField
    public static final String BLOCK_STONE_PLACE = func("minecraft:block.stone.place");
    @PythonField
    public static final String BLOCK_STONE_STEP = func("minecraft:block.stone.step");
    @PythonField
    public static final String BLOCK_STONE_BUTTON_CLICK_OFF = func("minecraft:block.stone_button.click_off");
    @PythonField
    public static final String BLOCK_STONE_BUTTON_CLICK_ON = func("minecraft:block.stone_button.click_on");
    @PythonField
    public static final String BLOCK_STONE_PRESSUREPLATE_CLICK_OFF = func("minecraft:block.stone_pressureplate.click_off");
    @PythonField
    public static final String BLOCK_STONE_PRESSUREPLATE_CLICK_ON = func("minecraft:block.stone_pressureplate.click_on");
    @PythonField
    public static final String BLOCK_TRIPWIRE_ATTACH = func("minecraft:block.tripwire.attach");
    @PythonField
    public static final String BLOCK_TRIPWIRE_CLICK_OFF = func("minecraft:block.tripwire.click_off");
    @PythonField
    public static final String BLOCK_TRIPWIRE_CLICK_ON = func("minecraft:block.tripwire.click_on");
    @PythonField
    public static final String BLOCK_TRIPWIRE_DETACH = func("minecraft:block.tripwire.detach");
    @PythonField
    public static final String BLOCK_WATER_AMBIENT = func("minecraft:block.water.ambient");
    @PythonField
    public static final String BLOCK_WATERLILY_PLACE = func("minecraft:block.waterlily.place");
    @PythonField
    public static final String BLOCK_WOOD_BREAK = func("minecraft:block.wood.break");
    @PythonField
    public static final String BLOCK_WOOD_FALL = func("minecraft:block.wood.fall");
    @PythonField
    public static final String BLOCK_WOOD_HIT = func("minecraft:block.wood.hit");
    @PythonField
    public static final String BLOCK_WOOD_PLACE = func("minecraft:block.wood.place");
    @PythonField
    public static final String BLOCK_WOOD_STEP = func("minecraft:block.wood.step");
    @PythonField
    public static final String BLOCK_WOOD_BUTTON_CLICK_OFF = func("minecraft:block.wood_button.click_off");
    @PythonField
    public static final String BLOCK_WOOD_BUTTON_CLICK_ON = func("minecraft:block.wood_button.click_on");
    @PythonField
    public static final String BLOCK_WOOD_PRESSUREPLATE_CLICK_OFF = func("minecraft:block.wood_pressureplate.click_off");
    @PythonField
    public static final String BLOCK_WOOD_PRESSUREPLATE_CLICK_ON = func("minecraft:block.wood_pressureplate.click_on");
    @PythonField
    public static final String BLOCK_WOODEN_DOOR_CLOSE = func("minecraft:block.wooden_door.close");
    @PythonField
    public static final String BLOCK_WOODEN_DOOR_OPEN = func("minecraft:block.wooden_door.open");
    @PythonField
    public static final String BLOCK_WOODEN_TRAPDOOR_CLOSE = func("minecraft:block.wooden_trapdoor.close");
    @PythonField
    public static final String BLOCK_WOODEN_TRAPDOOR_OPEN = func("minecraft:block.wooden_trapdoor.open");
    @PythonField
    public static final String ENCHANT_THORNS_HIT = func("minecraft:enchant.thorns.hit");
    @PythonField
    public static final String ENTITY_ARMORSTAND_BREAK = func("minecraft:entity.armorstand.break");
    @PythonField
    public static final String ENTITY_ARMORSTAND_FALL = func("minecraft:entity.armorstand.fall");
    @PythonField
    public static final String ENTITY_ARMORSTAND_HIT = func("minecraft:entity.armorstand.hit");
    @PythonField
    public static final String ENTITY_ARMORSTAND_PLACE = func("minecraft:entity.armorstand.place");
    @PythonField
    public static final String ENTITY_ARROW_HIT = func("minecraft:entity.arrow.hit");
    @PythonField
    public static final String ENTITY_ARROW_HIT_PLAYER = func("minecraft:entity.arrow.hit_player");
    @PythonField
    public static final String ENTITY_ARROW_SHOOT = func("minecraft:entity.arrow.shoot");
    @PythonField
    public static final String ENTITY_BAT_AMBIENT = func("minecraft:entity.bat.ambient");
    @PythonField
    public static final String ENTITY_BAT_DEATH = func("minecraft:entity.bat.death");
    @PythonField
    public static final String ENTITY_BAT_HURT = func("minecraft:entity.bat.hurt");
    @PythonField
    public static final String ENTITY_BAT_LOOP = func("minecraft:entity.bat.loop");
    @PythonField
    public static final String ENTITY_BAT_TAKEOFF = func("minecraft:entity.bat.takeoff");
    @PythonField
    public static final String ENTITY_BLAZE_AMBIENT = func("minecraft:entity.blaze.ambient");
    @PythonField
    public static final String ENTITY_BLAZE_BURN = func("minecraft:entity.blaze.burn");
    @PythonField
    public static final String ENTITY_BLAZE_DEATH = func("minecraft:entity.blaze.death");
    @PythonField
    public static final String ENTITY_BLAZE_HURT = func("minecraft:entity.blaze.hurt");
    @PythonField
    public static final String ENTITY_BLAZE_SHOOT = func("minecraft:entity.blaze.shoot");
    @PythonField
    public static final String ENTITY_BOAT_PADDLE_LAND = func("minecraft:entity.boat.paddle_land");
    @PythonField
    public static final String ENTITY_BOAT_PADDLE_WATER = func("minecraft:entity.boat.paddle_water");
    @PythonField
    public static final String ENTITY_BOBBER_RETRIEVE = func("minecraft:entity.bobber.retrieve");
    @PythonField
    public static final String ENTITY_BOBBER_SPLASH = func("minecraft:entity.bobber.splash");
    @PythonField
    public static final String ENTITY_BOBBER_THROW = func("minecraft:entity.bobber.throw");
    @PythonField
    public static final String ENTITY_CAT_AMBIENT = func("minecraft:entity.cat.ambient");
    @PythonField
    public static final String ENTITY_CAT_DEATH = func("minecraft:entity.cat.death");
    @PythonField
    public static final String ENTITY_CAT_HISS = func("minecraft:entity.cat.hiss");
    @PythonField
    public static final String ENTITY_CAT_HURT = func("minecraft:entity.cat.hurt");
    @PythonField
    public static final String ENTITY_CAT_PURR = func("minecraft:entity.cat.purr");
    @PythonField
    public static final String ENTITY_CAT_PURREOW = func("minecraft:entity.cat.purreow");
    @PythonField
    public static final String ENTITY_CHICKEN_AMBIENT = func("minecraft:entity.chicken.ambient");
    @PythonField
    public static final String ENTITY_CHICKEN_DEATH = func("minecraft:entity.chicken.death");
    @PythonField
    public static final String ENTITY_CHICKEN_EGG = func("minecraft:entity.chicken.egg");
    @PythonField
    public static final String ENTITY_CHICKEN_HURT = func("minecraft:entity.chicken.hurt");
    @PythonField
    public static final String ENTITY_CHICKEN_STEP = func("minecraft:entity.chicken.step");
    @PythonField
    public static final String ENTITY_COW_AMBIENT = func("minecraft:entity.cow.ambient");
    @PythonField
    public static final String ENTITY_COW_DEATH = func("minecraft:entity.cow.death");
    @PythonField
    public static final String ENTITY_COW_HURT = func("minecraft:entity.cow.hurt");
    @PythonField
    public static final String ENTITY_COW_MILK = func("minecraft:entity.cow.milk");
    @PythonField
    public static final String ENTITY_COW_STEP = func("minecraft:entity.cow.step");
    @PythonField
    public static final String ENTITY_CREEPER_DEATH = func("minecraft:entity.creeper.death");
    @PythonField
    public static final String ENTITY_CREEPER_HURT = func("minecraft:entity.creeper.hurt");
    @PythonField
    public static final String ENTITY_CREEPER_PRIMED = func("minecraft:entity.creeper.primed");
    @PythonField
    public static final String ENTITY_DONKEY_AMBIENT = func("minecraft:entity.donkey.ambient");
    @PythonField
    public static final String ENTITY_DONKEY_ANGRY = func("minecraft:entity.donkey.angry");
    @PythonField
    public static final String ENTITY_DONKEY_CHEST = func("minecraft:entity.donkey.chest");
    @PythonField
    public static final String ENTITY_DONKEY_DEATH = func("minecraft:entity.donkey.death");
    @PythonField
    public static final String ENTITY_DONKEY_HURT = func("minecraft:entity.donkey.hurt");
    @PythonField
    public static final String ENTITY_EGG_THROW = func("minecraft:entity.egg.throw");
    @PythonField
    public static final String ENTITY_ELDER_GUARDIAN_AMBIENT = func("minecraft:entity.elder_guardian.ambient");
    @PythonField
    public static final String ENTITY_ELDER_GUARDIAN_AMBIENT_LAND = func("minecraft:entity.elder_guardian.ambient_land");
    @PythonField
    public static final String ENTITY_ELDER_GUARDIAN_CURSE = func("minecraft:entity.elder_guardian.curse");
    @PythonField
    public static final String ENTITY_ELDER_GUARDIAN_DEATH = func("minecraft:entity.elder_guardian.death");
    @PythonField
    public static final String ENTITY_ELDER_GUARDIAN_DEATH_LAND = func("minecraft:entity.elder_guardian.death_land");
    @PythonField
    public static final String ENTITY_ELDER_GUARDIAN_FLOP = func("minecraft:entity.elder_guardian.flop");
    @PythonField
    public static final String ENTITY_ELDER_GUARDIAN_HURT = func("minecraft:entity.elder_guardian.hurt");
    @PythonField
    public static final String ENTITY_ELDER_GUARDIAN_HURT_LAND = func("minecraft:entity.elder_guardian.hurt_land");
    @PythonField
    public static final String ENTITY_ENDERDRAGON_AMBIENT = func("minecraft:entity.enderdragon.ambient");
    @PythonField
    public static final String ENTITY_ENDERDRAGON_DEATH = func("minecraft:entity.enderdragon.death");
    @PythonField
    public static final String ENTITY_ENDERDRAGON_FLAP = func("minecraft:entity.enderdragon.flap");
    @PythonField
    public static final String ENTITY_ENDERDRAGON_GROWL = func("minecraft:entity.enderdragon.growl");
    @PythonField
    public static final String ENTITY_ENDERDRAGON_HURT = func("minecraft:entity.enderdragon.hurt");
    @PythonField
    public static final String ENTITY_ENDERDRAGON_SHOOT = func("minecraft:entity.enderdragon.shoot");
    @PythonField
    public static final String ENTITY_ENDERDRAGON_FIREBALL_EXPLODE = func("minecraft:entity.enderdragon_fireball.explode");
    @PythonField
    public static final String ENTITY_ENDEREYE_DEATH = func("minecraft:entity.endereye.death");
    @PythonField
    public static final String ENTITY_ENDEREYE_LAUNCH = func("minecraft:entity.endereye.launch");
    @PythonField
    public static final String ENTITY_ENDERMEN_AMBIENT = func("minecraft:entity.endermen.ambient");
    @PythonField
    public static final String ENTITY_ENDERMEN_DEATH = func("minecraft:entity.endermen.death");
    @PythonField
    public static final String ENTITY_ENDERMEN_HURT = func("minecraft:entity.endermen.hurt");
    @PythonField
    public static final String ENTITY_ENDERMEN_SCREAM = func("minecraft:entity.endermen.scream");
    @PythonField
    public static final String ENTITY_ENDERMEN_STARE = func("minecraft:entity.endermen.stare");
    @PythonField
    public static final String ENTITY_ENDERMEN_TELEPORT = func("minecraft:entity.endermen.teleport");
    @PythonField
    public static final String ENTITY_ENDERMITE_AMBIENT = func("minecraft:entity.endermite.ambient");
    @PythonField
    public static final String ENTITY_ENDERMITE_DEATH = func("minecraft:entity.endermite.death");
    @PythonField
    public static final String ENTITY_ENDERMITE_HURT = func("minecraft:entity.endermite.hurt");
    @PythonField
    public static final String ENTITY_ENDERMITE_STEP = func("minecraft:entity.endermite.step");
    @PythonField
    public static final String ENTITY_ENDERPEARL_THROW = func("minecraft:entity.enderpearl.throw");
    @PythonField
    public static final String ENTITY_EVOCATION_FANGS_ATTACK = func("minecraft:entity.evocation_fangs.attack");
    @PythonField
    public static final String ENTITY_EVOCATION_ILLAGER_AMBIENT = func("minecraft:entity.evocation_illager.ambient");
    @PythonField
    public static final String ENTITY_EVOCATION_ILLAGER_CAST_SPELL = func("minecraft:entity.evocation_illager.cast_spell");
    @PythonField
    public static final String ENTITY_EVOCATION_ILLAGER_DEATH = func("minecraft:entity.evocation_illager.death");
    @PythonField
    public static final String ENTITY_EVOCATION_ILLAGER_HURT = func("minecraft:entity.evocation_illager.hurt");
    @PythonField
    public static final String ENTITY_EVOCATION_ILLAGER_PREPARE_ATTACK = func("minecraft:entity.evocation_illager.prepare_attack");
    @PythonField
    public static final String ENTITY_EVOCATION_ILLAGER_PREPARE_SUMMON = func("minecraft:entity.evocation_illager.prepare_summon");
    @PythonField
    public static final String ENTITY_EVOCATION_ILLAGER_PREPARE_WOLOLO = func("minecraft:entity.evocation_illager.prepare_wololo");
    @PythonField
    public static final String ENTITY_EXPERIENCE_BOTTLE_THROW = func("minecraft:entity.experience_bottle.throw");
    @PythonField
    public static final String ENTITY_EXPERIENCE_ORB_PICKUP = func("minecraft:entity.experience_orb.pickup");
    @PythonField
    public static final String ENTITY_FIREWORK_BLAST = func("minecraft:entity.firework.blast");
    @PythonField
    public static final String ENTITY_FIREWORK_BLAST_FAR = func("minecraft:entity.firework.blast_far");
    @PythonField
    public static final String ENTITY_FIREWORK_LARGE_BLAST = func("minecraft:entity.firework.large_blast");
    @PythonField
    public static final String ENTITY_FIREWORK_LARGE_BLAST_FAR = func("minecraft:entity.firework.large_blast_far");
    @PythonField
    public static final String ENTITY_FIREWORK_LAUNCH = func("minecraft:entity.firework.launch");
    @PythonField
    public static final String ENTITY_FIREWORK_SHOOT = func("minecraft:entity.firework.shoot");
    @PythonField
    public static final String ENTITY_FIREWORK_TWINKLE = func("minecraft:entity.firework.twinkle");
    @PythonField
    public static final String ENTITY_FIREWORK_TWINKLE_FAR = func("minecraft:entity.firework.twinkle_far");
    @PythonField
    public static final String ENTITY_GENERIC_BIG_FALL = func("minecraft:entity.generic.big_fall");
    @PythonField
    public static final String ENTITY_GENERIC_BURN = func("minecraft:entity.generic.burn");
    @PythonField
    public static final String ENTITY_GENERIC_DEATH = func("minecraft:entity.generic.death");
    @PythonField
    public static final String ENTITY_GENERIC_DRINK = func("minecraft:entity.generic.drink");
    @PythonField
    public static final String ENTITY_GENERIC_EAT = func("minecraft:entity.generic.eat");
    @PythonField
    public static final String ENTITY_GENERIC_EXPLODE = func("minecraft:entity.generic.explode");
    @PythonField
    public static final String ENTITY_GENERIC_EXTINGUISH_FIRE = func("minecraft:entity.generic.extinguish_fire");
    @PythonField
    public static final String ENTITY_GENERIC_HURT = func("minecraft:entity.generic.hurt");
    @PythonField
    public static final String ENTITY_GENERIC_SMALL_FALL = func("minecraft:entity.generic.small_fall");
    @PythonField
    public static final String ENTITY_GENERIC_SPLASH = func("minecraft:entity.generic.splash");
    @PythonField
    public static final String ENTITY_GENERIC_SWIM = func("minecraft:entity.generic.swim");
    @PythonField
    public static final String ENTITY_GHAST_AMBIENT = func("minecraft:entity.ghast.ambient");
    @PythonField
    public static final String ENTITY_GHAST_DEATH = func("minecraft:entity.ghast.death");
    @PythonField
    public static final String ENTITY_GHAST_HURT = func("minecraft:entity.ghast.hurt");
    @PythonField
    public static final String ENTITY_GHAST_SCREAM = func("minecraft:entity.ghast.scream");
    @PythonField
    public static final String ENTITY_GHAST_SHOOT = func("minecraft:entity.ghast.shoot");
    @PythonField
    public static final String ENTITY_GHAST_WARN = func("minecraft:entity.ghast.warn");
    @PythonField
    public static final String ENTITY_GUARDIAN_AMBIENT = func("minecraft:entity.guardian.ambient");
    @PythonField
    public static final String ENTITY_GUARDIAN_AMBIENT_LAND = func("minecraft:entity.guardian.ambient_land");
    @PythonField
    public static final String ENTITY_GUARDIAN_ATTACK = func("minecraft:entity.guardian.attack");
    @PythonField
    public static final String ENTITY_GUARDIAN_DEATH = func("minecraft:entity.guardian.death");
    @PythonField
    public static final String ENTITY_GUARDIAN_DEATH_LAND = func("minecraft:entity.guardian.death_land");
    @PythonField
    public static final String ENTITY_GUARDIAN_FLOP = func("minecraft:entity.guardian.flop");
    @PythonField
    public static final String ENTITY_GUARDIAN_HURT = func("minecraft:entity.guardian.hurt");
    @PythonField
    public static final String ENTITY_GUARDIAN_HURT_LAND = func("minecraft:entity.guardian.hurt_land");
    @PythonField
    public static final String ENTITY_HORSE_AMBIENT = func("minecraft:entity.horse.ambient");
    @PythonField
    public static final String ENTITY_HORSE_ANGRY = func("minecraft:entity.horse.angry");
    @PythonField
    public static final String ENTITY_HORSE_ARMOR = func("minecraft:entity.horse.armor");
    @PythonField
    public static final String ENTITY_HORSE_BREATHE = func("minecraft:entity.horse.breathe");
    @PythonField
    public static final String ENTITY_HORSE_DEATH = func("minecraft:entity.horse.death");
    @PythonField
    public static final String ENTITY_HORSE_EAT = func("minecraft:entity.horse.eat");
    @PythonField
    public static final String ENTITY_HORSE_GALLOP = func("minecraft:entity.horse.gallop");
    @PythonField
    public static final String ENTITY_HORSE_HURT = func("minecraft:entity.horse.hurt");
    @PythonField
    public static final String ENTITY_HORSE_JUMP = func("minecraft:entity.horse.jump");
    @PythonField
    public static final String ENTITY_HORSE_LAND = func("minecraft:entity.horse.land");
    @PythonField
    public static final String ENTITY_HORSE_SADDLE = func("minecraft:entity.horse.saddle");
    @PythonField
    public static final String ENTITY_HORSE_STEP = func("minecraft:entity.horse.step");
    @PythonField
    public static final String ENTITY_HORSE_STEP_WOOD = func("minecraft:entity.horse.step_wood");
    @PythonField
    public static final String ENTITY_HOSTILE_BIG_FALL = func("minecraft:entity.hostile.big_fall");
    @PythonField
    public static final String ENTITY_HOSTILE_DEATH = func("minecraft:entity.hostile.death");
    @PythonField
    public static final String ENTITY_HOSTILE_HURT = func("minecraft:entity.hostile.hurt");
    @PythonField
    public static final String ENTITY_HOSTILE_SMALL_FALL = func("minecraft:entity.hostile.small_fall");
    @PythonField
    public static final String ENTITY_HOSTILE_SPLASH = func("minecraft:entity.hostile.splash");
    @PythonField
    public static final String ENTITY_HOSTILE_SWIM = func("minecraft:entity.hostile.swim");
    @PythonField
    public static final String ENTITY_HUSK_AMBIENT = func("minecraft:entity.husk.ambient");
    @PythonField
    public static final String ENTITY_HUSK_DEATH = func("minecraft:entity.husk.death");
    @PythonField
    public static final String ENTITY_HUSK_HURT = func("minecraft:entity.husk.hurt");
    @PythonField
    public static final String ENTITY_HUSK_STEP = func("minecraft:entity.husk.step");
    @PythonField
    public static final String ENTITY_ILLUSION_ILLAGER_AMBIENT = func("minecraft:entity.illusion_illager.ambient");
    @PythonField
    public static final String ENTITY_ILLUSION_ILLAGER_CAST_SPELL = func("minecraft:entity.illusion_illager.cast_spell");
    @PythonField
    public static final String ENTITY_ILLUSION_ILLAGER_DEATH = func("minecraft:entity.illusion_illager.death");
    @PythonField
    public static final String ENTITY_ILLUSION_ILLAGER_HURT = func("minecraft:entity.illusion_illager.hurt");
    @PythonField
    public static final String ENTITY_ILLUSION_ILLAGER_MIRROR_MOVE = func("minecraft:entity.illusion_illager.mirror_move");
    @PythonField
    public static final String ENTITY_ILLUSION_ILLAGER_PREPARE_BLINDNESS = func("minecraft:entity.illusion_illager.prepare_blindness");
    @PythonField
    public static final String ENTITY_ILLUSION_ILLAGER_PREPARE_MIRROR = func("minecraft:entity.illusion_illager.prepare_mirror");
    @PythonField
    public static final String ENTITY_IRONGOLEM_ATTACK = func("minecraft:entity.irongolem.attack");
    @PythonField
    public static final String ENTITY_IRONGOLEM_DEATH = func("minecraft:entity.irongolem.death");
    @PythonField
    public static final String ENTITY_IRONGOLEM_HURT = func("minecraft:entity.irongolem.hurt");
    @PythonField
    public static final String ENTITY_IRONGOLEM_STEP = func("minecraft:entity.irongolem.step");
    @PythonField
    public static final String ENTITY_ITEM_BREAK = func("minecraft:entity.item.break");
    @PythonField
    public static final String ENTITY_ITEM_PICKUP = func("minecraft:entity.item.pickup");
    @PythonField
    public static final String ENTITY_ITEMFRAME_ADD_ITEM = func("minecraft:entity.itemframe.add_item");
    @PythonField
    public static final String ENTITY_ITEMFRAME_BREAK = func("minecraft:entity.itemframe.break");
    @PythonField
    public static final String ENTITY_ITEMFRAME_PLACE = func("minecraft:entity.itemframe.place");
    @PythonField
    public static final String ENTITY_ITEMFRAME_REMOVE_ITEM = func("minecraft:entity.itemframe.remove_item");
    @PythonField
    public static final String ENTITY_ITEMFRAME_ROTATE_ITEM = func("minecraft:entity.itemframe.rotate_item");
    @PythonField
    public static final String ENTITY_LEASHKNOT_BREAK = func("minecraft:entity.leashknot.break");
    @PythonField
    public static final String ENTITY_LEASHKNOT_PLACE = func("minecraft:entity.leashknot.place");
    @PythonField
    public static final String ENTITY_LIGHTNING_IMPACT = func("minecraft:entity.lightning.impact");
    @PythonField
    public static final String ENTITY_LIGHTNING_THUNDER = func("minecraft:entity.lightning.thunder");
    @PythonField
    public static final String ENTITY_LINGERINGPOTION_THROW = func("minecraft:entity.lingeringpotion.throw");
    @PythonField
    public static final String ENTITY_LLAMA_AMBIENT = func("minecraft:entity.llama.ambient");
    @PythonField
    public static final String ENTITY_LLAMA_ANGRY = func("minecraft:entity.llama.angry");
    @PythonField
    public static final String ENTITY_LLAMA_CHEST = func("minecraft:entity.llama.chest");
    @PythonField
    public static final String ENTITY_LLAMA_DEATH = func("minecraft:entity.llama.death");
    @PythonField
    public static final String ENTITY_LLAMA_EAT = func("minecraft:entity.llama.eat");
    @PythonField
    public static final String ENTITY_LLAMA_HURT = func("minecraft:entity.llama.hurt");
    @PythonField
    public static final String ENTITY_LLAMA_SPIT = func("minecraft:entity.llama.spit");
    @PythonField
    public static final String ENTITY_LLAMA_STEP = func("minecraft:entity.llama.step");
    @PythonField
    public static final String ENTITY_LLAMA_SWAG = func("minecraft:entity.llama.swag");
    @PythonField
    public static final String ENTITY_MAGMACUBE_DEATH = func("minecraft:entity.magmacube.death");
    @PythonField
    public static final String ENTITY_MAGMACUBE_HURT = func("minecraft:entity.magmacube.hurt");
    @PythonField
    public static final String ENTITY_MAGMACUBE_JUMP = func("minecraft:entity.magmacube.jump");
    @PythonField
    public static final String ENTITY_MAGMACUBE_SQUISH = func("minecraft:entity.magmacube.squish");
    @PythonField
    public static final String ENTITY_MINECART_INSIDE = func("minecraft:entity.minecart.inside");
    @PythonField
    public static final String ENTITY_MINECART_RIDING = func("minecraft:entity.minecart.riding");
    @PythonField
    public static final String ENTITY_MOOSHROOM_SHEAR = func("minecraft:entity.mooshroom.shear");
    @PythonField
    public static final String ENTITY_MULE_AMBIENT = func("minecraft:entity.mule.ambient");
    @PythonField
    public static final String ENTITY_MULE_CHEST = func("minecraft:entity.mule.chest");
    @PythonField
    public static final String ENTITY_MULE_DEATH = func("minecraft:entity.mule.death");
    @PythonField
    public static final String ENTITY_MULE_HURT = func("minecraft:entity.mule.hurt");
    @PythonField
    public static final String ENTITY_PAINTING_BREAK = func("minecraft:entity.painting.break");
    @PythonField
    public static final String ENTITY_PAINTING_PLACE = func("minecraft:entity.painting.place");
    @PythonField
    public static final String ENTITY_PARROT_AMBIENT = func("minecraft:entity.parrot.ambient");
    @PythonField
    public static final String ENTITY_PARROT_DEATH = func("minecraft:entity.parrot.death");
    @PythonField
    public static final String ENTITY_PARROT_EAT = func("minecraft:entity.parrot.eat");
    @PythonField
    public static final String ENTITY_PARROT_FLY = func("minecraft:entity.parrot.fly");
    @PythonField
    public static final String ENTITY_PARROT_HURT = func("minecraft:entity.parrot.hurt");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_BLAZE = func("minecraft:entity.parrot.imitate.blaze");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_CREEPER = func("minecraft:entity.parrot.imitate.creeper");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_ELDER_GUARDIAN = func("minecraft:entity.parrot.imitate.elder_guardian");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_ENDERDRAGON = func("minecraft:entity.parrot.imitate.enderdragon");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_ENDERMAN = func("minecraft:entity.parrot.imitate.enderman");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_ENDERMITE = func("minecraft:entity.parrot.imitate.endermite");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_EVOCATION_ILLAGER = func("minecraft:entity.parrot.imitate.evocation_illager");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_GHAST = func("minecraft:entity.parrot.imitate.ghast");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_HUSK = func("minecraft:entity.parrot.imitate.husk");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_ILLUSION_ILLAGER = func("minecraft:entity.parrot.imitate.illusion_illager");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_MAGMACUBE = func("minecraft:entity.parrot.imitate.magmacube");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_POLAR_BEAR = func("minecraft:entity.parrot.imitate.polar_bear");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_SHULKER = func("minecraft:entity.parrot.imitate.shulker");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_SILVERFISH = func("minecraft:entity.parrot.imitate.silverfish");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_SKELETON = func("minecraft:entity.parrot.imitate.skeleton");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_SLIME = func("minecraft:entity.parrot.imitate.slime");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_SPIDER = func("minecraft:entity.parrot.imitate.spider");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_STRAY = func("minecraft:entity.parrot.imitate.stray");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_VEX = func("minecraft:entity.parrot.imitate.vex");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_VINDICATION_ILLAGER = func("minecraft:entity.parrot.imitate.vindication_illager");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_WITCH = func("minecraft:entity.parrot.imitate.witch");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_WITHER = func("minecraft:entity.parrot.imitate.wither");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_WITHER_SKELETON = func("minecraft:entity.parrot.imitate.wither_skeleton");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_WOLF = func("minecraft:entity.parrot.imitate.wolf");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_ZOMBIE = func("minecraft:entity.parrot.imitate.zombie");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_ZOMBIE_PIGMAN = func("minecraft:entity.parrot.imitate.zombie_pigman");
    @PythonField
    public static final String ENTITY_PARROT_IMITATE_ZOMBIE_VILLAGER = func("minecraft:entity.parrot.imitate.zombie_villager");
    @PythonField
    public static final String ENTITY_PARROT_STEP = func("minecraft:entity.parrot.step");
    @PythonField
    public static final String ENTITY_PIG_AMBIENT = func("minecraft:entity.pig.ambient");
    @PythonField
    public static final String ENTITY_PIG_DEATH = func("minecraft:entity.pig.death");
    @PythonField
    public static final String ENTITY_PIG_HURT = func("minecraft:entity.pig.hurt");
    @PythonField
    public static final String ENTITY_PIG_SADDLE = func("minecraft:entity.pig.saddle");
    @PythonField
    public static final String ENTITY_PIG_STEP = func("minecraft:entity.pig.step");
    @PythonField
    public static final String ENTITY_PLAYER_ATTACK_CRIT = func("minecraft:entity.player.attack.crit");
    @PythonField
    public static final String ENTITY_PLAYER_ATTACK_KNOCKBACK = func("minecraft:entity.player.attack.knockback");
    @PythonField
    public static final String ENTITY_PLAYER_ATTACK_NODAMAGE = func("minecraft:entity.player.attack.nodamage");
    @PythonField
    public static final String ENTITY_PLAYER_ATTACK_STRONG = func("minecraft:entity.player.attack.strong");
    @PythonField
    public static final String ENTITY_PLAYER_ATTACK_SWEEP = func("minecraft:entity.player.attack.sweep");
    @PythonField
    public static final String ENTITY_PLAYER_ATTACK_WEAK = func("minecraft:entity.player.attack.weak");
    @PythonField
    public static final String ENTITY_PLAYER_BIG_FALL = func("minecraft:entity.player.big_fall");
    @PythonField
    public static final String ENTITY_PLAYER_BREATH = func("minecraft:entity.player.breath");
    @PythonField
    public static final String ENTITY_PLAYER_BURP = func("minecraft:entity.player.burp");
    @PythonField
    public static final String ENTITY_PLAYER_DEATH = func("minecraft:entity.player.death");
    @PythonField
    public static final String ENTITY_PLAYER_HURT = func("minecraft:entity.player.hurt");
    @PythonField
    public static final String ENTITY_PLAYER_HURT_DROWN = func("minecraft:entity.player.hurt_drown");
    @PythonField
    public static final String ENTITY_PLAYER_HURT_ON_FIRE = func("minecraft:entity.player.hurt_on_fire");
    @PythonField
    public static final String ENTITY_PLAYER_LEVELUP = func("minecraft:entity.player.levelup");
    @PythonField
    public static final String ENTITY_PLAYER_SMALL_FALL = func("minecraft:entity.player.small_fall");
    @PythonField
    public static final String ENTITY_PLAYER_SPLASH = func("minecraft:entity.player.splash");
    @PythonField
    public static final String ENTITY_PLAYER_SWIM = func("minecraft:entity.player.swim");
    @PythonField
    public static final String ENTITY_POLAR_BEAR_AMBIENT = func("minecraft:entity.polar_bear.ambient");
    @PythonField
    public static final String ENTITY_POLAR_BEAR_BABY_AMBIENT = func("minecraft:entity.polar_bear.baby_ambient");
    @PythonField
    public static final String ENTITY_POLAR_BEAR_DEATH = func("minecraft:entity.polar_bear.death");
    @PythonField
    public static final String ENTITY_POLAR_BEAR_HURT = func("minecraft:entity.polar_bear.hurt");
    @PythonField
    public static final String ENTITY_POLAR_BEAR_STEP = func("minecraft:entity.polar_bear.step");
    @PythonField
    public static final String ENTITY_POLAR_BEAR_WARNING = func("minecraft:entity.polar_bear.warning");
    @PythonField
    public static final String ENTITY_RABBIT_AMBIENT = func("minecraft:entity.rabbit.ambient");
    @PythonField
    public static final String ENTITY_RABBIT_ATTACK = func("minecraft:entity.rabbit.attack");
    @PythonField
    public static final String ENTITY_RABBIT_DEATH = func("minecraft:entity.rabbit.death");
    @PythonField
    public static final String ENTITY_RABBIT_HURT = func("minecraft:entity.rabbit.hurt");
    @PythonField
    public static final String ENTITY_RABBIT_JUMP = func("minecraft:entity.rabbit.jump");
    @PythonField
    public static final String ENTITY_SHEEP_AMBIENT = func("minecraft:entity.sheep.ambient");
    @PythonField
    public static final String ENTITY_SHEEP_DEATH = func("minecraft:entity.sheep.death");
    @PythonField
    public static final String ENTITY_SHEEP_HURT = func("minecraft:entity.sheep.hurt");
    @PythonField
    public static final String ENTITY_SHEEP_SHEAR = func("minecraft:entity.sheep.shear");
    @PythonField
    public static final String ENTITY_SHEEP_STEP = func("minecraft:entity.sheep.step");
    @PythonField
    public static final String ENTITY_SHULKER_AMBIENT = func("minecraft:entity.shulker.ambient");
    @PythonField
    public static final String ENTITY_SHULKER_CLOSE = func("minecraft:entity.shulker.close");
    @PythonField
    public static final String ENTITY_SHULKER_DEATH = func("minecraft:entity.shulker.death");
    @PythonField
    public static final String ENTITY_SHULKER_HURT = func("minecraft:entity.shulker.hurt");
    @PythonField
    public static final String ENTITY_SHULKER_HURT_CLOSED = func("minecraft:entity.shulker.hurt_closed");
    @PythonField
    public static final String ENTITY_SHULKER_OPEN = func("minecraft:entity.shulker.open");
    @PythonField
    public static final String ENTITY_SHULKER_SHOOT = func("minecraft:entity.shulker.shoot");
    @PythonField
    public static final String ENTITY_SHULKER_TELEPORT = func("minecraft:entity.shulker.teleport");
    @PythonField
    public static final String ENTITY_SHULKER_BULLET_HIT = func("minecraft:entity.shulker_bullet.hit");
    @PythonField
    public static final String ENTITY_SHULKER_BULLET_HURT = func("minecraft:entity.shulker_bullet.hurt");
    @PythonField
    public static final String ENTITY_SILVERFISH_AMBIENT = func("minecraft:entity.silverfish.ambient");
    @PythonField
    public static final String ENTITY_SILVERFISH_DEATH = func("minecraft:entity.silverfish.death");
    @PythonField
    public static final String ENTITY_SILVERFISH_HURT = func("minecraft:entity.silverfish.hurt");
    @PythonField
    public static final String ENTITY_SILVERFISH_STEP = func("minecraft:entity.silverfish.step");
    @PythonField
    public static final String ENTITY_SKELETON_AMBIENT = func("minecraft:entity.skeleton.ambient");
    @PythonField
    public static final String ENTITY_SKELETON_DEATH = func("minecraft:entity.skeleton.death");
    @PythonField
    public static final String ENTITY_SKELETON_HURT = func("minecraft:entity.skeleton.hurt");
    @PythonField
    public static final String ENTITY_SKELETON_SHOOT = func("minecraft:entity.skeleton.shoot");
    @PythonField
    public static final String ENTITY_SKELETON_STEP = func("minecraft:entity.skeleton.step");
    @PythonField
    public static final String ENTITY_SKELETON_HORSE_AMBIENT = func("minecraft:entity.skeleton_horse.ambient");
    @PythonField
    public static final String ENTITY_SKELETON_HORSE_DEATH = func("minecraft:entity.skeleton_horse.death");
    @PythonField
    public static final String ENTITY_SKELETON_HORSE_HURT = func("minecraft:entity.skeleton_horse.hurt");
    @PythonField
    public static final String ENTITY_SLIME_ATTACK = func("minecraft:entity.slime.attack");
    @PythonField
    public static final String ENTITY_SLIME_DEATH = func("minecraft:entity.slime.death");
    @PythonField
    public static final String ENTITY_SLIME_HURT = func("minecraft:entity.slime.hurt");
    @PythonField
    public static final String ENTITY_SLIME_JUMP = func("minecraft:entity.slime.jump");
    @PythonField
    public static final String ENTITY_SLIME_SQUISH = func("minecraft:entity.slime.squish");
    @PythonField
    public static final String ENTITY_SMALL_MAGMACUBE_DEATH = func("minecraft:entity.small_magmacube.death");
    @PythonField
    public static final String ENTITY_SMALL_MAGMACUBE_HURT = func("minecraft:entity.small_magmacube.hurt");
    @PythonField
    public static final String ENTITY_SMALL_MAGMACUBE_SQUISH = func("minecraft:entity.small_magmacube.squish");
    @PythonField
    public static final String ENTITY_SMALL_SLIME_DEATH = func("minecraft:entity.small_slime.death");
    @PythonField
    public static final String ENTITY_SMALL_SLIME_HURT = func("minecraft:entity.small_slime.hurt");
    @PythonField
    public static final String ENTITY_SMALL_SLIME_JUMP = func("minecraft:entity.small_slime.jump");
    @PythonField
    public static final String ENTITY_SMALL_SLIME_SQUISH = func("minecraft:entity.small_slime.squish");
    @PythonField
    public static final String ENTITY_SNOWBALL_THROW = func("minecraft:entity.snowball.throw");
    @PythonField
    public static final String ENTITY_SNOWMAN_AMBIENT = func("minecraft:entity.snowman.ambient");
    @PythonField
    public static final String ENTITY_SNOWMAN_DEATH = func("minecraft:entity.snowman.death");
    @PythonField
    public static final String ENTITY_SNOWMAN_HURT = func("minecraft:entity.snowman.hurt");
    @PythonField
    public static final String ENTITY_SNOWMAN_SHOOT = func("minecraft:entity.snowman.shoot");
    @PythonField
    public static final String ENTITY_SPIDER_AMBIENT = func("minecraft:entity.spider.ambient");
    @PythonField
    public static final String ENTITY_SPIDER_DEATH = func("minecraft:entity.spider.death");
    @PythonField
    public static final String ENTITY_SPIDER_HURT = func("minecraft:entity.spider.hurt");
    @PythonField
    public static final String ENTITY_SPIDER_STEP = func("minecraft:entity.spider.step");
    @PythonField
    public static final String ENTITY_SPLASH_POTION_BREAK = func("minecraft:entity.splash_potion.break");
    @PythonField
    public static final String ENTITY_SPLASH_POTION_THROW = func("minecraft:entity.splash_potion.throw");
    @PythonField
    public static final String ENTITY_SQUID_AMBIENT = func("minecraft:entity.squid.ambient");
    @PythonField
    public static final String ENTITY_SQUID_DEATH = func("minecraft:entity.squid.death");
    @PythonField
    public static final String ENTITY_SQUID_HURT = func("minecraft:entity.squid.hurt");
    @PythonField
    public static final String ENTITY_STRAY_AMBIENT = func("minecraft:entity.stray.ambient");
    @PythonField
    public static final String ENTITY_STRAY_DEATH = func("minecraft:entity.stray.death");
    @PythonField
    public static final String ENTITY_STRAY_HURT = func("minecraft:entity.stray.hurt");
    @PythonField
    public static final String ENTITY_STRAY_STEP = func("minecraft:entity.stray.step");
    @PythonField
    public static final String ENTITY_TNT_PRIMED = func("minecraft:entity.tnt.primed");
    @PythonField
    public static final String ENTITY_VEX_AMBIENT = func("minecraft:entity.vex.ambient");
    @PythonField
    public static final String ENTITY_VEX_CHARGE = func("minecraft:entity.vex.charge");
    @PythonField
    public static final String ENTITY_VEX_DEATH = func("minecraft:entity.vex.death");
    @PythonField
    public static final String ENTITY_VEX_HURT = func("minecraft:entity.vex.hurt");
    @PythonField
    public static final String ENTITY_VILLAGER_AMBIENT = func("minecraft:entity.villager.ambient");
    @PythonField
    public static final String ENTITY_VILLAGER_DEATH = func("minecraft:entity.villager.death");
    @PythonField
    public static final String ENTITY_VILLAGER_HURT = func("minecraft:entity.villager.hurt");
    @PythonField
    public static final String ENTITY_VILLAGER_NO = func("minecraft:entity.villager.no");
    @PythonField
    public static final String ENTITY_VILLAGER_TRADING = func("minecraft:entity.villager.trading");
    @PythonField
    public static final String ENTITY_VILLAGER_YES = func("minecraft:entity.villager.yes");
    @PythonField
    public static final String ENTITY_VINDICATION_ILLAGER_AMBIENT = func("minecraft:entity.vindication_illager.ambient");
    @PythonField
    public static final String ENTITY_VINDICATION_ILLAGER_DEATH = func("minecraft:entity.vindication_illager.death");
    @PythonField
    public static final String ENTITY_VINDICATION_ILLAGER_HURT = func("minecraft:entity.vindication_illager.hurt");
    @PythonField
    public static final String ENTITY_WITCH_AMBIENT = func("minecraft:entity.witch.ambient");
    @PythonField
    public static final String ENTITY_WITCH_DEATH = func("minecraft:entity.witch.death");
    @PythonField
    public static final String ENTITY_WITCH_DRINK = func("minecraft:entity.witch.drink");
    @PythonField
    public static final String ENTITY_WITCH_HURT = func("minecraft:entity.witch.hurt");
    @PythonField
    public static final String ENTITY_WITCH_THROW = func("minecraft:entity.witch.throw");
    @PythonField
    public static final String ENTITY_WITHER_AMBIENT = func("minecraft:entity.wither.ambient");
    @PythonField
    public static final String ENTITY_WITHER_BREAK_BLOCK = func("minecraft:entity.wither.break_block");
    @PythonField
    public static final String ENTITY_WITHER_DEATH = func("minecraft:entity.wither.death");
    @PythonField
    public static final String ENTITY_WITHER_HURT = func("minecraft:entity.wither.hurt");
    @PythonField
    public static final String ENTITY_WITHER_SHOOT = func("minecraft:entity.wither.shoot");
    @PythonField
    public static final String ENTITY_WITHER_SPAWN = func("minecraft:entity.wither.spawn");
    @PythonField
    public static final String ENTITY_WITHER_SKELETON_AMBIENT = func("minecraft:entity.wither_skeleton.ambient");
    @PythonField
    public static final String ENTITY_WITHER_SKELETON_DEATH = func("minecraft:entity.wither_skeleton.death");
    @PythonField
    public static final String ENTITY_WITHER_SKELETON_HURT = func("minecraft:entity.wither_skeleton.hurt");
    @PythonField
    public static final String ENTITY_WITHER_SKELETON_STEP = func("minecraft:entity.wither_skeleton.step");
    @PythonField
    public static final String ENTITY_WOLF_AMBIENT = func("minecraft:entity.wolf.ambient");
    @PythonField
    public static final String ENTITY_WOLF_DEATH = func("minecraft:entity.wolf.death");
    @PythonField
    public static final String ENTITY_WOLF_GROWL = func("minecraft:entity.wolf.growl");
    @PythonField
    public static final String ENTITY_WOLF_HOWL = func("minecraft:entity.wolf.howl");
    @PythonField
    public static final String ENTITY_WOLF_HURT = func("minecraft:entity.wolf.hurt");
    @PythonField
    public static final String ENTITY_WOLF_PANT = func("minecraft:entity.wolf.pant");
    @PythonField
    public static final String ENTITY_WOLF_SHAKE = func("minecraft:entity.wolf.shake");
    @PythonField
    public static final String ENTITY_WOLF_STEP = func("minecraft:entity.wolf.step");
    @PythonField
    public static final String ENTITY_WOLF_WHINE = func("minecraft:entity.wolf.whine");
    @PythonField
    public static final String ENTITY_ZOMBIE_AMBIENT = func("minecraft:entity.zombie.ambient");
    @PythonField
    public static final String ENTITY_ZOMBIE_ATTACK_DOOR_WOOD = func("minecraft:entity.zombie.attack_door_wood");
    @PythonField
    public static final String ENTITY_ZOMBIE_ATTACK_IRON_DOOR = func("minecraft:entity.zombie.attack_iron_door");
    @PythonField
    public static final String ENTITY_ZOMBIE_BREAK_DOOR_WOOD = func("minecraft:entity.zombie.break_door_wood");
    @PythonField
    public static final String ENTITY_ZOMBIE_DEATH = func("minecraft:entity.zombie.death");
    @PythonField
    public static final String ENTITY_ZOMBIE_HURT = func("minecraft:entity.zombie.hurt");
    @PythonField
    public static final String ENTITY_ZOMBIE_INFECT = func("minecraft:entity.zombie.infect");
    @PythonField
    public static final String ENTITY_ZOMBIE_STEP = func("minecraft:entity.zombie.step");
    @PythonField
    public static final String ENTITY_ZOMBIE_HORSE_AMBIENT = func("minecraft:entity.zombie_horse.ambient");
    @PythonField
    public static final String ENTITY_ZOMBIE_HORSE_DEATH = func("minecraft:entity.zombie_horse.death");
    @PythonField
    public static final String ENTITY_ZOMBIE_HORSE_HURT = func("minecraft:entity.zombie_horse.hurt");
    @PythonField
    public static final String ENTITY_ZOMBIE_PIG_AMBIENT = func("minecraft:entity.zombie_pig.ambient");
    @PythonField
    public static final String ENTITY_ZOMBIE_PIG_ANGRY = func("minecraft:entity.zombie_pig.angry");
    @PythonField
    public static final String ENTITY_ZOMBIE_PIG_DEATH = func("minecraft:entity.zombie_pig.death");
    @PythonField
    public static final String ENTITY_ZOMBIE_PIG_HURT = func("minecraft:entity.zombie_pig.hurt");
    @PythonField
    public static final String ENTITY_ZOMBIE_VILLAGER_AMBIENT = func("minecraft:entity.zombie_villager.ambient");
    @PythonField
    public static final String ENTITY_ZOMBIE_VILLAGER_CONVERTED = func("minecraft:entity.zombie_villager.converted");
    @PythonField
    public static final String ENTITY_ZOMBIE_VILLAGER_CURE = func("minecraft:entity.zombie_villager.cure");
    @PythonField
    public static final String ENTITY_ZOMBIE_VILLAGER_DEATH = func("minecraft:entity.zombie_villager.death");
    @PythonField
    public static final String ENTITY_ZOMBIE_VILLAGER_HURT = func("minecraft:entity.zombie_villager.hurt");
    @PythonField
    public static final String ENTITY_ZOMBIE_VILLAGER_STEP = func("minecraft:entity.zombie_villager.step");
    @PythonField
    public static final String ITEM_ARMOR_EQUIP_CHAIN = func("minecraft:item.armor.equip_chain");
    @PythonField
    public static final String ITEM_ARMOR_EQUIP_DIAMOND = func("minecraft:item.armor.equip_diamond");
    @PythonField
    public static final String ITEM_ARMOR_EQUIP_ELYTRA = func("minecraft:item.armor.equip_elytra");
    @PythonField
    public static final String ITEM_ARMOR_EQUIP_GENERIC = func("minecraft:item.armor.equip_generic");
    @PythonField
    public static final String ITEM_ARMOR_EQUIP_GOLD = func("minecraft:item.armor.equip_gold");
    @PythonField
    public static final String ITEM_ARMOR_EQUIP_IRON = func("minecraft:item.armor.equip_iron");
    @PythonField
    public static final String ITEM_ARMOR_EQUIP_LEATHER = func("minecraft:item.armor.equip_leather");
    @PythonField
    public static final String ITEM_BOTTLE_EMPTY = func("minecraft:item.bottle.empty");
    @PythonField
    public static final String ITEM_BOTTLE_FILL = func("minecraft:item.bottle.fill");
    @PythonField
    public static final String ITEM_BOTTLE_FILL_DRAGONBREATH = func("minecraft:item.bottle.fill_dragonbreath");
    @PythonField
    public static final String ITEM_BUCKET_EMPTY = func("minecraft:item.bucket.empty");
    @PythonField
    public static final String ITEM_BUCKET_EMPTY_LAVA = func("minecraft:item.bucket.empty_lava");
    @PythonField
    public static final String ITEM_BUCKET_FILL = func("minecraft:item.bucket.fill");
    @PythonField
    public static final String ITEM_BUCKET_FILL_LAVA = func("minecraft:item.bucket.fill_lava");
    @PythonField
    public static final String ITEM_CHORUS_FRUIT_TELEPORT = func("minecraft:item.chorus_fruit.teleport");
    @PythonField
    public static final String ITEM_ELYTRA_FLYING = func("minecraft:item.elytra.flying");
    @PythonField
    public static final String ITEM_FIRECHARGE_USE = func("minecraft:item.firecharge.use");
    @PythonField
    public static final String ITEM_FLINTANDSTEEL_USE = func("minecraft:item.flintandsteel.use");
    @PythonField
    public static final String ITEM_HOE_TILL = func("minecraft:item.hoe.till");
    @PythonField
    public static final String ITEM_SHIELD_BLOCK = func("minecraft:item.shield.block");
    @PythonField
    public static final String ITEM_SHIELD_BREAK = func("minecraft:item.shield.break");
    @PythonField
    public static final String ITEM_SHOVEL_FLATTEN = func("minecraft:item.shovel.flatten");
    @PythonField
    public static final String ITEM_TOTEM_USE = func("minecraft:item.totem.use");
    @PythonField
    public static final String MUSIC_CREATIVE = func("minecraft:music.creative");
    @PythonField
    public static final String MUSIC_CREDITS = func("minecraft:music.credits");
    @PythonField
    public static final String MUSIC_DRAGON = func("minecraft:music.dragon");
    @PythonField
    public static final String MUSIC_END = func("minecraft:music.end");
    @PythonField
    public static final String MUSIC_GAME = func("minecraft:music.game");
    @PythonField
    public static final String MUSIC_MENU = func("minecraft:music.menu");
    @PythonField
    public static final String MUSIC_NETHER = func("minecraft:music.nether");
    @PythonField
    public static final String RECORD_11 = func("minecraft:record.11");
    @PythonField
    public static final String RECORD_13 = func("minecraft:record.13");
    @PythonField
    public static final String RECORD_BLOCKS = func("minecraft:record.blocks");
    @PythonField
    public static final String RECORD_CAT = func("minecraft:record.cat");
    @PythonField
    public static final String RECORD_CHIRP = func("minecraft:record.chirp");
    @PythonField
    public static final String RECORD_FAR = func("minecraft:record.far");
    @PythonField
    public static final String RECORD_MALL = func("minecraft:record.mall");
    @PythonField
    public static final String RECORD_MELLOHI = func("minecraft:record.mellohi");
    @PythonField
    public static final String RECORD_STAL = func("minecraft:record.stal");
    @PythonField
    public static final String RECORD_STRAD = func("minecraft:record.strad");
    @PythonField
    public static final String RECORD_WAIT = func("minecraft:record.wait");
    @PythonField
    public static final String RECORD_WARD = func("minecraft:record.ward");
    @PythonField
    public static final String UI_BUTTON_CLICK = func("minecraft:ui.button.click");
    @PythonField
    public static final String UI_TOAST_IN = func("minecraft:ui.toast.in");
    @PythonField
    public static final String UI_TOAST_OUT = func("minecraft:ui.toast.out");
    @PythonField
    public static final String UI_TOAST_CHALLENGE_COMPLETE = func("minecraft:ui.toast.challenge_complete");
    @PythonField
    public static final String WEATHER_RAIN = func("minecraft:weather.rain");
    @PythonField
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