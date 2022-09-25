package net.DakotaPride.moreweaponry.client.render.model;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.NecromancerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NecromancerModel extends AnimatedGeoModel<NecromancerEntity> {
    @Override
    public Identifier getModelResource(NecromancerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/necromancer.geo.json");
    }

    @Override
    public Identifier getTextureResource(NecromancerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/darkest_cavern/necromancer.png");
    }

    @Override
    public Identifier getAnimationResource(NecromancerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/necromancer.animation.json");
    }
}
