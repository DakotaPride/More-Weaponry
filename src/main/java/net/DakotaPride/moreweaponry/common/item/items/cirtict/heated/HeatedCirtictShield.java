package net.DakotaPride.moreweaponry.common.item.items.cirtict.heated;

import net.DakotaPride.moreweaponry.common.item.items.shields.MoreWeaponryShieldItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HeatedCirtictShield extends MoreWeaponryShieldItem {
    public HeatedCirtictShield(Settings settings, int cooldownTicks, int enchantability, Item... repairItems) {
        super(settings, cooldownTicks, enchantability, repairItems);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText("item.moreweaponry.heated_cirtict_items.tooltip").formatted(Formatting.GOLD) );
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.isOnFire()) {
            target.setOnFireFor(5);
        }
        return super.postHit(stack, target, attacker);
    }

}
