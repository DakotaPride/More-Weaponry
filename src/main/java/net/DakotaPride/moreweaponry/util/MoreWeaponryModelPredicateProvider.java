package net.DakotaPride.moreweaponry.util;

import net.DakotaPride.moreweaponry.item.HeavyCrossBowItem;
import net.DakotaPride.moreweaponry.item.MoreWeaponryItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class MoreWeaponryModelPredicateProvider extends ModelPredicateProviderRegistry {
    public static void registerMoreWeaponryModels() {
        register(MoreWeaponryItems.HEAVY_CROSSBOW, new Identifier("pulling"), (stack, world, entity, seed) ->
                (entity != null && entity.isUsingItem() && entity.getActiveItem()
                        == stack && !HeavyCrossBowItem.isCharged(stack)) ? 1.0F : 0.0F);
        register(MoreWeaponryItems.HEAVY_CROSSBOW, new Identifier("charged"), (stack, world, entity, seed) ->
                (entity != null && HeavyCrossBowItem.isCharged(stack)) ? 1.0F : 0.0F);
        register(MoreWeaponryItems.HEAVY_CROSSBOW, new Identifier("firework"), (stack, world, entity, seed) ->
                (entity != null && HeavyCrossBowItem.isCharged(stack)
                        && HeavyCrossBowItem.hasProjectile(stack, Items.FIREWORK_ROCKET)) ? 1.0F : 0.0F);
    }

}
