package net.DakotaPride.moreweaponry.client.render.model;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.WatcherEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

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

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(WatcherEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("horns_head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
