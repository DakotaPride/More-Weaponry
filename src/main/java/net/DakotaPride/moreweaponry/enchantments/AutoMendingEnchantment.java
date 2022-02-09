package net.DakotaPride.moreweaponry.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class AutoMendingEnchantment extends Enchantment {
    public AutoMendingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient()) {
            ServerWorld world = ((ServerWorld) user.world);
            BlockPos position = target.getBlockPos();

            if(level == 1) {
                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
            }

            if(level == 2) {
                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);

                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
            }

            if(level == 3) {
                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);

                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);

                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
            }

            if(level == 4) {
                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);

                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);

                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);

                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
            }

            if(level == 5) {
                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);

                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);

                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);

                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);

                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
            }

            if(level == 6) {
                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);

                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);

                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);

                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);

                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);

                EntityType.EXPERIENCE_ORB.spawn(world, null, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
            }
        }

        super.onTargetDamaged(user, target, level);
    }


    @Override
    public int getMaxLevel() {
        return 5;
    }
}
