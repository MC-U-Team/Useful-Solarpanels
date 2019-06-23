package info.u_team.useful_solarpanels.proxy;

import info.u_team.u_team_core.api.IModProxy;
import info.u_team.useful_solarpanels.init.UsefulSolarpanelsGuis;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClientProxy extends CommonProxy implements IModProxy {
	
	@Override
	public void construct() {
		super.construct();
		UsefulSolarpanelsGuis.construct();
	}
	
	@Override
	public void setup() {
		super.setup();
	}
	
	@Override
	public void complete() {
		super.complete();
	}
}
