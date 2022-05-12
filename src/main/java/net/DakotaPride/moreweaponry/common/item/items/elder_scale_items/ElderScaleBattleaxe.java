package net.DakotaPride.moreweaponry.common.item.items.elder_scale_items;

import net.DakotaPride.moreweaponry.common.item.items.mod_tools.BattleaxeItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class ElderScaleBattleaxe extends BattleaxeItem {
    public ElderScaleBattleaxe(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 200, 2), attacker);
        return super.postHit(stack, target, attacker);
    }
}
