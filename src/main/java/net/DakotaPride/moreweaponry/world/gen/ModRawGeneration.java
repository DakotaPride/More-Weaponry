package net.DakotaPride.moreweaponry.world.gen;

import net.DakotaPride.moreweaponry.world.features.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;

public class ModRawGeneration {
    public static void generateRawGeneration() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.RAW_GENERATION, ModPlacedFeatures.LIMESTONE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.RAW_GENERATION, ModPlacedFeatures.BLUESTONE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.RAW_GENERATION, ModPlacedFeatures.CIRTICT_DEBRIS_KEY);

        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.valueOf("UNDERGROUND")),
                GenerationStep.Feature.RAW_GENERATION, ModPlacedFeatures.CRACKED_DRIPSTONE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.valueOf("UNDERGROUND")),
                GenerationStep.Feature.RAW_GENERATION, ModPlacedFeatures.INFESTED_CRACKED_DRIPSTONE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.valueOf("UNDERGROUND")),
                GenerationStep.Feature.RAW_GENERATION, ModPlacedFeatures.INFESTED_DRIPSTONE_KEY);
    }
}
