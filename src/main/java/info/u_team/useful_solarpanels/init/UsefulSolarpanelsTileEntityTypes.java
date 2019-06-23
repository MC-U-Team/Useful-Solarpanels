package info.u_team.useful_solarpanels.init;

import static info.u_team.useful_solarpanels.init.UsefulSolarpanelsBlocks.TIER_1;

import info.u_team.u_team_core.tileentitytype.UTileEntityType;
import info.u_team.u_team_core.util.registry.BaseRegistryUtil;
import info.u_team.useful_solarpanels.UsefulSolarpanelsMod;
import info.u_team.useful_solarpanels.tileentity.SolarpanelTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UsefulSolarpanelsMod.MODID, bus = Bus.MOD)
public class UsefulSolarpanelsTileEntityTypes {
	
	public static final TileEntityType<SolarpanelTileEntity> SOLARPANEL = UTileEntityType.UBuilder.create("solarpanel", SolarpanelTileEntity::new, TIER_1).build();
	
	@SubscribeEvent
	public static void register(Register<TileEntityType<?>> event) {
		BaseRegistryUtil.getAllGenericRegistryEntriesAndApplyNames(UsefulSolarpanelsMod.MODID, TileEntityType.class).forEach(event.getRegistry()::register);
	}
}
