package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.CracklerEntity;
import net.DakotaPride.moreweaponry.entity.custom.LurkerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CracklerRenderer  extends GeoEntityRenderer<CracklerEntity> {
    public CracklerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new CracklerModel());
    }

    @Override
    public Identifier getTextureLocation(CracklerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/crackler/crackler.png");
    }
}