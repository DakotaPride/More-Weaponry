package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.BardEntity;
import net.DakotaPride.moreweaponry.entity.custom.BuriedKnightEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BuriedKnightRenderer extends GeoEntityRenderer<BuriedKnightEntity> {
    public BuriedKnightRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BuriedKnightModel());
    }

    @Override
    public Identifier getTextureLocation(BuriedKnightEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/darkest_cavern/buried_knight.png");
    }
}