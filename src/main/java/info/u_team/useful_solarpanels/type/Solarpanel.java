package info.u_team.useful_solarpanels.type;

import java.util.function.Supplier;

import info.u_team.useful_solarpanels.config.*;
import net.minecraft.item.Rarity;
import net.minecraft.util.IStringSerializable;

public enum Solarpanel implements IStringSerializable {
	
	TIER_1("tier_1", Rarity.COMMON, 0xFFFFFF, () -> CommonConfig.getInstance().tier1SolarPanel);
	
	private final String name;
	private final Rarity rarity;
	private final int color;
	private final Supplier<SolarConfig> config;
	
	private Solarpanel(String name, Rarity rarity, int color, Supplier<SolarConfig> config) {
		this.name = name;
		this.rarity = rarity;
		this.color = color;
		this.config = config;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public Rarity getRarity() {
		return rarity;
	}
	
	public int getColor() {
		return color;
	}
	
	public SolarConfig getConfig() {
		return config.get();
	}
	
}
