package net.DakotaPride.moreweaponry.world.features;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;


public class MoreWeaponryConfiguredFeatures {

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> FRODON_TREE =
            ConfiguredFeatures.register("frodon", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(MoreWeaponryBlocks.FRODON_LOG),
                    new StraightTrunkPlacer(5, 2, 1),
                    BlockStateProvider.of(MoreWeaponryBlocks.FRODON_LEAVES),
                    new SpruceFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(3), ConstantIntProvider.create(1)),
                    new TwoLayersFeatureSize(2, 0, 2)).build());

    public static final RegistryEntry<PlacedFeature> FRODON_TREE_CHECKED = PlacedFeatures.register("frodon_tree_checked",
            FRODON_TREE, PlacedFeatures.wouldSurvive(MoreWeaponryBlocks.FRODON_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> FRODON_TREE_SPAWN =
            ConfiguredFeatures.register("frodon_tree_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(FRODON_TREE_CHECKED,
                            0.2F)), FRODON_TREE_CHECKED));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> NIGHT_CURON =
            ConfiguredFeatures.register("night_curon", Feature.FLOWER,
                    new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(MoreWeaponryBlocks.NIGHT_CURON)))));

    public static final List<OreFeatureConfig.Target> OVERWORLD_MARE_DIAMOND_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MoreWeaponryBlocks.MARE_DIAMOND_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MoreWeaponryBlocks.DEEPSLATE_MARE_DIAMOND_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> MARE_DIAMOND_ORE = ConfiguredFeatures.register("mare_diamond_ore",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_MARE_DIAMOND_ORES, 10));

    public static final List<OreFeatureConfig.Target> END_CIRTICT_DEBRIS = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MoreWeaponryBlocks.CIRTICT_DEBRIS.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CIRTICT_DEBRIS = ConfiguredFeatures.register("cirtict_debris",
            Feature.ORE, new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE),
                    MoreWeaponryBlocks.CIRTICT_DEBRIS.getDefaultState(),
                    4));

    public static final List<OreFeatureConfig.Target> OVERWORLD_SANDSTONE_DUST = List.of(
            OreFeatureConfig.createTarget(MoreWeaponryOreConfiguredFeatures.SAND_REPLACEABLE_OVERWORLD, MoreWeaponryBlocks.SANDSTONE_DUST_BLOCK.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SANDSTONE_DUST = ConfiguredFeatures.register("sandstone_dust",
            Feature.ORE, new OreFeatureConfig(new BlockMatchRuleTest(Blocks.SAND),
                    MoreWeaponryBlocks.SANDSTONE_DUST_BLOCK.getDefaultState(),
                    46));

    public static final List<OreFeatureConfig.Target> OVERWORLD_LIMESTONE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MoreWeaponryBlocks.LIMESTONE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> LIMESTONE = ConfiguredFeatures.register("limestone",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_LIMESTONE, 34));

    public static final List<OreFeatureConfig.Target> OVERWORLD_BLUESTONE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MoreWeaponryBlocks.BLUESTONE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> BLUESTONE = ConfiguredFeatures.register("bluestone",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_BLUESTONE, 34));

    public static final List<OreFeatureConfig.Target> OVERWORLD_CRACKED_DRIPSTONE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MoreWeaponryBlocks.CRACKED_DRIPSTONE_BLOCK.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CRACKED_DRIPSTONE = ConfiguredFeatures.register("cracked_dripstone",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_CRACKED_DRIPSTONE, 21));

    public static final List<OreFeatureConfig.Target> OVERWORLD_INFESTED_CRACKED_DRIPSTONE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MoreWeaponryBlocks.INFESTED_CRACKED_DRIPSTONE_BLOCK.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> INFESTED_CRACKED_DRIPSTONE = ConfiguredFeatures.register("infested_cracked_dripstone",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_INFESTED_CRACKED_DRIPSTONE, 11));

    public static final List<OreFeatureConfig.Target> OVERWORLD_INFESTED_DRIPSTONE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MoreWeaponryBlocks.INFESTED_DRIPSTONE_BLOCK.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> INFESTED_DRIPSTONE = ConfiguredFeatures.register("infested_dripstone",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_INFESTED_DRIPSTONE, 11));

    public static final RegistryEntry<ConfiguredFeature<SimpleBlockFeatureConfig, ?>> INTOXICATED_SINGLE_PIECE_OF_GRASS =
            ConfiguredFeatures.register("intoxicated_single_piece_of_grass",
                    Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig
                    (BlockStateProvider.of(MoreWeaponryBlocks.INTOXICATED_GRASS.getDefaultState())));



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

}
