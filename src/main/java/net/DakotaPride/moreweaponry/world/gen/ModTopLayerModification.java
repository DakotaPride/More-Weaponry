package net.DakotaPride.moreweaponry.world.gen;

import net.DakotaPride.moreweaponry.world.features.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;

public class ModTopLayerModification {
    public static void generateTopLayerModifications() {
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.valueOf("DESERT")),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.SANDSTONE_DUST_KEY);
    }
}
