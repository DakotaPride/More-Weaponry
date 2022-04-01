package net.DakotaPride.moreweaponry.effect.status_effects.base;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.AbsorptionStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class CelestialEffect extends AbsorptionStatusEffect {
    public CelestialEffect(StatusEffectCategory statusEffectCategory, int i) {
        super(statusEffectCategory, i);
    }

    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        entity.setAbsorptionAmount(entity.getAbsorptionAmount() - (8 * (amplifier + 10)));
        super.onRemoved(entity, attributes, amplifier);
    }


    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        entity.setAbsorptionAmount(entity.getAbsorptionAmount() + (8 * (amplifier + 10)));
        super.onApplied(entity, attributes, amplifier);
    }

}
