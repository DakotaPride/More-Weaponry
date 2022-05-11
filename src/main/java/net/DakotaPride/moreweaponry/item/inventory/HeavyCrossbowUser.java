package net.DakotaPride.moreweaponry.item.inventory;

import net.DakotaPride.moreweaponry.item.items.HeavyCrossBowItem;
import net.DakotaPride.moreweaponry.item.MoreWeaponryItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3f;
import org.jetbrains.annotations.Nullable;

public interface HeavyCrossbowUser extends RangedAttackMob
{
    void setCharging(boolean paramBoolean);

    void shoot(LivingEntity paramLivingEntity, ItemStack paramItemStack, ProjectileEntity paramProjectileEntity, float paramFloat);

    @Nullable
    LivingEntity getTarget();

    void postShoot();

    default void shoot(LivingEntity entity, float speed) {
        Hand hand = ProjectileUtil.getHandPossiblyHolding(entity, MoreWeaponryItems.HEAVY_CROSSBOW);
        ItemStack itemStack = entity.getStackInHand(hand);
        if (entity.isHolding(MoreWeaponryItems.HEAVY_CROSSBOW)) {
            HeavyCrossBowItem.shootAll(entity.world, entity, hand, itemStack, speed, (14 - entity.world.getDifficulty().getId() * 4));
        }
        postShoot();
    }

    default void shoot(LivingEntity entity, LivingEntity target, ProjectileEntity projectile, float multishotSpray, float speed) {
        Entity entity2 = projectile;
        double d = target.getX() - entity.getX();
        double e = target.getZ() - entity.getZ();
        double f = Math.sqrt(d * d + e * e);
        double g = target.getBodyY(0.3333333333333333D) - entity2.getY() + f * 0.20000000298023224D;

        Vec3f vec3f = getProjectileLaunchVelocity(entity, new Vec3d(d, g, e), multishotSpray);
        projectile.setVelocity(vec3f.getX(), vec3f.getY(), vec3f.getZ(), speed, (14 - entity.world.getDifficulty().getId() * 4));
        entity.playSound(SoundEvents.ITEM_CROSSBOW_SHOOT, 1.0F, 1.0F / (entity.getRandom().nextFloat() * 0.4F + 0.8F));
    }

    default Vec3f getProjectileLaunchVelocity(LivingEntity entity, Vec3d positionDelta, float multishotSpray) {
        Vec3d vec3d = positionDelta.normalize();
        Vec3d vec3d2 = vec3d.crossProduct(new Vec3d(0.0D, 1.0D, 0.0D));
        if (vec3d2.lengthSquared() <= 1.0E-7D) {
            vec3d2 = vec3d.crossProduct(entity.getOppositeRotationVector(1.0F));
        }

        Quaternion quaternion = new Quaternion(new Vec3f(vec3d2), 90.0F, true);
        Vec3f vec3f = new Vec3f(vec3d);
        vec3f.rotate(quaternion);

        Quaternion quaternion2 = new Quaternion(vec3f, multishotSpray, true);
        Vec3f vec3f2 = new Vec3f(vec3d);
        vec3f2.rotate(quaternion2);
        return vec3f2;
    }
}
