package info.u_team.useful_solarpanels.init;

import info.u_team.u_team_core.containertype.UContainerType;
import info.u_team.u_team_core.util.registry.BaseRegistryUtil;
import info.u_team.useful_solarpanels.UsefulSolarpanelsMod;
import info.u_team.useful_solarpanels.container.SolarpanelContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UsefulSolarpanelsMod.MODID, bus = Bus.MOD)
public class UsefulSolarpanelsContainerTypes {
	
	public static final ContainerType<SolarpanelContainer> SOLARPANEL = new UContainerType<SolarpanelContainer>("solarpanel", SolarpanelContainer::new);
	
	@SubscribeEvent
	public static void register(Register<ContainerType<?>> event) {
		BaseRegistryUtil.getAllGenericRegistryEntriesAndApplyNames(UsefulSolarpanelsMod.MODID, ContainerType.class).forEach(event.getRegistry()::register);
	}
}
