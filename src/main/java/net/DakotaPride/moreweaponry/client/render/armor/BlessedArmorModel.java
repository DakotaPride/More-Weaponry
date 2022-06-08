package net.DakotaPride.moreweaponry.client.render.armor;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.blessed_tools.BlessedArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BlessedArmorModel extends AnimatedGeoModel<BlessedArmorItem> {

    @Override
    public Identifier getModelResource(BlessedArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/blessed_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(BlessedArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/blessed_armor_16x.png");
    }

    @Override
    public Identifier getAnimationResource(BlessedArmorItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/blessed_armor.animation.json");
    }
}
