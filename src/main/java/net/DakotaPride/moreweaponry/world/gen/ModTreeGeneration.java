package net.DakotaPride.moreweaponry.world.gen;

import net.DakotaPride.moreweaponry.world.features.ModConfiguredFeatures;
import net.DakotaPride.moreweaponry.world.features.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;

    public class ModTreeGeneration {
        public static void generateTrees() {
            BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.valueOf("THEEND")),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FRODON_TREE_KEY);
        }

}
