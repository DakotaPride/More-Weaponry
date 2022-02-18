package net.DakotaPride.moreweaponry.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial
{
    GLIMMERING_AMETHYST("glimmering_amethyst", 30,
            new int[]{2, 5, 6, 3}, 23, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME,
            0.0f, 0.0f, () -> Ingredient.ofItems(ModItems.GLIMMERING_AMETHYST)),
    REFINED_MOON_STONE("refined_moon_stone", 37,
            new int[]{4, 7, 6, 5}, 17, SoundEvents.BLOCK_NOTE_BLOCK_CHIME,
            0.5f, 0.1f, () -> Ingredient.ofItems(ModItems.REFINED_MOON_STONE)),
    BLACKSTONE_METAL("blackstone_metal", 41,
            new int[]{5, 8, 7, 6}, 14, SoundEvents.BLOCK_BASALT_PLACE,
            3.5f, 0.2f, () -> Ingredient.ofItems(ModItems.BLACKSTONE_INGOT)),
    GUARDIAN_SCALE("guardian_scale", 43,
            new int[]{7, 10, 9, 8}, 16, SoundEvents.ENTITY_GUARDIAN_AMBIENT,
            4.0f, 0.4f, () -> Ingredient.ofItems(ModItems.GUARDIAN_SCALE)),
    ELDER_GUARDIAN_SCALE("elder_guardian_scale", 47,
            new int[]{10, 13, 12, 11}, 20, SoundEvents.ENTITY_ELDER_GUARDIAN_AMBIENT,
            5.0f, 0.7f, () -> Ingredient.ofItems(ModItems.ELDER_GUARDIAN_SCALE)),
    PHANTOM_SCALE("phantom_scale", 45,
            new int[]{10, 14, 12, 11}, 17, SoundEvents.ENTITY_PHANTOM_BITE,
            5.0f, 0.7f, () -> Ingredient.ofItems(ModItems.PHANTOM_SCALE)),
    ENDER("ender", 53,
            new int[]{12, 16, 14, 13}, 18, SoundEvents.ENTITY_ENDER_DRAGON_FLAP,
            6.0f, 0.8f, () -> Ingredient.ofItems(ModItems.DRAGON_SCALE)),
    SHULKER_SHELL("shulker_shell", 49,
            new int[]{5, 9, 8, 6}, 19, SoundEvents.BLOCK_SHULKER_BOX_OPEN,
            7.0f, 0.9f, () -> Ingredient.ofItems(Items.SHULKER_SHELL)),
    CIRTICT("cirtict", 51,
            new int[]{11, 15, 13, 12}, 16, SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE,
            6.5f, 0.7f, () -> Ingredient.ofItems(ModItems.CIRTICT_INGOT)),
    HEATED_CIRTICT("heated_cirtict", 57,
            new int[]{13, 17, 15, 14}, 17, SoundEvents.ITEM_BUCKET_EMPTY_LAVA,
            7.5f, 0.9f, () -> Ingredient.ofItems(ModItems.HEATED_CIRTICT_INGOT)),
    COOLED_CIRTICT("cooled_cirtict", 57,
            new int[]{13, 17, 15, 14}, 17, SoundEvents.ITEM_BUCKET_EMPTY_POWDER_SNOW,
            7.5f, 0.9f, () -> Ingredient.ofItems(ModItems.COOLED_CIRTICT_INGOT));

    private static final int[] BASE_DURABILITY;
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private ModArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
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