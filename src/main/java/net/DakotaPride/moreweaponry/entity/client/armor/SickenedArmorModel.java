package net.DakotaPride.moreweaponry.entity.client.armor;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.item.items.sickened_tools.SickenedArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SickenedArmorModel extends AnimatedGeoModel<SickenedArmorItem> {

    @Override
    public Identifier getModelLocation(SickenedArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/sickened_armor.geo.json");
    }

    @Override
    public Identifier getTextureLocation(SickenedArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/sickened_armor.png");
    }

    @Override
    public Identifier getAnimationFileLocation(SickenedArmorItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/sickened_armor_animation.json");
    }
}
