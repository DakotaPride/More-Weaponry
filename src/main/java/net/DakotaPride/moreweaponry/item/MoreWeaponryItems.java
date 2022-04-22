package net.DakotaPride.moreweaponry.item;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.DakotaPride.moreweaponry.entity.MoreWeaponryEntities;
import net.DakotaPride.moreweaponry.item.custom.*;
import net.DakotaPride.moreweaponry.item.custom.celestial_madalian.*;
import net.DakotaPride.moreweaponry.item.custom.cirtict.CooledCirtictClusterItem;
import net.DakotaPride.moreweaponry.item.custom.cirtict.HeatedCirtictClusterItem;
import net.DakotaPride.moreweaponry.item.custom.cirtict.cooled.*;
import net.DakotaPride.moreweaponry.item.custom.cirtict.essence.*;
import net.DakotaPride.moreweaponry.item.custom.cirtict.heated.*;
import net.DakotaPride.moreweaponry.item.custom.cores.*;
import net.DakotaPride.moreweaponry.item.custom.elder_scale_items.*;
import net.DakotaPride.moreweaponry.item.custom.bard_tools.*;
import net.DakotaPride.moreweaponry.item.custom.mod_tools.BluestoneIgnitor;
import net.DakotaPride.moreweaponry.item.custom.mod_tools.ModBattleaxeItem;
import net.DakotaPride.moreweaponry.item.custom.mod_tools.ModKnifeItem;
import net.DakotaPride.moreweaponry.item.custom.phantom_helm.PhantomScaleHelm;
import net.DakotaPride.moreweaponry.item.custom.sickened_tools.*;
import net.DakotaPride.moreweaponry.item.custom.powered_cores.*;
import net.DakotaPride.moreweaponry.item.custom.crackler_tools.*;
import net.DakotaPride.moreweaponry.item.custom.vanilla_tools.ModHoeItem;
import net.DakotaPride.moreweaponry.item.custom.vanilla_tools.ModPickaxeItem;
import net.DakotaPride.moreweaponry.item.custom.wanderer_tools.*;
import net.DakotaPride.moreweaponry.item.custom.watcher_tools.*;
import net.DakotaPride.moreweaponry.item.extra.MoreWeaponryArmorMaterials;
import net.DakotaPride.moreweaponry.item.extra.MoreWeaponryItemGroup;
import net.DakotaPride.moreweaponry.item.extra.MoreWeaponryToolMaterials;
import net.DakotaPride.moreweaponry.sound.MoreWeaponrySoundEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.DakotaPride.moreweaponry.item.custom.vanilla_tools.ModAxeItem;

public class MoreWeaponryItems {

