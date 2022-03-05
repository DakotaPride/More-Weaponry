package net.DakotaPride.moreweaponry.enchantments;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.security.Guard;

public class MoreWeaponryEnchantments {

    public static Enchantment EVOKERS_REVENGE = register("evokers_revenge",
            new EvokersRevengeEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON));

    public static Enchantment POWER_OF_THE_WITHER = register("power_of_the_wither",
            new PowerOfTheWitherEnchantment(Enchantment.Rarity.RARE,
                    EnchantmentTarget.BOW));

    public static Enchantment STRAY_BONAGE = register("stray_bonage",
            new StrayBonageEnchantment(Enchantment.Rarity.RARE,
                    EnchantmentTarget.BOW));

    public static Enchantment GUARDIANS_SMITE = register("guardians_smite",
            new GuardiansSmiteEnchantment(Enchantment.Rarity.RARE,
                    EnchantmentTarget.WEAPON));

    public static Enchantment AUTO_MENDING = register("auto_mending",
            new AutoMendingEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.ARMOR_CHEST));


    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(MoreWeaponry.MOD_ID, name), enchantment);
    }


    public static void registerModEnchantments() {

        System.out.println("Registering ModEnchantments for " + MoreWeaponry.MOD_ID);

    }
}
