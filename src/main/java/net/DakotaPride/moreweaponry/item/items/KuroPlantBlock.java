package net.DakotaPride.moreweaponry.item.items;

import net.DakotaPride.moreweaponry.item.MoreWeaponryItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class KuroPlantBlock extends CropBlock {
    public KuroPlantBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return MoreWeaponryItems.KURO_SEEDS;
    }
}
