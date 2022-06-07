package net.DakotaPride.moreweaponry.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    LivingEntity livingEntity = (LivingEntity) (Object) this;

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        LivingEntity attacker = livingEntity.getAttacker();
        if (livingEntity.hasStatusEffect(StatusEffects.FIRE_RESISTANCE)) {
            tryAttackHuskPlayer(attacker);
        }
    }

    public void tryAttackHuskPlayer(Entity target) {
        boolean bl = livingEntity.tryAttack(target);
        if (bl && target instanceof LivingEntity) {
            ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 500, 2), livingEntity);
        }
    }

}
