package net.DakotaPride.moreweaponry.client.render.model;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.SickenedEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class SickenedModel extends AnimatedGeoModel<SickenedEntity> {
    @Override
    public Identifier getModelLocation(SickenedEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/sickened.geo.json");
    }

    @Override
    public Identifier getTextureLocation(SickenedEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/sickened/sickened.png");
    }

    @Override
    public Identifier getAnimationFileLocation(SickenedEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/sickened.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(SickenedEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
