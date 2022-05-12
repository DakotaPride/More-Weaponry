package net.DakotaPride.moreweaponry.client.render.model;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.LurkerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LurkerModel extends AnimatedGeoModel<LurkerEntity> {
    @Override
    public Identifier getModelLocation(LurkerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/lurker.geo.json");
    }

    @Override
    public Identifier getTextureLocation(LurkerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/lurker/lurker.png");
    }

    @Override
    public Identifier getAnimationFileLocation(LurkerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/lurker.animation.json");
    }

}
