package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.WatcherEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WatcherRenderer extends GeoEntityRenderer<WatcherEntity> {
    public WatcherRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new WatcherModel());
    }

    @Override
    public Identifier getTextureLocation(WatcherEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/watcher/watcher.png");
    }
}
