package net.DakotaPride.moreweaponry.block.entity;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<EssenceUpgraderEntity> ESSENCE_UPGRADER;

    public static void registerAllEntities() {
        ESSENCE_UPGRADER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MoreWeaponry.MOD_ID, "essence_upgrader"),
                FabricBlockEntityTypeBuilder.create(EssenceUpgraderEntity::new,
                        ModBlocks.ESSENCE_UPGRADER).build(null));
    }
}
