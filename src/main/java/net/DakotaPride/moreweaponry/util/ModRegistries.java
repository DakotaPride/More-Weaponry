package net.DakotaPride.moreweaponry.util;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.DakotaPride.moreweaponry.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.Items;

public class ModRegistries {
    public static void registerModFeatures()
    {
        registerModComposterChances();
        registerStrippables();
    }

    public static void registerModComposterChances() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.KURO_SEEDS, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.KURO, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.KURO_WHEAT_BLOCK.asItem(), 0.85f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.NITRIS_LEAVES.asItem(), 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.NITRIS_SAPLING.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.NIGHT_CURON.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CURON_FLOWER_PETALS, 0.45f);
    }

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.NITRIS_LOG, ModBlocks.STRIPPED_NITRIS_LOG);
        StrippableBlockRegistry.register(ModBlocks.NITRIS_WOOD, ModBlocks.STRIPPED_NITRIS_WOOD);
    }

}
