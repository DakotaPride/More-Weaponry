package net.DakotaPride.moreweaponry.client.render.model;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.LurkerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LurkerModel extends AnimatedGeoModel<LurkerEntity> {
    @Override
    public Identifier getModelResource(LurkerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/lurker.geo.json");
    }

    @Override
    public Identifier getTextureResource(LurkerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/lurker/lurker.png");
    }

    @Override
    public Identifier getAnimationResource(LurkerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/lurker.animation.json");
    }

}
