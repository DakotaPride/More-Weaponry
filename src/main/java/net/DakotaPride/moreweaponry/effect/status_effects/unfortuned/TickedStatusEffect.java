package net.DakotaPride.moreweaponry.effect.status_effects.unfortuned;

import net.DakotaPride.moreweaponry.effect.status_effects.base.UnfortunedEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class TickedStatusEffect extends UnfortunedEffect {
    public TickedStatusEffect(StatusEffectCategory statusEffectCategory, int i) {
        super(statusEffectCategory, i);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }

}
