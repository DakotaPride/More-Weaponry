package net.DakotaPride.moreweaponry.common.world.gen;

import net.DakotaPride.moreweaponry.common.util.MoreWeaponryTags;
import net.DakotaPride.moreweaponry.common.world.features.MoreWeaponryPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;

public class MoreWeaponryTopLayerModification {
    public static void generateTopLayerModifications() {
        BiomeModifications.addFeature(BiomeSelectors.tag(MoreWeaponryTags.Biomes.SANDSTONE_DUST),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, MoreWeaponryPlacedFeatures.SANDSTONE_DUST_PLACED.getKey().get());
    }
}
