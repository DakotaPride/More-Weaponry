package net.DakotaPride.moreweaponry.util;

import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.DakotaPride.moreweaponry.item.MoreWeaponryItems;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.ComposterBlock;

public class MoreWeaponryRegistries {
    public static void registerModFeatures()
    {
        registerModComposterChances();
        registerStrippables();
    }

    public static void registerModComposterChances() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(MoreWeaponryItems.KURO_SEEDS, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(MoreWeaponryItems.KURO, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(MoreWeaponryBlocks.KURO_WHEAT_BLOCK.asItem(), 0.85f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(MoreWeaponryBlocks.FRODON_LEAVES.asItem(), 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(MoreWeaponryBlocks.FRODON_SAPLING.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(MoreWeaponryBlocks.NIGHT_CURON.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(MoreWeaponryItems.CURON_FLOWER_PETALS, 0.45f);
    }

    public static void registerStrippables() {
        StrippableBlockRegistry.register(MoreWeaponryBlocks.FRODON_LOG, MoreWeaponryBlocks.STRIPPED_FRODON_LOG);
        StrippableBlockRegistry.register(MoreWeaponryBlocks.FRODON_WOOD, MoreWeaponryBlocks.STRIPPED_FRODON_WOOD);
    }

}
