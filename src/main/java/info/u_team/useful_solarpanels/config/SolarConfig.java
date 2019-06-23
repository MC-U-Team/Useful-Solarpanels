package info.u_team.useful_solarpanels.config;

import net.minecraftforge.common.ForgeConfigSpec.*;

public class SolarConfig {
	
	private final IntValue generateDay;
	private final IntValue generateNight;
	private final LongValue capacity;
	private final IntValue transfer;
	
	public SolarConfig(IntValue generateDay, IntValue generateNight, LongValue capacity, IntValue transfer) {
		this.generateDay = generateDay;
		this.generateNight = generateNight;
		this.capacity = capacity;
		this.transfer = transfer;
	}
	
	public int getGenerateDay() {
		return generateDay.get();
	}
	
	public int getGenerateNight() {
		return generateNight.get();
	}
	
	public long getCapacity() {
		return capacity.get();
	}
	
	public int getTransfer() {
		return transfer.get();
	}
	
	@Override
	public String toString() {
		return "SolarConfig [getGenerateDay()=" + getGenerateDay() + ", getGenerateNight()=" + getGenerateNight() + ", getCapacity()=" + getCapacity() + ", getTransfer()=" + getTransfer() + "]";
	}
	
}
