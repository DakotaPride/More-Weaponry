package net.DakotaPride.moreweaponry.effect.status_effects.celestial;

import net.DakotaPride.moreweaponry.effect.status_effects.base.CelestialEffect;
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
