package net.DakotaPride.moreweaponry.client.render.armor.horns.colours;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.RainbowHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.RedHornsItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RedHornsModel extends AnimatedGeoModel<RedHornsItem> {

    @Override
    public Identifier getModelLocation(RedHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/base_horns.geo.json");
    }

    @Override
    public Identifier getTextureLocation(RedHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/red_horns.png");
    }

    @Override
    public Identifier getAnimationFileLocation(RedHornsItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/base_horns_animation.json");
    }
}
