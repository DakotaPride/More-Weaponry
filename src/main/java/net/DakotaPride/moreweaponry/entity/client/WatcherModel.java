package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.WatcherEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WatcherModel extends AnimatedGeoModel<WatcherEntity> {
    @Override
    public Identifier getModelLocation(WatcherEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/watcher.geo.json");
    }

    @Override
    public Identifier getTextureLocation(WatcherEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/watcher/watcher.png");
    }

    @Override
    public Identifier getAnimationFileLocation(WatcherEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/watcher.animation.json");
    }
}
