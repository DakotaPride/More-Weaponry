package net.DakotaPride.moreweaponry.world.features;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationConfiguredFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class MoreWeaponryPlacedFeatures {
    public static final RegistryKey<PlacedFeature> FRODON_TREE_KEY = registerKey("frodon_spawn");
    public static final RegistryKey<PlacedFeature> NIGHT_CURON_KEY = registerKey("night_curon");
    public static final RegistryKey<PlacedFeature> LIMESTONE_KEY = registerKey("limestone");
    public static final RegistryKey<PlacedFeature> MARE_DIAMOND_ORE_KEY = registerKey("mare_diamond_ore");
    public static final RegistryKey<PlacedFeature> BLUESTONE_KEY = registerKey("bluestone");
    public static final RegistryKey<PlacedFeature> CIRTICT_DEBRIS_KEY = registerKey("cirtict_debris");
    public static final RegistryKey<PlacedFeature> CRACKED_DRIPSTONE_KEY = registerKey("cracked_dripstone");
    public static final RegistryKey<PlacedFeature> SANDSTONE_DUST_KEY = registerKey("sandstone_dust");
    public static final RegistryKey<PlacedFeature> INFESTED_DRIPSTONE_KEY = registerKey("infested_dripstone");
    public static final RegistryKey<PlacedFeature> INFESTED_CRACKED_DRIPSTONE_KEY = registerKey("infested_cracked_dripstone");
    public static final RuleTest END_STONE_RULE = new BlockMatchRuleTest(Blocks.END_STONE);
    public static final RuleTest SAND_RULE = new BlockMatchRuleTest(Blocks.SAND);



    public static final RegistryEntry<PlacedFeature> FRODON_TREE_PLACED = PlacedFeatures.register("frodon_spawn",
            MoreWeaponryConfiguredFeatures.FRODON_TREE_SPAWN, VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));

    public static final RegistryEntry<PlacedFeature> NIGHT_CURON_PLACED = PlacedFeatures.register("night_curon",
            MoreWeaponryConfiguredFeatures.NIGHT_CURON, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> MARE_DIAMOND_ORE_PLACED = PlacedFeatures.register("mare_diamond_ore",
            MoreWeaponryConfiguredFeatures.MARE_DIAMOND_ORE, MoreWeaponryOreFeatures.modifiersWithCount(8,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(100))));

    public static final RegistryEntry<PlacedFeature> CIRTICT_DEBRIS_PLACED = PlacedFeatures.register("cirtict_debris",
            MoreWeaponryConfiguredFeatures.CIRTICT_DEBRIS, MoreWeaponryOreFeatures.modifiersWithCount(3,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(100))));

    public static final RegistryEntry<PlacedFeature> SANDSTONE_DUST_PLACED = PlacedFeatures.register("sandstone_dust",
            MoreWeaponryConfiguredFeatures.SANDSTONE_DUST, MoreWeaponryOreFeatures.modifiersWithCount(6,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(300))));

    public static final RegistryEntry<PlacedFeature> LIMESTONE_PLACED = PlacedFeatures.register("limestone",
            MoreWeaponryConfiguredFeatures.LIMESTONE, MoreWeaponryOreFeatures.modifiersWithCount(11,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(200))));

    public static final RegistryEntry<PlacedFeature> BLUESTONE_PLACED = PlacedFeatures.register("bluestone",
            MoreWeaponryConfiguredFeatures.BLUESTONE, MoreWeaponryOreFeatures.modifiersWithCount(11,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(100))));

    public static final RegistryEntry<PlacedFeature> CRACKED_DRIPSTONE_PLACED = PlacedFeatures.register("cracked_dripstone",
            MoreWeaponryConfiguredFeatures.CRACKED_DRIPSTONE, MoreWeaponryOreFeatures.modifiersWithCount(3,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(300))));

    public static final RegistryEntry<PlacedFeature> INFESTED_CRACKED_DRIPSTONE_PLACED = PlacedFeatures.register("infested_cracked_dripstone",
            MoreWeaponryConfiguredFeatures.INFESTED_CRACKED_DRIPSTONE, MoreWeaponryOreFeatures.modifiersWithCount(3,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(300))));

    public static final RegistryEntry<PlacedFeature> INFESTED_DRIPSTONE_PLACED = PlacedFeatures.register("infested_dripstone",
            MoreWeaponryConfiguredFeatures.INFESTED_DRIPSTONE, MoreWeaponryOreFeatures.modifiersWithCount(3,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(300))));

    public static final RegistryEntry<PlacedFeature> INTOXICATED_GRASS_BONEMEAL = PlacedFeatures.register("intoxicated_grass_bonemeal",
            MoreWeaponryConfiguredFeatures.SINGLE_PIECE_OF_INTOXICATED_GRASS,
            PlacedFeatures.isAir());

    public static final RegistryEntry<PlacedFeature> INTOXICATED_POPPY_BONEMEAL = PlacedFeatures.register("intoxicated_poppy_bonemeal",
            MoreWeaponryConfiguredFeatures.SINGLE_PIECE_OF_INTOXICATED_POPPY,
            PlacedFeatures.isAir());

    public static final RegistryEntry<PlacedFeature> INTOXICATED_DANDELION_BONEMEAL = PlacedFeatures.register("intoxicated_dandelion_bonemeal",
            MoreWeaponryConfiguredFeatures.SINGLE_PIECE_OF_INTOXICATED_DANDELION,
            PlacedFeatures.isAir());

    public static final RegistryEntry<PlacedFeature> INTOXICATED_FERN_BONEMEAL = PlacedFeatures.register("intoxicated_fern_bonemeal",
            MoreWeaponryConfiguredFeatures.SINGLE_PIECE_OF_INTOXICATED_FERN,
            PlacedFeatures.isAir());


    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MoreWeaponry.MOD_ID, name), placedFeature);
    }

    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(MoreWeaponry.MOD_ID, name));
    }
}