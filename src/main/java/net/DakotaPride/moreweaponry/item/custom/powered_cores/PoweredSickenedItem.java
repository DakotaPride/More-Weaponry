package net.DakotaPride.moreweaponry.item.custom.powered_cores;

import net.DakotaPride.moreweaponry.effect.MoreWeaponryEffects;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
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
        target.addStatusEffect(new StatusEffectInstance(MoreWeaponryEffects.PLAGUED, 200, 2), attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 2), attacker);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText("misc.moreweaponry.core.abilities").formatted(Formatting.GRAY));
        tooltip.add( new TranslatableText("item.moreweaponry.description.sickened_weapon").formatted(Formatting.DARK_GREEN));
    }

}
