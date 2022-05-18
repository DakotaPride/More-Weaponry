package net.DakotaPride.moreweaponry.client.render.armor.horns.colours;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.BlueHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.PinkHornsItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PinkHornsModel extends AnimatedGeoModel<PinkHornsItem> {

    @Override
    public Identifier getModelLocation(PinkHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/base_horns.geo.json");
    }

    @Override
    public Identifier getTextureLocation(PinkHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/pink_horns.png");
    }

    @Override
    public Identifier getAnimationFileLocation(PinkHornsItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/base_horns_animation.json");
    }
}
