package net.DakotaPride.moreweaponry.world.features.tree;

import net.DakotaPride.moreweaponry.world.features.ModConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class FrodonSaplingGenerator extends SaplingGenerator {
    public FrodonSaplingGenerator(ConfiguredFeature<TreeFeatureConfig, ?> nitrisTree) {

    }

    @Nullable
    @Override
    protected ConfiguredFeature<?, ?> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.FRODON_TREE;
    }
}
