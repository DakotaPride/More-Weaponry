package net.DakotaPride.moreweaponry.client.render.armor.horns.pride;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.BisexualHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.NonBinaryHornsItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BisexualHornsModel extends AnimatedGeoModel<BisexualHornsItem> {

    @Override
    public Identifier getModelLocation(BisexualHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/base_horns.geo.json");
    }

    @Override
    public Identifier getTextureLocation(BisexualHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/bisexual_horns.png");
    }

    @Override
    public Identifier getAnimationFileLocation(BisexualHornsItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/base_horns_animation.json");
    }
}
