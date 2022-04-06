package net.DakotaPride.moreweaponry.entity;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.*;
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
                    .dimensions(EntityDimensions.fixed(0.6f, 3.8f)).build());
    public static final EntityType<LurkerEntity> LURKER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MoreWeaponry.MOD_ID, "lurker"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, LurkerEntity::new)
                    .dimensions(EntityDimensions.fixed(0.7f, 1.9f)).build());
    public static final EntityType<WandererEntity> WANDERER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MoreWeaponry.MOD_ID, "wanderer"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WandererEntity::new)
                    .dimensions(EntityDimensions.fixed(1.4f, 1.2f)).build());
    public static final EntityType<CracklerEntity> CRACKLER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MoreWeaponry.MOD_ID, "crackler"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CracklerEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.5f)).build());
    public static final EntityType<BardEntity> BARD = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MoreWeaponry.MOD_ID, "bard"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, BardEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.9f)).build());
    public static final EntityType<SickenedEntity> SICKENED = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MoreWeaponry.MOD_ID, "sickened"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SickenedEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.9f)).build());
    public static final EntityType<SickenedHuskEntity> SICKENED_HUSK = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MoreWeaponry.MOD_ID, "sickened_husk"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SickenedHuskEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.9f)).build());

    public static final EntityType<BuriedKnightEntity> BURIED_KNIGHT = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MoreWeaponry.MOD_ID, "buried_knight"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, BuriedKnightEntity::new)
                    .dimensions(EntityDimensions.fixed(0.7f, 1.9f)).build());
}
