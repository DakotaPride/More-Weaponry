package net.DakotaPride.moreweaponry.entity;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.WatcherEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreWeaponryEntities {
    public static final EntityType<WatcherEntity> WATCHER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MoreWeaponry.MOD_ID, "watcher"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WatcherEntity::new)
                    .dimensions(EntityDimensions.fixed(1.0f, 3.0f)).build());
}
