package net.DakotaPride.moreweaponry.common.entity.custom;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.abstract_cases.AbstractHostileEntity;
import net.DakotaPride.moreweaponry.common.entity.damage.MoreWeaponryDamageSource;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class SickenedEntity extends AbstractHostileEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private final ServerBossBar bossBar;
    public SickenedEntity(EntityType<? extends AbstractHostileEntity> entityType, World world) {
        super(entityType, world);

        this.bossBar = (ServerBossBar)(new ServerBossBar(Text.translatable("entity.moreweaponry.sickened"),
                BossBar.Color.GREEN, BossBar.Style.PROGRESS)).setDragonMusic(false).setThickenFog(false);

    }

    public boolean damage(DamageSource source, float amount) {
        if (source.getAttacker() != null && source.isProjectile() && source.getAttacker() instanceof LivingEntity) {
            LivingEntity attacker = (LivingEntity) source.getAttacker();
            attacker.damage(MoreWeaponryDamageSource.CELESTIALITE, 0.0F);
            attacker.addStatusEffect(new StatusEffectInstance(MoreWeaponry.PLAGUED, 100), this);
        }

        return super.damage(source, amount);
    }

    @Override
    public boolean canHaveStatusEffect(StatusEffectInstance effect) {
        StatusEffect statusEffect = effect.getEffectType();
        return statusEffect
                != StatusEffects.POISON && statusEffect
                != MoreWeaponry.SICKENED && statusEffect
                != MoreWeaponry.PLAGUED && statusEffect
                != StatusEffects.HUNGER;
    }

    public boolean tryAttack(Entity target) {
        if (!super.tryAttack(target)) {
            return false;
        } else {
            if (target instanceof LivingEntity) {
                ((LivingEntity)target).addStatusEffect
                        (new StatusEffectInstance(MoreWeaponry.PLAGUED, 140), this);
            }

            return true;
        }
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
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 700.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 14.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 186.0D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.96f);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D, 0.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.goalSelector.add(6, new LookAtEntityGoal(this, (Class) PlayerEntity.class, 8.0F));

        this.goalSelector.add(12, new RevengeGoal(this, PlayerEntity.class));
        this.goalSelector.add(13, new RevengeGoal(this, WandererEntity.class));
        this.goalSelector.add(14, new RevengeGoal(this, CracklerEntity.class));
        this.goalSelector.add(15, new RevengeGoal(this, WatcherEntity.class));
        this.goalSelector.add(16, new RevengeGoal(this, BardEntity.class));
        this.goalSelector.add(17, new RevengeGoal(this, LurkerEntity.class));
        this.goalSelector.add(18, new RevengeGoal(this, SkeletonEntity.class));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, WandererEntity.class, true, false));
        this.targetSelector.add(4, new ActiveTargetGoal<>(this, CracklerEntity.class, true, false));
        this.targetSelector.add(5, new ActiveTargetGoal<>(this, WatcherEntity.class, true, false));
        this.targetSelector.add(9, new ActiveTargetGoal<>(this, BardEntity.class, true,false));
        this.targetSelector.add(10, new ActiveTargetGoal<>(this, LurkerEntity.class, true, false));

    }

    public void tickMovement() {
        super.tickMovement();
        if (!this.world.isClient) {
            int i = MathHelper.floor(this.getX());
            int j = MathHelper.floor(this.getY());
            int k = MathHelper.floor(this.getZ());
            BlockPos blockPos = new BlockPos(i, j - 1, k);

            if (!this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                return;
            }

            BlockState blockState = MoreWeaponry.INTOXICATED_GRASS_BLOCK.getDefaultState();
            BlockState blockState1 = MoreWeaponry.INTOXICATED_STONE.getDefaultState();

            for(int l = 0; l < 4; ++l) {
                i = MathHelper.floor(this.getX() + (double)((float)(l % 2 * 2 - 1) * 0.25F));
                j = MathHelper.floor(this.getY());
                k = MathHelper.floor(this.getZ() + (double)((float)(l / 2 % 2 * 2 - 1) * 0.25F));
                BlockPos blockPos2 = new BlockPos(i, j - 1, k);
                if (this.world.getBlockState(blockPos2).isOf(Blocks.GRASS_BLOCK) && blockState.canPlaceAt(this.world, blockPos2)) {
                    this.world.setBlockState(blockPos2, blockState);
                } if (this.world.getBlockState(blockPos2).isOf(Blocks.STONE) && blockState.canPlaceAt(this.world, blockPos2)) {
                    this.world.setBlockState(blockPos2, blockState1);
                } if (this.world.getBlockState(blockPos2).isOf(Blocks.ANDESITE) && blockState.canPlaceAt(this.world, blockPos2)) {
                    this.world.setBlockState(blockPos2, blockState1);
                } if (this.world.getBlockState(blockPos2).isOf(Blocks.GRANITE) && blockState.canPlaceAt(this.world, blockPos2)) {
                    this.world.setBlockState(blockPos2, blockState1);
                } if (this.world.getBlockState(blockPos2).isOf(Blocks.DIORITE) && blockState.canPlaceAt(this.world, blockPos2)) {
                    this.world.setBlockState(blockPos2, blockState1);
                }
            }
        }
    }

    protected int getXpToDrop(PlayerEntity player) {
        if (!isBaby()) {
            this.experiencePoints = (int)(this.experiencePoints * 43.5F);
        }

        return super.getXpToDrop();
    }

    protected boolean shouldDropLoot() {
        return true;
    }

    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 1.73F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_ZOMBIE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_DEATH;
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
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.sickened.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.sickened.idle", true));
        return PlayState.CONTINUE;
    }

}
