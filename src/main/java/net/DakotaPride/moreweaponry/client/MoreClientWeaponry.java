package net.DakotaPride.moreweaponry.client;

import net.DakotaPride.moreweaponry.client.render.MoreWeaponryEntityRegistry;
import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.block.entity.MoreWeaponryBlockEntities;
import net.DakotaPride.moreweaponry.client.render.renderer.IronBoltEntityRenderer;
import net.DakotaPride.moreweaponry.client.render.armor.*;
import net.DakotaPride.moreweaponry.common.particle.CelestialMedallionParticle;
import net.DakotaPride.moreweaponry.common.screen.CirtictForgeScreen;
import net.DakotaPride.moreweaponry.common.screen.CoreForgeScreen;
import net.DakotaPride.moreweaponry.common.screen.EssenceTranslatorScreen;
import net.DakotaPride.moreweaponry.common.util.MoreWeaponryModelPredicateProvider;
import net.DakotaPride.moreweaponry.common.util.MoreWeaponryRendererHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class MoreClientWeaponry implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        FluidRenderHandlerRegistry.INSTANCE.register(MoreWeaponry.CELESTIALITE_STILL,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0xFFF499));

        FluidRenderHandlerRegistry.INSTANCE.register(MoreWeaponry.CELESTIALITE_FLOWING,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0xFFF499));

        EntityRendererRegistry.INSTANCE.register(MoreWeaponry.IRON_BOLT, IronBoltEntityRenderer::new);

        // ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex)
           //     -> 0x818269, MoreWeaponryBlocks.INTOXICATED_GRASS_BLOCK);

        ParticleFactoryRegistry.getInstance().register(MoreWeaponry.CELESTIAL_MEDALLION_PARTICLE,
                CelestialMedallionParticle.Factory::new);

        ScreenRegistry.register(MoreWeaponry.CORE_FORGE_SCREEN_HANDLER, CoreForgeScreen::new);
        ScreenRegistry.register(MoreWeaponry.ESSENCE_TRANSLATOR_SCREEN_HANDLER, EssenceTranslatorScreen::new);
        ScreenRegistry.register(MoreWeaponry.CIRTICT_FORGE_SCREEN_HANDLER, CirtictForgeScreen::new);

        MoreWeaponryRendererHelper.setRenderLayers();
        MoreWeaponryRendererHelper.setTransparentBlocks();

        MoreWeaponryModelPredicateProvider.registerMoreWeaponryModels();

        MoreWeaponryEntityRegistry.registerMoreWeaponryEntities();
        MoreWeaponryBlockEntities.registerMoreWeaponryBlockEntities();

        GeoArmorRenderer.registerArmorRenderer(new WatcherArmorRenderer(), MoreWeaponry.WATCHER_HELMET,
                MoreWeaponry.WATCHER_BREASTPLATE);
        GeoArmorRenderer.registerArmorRenderer(new WandererArmorRenderer(), MoreWeaponry.WANDERER_HELMET,
                MoreWeaponry.WANDERER_BREASTPLATE);
        GeoArmorRenderer.registerArmorRenderer(new CracklerArmorRenderer(), MoreWeaponry.CRACKLER_HELMET,
                MoreWeaponry.CRACKLER_BREASTPLATE);
        GeoArmorRenderer.registerArmorRenderer(new BardArmorRenderer(), MoreWeaponry.BARD_HELMET,
                MoreWeaponry.BARD_BREASTPLATE);
        GeoArmorRenderer.registerArmorRenderer(new SickenedArmorRenderer(), MoreWeaponry.SICKENED_HELMET,
                MoreWeaponry.SICKENED_BREASTPLATE);
        GeoArmorRenderer.registerArmorRenderer(new BlessedArmorRenderer(), MoreWeaponry.BLESSED_HELMET,
                MoreWeaponry.BLESSED_BREASTPLATE);


    }
}