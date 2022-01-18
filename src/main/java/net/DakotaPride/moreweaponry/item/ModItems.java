package net.DakotaPride.moreweaponry.item;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.DakotaPride.moreweaponry.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.DakotaPride.moreweaponry.item.custom.ModAxeItem;

public class ModItems {

    public static final Item BLASTED_AMETHYST = registerItem("blasted_amethyst",
            new Item(new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item GLIMMERING_AMETHYST = registerItem("glimmering_amethyst",
            new Item(new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item MOON_STONE_DUST = registerItem("moon_stone_dust",
            new Item(new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item REFINED_MOON_STONE = registerItem("refined_moon_stone",
            new Item(new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item HANDLE = registerItem("handle",
            new ModHandleItem(new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item KURO_SEEDS = registerItem("kuro_seeds",
            new BlockItem(ModBlocks.KURO_PLANT, new FabricItemSettings().fireproof().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item KURO = registerItem("kuro",
            new Item(new FabricItemSettings().fireproof().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item KURO_BREAD = registerItem("kuro_bread",
            new Item(new FabricItemSettings().fireproof().rarity(Rarity.RARE).food
                    (new FoodComponent.Builder().alwaysEdible().hunger(10).statusEffect
                                    (new StatusEffectInstance(StatusEffects.ABSORPTION, 20*15), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20*5), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*20), 1f)
                            .saturationModifier(0.8f).build()).group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item CURON_BREW = registerItem("curon_brew",
            new ModStewItem(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).food
                    (new FoodComponent.Builder().alwaysEdible().hunger(16).statusEffect
                            (new StatusEffectInstance(StatusEffects.BLINDNESS, 20*10), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20*5), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20*5), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, 20*10), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 20*3), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 20*10), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*5), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20*10), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20*10), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 20*5), 1f)
                            .saturationModifier(1.0f).build()).group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item NITRIS_BOWL = registerItem("nitris_bowl",
            new Item(new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item CURON_FLOWER_PETALS = registerItem("curon_flower_petals",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).statusEffect
                    (new StatusEffectInstance(StatusEffects.WEAKNESS, 20*3), 0.5f)
                    .saturationModifier(1.0f).build()).group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item CONDENSED_KURO = registerItem("condensed_kuro",
            new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item CRUSHED_KURO = registerItem("crushed_kuro",
            new Item(new FabricItemSettings().food
                    (new FoodComponent.Builder().hunger(5).statusEffect
                                    (new StatusEffectInstance(StatusEffects.HASTE, 20*5), 0.5f)
                            .saturationModifier(1.0f).build()).fireproof().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item BLACKSTONE_INGOT = registerItem("blackstone_ingot",
            new Item(new FabricItemSettings().fireproof().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item NETHERITE_HANDLE = registerItem("netherite_handle",
            new ModHandleItem(new FabricItemSettings().fireproof().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item MARE_DIAMOND = registerItem("mare_diamond",
            new Item(new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item NETHERITE_NUGGET = registerItem("netherite_nugget",
            new Item(new FabricItemSettings().fireproof().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item AMETHYST_HANDLE = registerItem("amethyst_handle",
            new ModHandleItem(new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item GUARDIAN_SCALE = registerItem("guardian_scale",
            new Item(new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item ELDER_GUARDIAN_SCALE = registerItem("elder_guardian_scale",
            new Item(new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item ELDER_GUARDIANS_EYE = registerItem("elder_guardians_eye",
            new Item(new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item PRISMARINE_HANDLE = registerItem("prismarine_handle",
            new ModHandleItem(new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));


    public static final Item GLIMMERING_SWORD = registerItem("glimmering_sword",
            new SwordItem((ToolMaterial) ModToolMaterial.GLIMMERING_AMETHYST, 3, -2.4f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item GLIMMERING_SHOVEL = registerItem("glimmering_shovel",
            new ShovelItem((ToolMaterial) ModToolMaterial.GLIMMERING_AMETHYST, 1, -3f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item GLIMMERING_PICKAXE = registerItem("glimmering_pickaxe",
            new ModPickaxeItem((ToolMaterial) ModToolMaterial.GLIMMERING_AMETHYST, 1, -2.8f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item GLIMMERING_AXE = registerItem("glimmering_axe",
            new ModAxeItem((ToolMaterial) ModToolMaterial.GLIMMERING_AMETHYST, 5, -3f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item GLIMMERING_HOE = registerItem("glimmering_hoe",
            new ModHoeItem((ToolMaterial) ModToolMaterial.GLIMMERING_AMETHYST, -1, 0f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item GLIMMERING_BATTLEAXE = registerItem("glimmering_battleaxe",
            new ModBattleaxeItem((ToolMaterial) ModToolMaterial.GLIMMERING_AMETHYST, 8, -3.5f,
                    new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item MOON_STONE_SWORD = registerItem("moon_stone_sword",
            new SwordItem((ToolMaterial) ModToolMaterial.REFINED_MOON_STONE, 5, -1.8f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item MOON_STONE_SHOVEL = registerItem("moon_stone_shovel",
            new ShovelItem((ToolMaterial) ModToolMaterial.REFINED_MOON_STONE, 1, -2.5f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item MOON_STONE_PICKAXE = registerItem("moon_stone_pickaxe",
            new ModPickaxeItem((ToolMaterial) ModToolMaterial.REFINED_MOON_STONE, 2, -2.4f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item MOON_STONE_AXE = registerItem("moon_stone_axe",
            new ModAxeItem((ToolMaterial) ModToolMaterial.REFINED_MOON_STONE, 7, -2.8f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item MOON_STONE_HOE = registerItem("moon_stone_hoe",
            new ModHoeItem((ToolMaterial) ModToolMaterial.REFINED_MOON_STONE, 0, -0.1f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item MOON_STONE_BATTLEAXE = registerItem("moon_stone_battleaxe",
            new ModBattleaxeItem((ToolMaterial) ModToolMaterial.REFINED_MOON_STONE, 10, -3.2f,
                    new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item BLACKSTONE_METAL_SWORD = registerItem("blackstone_metal_sword",
            new SwordItem((ToolMaterial) ModToolMaterial.BLACKSTONE_METAL, 8, -2f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item BLACKSTONE_METAL_SHOVEL = registerItem("blackstone_metal_shovel",
            new ShovelItem((ToolMaterial) ModToolMaterial.BLACKSTONE_METAL, 2, -2.5f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item BLACKSTONE_METAL_PICKAXE = registerItem("blackstone_metal_pickaxe",
            new ModPickaxeItem((ToolMaterial) ModToolMaterial.BLACKSTONE_METAL, 3, -2.3f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item BLACKSTONE_METAL_AXE = registerItem("blackstone_metal_axe",
            new ModAxeItem((ToolMaterial) ModToolMaterial.BLACKSTONE_METAL, 12, -3.4f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item BLACKSTONE_METAL_HOE = registerItem("blackstone_metal_hoe",
            new ModHoeItem((ToolMaterial) ModToolMaterial.BLACKSTONE_METAL, 1, -0.1f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item BLACKSTONE_METAL_BATTLEAXE = registerItem("blackstone_metal_battleaxe",
            new ModBattleaxeItem((ToolMaterial) ModToolMaterial.BLACKSTONE_METAL, 15, -3.4f,
                    new FabricItemSettings().rarity(Rarity.EPIC).group(ModItemGroup.MORE_WEAPONRY)));


    public static final Item NETHERITE_BATTLEAXE = registerItem("netherite_battleaxe",
            new ModBattleaxeItem((ToolMaterial) ModToolMaterial.OG_NETHERITE, 11, -3.3f,
                    new FabricItemSettings().rarity(Rarity.EPIC).group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item DIAMOND_BATTLEAXE = registerItem("diamond_battleaxe",
            new ModBattleaxeItem((ToolMaterial) ModToolMaterial.OG_DIAMOND, 9, -3.4f,
                    new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item GLIMMERING_HELMET = registerItem("glimmering_helmet",
            new ArmorItem(ModArmorMaterial.GLIMMERING_AMETHYST, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item GLIMMERING_CHESTPLATE = registerItem("glimmering_chestplate",
            new ArmorItem(ModArmorMaterial.GLIMMERING_AMETHYST, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item GLIMMERING_LEGGINGS = registerItem("glimmering_leggings",
            new ArmorItem(ModArmorMaterial.GLIMMERING_AMETHYST, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item GLIMMERING_BOOTS = registerItem("glimmering_boots",
            new ArmorItem(ModArmorMaterial.GLIMMERING_AMETHYST, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item MOON_STONE_HELMET = registerItem("moon_stone_helmet",
            new ArmorItem(ModArmorMaterial.REFINED_MOON_STONE, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item MOON_STONE_CHESTPLATE = registerItem("moon_stone_chestplate",
            new ArmorItem(ModArmorMaterial.REFINED_MOON_STONE, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item MOON_STONE_LEGGINGS = registerItem("moon_stone_leggings",
            new ArmorItem(ModArmorMaterial.REFINED_MOON_STONE, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item MOON_STONE_BOOTS = registerItem("moon_stone_boots",
            new ArmorItem(ModArmorMaterial.REFINED_MOON_STONE, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item BLACKSTONE_METAL_HELMET = registerItem("blackstone_metal_helmet",
            new ArmorItem(ModArmorMaterial.BLACKSTONE_METAL, EquipmentSlot.HEAD,
                    new FabricItemSettings().rarity(Rarity.EPIC).group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item BLACKSTONE_METAL_CHESTPLATE = registerItem("blackstone_metal_chestplate",
            new ArmorItem(ModArmorMaterial.BLACKSTONE_METAL, EquipmentSlot.CHEST,
                    new FabricItemSettings().rarity(Rarity.EPIC).group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item BLACKSTONE_METAL_LEGGINGS = registerItem("blackstone_metal_leggings",
            new ArmorItem(ModArmorMaterial.BLACKSTONE_METAL, EquipmentSlot.LEGS,
                    new FabricItemSettings().rarity(Rarity.EPIC).group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item BLACKSTONE_METAL_BOOTS = registerItem("blackstone_metal_boots",
            new ArmorItem(ModArmorMaterial.BLACKSTONE_METAL, EquipmentSlot.FEET,
                    new FabricItemSettings().rarity(Rarity.EPIC).group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item ELDER_GUARDIAN_SCALE_HELMET = registerItem("elder_guardian_scale_helmet",
            new ModArmorItem(ModArmorMaterial.ELDER_GUARDIAN_SCALE, EquipmentSlot.HEAD,
                    new FabricItemSettings().rarity(Rarity.EPIC).group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item ELDER_GUARDIAN_SCALE_CHESTPLATE = registerItem("elder_guardian_scale_chestplate",
            new ModArmorItem(ModArmorMaterial.ELDER_GUARDIAN_SCALE, EquipmentSlot.CHEST,
                    new FabricItemSettings().rarity(Rarity.EPIC).group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item ELDER_GUARDIAN_SCALE_LEGGINGS = registerItem("elder_guardian_scale_leggings",
            new ModArmorItem(ModArmorMaterial.ELDER_GUARDIAN_SCALE, EquipmentSlot.LEGS,
                    new FabricItemSettings().rarity(Rarity.EPIC).group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item ELDER_GUARDIAN_SCALE_BOOTS = registerItem("elder_guardian_scale_boots",
            new ModArmorItem(ModArmorMaterial.ELDER_GUARDIAN_SCALE, EquipmentSlot.FEET,
                    new FabricItemSettings().rarity(Rarity.EPIC).group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item ELDER_GUARDIAN_SCALE_SWORD = registerItem("elder_guardian_scale_sword",
            new SwordItem((ToolMaterial) ModToolMaterial.ELDER_GUARDIAN_SCALE, 5, -1.8f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item ELDER_GUARDIAN_SCALE_SHOVEL = registerItem("elder_guardian_scale_shovel",
            new ShovelItem((ToolMaterial) ModToolMaterial.ELDER_GUARDIAN_SCALE, 1, -2.5f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item ELDER_GUARDIAN_SCALE_PICKAXE = registerItem("elder_guardian_scale_pickaxe",
            new ModPickaxeItem((ToolMaterial) ModToolMaterial.ELDER_GUARDIAN_SCALE, 2, -2.4f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item ELDER_GUARDIAN_SCALE_AXE = registerItem("elder_guardian_scale_axe",
            new ModAxeItem((ToolMaterial) ModToolMaterial.ELDER_GUARDIAN_SCALE, 7, -2.8f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item ELDER_GUARDIAN_SCALE_HOE = registerItem("elder_guardian_scale_hoe",
            new ModHoeItem((ToolMaterial) ModToolMaterial.ELDER_GUARDIAN_SCALE, 0, -0.1f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item ELDER_GUARDIAN_SCALE_BATTLEAXE = registerItem("elder_guardian_scale_battleaxe",
            new ModBattleaxeItem((ToolMaterial) ModToolMaterial.ELDER_GUARDIAN_SCALE, 10, -3.2f,
                    new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item GUARDIAN_SCALE_HELMET = registerItem("guardian_scale_helmet",
            new ArmorItem(ModArmorMaterial.GUARDIAN_SCALE, EquipmentSlot.HEAD,
                    new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item GUARDIAN_SCALE_CHESTPLATE = registerItem("guardian_scale_chestplate",
            new ArmorItem(ModArmorMaterial.GUARDIAN_SCALE, EquipmentSlot.CHEST,
                    new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item GUARDIAN_SCALE_LEGGINGS = registerItem("guardian_scale_leggings",
            new ArmorItem(ModArmorMaterial.GUARDIAN_SCALE, EquipmentSlot.LEGS,
                    new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item GUARDIAN_SCALE_BOOTS = registerItem("guardian_scale_boots",
            new ArmorItem(ModArmorMaterial.GUARDIAN_SCALE, EquipmentSlot.FEET,
                    new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item GUARDIAN_SCALE_SWORD = registerItem("guardian_scale_sword",
            new SwordItem((ToolMaterial) ModToolMaterial.GUARDIAN_SCALE, 5, -1.8f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item GUARDIAN_SCALE_SHOVEL = registerItem("guardian_scale_shovel",
            new ShovelItem((ToolMaterial) ModToolMaterial.ELDER_GUARDIAN_SCALE, 1, -2.5f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item GUARDIAN_SCALE_PICKAXE = registerItem("guardian_scale_pickaxe",
            new ModPickaxeItem((ToolMaterial) ModToolMaterial.GUARDIAN_SCALE, 2, -2.4f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item GUARDIAN_SCALE_AXE = registerItem("guardian_scale_axe",
            new ModAxeItem((ToolMaterial) ModToolMaterial.GUARDIAN_SCALE, 7, -2.8f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));
    public static final Item GUARDIAN_SCALE_HOE = registerItem("guardian_scale_hoe",
            new ModHoeItem((ToolMaterial) ModToolMaterial.GUARDIAN_SCALE, 0, -0.1f,
                    new FabricItemSettings().group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item GUARDIAN_SCALE_BATTLEAXE = registerItem("guardian_scale_battleaxe",
            new ModBattleaxeItem((ToolMaterial) ModToolMaterial.GUARDIAN_SCALE, 10, -3.2f,
                    new FabricItemSettings().rarity(Rarity.RARE).group(ModItemGroup.MORE_WEAPONRY)));

    public static final Item GLIMMERING_SHIELD = registerItem("glimmering_shield",
            new FabricShieldItem(new FabricItemSettings().maxDamage(1782).group(ModItemGroup.MORE_WEAPONRY), 20, 23, ModItems.GLIMMERING_AMETHYST));

    public static final Item BLACKSTONE_METAL_SHIELD = registerItem("blackstone_metal_shield",
            new FabricShieldItem(new FabricItemSettings().maxDamage(2476).rarity(Rarity.EPIC).group(ModItemGroup.MORE_WEAPONRY), 10, 17, ModItems.BLACKSTONE_INGOT));

    public static final Item MOON_STONE_SHIELD = registerItem("moon_stone_shield",
            new FabricShieldItem(new FabricItemSettings().maxDamage(2006).group(ModItemGroup.MORE_WEAPONRY), 15, 19, ModItems.REFINED_MOON_STONE));

    public static final Item GUARDIAN_SCALE_SHIELD = registerItem("guardian_scale_shield",
            new FabricShieldItem(new FabricItemSettings().maxDamage(2938).rarity(Rarity.UNCOMMON).group(ModItemGroup.MORE_WEAPONRY), 8, 17, ModItems.GUARDIAN_SCALE));

    public static final Item ELDER_SCALE_SHIELD  = registerItem("elder_scale_shield",
            new FabricShieldItem(new FabricItemSettings().maxDamage(3276).rarity(Rarity.EPIC).group(ModItemGroup.MORE_WEAPONRY), 7, 18, ModItems.ELDER_GUARDIAN_SCALE));

    public static final Item ELDER_SCALE_TRIDENT = registerItem("elder_scale_trident",
            new ElderScaleTridentItem(new FabricItemSettings().rarity(Rarity.EPIC).group(ModItemGroup.MORE_WEAPONRY)));


    private static Item registerItem (String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MoreWeaponry.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MoreWeaponry.LOGGER.info("Registering Mod Items for " + MoreWeaponry.MOD_ID);
    }

}
