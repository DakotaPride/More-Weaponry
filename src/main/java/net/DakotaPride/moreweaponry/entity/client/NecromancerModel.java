package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.CrawlerEntity;
import net.DakotaPride.moreweaponry.entity.custom.NecromancerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NecromancerModel extends AnimatedGeoModel<NecromancerEntity> {
    @Override
    public Identifier getModelLocation(NecromancerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/necromancer.geo.json");
    }

    @Override
    public Identifier getTextureLocation(NecromancerEntity entity) {
        if (entity.isSpellcasting()) {
            return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/darkest_cavern/necromancer_spellcasting.png");
        } else {
            return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/darkest_cavern/necromancer.png");
        }
    }

    @Override
    public Identifier getAnimationFileLocation(NecromancerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/necromancer.animation.json");
    }
}
