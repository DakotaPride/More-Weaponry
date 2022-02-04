package net.DakotaPride.moreweaponry.recipe;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MoreWeaponry.MOD_ID, EssenceUpgraderRecipe.Serializer.ID),
                EssenceUpgraderRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(MoreWeaponry.MOD_ID, EssenceUpgraderRecipe.Type.ID),
                EssenceUpgraderRecipe.Type.INSTANCE);
    }
}
