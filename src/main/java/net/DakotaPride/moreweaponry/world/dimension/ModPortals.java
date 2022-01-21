package net.DakotaPride.moreweaponry.world.dimension;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.DakotaPride.moreweaponry.item.ModItems;

public class ModPortals {
    public static void registerPortals() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.BLUESTONE)
                .lightWithItem(ModItems.BLUESTONE_IGNITOR)
                .destDimID(ModDimensions.EVER_FROST_KEY.getValue())
                .tintColor(138, 135, 158)
                .registerPortal();
    }
}
