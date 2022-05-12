package net.DakotaPride.moreweaponry.item.items;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class BotheringMightSwordItem extends SwordItem {
    public BotheringMightSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(MoreWeaponry.CONFUSION, 200, 2), attacker);
        return super.postHit(stack, target, attacker);
    }
}
