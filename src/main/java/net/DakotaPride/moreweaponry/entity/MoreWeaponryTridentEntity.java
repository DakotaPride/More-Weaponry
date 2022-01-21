package net.DakotaPride.moreweaponry.entity;

import net.DakotaPride.moreweaponry.mixin.TridentEntityAccessor;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class MoreWeaponryTridentEntity extends TridentEntity {

    public void setTridentAttributes(World world, LivingEntity owner, ItemStack stack) {
        this.setTridentStack(stack.copy());
        this.dataTracker.set(TridentEntityAccessor.impaled$getLoyalty(), (byte) EnchantmentHelper.getLoyalty(stack));
        this.dataTracker.set(TridentEntityAccessor.impaled$getEnchanted(), stack.hasGlint());
    }

    public MoreWeaponryTridentEntity(EntityType<? extends MoreWeaponryTridentEntity> entityType, World world) {
        super(entityType, world);
    }

    protected float getDragInWater() {
        return 0.99f;
    }

    public void setTridentStack(ItemStack tridentStack) {
        ((TridentEntityAccessor) this).impaled$setTridentStack(tridentStack);
    }

    public ItemStack getTridentStack() {
        return ((TridentEntityAccessor) this).impaled$getTridentStack();
    }

    protected void setDealtDamage(boolean dealtDamage) {
        ((TridentEntityAccessor) this).impaled$setDealtDamage(dealtDamage);
    }

    protected boolean hasDealtDamage() {
        return ((TridentEntityAccessor) this).impaled$hasDealtDamage();
    }

    protected Consumer<ItemStack> getStackFetcher() {
        return null;
    }
}
