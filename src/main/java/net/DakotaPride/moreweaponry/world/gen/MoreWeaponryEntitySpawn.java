package net.DakotaPride.moreweaponry.world.gen;

import net.DakotaPride.moreweaponry.entity.MoreWeaponryEntities;
import net.DakotaPride.moreweaponry.entity.custom.LurkerEntity;
import net.DakotaPride.moreweaponry.entity.custom.WandererEntity;
import net.DakotaPride.moreweaponry.entity.custom.WatcherEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;

public class MoreWeaponryEntitySpawn {
    public static void addEntitySpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.THEEND), SpawnGroup.MONSTER,
                MoreWeaponryEntities.WATCHER, 1, 0, 1);
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.THEEND), SpawnGroup.MONSTER,
                MoreWeaponryEntities.LURKER, 2, 0, 3);

        SpawnRestrictionAccessor.callRegister(MoreWeaponryEntities.WATCHER, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WatcherEntity::canSpawnIgnoreLightLevel);
        SpawnRestrictionAccessor.callRegister(MoreWeaponryEntities.LURKER, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LurkerEntity::canSpawnIgnoreLightLevel);
        SpawnRestrictionAccessor.callRegister(MoreWeaponryEntities.WANDERER, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WandererEntity::canSpawnIgnoreLightLevel);

    }
}
