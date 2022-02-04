package net.DakotaPride.moreweaponry.item.custom.cirtict.heated;

import net.DakotaPride.moreweaponry.item.custom.vanilla_tools.ModHoeItem;
import net.DakotaPride.moreweaponry.item.custom.vanilla_tools.ModPickaxeItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HeatedCirtictPickaxe extends ModPickaxeItem {


    public HeatedCirtictPickaxe(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText("item.moreweaponry.heated_cirtict_items.tooltip").formatted(Formatting.GOLD) );
    }
}