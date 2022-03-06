package net.DakotaPride.moreweaponry;

import net.DakotaPride.moreweaponry.entity.MoreWeaponryEntities;
import net.DakotaPride.moreweaponry.entity.client.WatcherRenderer;
import net.DakotaPride.moreweaponry.util.MoreWeaponryModelPredicateProvider;
import net.DakotaPride.moreweaponry.util.MoreWeaponryRendererHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class MoreClientWeaponry implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        MoreWeaponryRendererHelper.setRenderLayers();

        MoreWeaponryModelPredicateProvider.registerMoreWeaponryModels();

        EntityRendererRegistry.register(MoreWeaponryEntities.WATCHER, WatcherRenderer::new);


    }
}