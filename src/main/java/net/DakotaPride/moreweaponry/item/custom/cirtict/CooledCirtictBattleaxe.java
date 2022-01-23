package net.DakotaPride.moreweaponry.item.custom.cirtict;

import net.DakotaPride.moreweaponry.item.custom.mod_tools.ModBattleaxeItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CooledCirtictBattleaxe extends ModBattleaxeItem {

    public CooledCirtictBattleaxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText("item.moreweaponry.cooled_cirtict_battleaxe.tooltip").formatted(Formatting.BLUE) );
    }
}
