package net.DakotaPride.moreweaponry.common.enchantments;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class BleedingEnchantment extends Enchantment {
    public BleedingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }


    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return super.isAcceptableItem(stack);
    }


    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient()) {
            if(level == 1) {
                if (target instanceof LivingEntity) {
                    ((LivingEntity) target).addStatusEffect
                            (new StatusEffectInstance(MoreWeaponry.BLEEDING, 20 * 4 * level, 0));
                }
            }

            if(level == 2) {
                if (target instanceof LivingEntity) {
                    ((LivingEntity) target).addStatusEffect
                            (new StatusEffectInstance(MoreWeaponry.BLEEDING, 20 * 8 * level, 1));
                }
            }

            if(level == 3) {
                if (target instanceof LivingEntity) {
                    ((LivingEntity) target).addStatusEffect
                            (new StatusEffectInstance(MoreWeaponry.BLEEDING, 20 * 12 * level, 2));
                }
            }
        }

        super.onTargetDamaged(user, target, level);
    }



    @Override
    public int getMaxLevel() {
        return 3;
    }

}
