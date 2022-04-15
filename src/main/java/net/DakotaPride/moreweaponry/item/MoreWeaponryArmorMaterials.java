package net.DakotaPride.moreweaponry.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum MoreWeaponryArmorMaterials implements ArmorMaterial
{
    GLIMMERING_AMETHYST("glimmering_amethyst", 14,
            new int[]{1, 4, 5, 2}, 13, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME,
            0.0f, 0.0f, () -> Ingredient.ofItems(MoreWeaponryItems.GLIMMERING_AMETHYST)),
    REFINED_MOON_STONE("refined_moon_stone", 16,
            new int[]{3, 4, 7, 1}, 10, SoundEvents.BLOCK_NOTE_BLOCK_CHIME,
            0.0f, 0.0f, () -> Ingredient.ofItems(MoreWeaponryItems.REFINED_MOON_STONE)),
    BLACKSTONE_METAL("blackstone_metal", 38,
            new int[]{3, 7, 8, 4}, 16, SoundEvents.BLOCK_BASALT_PLACE,
            3.5f, 0.2f, () -> Ingredient.ofItems(MoreWeaponryItems.BLACKSTONE_INGOT)),
    RUSTED("rusted_mare_diamond", 38,
            new int[]{3, 7, 8, 4}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
            3.5f, 0.2f, () -> Ingredient.ofItems(MoreWeaponryItems.BLACKSTONE_INGOT)),
    GUARDIAN_SCALE("guardian_scale", 40,
            new int[]{4, 8, 8, 5}, 17, SoundEvents.ENTITY_GUARDIAN_AMBIENT,
            3.5f, 0.3f, () -> Ingredient.ofItems(MoreWeaponryItems.GUARDIAN_SCALE)),
    ELDER_GUARDIAN_SCALE("elder_guardian_scale", 42,
            new int[]{5, 8, 9, 6}, 19, SoundEvents.ENTITY_ELDER_GUARDIAN_AMBIENT,
            4.0f, 0.4f, () -> Ingredient.ofItems(MoreWeaponryItems.ELDER_GUARDIAN_SCALE)),
    PHANTOM_SCALE("phantom_scale", 23,
            new int[]{5, 7, 6, 5}, 18, SoundEvents.ENTITY_PHANTOM_BITE,
            3.5f, 0.3f, () -> Ingredient.ofItems(MoreWeaponryItems.PHANTOM_SCALE)),
    ENDER("ender", 45,
            new int[]{10, 13, 12, 11}, 21, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            4.5f, 0.5f, () -> Ingredient.ofItems(MoreWeaponryItems.WATCHER_CLOTH)),
    WANDERER("wanderer", 45,
            new int[]{9, 12, 11, 10}, 21, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            4.5f, 0.5f, () -> Ingredient.ofItems(MoreWeaponryItems.WRETCHED_ESSENCE)),
    CRACKLER("crackler", 45,
            new int[]{7, 10, 9, 8}, 21, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            4.5f, 0.5f, () -> Ingredient.ofItems(MoreWeaponryItems.MELODIC_ESSENCE)),
    BARD("bard", 45,
            new int[]{8, 11, 10, 9}, 21, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            4.5f, 0.5f, () -> Ingredient.ofItems(MoreWeaponryItems.LEECHING_ESSENCE)),
    SICKENED("sickened", 45,
            new int[]{6, 9, 8, 7}, 21, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            4.5f, 0.5f, () -> Ingredient.ofItems(MoreWeaponryItems.EXPLOSIVE_ESSENCE)),
    SHULKER_SHELL("shulker_shell", 25,
            new int[]{5, 9, 8, 6}, 17, SoundEvents.BLOCK_SHULKER_BOX_OPEN,
            5.0f, 0.6f, () -> Ingredient.ofItems(Items.SHULKER_SHELL)),
    CIRTICT("cirtict", 51,
            new int[]{6, 9, 10, 7}, 16, SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE,
            6.5f, 0.7f, () -> Ingredient.ofItems(MoreWeaponryItems.CIRTICT_INGOT)),
    HEATED_CIRTICT("heated_cirtict", 57,
            new int[]{7, 10, 11, 8}, 17, SoundEvents.ITEM_BUCKET_EMPTY_LAVA,
            7.5f, 0.9f, () -> Ingredient.ofItems(MoreWeaponryItems.HEATED_CIRTICT_INGOT)),
    COOLED_CIRTICT("cooled_cirtict", 57,
            new int[]{7, 10, 11, 8}, 17, SoundEvents.ITEM_BUCKET_EMPTY_POWDER_SNOW,
            7.5f, 0.9f, () -> Ingredient.ofItems(MoreWeaponryItems.COOLED_CIRTICT_INGOT));

    private static final int[] BASE_DURABILITY;
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private MoreWeaponryArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy<Ingredient>(repairIngredientSupplier);
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    static {
        BASE_DURABILITY = new int[]{13, 15, 16, 11};
    }
}