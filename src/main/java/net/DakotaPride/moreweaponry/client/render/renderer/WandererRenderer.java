package net.DakotaPride.moreweaponry.client.render.renderer;

import net.DakotaPride.moreweaponry.client.render.model.WandererModel;
import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.WandererEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WandererRenderer extends GeoEntityRenderer<WandererEntity> {
    public WandererRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new WandererModel());
    }

    @Override
    public Identifier getTextureResource(WandererEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/wanderer/wanderer.png");
    }
}
