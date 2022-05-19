package net.DakotaPride.moreweaponry.client.render.armor.horns.colours;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.BlackHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.BlueHornsItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BlackHornsModel extends AnimatedGeoModel<BlackHornsItem> {

    @Override
    public Identifier getModelLocation(BlackHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/base_horns.geo.json");
    }

    @Override
    public Identifier getTextureLocation(BlackHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/black_horns.png");
    }

    @Override
    public Identifier getAnimationFileLocation(BlackHornsItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/base_horns_animation.json");
    }
}
