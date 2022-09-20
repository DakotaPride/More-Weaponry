package net.DakotaPride.moreweaponry.common.world.features;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.world.features.tree.HugeGyolosMushroomFeature;
import net.DakotaPride.moreweaponry.common.world.features.tree.HugeSoukilMushroomFeature;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;

public class MoreWeaponryFeatures {
    public static final Feature<HugeMushroomFeatureConfig> HUGE_GYOLOS_MUSHROOM =
            register(MoreWeaponry.MOD_ID + "huge_gyolos_mushroom", new HugeGyolosMushroomFeature(HugeMushroomFeatureConfig.CODEC));
    public static final Feature<HugeMushroomFeatureConfig> HUGE_SOUKIL_MUSHROOM =
            register(MoreWeaponry.MOD_ID + "huge_soukil_mushroom", new HugeSoukilMushroomFeature(HugeMushroomFeatureConfig.CODEC));

    private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return (F) Registry.register(Registry.FEATURE, name, feature);
    }
}
