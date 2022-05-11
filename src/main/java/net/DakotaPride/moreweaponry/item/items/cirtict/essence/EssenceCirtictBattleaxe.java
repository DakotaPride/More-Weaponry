package net.DakotaPride.moreweaponry.item.items.cirtict.essence;

import net.DakotaPride.moreweaponry.item.items.mod_tools.BattleaxeItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class EssenceCirtictBattleaxe extends BattleaxeItem {

    public EssenceCirtictBattleaxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 2), attacker);
        return super.postHit(stack, target, attacker);
    }

}
