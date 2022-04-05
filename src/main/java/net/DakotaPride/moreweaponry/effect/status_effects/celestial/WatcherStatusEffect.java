package net.DakotaPride.moreweaponry.effect.status_effects.celestial;

import net.DakotaPride.moreweaponry.effect.status_effects.base.CelestialEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class WatcherStatusEffect extends CelestialEffect {
    public WatcherStatusEffect(StatusEffectCategory statusEffectCategory, int i) {
        super(statusEffectCategory, i);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }

}
