package net.DakotaPride.moreweaponry.common.block.custom;

import net.DakotaPride.moreweaponry.common.world.features.EndConfiguredFeatures;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;

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
        ((ConfiguredFeature)EndConfiguredFeatures.PEPLEX_PATCH_BONEMEAL.value())
                .generate(world, world.getChunkManager().getChunkGenerator(), random, pos.up());
    }

}
