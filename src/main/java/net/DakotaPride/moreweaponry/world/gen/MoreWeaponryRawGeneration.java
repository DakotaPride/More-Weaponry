package net.DakotaPride.moreweaponry.world.gen;

import net.DakotaPride.moreweaponry.world.features.MoreWeaponryPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;

public class MoreWeaponryRawGeneration {
    public static void generateRawGeneration() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.RAW_GENERATION, MoreWeaponryPlacedFeatures.LIMESTONE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.RAW_GENERATION, MoreWeaponryPlacedFeatures.BLUESTONE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.RAW_GENERATION, MoreWeaponryPlacedFeatures.CIRTICT_DEBRIS_KEY);

        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.valueOf("UNDERGROUND")),
                GenerationStep.Feature.RAW_GENERATION, MoreWeaponryPlacedFeatures.CRACKED_DRIPSTONE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.valueOf("UNDERGROUND")),
                GenerationStep.Feature.RAW_GENERATION, MoreWeaponryPlacedFeatures.INFESTED_CRACKED_DRIPSTONE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.valueOf("UNDERGROUND")),
                GenerationStep.Feature.RAW_GENERATION, MoreWeaponryPlacedFeatures.INFESTED_DRIPSTONE_KEY);
    }
}
