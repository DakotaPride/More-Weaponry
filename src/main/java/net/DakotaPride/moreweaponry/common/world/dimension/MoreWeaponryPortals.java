package net.DakotaPride.moreweaponry.common.world.dimension;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
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
