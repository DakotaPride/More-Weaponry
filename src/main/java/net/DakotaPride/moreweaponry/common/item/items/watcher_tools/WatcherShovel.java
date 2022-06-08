package net.DakotaPride.moreweaponry.common.item.items.watcher_tools;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WatcherShovel extends ShovelItem {
    public WatcherShovel(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200, 2), attacker);
        // target.addStatusEffect(new StatusEffectInstance(StatusEffect.DARKNESS, 200, 2, attacker));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200, 2), attacker);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.moreweaponry.description.watcher_weapon").formatted(Formatting.LIGHT_PURPLE));
    }

}
