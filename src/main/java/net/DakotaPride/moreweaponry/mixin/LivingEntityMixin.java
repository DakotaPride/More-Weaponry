package net.DakotaPride.moreweaponry.mixin;

import net.DakotaPride.moreweaponry.effect.MoreWeaponryEffects;
import net.DakotaPride.moreweaponry.entity.custom.BuriedKnightEntity;
import net.DakotaPride.moreweaponry.entity.custom.CrawlerEntity;
import net.DakotaPride.moreweaponry.entity.damage.MoreWeaponryDamageSource;
import net.DakotaPride.moreweaponry.item.custom.HeavyCrossBowItem;
import net.DakotaPride.moreweaponry.item.custom.HeavySwordItem;
import net.DakotaPride.moreweaponry.item.MoreWeaponryItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
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


        if (itemStack.getItem() instanceof HeavyCrossBowItem) {
            if (!livingEntity.getOffHandStack().isEmpty()) {
                addStatusEffect(new StatusEffectInstance(MoreWeaponryEffects.OVER_PACKAGED, 100));
            }

        } if (!livingEntity.getMainHandStack().isEmpty()) {
            if (livingEntity.getOffHandStack().isOf(MoreWeaponryItems.HEAVY_CROSSBOW)) {
                addStatusEffect(new StatusEffectInstance(MoreWeaponryEffects.OVER_PACKAGED, 100));
            }
        } if (livingEntity.getMainHandStack().isOf(MoreWeaponryItems.IRON_BOLT)) {
            removeStatusEffect(MoreWeaponryEffects.OVER_PACKAGED);
        } if (livingEntity.getMainHandStack().isOf(Items.FIREWORK_ROCKET)) {
            removeStatusEffect(MoreWeaponryEffects.OVER_PACKAGED);
        } if (livingEntity.getMainHandStack().isOf(Items.ARROW)) {
            removeStatusEffect(MoreWeaponryEffects.OVER_PACKAGED);
        }

        if (livingEntity.getOffHandStack().isOf(MoreWeaponryItems.IRON_BOLT)) {
            removeStatusEffect(MoreWeaponryEffects.OVER_PACKAGED);
        } if (livingEntity.getOffHandStack().isOf(Items.FIREWORK_ROCKET)) {
            removeStatusEffect(MoreWeaponryEffects.OVER_PACKAGED);
        } if (livingEntity.getOffHandStack().isOf(Items.ARROW)) {
            removeStatusEffect(MoreWeaponryEffects.OVER_PACKAGED);
        }

        if (livingEntity.hasStatusEffect(StatusEffects.BLINDNESS)) {
            if (livingEntity.getAttacker() instanceof BuriedKnightEntity) {
                livingEntity.damage(MoreWeaponryDamageSource.ANCIENT_DARKNESS, 1.0F);
            } if (livingEntity.getAttacker() instanceof CrawlerEntity) {
                livingEntity.damage(MoreWeaponryDamageSource.ANCIENT_DARKNESS, 1.0F);
            }
        }

        if (livingEntity.hasStatusEffect(MoreWeaponryEffects.CELESTIAL)) {
            livingEntity.damage(MoreWeaponryDamageSource.CELESTIALITE, 0.3F);
        }

    }

}
