package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.BardEntity;
import net.DakotaPride.moreweaponry.entity.custom.CrawlerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CrawlerModel extends AnimatedGeoModel<CrawlerEntity> {
    @Override
    public Identifier getModelLocation(CrawlerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/crawler.geo.json");
    }

    @Override
    public Identifier getTextureLocation(CrawlerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/darkest_cavern/crawler.png");
    }

    @Override
    public Identifier getAnimationFileLocation(CrawlerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/crawler.animation.json");
    }
}
