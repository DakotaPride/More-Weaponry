package net.DakotaPride.moreweaponry.block.custom;

import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.DakotaPride.moreweaponry.world.features.MoreWeaponryPlacedFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.GrassBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;
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

        BlockState blockState = MoreWeaponryBlocks.INTOXICATED_GRASS.getDefaultState();

        int i;
        label31: for (i = 0; i < 128; i++) {
            RegistryEntry<PlacedFeature> registryEntry; BlockPos blockPos2 = blockPos;
            for (int k = 0; k < i / 16; ) {
                blockPos2 = blockPos2.add(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
                if (world.getBlockState(blockPos2.down()).isOf(this)) { if (world.getBlockState(blockPos2).isFullCube(world, blockPos2))
                    continue label31;
                    k++; }

                continue label31;
            }
            BlockState j = world.getBlockState(blockPos2);
            if (j.isOf(blockState.getBlock()) && random.nextInt(10) == 0) {
                ((Fertilizable)blockState.getBlock()).grow(world, random, blockPos2, j);
            }

            if (!j.isAir()) {
                continue;
            }


            if (random.nextInt(8) == 0) {
                List<ConfiguredFeature<?, ?>> list = ((Biome)world.getBiome(blockPos2).value()).getGenerationSettings().getFlowerFeatures();
                if (list.isEmpty()) {
                    continue;
                }

                registryEntry = ((RandomPatchFeatureConfig)((ConfiguredFeature)list.get(0)).config()).feature();
            } else {
                registryEntry = MoreWeaponryPlacedFeatures.INTOXICATED_GRASS_BONEMEAL;
            }

            ((PlacedFeature)registryEntry.value()).generateUnregistered(world, world.getChunkManager().getChunkGenerator(), random, blockPos2);
            continue;
        }
    }

}
