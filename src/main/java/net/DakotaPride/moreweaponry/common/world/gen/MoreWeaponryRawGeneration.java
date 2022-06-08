package net.DakotaPride.moreweaponry.common.world.gen;

import net.DakotaPride.moreweaponry.common.world.features.MoreWeaponryPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;

public class MoreWeaponryRawGeneration {
    public static void generateRawGeneration() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.RAW_GENERATION, MoreWeaponryPlacedFeatures.LIMESTONE_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.RAW_GENERATION, MoreWeaponryPlacedFeatures.BLUESTONE_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.RAW_GENERATION, MoreWeaponryPlacedFeatures.CIRTICT_DEBRIS_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.RAW_GENERATION, MoreWeaponryPlacedFeatures.CRACKED_DRIPSTONE_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.RAW_GENERATION, MoreWeaponryPlacedFeatures.INFESTED_CRACKED_DRIPSTONE_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.RAW_GENERATION, MoreWeaponryPlacedFeatures.INFESTED_DRIPSTONE_PLACED.getKey().get());
    }
}
