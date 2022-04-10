package net.DakotaPride.moreweaponry.mixin;

import net.DakotaPride.moreweaponry.effect.MoreWeaponryEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(StatusEffect.class)
public class StatusEffectMixin {
    @Inject(method = "applyUpdateEffect", at = @At("HEAD"))
    public void applyUpdateEffect(LivingEntity entity, int amplifier, CallbackInfo callbackInfo) {
        if (entity.hasStatusEffect(MoreWeaponryEffects.CELESTIAL)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
        } else if (entity.hasStatusEffect(MoreWeaponryEffects.PLAGUED)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
        } else if (entity.hasStatusEffect(MoreWeaponryEffects.EXPLOSIVE)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
        } else if (entity.hasStatusEffect(MoreWeaponryEffects.SIREN)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
        } else if (entity.hasStatusEffect(MoreWeaponryEffects.TICKED)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
        } else if (entity.hasStatusEffect(MoreWeaponryEffects.WEBBED)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
        }

    }

}
