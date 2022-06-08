package net.DakotaPride.moreweaponry.client.render.armor.horns.pride;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.NonBinaryHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.TransgenderHornsItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TransgenderHornsModel extends AnimatedGeoModel<TransgenderHornsItem> {

    @Override
    public Identifier getModelResource(TransgenderHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/base_horns.geo.json");
    }

    @Override
    public Identifier getTextureResource(TransgenderHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/transgender_horns.png");
    }

    @Override
    public Identifier getAnimationResource(TransgenderHornsItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/base_horns_animation.json");
    }
}
