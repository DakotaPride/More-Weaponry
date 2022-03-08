package net.DakotaPride.moreweaponry.item.custom;

import com.google.common.collect.ImmutableMap;
import net.DakotaPride.moreweaponry.item.MoreWeaponryArmorMaterials;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class ModElderScaleArmorItem extends ArmorItem {

    private static final Map<ArmorMaterial, StatusEffect> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffect>())
                    .put(MoreWeaponryArmorMaterials.ELDER_GUARDIAN_SCALE, StatusEffects.WATER_BREATHING).build();


    public ModElderScaleArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity)entity;

                if(hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }


    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffect> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffect mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }


    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffect mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect);

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect, 200));

        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        for (ItemStack armorStack: player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof ModElderScaleArmorItem)) {
                return true;
            }
        }
        ModElderScaleArmorItem boots = ((ModElderScaleArmorItem)player.getInventory().getArmorStack(0).getItem());
        ModElderScaleArmorItem leggings = ((ModElderScaleArmorItem)player.getInventory().getArmorStack(1).getItem());
        ModElderScaleArmorItem breastplate = ((ModElderScaleArmorItem)player.getInventory().getArmorStack(2).getItem());
        ModElderScaleArmorItem helmet = ((ModElderScaleArmorItem)player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
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
            }
    }

}
