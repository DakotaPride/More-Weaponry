package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.custom.IronBoltEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(value = EnvType.CLIENT)
public class IronBoltEntityRenderer extends ProjectileEntityRenderer<IronBoltEntity> {
    public static final Identifier TEXTURE = new Identifier
            (MoreWeaponry.MOD_ID, "textures/entity/projectiles/iron_bolt.png");

    public IronBoltEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(IronBoltEntity ironBoltEntity) {
        return TEXTURE;
    }
}
