package net.DakotaPride.moreweaponry.client.render.renderer;

import net.DakotaPride.moreweaponry.client.render.model.BuriedKnightModel;
import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.BuriedKnightEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BuriedKnightRenderer extends GeoEntityRenderer<BuriedKnightEntity> {
    public BuriedKnightRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BuriedKnightModel());
    }

    @Override
    public Identifier getTextureResource(BuriedKnightEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/darkest_cavern/buried_knight.png");
    }
}