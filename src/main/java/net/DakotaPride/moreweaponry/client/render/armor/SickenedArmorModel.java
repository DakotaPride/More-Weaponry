package net.DakotaPride.moreweaponry.client.render.armor;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.sickened_tools.SickenedArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SickenedArmorModel extends AnimatedGeoModel<SickenedArmorItem> {

    @Override
    public Identifier getModelResource(SickenedArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/sickened_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(SickenedArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/sickened_armor.png");
    }

    @Override
    public Identifier getAnimationResource(SickenedArmorItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/sickened_armor_animation.json");
    }
}
