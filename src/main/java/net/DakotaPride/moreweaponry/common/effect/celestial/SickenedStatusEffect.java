package net.DakotaPride.moreweaponry.common.effect.celestial;

import net.DakotaPride.moreweaponry.common.effect.base.CelestialEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class SickenedStatusEffect extends CelestialEffect {
    public SickenedStatusEffect(StatusEffectCategory statusEffectCategory, int i) {
        super(statusEffectCategory, i);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }
}
