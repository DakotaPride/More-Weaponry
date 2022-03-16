package net.DakotaPride.moreweaponry;

import net.DakotaPride.moreweaponry.entity.MoreWeaponryEntityRegistry;
import net.DakotaPride.moreweaponry.screen.CirtictForgeScreen;
import net.DakotaPride.moreweaponry.screen.CoreForgeScreen;
import net.DakotaPride.moreweaponry.screen.EssenceTranslatorScreen;
import net.DakotaPride.moreweaponry.screen.MoreWeaponryScreenHandlers;
import net.DakotaPride.moreweaponry.util.MoreWeaponryModelPredicateProvider;
import net.DakotaPride.moreweaponry.util.MoreWeaponryRendererHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class MoreClientWeaponry implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ScreenRegistry.register(MoreWeaponryScreenHandlers.CORE_FORGE_SCREEN_HANDLER, CoreForgeScreen::new);
        ScreenRegistry.register(MoreWeaponryScreenHandlers.ESSENCE_TRANSLATOR_SCREEN_HANDLER, EssenceTranslatorScreen::new);
        ScreenRegistry.register(MoreWeaponryScreenHandlers.CIRTICT_FORGE_SCREEN_HANDLER, CirtictForgeScreen::new);

        MoreWeaponryRendererHelper.setRenderLayers();

        MoreWeaponryModelPredicateProvider.registerMoreWeaponryModels();

        MoreWeaponryEntityRegistry.registerMoreWeaponryEntities();


    }
}