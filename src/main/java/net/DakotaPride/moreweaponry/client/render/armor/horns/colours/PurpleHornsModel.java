package net.DakotaPride.moreweaponry.client.render.armor.horns.colours;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.BlueHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.PurpleHornsItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PurpleHornsModel extends AnimatedGeoModel<PurpleHornsItem> {

    @Override
    public Identifier getModelLocation(PurpleHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/base_horns.geo.json");
    }

    @Override
    public Identifier getTextureLocation(PurpleHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/purple_horns.png");
    }

    @Override
    public Identifier getAnimationFileLocation(PurpleHornsItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/base_horns_animation.json");
    }
}
