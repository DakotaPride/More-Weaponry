package net.DakotaPride.moreweaponry.common.block.custom;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.world.features.MoreWeaponryPlacedFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.GrassBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import org.apache.logging.log4j.core.jmx.Server;

import java.util.List;
import java.util.Random;

public class IntoxicatedGrassBlock extends GrassBlock {
    public IntoxicatedGrassBlock(Settings settings) {
        super(settings);
    }

    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return world.getBlockState(pos.up()).isAir();
    }

    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld world, net.minecraft.util.math.random.Random random, BlockPos pos, BlockState state) {
        BlockPos blockPos = pos.up();
        BlockState blockState = MoreWeaponry.INTOXICATED_GRASS.getDefaultState();
        BlockState blockState1 = MoreWeaponry.INTOXICATED_DANDELION.getDefaultState();
        BlockState blockState2 = MoreWeaponry.INTOXICATED_DANDELION.getDefaultState();

        label46:
        for(int i = 0; i < 128; ++i) {
            BlockPos blockPos2 = blockPos;

            for(int j = 0; j < i / 16; ++j) {
                blockPos2 = blockPos2.add(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
                if (!world.getBlockState(blockPos2.down()).isOf(this) || world.getBlockState(blockPos2).isFullCube(world, blockPos2)) {
                    continue label46;
                }
            }

            BlockState j = world.getBlockState(blockPos2);
            if (j.isOf(blockState.getBlock()) && random.nextInt(10) == 0) {
                ((Fertilizable)blockState.getBlock()).grow(world, random, blockPos2, j);
            } if (j.isOf(blockState1.getBlock()) && random.nextInt(10) == 0) {
                ((Fertilizable)blockState1.getBlock()).grow(world, random, blockPos2, j);
            } if (j.isOf(blockState2.getBlock()) && random.nextInt(10) == 0) {
                ((Fertilizable)blockState2.getBlock()).grow(world, random, blockPos2, j);
            }

            if (j.isAir()) {
                RegistryEntry registryEntry;
                if (random.nextInt(8) == 0) {
                    List<ConfiguredFeature<?, ?>> list = world.getBiome(blockPos2).value().getGenerationSettings().getFlowerFeatures();
                    if (list.isEmpty()) {
                        continue;
                    }

                    registryEntry = ((RandomPatchFeatureConfig)((ConfiguredFeature)list.get(0)).config()).feature();
                } else {
                    registryEntry = MoreWeaponryPlacedFeatures.INTOXICATED_GRASS_BONEMEAL;
                }

                ((PlacedFeature)registryEntry.value()).generateUnregistered(world, world.getChunkManager().getChunkGenerator(), random, blockPos2);
            }
            {
                RegistryEntry registryEntry;
                if (random.nextInt(8) == 0) {
                    List<ConfiguredFeature<?, ?>> list = world.getBiome(blockPos2).value().getGenerationSettings().getFlowerFeatures();
                    if (list.isEmpty()) {
                        continue;
                    }

                    registryEntry = ((RandomPatchFeatureConfig) ((ConfiguredFeature) list.get(0)).config()).feature();
                } else {
                    registryEntry = MoreWeaponryPlacedFeatures.INTOXICATED_POPPY_BONEMEAL;
                }

                ((PlacedFeature) registryEntry.value()).generateUnregistered(world, world.getChunkManager().getChunkGenerator(), random, blockPos2);
            }
            {
                RegistryEntry registryEntry;
                if (random.nextInt(8) == 0) {
                    List<ConfiguredFeature<?, ?>> list = world.getBiome(blockPos2).value().getGenerationSettings().getFlowerFeatures();
                    if (list.isEmpty()) {
                        continue;
                    }

                    registryEntry = ((RandomPatchFeatureConfig)((ConfiguredFeature)list.get(0)).config()).feature();
                } else {
                    registryEntry = MoreWeaponryPlacedFeatures.INTOXICATED_DANDELION_BONEMEAL;
                }

                ((PlacedFeature)registryEntry.value()).generateUnregistered(world, world.getChunkManager().getChunkGenerator(), random, blockPos2);

            }
            {
                RegistryEntry registryEntry;
                if (random.nextInt(8) == 0) {
                    List<ConfiguredFeature<?, ?>> list = world.getBiome(blockPos2).value().getGenerationSettings().getFlowerFeatures();
                    if (list.isEmpty()) {
                        continue;
                    }

                    registryEntry = ((RandomPatchFeatureConfig)((ConfiguredFeature)list.get(0)).config()).feature();
                } else {
                    registryEntry = MoreWeaponryPlacedFeatures.INTOXICATED_FERN_BONEMEAL;
                }

                ((PlacedFeature)registryEntry.value()).generateUnregistered(world, world.getChunkManager().getChunkGenerator(), random, blockPos2);

            }
        }

    }

}
