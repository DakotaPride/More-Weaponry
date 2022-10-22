package net.DakotaPride.moreweaponry.common.entity.custom;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.abstract_cases.AbstractHostileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class SentienceEntity extends AbstractHostileEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private final ServerBossBar bossBar;

    public SentienceEntity(EntityType<? extends AbstractHostileEntity> entityType, World world) {
        super(entityType, world);

        this.bossBar = (ServerBossBar)(new ServerBossBar(Text.translatable("entity.moreweaponry.sentience"),
                BossBar.Color.BLUE, BossBar.Style.PROGRESS)).setDragonMusic(false).setThickenFog(false);

    }

    @Override
    public boolean canHaveStatusEffect(StatusEffectInstance effect) {
        StatusEffect statusEffect = effect.getEffectType();
        return statusEffect
                != StatusEffects.POISON && statusEffect
                != MoreWeaponry.SICKENED && statusEffect
                != MoreWeaponry.PLAGUED && statusEffect
                != MoreWeaponry.CRACKLER && statusEffect
                != MoreWeaponry.EXPLOSIVE && statusEffect
                != MoreWeaponry.BARD && statusEffect
                != MoreWeaponry.SIREN && statusEffect
                != MoreWeaponry.WANDERER && statusEffect
                != MoreWeaponry.WEBBED && statusEffect
                != MoreWeaponry.WATCHER && statusEffect
                != MoreWeaponry.TICKED && statusEffect
                != MoreWeaponry.NUMBED && statusEffect
                != StatusEffects.WITHER && statusEffect
                != StatusEffects.LEVITATION && statusEffect
                != StatusEffects.GLOWING && statusEffect
                != StatusEffects.UNLUCK && statusEffect
                != StatusEffects.MINING_FATIGUE && statusEffect
                != StatusEffects.HUNGER;
    }

    protected boolean shouldDropLoot() {
        return true;
    }

    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 1.73F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_COW_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SKELETON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SKELETON_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.BLOCK_STONE_STEP, 0.15f, 1.0f);
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
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.sentience.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.sentience.idle", true));
        return PlayState.CONTINUE;
    }
}
