package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.LurkerEntity;
import net.DakotaPride.moreweaponry.entity.custom.WandererEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WandererRenderer extends GeoEntityRenderer<WandererEntity> {
    public WandererRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new WandererModel());
    }

    @Override
    public Identifier getTextureLocation(WandererEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/wanderer/wanderer.png");
    }
}
