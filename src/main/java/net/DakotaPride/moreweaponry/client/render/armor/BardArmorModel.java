package net.DakotaPride.moreweaponry.client.render.armor;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.bard_tools.BardArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BardArmorModel extends AnimatedGeoModel<BardArmorItem> {

    @Override
    public Identifier getModelLocation(BardArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/bard_armor.geo.json");
    }

    @Override
    public Identifier getTextureLocation(BardArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/bard_armor.png");
    }

    @Override
    public Identifier getAnimationFileLocation(BardArmorItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/bard_armor_animation.json");
    }
}
