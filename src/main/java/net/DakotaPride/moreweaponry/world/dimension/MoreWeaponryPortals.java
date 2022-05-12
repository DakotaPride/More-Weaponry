package net.DakotaPride.moreweaponry.world.dimension;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;

public class MoreWeaponryPortals {
    public static void registerMoreWeaponryPortals() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(MoreWeaponry.BLUESTONE)
                .lightWithItem(MoreWeaponry.BLUESTONE_IGNITOR)
                .destDimID(MoreWeaponryDimensions.EVER_FROST_KEY.getValue())
                .tintColor(138, 135, 158)
                .registerPortal();
    }
}
