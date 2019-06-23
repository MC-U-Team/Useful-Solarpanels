package info.u_team.useful_solarpanels.init;

import static info.u_team.useful_solarpanels.init.UsefulSolarpanelsBlocks.TIER_1;

import info.u_team.useful_solarpanels.UsefulSolarpanelsMod;
import info.u_team.useful_solarpanels.block.SolarpanelBlock;
import net.minecraft.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UsefulSolarpanelsMod.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class UsefulSolarpanelsColors {
	
	@SubscribeEvent
	public static void register(ColorHandlerEvent.Item event) {
		event.getBlockColors().register((state, world, pos, index) -> {
			if (index == 1) {
				return ((SolarpanelBlock) state.getBlock()).getSolarpanel().getColor();
			}
			return 0;
		}, TIER_1);
		
		event.getItemColors().register((stack, index) -> {
			if (index == 1) {
				return ((SolarpanelBlock) Block.getBlockFromItem(stack.getItem())).getSolarpanel().getColor();
			}
			return 0;
		}, TIER_1);
	}
	
}
