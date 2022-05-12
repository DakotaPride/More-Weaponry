package net.DakotaPride.moreweaponry.common.effect;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class BleedingStatusEffect extends StatusEffect {
    public BleedingStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i;
        if (this == MoreWeaponry.BLEEDING) {
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
