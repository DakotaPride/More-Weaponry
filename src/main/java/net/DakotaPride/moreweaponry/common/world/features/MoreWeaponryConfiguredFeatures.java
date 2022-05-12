package net.DakotaPride.moreweaponry.common.world.features;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;


public class MoreWeaponryConfiguredFeatures {

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> FRODON_TREE =
            ConfiguredFeatures.register("frodon", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(MoreWeaponry.FRODON_LOG),
                    new StraightTrunkPlacer(5, 2, 1),
                    BlockStateProvider.of(MoreWeaponry.FRODON_LEAVES),
                    new SpruceFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(3), ConstantIntProvider.create(1)),
                    new TwoLayersFeatureSize(2, 0, 2)).build());

    public static final RegistryEntry<PlacedFeature> FRODON_TREE_CHECKED = PlacedFeatures.register("frodon_tree_checked",
            FRODON_TREE, PlacedFeatures.wouldSurvive(MoreWeaponry.FRODON_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> FRODON_TREE_SPAWN =
            ConfiguredFeatures.register("frodon_tree_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(FRODON_TREE_CHECKED,
                            0.2F)), FRODON_TREE_CHECKED));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> NIGHT_CURON =
            ConfiguredFeatures.register("night_curon", Feature.FLOWER,
                    new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(MoreWeaponry.NIGHT_CURON)))));

    public static final List<OreFeatureConfig.Target> OVERWORLD_MARE_DIAMOND_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MoreWeaponry.MARE_DIAMOND_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MoreWeaponry.DEEPSLATE_MARE_DIAMOND_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> MARE_DIAMOND_ORE = ConfiguredFeatures.register("mare_diamond_ore",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_MARE_DIAMOND_ORES, 10));

    public static final List<OreFeatureConfig.Target> END_CIRTICT_DEBRIS = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MoreWeaponry.CIRTICT_DEBRIS.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CIRTICT_DEBRIS = ConfiguredFeatures.register("cirtict_debris",
            Feature.ORE, new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE),
                    MoreWeaponry.CIRTICT_DEBRIS.getDefaultState(),
                    4));

    public static final List<OreFeatureConfig.Target> OVERWORLD_SANDSTONE_DUST = List.of(
            OreFeatureConfig.createTarget(MoreWeaponryOreConfiguredFeatures.SAND_REPLACEABLE_OVERWORLD, MoreWeaponry.SANDSTONE_DUST_BLOCK.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SANDSTONE_DUST = ConfiguredFeatures.register("sandstone_dust",
            Feature.ORE, new OreFeatureConfig(new BlockMatchRuleTest(Blocks.SAND),
                    MoreWeaponry.SANDSTONE_DUST_BLOCK.getDefaultState(),
                    46));

    public static final List<OreFeatureConfig.Target> OVERWORLD_LIMESTONE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MoreWeaponry.LIMESTONE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> LIMESTONE = ConfiguredFeatures.register("limestone",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_LIMESTONE, 34));

    public static final List<OreFeatureConfig.Target> OVERWORLD_BLUESTONE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, MoreWeaponry.BLUESTONE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> BLUESTONE = ConfiguredFeatures.register("bluestone",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_BLUESTONE, 34));

    public static final List<OreFeatureConfig.Target> OVERWORLD_CRACKED_DRIPSTONE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MoreWeaponry.CRACKED_DRIPSTONE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CRACKED_DRIPSTONE = ConfiguredFeatures.register("cracked_dripstone",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_CRACKED_DRIPSTONE, 21));

    public static final List<OreFeatureConfig.Target> OVERWORLD_INFESTED_CRACKED_DRIPSTONE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MoreWeaponry.INFESTED_CRACKED_DRIPSTONE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> INFESTED_CRACKED_DRIPSTONE = ConfiguredFeatures.register("infested_cracked_dripstone",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_INFESTED_CRACKED_DRIPSTONE, 11));

    public static final List<OreFeatureConfig.Target> OVERWORLD_INFESTED_DRIPSTONE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, MoreWeaponry.INFESTED_DRIPSTONE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> INFESTED_DRIPSTONE = ConfiguredFeatures.register("infested_dripstone",
            Feature.ORE, new OreFeatureConfig(OVERWORLD_INFESTED_DRIPSTONE, 11));

    public static final RegistryEntry<ConfiguredFeature<SimpleBlockFeatureConfig, ?>>
            SINGLE_PIECE_OF_INTOXICATED_GRASS = ConfiguredFeatures.register("single_piece_of_intoxicated_grass", Feature.SIMPLE_BLOCK, new
    SimpleBlockFeatureConfig(BlockStateProvider.of(MoreWeaponry.INTOXICATED_GRASS.getDefaultState())));

    public static final RegistryEntry<ConfiguredFeature<SimpleBlockFeatureConfig, ?>>
            SINGLE_PIECE_OF_INTOXICATED_POPPY = ConfiguredFeatures.register("single_piece_of_intoxicated_poppy", Feature.SIMPLE_BLOCK, new
            SimpleBlockFeatureConfig(BlockStateProvider.of(MoreWeaponry.INTOXICATED_POPPY.getDefaultState())));

    public static final RegistryEntry<ConfiguredFeature<SimpleBlockFeatureConfig, ?>>
            SINGLE_PIECE_OF_INTOXICATED_DANDELION = ConfiguredFeatures.register("single_piece_of_intoxicated_dandelion", Feature.SIMPLE_BLOCK, new
            SimpleBlockFeatureConfig(BlockStateProvider.of(MoreWeaponry.INTOXICATED_DANDELION.getDefaultState())));

    public static final RegistryEntry<ConfiguredFeature<SimpleBlockFeatureConfig, ?>>
            SINGLE_PIECE_OF_INTOXICATED_FERN = ConfiguredFeatures.register("single_piece_of_intoxicated_fern", Feature.SIMPLE_BLOCK, new
            SimpleBlockFeatureConfig(BlockStateProvider.of(MoreWeaponry.INTOXICATED_FERN.getDefaultState())));



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
