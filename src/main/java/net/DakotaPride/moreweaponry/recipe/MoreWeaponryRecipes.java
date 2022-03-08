package net.DakotaPride.moreweaponry.recipe;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreWeaponryRecipes {
    public static void registerMoreWeaponryRecipes() {
        // Core Forge
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MoreWeaponry.MOD_ID, CoreForgeRecipe.Serializer.ID),
                CoreForgeRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(MoreWeaponry.MOD_ID, CoreForgeRecipe.Type.ID),
                CoreForgeRecipe.Type.INSTANCE);
        // Essence Translator
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MoreWeaponry.MOD_ID, EssenceTranslatorRecipe.Serializer.ID),
                EssenceTranslatorRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(MoreWeaponry.MOD_ID, EssenceTranslatorRecipe.Type.ID),
                EssenceTranslatorRecipe.Type.INSTANCE);
    }
}
