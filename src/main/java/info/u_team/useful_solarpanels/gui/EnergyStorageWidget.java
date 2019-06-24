package info.u_team.useful_solarpanels.gui;

import java.util.function.LongSupplier;

import info.u_team.useful_solarpanels.UsefulSolarpanelsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class EnergyStorageWidget extends Widget {
	
	public static final ResourceLocation ENERGY_TEXTURE = new ResourceLocation(UsefulSolarpanelsMod.MODID, "textures/gui/energy.png");
	
	private final LongSupplier capacity;
	private final LongSupplier storage;
	
	public EnergyStorageWidget(int x, int y, int height, String msg, LongSupplier capacity, LongSupplier storage) {
		super(x, y, 14, height < 3 ? 3 : height, msg);
		this.capacity = capacity;
		this.storage = storage;
	}
	
	@Override
	public void renderButton(int mouseX, int mouseY, float partialTicks) {
		final Minecraft minecraft = Minecraft.getInstance();
		minecraft.getTextureManager().bindTexture(ENERGY_TEXTURE);
		blit(x, y, 0, 0, 14, 1, 16, 16);
		
		int c = 0;
		int s = 0;
		for (int yComponent = 1; yComponent < height; yComponent += 2) {
			blit(x, y + yComponent, 0, 1, 14, 2, 16, 16);
			c++;
		}
		for (int yComponent = height; yComponent > ((double) storage.getAsLong() / capacity.getAsLong()) * height + 4; yComponent -= 2) {
			blit(x + 1, y + yComponent, 0, 4, 12, 2, 16, 16);
			s++;
		}
		
		blit(x, y + height, 0, 3, 14, 1, 16, 16);
		
		System.out.println(c + " - " + s + " - " + (double) s / c);
	}
}
