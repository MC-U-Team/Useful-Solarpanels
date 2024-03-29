package info.u_team.useful_solarpanels.gui;

import java.util.*;
import java.util.function.LongSupplier;

import info.u_team.useful_solarpanels.UsefulSolarpanelsMod;
import net.minecraft.client.*;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.fml.client.config.GuiUtils;

@OnlyIn(Dist.CLIENT)
public class EnergyStorageWidget extends Widget {
	
	public static final ResourceLocation ENERGY_TEXTURE = new ResourceLocation(UsefulSolarpanelsMod.MODID, "textures/gui/energy.png");
	
	private final LongSupplier capacity;
	private final LongSupplier storage;
	
	public EnergyStorageWidget(int x, int y, int height, LongSupplier capacity, LongSupplier storage) {
		super(x, y, 14, height < 3 ? 3 : height, "");
		this.capacity = capacity;
		this.storage = storage;
	}
	
	@Override
	public void renderButton(int mouseX, int mouseY, float partialTicks) {
		final Minecraft minecraft = Minecraft.getInstance();
		minecraft.getTextureManager().bindTexture(ENERGY_TEXTURE);
		
		double ratio = (double) storage.getAsLong() / capacity.getAsLong();
		if (ratio > 1) {
			ratio = 1;
		}
		
		final int storageOffset = (int) ((1 - ratio) * (height - 2));
		
		for (int yComponent = 1; yComponent < height - 1; yComponent += 2) {
			blit(x + 1, y + yComponent, 0, 0, 12, 2, 16, 16); // Background with side border
		}
		
		for (int yComponent = 1 + storageOffset; yComponent < height - 1; yComponent++) {
			if (yComponent % 2 == 0) {
				blit(x + 1, y + yComponent, 0, 3, 12, 1, 16, 16); // Fuel
			} else {
				blit(x + 1, y + yComponent, 0, 2, 12, 1, 16, 16); // Fuel
			}
		}
		
		drawContainerBorder(x, y, width, height);
	}
	
	private static void drawContainerBorder(int x, int y, int width, int height) {
		
		// ARGB ... Strange formal
		
		final int darkColor = 0xFF373737;
		final int mediumColor = 0xFF8B8B8B;
		final int brightColor = 0xFFFFFFFF;
		
		fill(x, y, x + width - 1, y + 1, darkColor);
		fill(x, y, x + 1, y + height - 1, darkColor);
		
		fill(x + width - 1, y, x + width, y + 1, mediumColor);
		fill(x, y + height - 1, x + 1, y + height, mediumColor);
		
		fill(x + 1, y + height, x + width - 1, y + height - 1, brightColor);
		fill(x + width - 1, y + 1, x + width, y + height, brightColor);
	}
	
	@Override
	public void renderToolTip(int mouseX, int mouseY) {
		if (isHovered) {
			final Minecraft minecraft = Minecraft.getInstance();
			final MainWindow mainWindow = minecraft.mainWindow;
			final List<String> list = new ArrayList<>();
			list.add(storage.getAsLong() + " / " + capacity.getAsLong() + " FE");
			GuiUtils.drawHoveringText(list, mouseX, mouseY, mainWindow.getWidth(), mainWindow.getHeight(), 300, minecraft.fontRenderer);
		}
	}
	
	@Override
	public void playDownSound(SoundHandler handler) {
		// Don't play click sound
	}
}
