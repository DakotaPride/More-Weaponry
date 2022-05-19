package net.DakotaPride.moreweaponry.client.render.armor.horns.colours;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.BlackHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.WhiteHornsItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WhiteHornsModel extends AnimatedGeoModel<WhiteHornsItem> {

    @Override
    public Identifier getModelLocation(WhiteHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/base_horns.geo.json");
    }

    @Override
    public Identifier getTextureLocation(WhiteHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/white_horns.png");
    }

    @Override
    public Identifier getAnimationFileLocation(WhiteHornsItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/base_horns_animation.json");
    }
}
