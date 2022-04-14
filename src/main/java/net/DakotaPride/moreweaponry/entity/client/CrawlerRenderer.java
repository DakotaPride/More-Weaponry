package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.CrawlerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CrawlerRenderer extends GeoEntityRenderer<CrawlerEntity> {
    public CrawlerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new CrawlerModel());
    }

    @Override
    public Identifier getTextureLocation(CrawlerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/darkest_cavern/crawler.png");
    }
}
