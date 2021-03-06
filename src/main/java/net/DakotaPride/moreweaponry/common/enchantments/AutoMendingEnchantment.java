package net.DakotaPride.moreweaponry.common.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class AutoMendingEnchantment extends Enchantment {
    public AutoMendingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }


    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return super.isAcceptableItem(stack);
    }


    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient()) {
            ServerWorld world = ((ServerWorld) user.world);
            BlockPos position = target.getBlockPos();

            if (target instanceof LivingEntity) {
                if(level == 1) {
                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);
                }

                if(level == 2) {
                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);
                }

                if(level == 3) {
                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);
                }

                if(level == 4) {
                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);
                }

                if(level == 5) {
                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);
                }

                if(level == 6) {
                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.EXPERIENCE_BOTTLE.spawn(world, null, null, null, position,
                            SpawnReason.TRIGGERED, true, true);
                }
            }
        }

        super.onTargetDamaged(user, target, level);
    }


    @Override
    public int getMaxLevel() {
        return 6;
    }
}
