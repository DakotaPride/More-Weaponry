package net.DakotaPride.moreweaponry.item.custom.mod_tools;

import net.DakotaPride.moreweaponry.item.custom.vanilla_tools.ModAxeItem;
import net.DakotaPride.moreweaponry.item.custom.vanilla_tools.ModPickaxeItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class ModBroadHammerItem extends SwordItem {
    public ModBroadHammerItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
