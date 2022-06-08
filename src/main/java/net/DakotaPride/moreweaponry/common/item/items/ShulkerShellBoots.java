package net.DakotaPride.moreweaponry.common.item.items;

import com.google.common.collect.ImmutableMap;
import net.DakotaPride.moreweaponry.common.MoreWeaponry;
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
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class ShulkerShellBoots extends ArmorItem {

    private static final Map<ArmorMaterial, StatusEffect> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffect>())
                    .put(MoreWeaponry.MoreWeaponryArmorMaterials.SHULKER_SHELL_ARMOR, StatusEffects.LEVITATION).build();

    public ShulkerShellBoots(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
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
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect, 20*16, 1));

        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);

        return !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());

        return boots.getMaterial() == material;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
        tooltip.add(Text.translatable("armor.moreweaponry.shift_down_description.shulker_boots.top").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("armor.moreweaponry.shift_down.description.shulker_boots.bottom.one").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("armor.moreweaponry.shift_down.description.shulker_boots.bottom.two").formatted(Formatting.DARK_PURPLE));
        } else {
            tooltip.add(Text.translatable("misc.moreweaponry.shift_up").formatted(Formatting.DARK_GRAY));
        }
    }

}
