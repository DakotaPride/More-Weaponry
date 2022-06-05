package net.DakotaPride.moreweaponry.common.effect;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class BleedingStatusEffect extends StatusEffect {
    public BleedingStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return super.canApplyUpdateEffect(duration, amplifier);
    }
}
