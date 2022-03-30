package net.DakotaPride.moreweaponry.entity.client;

import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.DakotaPride.moreweaponry.entity.custom.SuppressedExplosiveEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.TntEntityRenderer;
import net.minecraft.client.render.entity.TntMinecartEntityRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.TntEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

public class SuppressedExplosiveRenderer extends TntEntityRenderer {
    public SuppressedExplosiveRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    public void render(SuppressedExplosiveEntity suppressedExplosiveEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.translate(0.0D, 0.5D, 0.0D);
        int j = suppressedExplosiveEntity.getFuse();
        if (j - g + 1.0F < 10.0F) {
            float h = 1.0F - (j - g + 1.0F) / 10.0F;
            h = MathHelper.clamp(h, 0.0F, 1.0F);
            h *= h;
            h *= h;
            float k = 1.0F + h * 0.3F;
            matrixStack.scale(k, k, k);
        }

        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(-90.0F));
        matrixStack.translate(-0.5D, -0.5D, 0.5D);
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(90.0F));

        TntMinecartEntityRenderer.renderFlashingBlock(MoreWeaponryBlocks.CRACKLED_EXPLOSION.getDefaultState(), matrixStack, vertexConsumerProvider, i, (j / 5 % 2 == 0));

        matrixStack.pop();

        super.render(suppressedExplosiveEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }


    public Identifier getTexture(SuppressedExplosiveEntity suppressedExplosiveEntity) {
        return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;
    }
}
