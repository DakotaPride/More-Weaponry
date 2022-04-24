package net.DakotaPride.moreweaponry.effect.status_effects.unfortuned;

import net.DakotaPride.moreweaponry.effect.status_effects.base.UnfortunedEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class PlaguedStatusEffect extends UnfortunedEffect {
    public PlaguedStatusEffect(StatusEffectCategory statusEffectCategory, int i) {
        super(statusEffectCategory, i);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }

}
