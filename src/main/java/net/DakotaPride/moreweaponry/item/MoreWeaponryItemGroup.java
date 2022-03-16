package net.DakotaPride.moreweaponry.item;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class MoreWeaponryItemGroup {
    public static final ItemGroup MORE_WEAPONRY = FabricItemGroupBuilder.create(
                    new Identifier("moreweaponry", "more_weaponry"))
            .icon(() -> new ItemStack(MoreWeaponryItems.HEATED_CIRTICT_BATTLEAXE)).build();
}
