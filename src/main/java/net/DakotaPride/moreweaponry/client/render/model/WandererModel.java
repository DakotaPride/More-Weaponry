package net.DakotaPride.moreweaponry.client.render.model;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.WandererEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WandererModel extends AnimatedGeoModel<WandererEntity> {
    @Override
    public Identifier getModelResource(WandererEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/wanderer.geo.json");
    }

    @Override
    public Identifier getTextureResource(WandererEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/wanderer/lurker.png");
    }

    @Override
    public Identifier getAnimationResource(WandererEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/wanderer.animation.json");
    }

}
