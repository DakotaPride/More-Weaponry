package net.DakotaPride.moreweaponry.block.custom;

import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.NyliumBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.EndConfiguredFeatures;
import net.minecraft.world.gen.feature.NetherConfiguredFeatures;

import java.util.Random;

public class EndNyliumBlock extends NyliumBlock {
    public EndNyliumBlock(Settings settings) {
        super(settings);
    }

    private static boolean stayAlive(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(blockPos);
        int i = ChunkLightProvider.getRealisticOpacity(world, state, pos, blockState, blockPos, Direction.UP, blockState.getOpacity(world, blockPos));
        return i < world.getMaxLightLevel();
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!EndNyliumBlock.stayAlive(state, world, pos)) {
            world.setBlockState(pos, Blocks.END_STONE.getDefaultState());
        }
    }


}
