package net.DakotaPride.moreweaponry.world.features;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.feature.*;


import java.util.List;



public class ModConfiguredFeatures {

    public static final ConfiguredFeature<TreeFeatureConfig, ?> NITRIS_TREE = register("nitris",
            Feature.TREE.configure(new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.NITRIS_LOG),
                    new StraightTrunkPlacer(5, 2, 4),
                    BlockStateProvider.of(ModBlocks.NITRIS_LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)).build()));

    public static final ConfiguredFeature<RandomFeatureConfig, ?> NITRIS_TREE_RANDOM = register("nitris_feature",
            Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(List.of(new RandomFeatureEntry(
                    NITRIS_TREE.withWouldSurviveFilter(ModBlocks.NITRIS_SAPLING), 0.1f)),
                    NITRIS_TREE.withWouldSurviveFilter(ModBlocks.NITRIS_SAPLING))));;

    public static final ConfiguredFeature<RandomPatchFeatureConfig, ?> NIGHT_CURON =
            ModConfiguredFeatures.register("night_curon_feature", Feature.FLOWER.configure(
                    createRandomPatchFeatureConfig(BlockStateProvider.of(ModBlocks.NIGHT_CURON), 64)));

    public static final List<OreFeatureConfig.Target> OVERWORLD_MARE_DIAMOND_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.MARE_DIAMOND_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_MARE_DIAMOND_ORE.getDefaultState()));

    public static final ConfiguredFeature<?, ?> MARE_DIAMOND_ORE = register("mare_diamond_ore",
            Feature.ORE.configure(new OreFeatureConfig(OVERWORLD_MARE_DIAMOND_ORES, 10)));

    public static final List<OreFeatureConfig.Target> END_CIRTICT_DEBRIS = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.CIRTICT_DEBRIS.getDefaultState()));

    public static final ConfiguredFeature<?, ?> CIRTICT_DEBRIS = register("cirtict_debris",
            Feature.ORE.configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE),
                    ModBlocks.CIRTICT_DEBRIS.getDefaultState(),
                    4)));

    public static final List<OreFeatureConfig.Target> OVERWORLD_LIMESTONE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.LIMESTONE.getDefaultState()));

    public static final ConfiguredFeature<?, ?> LIMESTONE = register("limestone",
            Feature.ORE.configure(new OreFeatureConfig(OVERWORLD_LIMESTONE, 34)));

    public static final List<OreFeatureConfig.Target> OVERWORLD_BLUESTONE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.BLUESTONE.getDefaultState()));

    public static final ConfiguredFeature<?, ?> BLUESTONE = register("bluestone",
            Feature.ORE.configure(new OreFeatureConfig(OVERWORLD_BLUESTONE, 34)));


    private static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(MoreWeaponry.MOD_ID, name));
    }

    private static ConfiguredFeature<?, ?> register(ConfiguredFeature<?, ?> configuredFeature,
            RegistryKey<ConfiguredFeature<?, ?>> key) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key.getValue(), configuredFeature);
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + MoreWeaponry.MOD_ID);
    }
    public static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MoreWeaponry.MOD_ID, name),
                configuredFeature);
    }

    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(BlockStateProvider block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries,
                Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(block)).withInAirFilter());
    }

}
