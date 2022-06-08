package net.DakotaPride.moreweaponry.client.render.renderer;

import net.DakotaPride.moreweaponry.client.render.model.CrawlerModel;
import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.CrawlerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CrawlerRenderer extends GeoEntityRenderer<CrawlerEntity> {
    public CrawlerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new CrawlerModel());
    }

    @Override
    public Identifier getTextureResource(CrawlerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/darkest_cavern/crawler.png");
    }
}
