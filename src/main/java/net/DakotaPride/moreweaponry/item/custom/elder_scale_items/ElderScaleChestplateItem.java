package net.DakotaPride.moreweaponry.item.custom.elder_scale_items;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ElderScaleChestplateItem extends ArmorItem {
    public ElderScaleChestplateItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if(Screen.hasShiftDown()){
            tooltip.add( new LiteralText("Grants Water Breathing Upon Full Set").formatted(Formatting.YELLOW));
            tooltip.add( new LiteralText("After Defeating the Elder Guardian From The").formatted(Formatting.YELLOW));
            tooltip.add( new LiteralText("Depths Of The Ocean Monument, This Gear Is Well Respected").formatted(Formatting.YELLOW));
            tooltip.add( new LiteralText("Among Warriors And Armorers Alike").formatted(Formatting.YELLOW));
        } else {
            tooltip.add( new LiteralText("Press Shift For More Information").formatted(Formatting.DARK_GRAY));
            tooltip.add( new LiteralText("Currently You Do Not Need The Chestplate Due To Bug").formatted(Formatting.DARK_GRAY));
        }
    }

}
