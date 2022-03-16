package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.CracklerEntity;
import net.DakotaPride.moreweaponry.entity.custom.LurkerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CracklerModel extends AnimatedGeoModel<CracklerEntity> {
    @Override
    public Identifier getModelLocation(CracklerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/crackler.geo.json");
    }

    @Override
    public Identifier getTextureLocation(CracklerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/crackler/crackler.png");
    }

    @Override
    public Identifier getAnimationFileLocation(CracklerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/crackler.animation.json");
    }
}
