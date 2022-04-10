package net.DakotaPride.moreweaponry.entity.custom;

import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.DakotaPride.moreweaponry.effect.MoreWeaponryEffects;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class WatcherEntity extends HostileEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private final ServerBossBar bossBar;
    public WatcherEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.ignoreCameraFrustum = true;
        this.bossBar = (ServerBossBar)(new ServerBossBar(new TranslatableText("entity.moreweaponry.watcher"),
                BossBar.Color.PURPLE, BossBar.Style.PROGRESS)).setDragonMusic(false).setThickenFog(false);
        this.stepHeight = 1.0F;

        setPathfindingPenalty(PathNodeType.WATER, -1.0F);

    }

    @Override
    public boolean canHaveStatusEffect(StatusEffectInstance effect) {
        StatusEffect statusEffect = effect.getEffectType();
        return statusEffect
                != StatusEffects.POISON && statusEffect
                != MoreWeaponryEffects.SICKENED && statusEffect
                != MoreWeaponryEffects.PLAGUED && statusEffect
                != MoreWeaponryEffects.CRACKLER && statusEffect
                != MoreWeaponryEffects.EXPLOSIVE && statusEffect
                != MoreWeaponryEffects.BARD && statusEffect
                != MoreWeaponryEffects.SIREN && statusEffect
                != MoreWeaponryEffects.WANDERER && statusEffect
                != MoreWeaponryEffects.WEBBED && statusEffect
                != MoreWeaponryEffects.WATCHER && statusEffect
                != MoreWeaponryEffects.TICKED && statusEffect
                != MoreWeaponryEffects.NUMBED && statusEffect
                != StatusEffects.WITHER && statusEffect
                != StatusEffects.LEVITATION && statusEffect
                != StatusEffects.GLOWING && statusEffect
                != StatusEffects.UNLUCK && statusEffect
                != StatusEffects.MINING_FATIGUE && statusEffect
                != StatusEffects.HUNGER;
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
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 917.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 25.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.40f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 206.0D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.96f);
    }

    public void dropEquipment(DamageSource source, int lootingMultiplier, boolean allowDrops) {
        super.dropEquipment(source, lootingMultiplier, allowDrops);
        Entity entity = source.getAttacker();
        if (entity instanceof CreeperEntity) {
            CreeperEntity creeperEntity = (CreeperEntity)entity;
            if (creeperEntity.shouldDropHead()) {
                creeperEntity.onHeadDropped();
                dropItem(MoreWeaponryBlocks.WATCHER_SKULL.asItem());
            }
        }
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D, 0.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));

        this.goalSelector.add(12, new RevengeGoal(this, PlayerEntity.class));
        this.goalSelector.add(13, new RevengeGoal(this, WandererEntity.class));
        this.goalSelector.add(15, new RevengeGoal(this, CracklerEntity.class));
        this.goalSelector.add(19, new RevengeGoal(this, SickenedEntity.class));
        this.goalSelector.add(20, new RevengeGoal(this, SickenedHuskEntity.class));
        this.goalSelector.add(16, new RevengeGoal(this, BardEntity.class));
        this.goalSelector.add(17, new RevengeGoal(this, LurkerEntity.class));
        this.goalSelector.add(18, new RevengeGoal(this, SkeletonEntity.class));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, WandererEntity.class, true, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, CracklerEntity.class, true, false));
        this.targetSelector.add(5, new ActiveTargetGoal<>(this, SickenedEntity.class, true, false));
        this.targetSelector.add(9, new ActiveTargetGoal<>(this, SickenedHuskEntity.class, true, false));
    }

    public boolean hurtByWater() {
        return true;
    }

    public boolean tryAttack(Entity target) {
        if (!super.tryAttack(target)) {
            return false;
        } else {
            if (target instanceof LivingEntity) {
                ((LivingEntity)target).addStatusEffect
                        (new StatusEffectInstance(MoreWeaponryEffects.TICKED, 140), this);
            }

            return true;
        }
    }

    public boolean damage(DamageSource source, float amount) {
        if (source.getAttacker() != null && !source.isProjectile() && source.getAttacker() instanceof LivingEntity) {
            LivingEntity attacker = (LivingEntity) source.getAttacker();
            attacker.addStatusEffect(new StatusEffectInstance(MoreWeaponryEffects.TICKED, 100), this);
        }

        return super.damage(source, amount);
    }

    protected int getXpToDrop(PlayerEntity player) {
        if (isBaby()) {
            this.experiencePoints = (int)(this.experiencePoints * 43.5F);
        }

        return super.getXpToDrop(player);
    }

    protected boolean shouldDropLoot() {
        return true;
    }

    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 3.5F;
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
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.watcher.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.watcher.idle", true));
        return PlayState.CONTINUE;
    }
}
