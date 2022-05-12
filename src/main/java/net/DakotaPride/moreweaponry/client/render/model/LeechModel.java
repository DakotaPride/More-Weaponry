package net.DakotaPride.moreweaponry.client.render.model;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.LeechEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LeechModel extends AnimatedGeoModel<LeechEntity> {
    @Override
    public Identifier getModelLocation(LeechEntity object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/leech.geo.json");
    }

    @Override
    public Identifier getTextureLocation(LeechEntity object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/sickened/leech.png");
    }

    @Override
    public Identifier getAnimationFileLocation(LeechEntity animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/leech.animation.json");
    }
}
