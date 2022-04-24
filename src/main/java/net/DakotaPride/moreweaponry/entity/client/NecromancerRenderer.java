package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.LurkerEntity;
import net.DakotaPride.moreweaponry.entity.custom.NecromancerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class NecromancerRenderer extends GeoEntityRenderer<NecromancerEntity> {
    public NecromancerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new NecromancerModel());
    }

    @Override
    public Identifier getTextureLocation(NecromancerEntity entity) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/darkest_cavern/necromancer.png");
    }
}
