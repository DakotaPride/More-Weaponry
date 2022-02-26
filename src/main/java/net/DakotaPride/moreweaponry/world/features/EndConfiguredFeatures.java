package net.DakotaPride.moreweaponry.world.features;

import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.DakotaPride.moreweaponry.tag.ModBlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.decorator.PlacementModifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class EndConfiguredFeatures {

    public static final ConfiguredFeature<SimpleBlockFeatureConfig, ?> PEPLEX_VEGETATION =
            ConfiguredFeatures.register("peplex_vegetation", Feature.SIMPLE_BLOCK.configure
                    (new SimpleBlockFeatureConfig(new WeightedBlockStateProvider
                            (DataPool.builder().add(ModBlocks.PEPLEX_NYLIUM.getDefaultState(), 4)))));
    
    public static final ConfiguredFeature<VegetationPatchFeatureConfig, ?> PEPLEX_PATCH =
            ConfiguredFeatures.register("peplex_patch", Feature.VEGETATION_PATCH.configure
                    (new VegetationPatchFeatureConfig(ModBlockTags.PEPLEX_REPLACEABLE.getId(), BlockStateProvider.of
                            (ModBlocks.PEPLEX_NYLIUM), () -> PEPLEX_VEGETATION.withPlacement(new PlacementModifier[0]),
                            VerticalSurfaceType.FLOOR, ConstantIntProvider.create(1),
                            0.0f, 5, 0.8f, UniformIntProvider.create(4, 7),
                            0.3f)));

    public static final ConfiguredFeature<VegetationPatchFeatureConfig, ?> PEPLEX_PATCH_BONEMEAL =
            ConfiguredFeatures.register("peplex_patch_bonemeal", Feature.VEGETATION_PATCH.configure
                    (new VegetationPatchFeatureConfig(ModBlockTags.PEPLEX_REPLACEABLE.getId(), BlockStateProvider.of
                            (ModBlocks.PEPLEX_NYLIUM), () -> PEPLEX_VEGETATION.withPlacement(new PlacementModifier[0]),
                            VerticalSurfaceType.FLOOR, ConstantIntProvider.create(1),
                            0.0f, 5, 0.6f, UniformIntProvider.create(1, 2),
                            0.75f)));


}
