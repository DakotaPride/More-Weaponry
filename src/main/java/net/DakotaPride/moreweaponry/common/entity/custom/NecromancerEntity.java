package net.DakotaPride.moreweaponry.common.entity.custom;

import net.DakotaPride.moreweaponry.common.entity.custom.abstract_cases.AbstractNecromancerEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class NecromancerEntity extends AbstractNecromancerEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private final ServerBossBar bossBar;
    public NecromancerEntity(EntityType<? extends AbstractNecromancerEntity> entityType, World world) {
        super(entityType, world);

        this.bossBar = (ServerBossBar)(new ServerBossBar(Text.translatable("entity.moreweaponry.necromancer"),
                BossBar.Color.PURPLE, BossBar.Style.PROGRESS)).setDragonMusic(false).setThickenFog(false);

    }


    @Override
    protected void initGoals() {
        super.initGoals();
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 932.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 26.5f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.32f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 87.0D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.97f);
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

    protected int getXpToDrop(PlayerEntity player) {
        if (!isBaby()) {
            this.experiencePoints = (int)(this.experiencePoints * 45.7F);
        }

        return super.getXpToDrop();
    }

    protected void mobTick() {
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }

    protected boolean shouldDropLoot() {
        return true;
    }

    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 1.76F;
    }

 //   @Override
    protected SoundEvent getCastSpellSound() {
        return SoundEvents.ENTITY_ILLUSIONER_CAST_SPELL;
    }

//    @Override
    public void addBonusForWave(int wave, boolean unused) {

    }

 //   @Override
    public SoundEvent getCelebratingSound() {
        return SoundEvents.ENTITY_FIREWORK_ROCKET_BLAST;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_EVOKER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_EVOKER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_EVOKER_DEATH;
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
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.necromancer.walk", true));
            return PlayState.CONTINUE;
        } if (this.isSpellcasting()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.necromancer.spellcasting", false));
            return PlayState.CONTINUE;
        }
        else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.necromancer.idle", true));
            return PlayState.CONTINUE;
        }
    }

}
