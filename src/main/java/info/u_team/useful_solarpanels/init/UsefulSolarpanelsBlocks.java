package info.u_team.useful_solarpanels.init;

import java.util.List;

import info.u_team.u_team_core.util.registry.BaseRegistryUtil;
import info.u_team.useful_solarpanels.UsefulSolarpanelsMod;
import info.u_team.useful_solarpanels.block.SolarpanelBlock;
import info.u_team.useful_solarpanels.type.Solarpanel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UsefulSolarpanelsMod.MODID, bus = Bus.MOD)
public class UsefulSolarpanelsBlocks {
	
	public static final SolarpanelBlock TIER_1 = new SolarpanelBlock(Solarpanel.TIER_1);
	
	@SubscribeEvent
	public static void register(Register<Block> event) {
		entries = BaseRegistryUtil.getAllRegistryEntriesAndApplyNames(UsefulSolarpanelsMod.MODID, Block.class);
		entries.forEach(event.getRegistry()::register);
	}
	
	@SubscribeEvent
	public static void registerBlockItem(Register<Item> event) {
		BaseRegistryUtil.getBlockItems(entries).forEach(event.getRegistry()::register);
	}
	
	// Just a cache for the block item registry for performance
	private static List<Block> entries;
}
