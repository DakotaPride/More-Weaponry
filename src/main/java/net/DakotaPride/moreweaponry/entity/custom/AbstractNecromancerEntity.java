package net.DakotaPride.moreweaponry.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.entity.mob.SpellcastingIllagerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class AbstractNecromancerEntity extends IllagerEntity {
    private static final TrackedData<Byte> SPELL = DataTracker.registerData((Class)AbstractNecromancerEntity.class, TrackedDataHandlerRegistry.BYTE);

    protected int spellTicks;
    private AbstractNecromancerEntity.NecromancerSpell spell = AbstractNecromancerEntity.NecromancerSpell.NONE;

    protected AbstractNecromancerEntity(EntityType<? extends SpellcastingIllagerEntity> entityType, World world) {
        super((EntityType)entityType, world);
    }


    protected void initDataTracker() {
        super.initDataTracker();

        this.dataTracker.startTracking(SPELL, Byte.valueOf((byte)0));
    }

    @Override
    public void addBonusForWave(int wave, boolean unused) {

    }


    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);

        this.spellTicks = nbt.getInt("SpellTicks");
    }

    @Override
    public SoundEvent getCelebratingSound() {
        return null;
    }


    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);

        nbt.putInt("SpellTicks", this.spellTicks);
    }


    public IllagerEntity.State getState() {
        if (isSpellcasting())
            return IllagerEntity.State.SPELLCASTING;
        if (isCelebrating()) {
            return IllagerEntity.State.CELEBRATING;
        }
        return IllagerEntity.State.CROSSED;
    }

    public boolean isSpellcasting() {
        if (this.world.isClient) {
            return (((Byte)this.dataTracker.<Byte>get(SPELL)).byteValue() > 0);
        }
        return (this.spellTicks > 0);
    }

    public void setSpell(NecromancerSpell spell) {
        this.spell = spell;
        this.dataTracker.set(SPELL, (byte) spell.id);
    }

    protected NecromancerSpell getSpell() {
        if (!this.world.isClient) {
            return this.spell;
        }
        return NecromancerSpell.byId((Byte) this.dataTracker.<Byte>get(SPELL));
    }


    protected void mobTick() {
        super.mobTick();

        if (this.spellTicks > 0) {
            this.spellTicks--;
        }
    }


    public void tick() {
        super.tick();

        if (this.world.isClient && isSpellcasting()) {
            AbstractNecromancerEntity.NecromancerSpell spell = getSpell();
            double d = spell.particleVelocity[0];
            double e = spell.particleVelocity[1];
            double f = spell.particleVelocity[2];


            float g = this.bodyYaw * 0.017453292F + MathHelper.cos(this.age * 0.6662F) * 0.25F;
            float h = MathHelper.cos(g);
            float i = MathHelper.sin(g);

            this.world.addParticle(ParticleTypes.ENTITY_EFFECT, getX() + h * 0.6D, getY() + 1.8D, getZ() + i * 0.6D, d, e, f);
            this.world.addParticle(ParticleTypes.ENTITY_EFFECT, getX() - h * 0.6D, getY() + 1.8D, getZ() - i * 0.6D, d, e, f);
        }
    }

    protected int getSpellTicks() {
        return this.spellTicks;
    }

    protected SoundEvent getCastSpellSound() {
        return null;
    }

    protected static class LookAtTargetGoal extends Goal {
        public LookAtTargetGoal(AbstractNecromancerEntity necromancerEntity) {
            setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
        }


      //  public boolean canStart() {
      //      return (this.field_7383.getSpellTicks() > 0);
      //  }


        @Override
        public boolean canStart() {
            return true;
        }

     //   public void start() {
     //       super.start();
     //       AbstractNecromancerEntity.method_7141(this.field_7383).stop();
     //   }


     //   public void stop() {
     //       super.stop();
     //       this.field_7383.setSpell(AbstractNecromancerEntity.NecromancerSpell.NONE);
     //   }


     //   public void tick() {
     //       if (this.field_7383.getTarget() != null)
     //           this.field_7383.getLookControl().lookAt(this.field_7383.getTarget(), this.field_7383.getMaxHeadRotation(), this.field_7383.getMaxLookPitchChange());
     //  }
    }

    protected abstract class CastSpellGoal extends Goal {
        protected int spellCooldown;
        protected int startTime;

        protected CastSpellGoal(AbstractNecromancerEntity AbstractNecromancerEntity) {}

     //   public boolean canStart() {
     //       LivingEntity livingEntity = this.field_7386.getTarget();
     //       if (livingEntity == null || !livingEntity.isAlive()) {
     //          return false;
     //       }
     //       if (this.field_7386.isSpellcasting())
     //       {
     //           return false;
     //       }
     //       if (this.field_7386.age < this.startTime) {
     //           return false;
     //       }
     //       return true;
     //   }


     //   public boolean shouldContinue() {
     //       LivingEntity livingEntity = this.field_7386.getTarget();
     //       return (livingEntity != null && livingEntity.isAlive() && this.spellCooldown > 0);
     //   }


     //   public void start() {
     //       this.spellCooldown = getTickCount(getInitialCooldown());
     //       this.field_7386.spellTicks = getSpellTicks();
     //       this.startTime = this.field_7386.age + startTimeDelay();
     //       SoundEvent soundEvent = getSoundPrepare();
     //       if (soundEvent != null) {
     //           this.field_7386.playSound(soundEvent, 1.0F, 1.0F);
     //       }
     //       this.field_7386.setSpell(getSpell());
     //   }


     //   public void tick() {
     //       this.spellCooldown--;
     //       if (this.spellCooldown == 0) {
     //           castSpell();
     //           this.field_7386.playSound(this.field_7386.getCastSpellSound(), 1.0F, 1.0F);
     //       }
     //   }

        protected abstract void castSpell();

        protected int getInitialCooldown() {
            return 20;
        }

        protected abstract int getSpellTicks();

        protected abstract int startTimeDelay();

        @Nullable
        protected abstract SoundEvent getSoundPrepare();

        protected abstract AbstractNecromancerEntity.NecromancerSpell getSpell();
    }

    protected enum NecromancerSpell {
        NONE(0, 0.0D, 0.0D, 0.0D),
        SUMMON_SKELETON(1, 0.7D, 0.7D, 0.8D),
        SUMMON_ARMORED_SKELETON(2, 0.7D, 0.7D, 0.8D);

        final int id;

        final double[] particleVelocity;

        NecromancerSpell(int id, double particleVelocityX, double particleVelocityY, double particleVelocityZ) {
            this.id = id;
            this.particleVelocity = new double[] { particleVelocityX, particleVelocityY, particleVelocityZ };
        }

        public static AbstractNecromancerEntity.NecromancerSpell byId(int id) {
            for (AbstractNecromancerEntity.NecromancerSpell necromancerSpell : values()) {
                if (id == necromancerSpell.id) {
                    return necromancerSpell;
                }
            }
            return NONE;
        }
    }
}
