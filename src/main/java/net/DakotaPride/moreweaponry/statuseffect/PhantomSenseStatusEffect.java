package net.DakotaPride.moreweaponry.statuseffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class PhantomSenseStatusEffect extends StatusEffect {
    protected PhantomSenseStatusEffect(StatusEffectCategory category, int color) {
        super(StatusEffectCategory.BENEFICIAL, 0x5061A4);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return super.canApplyUpdateEffect(duration, amplifier);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
    }
}
