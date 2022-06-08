package net.DakotaPride.moreweaponry.common.item.items.cirtict.heated;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HeatedCirtictPickaxe extends MoreWeaponry.BetterPickaxeItem {


    public HeatedCirtictPickaxe(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.moreweaponry.heated_cirtict_items.tooltip").formatted(Formatting.GOLD) );
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.isOnFire()) {
            target.setOnFireFor(5);
        }
        return super.postHit(stack, target, attacker);
    }

}
