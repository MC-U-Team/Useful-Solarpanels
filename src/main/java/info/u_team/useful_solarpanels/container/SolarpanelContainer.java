package info.u_team.useful_solarpanels.container;

import info.u_team.u_team_core.container.USyncedTileEntityContainer;
import info.u_team.useful_solarpanels.init.UsefulSolarpanelsContainerTypes;
import info.u_team.useful_solarpanels.tileentity.SolarpanelTileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketBuffer;

public class SolarpanelContainer extends USyncedTileEntityContainer<SolarpanelTileEntity> {
	
	public SolarpanelContainer(int id, PlayerInventory playerInventory, SolarpanelTileEntity tileEntity) {
		super(UsefulSolarpanelsContainerTypes.SOLARPANEL, id, playerInventory, tileEntity);
	}
	
	public SolarpanelContainer(int id, PlayerInventory playerInventory, PacketBuffer buffer) {
		super(UsefulSolarpanelsContainerTypes.SOLARPANEL, id, playerInventory, buffer);
	}
	
	@Override
	protected void init(boolean server) {
	}
	
}
