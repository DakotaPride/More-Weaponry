package net.DakotaPride.moreweaponry.client.render.armor.horns.pride;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.BaseHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.RainbowHornsItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RainbowHornsModel extends AnimatedGeoModel<RainbowHornsItem> {

    @Override
    public Identifier getModelLocation(RainbowHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/base_horns.geo.json");
    }

    @Override
    public Identifier getTextureLocation(RainbowHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/rainbow_horns.png");
    }

    @Override
    public Identifier getAnimationFileLocation(RainbowHornsItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/base_horns_animation.json");
    }
}
