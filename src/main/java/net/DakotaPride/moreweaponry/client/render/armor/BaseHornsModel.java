package net.DakotaPride.moreweaponry.client.render.armor;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.BaseHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.bard_tools.BardArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BaseHornsModel extends AnimatedGeoModel<BaseHornsItem> {

    @Override
    public Identifier getModelLocation(BaseHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/base_horns.geo.json");
    }

    @Override
    public Identifier getTextureLocation(BaseHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/base_horns.png");
    }

    @Override
    public Identifier getAnimationFileLocation(BaseHornsItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/base_horns_animation.json");
    }
}
