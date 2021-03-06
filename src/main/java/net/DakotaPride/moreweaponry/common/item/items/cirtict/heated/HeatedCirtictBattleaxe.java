package net.DakotaPride.moreweaponry.common.item.items.cirtict.heated;

import net.DakotaPride.moreweaponry.common.item.items.mod_tools.BattleaxeItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HeatedCirtictBattleaxe extends BattleaxeItem {

    public HeatedCirtictBattleaxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.moreweaponry.heated_cirtict_items.tooltip").formatted(Formatting.GOLD) );
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.isOnFire()) {
            target.setOnFireFor(5);
        }
        return super.postHit(stack, target, attacker);
    }
}
