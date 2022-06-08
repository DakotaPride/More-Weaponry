package net.DakotaPride.moreweaponry.client.render.armor.horns.colours;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.OrangeHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.YellowHornsItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class YellowHornsModel extends AnimatedGeoModel<YellowHornsItem> {

    @Override
    public Identifier getModelResource(YellowHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/base_horns.geo.json");
    }

    @Override
    public Identifier getTextureResource(YellowHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/yellow_horns.png");
    }

    @Override
    public Identifier getAnimationResource(YellowHornsItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/base_horns_animation.json");
    }
}
