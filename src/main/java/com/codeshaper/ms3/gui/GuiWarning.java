package com.codeshaper.ms3.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.codeshaper.ms3.Ms3;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Used for the warning message when you first open Ms3.
 */
@SideOnly(Side.CLIENT)
public class GuiWarning extends GuiScreen {
	
	private GuiScreen mainMenuGui;

	public GuiWarning(GuiScreen gui) {
		this.mainMenuGui = gui;
	}

	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	@Override
	public void initGui() {
		Keyboard.enableRepeatEvents(true);
		this.buttonList.clear();
		this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12,
				I18n.format("ms3.warning.agree", new Object[0])));
	}

	/**
	 * Called when the screen is unloaded. Used to disable keyboard repeat events
	 */
	@Override
	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button.enabled && button.id == 0) {
			Ms3.ms3Props.setShowWarning(false);
			this.mc.displayGuiScreen(this.mainMenuGui);
		}
	}

	/**
	 * Draws the screen and all the components in it. Args : mouseX, mouseY,
	 * renderPartialTicks
	 */
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		int WHITE = 16777215;

		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRenderer, I18n.format("ms3.warning.warning", new Object[0]), this.width / 2,
				20, WHITE);

		for (int i = 1; i <= 4; i++) {
			this.drawCenteredString(this.fontRenderer, I18n.format("ms3.warning.line" + i, new Object[0]),
					this.width / 2, 60 + ((i - 1) * 15), WHITE);
		}

		this.drawCenteredString(this.fontRenderer, I18n.format("ms3.warning.notAgain", new Object[0]), this.width / 2,
				130, WHITE);

		// this.drawString(this.fontRendererObj, I18n.format("selectWorld.enterName",
		// new Object[0]), this.width / 2 - 100, 47, 10526880);
		// this.textField.drawTextBox();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
