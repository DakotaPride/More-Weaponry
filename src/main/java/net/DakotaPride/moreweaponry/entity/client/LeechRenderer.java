package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.CracklerEntity;
import net.DakotaPride.moreweaponry.entity.custom.LeechEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class LeechRenderer extends GeoEntityRenderer<LeechEntity> {
    public LeechRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new LeechModel());
    }

    @Override
    public Identifier getTextureLocation(LeechEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/sickened/leech.png");
    }
}