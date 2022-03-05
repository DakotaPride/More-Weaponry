package net.DakotaPride.moreweaponry.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.DakotaPride.moreweaponry.world.features.MoreWeaponryPlacedFeatures;

public class MoreWeaponryOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, MoreWeaponryPlacedFeatures.MARE_DIAMOND_ORE_KEY);

    }
}
