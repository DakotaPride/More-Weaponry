package net.DakotaPride.moreweaponry.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class CracklerEntity extends HostileEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private final ServerBossBar bossBar;
    public CracklerEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);

        this.bossBar = (ServerBossBar)(new ServerBossBar(new LiteralText("Crackler"),
                BossBar.Color.GREEN, BossBar.Style.NOTCHED_10)).setDragonMusic(false).setThickenFog(false);

    }

    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (this.hasCustomName()) {
            this.bossBar.setName(this.getDisplayName());
        }

    }

    protected void mobTick() {
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }


    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 1250.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 40.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 192.0D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.0f);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D, 0.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.goalSelector.add(6, new LookAtEntityGoal(this, (Class)PlayerEntity.class, 8.0F));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, LurkerEntity.class, true, false));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, WatcherEntity.class, true, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, WandererEntity.class, true, false));
    }

    private static class AttackGoal extends MeleeAttackGoal {
        public AttackGoal(CracklerEntity cracklerEntity) {
            super(cracklerEntity, 1.0D, true);
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
        public TargetGoal(CracklerEntity cracklerEntity, Class<T> targetEntityClass) {
            super(cracklerEntity, targetEntityClass, true);
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
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CREEPER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CREEPER_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.BLOCK_STONE_STEP, 0.15f, 1.0f);
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.crackler.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.crackler.idle", true));
        return PlayState.CONTINUE;
    }

}
