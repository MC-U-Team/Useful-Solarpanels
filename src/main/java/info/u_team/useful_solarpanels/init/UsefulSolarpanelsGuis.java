package info.u_team.useful_solarpanels.init;

import info.u_team.useful_solarpanels.gui.SolarpanelScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class UsefulSolarpanelsGuis {
	
	public static void construct() {
		ScreenManager.registerFactory(UsefulSolarpanelsContainerTypes.SOLARPANEL, SolarpanelScreen::new);
	}
}
