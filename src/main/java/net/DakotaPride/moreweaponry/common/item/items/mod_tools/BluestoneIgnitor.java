package net.DakotaPride.moreweaponry.common.item.items.mod_tools;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BluestoneIgnitor extends Item {

    public BluestoneIgnitor(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.moreweaponry.ignitor.ever_frost").formatted(Formatting.DARK_AQUA));
        }  else {
            tooltip.add(Text.translatable("misc.moreweaponry.shift_up").formatted(Formatting.DARK_GRAY));
        }
    }

}