    public static final Item BLASTED_AMETHYST = registerItem("blasted_amethyst",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item GLIMMERING_AMETHYST = registerItem("glimmering_amethyst",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item MOON_STONE_DUST = registerItem("moon_stone_dust",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item REFINED_MOON_STONE = registerItem("refined_moon_stone",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item HANDLE = registerItem("handle",
            new ModHandleItem(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item KURO_SEEDS = registerItem("kuro_seeds",
            new BlockItem(MoreWeaponryBlocks.KURO_PLANT, new FabricItemSettings().fireproof().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item KURO = registerItem("kuro",
            new Item(new FabricItemSettings().fireproof().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item KURO_BREAD = registerItem("kuro_bread",
            new Item(new FabricItemSettings().fireproof().food
                    (new FoodComponent.Builder().alwaysEdible().hunger(8).statusEffect
                                    (new StatusEffectInstance(StatusEffects.ABSORPTION, 20*10), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20*5), 0.5f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*15), 1f)
                            .saturationModifier(0.7f).build()).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CURON_BREW = registerItem("curon_brew",
            new NightCuronBrewItem(new FabricItemSettings().maxCount(1).food
                    (new FoodComponent.Builder().alwaysEdible().hunger(7).statusEffect
                            (new StatusEffectInstance(StatusEffects.BLINDNESS, 20*10), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20*5), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20*5), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 20*3), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 20*10), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*5), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20*10), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20*10), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 20*5), 1f)
                            .saturationModifier(0.6f).build()).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item FRODON_BOWL = registerItem("frodon_bowl",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CURON_FLOWER_PETALS = registerItem("curon_flower_petals",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).statusEffect
                    (new StatusEffectInstance(StatusEffects.WEAKNESS, 20*3), 0.7f)
                    .saturationModifier(0.4f).build()).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CRUSHED_KURO = registerItem("crushed_kuro",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item BLACKSTONE_INGOT = registerItem("blackstone_ingot",
            new Item(new FabricItemSettings().fireproof().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item NETHERITE_HANDLE = registerItem("netherite_handle",
            new ModHandleItem(new FabricItemSettings().fireproof().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item MARE_DIAMOND = registerItem("mare_diamond",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item NETHERITE_NUGGET = registerItem("netherite_nugget",
            new Item(new FabricItemSettings().fireproof().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item AMETHYST_HANDLE = registerItem("amethyst_handle",
            new ModHandleItem(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item GUARDIAN_SCALE = registerItem("guardian_scale",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item ELDER_GUARDIAN_SCALE = registerItem("elder_guardian_scale",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item ELDER_GUARDIANS_EYE = registerItem("elder_guardians_eye",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item PRISMARINE_HANDLE = registerItem("prismarine_handle",
            new ModHandleItem(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WITHER_ESSENCE = registerItem("wither_essence",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WITHER_BONE = registerItem("wither_bone",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item PHANTOM_ESSENCE = registerItem("phantom_essence",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item PHANTOM_SCALE = registerItem("phantom_scale",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item PHANTOM_HELMET = registerItem("phantom_helmet",
            new PhantomScaleHelm(MoreWeaponryArmorMaterials.PHANTOM_SCALE, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CIRTICT_INGOT = registerItem("cirtict_ingot",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));


    public static final Item GLIMMERING_SWORD = registerItem("glimmering_sword",
            new SwordItem((ToolMaterial) MoreWeaponryToolMaterials.GLIMMERING_AMETHYST, 3, -2.4f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item GLIMMERING_SHOVEL = registerItem("glimmering_shovel",
            new ShovelItem((ToolMaterial) MoreWeaponryToolMaterials.GLIMMERING_AMETHYST, 1, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item GLIMMERING_PICKAXE = registerItem("glimmering_pickaxe",
            new ModPickaxeItem((ToolMaterial) MoreWeaponryToolMaterials.GLIMMERING_AMETHYST, 1, -2.8f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item GLIMMERING_AXE = registerItem("glimmering_axe",
            new ModAxeItem((ToolMaterial) MoreWeaponryToolMaterials.GLIMMERING_AMETHYST, 5, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item GLIMMERING_HOE = registerItem("glimmering_hoe",
            new ModHoeItem((ToolMaterial) MoreWeaponryToolMaterials.GLIMMERING_AMETHYST, -1, 0f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item GLIMMERING_BATTLEAXE = registerItem("glimmering_battleaxe",
            new ModBattleaxeItem((ToolMaterial) MoreWeaponryToolMaterials.GLIMMERING_AMETHYST, 6, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item MOON_STONE_SWORD = registerItem("moon_stone_sword",
            new SwordItem((ToolMaterial) MoreWeaponryToolMaterials.REFINED_MOON_STONE, 3, -2.4f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item MOON_STONE_SHOVEL = registerItem("moon_stone_shovel",
            new ShovelItem((ToolMaterial) MoreWeaponryToolMaterials.REFINED_MOON_STONE, 1, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item MOON_STONE_PICKAXE = registerItem("moon_stone_pickaxe",
            new ModPickaxeItem((ToolMaterial) MoreWeaponryToolMaterials.REFINED_MOON_STONE, 1, -2.8f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item MOON_STONE_AXE = registerItem("moon_stone_axe",
            new ModAxeItem((ToolMaterial) MoreWeaponryToolMaterials.REFINED_MOON_STONE, 6, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item MOON_STONE_HOE = registerItem("moon_stone_hoe",
            new ModHoeItem((ToolMaterial) MoreWeaponryToolMaterials.REFINED_MOON_STONE, 0, 0f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item MOON_STONE_BATTLEAXE = registerItem("moon_stone_battleaxe",
            new ModBattleaxeItem((ToolMaterial) MoreWeaponryToolMaterials.REFINED_MOON_STONE, 8, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item BLACKSTONE_METAL_SWORD = registerItem("blackstone_metal_sword",
            new SwordItem((ToolMaterial) MoreWeaponryToolMaterials.BLACKSTONE_METAL, 4, -2.4f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item BLACKSTONE_METAL_SHOVEL = registerItem("blackstone_metal_shovel",
            new ShovelItem((ToolMaterial) MoreWeaponryToolMaterials.BLACKSTONE_METAL, 2, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item BLACKSTONE_METAL_PICKAXE = registerItem("blackstone_metal_pickaxe",
            new ModPickaxeItem((ToolMaterial) MoreWeaponryToolMaterials.BLACKSTONE_METAL, 1, -2.8f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item BLACKSTONE_METAL_AXE = registerItem("blackstone_metal_axe",
            new ModAxeItem((ToolMaterial) MoreWeaponryToolMaterials.BLACKSTONE_METAL, 6, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item BLACKSTONE_METAL_HOE = registerItem("blackstone_metal_hoe",
            new ModHoeItem((ToolMaterial) MoreWeaponryToolMaterials.BLACKSTONE_METAL, (int) -4.5, 0f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item BLACKSTONE_METAL_BATTLEAXE = registerItem("blackstone_metal_battleaxe",
            new ModBattleaxeItem((ToolMaterial) MoreWeaponryToolMaterials.BLACKSTONE_METAL, 9, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));


    public static final Item NETHERITE_BATTLEAXE = registerItem("netherite_battleaxe",
            new ModBattleaxeItem((ToolMaterial) MoreWeaponryToolMaterials.OG_NETHERITE, 8, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item DIAMOND_BATTLEAXE = registerItem("diamond_battleaxe",
            new ModBattleaxeItem((ToolMaterial) MoreWeaponryToolMaterials.OG_DIAMOND, 7, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item GLIMMERING_HELMET = registerItem("glimmering_helmet",
            new ArmorItem(MoreWeaponryArmorMaterials.GLIMMERING_AMETHYST, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item GLIMMERING_CHESTPLATE = registerItem("glimmering_chestplate",
            new ArmorItem(MoreWeaponryArmorMaterials.GLIMMERING_AMETHYST, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item GLIMMERING_LEGGINGS = registerItem("glimmering_leggings",
            new ArmorItem(MoreWeaponryArmorMaterials.GLIMMERING_AMETHYST, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item GLIMMERING_BOOTS = registerItem("glimmering_boots",
            new ArmorItem(MoreWeaponryArmorMaterials.GLIMMERING_AMETHYST, EquipmentSlot.FEET,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item MOON_STONE_HELMET = registerItem("moon_stone_helmet",
            new ArmorItem(MoreWeaponryArmorMaterials.REFINED_MOON_STONE, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item MOON_STONE_CHESTPLATE = registerItem("moon_stone_chestplate",
            new ArmorItem(MoreWeaponryArmorMaterials.REFINED_MOON_STONE, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item MOON_STONE_LEGGINGS = registerItem("moon_stone_leggings",
            new ArmorItem(MoreWeaponryArmorMaterials.REFINED_MOON_STONE, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item MOON_STONE_BOOTS = registerItem("moon_stone_boots",
            new ArmorItem(MoreWeaponryArmorMaterials.REFINED_MOON_STONE, EquipmentSlot.FEET,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item BLACKSTONE_METAL_HELMET = registerItem("blackstone_metal_helmet",
            new ArmorItem(MoreWeaponryArmorMaterials.BLACKSTONE_METAL, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item BLACKSTONE_METAL_CHESTPLATE = registerItem("blackstone_metal_chestplate",
            new ArmorItem(MoreWeaponryArmorMaterials.BLACKSTONE_METAL, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item BLACKSTONE_METAL_LEGGINGS = registerItem("blackstone_metal_leggings",
            new ArmorItem(MoreWeaponryArmorMaterials.BLACKSTONE_METAL, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item BLACKSTONE_METAL_BOOTS = registerItem("blackstone_metal_boots",
            new ArmorItem(MoreWeaponryArmorMaterials.BLACKSTONE_METAL, EquipmentSlot.FEET,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item ELDER_GUARDIAN_SCALE_HELMET = registerItem("elder_guardian_scale_helmet",
            new ElderScaleArmorItem(MoreWeaponryArmorMaterials.ELDER_GUARDIAN_SCALE, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item ELDER_GUARDIAN_SCALE_CHESTPLATE = registerItem("elder_guardian_scale_chestplate",
            new ArmorItem(MoreWeaponryArmorMaterials.ELDER_GUARDIAN_SCALE, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item ELDER_GUARDIAN_SCALE_LEGGINGS = registerItem("elder_guardian_scale_leggings",
            new ArmorItem(MoreWeaponryArmorMaterials.ELDER_GUARDIAN_SCALE, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item ELDER_GUARDIAN_SCALE_BOOTS = registerItem("elder_guardian_scale_boots",
            new ArmorItem(MoreWeaponryArmorMaterials.ELDER_GUARDIAN_SCALE, EquipmentSlot.FEET,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item ELDER_GUARDIAN_SCALE_SWORD = registerItem("elder_guardian_scale_sword",
            new ElderScaleSword((ToolMaterial) MoreWeaponryToolMaterials.ELDER_GUARDIAN_SCALE, 5, -2.4f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item ELDER_GUARDIAN_SCALE_SHOVEL = registerItem("elder_guardian_scale_shovel",
            new ElderScaleShovel((ToolMaterial) MoreWeaponryToolMaterials.ELDER_GUARDIAN_SCALE, 2, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item ELDER_GUARDIAN_SCALE_PICKAXE = registerItem("elder_guardian_scale_pickaxe",
            new ElderScalePickaxe((ToolMaterial) MoreWeaponryToolMaterials.ELDER_GUARDIAN_SCALE, 2, -2.8f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item ELDER_GUARDIAN_SCALE_AXE = registerItem("elder_guardian_scale_axe",
            new ElderScaleAxe((ToolMaterial) MoreWeaponryToolMaterials.ELDER_GUARDIAN_SCALE, 7, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item ELDER_GUARDIAN_SCALE_HOE = registerItem("elder_guardian_scale_hoe",
            new ElderScaleHoe((ToolMaterial) MoreWeaponryToolMaterials.ELDER_GUARDIAN_SCALE, -5, 0f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item ELDER_GUARDIAN_SCALE_BATTLEAXE = registerItem("elder_guardian_scale_battleaxe",
            new ElderScaleBattleaxe((ToolMaterial) MoreWeaponryToolMaterials.ELDER_GUARDIAN_SCALE, 11, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item GUARDIAN_SCALE_HELMET = registerItem("guardian_scale_helmet",
            new ArmorItem(MoreWeaponryArmorMaterials.GUARDIAN_SCALE, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item GUARDIAN_SCALE_CHESTPLATE = registerItem("guardian_scale_chestplate",
            new ArmorItem(MoreWeaponryArmorMaterials.GUARDIAN_SCALE, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item GUARDIAN_SCALE_LEGGINGS = registerItem("guardian_scale_leggings",
            new ArmorItem(MoreWeaponryArmorMaterials.GUARDIAN_SCALE, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item GUARDIAN_SCALE_BOOTS = registerItem("guardian_scale_boots",
            new ArmorItem(MoreWeaponryArmorMaterials.GUARDIAN_SCALE, EquipmentSlot.FEET,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item GUARDIAN_SCALE_SWORD = registerItem("guardian_scale_sword",
            new SwordItem((ToolMaterial) MoreWeaponryToolMaterials.GUARDIAN_SCALE, 4, -2.4f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item GUARDIAN_SCALE_SHOVEL = registerItem("guardian_scale_shovel",
            new ShovelItem((ToolMaterial) MoreWeaponryToolMaterials.ELDER_GUARDIAN_SCALE, 1, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item GUARDIAN_SCALE_PICKAXE = registerItem("guardian_scale_pickaxe",
            new ModPickaxeItem((ToolMaterial) MoreWeaponryToolMaterials.GUARDIAN_SCALE, 2, -2.8f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item GUARDIAN_SCALE_AXE = registerItem("guardian_scale_axe",
            new ModAxeItem((ToolMaterial) MoreWeaponryToolMaterials.GUARDIAN_SCALE, 7, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item GUARDIAN_SCALE_HOE = registerItem("guardian_scale_hoe",
            new ModHoeItem((ToolMaterial) MoreWeaponryToolMaterials.GUARDIAN_SCALE, -4, 0f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item GUARDIAN_SCALE_BATTLEAXE = registerItem("guardian_scale_battleaxe",
            new ModBattleaxeItem((ToolMaterial) MoreWeaponryToolMaterials.GUARDIAN_SCALE, 10, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item GLIMMERING_SHIELD = registerItem("glimmering_shield",
            new FabricShieldItem(new FabricItemSettings().maxDamage(1782).group(MoreWeaponryItemGroup.MORE_WEAPONRY), 20, 23, MoreWeaponryItems.GLIMMERING_AMETHYST));

    public static final Item BLACKSTONE_METAL_SHIELD = registerItem("blackstone_metal_shield",
            new FabricShieldItem(new FabricItemSettings().maxDamage(2476).group(MoreWeaponryItemGroup.MORE_WEAPONRY), 10, 17, MoreWeaponryItems.BLACKSTONE_INGOT));

    public static final Item MOON_STONE_SHIELD = registerItem("moon_stone_shield",
            new FabricShieldItem(new FabricItemSettings().maxDamage(2006).group(MoreWeaponryItemGroup.MORE_WEAPONRY), 15, 19, MoreWeaponryItems.REFINED_MOON_STONE));

    public static final Item GUARDIAN_SCALE_SHIELD = registerItem("guardian_scale_shield",
            new FabricShieldItem(new FabricItemSettings().maxDamage(2938).group(MoreWeaponryItemGroup.MORE_WEAPONRY), 8, 17, MoreWeaponryItems.GUARDIAN_SCALE));

    public static final Item ELDER_SCALE_SHIELD  = registerItem("elder_scale_shield",
            new FabricShieldItem(new FabricItemSettings().maxDamage(3276).group(MoreWeaponryItemGroup.MORE_WEAPONRY), 7, 18, MoreWeaponryItems.ELDER_GUARDIAN_SCALE));

    public static final Item ELDER_SCALE_ARTIFACT = registerItem("elder_scale_artifact",
            new ElderScaleArtifactItem((ToolMaterial) MoreWeaponryToolMaterials.ELDER_GUARDIAN_SCALE, 9, -2.9f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item GOLDEN_KNIFE = registerItem("golden_knife",
            new ModKnifeItem((ToolMaterial) MoreWeaponryToolMaterials.OG_GOLD, 2, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item STONE_KNIFE = registerItem("stone_knife",
            new ModKnifeItem((ToolMaterial) MoreWeaponryToolMaterials.OG_STONE, 2, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item IRON_KNIFE = registerItem("iron_knife",
            new ModKnifeItem((ToolMaterial) MoreWeaponryToolMaterials.OG_IRON, 3, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item DIAMOND_KNIFE = registerItem("diamond_knife",
            new ModKnifeItem((ToolMaterial) MoreWeaponryToolMaterials.OG_DIAMOND, 4, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WOODEN_KNIFE = registerItem("wooden_knife",
            new ModKnifeItem((ToolMaterial) MoreWeaponryToolMaterials.OG_WOOD, 1, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item NETHERITE_KNIFE = registerItem("netherite_knife",
            new ModKnifeItem((ToolMaterial) MoreWeaponryToolMaterials.OG_NETHERITE, 2, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item REFINED_MOON_KNIFE = registerItem("refined_moon_knife",
            new ModKnifeItem((ToolMaterial) MoreWeaponryToolMaterials.REFINED_MOON_STONE, 3, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item GLIMMERED_AMETHYST_KNIFE = registerItem("glimmered_amethyst_knife",
            new ModKnifeItem((ToolMaterial) MoreWeaponryToolMaterials.GLIMMERING_AMETHYST, 2, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item BLACKSTONE_METAL_KNIFE = registerItem("blackstone_metal_knife",
            new ModKnifeItem((ToolMaterial) MoreWeaponryToolMaterials.BLACKSTONE_METAL, (int) 2.5, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item GUARDIAN_SCALE_KNIFE = registerItem("guardian_scale_knife",
            new ModKnifeItem((ToolMaterial) MoreWeaponryToolMaterials.GUARDIAN_SCALE, 3, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item ELDER_GUARDIAN_SCALE_KNIFE = registerItem("elder_guardian_scale_knife",
            new ModKnifeItem((ToolMaterial) MoreWeaponryToolMaterials.ELDER_GUARDIAN_SCALE, 3, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item GOLDEN_BATTLEAXE = registerItem("golden_battleaxe",
            new ModBattleaxeItem((ToolMaterial) MoreWeaponryToolMaterials.OG_GOLD, 2, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WOODEN_BATTLEAXE = registerItem("wooden_battleaxe",
            new ModBattleaxeItem((ToolMaterial) MoreWeaponryToolMaterials.OG_WOOD, 1, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item STONE_BATTLEAXE = registerItem("stone_battleaxe",
            new ModBattleaxeItem((ToolMaterial) MoreWeaponryToolMaterials.OG_STONE, 2, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item IRON_BATTLEAXE = registerItem("iron_battleaxe",
            new ModBattleaxeItem((ToolMaterial) MoreWeaponryToolMaterials.OG_IRON, 3, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CIRTICT_BATTLEAXE = registerItem("cirtict_battleaxe",
            new ModBattleaxeItem((ToolMaterial) MoreWeaponryToolMaterials.CIRTICT, 4, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item HEATED_CIRTICT_BATTLEAXE = registerItem("heated_cirtict_battleaxe",
            new HeatedCirtictBattleaxe((ToolMaterial) MoreWeaponryToolMaterials.HEATED_CIRTICT, 5, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item COOLED_CIRTICT_BATTLEAXE = registerItem("cooled_cirtict_battleaxe",
            new CooledCirtictBattleaxe((ToolMaterial) MoreWeaponryToolMaterials.COOLED_CIRTICT, 5, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item BLUESTONE_IGNITOR = registerItem("bluestone_ignitor",
            new BluestoneIgnitor(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item BLUESTONE_ROCK = registerItem("bluestone_rock",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CIRTICT_SCRAP = registerItem("cirtict_scrap",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item COOLED_CIRTICT_INGOT = registerItem("cooled_cirtict_ingot",
            new CooledCirtictIngot(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WARDENS_STEP_MUSIC_DISC = registerItem("wardens_step_music_disc",
            new MoreWeaponryMusicDiscItem(9, MoreWeaponrySoundEvents.WARDENS_STEP,
                    new FabricItemSettings().maxCount(1).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item FRODON_SIGN = registerItem("frodon_sign",
            new SignItem(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY).maxCount(16),
                    MoreWeaponryBlocks.FRODON_SIGN, MoreWeaponryBlocks.FRODON_WALL_SIGN));

    public static final Item DRAGON_SCALE = registerItem("dragon_scale",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item SHULKER_SHELL_BOOTS = registerItem("shulker_shell_boots",
            new ShulkerShellBoots(MoreWeaponryArmorMaterials.SHULKER_SHELL, EquipmentSlot.FEET,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WITHER_BROAD_HAMMER = registerItem("wither_broad_hammer",
            new WitherBroadHammerItem((ToolMaterial) MoreWeaponryToolMaterials.WITHERED, 11, -3.0f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WITHERING_HANDLE = registerItem("withering_handle",
            new ModHandleItem(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WITHER_BROAD_HAMMER_HEAD = registerItem("wither_broad_hammer_head",
            new Item(new FabricItemSettings().maxCount(1).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item HEATED_CIRTICT_INGOT = registerItem("heated_cirtict_ingot",
            new HeatedCirtictIngot(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item COOLED_CIRTICT_SWORD = registerItem("cooled_cirtict_sword",
            new CooledCirtictSword((ToolMaterial) MoreWeaponryToolMaterials.COOLED_CIRTICT, -1, -2.4f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item COOLED_CIRTICT_AXE = registerItem("cooled_cirtict_axe",
            new CooledCirtictAxe((ToolMaterial) MoreWeaponryToolMaterials.COOLED_CIRTICT, 2, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item COOLED_CIRTICT_HOE = registerItem("cooled_cirtict_hoe",
            new CooledCirtictHoe((ToolMaterial) MoreWeaponryToolMaterials.COOLED_CIRTICT, -13, 0f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item COOLED_CIRTICT_PICKAXE = registerItem("cooled_cirtict_pickaxe",
            new CooledCirtictPickaxe((ToolMaterial) MoreWeaponryToolMaterials.COOLED_CIRTICT, -4, -2.8f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item COOLED_CIRTICT_SHOVEL = registerItem("cooled_cirtict_shovel",
            new CooledCirtictShovel((ToolMaterial) MoreWeaponryToolMaterials.COOLED_CIRTICT, -5, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item COOLED_CIRTICT_KNIFE = registerItem("cooled_cirtict_knife",
            new CooledCirtictKnife((ToolMaterial) MoreWeaponryToolMaterials.COOLED_CIRTICT, -2, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item HEATED_CIRTICT_SWORD = registerItem("heated_cirtict_sword",
            new HeatedCirtictSword((ToolMaterial) MoreWeaponryToolMaterials.HEATED_CIRTICT, -1, -2.4f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item HEATED_CIRTICT_AXE = registerItem("heated_cirtict_axe",
            new HeatedCirtictAxe((ToolMaterial) MoreWeaponryToolMaterials.HEATED_CIRTICT, 2, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item HEATED_CIRTICT_HOE = registerItem("heated_cirtict_hoe",
            new HeatedCirtictHoe((ToolMaterial) MoreWeaponryToolMaterials.HEATED_CIRTICT, -13, 0f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item HEATED_CIRTICT_PICKAXE = registerItem("heated_cirtict_pickaxe",
            new HeatedCirtictPickaxe((ToolMaterial) MoreWeaponryToolMaterials.HEATED_CIRTICT, -4, -2.8f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item HEATED_CIRTICT_SHOVEL = registerItem("heated_cirtict_shovel",
            new HeatedCirtictShovel((ToolMaterial) MoreWeaponryToolMaterials.HEATED_CIRTICT, -5, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item HEATED_CIRTICT_KNIFE = registerItem("heated_cirtict_knife",
            new HeatedCirtictKnife((ToolMaterial) MoreWeaponryToolMaterials.HEATED_CIRTICT, -2, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CIRTICT_SWORD = registerItem("cirtict_sword",
            new SwordItem((ToolMaterial) MoreWeaponryToolMaterials.CIRTICT, -2, -2.4f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CIRTICT_AXE = registerItem("cirtict_axe",
            new ModAxeItem((ToolMaterial) MoreWeaponryToolMaterials.CIRTICT, 1, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CIRTICT_HOE = registerItem("cirtict_hoe",
            new ModHoeItem((ToolMaterial) MoreWeaponryToolMaterials.CIRTICT, -13, 0f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CIRTICT_PICKAXE = registerItem("cirtict_pickaxe",
            new ModPickaxeItem((ToolMaterial) MoreWeaponryToolMaterials.CIRTICT, -5, -2.8f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CIRTICT_SHOVEL = registerItem("cirtict_shovel",
            new ShovelItem((ToolMaterial) MoreWeaponryToolMaterials.CIRTICT, -4, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CIRTICT_KNIFE = registerItem("cirtict_knife",
            new ModKnifeItem((ToolMaterial) MoreWeaponryToolMaterials.CIRTICT, -4, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item COOLED_CIRTICT_SHIELD  = registerItem("cooled_cirtict_shield",
            new CooledCirtictShield(new FabricItemSettings().maxDamage(3583).group(MoreWeaponryItemGroup.MORE_WEAPONRY), 6, 16, MoreWeaponryItems.COOLED_CIRTICT_INGOT));

    public static final Item HEATED_CIRTICT_SHIELD  = registerItem("heated_cirtict_shield",
            new HeatedCirtictShield(new FabricItemSettings().maxDamage(3583).group(MoreWeaponryItemGroup.MORE_WEAPONRY), 6, 16, MoreWeaponryItems.HEATED_CIRTICT_INGOT));

    public static final Item CIRTICT_SHIELD  = registerItem("cirtict_shield",
            new FabricShieldItem(new FabricItemSettings().maxDamage(3456).group(MoreWeaponryItemGroup.MORE_WEAPONRY), 6, 17, MoreWeaponryItems.CIRTICT_INGOT));

    public static final Item CIRTICT_NUGGET = registerItem("cirtict_nugget",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item HEATED_CIRTICT_NUGGET = registerItem("heated_cirtict_nugget",
            new HeatedCirtictNugget(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item COOLED_CIRTICT_NUGGET = registerItem("cooled_cirtict_nugget",
            new CooledCirtictNugget(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));



    // Plague Update

    public static final Item ENDICATE_STAFF = registerItem("endicate_staff",
            new EndicateStaffItem((ToolMaterial) MoreWeaponryToolMaterials.ENDICATE_STAFF, 24, -3.4f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item ENDICATE_HANDLE = registerItem("endicate_handle",
            new ModHandleItem(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item SANDSTONE_DUST = registerItem("sandstone_dust",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WRETCHED_ESSENCE = registerItem("wretched_essence",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));


    public static final Item CIRTICT_CLUSTER = registerItem("cirtict_cluster",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item HEATED_CIRTICT_CLUSTER = registerItem("heated_cirtict_cluster",
            new HeatedCirtictClusterItem(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item COOLED_CIRTICT_CLUSTER = registerItem("cooled_cirtict_cluster",
            new CooledCirtictClusterItem(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));


    public static final Item WRETCHED_CORE = registerItem("wretched_core",
            new WandererCoreItem(new FabricItemSettings().maxCount(1).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item WATCHER_CORE = registerItem("watcher_core",
            new WatcherCoreItem(new FabricItemSettings().maxCount(1).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item MAIDEN_CORE = registerItem("maiden_core",
            new BardCoreItem(new FabricItemSettings().maxCount(1).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item PLAGUED_CORE = registerItem("plagued_core",
            new SickenedCoreItem(new FabricItemSettings().maxCount(1).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item SICKENED_HUSK_CORE = registerItem("sickened_husk_core",
            new SickenedHuskCoreItem(new FabricItemSettings().maxCount(1).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item SUPPRESSED_CORE = registerItem("suppressed_core",
            new CracklerCoreItem(new FabricItemSettings().maxCount(1).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item MOB_CORE = registerItem("mob_core",
            new EmptyCoreItem(new FabricItemSettings().maxCount(1).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CHARGED_MOB_CORE = registerItem("charged_mob_core",
            new ChargedMobCoreItem(new FabricItemSettings().maxCount(1).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item ESSENCE_CIRTICT_AXE = registerItem("essence_cirtict_axe",
            new EssenceCirtictAxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, 3, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item ESSENCE_CIRTICT_PICKAXE = registerItem("essence_cirtict_pickaxe",
            new EssenceCirtictPickaxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -5, -2.8f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item ESSENCE_CIRTICT_SWORD = registerItem("essence_cirtict_sword",
            new EssenceCirtictSword((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -1, -2.4f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item ESSENCE_CIRTICT_SHOVEL = registerItem("essence_cirtict_shovel",
            new EssenceCirtictShovel((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -6, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item ESSENCE_CIRTICT_KNIFE = registerItem("essence_cirtict_knife",
            new EssenceCirtictKnife((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -3, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item ESSENCE_CIRTICT_HOE = registerItem("essence_cirtict_hoe",
            new EssenceCirtictHoe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -15, 0f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item ESSENCE_CIRTICT_BATTLEAXE = registerItem("essence_cirtict_battleaxe",
            new EssenceCirtictBattleaxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, 4, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item POWERED_WRETCHED_MOB_CORE = registerItem("powered_wretched_mob_core",
            new PoweredWandererItem(new FabricItemSettings().maxCount(1).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item POWERED_WATCHER_MOB_CORE = registerItem("powered_watcher_mob_core",
            new PoweredWatcherItem(new FabricItemSettings().maxCount(1).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item POWERED_MAIDEN_MOB_CORE = registerItem("powered_maiden_mob_core",
            new PoweredBardItem(new FabricItemSettings().maxCount(1).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item POWERED_PLAGUED_MOB_CORE = registerItem("powered_plagued_mob_core",
            new PoweredSickenedItem(new FabricItemSettings().maxCount(1).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item POWERED_SICKENED_HUSK_MOB_CORE = registerItem("powered_sickened_husk_mob_core",
            new PoweredSickenedHuskItem(new FabricItemSettings().maxCount(1).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item POWERED_SUPPRESSED_MOB_CORE = registerItem("powered_suppressed_mob_core",
            new PoweredCracklerItem(new FabricItemSettings().maxCount(1).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));


    public static final Item WATCHER_ESSENCE_CIRTICT_AXE = registerItem("watcher_essence_cirtict_axe",
            new WatcherAxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, 5, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WATCHER_ESSENCE_CIRTICT_PICKAXE = registerItem("watcher_essence_cirtict_pickaxe",
            new WatcherPickaxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -3, -2.8f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WATCHER_ESSENCE_CIRTICT_SWORD = registerItem("watcher_essence_cirtict_sword",
            new WatcherSword((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, 1, -2.4f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WATCHER_ESSENCE_CIRTICT_SHOVEL = registerItem("watcher_essence_cirtict_shovel",
            new WatcherShovel((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -4, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WATCHER_ESSENCE_CIRTICT_KNIFE = registerItem("watcher_essence_cirtict_knife",
            new WatcherKnife((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -7, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WATCHER_ESSENCE_CIRTICT_HOE = registerItem("watcher_essence_cirtict_hoe",
            new WatcherHoe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -14, 0f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WATCHER_ESSENCE_CIRTICT_BATTLEAXE = registerItem("watcher_essence_cirtict_battleaxe",
            new WatcherBattleaxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, 7, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WANDERER_ESSENCE_CIRTICT_AXE = registerItem("wanderer_essence_cirtict_axe",
            new WandererAxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, 5, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WANDERER_ESSENCE_CIRTICT_PICKAXE = registerItem("wanderer_essence_cirtict_pickaxe",
            new WandererPickaxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -3, -2.8f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WANDERER_ESSENCE_CIRTICT_SWORD = registerItem("wanderer_essence_cirtict_sword",
            new WandererSword((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, 1, -2.4f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WANDERER_ESSENCE_CIRTICT_SHOVEL = registerItem("wanderer_essence_cirtict_shovel",
            new WandererShovel((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -4, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WANDERER_ESSENCE_CIRTICT_KNIFE = registerItem("wanderer_essence_cirtict_knife",
            new WandererKnife((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -7, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WANDERER_ESSENCE_CIRTICT_HOE = registerItem("wanderer_essence_cirtict_hoe",
            new WandererHoe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -14, 0f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WANDERER_ESSENCE_CIRTICT_BATTLEAXE = registerItem("wanderer_essence_cirtict_battleaxe",
            new WandererBattleaxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, 7, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));


    public static final Item MAIDEN_ESSENCE_CIRTICT_AXE = registerItem("maiden_essence_cirtict_axe",
            new BardAxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, 5, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item MAIDEN_ESSENCE_CIRTICT_PICKAXE = registerItem("maiden_essence_cirtict_pickaxe",
            new BardPickaxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -3, -2.8f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item MAIDEN_ESSENCE_CIRTICT_SWORD = registerItem("maiden_essence_cirtict_sword",
            new BardSword((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, 1, -2.4f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item MAIDEN_ESSENCE_CIRTICT_SHOVEL = registerItem("maiden_essence_cirtict_shovel",
            new BardShovel((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -4, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item MAIDEN_ESSENCE_CIRTICT_KNIFE = registerItem("maiden_essence_cirtict_knife",
            new BardKnife((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -7, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item MAIDEN_ESSENCE_CIRTICT_HOE = registerItem("maiden_essence_cirtict_hoe",
            new BardHoe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -14, 0f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item MAIDEN_ESSENCE_CIRTICT_BATTLEAXE = registerItem("maiden_essence_cirtict_battleaxe",
            new BardBattleaxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, 7, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item LEECHING_ESSENCE = registerItem("leeching_essence",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WATCHER_HELMET = registerItem("watcher_helmet",
            new WatcherEffectItem(MoreWeaponryArmorMaterials.ENDER, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WATCHER_CHESTPLATE = registerItem("watcher_chestplate",
            new WatcherEffectItem(MoreWeaponryArmorMaterials.ENDER, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WATCHER_STAFF = registerItem("watcher_staff",
            new WatcherStaffItem((ToolMaterial) MoreWeaponryToolMaterials.WATCHER_STAFF, 26, -3.1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WITHER_BONE_MEAL = registerItem("wither_bone_meal",
            new BoneMealItem(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WATCHER_CLOTH = registerItem("watcher_cloth",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item MAIDEN_STEM = registerItem("maiden_stem",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item BARD_CLOTH = registerItem("bard_cloth",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item REINFORCED_BONE = registerItem("reinforced_bone",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item MELODIC_ESSENCE = registerItem("melodic_essence",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item EXPLOSIVE_ESSENCE = registerItem("explosive_essence",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item RUSTED_MARE_DIAMOND = registerItem("rusted_mare_diamond",
            new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item SUPPRESSED_ESSENCE_CIRTICT_AXE = registerItem("suppressed_essence_cirtict_axe",
            new CracklerAxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, 5, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item SUPPRESSED_ESSENCE_CIRTICT_PICKAXE = registerItem("suppressed_essence_cirtict_pickaxe",
            new CracklerPickaxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -3, -2.8f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item SUPPRESSED_ESSENCE_CIRTICT_SWORD = registerItem("suppressed_essence_cirtict_sword",
            new CracklerSword((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, 1, -2.4f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item SUPPRESSED_ESSENCE_CIRTICT_SHOVEL = registerItem("suppressed_essence_cirtict_shovel",
            new CracklerShovel((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -4, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item SUPPRESSED_ESSENCE_CIRTICT_KNIFE = registerItem("suppressed_essence_cirtict_knife",
            new CracklerKnife((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -7, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item SUPPRESSED_ESSENCE_CIRTICT_HOE = registerItem("suppressed_essence_cirtict_hoe",
            new CracklerHoe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -14, 0f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item SUPPRESSED_ESSENCE_CIRTICT_BATTLEAXE = registerItem("suppressed_essence_cirtict_battleaxe",
            new CracklerBattleaxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, 7, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));


    public static final Item PLAGUED_ESSENCE_CIRTICT_AXE = registerItem("plagued_essence_cirtict_axe",
            new SickenedAxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, 5, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item PLAGUED_ESSENCE_CIRTICT_PICKAXE = registerItem("plagued_essence_cirtict_pickaxe",
            new SickenedPickaxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -3, -2.8f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item PLAGUED_ESSENCE_CIRTICT_SWORD = registerItem("plagued_essence_cirtict_sword",
            new SickenedSword((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, 1, -2.4f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item PLAGUED_ESSENCE_CIRTICT_SHOVEL = registerItem("plagued_essence_cirtict_shovel",
            new SickenedShovel((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -4, -3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item PLAGUED_ESSENCE_CIRTICT_KNIFE = registerItem("plagued_essence_cirtict_knife",
            new SickenedKnife((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -7, -1f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item PLAGUED_ESSENCE_CIRTICT_HOE = registerItem("plagued_essence_cirtict_hoe",
            new SickenedHoe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, -14, 0f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item PLAGUED_ESSENCE_CIRTICT_BATTLEAXE = registerItem("plagued_essence_cirtict_battleaxe",
            new SickenedBattleaxe((ToolMaterial) MoreWeaponryToolMaterials.ESSENCE_CIRTICT, 7, -3.3f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WATCHER_SPAWN_EGG = registerItem("watcher_spawn_egg",
            new SpawnEggItem(MoreWeaponryEntities.WATCHER,0xC938FF, 0x420059,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item BARD_SPAWN_EGG = registerItem("bard_spawn_egg",
            new SpawnEggItem(MoreWeaponryEntities.BARD,0xF2F2F2, 0x7A7EDB,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item SICKENED_SPAWN_EGG = registerItem("sickened_spawn_egg",
            new SpawnEggItem(MoreWeaponryEntities.SICKENED,0x447C3D, 0x335B2C,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item LURKER_SPAWN_EGG = registerItem("lurker_spawn_egg",
            new SpawnEggItem(MoreWeaponryEntities.LURKER,0x271A2D, 0x3B2744,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WANDERER_SPAWN_EGG = registerItem("wanderer_spawn_egg",
            new SpawnEggItem(MoreWeaponryEntities.WANDERER, 0x4C4138, 0x302924,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WANDERER_HELMET = registerItem("wanderer_helmet",
            new WandererEffectItem(MoreWeaponryArmorMaterials.WANDERER, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item WANDERER_CHESTPLATE = registerItem("wanderer_chestplate",
            new WandererEffectItem(MoreWeaponryArmorMaterials.WANDERER, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CRACKLER_SPAWN_EGG = registerItem("crackler_spawn_egg",
            new SpawnEggItem(MoreWeaponryEntities.CRACKLER, 0xBDEAB2, 0xAAE59C,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CRACKLER_HELMET = registerItem("crackler_helmet",
            new CracklerEffectItem(MoreWeaponryArmorMaterials.CRACKLER, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CRACKLER_CHESTPLATE = registerItem("crackler_chestplate",
            new CracklerEffectItem(MoreWeaponryArmorMaterials.CRACKLER, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item BARD_HELMET = registerItem("bard_helmet",
            new BardEffectItem(MoreWeaponryArmorMaterials.BARD, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item BARD_CHESTPLATE = registerItem("bard_chestplate",
            new BardEffectItem(MoreWeaponryArmorMaterials.BARD, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item SICKENED_HELMET = registerItem("sickened_helmet",
            new SickenedEffectItem(MoreWeaponryArmorMaterials.SICKENED, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item SICKENED_CHESTPLATE = registerItem("sickened_chestplate",
            new SickenedEffectItem(MoreWeaponryArmorMaterials.SICKENED, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item RUSTED_MARE_DIAMOND_HELMET = registerItem("rusted_mare_diamond_helmet",
            new ArmorItem(MoreWeaponryArmorMaterials.RUSTED, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item HEAVY_SWORD = registerItem("heavy_sword",
            new HeavySwordItem((ToolMaterial) ToolMaterials.IRON, 11, -3.0f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item HEAVY_CROSSBOW = registerItem("heavy_crossbow",
            new HeavyCrossBowItem(new FabricItemSettings().maxDamage(521).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item IRON_BOLT = registerItem("iron_bolt",
            new IronBoltItem(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item BOTHERING_MIGHT = registerItem("bothering_might",
            new BotheringMightSwordItem((ToolMaterial) ToolMaterials.DIAMOND, 12, -2.5f,
                    new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CELESTIAL_MEDALLION = registerItem("celestial_medallion",
            new CelestialMadalianItem(new FabricItemSettings().maxDamage(107).group(MoreWeaponryItemGroup.MORE_WEAPONRY)));

    public static final Item CELESTIAL_MEDALLION_SICKENED = registerItem("celestial_medallion_sickened",
            new SickenedCelestialMedallionItem(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item CELESTIAL_MEDALLION_SICKENED_HUSK = registerItem("celestial_medallion_sickened_husk",
            new SickenedHuskCelestialMadalianItem(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item CELESTIAL_MEDALLION_CRACKLER = registerItem("celestial_medallion_crackler",
            new CracklerCelestialMedallionItem(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item CELESTIAL_MEDALLION_BARD = registerItem("celestial_medallion_bard",
            new BardCelestialMedallionItem(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item CELESTIAL_MEDALLION_WANDERER = registerItem("celestial_medallion_wanderer",
            new WandererCelestialMedallionItem(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
    public static final Item CELESTIAL_MEDALLION_WATCHER = registerItem("celestial_medallion_watcher",
            new WatcherCelestialMedallionItem(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));


    public static Item registerItem (String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MoreWeaponry.MOD_ID, name), item);
    }

    public static void registerMoreWeaponryItems() {
        MoreWeaponry.LOGGER.info("Registering More Weaponry Items for " + MoreWeaponry.MOD_ID);
    }

}
