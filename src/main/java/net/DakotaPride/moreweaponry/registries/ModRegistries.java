package net.DakotaPride.moreweaponry.registries;

import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.DakotaPride.moreweaponry.item.ModItems;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.ComposterBlock;

public class ModRegistries {
    public static void registerModFeatures()
    {
        registerModComposterChances();
        registerStrippables();
    }

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.NITRIS_LOG, ModBlocks.STRIPPED_NITRIS_LOG);
        StrippableBlockRegistry.register(ModBlocks.NITRIS_WOOD, ModBlocks.STRIPPED_NITRIS_WOOD);

    }

    public static void registerModComposterChances() {
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.KURO_SEEDS, 0.35f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.KURO, 0.65f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.KURO_WHEAT_BLOCK, 0.90f);
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.NITRIS_LEAVES, 0.75f);
    }

}

