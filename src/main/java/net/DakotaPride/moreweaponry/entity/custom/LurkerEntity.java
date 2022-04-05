package net.DakotaPride.moreweaponry.entity.custom;

import net.DakotaPride.moreweaponry.effect.MoreWeaponryEffects;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
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

    public boolean tryAttack(Entity target) {
        if (!super.tryAttack(target)) {
            return false;
        } else {
            if (target instanceof LivingEntity) {
                ((LivingEntity)target).addStatusEffect
                        (new StatusEffectInstance(MoreWeaponryEffects.NUMBED, 100), this);
            }

            return true;
        }
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 850.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 22.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.22f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 84.0D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.85f);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.0D, 0.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(5, new ActiveTargetGoal<>(this, PlayerEntity.class, true, false));
        this.targetSelector.add(6, new ActiveTargetGoal<>(this, SpiderEntity.class, true, false));
        this.targetSelector.add(7, new ActiveTargetGoal<>(this, CaveSpiderEntity.class, true, false));
        this.targetSelector.add(8, new ActiveTargetGoal<>(this, ZombieEntity.class, true, false));
        this.targetSelector.add(9, new ActiveTargetGoal<>(this, HuskEntity.class, true, false));
        this.targetSelector.add(10, new ActiveTargetGoal<>(this, DrownedEntity.class, true, false));
        this.targetSelector.add(11, new ActiveTargetGoal<>(this, SkeletonEntity.class, true, false));
        this.targetSelector.add(12, new ActiveTargetGoal<>(this, StrayEntity.class, true, false));
        this.targetSelector.add(13, new ActiveTargetGoal<>(this, SkeletonHorseEntity.class, true, false));
        this.targetSelector.add(14, new ActiveTargetGoal<>(this, HorseEntity.class, true, false));
        this.targetSelector.add(15, new ActiveTargetGoal<>(this, MuleEntity.class, true, false));
        this.targetSelector.add(16, new ActiveTargetGoal<>(this, PillagerEntity.class, true, false));
        this.targetSelector.add(17, new ActiveTargetGoal<>(this, EvokerEntity.class, true, false));
        this.targetSelector.add(18, new ActiveTargetGoal<>(this, RavagerEntity.class, true, false));
        this.targetSelector.add(19, new ActiveTargetGoal<>(this, VexEntity.class, true, false));
        this.targetSelector.add(20, new ActiveTargetGoal<>(this, PigEntity.class, true, false));
        this.targetSelector.add(21, new ActiveTargetGoal<>(this, PiglinEntity.class, true, false));
        this.targetSelector.add(22, new ActiveTargetGoal<>(this, ZombifiedPiglinEntity.class, true, false));
        this.targetSelector.add(23, new ActiveTargetGoal<>(this, HoglinEntity.class, true, false));
        this.targetSelector.add(24, new ActiveTargetGoal<>(this, CowEntity.class, true, false));
        this.targetSelector.add(25, new ActiveTargetGoal<>(this, SheepEntity.class, true, false));
        this.targetSelector.add(26, new ActiveTargetGoal<>(this, CreeperEntity.class, true, false));
        this.targetSelector.add(27, new ActiveTargetGoal<>(this, RabbitEntity.class, true, false));
        this.targetSelector.add(28, new ActiveTargetGoal<>(this, PolarBearEntity.class, true, false));
        this.targetSelector.add(29, new ActiveTargetGoal<>(this, FoxEntity.class, true, false));
        this.targetSelector.add(30, new ActiveTargetGoal<>(this, BatEntity.class, true, false));
      //  this.targetSelector.add(31, new ActiveTargetGoal<>(this, WardenEntity.class, true, false));
        this.targetSelector.add(32, new ActiveTargetGoal<>(this, GuardianEntity.class, true, false));
        this.targetSelector.add(33, new ActiveTargetGoal<>(this, ElderGuardianEntity.class, true, false));
        this.targetSelector.add(34, new ActiveTargetGoal<>(this, OcelotEntity.class, true, false));
        this.targetSelector.add(35, new ActiveTargetGoal<>(this, CatEntity.class, true, false));
        this.targetSelector.add(36, new ActiveTargetGoal<>(this, WolfEntity.class, true, false));
        this.targetSelector.add(34, new ActiveTargetGoal<>(this, ZombieHorseEntity.class, true, false));
        this.targetSelector.add(34, new ActiveTargetGoal<>(this, PandaEntity.class, true, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, WandererEntity.class, true, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, CracklerEntity.class, true, false));
        this.targetSelector.add(6, new ActiveTargetGoal<>(this, EndermiteEntity.class, true, false));
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
