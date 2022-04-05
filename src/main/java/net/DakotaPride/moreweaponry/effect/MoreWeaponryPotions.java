package net.DakotaPride.moreweaponry.effect;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.item.MoreWeaponryItems;
import net.DakotaPride.moreweaponry.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreWeaponryPotions {
    public static Potion NUMBNESS_POTION;

    public static Potion registerNumbedPotion(String name) {
        return Registry.register(Registry.POTION, new Identifier(MoreWeaponry.MOD_ID, name),
                new Potion(new StatusEffectInstance(MoreWeaponryEffects.NUMBED, 200, 0)));
    }

    public static void registerMoreWeaponryPotions() {
        NUMBNESS_POTION = registerNumbedPotion("numbness_potion");


        registerMoreWeaponryPotionRecipes();
    }

    public static void registerMoreWeaponryPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, MoreWeaponryItems.CURON_FLOWER_PETALS,
                MoreWeaponryPotions.NUMBNESS_POTION);
    }
}
