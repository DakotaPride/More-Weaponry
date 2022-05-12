package net.DakotaPride.moreweaponry.common.util;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.HeavyCrossBowItem;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class MoreWeaponryModelPredicateProvider extends ModelPredicateProviderRegistry {
    public static void registerMoreWeaponryModels() {
        register(MoreWeaponry.HEAVY_CROSSBOW, new Identifier("pulling"), (stack, world, entity, seed) ->
                (entity != null && entity.isUsingItem() && entity.getActiveItem()
                        == stack && !HeavyCrossBowItem.isCharged(stack)) ? 1.0F : 0.0F);
        register(MoreWeaponry.HEAVY_CROSSBOW, new Identifier("charged"), (stack, world, entity, seed) ->
                (entity != null && HeavyCrossBowItem.isCharged(stack)) ? 1.0F : 0.0F);
        register(MoreWeaponry.HEAVY_CROSSBOW, new Identifier("firework"), (stack, world, entity, seed) ->
                (entity != null && HeavyCrossBowItem.isCharged(stack)
                        && HeavyCrossBowItem.hasProjectile(stack, Items.FIREWORK_ROCKET)) ? 1.0F : 0.0F);
        register(MoreWeaponry.HEAVY_CROSSBOW, new Identifier("pull"), (stack, world, entity, seed) -> (entity == null)
                ? 0.0F : (HeavyCrossBowItem.isCharged(stack) ? 0.0F :
                ((stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / HeavyCrossBowItem.getPullTime(stack))));
    }

}
