package net.DakotaPride.moreweaponry.common.item.items.powered_cores;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PoweredSickenedItem extends Item {
    public PoweredSickenedItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(MoreWeaponry.PLAGUED, 200, 2), attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 2), attacker);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("misc.moreweaponry.core.abilities").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.moreweaponry.description.sickened_weapon").formatted(Formatting.DARK_GREEN));
    }

}
