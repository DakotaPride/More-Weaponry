package net.DakotaPride.moreweaponry.common.world.gen;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.util.MoreWeaponryTags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.DakotaPride.moreweaponry.common.world.features.MoreWeaponryPlacedFeatures;

public class MoreWeaponryFlowerGeneration {
    public static void generateFlowers() {
        BiomeModifications.addFeature(BiomeSelectors.tag(MoreWeaponryTags.Biomes.NIGHT_CURON),
                GenerationStep.Feature.VEGETAL_DECORATION, MoreWeaponryPlacedFeatures.NIGHT_CURON_PLACED.getKey().get());
    }
}