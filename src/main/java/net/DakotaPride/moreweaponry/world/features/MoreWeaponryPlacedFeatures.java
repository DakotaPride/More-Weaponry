package net.DakotaPride.moreweaponry.world.features;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

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



    public static final PlacedFeature FRODON_PLACED = registerPlacedFeature("frodon_spawn",
            MoreWeaponryConfiguredFeatures.FRODON_TREE_RANDOM.withPlacement(VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 2))));

    public static final PlacedFeature NIGHT_CURON_PLACED = registerPlacedFeature("night_curon",
            MoreWeaponryConfiguredFeatures.NIGHT_CURON.withPlacement(RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                    PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final PlacedFeature MARE_DIAMOND_ORE_PLACED = registerPlacedFeature("mare_diamond_ore",
            MoreWeaponryConfiguredFeatures.MARE_DIAMOND_ORE.withPlacement(modifiersWithCount(8,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(100)))));

    public static final PlacedFeature CIRTICT_DEBRIS_PLACED = registerPlacedFeature("cirtict_debris",
            MoreWeaponryConfiguredFeatures.CIRTICT_DEBRIS.withPlacement(modifiersWithCount(3,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(300)))));

    public static final PlacedFeature SANDSTONE_DUST_PLACED = registerPlacedFeature("sandstone_dust",
            MoreWeaponryConfiguredFeatures.SANDSTONE_DUST.withPlacement(modifiersWithCount(6,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(300)))));

    public static final PlacedFeature LIMESTONE_PLACED = registerPlacedFeature("limestone",
            MoreWeaponryConfiguredFeatures.LIMESTONE.withPlacement(modifiersWithCount(11,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(200)))));

    public static final PlacedFeature BLUESTONE_PLACED = registerPlacedFeature("bluestone",
            MoreWeaponryConfiguredFeatures.BLUESTONE.withPlacement(modifiersWithCount(11,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(100)))));

    public static final PlacedFeature CRACKED_DRIPSTONE_PLACED = registerPlacedFeature("cracked_dripstone",
            MoreWeaponryConfiguredFeatures.CRACKED_DRIPSTONE.withPlacement(modifiersWithCount(3,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(300)))));

    public static final PlacedFeature INFESTED_CRACKED_DRIPSTONE_PLACED = registerPlacedFeature("infested_cracked_dripstone",
            MoreWeaponryConfiguredFeatures.INFESTED_CRACKED_DRIPSTONE.withPlacement(modifiersWithCount(3,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(300)))));

    public static final PlacedFeature INFESTED_DRIPSTONE_PLACED = registerPlacedFeature("infested_dripstone",
            MoreWeaponryConfiguredFeatures.INFESTED_DRIPSTONE.withPlacement(modifiersWithCount(3,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(300)))));

    public static final PlacedFeature INTOXICATED_GRASS_BONEMEAL = PlacedFeatures.register("intoxicated_grass_bonemeal",
            MoreWeaponryConfiguredFeatures.INTOXICATED_SINGLE_PIECE_OF_GRASS.withInAirFilter());


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