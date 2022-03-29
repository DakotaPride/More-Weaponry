package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.BardEntity;
import net.DakotaPride.moreweaponry.entity.custom.SickenedEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SickenedRenderer extends GeoEntityRenderer<SickenedEntity> {
    public SickenedRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SickenedModel());
    }

    @Override
    public Identifier getTextureLocation(SickenedEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/sickened/sickened.png");
    }
}