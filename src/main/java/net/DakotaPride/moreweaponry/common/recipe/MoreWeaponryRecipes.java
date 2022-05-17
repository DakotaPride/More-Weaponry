package net.DakotaPride.moreweaponry.common.recipe;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
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
        // Cirtict Forge
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MoreWeaponry.MOD_ID, CirtictForgeRecipe.Serializer.ID),
                CirtictForgeRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(MoreWeaponry.MOD_ID, CirtictForgeRecipe.Type.ID),
                CirtictForgeRecipe.Type.INSTANCE);
        // Fabricator
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MoreWeaponry.MOD_ID, FabricatorRecipe.Serializer.ID),
                FabricatorRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(MoreWeaponry.MOD_ID, FabricatorRecipe.Type.ID),
                FabricatorRecipe.Type.INSTANCE);
    }
}
