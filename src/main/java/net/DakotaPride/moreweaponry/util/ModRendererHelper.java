package net.DakotaPride.moreweaponry.util;

import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class ModRendererHelper {
    public static void setRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KURO_PLANT, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FRODON_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FRODON_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NIGHT_CURON, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_NIGHT_CURON, RenderLayer.getCutout());
    }
}
