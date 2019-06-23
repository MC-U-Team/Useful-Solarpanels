package info.u_team.useful_solarpanels.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.*;

public class CommonConfig {
	
	public static final ForgeConfigSpec CONFIG;
	private static final CommonConfig INSTANCE;
	
	static {
		Pair<CommonConfig, ForgeConfigSpec> pair = new Builder().configure(CommonConfig::new);
		CONFIG = pair.getRight();
		INSTANCE = pair.getLeft();
	}
	
	public static CommonConfig getInstance() {
		return INSTANCE;
	}
	
	public final SolarConfig tier1SolarPanel;
	
	private CommonConfig(Builder builder) {
		builder.comment("Solar panel configuration").push("solarpanels");
		tier1SolarPanel = createSolarConfig(builder, "tier1", 128, 64, 100000, 1000);
		builder.pop();
	}
	
	private SolarConfig createSolarConfig(Builder builder, String name, int defaultGenerateDay, int defaultGenerateNight, long defaultCapacity, int defaultTransfer) {
		builder.push(name);
		final IntValue generateDay = builder.comment("Generation in FE at daytime").defineInRange("generationDay", defaultGenerateDay, 1, Integer.MAX_VALUE);
		final IntValue generateNight = builder.comment("Generation in FE at night").defineInRange("generationNight", defaultGenerateNight, 1, Integer.MAX_VALUE);
		final LongValue capacity = builder.comment("Internal storage").defineInRange("capactity", defaultCapacity, 1, Long.MAX_VALUE);
		final IntValue transfer = builder.comment("Max output transfer in FE").defineInRange("transfer", defaultTransfer, 1, Integer.MAX_VALUE);
		builder.pop();
		return new SolarConfig(generateDay, generateNight, capacity, transfer);
	}
	
}