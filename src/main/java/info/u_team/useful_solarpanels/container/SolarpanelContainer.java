package info.u_team.useful_solarpanels.container;

import info.u_team.u_team_core.container.USyncedTileEntityContainer;
import info.u_team.useful_solarpanels.init.UsefulSolarpanelsContainerTypes;
import info.u_team.useful_solarpanels.tileentity.SolarpanelTileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.items.*;

public class SolarpanelContainer extends USyncedTileEntityContainer<SolarpanelTileEntity> {
	
	public SolarpanelContainer(int id, PlayerInventory playerInventory, SolarpanelTileEntity tileEntity) {
		super(UsefulSolarpanelsContainerTypes.SOLARPANEL, id, playerInventory, tileEntity);
	}
	
	public SolarpanelContainer(int id, PlayerInventory playerInventory, PacketBuffer buffer) {
		super(UsefulSolarpanelsContainerTypes.SOLARPANEL, id, playerInventory, buffer);
	}
	
	@Override
	protected void init(boolean server) {
		tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
			for (int index = 0; index < handler.getSlots(); index++) {
				addSlot(new SlotItemHandler(handler, index, index * 18 + 10, 10));
			}
		});
		appendPlayerInventory(playerInventory, 8, 20);
	}
	
}
