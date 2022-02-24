package net.DakotaPride.moreweaponry.item.custom.phantom_helm;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
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
            tooltip.add( new LiteralText("Grants Slow Falling and Night Vision Upon Equipping").formatted(Formatting.BLUE));
            tooltip.add( new LiteralText("Using The Scales Of A Phantom, You Gain The Powers Of The Creature").formatted(Formatting.BLUE));
            tooltip.add( new LiteralText("Of The Darkest Nights").formatted(Formatting.BLUE));
        } else {
            tooltip.add( new LiteralText("Press Shift For More Information").formatted(Formatting.DARK_GRAY));
        }
    }

}
