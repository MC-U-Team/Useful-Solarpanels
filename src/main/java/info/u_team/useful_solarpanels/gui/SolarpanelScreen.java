package info.u_team.useful_solarpanels.gui;

import info.u_team.u_team_core.gui.UContainerScreen;
import info.u_team.useful_solarpanels.container.SolarpanelContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class SolarpanelScreen extends UContainerScreen<SolarpanelContainer> {
	
	public SolarpanelScreen(SolarpanelContainer container, PlayerInventory playerInventory, ITextComponent title) {
		super(container, playerInventory, title, new ResourceLocation("null"));
	}
	
}
