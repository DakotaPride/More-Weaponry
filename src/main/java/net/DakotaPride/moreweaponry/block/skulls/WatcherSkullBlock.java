package net.DakotaPride.moreweaponry.block.skulls;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

import static net.DakotaPride.moreweaponry.block.custom.WretchedSkullBlock.FACING;

public class WatcherSkullBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public WatcherSkullBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(4, 0, 4, 12, 8, 12),
            Block.createCuboidShape(13, 13, 9, 15, 14, 10),
            Block.createCuboidShape(12, 6, 9, 16, 7, 10),
            Block.createCuboidShape(13, 7, 9, 17, 8, 10),
            Block.createCuboidShape(14, 8, 9, 17, 9, 10),
            Block.createCuboidShape(13, 9, 9, 16, 10, 10),
            Block.createCuboidShape(15, 10, 9, 20, 11, 10),
            Block.createCuboidShape(18, 9, 9, 20, 10, 10),
            Block.createCuboidShape(18, 7, 9, 19, 9, 10),
            Block.createCuboidShape(14, 11, 9, 19, 12, 10),
            Block.createCuboidShape(12, 12, 9, 17, 13, 10),
            Block.createCuboidShape(1, 13, 9, 3, 14, 10),
            Block.createCuboidShape(0, 6, 9, 4, 7, 10),
            Block.createCuboidShape(-1, 7, 9, 3, 8, 10),
            Block.createCuboidShape(-1, 8, 9, 2, 9, 10),
            Block.createCuboidShape(0, 9, 9, 3, 10, 10),
            Block.createCuboidShape(-4, 10, 9, 1, 11, 10),
            Block.createCuboidShape(-4, 9, 9, -2, 10, 10),
            Block.createCuboidShape(-3, 7, 9, -2, 9, 10),
            Block.createCuboidShape(-3, 11, 9, 2, 12, 10),
            Block.createCuboidShape(-1, 12, 9, 4, 13, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(4, 0, 4, 12, 8, 12),
            Block.createCuboidShape(1, 13, 6, 3, 14, 7),
            Block.createCuboidShape(0, 6, 6, 4, 7, 7),
            Block.createCuboidShape(-1, 7, 6, 3, 8, 7),
            Block.createCuboidShape(-1, 8, 6, 2, 9, 7),
            Block.createCuboidShape(0, 9, 6, 3, 10, 7),
            Block.createCuboidShape(-4, 10, 6, 1, 11, 7),
            Block.createCuboidShape(-4, 9, 6, -2, 10, 7),
            Block.createCuboidShape(-3, 7, 6, -2, 9, 7),
            Block.createCuboidShape(-3, 11, 6, 2, 12, 7),
            Block.createCuboidShape(-1, 12, 6, 4, 13, 7),
            Block.createCuboidShape(13, 13, 6, 15, 14, 7),
            Block.createCuboidShape(12, 6, 6, 16, 7, 7),
            Block.createCuboidShape(13, 7, 6, 17, 8, 7),
            Block.createCuboidShape(14, 8, 6, 17, 9, 7),
            Block.createCuboidShape(13, 9, 6, 16, 10, 7),
            Block.createCuboidShape(15, 10, 6, 20, 11, 7),
            Block.createCuboidShape(18, 9, 6, 20, 10, 7),
            Block.createCuboidShape(18, 7, 6, 19, 9, 7),
            Block.createCuboidShape(14, 11, 6, 19, 12, 7),
            Block.createCuboidShape(12, 12, 6, 17, 13, 7)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(4, 0, 4, 12, 8, 12),
            Block.createCuboidShape(9, 13, 1, 10, 14, 3),
            Block.createCuboidShape(9, 6, 0, 10, 7, 4),
            Block.createCuboidShape(9, 7, -1, 10, 8, 3),
            Block.createCuboidShape(9, 8, -1, 10, 9, 2),
            Block.createCuboidShape(9, 9, 0, 10, 10, 3),
            Block.createCuboidShape(9, 10, -4, 10, 11, 1),
            Block.createCuboidShape(9, 9, -4, 10, 10, -2),
            Block.createCuboidShape(9, 7, -3, 10, 9, -2),
            Block.createCuboidShape(9, 11, -3, 10, 12, 2),
            Block.createCuboidShape(9, 12, -1, 10, 13, 4),
            Block.createCuboidShape(9, 13, 13, 10, 14, 15),
            Block.createCuboidShape(9, 6, 12, 10, 7, 16),
            Block.createCuboidShape(9, 7, 13, 10, 8, 17),
            Block.createCuboidShape(9, 8, 14, 10, 9, 17),
            Block.createCuboidShape(9, 9, 13, 10, 10, 16),
            Block.createCuboidShape(9, 10, 15, 10, 11, 20),
            Block.createCuboidShape(9, 9, 18, 10, 10, 20),
            Block.createCuboidShape(9, 7, 18, 10, 9, 19),
            Block.createCuboidShape(9, 11, 14, 10, 12, 19),
            Block.createCuboidShape(9, 12, 12, 10, 13, 17)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(4, 0, 4, 12, 8, 12),
            Block.createCuboidShape(6, 13, 13, 7, 14, 15),
            Block.createCuboidShape(6, 6, 12, 7, 7, 16),
            Block.createCuboidShape(6, 7, 13, 7, 8, 17),
            Block.createCuboidShape(6, 8, 14, 7, 9, 17),
            Block.createCuboidShape(6, 9, 13, 7, 10, 16),
            Block.createCuboidShape(6, 10, 15, 7, 11, 20),
            Block.createCuboidShape(6, 9, 18, 7, 10, 20),
            Block.createCuboidShape(6, 7, 18, 7, 9, 19),
            Block.createCuboidShape(6, 11, 14, 7, 12, 19),
            Block.createCuboidShape(6, 12, 12, 7, 13, 17),
            Block.createCuboidShape(6, 13, 1, 7, 14, 3),
            Block.createCuboidShape(6, 6, 0, 7, 7, 4),
            Block.createCuboidShape(6, 7, -1, 7, 8, 3),
            Block.createCuboidShape(6, 8, -1, 7, 9, 2),
            Block.createCuboidShape(6, 9, 0, 7, 10, 3),
            Block.createCuboidShape(6, 10, -4, 7, 11, 1),
            Block.createCuboidShape(6, 9, -4, 7, 10, -2),
            Block.createCuboidShape(6, 7, -3, 7, 9, -2),
            Block.createCuboidShape(6, 11, -3, 7, 12, 2),
            Block.createCuboidShape(6, 12, -1, 7, 13, 4)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();



    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;

            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

}
