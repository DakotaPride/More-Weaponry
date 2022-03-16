package net.DakotaPride.moreweaponry.block.entity;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreWeaponryBlockEntities {
    public static BlockEntityType<CoreForgeEntity> CORE_FORGE;
    public static BlockEntityType<EssenceTranslatorEntity> ESSENCE_TRANSLATOR;
    public static BlockEntityType<CirtictForgeEntity> CIRTICT_FORGE;

    public static void registerMoreWeaponryBlockEntities() {
        CORE_FORGE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MoreWeaponry.MOD_ID, "core_forge"),
                FabricBlockEntityTypeBuilder.create(CoreForgeEntity::new,
                        MoreWeaponryBlocks.CORE_FORGE).build(null));
        ESSENCE_TRANSLATOR = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MoreWeaponry.MOD_ID, "essence_translator"),
                FabricBlockEntityTypeBuilder.create(EssenceTranslatorEntity::new,
                        MoreWeaponryBlocks.ESSENCE_TRANSLATOR).build(null));
        CIRTICT_FORGE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MoreWeaponry.MOD_ID, "cirtict_forge"),
                FabricBlockEntityTypeBuilder.create(CirtictForgeEntity::new,
                        MoreWeaponryBlocks.CIRTICT_FORGE).build(null));
    }

}
