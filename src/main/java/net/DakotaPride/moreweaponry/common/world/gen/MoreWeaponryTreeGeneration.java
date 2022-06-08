package net.DakotaPride.moreweaponry.common.world.gen;

import net.DakotaPride.moreweaponry.common.util.MoreWeaponryTags;
import net.DakotaPride.moreweaponry.common.world.features.MoreWeaponryPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;

    public class MoreWeaponryTreeGeneration {
        public static void generateTrees() {
            BiomeModifications.addFeature(BiomeSelectors.tag(MoreWeaponryTags.Biomes.FRODON_TREES),
                    GenerationStep.Feature.VEGETAL_DECORATION, MoreWeaponryPlacedFeatures.FRODON_TREE_PLACED.getKey().get());
        }

}
