package net.DakotaPride.moreweaponry.entity.client.armor;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.item.custom.crackler_tools.CracklerArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CracklerArmorModel extends AnimatedGeoModel<CracklerArmorItem> {

    @Override
    public Identifier getModelLocation(CracklerArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/crackler_armor.geo.json");
    }

    @Override
    public Identifier getTextureLocation(CracklerArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/crackler_armor.png");
    }

    @Override
    public Identifier getAnimationFileLocation(CracklerArmorItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/crackler_armor_animation.json");
    }
}
