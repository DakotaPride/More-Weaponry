package net.DakotaPride.moreweaponry.client.render.armor.horns;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.BaseHornsItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BaseHornsModel extends AnimatedGeoModel<BaseHornsItem> {

    @Override
    public Identifier getModelResource(BaseHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/base_horns.geo.json");
    }

    @Override
    public Identifier getTextureResource(BaseHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/base_horns.png");
    }

    @Override
    public Identifier getAnimationResource(BaseHornsItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/base_horns_animation.json");
    }
}
