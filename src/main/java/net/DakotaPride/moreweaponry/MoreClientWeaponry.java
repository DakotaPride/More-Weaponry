package net.DakotaPride.moreweaponry;

import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.DakotaPride.moreweaponry.enchantments.ModEnchantments;
import net.DakotaPride.moreweaponry.util.ModModelPredicateProvider;
import net.DakotaPride.moreweaponry.util.ModRendererHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;

public class MoreClientWeaponry implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ModRendererHelper.setRenderLayers();

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_NIGHT_CURON, RenderLayer.getCutout());

        ModModelPredicateProvider.registerModModels();




    }
}