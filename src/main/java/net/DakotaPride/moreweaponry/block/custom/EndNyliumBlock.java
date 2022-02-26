package net.DakotaPride.moreweaponry.block.custom;

import net.DakotaPride.moreweaponry.world.features.EndConfiguredFeatures;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import net.minecraft.world.gen.feature.UndergroundConfiguredFeatures;

import java.util.Random;

public class EndNyliumBlock extends MossBlock {
    public EndNyliumBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return world.getBlockState(pos.up()).isAir();
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        EndConfiguredFeatures.PEPLEX_PATCH_BONEMEAL.generate(world,
                world.getChunkManager().getChunkGenerator(), random, pos.up());
    }

}
