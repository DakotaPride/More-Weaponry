package net.DakotaPride.moreweaponry.mixin;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.damage.MoreWeaponryDamageSource;
import net.DakotaPride.moreweaponry.common.item.items.BotheringMightSwordItem;
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
        if (entity.hasStatusEffect(MoreWeaponry.CELESTIAL)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
            if (itemStack.getItem() instanceof BotheringMightSwordItem) {
                if (target != null) {
                    target.addStatusEffect(new StatusEffectInstance(MoreWeaponry.CONFUSION));
                }
            }
        } else if (entity.hasStatusEffect(MoreWeaponry.PLAGUED)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
            if (itemStack.getItem() instanceof BotheringMightSwordItem) {
                if (target != null) {
                    target.addStatusEffect(new StatusEffectInstance(MoreWeaponry.CONFUSION));
                }
            }
        } else if (entity.hasStatusEffect(MoreWeaponry.EXPLOSIVE)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
            if (itemStack.getItem() instanceof BotheringMightSwordItem) {
                if (target != null) {
                    target.addStatusEffect(new StatusEffectInstance(MoreWeaponry.CONFUSION));
                }
            }
        } else if (entity.hasStatusEffect(MoreWeaponry.SIREN)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
            if (itemStack.getItem() instanceof BotheringMightSwordItem) {
                if (target != null) {
                    target.addStatusEffect(new StatusEffectInstance(MoreWeaponry.CONFUSION));
                }
            }
        } else if (entity.hasStatusEffect(MoreWeaponry.TICKED)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
            if (itemStack.getItem() instanceof BotheringMightSwordItem) {
                if (target != null) {
                    target.addStatusEffect(new StatusEffectInstance(MoreWeaponry.CONFUSION));
                }
            }
        } else if (entity.hasStatusEffect(MoreWeaponry.WEBBED)) {
            entity.removeStatusEffect(StatusEffects.REGENERATION);
            if (itemStack.getItem() instanceof BotheringMightSwordItem) {
                if (target != null) {
                    target.addStatusEffect(new StatusEffectInstance(MoreWeaponry.CONFUSION));
                }
            }
        }

        if (entity.hasStatusEffect(MoreWeaponry.BLEEDING)) {
            entity.damage(MoreWeaponryDamageSource.BLEEDING, 0.4F);
        }

        if (entity.hasStatusEffect(MoreWeaponry.WATCHER)) {
            entity.removeStatusEffect(StatusEffects.POISON);
            entity.removeStatusEffect(StatusEffects.BLINDNESS);
            entity.removeStatusEffect(StatusEffects.SLOWNESS);
            entity.removeStatusEffect(StatusEffects.WEAKNESS);
            entity.removeStatusEffect(StatusEffects.WITHER);
            entity.removeStatusEffect(StatusEffects.UNLUCK);
        } else if (entity.hasStatusEffect(MoreWeaponry.SICKENED)) {
            entity.removeStatusEffect(StatusEffects.SLOWNESS);
            entity.removeStatusEffect(StatusEffects.UNLUCK);
        } else if (entity.hasStatusEffect(MoreWeaponry.CRACKLER)) {
            entity.removeStatusEffect(StatusEffects.SLOWNESS);
            entity.removeStatusEffect(StatusEffects.WEAKNESS);
            entity.removeStatusEffect(StatusEffects.UNLUCK);
        } else if (entity.hasStatusEffect(MoreWeaponry.BARD)) {
            entity.removeStatusEffect(StatusEffects.BLINDNESS);
            entity.removeStatusEffect(StatusEffects.SLOWNESS);
            entity.removeStatusEffect(StatusEffects.WEAKNESS);
            entity.removeStatusEffect(StatusEffects.UNLUCK);
        } else if (entity.hasStatusEffect(MoreWeaponry.WANDERER)) {
            entity.removeStatusEffect(StatusEffects.POISON);
            entity.removeStatusEffect(StatusEffects.BLINDNESS);
            entity.removeStatusEffect(StatusEffects.SLOWNESS);
            entity.removeStatusEffect(StatusEffects.WEAKNESS);
            entity.removeStatusEffect(StatusEffects.UNLUCK);
        }

    }

}
