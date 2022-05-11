package net.DakotaPride.moreweaponry.item.items.phantom_helm;

import net.minecraft.client.gui.screen.Screen;
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
        if (Screen.hasShiftDown()) {
            tooltip.add( new TranslatableText("armor.moreweaponry.shift_down.description.phantom_helm.one").formatted(Formatting.BLUE));
            tooltip.add( new TranslatableText("armor.moreweaponry.shift_down.description.phantom_helm.two").formatted(Formatting.BLUE));
            tooltip.add( new TranslatableText("armor.moreweaponry.shift_down.description.phantom_helm.three").formatted(Formatting.BLUE));
        } else {
            tooltip.add( new TranslatableText("misc.moreweaponry.shift_up").formatted(Formatting.DARK_GRAY));
        }
    }

}
