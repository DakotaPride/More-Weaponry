package net.DakotaPride.moreweaponry.common.item.items.cores;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChargedMobCoreItem extends Item {
    public ChargedMobCoreItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.moreweaponry.core.charged").formatted(Formatting.AQUA));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
