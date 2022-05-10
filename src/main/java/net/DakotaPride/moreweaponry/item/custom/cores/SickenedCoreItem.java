package net.DakotaPride.moreweaponry.item.custom.cores;

import net.DakotaPride.moreweaponry.effect.MoreWeaponryEffects;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SickenedCoreItem extends Item {
    public SickenedCoreItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.PARTICLE_SOUL_ESCAPE, 2.0F, 1.0F);
        playerEntity.addStatusEffect(new StatusEffectInstance(MoreWeaponryEffects.SICKENED, 200, 0), playerEntity);
        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200, 0), playerEntity);
        playerEntity.getItemCooldownManager().set(this, 200);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText("item.moreweaponry.core.sickened").formatted(Formatting.DARK_GREEN));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

}
