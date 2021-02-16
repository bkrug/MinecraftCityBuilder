package com.example.examplemod;

import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;

public class CobblestoneStreetBlock extends Block {

	public static final Property<Direction> FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);

	public CobblestoneStreetBlock(String name, Properties material) {
		super(material);
		//setUnlocalizedName(name);
		//setRegistryName(name);
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {	
		builder.add(FACING);
	}
	
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		Direction horizFacing = context.getPlacementHorizontalFacing();
		return this.stateContainer.getBaseState().with(FACING, horizFacing);
	}
}