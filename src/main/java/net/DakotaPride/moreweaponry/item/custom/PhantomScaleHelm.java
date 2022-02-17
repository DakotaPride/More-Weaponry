package net.DakotaPride.moreweaponry.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PhantomScaleHelm extends ModPhantomScaleArmorItem{
    public PhantomScaleHelm(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new LiteralText("Obtain the Powers of the Phantom").formatted(Formatting.AQUA));
        tooltip.add( new LiteralText("Grants Slow Falling and Night Vision Upon Equipping").formatted(Formatting.DARK_GRAY));
    }

}
