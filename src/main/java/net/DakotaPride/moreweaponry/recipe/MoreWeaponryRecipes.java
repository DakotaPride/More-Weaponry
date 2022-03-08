package net.DakotaPride.moreweaponry.recipe;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreWeaponryRecipes {
    public static void registerMoreWeaponryRecipes() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MoreWeaponry.MOD_ID, CoreForgeRecipe.Serializer.ID),
                CoreForgeRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(MoreWeaponry.MOD_ID, CoreForgeRecipe.Type.ID),
                CoreForgeRecipe.Type.INSTANCE);
    }
}
