package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.WandererEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class WandererModel extends AnimatedGeoModel<WandererEntity> {
    @Override
    public Identifier getModelLocation(WandererEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/wanderer.geo.json");
    }

    @Override
    public Identifier getTextureLocation(WandererEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/wanderer/lurker.png");
    }

    @Override
    public Identifier getAnimationFileLocation(WandererEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/wanderer.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(WandererEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }

}
