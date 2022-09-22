package net.DakotaPride.moreweaponry.common.util;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class MoreWeaponryRendererHelper {
    public static void setRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.KURO_PLANT, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.FRODON_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.FRODON_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.NIGHT_CURON, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.POTTED_NIGHT_CURON, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.FRODON_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.FRODON_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.POTTED_NIGHT_CURON, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.INTOXICATED_FERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.INTOXICATED_TALL_FERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.INTOXICATED_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.INTOXICATED_TALL_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.INTOXICATED_GRASS_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.INTOXICATED_POPPY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.INTOXICATED_DANDELION, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.SICKENED_STONE_GRAVE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.GYOLOS_FUNGUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.SOUKIL_FUNGUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.BENTIK_FUNGUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.VAOLOS_FUNGUS, RenderLayer.getCutout());

    }

    public static void setTransparentBlocks() {
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.WATCHER_CELESTIAL_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.CRYSTALINE_WATCHER_CORE, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.WANDERER_CELESTIAL_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.CRYSTALINE_WANDERER_CORE, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.CRACKLER_CELESTIAL_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.CRYSTALINE_CRACKLER_CORE, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.BARD_CELESTIAL_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.CRYSTALINE_BARD_CORE, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.SICKENED_CELESTIAL_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MoreWeaponry.CRYSTALINE_SICKENED_CORE, RenderLayer.getTranslucent());
    }

}
