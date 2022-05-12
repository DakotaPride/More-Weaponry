package net.DakotaPride.moreweaponry.common.world.dimension;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;

public class MoreWeaponryDimensions {
    private static final RegistryKey<DimensionOptions> DIMENSION_KEY = RegistryKey.of(Registry.DIMENSION_KEY,
            new Identifier(MoreWeaponry.MOD_ID, "ever_frost"));
    public static RegistryKey<World> EVER_FROST_KEY = RegistryKey.of(Registry.WORLD_KEY, DIMENSION_KEY.getValue());

    public static void register() {
        System.out.println("Registering Mod Dimensions for " + MoreWeaponry.MOD_ID);
    }
}
