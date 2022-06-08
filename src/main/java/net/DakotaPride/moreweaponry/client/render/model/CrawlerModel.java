package net.DakotaPride.moreweaponry.client.render.model;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.CrawlerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CrawlerModel extends AnimatedGeoModel<CrawlerEntity> {
    @Override
    public Identifier getModelResource(CrawlerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/crawler.geo.json");
    }

    @Override
    public Identifier getTextureResource(CrawlerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/darkest_cavern/crawler.png");
    }

    @Override
    public Identifier getAnimationResource(CrawlerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/crawler.animation.json");
    }
}
