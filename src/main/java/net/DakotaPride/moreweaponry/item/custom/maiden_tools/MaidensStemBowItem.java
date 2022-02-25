package net.DakotaPride.moreweaponry.item.custom.maiden_tools;

import net.minecraft.item.BowItem;

public class MaidensStemBowItem extends BowItem {
    public MaidensStemBowItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getRange() {
        return 30;
    }
}
