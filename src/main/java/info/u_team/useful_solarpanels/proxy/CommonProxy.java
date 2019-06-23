package info.u_team.useful_solarpanels.proxy;

import info.u_team.u_team_core.api.IModProxy;
import info.u_team.useful_solarpanels.config.CommonConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig.Type;

public class CommonProxy implements IModProxy {
	
	@Override
	public void construct() {
		ModLoadingContext.get().registerConfig(Type.COMMON, CommonConfig.CONFIG);
	}
	
	@Override
	public void setup() {
		System.out.println("_______________________________________________________________________________________");
		System.out.println(CommonConfig.getInstance().tier1SolarPanel);
	}
	
	@Override
	public void complete() {
	}
	
}
