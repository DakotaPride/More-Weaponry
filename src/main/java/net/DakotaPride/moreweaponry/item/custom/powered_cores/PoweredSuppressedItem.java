package net.DakotaPride.moreweaponry.item.custom.powered_cores;

import net.DakotaPride.moreweaponry.item.custom.cores.SuppressedCoreItem;
import net.DakotaPride.moreweaponry.item.custom.cores.WretchedCoreItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PoweredSuppressedItem extends Item {
    public PoweredSuppressedItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 2), attacker);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 2), attacker);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new LiteralText("Abilities").formatted(Formatting.GRAY));
        tooltip.add( new LiteralText("Explosion").formatted(Formatting.GREEN));
    }

}
