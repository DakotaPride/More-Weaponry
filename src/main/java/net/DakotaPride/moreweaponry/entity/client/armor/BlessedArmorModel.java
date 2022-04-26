package net.DakotaPride.moreweaponry.entity.client.armor;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.item.custom.bard_tools.BardArmorItem;
import net.DakotaPride.moreweaponry.item.custom.blessed_tools.BlessedArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BlessedArmorModel extends AnimatedGeoModel<BlessedArmorItem> {

    @Override
    public Identifier getModelLocation(BlessedArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/blessed_armor.geo.json");
    }

    @Override
    public Identifier getTextureLocation(BlessedArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/blessed_armor_16x.png");
    }

    @Override
    public Identifier getAnimationFileLocation(BlessedArmorItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/blessed_armor.animation.json");
    }
}
