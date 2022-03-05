package net.DakotaPride.moreweaponry.world.dimension;

import net.DakotaPride.moreweaponry.item.MoreWeaponryItems;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;

public class MoreWeaponryPortals {
    public static void registerMoreWeaponryPortals() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(MoreWeaponryBlocks.BLUESTONE)
                .lightWithItem(MoreWeaponryItems.BLUESTONE_IGNITOR)
                .destDimID(MoreWeaponryDimensions.EVER_FROST_KEY.getValue())
                .tintColor(138, 135, 158)
                .registerPortal();
    }
}
