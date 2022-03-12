package net.DakotaPride.moreweaponry.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
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
    public WatcherSkullBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(4, 0, 5, 12, 8, 13),
            Block.createCuboidShape(26.368275304820337, -2.9131183203153945, 6.75, 30.368275304820337, 5.0868816796846055, 10.75),
            Block.createCuboidShape(10.592420163512372, 3.709138641865625, 6.75, 23.592420163512372, 7.709138641865625, 10.75),
            Block.createCuboidShape(18.928042103824062, -10.361759453932864, 6.775, 22.928042103824062, 1.638240546067136, 10.725),
            Block.createCuboidShape(-14.36827612231612, -2.9131186100359514, 6.75, -10.36827612231612, 5.086881389964049, 10.75),
            Block.createCuboidShape(-7.592420165663311, 3.7091386310521317, 6.75, 5.407579834336689, 7.709138631052132, 10.75),
            Block.createCuboidShape(-6.928042103824062, -10.361759453932864, 6.775, -2.928042103824062, 1.638240546067136, 10.725),
            Block.createCuboidShape(13, 13, 10, 15, 14, 11),
            Block.createCuboidShape(12, 6, 10, 16, 7, 11),
            Block.createCuboidShape(13, 7, 10, 17, 8, 11),
            Block.createCuboidShape(14, 8, 10, 17, 9, 11),
            Block.createCuboidShape(13, 9, 10, 16, 10, 11),
            Block.createCuboidShape(15, 10, 10, 20, 11, 11),
            Block.createCuboidShape(18, 9, 10, 20, 10, 11),
            Block.createCuboidShape(18, 7, 10, 19, 9, 11),
            Block.createCuboidShape(14, 11, 10, 19, 12, 11),
            Block.createCuboidShape(12, 12, 10, 17, 13, 11),
            Block.createCuboidShape(1, 13, 10, 3, 14, 11),
            Block.createCuboidShape(0, 6, 10, 4, 7, 11),
            Block.createCuboidShape(-1, 7, 10, 3, 8, 11),
            Block.createCuboidShape(-1, 8, 10, 2, 9, 11),
            Block.createCuboidShape(0, 9, 10, 3, 10, 11),
            Block.createCuboidShape(-4, 10, 10, 1, 11, 11),
            Block.createCuboidShape(-4, 9, 10, -2, 10, 11),
            Block.createCuboidShape(-3, 7, 10, -2, 9, 11),
            Block.createCuboidShape(-3, 11, 10, 2, 12, 11),
            Block.createCuboidShape(-1, 12, 10, 4, 13, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(4, 0, 5, 12, 8, 13),
            Block.createCuboidShape(26.368275304820337, -2.9131183203153945, 6.75, 30.368275304820337, 5.0868816796846055, 10.75),
            Block.createCuboidShape(10.592420163512372, 3.709138641865625, 6.75, 23.592420163512372, 7.709138641865625, 10.75),
            Block.createCuboidShape(18.928042103824062, -10.361759453932864, 6.775, 22.928042103824062, 1.638240546067136, 10.725),
            Block.createCuboidShape(-14.36827612231612, -2.9131186100359514, 6.75, -10.36827612231612, 5.086881389964049, 10.75),
            Block.createCuboidShape(-7.592420165663311, 3.7091386310521317, 6.75, 5.407579834336689, 7.709138631052132, 10.75),
            Block.createCuboidShape(-6.928042103824062, -10.361759453932864, 6.775, -2.928042103824062, 1.638240546067136, 10.725),
            Block.createCuboidShape(13, 13, 10, 15, 14, 11),
            Block.createCuboidShape(12, 6, 10, 16, 7, 11),
            Block.createCuboidShape(13, 7, 10, 17, 8, 11),
            Block.createCuboidShape(14, 8, 10, 17, 9, 11),
            Block.createCuboidShape(13, 9, 10, 16, 10, 11),
            Block.createCuboidShape(15, 10, 10, 20, 11, 11),
            Block.createCuboidShape(18, 9, 10, 20, 10, 11),
            Block.createCuboidShape(18, 7, 10, 19, 9, 11),
            Block.createCuboidShape(14, 11, 10, 19, 12, 11),
            Block.createCuboidShape(12, 12, 10, 17, 13, 11),
            Block.createCuboidShape(1, 13, 10, 3, 14, 11),
            Block.createCuboidShape(0, 6, 10, 4, 7, 11),
            Block.createCuboidShape(-1, 7, 10, 3, 8, 11),
            Block.createCuboidShape(-1, 8, 10, 2, 9, 11),
            Block.createCuboidShape(0, 9, 10, 3, 10, 11),
            Block.createCuboidShape(-4, 10, 10, 1, 11, 11),
            Block.createCuboidShape(-4, 9, 10, -2, 10, 11),
            Block.createCuboidShape(-3, 7, 10, -2, 9, 11),
            Block.createCuboidShape(-3, 11, 10, 2, 12, 11),
            Block.createCuboidShape(-1, 12, 10, 4, 13, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(4, 0, 5, 12, 8, 13),
            Block.createCuboidShape(26.368275304820337, -2.9131183203153945, 6.75, 30.368275304820337, 5.0868816796846055, 10.75),
            Block.createCuboidShape(10.592420163512372, 3.709138641865625, 6.75, 23.592420163512372, 7.709138641865625, 10.75),
            Block.createCuboidShape(18.928042103824062, -10.361759453932864, 6.775, 22.928042103824062, 1.638240546067136, 10.725),
            Block.createCuboidShape(-14.36827612231612, -2.9131186100359514, 6.75, -10.36827612231612, 5.086881389964049, 10.75),
            Block.createCuboidShape(-7.592420165663311, 3.7091386310521317, 6.75, 5.407579834336689, 7.709138631052132, 10.75),
            Block.createCuboidShape(-6.928042103824062, -10.361759453932864, 6.775, -2.928042103824062, 1.638240546067136, 10.725),
            Block.createCuboidShape(13, 13, 10, 15, 14, 11),
            Block.createCuboidShape(12, 6, 10, 16, 7, 11),
            Block.createCuboidShape(13, 7, 10, 17, 8, 11),
            Block.createCuboidShape(14, 8, 10, 17, 9, 11),
            Block.createCuboidShape(13, 9, 10, 16, 10, 11),
            Block.createCuboidShape(15, 10, 10, 20, 11, 11),
            Block.createCuboidShape(18, 9, 10, 20, 10, 11),
            Block.createCuboidShape(18, 7, 10, 19, 9, 11),
            Block.createCuboidShape(14, 11, 10, 19, 12, 11),
            Block.createCuboidShape(12, 12, 10, 17, 13, 11),
            Block.createCuboidShape(1, 13, 10, 3, 14, 11),
            Block.createCuboidShape(0, 6, 10, 4, 7, 11),
            Block.createCuboidShape(-1, 7, 10, 3, 8, 11),
            Block.createCuboidShape(-1, 8, 10, 2, 9, 11),
            Block.createCuboidShape(0, 9, 10, 3, 10, 11),
            Block.createCuboidShape(-4, 10, 10, 1, 11, 11),
            Block.createCuboidShape(-4, 9, 10, -2, 10, 11),
            Block.createCuboidShape(-3, 7, 10, -2, 9, 11),
            Block.createCuboidShape(-3, 11, 10, 2, 12, 11),
            Block.createCuboidShape(-1, 12, 10, 4, 13, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(4, 0, 5, 12, 8, 13),
            Block.createCuboidShape(26.368275304820337, -2.9131183203153945, 6.75, 30.368275304820337, 5.0868816796846055, 10.75),
            Block.createCuboidShape(10.592420163512372, 3.709138641865625, 6.75, 23.592420163512372, 7.709138641865625, 10.75),
            Block.createCuboidShape(18.928042103824062, -10.361759453932864, 6.775, 22.928042103824062, 1.638240546067136, 10.725),
            Block.createCuboidShape(-14.36827612231612, -2.9131186100359514, 6.75, -10.36827612231612, 5.086881389964049, 10.75),
            Block.createCuboidShape(-7.592420165663311, 3.7091386310521317, 6.75, 5.407579834336689, 7.709138631052132, 10.75),
            Block.createCuboidShape(-6.928042103824062, -10.361759453932864, 6.775, -2.928042103824062, 1.638240546067136, 10.725),
            Block.createCuboidShape(13, 13, 10, 15, 14, 11),
            Block.createCuboidShape(12, 6, 10, 16, 7, 11),
            Block.createCuboidShape(13, 7, 10, 17, 8, 11),
            Block.createCuboidShape(14, 8, 10, 17, 9, 11),
            Block.createCuboidShape(13, 9, 10, 16, 10, 11),
            Block.createCuboidShape(15, 10, 10, 20, 11, 11),
            Block.createCuboidShape(18, 9, 10, 20, 10, 11),
            Block.createCuboidShape(18, 7, 10, 19, 9, 11),
            Block.createCuboidShape(14, 11, 10, 19, 12, 11),
            Block.createCuboidShape(12, 12, 10, 17, 13, 11),
            Block.createCuboidShape(1, 13, 10, 3, 14, 11),
            Block.createCuboidShape(0, 6, 10, 4, 7, 11),
            Block.createCuboidShape(-1, 7, 10, 3, 8, 11),
            Block.createCuboidShape(-1, 8, 10, 2, 9, 11),
            Block.createCuboidShape(0, 9, 10, 3, 10, 11),
            Block.createCuboidShape(-4, 10, 10, 1, 11, 11),
            Block.createCuboidShape(-4, 9, 10, -2, 10, 11),
            Block.createCuboidShape(-3, 7, 10, -2, 9, 11),
            Block.createCuboidShape(-3, 11, 10, 2, 12, 11),
            Block.createCuboidShape(-1, 12, 10, 4, 13, 11)
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
