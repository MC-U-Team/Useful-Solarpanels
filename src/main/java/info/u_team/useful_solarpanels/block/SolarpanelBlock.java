package info.u_team.useful_solarpanels.block;

import info.u_team.u_team_core.block.UTileEntityBlock;
import info.u_team.useful_solarpanels.init.*;
import info.u_team.useful_solarpanels.type.Solarpanel;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Hand;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

public class SolarpanelBlock extends UTileEntityBlock {
	
	private final Solarpanel solarpanel;
	
	public SolarpanelBlock(Solarpanel solarpanel) {
		super("solarpanel_" + solarpanel.getName(), UsefulSolarpanelsItemGroups.GROUP, Properties.create(Material.IRON).hardnessAndResistance(1).doesNotBlockMovement(), new Item.Properties().rarity(solarpanel.getRarity()), () -> UsefulSolarpanelsTileEntityTypes.SOLARPANEL);
		this.solarpanel = solarpanel;
	}
	
	@Override
	public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		return openContainer(world, pos, player, true);
	}
	
	public Solarpanel getSolarpanel() {
		return solarpanel;
	}
}
