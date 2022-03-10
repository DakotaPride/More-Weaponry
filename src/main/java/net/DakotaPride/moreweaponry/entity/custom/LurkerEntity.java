package net.DakotaPride.moreweaponry.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.UUID;

public class LurkerEntity extends HostileEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private UUID targetUuid;
    private int lastAngrySoundAge;
    private int ageWhenTargetSet;

    public LurkerEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.stepHeight = 1.0F;

        setPathfindingPenalty(PathNodeType.WATER, -1.0F);

    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 450.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 16.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 72.0D);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D, 0.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));

        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, PlayerEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, SpiderEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, CaveSpiderEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, ZombieEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, HuskEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, DrownedEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, SkeletonEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, StrayEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, SkeletonHorseEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, HorseEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, MuleEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, PillagerEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, EvokerEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, RavagerEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, VexEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, PigEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, PiglinEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, ZombifiedPiglinEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, HoglinEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, CowEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, SheepEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, CreeperEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, RabbitEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, PolarBearEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, FoxEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, BatEntity.class));
      //  this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, WardenEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, GuardianEntity.class));
        this.targetSelector.add(2, new LurkerEntity.TargetGoal<>(this, ElderGuardianEntity.class));
    }

    private static class TargetGoal<T extends LivingEntity> extends ActiveTargetGoal<T> {
        public TargetGoal(LurkerEntity lurkerEntity, Class<T> targetEntityClass) {
            super(lurkerEntity, targetEntityClass, true);
        }


        public boolean canStart() {
            float f = this.mob.getBrightnessAtEyes();
            if (f >= 0.5F) {
                return false;
            }

            return super.canStart();
        }
    }

    @Nullable
    public UUID getAngryAt() {
        return this.targetUuid;
    }

    public void playAngrySound() {
        if (this.age >= this.lastAngrySoundAge + 400) {
            this.lastAngrySoundAge = this.age;
            if (!isSilent()) {
                this.world.playSound(getX(), getEyeY(), getZ(), SoundEvents.ENTITY_ENDERMAN_STARE, getSoundCategory(), 2.5F, 1.0F, true);
            }
        }
    }

    public boolean hurtByWater() {
        return true;
    }

    protected int getXpToDrop(PlayerEntity player) {
        if (isBaby()) {
            this.experiencePoints = (int)(this.experiencePoints * 24.0F);
        }

        return super.getXpToDrop(player);
    }

    protected boolean shouldDropLoot() {
        return true;
    }

    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 1.8F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ENDERMAN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_ENDERMAN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ENDERMAN_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.BLOCK_STONE_STEP, 0.15f, 1.0f);
    }

    @Nullable
    public HostileEntity createChild(ServerWorld world, HostileEntity entity) {
        return null;
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
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.lurker.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.lurker.idle", true));
        return PlayState.CONTINUE;
    }
}
