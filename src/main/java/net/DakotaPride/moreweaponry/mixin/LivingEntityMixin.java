package net.DakotaPride.moreweaponry.mixin;

import net.DakotaPride.moreweaponry.effect.MoreWeaponryEffects;
import net.DakotaPride.moreweaponry.item.HeavySwordItem;
import net.DakotaPride.moreweaponry.item.MoreWeaponryItems;
import net.DakotaPride.moreweaponry.item.custom.cores.SickenedCoreItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

    @Shadow public abstract boolean removeStatusEffect(StatusEffect type);

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect, @Nullable Entity source);

    @Inject(method = "Lnet/minecraft/entity/LivingEntity;getHandSwingDuration()I", at = @At("HEAD"), cancellable = true)
    private void getHandSwingDuration(CallbackInfoReturnable<Integer> info) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        ItemStack itemStack = livingEntity.getMainHandStack();
        if (itemStack.getItem() instanceof HeavySwordItem) {
            if (!livingEntity.getOffHandStack().isEmpty()) {
                addStatusEffect(new StatusEffectInstance(MoreWeaponryEffects.OVER_PACKAGED, 100));
            }

            addStatusEffect(new StatusEffectInstance(MoreWeaponryEffects.BLEEDING, 100));

        } if (!livingEntity.getMainHandStack().isEmpty()) {
            if (livingEntity.getOffHandStack().isOf(MoreWeaponryItems.HEAVY_SWORD)) {
                    addStatusEffect(new StatusEffectInstance(MoreWeaponryEffects.OVER_PACKAGED, 100));
                    addStatusEffect(new StatusEffectInstance(MoreWeaponryEffects.BLEEDING, 100));
            }
        }
        if (livingEntity.getOffHandStack().isOf(MoreWeaponryItems.HEAVY_SWORD)) {
            addStatusEffect(new StatusEffectInstance(MoreWeaponryEffects.BLEEDING, 100));
        } if (livingEntity.getOffHandStack().isOf(MoreWeaponryItems.POWERED_PLAGUED_MOB_CORE)) {
            removeStatusEffect(MoreWeaponryEffects.PLAGUED);
        } if (livingEntity.getOffHandStack().isOf(MoreWeaponryItems.POWERED_SUPPRESSED_MOB_CORE)) {
            removeStatusEffect(MoreWeaponryEffects.EXPLOSIVE);
        } if (livingEntity.getOffHandStack().isOf(MoreWeaponryItems.POWERED_WATCHER_MOB_CORE)) {
            removeStatusEffect(MoreWeaponryEffects.TICKED);
        } if (livingEntity.getOffHandStack().isOf(MoreWeaponryItems.POWERED_MAIDEN_MOB_CORE)) {
            removeStatusEffect(MoreWeaponryEffects.SIREN);
        } if (livingEntity.getOffHandStack().isOf(MoreWeaponryItems.POWERED_WRETCHED_MOB_CORE)) {
            removeStatusEffect(MoreWeaponryEffects.WEBBED);
        } if (livingEntity.getOffHandStack().isOf(MoreWeaponryItems.POWERED_SICKENED_HUSK_MOB_CORE)) {
            removeStatusEffect(MoreWeaponryEffects.PLAGUED);
        }
    }

}
