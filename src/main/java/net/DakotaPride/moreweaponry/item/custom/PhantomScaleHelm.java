package net.DakotaPride.moreweaponry.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
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
        tooltip.add( new TranslatableText("item.moreweaponry.phantom_scale_helm.tooltip").formatted(Formatting.AQUA));
        tooltip.add( new TranslatableText("item.moreweaponry.phantom_scale_helm_two.tooltip").formatted(Formatting.DARK_GRAY));
    }

}
