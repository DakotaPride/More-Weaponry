package net.DakotaPride.moreweaponry.client.render.armor.horns.colours;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.BlueHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.GreenHornsItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BlueHornsModel extends AnimatedGeoModel<BlueHornsItem> {

    @Override
    public Identifier getModelLocation(BlueHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/base_horns.geo.json");
    }

    @Override
    public Identifier getTextureLocation(BlueHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/blue_horns.png");
    }

    @Override
    public Identifier getAnimationFileLocation(BlueHornsItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/base_horns_animation.json");
    }
}
