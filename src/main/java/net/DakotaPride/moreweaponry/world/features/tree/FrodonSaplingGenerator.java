package net.DakotaPride.moreweaponry.world.features.tree;

import net.DakotaPride.moreweaponry.world.features.MoreWeaponryConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class FrodonSaplingGenerator extends SaplingGenerator {

    @Nullable
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return MoreWeaponryConfiguredFeatures.FRODON_TREE;
    }
}
