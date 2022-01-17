package net.DakotaPride.moreweaponry.registries;

import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModRegistries {

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.NITRIS_LOG, ModBlocks.STRIPPED_NITRIS_LOG);
        StrippableBlockRegistry.register(ModBlocks.NITRIS_WOOD, ModBlocks.STRIPPED_NITRIS_WOOD);

    }
}
