package net.DakotaPride.moreweaponry.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.HostileEntity;
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
        this.goalSelector.add(2, new WanderAroundPointOfInterestGoal(this, 0.75f, false));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(7, new MeleeAttackGoal(this, 1.0D, false));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
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

    protected void mobTick() {
        if (this.world.isDay() && this.age >= this.ageWhenTargetSet + 600) {
            float f = getBrightnessAtEyes();
            if (f > 0.5F &&
                    this.world.isSkyVisible(getBlockPos()) && this.random.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
                setTarget((LivingEntity)null);
                teleportRandomly();
            }
        }


        super.mobTick();
    }

    protected boolean teleportRandomly() {
        if (this.world.isClient() || !isAlive()) {
            return false;
        }

        double d = getX() + (this.random.nextDouble() - 0.5D) * 64.0D;
        double e = getY() + (this.random.nextInt(64) - 32);
        double f = getZ() + (this.random.nextDouble() - 0.5D) * 64.0D;
        return teleportTo(d, e, f);
    }

    boolean teleportTo(Entity entity) {
        Vec3d vec3d = new Vec3d(getX() - entity.getX(), getBodyY(0.5D) - entity.getEyeY(), getZ() - entity.getZ());
        vec3d = vec3d.normalize();
        double d = 16.0D;
        double e = getX() + (this.random.nextDouble() - 0.5D) * 8.0D - vec3d.x * 16.0D;
        double f = getY() + (this.random.nextInt(16) - 8) - vec3d.y * 16.0D;
        double g = getZ() + (this.random.nextDouble() - 0.5D) * 8.0D - vec3d.z * 16.0D;
        return teleportTo(e, f, g);
    }

    private boolean teleportTo(double x, double y, double z) {
        BlockPos.Mutable mutable = new BlockPos.Mutable(x, y, z);
        while (mutable.getY() > this.world.getBottomY() && !this.world.getBlockState(mutable).getMaterial().blocksMovement()) {
            mutable.move(Direction.DOWN);
        }
        BlockState blockState = this.world.getBlockState(mutable);
        boolean bl = blockState.getMaterial().blocksMovement();
        boolean bl2 = blockState.getFluidState().isIn(FluidTags.WATER);
        if (!bl || bl2) {
            return false;
        }

        boolean bl3 = teleport(x, y, z, true);
        if (bl3 &&
                !isSilent()) {
            this.world.playSound((PlayerEntity)null, this.prevX, this.prevY, this.prevZ, SoundEvents.ENTITY_ENDERMAN_TELEPORT, getSoundCategory(), 1.0F, 1.0F);
            playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
        }


        return bl3;
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
