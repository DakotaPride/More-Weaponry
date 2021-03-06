package net.DakotaPride.moreweaponry.common.item.items.cirtict.cooled;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CooledCirtictNugget extends Item {
    public CooledCirtictNugget(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.moreweaponry.cooled_cirtict_items.tooltip").formatted(Formatting.AQUA) );
    }

}
