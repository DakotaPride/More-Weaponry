package net.DakotaPride.moreweaponry.entity.custom;

import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.EvokerEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class NecromancerEntity extends EvokerEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private final ServerBossBar bossBar;
    public NecromancerEntity(EntityType<? extends EvokerEntity> entityType, World world) {
        super(entityType, world);

        this.bossBar = (ServerBossBar)(new ServerBossBar(new TranslatableText("entity.moreweaponry.necromancer"),
                BossBar.Color.PURPLE, BossBar.Style.PROGRESS)).setDragonMusic(false).setThickenFog(false);

    }


    @Override
    protected void initGoals() {
      //  this.goalSelector.add(4, new SummonSkeletonGoal(this));
     //   this.goalSelector.add(5, new SummonArmoredSkeletonGoal(this));
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


 //   private class SummonSkeletonGoal extends AbstractNecromancerEntity.CastSpellGoal { SummonSkeletonGoal(NecromancerEntity necromancerEntity) {
 //       super(necromancerEntity);
  //      this.closeVexPredicate = TargetPredicate.createNonAttackable().setBaseMaxDistance(16.0D).ignoreVisibility().ignoreDistanceScalingFactor();
 //   }
  //      private final TargetPredicate closeVexPredicate;
   //     public boolean canStart() {
     //       if (!super.canStart()) {
     //           return false;
      //      }


       //     int i = this.field_7267.world.<VexEntity>getTargets(SkeletonEntity.class, this.closeVexPredicate, this.field_7267, this.field_7267.getBoundingBox().expand(16.0D)).size();
       //     return (EvokerEntity.method_7038(this.field_7267).nextInt(8) + 1 > i);
      //  }


        protected int getSpellTicks() {
            return 100;
        }


        protected int startTimeDelay() {
            return 340;
        }


        protected void castSpell() {
       //     ServerWorld serverWorld = (ServerWorld)this.field_7267.world;
       //     for (int i = 0; i < 3; i++) {
       //         BlockPos blockPos = this.field_7267.getBlockPos().add(-2 + NecromancerEntity.method_7037(this.field_7267).nextInt(5), 1, -2 + NecromancerEntity.method_7043(this.field_7267).nextInt(5));
       //         SkeletonEntity skeletonEntity = EntityType.SKELETON.create(this.field_7267.world);
       //         skeletonEntity.refreshPositionAndAngles(blockPos, 0.0F, 0.0F);
       //         skeletonEntity.initialize(serverWorld, this.field_7267.world.getLocalDifficulty(blockPos), SpawnReason.MOB_SUMMONED, (EntityData)null, (NbtCompound)null);
       //         serverWorld.spawnEntityAndPassengers(skeletonEntity);
       //     }
       }


  //      protected SoundEvent getSoundPrepare() {
   //         return SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON;
   //     }


  //      protected AbstractNecromancerEntity.NecromancerSpell getSpell() {
   //         return NecromancerSpell.SUMMON_SKELETON;
    //    } }

 //   private class SummonArmoredSkeletonGoal extends AbstractNecromancerEntity.CastSpellGoal { SummonArmoredSkeletonGoal(NecromancerEntity necromancerEntity) {
  //      super(necromancerEntity);
  //      this.closeVexPredicate = TargetPredicate.createNonAttackable().setBaseMaxDistance(16.0D).ignoreVisibility().ignoreDistanceScalingFactor();
 //   }
   //     private final TargetPredicate closeVexPredicate;
   //     public boolean canStart() {
    //        if (!super.canStart()) {
    //            return false;
    //        }


    //        int i = this.field_7267.world.<VexEntity>getTargets(SkeletonEntity.class, this.closeVexPredicate, this.field_7267, this.field_7267.getBoundingBox().expand(16.0D)).size();
    //        return (EvokerEntity.method_7038(this.field_7267).nextInt(8) + 1 > i);
     //   }


    //    protected int getSpellTicks() {
    //        return 100;
    //    }


    //    protected int startTimeDelay() {
     //       return 340;
     //   }


    //    protected void castSpell() {
     //       ServerWorld serverWorld = (ServerWorld)this.field_7267.world;
     //       for (int i = 0; i < 3; i++) {
      //          BlockPos blockPos = this.field_7267.getBlockPos().add(-2 + NecromancerEntity.method_7037(this.field_7267).nextInt(5), 1, -2 + NecromancerEntity.method_7043(this.field_7267).nextInt(5));
     //           SkeletonEntity skeletonEntity = EntityType.SKELETON.create(this.field_7267.world);
     //           skeletonEntity.refreshPositionAndAngles(blockPos, 0.0F, 0.0F);
       //         skeletonEntity.initialize(serverWorld, this.field_7267.world.getLocalDifficulty(blockPos), SpawnReason.MOB_SUMMONED, (EntityData)null, (NbtCompound)null);
       //         serverWorld.spawnEntityAndPassengers(skeletonEntity);
        //    }
     //   }


     //   protected SoundEvent getSoundPrepare() {
    //        return SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON;
     //   }


     //   protected AbstractNecromancerEntity.NecromancerSpell getSpell() {
     //       return NecromancerSpell.SUMMON_SKELETON;
     //   } }


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
        if (isBaby()) {
            this.experiencePoints = (int)(this.experiencePoints * 45.7F);
        }

        return super.getXpToDrop(player);
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
