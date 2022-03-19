package net.DakotaPride.moreweaponry.world.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.DakotaPride.moreweaponry.MoreWeaponry;

public class MoreWeaponryDimensions {
    private static final RegistryKey<DimensionOptions> DIMENSION_KEY = RegistryKey.of(Registry.DIMENSION_KEY,
            new Identifier(MoreWeaponry.MOD_ID, "ever_frost"));
    public static RegistryKey<World> EVER_FROST_KEY = RegistryKey.of(Registry.WORLD_KEY, DIMENSION_KEY.getValue());
    private static final RegistryKey<DimensionType> DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            new Identifier(MoreWeaponry.MOD_ID, "ever_frost_type"));

    public static void register() {
        System.out.println("Registering Mod Dimensions for " + MoreWeaponry.MOD_ID);
    }
}
