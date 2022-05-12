package net.DakotaPride.moreweaponry.util;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.ComposterBlock;

public class MoreWeaponryRegistries {
    public static void registerMoreWeaponryFeatures()
    {
        registerMoreWeaponryComposterChances();
        registerMoreWeaponryStrippables();
    }

    public static void registerMoreWeaponryComposterChances() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(MoreWeaponry.KURO_SEEDS, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(MoreWeaponry.KURO, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(MoreWeaponry.KURO_WHEAT_BLOCK.asItem(), 0.85f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(MoreWeaponry.FRODON_LEAVES.asItem(), 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(MoreWeaponry.FRODON_SAPLING.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(MoreWeaponry.NIGHT_CURON.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(MoreWeaponry.CURON_FLOWER_PETALS, 0.45f);
    }

    public static void registerMoreWeaponryStrippables() {
        StrippableBlockRegistry.register(MoreWeaponry.FRODON_LOG, MoreWeaponry.STRIPPED_FRODON_LOG);
        StrippableBlockRegistry.register(MoreWeaponry.FRODON_WOOD, MoreWeaponry.STRIPPED_FRODON_WOOD);
    }

}
