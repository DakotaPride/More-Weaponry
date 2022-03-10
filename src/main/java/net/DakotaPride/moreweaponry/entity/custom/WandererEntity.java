package net.DakotaPride.moreweaponry.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.EndermiteEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class WandererEntity extends HostileEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    public WandererEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 1200.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 36.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.37)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 186.0D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.92f);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D, 0.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true, false));
    }

    private static class AttackGoal extends MeleeAttackGoal {
        public AttackGoal(WandererEntity wandererEntity) {
            super(wandererEntity, 1.0D, true);
        }

        public boolean canStart() {
            return (super.canStart() && !this.mob.hasPassengers());
        }


        public boolean shouldContinue() {
            float f = this.mob.getBrightnessAtEyes();
            if (f >= 0.5F && this.mob.getRandom().nextInt(100) == 0) {
                this.mob.setTarget((LivingEntity)null);
                return false;
            }
            return super.shouldContinue();
        }


        protected double getSquaredMaxAttackDistance(LivingEntity entity) {
            return (4.0F + entity.getWidth());
        }

    }

    private static class TargetGoal<T extends LivingEntity> extends ActiveTargetGoal<T> {
        public TargetGoal(WandererEntity wandererEntity, Class<T> targetEntityClass) {
            super(wandererEntity, targetEntityClass, true);
        }


        public boolean canStart() {
            float f = this.mob.getBrightnessAtEyes();
            if (f >= 0.5F) {
                return false;
            }

            return super.canStart();
        }
    }


    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wanderer.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wanderer.idle", true));
        return PlayState.CONTINUE;
    }
}
