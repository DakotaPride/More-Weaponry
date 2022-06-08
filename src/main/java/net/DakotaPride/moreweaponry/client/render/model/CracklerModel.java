package net.DakotaPride.moreweaponry.client.render.model;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.CracklerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class CracklerModel extends AnimatedGeoModel<CracklerEntity> {
    @Override
    public Identifier getModelResource(CracklerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/crackler.geo.json");
    }

    @Override
    public Identifier getTextureResource(CracklerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/crackler/crackler.png");
    }

    @Override
    public Identifier getAnimationResource(CracklerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/crackler.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(CracklerEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head2");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
