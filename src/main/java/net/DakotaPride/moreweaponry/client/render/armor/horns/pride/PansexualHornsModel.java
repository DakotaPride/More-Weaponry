package net.DakotaPride.moreweaponry.client.render.armor.horns.pride;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.BisexualHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.PansexualHornsItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PansexualHornsModel extends AnimatedGeoModel<PansexualHornsItem> {

    @Override
    public Identifier getModelLocation(PansexualHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/base_horns.geo.json");
    }

    @Override
    public Identifier getTextureLocation(PansexualHornsItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/pansexual_horns.png");
    }

    @Override
    public Identifier getAnimationFileLocation(PansexualHornsItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/base_horns_animation.json");
    }
}
