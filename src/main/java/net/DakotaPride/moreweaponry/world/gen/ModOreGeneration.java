package net.DakotaPride.moreweaponry.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.DakotaPride.moreweaponry.world.features.ModConfiguredFeatures;
import net.DakotaPride.moreweaponry.world.features.ModPlacedFeatures;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.MARE_DIAMOND_ORE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.RAW_GENERATION, ModPlacedFeatures.LIMESTONE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.RAW_GENERATION, ModPlacedFeatures.BLUESTONE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.RAW_GENERATION, ModPlacedFeatures.CIRTICT_DEBRIS_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.RAW_GENERATION, ModPlacedFeatures.CRACKED_DRIPSTONE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.RAW_GENERATION, ModPlacedFeatures.INFESTED_CRACKED_DRIPSTONE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.RAW_GENERATION, ModPlacedFeatures.INFESTED_DRIPSTONE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.SANDSTONE_DUST_KEY);

    }
}
