package net.DakotaPride.moreweaponry.mixin;

import net.DakotaPride.moreweaponry.effect.MoreWeaponryEffects;
import net.DakotaPride.moreweaponry.entity.damage.MoreWeaponryDamageSource;
import net.DakotaPride.moreweaponry.item.items.BotheringMightSwordItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(StatusEffect.class)
public class StatusEffectMixin {
    @Inject(method = "applyUpdateEffect", at = @At("HEAD"))
    public void applyUpdateEffect(LivingEntity entity, int amplifier, CallbackInfo callbackInfo) {
        ItemStack itemStack = entity.getMainHandStack();
        LivingEntity target = entity.getAttacking();
        if (entity.hasStatusEffect(MoreWeaponryEffects.CELESTIAL)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
            if (itemStack.getItem() instanceof BotheringMightSwordItem) {
                if (target != null) {
                    target.addStatusEffect(new StatusEffectInstance(MoreWeaponryEffects.CONFUSION));
                }
            }
        } else if (entity.hasStatusEffect(MoreWeaponryEffects.PLAGUED)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
            if (itemStack.getItem() instanceof BotheringMightSwordItem) {
                if (target != null) {
                    target.addStatusEffect(new StatusEffectInstance(MoreWeaponryEffects.CONFUSION));
                }
            }
        } else if (entity.hasStatusEffect(MoreWeaponryEffects.EXPLOSIVE)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
            if (itemStack.getItem() instanceof BotheringMightSwordItem) {
                if (target != null) {
                    target.addStatusEffect(new StatusEffectInstance(MoreWeaponryEffects.CONFUSION));
                }
            }
        } else if (entity.hasStatusEffect(MoreWeaponryEffects.SIREN)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
            if (itemStack.getItem() instanceof BotheringMightSwordItem) {
                if (target != null) {
                    target.addStatusEffect(new StatusEffectInstance(MoreWeaponryEffects.CONFUSION));
                }
            }
        } else if (entity.hasStatusEffect(MoreWeaponryEffects.TICKED)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
            if (itemStack.getItem() instanceof BotheringMightSwordItem) {
                if (target != null) {
                    target.addStatusEffect(new StatusEffectInstance(MoreWeaponryEffects.CONFUSION));
                }
            }
        } else if (entity.hasStatusEffect(MoreWeaponryEffects.WEBBED)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
            if (itemStack.getItem() instanceof BotheringMightSwordItem) {
                if (target != null) {
                    target.addStatusEffect(new StatusEffectInstance(MoreWeaponryEffects.CONFUSION));
                }
            }
        }

        if (entity.hasStatusEffect(MoreWeaponryEffects.BLEEDING)) {
            entity.damage(MoreWeaponryDamageSource.BLEEDING, 0.4F);
        }

        if (entity.hasStatusEffect(MoreWeaponryEffects.WATCHER)) {
            entity.removeStatusEffect(StatusEffects.POISON);
            entity.removeStatusEffect(StatusEffects.BLINDNESS);
            entity.removeStatusEffect(StatusEffects.SLOWNESS);
            entity.removeStatusEffect(StatusEffects.WEAKNESS);
            entity.removeStatusEffect(StatusEffects.WITHER);
            entity.removeStatusEffect(StatusEffects.UNLUCK);
        } else if (entity.hasStatusEffect(MoreWeaponryEffects.SICKENED)) {
            entity.removeStatusEffect(StatusEffects.SLOWNESS);
            entity.removeStatusEffect(StatusEffects.UNLUCK);
        } else if (entity.hasStatusEffect(MoreWeaponryEffects.CRACKLER)) {
            entity.removeStatusEffect(StatusEffects.SLOWNESS);
            entity.removeStatusEffect(StatusEffects.WEAKNESS);
            entity.removeStatusEffect(StatusEffects.UNLUCK);
        } else if (entity.hasStatusEffect(MoreWeaponryEffects.BARD)) {
            entity.removeStatusEffect(StatusEffects.BLINDNESS);
            entity.removeStatusEffect(StatusEffects.SLOWNESS);
            entity.removeStatusEffect(StatusEffects.WEAKNESS);
            entity.removeStatusEffect(StatusEffects.UNLUCK);
        } else if (entity.hasStatusEffect(MoreWeaponryEffects.WANDERER)) {
            entity.removeStatusEffect(StatusEffects.POISON);
            entity.removeStatusEffect(StatusEffects.BLINDNESS);
            entity.removeStatusEffect(StatusEffects.SLOWNESS);
            entity.removeStatusEffect(StatusEffects.WEAKNESS);
            entity.removeStatusEffect(StatusEffects.UNLUCK);
        }

    }

}
