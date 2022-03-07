package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.LurkerEntity;
import net.DakotaPride.moreweaponry.entity.custom.WatcherEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class LurkerRenderer extends GeoEntityRenderer<LurkerEntity> {
    public LurkerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new LurkerModel());
    }

    @Override
    public Identifier getTextureLocation(LurkerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/lurker/lurker.png");
    }
}
