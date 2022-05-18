package net.DakotaPride.moreweaponry.client.render.armor.horns.colours;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.OrangeHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.RedHornsItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OrangeHornsModel extends AnimatedGeoModel<OrangeHornsItem> {

    @Override
    public Identifier getModelLocation(OrangeHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/base_horns.geo.json");
    }

    @Override
    public Identifier getTextureLocation(OrangeHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/orange_horns.png");
    }

    @Override
    public Identifier getAnimationFileLocation(OrangeHornsItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/base_horns_animation.json");
    }
}
