package net.DakotaPride.moreweaponry;

import net.DakotaPride.moreweaponry.entity.MoreWeaponryEntityRegistry;
import net.DakotaPride.moreweaponry.util.MoreWeaponryModelPredicateProvider;
import net.DakotaPride.moreweaponry.util.MoreWeaponryRendererHelper;
import net.fabricmc.api.ClientModInitializer;

public class MoreClientWeaponry implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        MoreWeaponryRendererHelper.setRenderLayers();

        MoreWeaponryModelPredicateProvider.registerMoreWeaponryModels();

        MoreWeaponryEntityRegistry.registerMoreWeaponryEntities();


    }
}