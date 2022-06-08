package net.DakotaPride.moreweaponry.client.render.armor.horns.colours;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.GreenHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.YellowHornsItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GreenHornsModel extends AnimatedGeoModel<GreenHornsItem> {

    @Override
    public Identifier getModelResource(GreenHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/base_horns.geo.json");
    }

    @Override
    public Identifier getTextureResource(GreenHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/green_horns.png");
    }

    @Override
    public Identifier getAnimationResource(GreenHornsItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/base_horns_animation.json");
    }
}
