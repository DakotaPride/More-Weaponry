package net.DakotaPride.moreweaponry.client.render.renderer;

import net.DakotaPride.moreweaponry.client.render.model.NecromancerModel;
import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.entity.custom.NecromancerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class NecromancerRenderer extends GeoEntityRenderer<NecromancerEntity> {
    public NecromancerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new NecromancerModel());
    }

    @Override
    public Identifier getTextureLocation(NecromancerEntity entity) {
        if (entity.isSpellcasting()) {
            return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/darkest_cavern/necromancer_spellcasting.png");
        } else {
            return new Identifier(MoreWeaponry.MOD_ID, "textures/entity/darkest_cavern/necromancer.png");
        }
    }
}
