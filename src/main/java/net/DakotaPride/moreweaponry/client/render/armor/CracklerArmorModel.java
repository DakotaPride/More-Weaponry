package net.DakotaPride.moreweaponry.client.render.armor;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.crackler_tools.CracklerArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CracklerArmorModel extends AnimatedGeoModel<CracklerArmorItem> {

    @Override
    public Identifier getModelResource(CracklerArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/crackler_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(CracklerArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/crackler_armor.png");
    }

    @Override
    public Identifier getAnimationResource(CracklerArmorItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/crackler_armor_animation.json");
    }
}
