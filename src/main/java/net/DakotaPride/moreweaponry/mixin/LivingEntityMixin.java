package net.DakotaPride.moreweaponry.mixin;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.BuriedKnightEntity;
import net.DakotaPride.moreweaponry.common.entity.custom.CrawlerEntity;
import net.DakotaPride.moreweaponry.common.entity.damage.MoreWeaponryDamageSource;
import net.DakotaPride.moreweaponry.common.item.items.HeavyCrossBowItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements ILivingEntityMixin {
    LivingEntity livingEntity = (LivingEntity) (Object) this;
    private StatusEffect statusEffect;

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

    @Shadow public abstract boolean removeStatusEffect(StatusEffect type);

    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect, @Nullable Entity source);

    @Shadow public abstract ItemStack getOffHandStack();

    @Shadow public @Nullable abstract LivingEntity getAttacker();

    @Inject(method = "hasStatusEffect", at = @At("HEAD"))
    private void hasStatusEffect(StatusEffect effect, CallbackInfoReturnable<Boolean> cir) {
        if (effect == MoreWeaponry.WATCHER) {
            if (!livingEntity.getEquippedStack(EquipmentSlot.HEAD).isOf(MoreWeaponry.WATCHER_HELMET)) {
                livingEntity.removeStatusEffect(MoreWeaponry.WATCHER);
            }
            if (!livingEntity.getEquippedStack(EquipmentSlot.CHEST).isOf(MoreWeaponry.WATCHER_BREASTPLATE)) {
                livingEntity.removeStatusEffect(MoreWeaponry.WATCHER);
            }
        } else if (effect == MoreWeaponry.SICKENED) {
            if (!livingEntity.getEquippedStack(EquipmentSlot.HEAD).isOf(MoreWeaponry.SICKENED_HELMET)) {
                livingEntity.removeStatusEffect(MoreWeaponry.SICKENED);
            }
            if (!livingEntity.getEquippedStack(EquipmentSlot.CHEST).isOf(MoreWeaponry.SICKENED_BREASTPLATE)) {
                livingEntity.removeStatusEffect(MoreWeaponry.SICKENED);
            }
        } else if (effect == MoreWeaponry.BARD) {
            if (!livingEntity.getEquippedStack(EquipmentSlot.HEAD).isOf(MoreWeaponry.BARD_HELMET)) {
                livingEntity.removeStatusEffect(MoreWeaponry.BARD);
            }
            if (!livingEntity.getEquippedStack(EquipmentSlot.CHEST).isOf(MoreWeaponry.BARD_BREASTPLATE)) {
                livingEntity.removeStatusEffect(MoreWeaponry.BARD);
            }
        } else if (effect == MoreWeaponry.CRACKLER) {
            if (!livingEntity.getEquippedStack(EquipmentSlot.HEAD).isOf(MoreWeaponry.CRACKLER_HELMET)) {
                livingEntity.removeStatusEffect(MoreWeaponry.CRACKLER);
            }
            if (!livingEntity.getEquippedStack(EquipmentSlot.CHEST).isOf(MoreWeaponry.CRACKLER_BREASTPLATE)) {
                livingEntity.removeStatusEffect(MoreWeaponry.CRACKLER);
            }
        } else if (effect == MoreWeaponry.WANDERER) {
            if (!livingEntity.getEquippedStack(EquipmentSlot.HEAD).isOf(MoreWeaponry.WANDERER_HELMET)) {
                livingEntity.removeStatusEffect(MoreWeaponry.WANDERER);
            }
            if (!livingEntity.getEquippedStack(EquipmentSlot.CHEST).isOf(MoreWeaponry.WANDERER_BREASTPLATE)) {
                livingEntity.removeStatusEffect(MoreWeaponry.WANDERER);
            }
        }
    }

    @Inject(method = "damage", at = @At("HEAD"))
    private void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity attacker = livingEntity.getAttacker();
        if (this.getOffHandStack().isOf(MoreWeaponry.DUSTED_LIFE_CORE)) {
            if (livingEntity.getAttacker() != null) {
                tryAttackHuskPlayer(attacker);
            }
        }

    }

    public void tryAttackHuskPlayer(Entity target) {
            ((LivingEntity)target).addStatusEffect(new StatusEffectInstance
                    (StatusEffects.HUNGER, 500, 2), livingEntity);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
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



        if (this.getOffHandStack().isOf(MoreWeaponry.POISONOUS_FANG)) {
            if (!this.hasStatusEffect(MoreWeaponry.COLD_BLOODED)) {
                this.addStatusEffect(new StatusEffectInstance(MoreWeaponry.COLD_BLOODED, 100, 1));
            }
            if (this.hasStatusEffect(MoreWeaponry.COLD_BLOODED)) {
                this.removeStatusEffect(StatusEffects.POISON);
                this.removeStatusEffect(StatusEffects.WITHER);
            }
        }

        if (this.getOffHandStack().isOf(MoreWeaponry.FORGOTTEN_MUSIC_SHEET)) {
            if (!this.hasStatusEffect(StatusEffects.REGENERATION)) {
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1));
            }
        }

        if (this.getOffHandStack().isOf(MoreWeaponry.TICKING_HEART)) {
            if (!this.hasStatusEffect(StatusEffects.RESISTANCE)) {
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 1));
            }
        }

        if (this.getOffHandStack().isOf(MoreWeaponry.CORRUPTED_EYE_OF_ENDER)) {
            if (!this.hasStatusEffect(StatusEffects.STRENGTH)) {
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 1));
            }
        }

        if (this.getOffHandStack().isOf(MoreWeaponry.LIFE_CORE)) {
            if (!this.hasStatusEffect(StatusEffects.SPEED)) {
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 1));
            }
        }

        if (this.getOffHandStack().isOf(MoreWeaponry.DUSTED_LIFE_CORE)) {
            if (!this.hasStatusEffect(StatusEffects.FIRE_RESISTANCE)) {
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 100, 1));
            }

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
