package com.codeshaper.ms3.apiBuilder;

import com.codeshaper.ms3.Ms3;
import com.codeshaper.ms3.api.BoundObject;
import com.codeshaper.ms3.api.biomes;
import com.codeshaper.ms3.api.blockUtils;
import com.codeshaper.ms3.api.blocks;
import com.codeshaper.ms3.api.colors;
import com.codeshaper.ms3.api.drawer;
import com.codeshaper.ms3.api.effectList;
import com.codeshaper.ms3.api.enchantments;
import com.codeshaper.ms3.api.entity;
import com.codeshaper.ms3.api.entityList;
import com.codeshaper.ms3.api.equipmentSlot;
import com.codeshaper.ms3.api.exception;
import com.codeshaper.ms3.api.executor;
import com.codeshaper.ms3.api.formattingCode;
import com.codeshaper.ms3.api.itemStack;
import com.codeshaper.ms3.api.itemUtils;
import com.codeshaper.ms3.api.items;
import com.codeshaper.ms3.api.obfuscationHelper;
import com.codeshaper.ms3.api.particleType;
import com.codeshaper.ms3.api.soundCategories;
import com.codeshaper.ms3.api.sounds;
import com.codeshaper.ms3.api.tileEntity;
import com.codeshaper.ms3.api.tileEntityList;
import com.codeshaper.ms3.api.translations;
import com.codeshaper.ms3.api.util;
import com.codeshaper.ms3.api.world;

/**
 * A list of classes to build into Python modules. Moved to a different class so
 * we wouldn't bloat the import section of ModuleBuilder.
 * 
 * @author CodeShaper
 */
public class BuildList {

	/** An array of all the classes to compile. Update this manually to add more. */
	public Class<?>[] classList;

	public BuildList() {
		this.classList = new Class[] {
				biomes.class,
				blockUtils.class,
				BoundObject.class,
				blocks.class,
				colors.class,
				drawer.class,
				effectList.class,
				enchantments.class,
				entity.class,
				entityList.class,
				equipmentSlot.class,
				exception.class,
				executor.class,
				formattingCode.class,
				// interpreter.class,
				itemUtils.class,
				items.class,
				itemStack.class,
				obfuscationHelper.class,
				particleType.class,
				soundCategories.class,
				sounds.class, 
				util.class,
				tileEntity.class,
				tileEntityList.class,
				translations.class,
				util.class,
				world.class,
				// worldBorder.class,
		};

		this.validateList();
	}

	/**
	 * Checks that no outside classer were added to the list.
	 * 
	 * @throws Error If an outside class was added.
	 */
	private void validateList() throws Error {
		for (Class<?> clazz : this.classList) {
			String s = clazz.getCanonicalName();
			if (!s.startsWith("com." + Ms3.AUTHOR + "." + Ms3.MOD_ID)) {
				throw new Error("The module build list should not contain classes from external jars and it contains "
						+ s + "!");
			}
		}
	}
}