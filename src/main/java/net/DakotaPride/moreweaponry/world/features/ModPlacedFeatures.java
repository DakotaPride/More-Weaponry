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

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> NITRIS_TREE_KEY = registerKey("nitris_spawn");
    public static final RegistryKey<PlacedFeature> NIGHT_CURON_KEY = registerKey("night_curon");
    public static final RegistryKey<PlacedFeature> LIMESTONE_KEY = registerKey("limestone");
    public static final RegistryKey<PlacedFeature> MARE_DIAMOND_ORE_KEY = registerKey("mare_diamond_ore");
    public static final RegistryKey<PlacedFeature> BLUESTONE_KEY = registerKey("bluestone");
    public static final RegistryKey<PlacedFeature> CIRTICT_DEBRIS_KEY = registerKey("cirtict_debris");
    public static final RegistryKey<PlacedFeature> CRACKED_DRIPSTONE_KEY = registerKey("cracked_dripstone");
    public static final RuleTest END_STONE_RULE = new BlockMatchRuleTest(Blocks.END_STONE);


    public static final PlacedFeature NITRIS_PLACED = registerPlacedFeature("nitris_spawn",
            ModConfiguredFeatures.NITRIS_TREE_RANDOM.withPlacement(VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 2))));

    public static final PlacedFeature NIGHT_CURON_PLACED = registerPlacedFeature("night_curon",
            ModConfiguredFeatures.NIGHT_CURON.withPlacement(RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                    PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final PlacedFeature MARE_DIAMOND_ORE_PLACED = registerPlacedFeature("mare_diamond_ore",
            ModConfiguredFeatures.MARE_DIAMOND_ORE.withPlacement(modifiersWithCount(8,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(100)))));

    public static final PlacedFeature CIRTICT_DEBRIS_PLACED = registerPlacedFeature("cirtict_debris",
            ModConfiguredFeatures.CIRTICT_DEBRIS.withPlacement(modifiersWithCount(3,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(300)))));

    public static final PlacedFeature LIMESTONE_PLACED = registerPlacedFeature("limestone",
            ModConfiguredFeatures.LIMESTONE.withPlacement(modifiersWithCount(11,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(200)))));

    public static final PlacedFeature BLUESTONE_PLACED = registerPlacedFeature("bluestone",
            ModConfiguredFeatures.BLUESTONE.withPlacement(modifiersWithCount(11,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(100)))));

    public static final PlacedFeature CRACKED_DRIPSTONE_PLACED = registerPlacedFeature("cracked_dripstone",
            ModConfiguredFeatures.CRACKED_DRIPSTONE.withPlacement(modifiersWithCount(11,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(200)))));

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