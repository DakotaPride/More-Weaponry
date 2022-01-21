package net.DakotaPride.moreweaponry.entity;

import net.DakotaPride.moreweaponry.item.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ElderScaleTridentEntity extends MoreWeaponryTridentEntity {

    private boolean hasSearchedTarget;
    private Entity closestTarget;

    public ElderScaleTridentEntity(EntityType<? extends MoreWeaponryTridentEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Consumer<ItemStack> getStackFetcher() {
        Entity owner = this.getOwner();
        if (owner != null) {
            return stack -> {
                if (owner.isAlive()) {
                    if (!(owner instanceof PlayerEntity) || !((PlayerEntity) owner).getInventory().insertStack(stack)) {
                        owner.dropStack(stack);
                    }
                } else {
                    this.dropStack(stack);
                }
            };
        }
        return super.getStackFetcher();
    }

    @Override
    public void tick() {
        if (this.hasDealtDamage()) {
            if (this.isSubmergedInWater()) {
                this.playSound(SoundEvents.ENTITY_GUARDIAN_DEATH, 1.0f, 1.0f);
            } else {
                this.playSound(SoundEvents.ENTITY_GUARDIAN_DEATH_LAND, 1.0f, 1.0f);
            }

            for (int i = 0; i < 20; i++) {
                this.world.addParticle(ParticleTypes.BUBBLE_POP, this.getX()+this.random.nextGaussian()/10, this.getY()+this.random.nextGaussian()/10, this.getZ()+this.random.nextGaussian()/10, this.random.nextGaussian()/10, Math.abs(this.random.nextGaussian()/10), this.random.nextGaussian()/10);
            }

            this.remove(RemovalReason.DISCARDED);
        }

        if (!this.hasSearchedTarget) {
            if (this.getOwner() != null) {
                Vec3d rotationVec = this.getOwner().getRotationVector();
                Box box = new Box(this.getX() - 1, this.getY() - 1, this.getZ() - 1, this.getX() + 1, this.getY() + 1, this.getZ() + 1).expand(96 * rotationVec.getX(), 96 * rotationVec.getY(), 96 * rotationVec.getZ());
                List<Entity> possibleTargets = world.getEntitiesByClass(Entity.class, box, (entity) -> entity.collides() && entity != this.getOwner() && !(entity instanceof TameableEntity && ((TameableEntity) entity).isTamed()) && !(entity instanceof TridentEntity));
                List<Entity> validTargets = new ArrayList<>();

                double max = 0.3;
                for (Entity possibleTarget : possibleTargets) {
                    Vec3d vecDist = possibleTarget.getPos().subtract(this.getOwner().getPos());
                    double dotProduct = vecDist.normalize().dotProduct(rotationVec);
                    if (dotProduct > max) {
                        validTargets.add(possibleTarget);
                    }
                }

                if (!validTargets.isEmpty()) {
                    this.closestTarget = validTargets.get(this.random.nextInt(validTargets.size()));
                }

                this.hasSearchedTarget = true;
            }
        } else {
            super.tick();
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if (!this.isOwner(entityHitResult.getEntity())) {
            super.onEntityHit(entityHitResult);
        }
    }

    @Override
    public boolean collidesWith(Entity other) {
        return super.collidesWith(other) && !this.isOwner(other);
    }

    @Override
    public boolean isEnchanted() {
        return false;
    }
}
