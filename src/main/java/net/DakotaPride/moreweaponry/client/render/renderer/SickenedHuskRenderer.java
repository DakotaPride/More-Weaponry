package net.DakotaPride.moreweaponry.client.render.renderer;

import net.DakotaPride.moreweaponry.client.render.model.SickenedHuskModel;
import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.SickenedHuskEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SickenedHuskRenderer extends GeoEntityRenderer<SickenedHuskEntity> {
    public SickenedHuskRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SickenedHuskModel());
    }

    @Override
    public Identifier getTextureResource(SickenedHuskEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/sickened/sickened_husk.png");
    }
}