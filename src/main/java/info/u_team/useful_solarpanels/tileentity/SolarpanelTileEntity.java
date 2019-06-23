package info.u_team.useful_solarpanels.tileentity;

import info.u_team.u_team_core.api.sync.IAutoSyncedTileEntity;
import info.u_team.u_team_core.container.USyncedTileEntityContainer;
import info.u_team.u_team_core.tileentity.UTileEntity;
import info.u_team.useful_solarpanels.UsefulSolarpanelsMod;
import info.u_team.useful_solarpanels.block.SolarpanelBlock;
import info.u_team.useful_solarpanels.container.SolarpanelContainer;
import info.u_team.useful_solarpanels.init.UsefulSolarpanelsTileEntityTypes;
import info.u_team.useful_solarpanels.type.Solarpanel;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Direction;
import net.minecraft.util.text.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.*;

public class SolarpanelTileEntity extends UTileEntity implements IAutoSyncedTileEntity {
	
	private final LazyOptional<Solarpanel> solarpanel = LazyOptional.of(() -> ((SolarpanelBlock) getBlockState().getBlock()).getSolarpanel());
	
	private final LazyOptional<ItemStackHandler> upgradeSlots = LazyOptional.of(() -> new ItemStackHandler(5) {
		
		public int getSlotLimit(int slot) {
			return 5;
		}
	});
	
	public SolarpanelTileEntity() {
		super(UsefulSolarpanelsTileEntityTypes.SOLARPANEL);
	}
	
	@Override
	public void readNBT(CompoundNBT compound) {
		upgradeSlots.ifPresent(handler -> handler.deserializeNBT(compound.getCompound("upgrade_slots")));
	}
	
	@Override
	public void writeNBT(CompoundNBT compound) {
		upgradeSlots.ifPresent(handler -> compound.put("upgrade_slots", handler.serializeNBT()));
	}
	
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction side) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return upgradeSlots.cast();
		}
		return super.getCapability(capability, side);
	}
	
	@Override
	public USyncedTileEntityContainer<?> createMenu(int id, PlayerInventory playerInventory, PlayerEntity player) {
		return new SolarpanelContainer(id, playerInventory, this);
	}
	
	@Override
	public ITextComponent getDisplayName() {
		return new TranslationTextComponent("block." + UsefulSolarpanelsMod.MODID + ".solarpanel_" + solarpanel.orElse(null));
	}
	
	// Server -> Client
	
	@Override
	public void sendToClient(PacketBuffer buffer) {
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void handleFromServer(PacketBuffer buffer) {
	}
	
	// Client -> Server
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void sendToServer(PacketBuffer buffer) {
	}
	
	@Override
	public void handleFromClient(PacketBuffer buffer) {
	}
	
}
