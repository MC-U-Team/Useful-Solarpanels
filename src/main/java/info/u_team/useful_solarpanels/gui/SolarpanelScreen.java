package info.u_team.useful_solarpanels.gui;

import info.u_team.u_team_core.gui.UContainerScreen;
import info.u_team.useful_solarpanels.UsefulSolarpanelsMod;
import info.u_team.useful_solarpanels.container.SolarpanelContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class SolarpanelScreen extends UContainerScreen<SolarpanelContainer> {
	
	private static ResourceLocation TEXTURE = new ResourceLocation(UsefulSolarpanelsMod.MODID, "textures/gui/solarpanel.png");
	
	public SolarpanelScreen(SolarpanelContainer container, PlayerInventory playerInventory, ITextComponent title) {
		super(container, playerInventory, title, TEXTURE);
		xSize = 176;
		ySize = 168;
	}
	
	@Override
	protected void init() {
		super.init();
		addButton(new EnergyStorageWidget(guiLeft + 9, guiTop + 17, 54, () -> 1000, () -> 100));
		addButton(new SolarGenerationStateWidget(guiLeft + 30, guiTop + 50, () -> GenerationState.NO));
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		renderBackground();
		super.render(mouseX, mouseY, partialTicks);
		buttons.forEach(button -> button.renderToolTip(mouseX, mouseY));
		renderHoveredToolTip(mouseX, mouseY);
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		font.drawString(title.getFormattedText(), 8, 6, 4210752);
		font.drawString(playerInventory.getDisplayName().getFormattedText(), 8.0F, ySize - 94, 4210752);
	}
	
}
