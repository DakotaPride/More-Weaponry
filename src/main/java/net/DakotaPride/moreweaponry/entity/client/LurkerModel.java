package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.LurkerEntity;
import net.DakotaPride.moreweaponry.entity.custom.WatcherEntity;
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
