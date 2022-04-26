package net.DakotaPride.moreweaponry.item.custom.watcher_tools;

import com.google.common.collect.ImmutableMap;
import net.DakotaPride.moreweaponry.effect.MoreWeaponryEffects;
import net.DakotaPride.moreweaponry.item.MoreWeaponryItems;
import net.DakotaPride.moreweaponry.item.extra.MoreWeaponryArmorMaterials;
import net.DakotaPride.moreweaponry.mixin.ILivingEntityMixin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

import java.util.Map;

public class WatcherEffectItem extends WatcherArmorItem {
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(MoreWeaponryArmorMaterials.ENDER,
                            new StatusEffectInstance(MoreWeaponryEffects.WATCHER, 12000, 0)).build();

    public WatcherEffectItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        EntityAttributeInstance health = ((LivingEntity)((ILivingEntityMixin)this)).getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        EntityAttributeModifier modifier = new EntityAttributeModifier("generic.max_health", 30.0F,
                EntityAttributeModifier.Operation.ADDITION);
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity)entity;

                if(hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        } if (stack.getItem() == MoreWeaponryItems.WATCHER_HELMET
                    || stack.getItem() == MoreWeaponryItems.WATCHER_CHESTPLATE) {
            assert health != null;
            if(!health.hasModifier(modifier)) {
                    health.addTemporaryModifier(modifier);
                }
            }
            else {
            assert health != null;
            if(health.hasModifier(modifier)) {
                    health.removeModifier(modifier);
                }
            }


        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect.getEffectType(),
                    mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier()));

        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty();
    }

    private  boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        for (ItemStack armorStack: player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof ArmorItem) && armorStack.getItem() != Items.AIR) {
                return false;
            }
        }

        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material;
    }

}
