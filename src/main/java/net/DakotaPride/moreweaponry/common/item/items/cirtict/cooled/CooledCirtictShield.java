package net.DakotaPride.moreweaponry.common.item.items.cirtict.cooled;

import net.DakotaPride.moreweaponry.common.item.items.shields.MoreWeaponryShieldItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CooledCirtictShield extends MoreWeaponryShieldItem {
    public CooledCirtictShield(Settings settings, int cooldownTicks, int enchantability, Item... repairItems) {
        super(settings, cooldownTicks, enchantability, repairItems);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.moreweaponry.cooled_cirtict_items.tooltip").formatted(Formatting.AQUA) );
    }

}
