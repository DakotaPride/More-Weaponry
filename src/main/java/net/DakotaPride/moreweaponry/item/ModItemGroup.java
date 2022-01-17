package net.DakotaPride.moreweaponry.item;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup MORE_WEAPONRY = FabricItemGroupBuilder.build(new Identifier(MoreWeaponry.MOD_ID, "more_weaponry"),
            () -> new ItemStack(ModBlocks.MOON_STONE_DUST_BLOCK));
}
