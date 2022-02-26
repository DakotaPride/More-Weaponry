package net.DakotaPride.moreweaponry.block.custom;

import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.DakotaPride.moreweaponry.world.features.ModPlacedFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.GrassBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

import java.util.List;
import java.util.Random;

public class IntoxicatedGrassBlock extends GrassBlock {
    public IntoxicatedGrassBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockPos blockPos = pos.up();
        BlockState blockState = ModBlocks.INTOXICATED_GRASS.getDefaultState();
        block0: for (int i = 0; i < 128; ++i) {
            PlacedFeature placedFeature;
            BlockPos blockPos2 = blockPos;
            for (int j = 0; j < i / 16; ++j) {
                if (!world.getBlockState((blockPos2 = blockPos2.add(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1)).down()).isOf(this) || world.getBlockState(blockPos2).isFullCube(world, blockPos2)) continue block0;
            }
            BlockState j = world.getBlockState(blockPos2);
            if (j.isOf(blockState.getBlock()) && random.nextInt(10) == 0) {
                ((Fertilizable)((Object)blockState.getBlock())).grow(world, random, blockPos2, j);
            }
            if (!j.isAir()) continue;
            if (random.nextInt(8) == 0) {
                List<ConfiguredFeature<?, ?>> list = world.getBiome(blockPos2).getGenerationSettings().getFlowerFeatures();
                if (list.isEmpty()) continue;
                placedFeature = ((RandomPatchFeatureConfig)list.get(0).getConfig()).feature().get();
            } else {
                placedFeature = ModPlacedFeatures.INTOXICATED_GRASS_BONEMEAL;
            }
            placedFeature.generateUnregistered(world, world.getChunkManager().getChunkGenerator(), random, blockPos2);
        }
    }

}
