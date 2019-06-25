package info.u_team.useful_solarpanels.gui;

import java.util.*;
import java.util.function.Supplier;

import info.u_team.useful_solarpanels.UsefulSolarpanelsMod;
import net.minecraft.client.*;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.fml.client.config.GuiUtils;

@OnlyIn(Dist.CLIENT)
public class SolarGenerationStateWidget extends Widget {
	
	public static final ResourceLocation STATE_TEXTURE = new ResourceLocation(UsefulSolarpanelsMod.MODID, "textures/gui/generation_state.png");
	
	private final Supplier<GenerationState> state;
	
	public SolarGenerationStateWidget(int x, int y, Supplier<GenerationState> state) {
		super(x, y, 10, 10, "");
		this.state = state;
	}
	
	@Override
	public void renderButton(int mouseX, int mouseY, float partialTicks) {
		final Minecraft minecraft = Minecraft.getInstance();
		
		minecraft.getTextureManager().bindTexture(STATE_TEXTURE);
		final int imageOffset = state.get() == GenerationState.DAY ? 1 : state.get() == GenerationState.NIGHT ? 2 : 0;
		blit(x + 1, y + 1, 0, 8 * imageOffset, 8, 8, 32, 32);
		
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
			list.add("Generation state");
			GuiUtils.drawHoveringText(list, mouseX, mouseY, mainWindow.getWidth(), mainWindow.getHeight(), 300, minecraft.fontRenderer);
		}
	}
	
	@Override
	public void playDownSound(SoundHandler handler) {
		// Don't play click sound
	}
	
}
