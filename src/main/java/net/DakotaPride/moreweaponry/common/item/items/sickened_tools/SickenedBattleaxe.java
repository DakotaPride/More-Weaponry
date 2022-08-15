package net.DakotaPride.moreweaponry.common.item.items.sickened_tools;

import net.DakotaPride.moreweaponry.common.item.items.mod_tools.BattleaxeItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SickenedBattleaxe extends BattleaxeItem {
    public SickenedBattleaxe(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 2), attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200, 2), attacker);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("text.set.sickened__set").formatted(Formatting.DARK_GREEN));
    }

}
