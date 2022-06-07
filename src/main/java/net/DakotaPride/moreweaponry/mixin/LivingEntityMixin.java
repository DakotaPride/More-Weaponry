package net.DakotaPride.moreweaponry.mixin;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.BuriedKnightEntity;
import net.DakotaPride.moreweaponry.common.entity.custom.CrawlerEntity;
import net.DakotaPride.moreweaponry.common.entity.damage.MoreWeaponryDamageSource;
import net.DakotaPride.moreweaponry.common.item.items.HeavyCrossBowItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements ILivingEntityMixin {
    LivingEntity livingEntity = (LivingEntity) (Object) this;
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

    @Shadow public abstract boolean removeStatusEffect(StatusEffect type);

    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect, @Nullable Entity source);

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        LivingEntity attacker = livingEntity.getAttacker();
        ItemStack itemStack = livingEntity.getMainHandStack();
        if (livingEntity.getMainHandStack().isOf(MoreWeaponry.HEAVY_SWORD)) {
            if (!livingEntity.getOffHandStack().isEmpty()) {
                addStatusEffect(new StatusEffectInstance(MoreWeaponry.OVER_PACKAGED, 100));
            }

            addStatusEffect(new StatusEffectInstance(MoreWeaponry.BLEEDING, 100));

        } if (!livingEntity.getMainHandStack().isEmpty()) {
            if (livingEntity.getOffHandStack().isOf(MoreWeaponry.HEAVY_SWORD)) {
                    addStatusEffect(new StatusEffectInstance(MoreWeaponry.OVER_PACKAGED, 100));
                    addStatusEffect(new StatusEffectInstance(MoreWeaponry.BLEEDING, 100));
            }
        }
        if (livingEntity.getOffHandStack().isOf(MoreWeaponry.HEAVY_SWORD)) {
            addStatusEffect(new StatusEffectInstance(MoreWeaponry.BLEEDING, 100));
        } if (livingEntity.getOffHandStack().isOf(MoreWeaponry.POWERED_PLAGUED_MOB_CORE)) {
            removeStatusEffect(MoreWeaponry.PLAGUED);
        } if (livingEntity.getOffHandStack().isOf(MoreWeaponry.POWERED_SUPPRESSED_MOB_CORE)) {
            removeStatusEffect(MoreWeaponry.EXPLOSIVE);
        } if (livingEntity.getOffHandStack().isOf(MoreWeaponry.POWERED_WATCHER_MOB_CORE)) {
            removeStatusEffect(MoreWeaponry.TICKED);
        } if (livingEntity.getOffHandStack().isOf(MoreWeaponry.POWERED_MAIDEN_MOB_CORE)) {
            removeStatusEffect(MoreWeaponry.SIREN);
        } if (livingEntity.getOffHandStack().isOf(MoreWeaponry.POWERED_WRETCHED_MOB_CORE)) {
            removeStatusEffect(MoreWeaponry.WEBBED);
        } if (livingEntity.getOffHandStack().isOf(MoreWeaponry.POWERED_SICKENED_HUSK_MOB_CORE)) {
            removeStatusEffect(MoreWeaponry.PLAGUED);
        }

        if (this.hasStatusEffect(MoreWeaponry.BLEEDING)) {
            this.damage(MoreWeaponryDamageSource.BLEEDING, 0.6F);
        }

        if (this.hasStatusEffect(MoreWeaponry.COLD_BLOODED)) {
            this.removeStatusEffect(StatusEffects.POISON);
            this.removeStatusEffect(StatusEffects.WITHER);
        }

        if (itemStack.getItem() instanceof HeavyCrossBowItem) {
            if (!livingEntity.getOffHandStack().isEmpty()) {
                addStatusEffect(new StatusEffectInstance(MoreWeaponry.OVER_PACKAGED, 100));
            }

        } if (!livingEntity.getMainHandStack().isEmpty()) {
            if (livingEntity.getOffHandStack().isOf(MoreWeaponry.HEAVY_CROSSBOW)) {
                addStatusEffect(new StatusEffectInstance(MoreWeaponry.OVER_PACKAGED, 100));
            }
        } if (livingEntity.getMainHandStack().isOf(MoreWeaponry.IRON_BOLT_ITEM)) {
            removeStatusEffect(MoreWeaponry.OVER_PACKAGED);
        } if (livingEntity.getMainHandStack().isOf(Items.FIREWORK_ROCKET)) {
            removeStatusEffect(MoreWeaponry.OVER_PACKAGED);
        } if (livingEntity.getMainHandStack().isOf(Items.ARROW)) {
            removeStatusEffect(MoreWeaponry.OVER_PACKAGED);
        }

        if (livingEntity.getOffHandStack().isOf(MoreWeaponry.IRON_BOLT_ITEM)) {
            removeStatusEffect(MoreWeaponry.OVER_PACKAGED);
        } if (livingEntity.getOffHandStack().isOf(Items.FIREWORK_ROCKET)) {
            removeStatusEffect(MoreWeaponry.OVER_PACKAGED);
        } if (livingEntity.getOffHandStack().isOf(Items.ARROW)) {
            removeStatusEffect(MoreWeaponry.OVER_PACKAGED);
        }

        if (livingEntity.hasStatusEffect(StatusEffects.BLINDNESS)) {
            if (livingEntity.getAttacker() instanceof BuriedKnightEntity) {
                livingEntity.damage(MoreWeaponryDamageSource.ANCIENT_DARKNESS, 1.0F);
            } if (livingEntity.getAttacker() instanceof CrawlerEntity) {
                livingEntity.damage(MoreWeaponryDamageSource.ANCIENT_DARKNESS, 1.0F);
            }
        }

        if (livingEntity.hasStatusEffect(MoreWeaponry.CELESTIAL)) {
            livingEntity.damage(MoreWeaponryDamageSource.CELESTIALITE, 0.3F);
        }

    }

}
