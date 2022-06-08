package net.DakotaPride.moreweaponry.client.render.renderer;

import net.DakotaPride.moreweaponry.client.render.model.CracklerModel;
import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.CracklerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CracklerRenderer extends GeoEntityRenderer<CracklerEntity> {
    public CracklerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new CracklerModel());
    }

    @Override
    public Identifier getTextureResource(CracklerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/crackler/crackler.png");
    }
}