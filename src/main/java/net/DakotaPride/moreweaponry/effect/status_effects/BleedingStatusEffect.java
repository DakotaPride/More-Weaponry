package net.DakotaPride.moreweaponry.effect.status_effects;

import net.DakotaPride.moreweaponry.effect.MoreWeaponryEffects;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class BleedingStatusEffect extends StatusEffect {
    public BleedingStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public void canApplyUpdateEffect(LivingEntity entity, int amplifier) {
        if (this == MoreWeaponryEffects.BLEEDING) {
            if (entity.getHealth() > 1.0F) {
                entity.damage(DamageSource.MAGIC, 1.0F);
            }
        } else {
            entity.heal((float)Math.max(4 << amplifier, 0));
        }
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i;
        if (this == MoreWeaponryEffects.BLEEDING) {
            i = 25 >> amplifier;
            if (i > 0) {
                return duration % i == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


}
