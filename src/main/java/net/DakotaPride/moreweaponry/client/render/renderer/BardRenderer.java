package net.DakotaPride.moreweaponry.client.render.renderer;

import net.DakotaPride.moreweaponry.client.render.model.BardModel;
import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.BardEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BardRenderer extends GeoEntityRenderer<BardEntity> {
    public BardRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BardModel());
    }

    @Override
    public Identifier getTextureLocation(BardEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/bard/bard.png");
    }
}