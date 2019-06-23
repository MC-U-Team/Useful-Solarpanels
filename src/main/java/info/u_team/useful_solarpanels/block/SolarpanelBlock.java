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
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;

public class SolarpanelBlock extends UTileEntityBlock {
	
	private final Solarpanel solarpanel;
	
	public SolarpanelBlock(Solarpanel solarpanel) {
		super("solarpanel_" + solarpanel.getName(), UsefulSolarpanelsItemGroups.GROUP, Properties.create(Material.IRON).hardnessAndResistance(1), new Item.Properties().rarity(solarpanel.getRarity()), () -> UsefulSolarpanelsTileEntityTypes.SOLARPANEL);
		this.solarpanel = solarpanel;
	}
	
	@Override
	public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		return openContainer(world, pos, player, true);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		// top to button shapes
		final VoxelShape shape1 = makeCuboidShape(0, 8, 0, 16, 10, 16);
		final VoxelShape shape2 = makeCuboidShape(5, 7, 5, 11, 8, 11);
		final VoxelShape shape3 = makeCuboidShape(6, 4, 6, 10, 7, 10);
		final VoxelShape shape4 = makeCuboidShape(5, 3, 5, 11, 4, 11);
		final VoxelShape shape5 = makeCuboidShape(1, 0, 1, 15, 3, 15);
		return VoxelShapes.or(shape1, shape2, shape3, shape4, shape5);
	}
	
	public Solarpanel getSolarpanel() {
		return solarpanel;
	}
}
