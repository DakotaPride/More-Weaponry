package net.DakotaPride.moreweaponry;

import net.DakotaPride.moreweaponry.entity.MoreWeaponryEntityRegistry;
import net.DakotaPride.moreweaponry.entity.client.armor.WandererArmorRenderer;
import net.DakotaPride.moreweaponry.entity.client.armor.WatcherArmorRenderer;
import net.DakotaPride.moreweaponry.item.MoreWeaponryItems;
import net.DakotaPride.moreweaponry.screen.CirtictForgeScreen;
import net.DakotaPride.moreweaponry.screen.CoreForgeScreen;
import net.DakotaPride.moreweaponry.screen.EssenceTranslatorScreen;
import net.DakotaPride.moreweaponry.screen.MoreWeaponryScreenHandlers;
import net.DakotaPride.moreweaponry.util.MoreWeaponryModelPredicateProvider;
import net.DakotaPride.moreweaponry.util.MoreWeaponryRendererHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class MoreClientWeaponry implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ScreenRegistry.register(MoreWeaponryScreenHandlers.CORE_FORGE_SCREEN_HANDLER, CoreForgeScreen::new);
        ScreenRegistry.register(MoreWeaponryScreenHandlers.ESSENCE_TRANSLATOR_SCREEN_HANDLER, EssenceTranslatorScreen::new);
        ScreenRegistry.register(MoreWeaponryScreenHandlers.CIRTICT_FORGE_SCREEN_HANDLER, CirtictForgeScreen::new);

        MoreWeaponryRendererHelper.setRenderLayers();
        MoreWeaponryRendererHelper.setTransparentBlocks();

        MoreWeaponryModelPredicateProvider.registerMoreWeaponryModels();

        MoreWeaponryEntityRegistry.registerMoreWeaponryEntities();

        GeoArmorRenderer.registerArmorRenderer(new WatcherArmorRenderer(), MoreWeaponryItems.WATCHER_HELMET,
                MoreWeaponryItems.WATCHER_CHESTPLATE);
        GeoArmorRenderer.registerArmorRenderer(new WandererArmorRenderer(), MoreWeaponryItems.WANDERER_HELMET,
                MoreWeaponryItems.WANDERER_CHESTPLATE);


    }
}