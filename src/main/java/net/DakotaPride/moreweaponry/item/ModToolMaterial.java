package net.DakotaPride.moreweaponry.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    
    GLIMMERING_AMETHYST(MiningLevels.IRON, 546, 6.5f,
            1.5f, 23,
            () -> Ingredient.ofItems(MoreWeaponryItems.GLIMMERING_AMETHYST)),
    REFINED_MOON_STONE(MiningLevels.DIAMOND, 1278,8.5f,
            2.5f, 17,
            () -> Ingredient.ofItems(MoreWeaponryItems.REFINED_MOON_STONE)),
    OG_NETHERITE(MiningLevels.NETHERITE, 2031, 9.0f,
            4.0f, 15,
            () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    OG_DIAMOND(MiningLevels.DIAMOND, 1561, 8.0f,
            3.0f, 10,
            () -> Ingredient.ofItems(Items.DIAMOND)),
    BLACKSTONE_METAL(MiningLevels.NETHERITE, 2176, 9.5f,
            4.5f, 16,
            () -> Ingredient.ofItems(MoreWeaponryItems.BLACKSTONE_INGOT)),
    GUARDIAN_SCALE(MoreWeaponryMiningLevels.GUARDIAN_SCALE, 2458, 10.0f,
            5.5f, 18,
            () -> Ingredient.ofItems(MoreWeaponryItems.GUARDIAN_SCALE)),
    ELDER_GUARDIAN_SCALE(MoreWeaponryMiningLevels.ELDER_GUARDIAN_SCALE, 2986, 10.5f,
            7.0f, 17,
            () -> Ingredient.ofItems(MoreWeaponryItems.ELDER_GUARDIAN_SCALE)),
    WITHERED(MiningLevels.NETHERITE, 3182, 11.0f,
    8.5f, 14,
            () -> Ingredient.ofItems(MoreWeaponryItems.WITHER_ESSENCE)),
    OG_IRON(MiningLevels.IRON, 250, 6.0f,
            2.0f, 14,
            () -> Ingredient.ofItems(Items.IRON_INGOT)),
    OG_WOOD(MiningLevels.WOOD, 59, 2.0f,
            0.0f, 15,
            () -> Ingredient.fromTag(ItemTags.PLANKS)),
    OG_STONE(MiningLevels.STONE, 131, 4.0f,
            1.0f, 5,
            () -> Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS)),
    OG_GOLD(MiningLevels.WOOD, 32, 12.0f,
            0.0f, 22,
            () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    COOLED_CIRTICT(MoreWeaponryMiningLevels.COOLED_CIRTICT, 3182, 12.0f,
            18.0f, 18,
            () -> Ingredient.ofItems(MoreWeaponryItems.COOLED_CIRTICT_INGOT)),
    CIRTICT(MoreWeaponryMiningLevels.CIRTICT, 3003, 11.5f,
            16.0f, 15,
            () -> Ingredient.ofItems(MoreWeaponryItems.CIRTICT_INGOT)),
    HEATED_CIRTICT(MoreWeaponryMiningLevels.HEATED_CIRTICT, 3182, 12.0f,
            18.0f, 18,
            () -> Ingredient.ofItems(MoreWeaponryItems.HEATED_CIRTICT_INGOT)),
    DRAGON_SCALE(MiningLevels.NETHERITE, 3486, 13.0f,
            19.5f, 18,
            () -> Ingredient.ofItems(MoreWeaponryItems.DRAGON_SCALE)),
    ENDICATE_STAFF(MiningLevels.NETHERITE, 388, 14.0f,
            20.0f, 23,
            () -> Ingredient.ofItems(Items.ENDER_EYE)),
    WATCHER_STAFF(MiningLevels.NETHERITE, 593, 14.0f,
            21.0f, 25,
            () -> Ingredient.ofItems(Items.ENDER_EYE)),
    ESSENCE_CIRTICT(MoreWeaponryMiningLevels.ESSENCE, 3875, 12.5f,
            21.0f, 24,
            () -> Ingredient.ofItems(MoreWeaponryItems.WITHER_ESSENCE));


    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}


