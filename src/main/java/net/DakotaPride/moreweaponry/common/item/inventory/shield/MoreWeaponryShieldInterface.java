package net.DakotaPride.moreweaponry.common.item.inventory.shield;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import java.util.List;

public interface MoreWeaponryShieldInterface {

    int getCooldownTicks();

    boolean supportsBanner();

    default boolean acceptsShieldEnchantments() {
        return true;
    }

    default boolean displayTooltip() {
        return true;
    }

    default void appendShieldTooltip(ItemStack stack, List<Text> tooltip, TooltipContext context) {

    }

}
