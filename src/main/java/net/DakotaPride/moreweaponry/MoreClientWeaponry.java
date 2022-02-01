package net.DakotaPride.moreweaponry;

import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.DakotaPride.moreweaponry.screen.CropCutterScreen;
import net.DakotaPride.moreweaponry.screen.ModScreenHandlers;
import net.DakotaPride.moreweaponry.util.ModRendererHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;

public class MoreClientWeaponry implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ModRendererHelper.setRenderLayers();

        ScreenRegistry.register(ModScreenHandlers.CROP_CUTTER_SCREEN_HANDLER, CropCutterScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_NIGHT_CURON, RenderLayer.getCutout());


    }
}