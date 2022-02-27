package net.DakotaPride.moreweaponry.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WeakEssenceItem extends Item {
    public WeakEssenceItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.PARTICLE_SOUL_ESCAPE, 2.0F, 1.0F);
        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200, 0), playerEntity);
        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 0), playerEntity);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }


}
