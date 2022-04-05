package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.SickenedEntity;
import net.DakotaPride.moreweaponry.entity.custom.SickenedHuskEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SickenedHuskRenderer extends GeoEntityRenderer<SickenedHuskEntity> {
    public SickenedHuskRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SickenedHuskModel());
    }

    @Override
    public Identifier getTextureLocation(SickenedHuskEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/sickened/sickened_husk.png");
    }
}