package net.DakotaPride.moreweaponry.client.render.armor.horns.pride;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.NonBinaryHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.RainbowHornsItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NonBinaryHornsModel extends AnimatedGeoModel<NonBinaryHornsItem> {

    @Override
    public Identifier getModelLocation(NonBinaryHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/base_horns.geo.json");
    }

    @Override
    public Identifier getTextureLocation(NonBinaryHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/nonbinary_horns.png");
    }

    @Override
    public Identifier getAnimationFileLocation(NonBinaryHornsItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/base_horns_animation.json");
    }
}
