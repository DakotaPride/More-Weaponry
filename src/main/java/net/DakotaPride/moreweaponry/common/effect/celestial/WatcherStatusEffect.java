package net.DakotaPride.moreweaponry.common.effect.celestial;

import net.DakotaPride.moreweaponry.common.effect.base.CelestialEffect;
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
