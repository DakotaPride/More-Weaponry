package net.DakotaPride.moreweaponry.client;

import net.DakotaPride.moreweaponry.client.render.MoreWeaponryEntityRegistry;
import net.DakotaPride.moreweaponry.client.render.armor.*;
import net.DakotaPride.moreweaponry.client.render.armor.horns.BaseHornsRenderer;
import net.DakotaPride.moreweaponry.client.render.armor.horns.colours.*;
import net.DakotaPride.moreweaponry.client.render.armor.horns.pride.*;
import net.DakotaPride.moreweaponry.client.render.renderer.IronBoltEntityRenderer;
import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.block.entity.CirtictForgeEntity;
import net.DakotaPride.moreweaponry.common.block.entity.CoreForgeEntity;
import net.DakotaPride.moreweaponry.common.block.entity.EchoInfuserEntity;
import net.DakotaPride.moreweaponry.common.block.entity.EssenceTranslatorEntity;
import net.DakotaPride.moreweaponry.common.particle.CelestialMedallionParticle;
import net.DakotaPride.moreweaponry.common.screen.CirtictForgeScreen;
import net.DakotaPride.moreweaponry.common.screen.CoreForgeScreen;
import net.DakotaPride.moreweaponry.common.screen.EchoInfuserScreen;
import net.DakotaPride.moreweaponry.common.screen.EssenceTranslatorScreen;
import net.DakotaPride.moreweaponry.common.util.MoreWeaponryModelPredicateProvider;
import net.DakotaPride.moreweaponry.common.util.MoreWeaponryRendererHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class MoreClientWeaponry implements ClientModInitializer {


    public static BlockEntityType<CoreForgeEntity> CORE_FORGE_BLOCK_ENTITY;
    public static BlockEntityType<EssenceTranslatorEntity> ESSENCE_TRANSLATOR_BLOCK_ENTITY;
    public static BlockEntityType<CirtictForgeEntity> CIRTICT_FORGE_BLOCK_ENTITY;
    public static BlockEntityType<EchoInfuserEntity> ECHO_INFUSER_BLOCK_ENTITY;

    @Override
    public void onInitializeClient() {

        CORE_FORGE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MoreWeaponry.MOD_ID, "core_forge"),
                FabricBlockEntityTypeBuilder.create(CoreForgeEntity::new,
                        MoreWeaponry.CORE_FORGE).build(null));
        ESSENCE_TRANSLATOR_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MoreWeaponry.MOD_ID, "essence_translator"),
                FabricBlockEntityTypeBuilder.create(EssenceTranslatorEntity::new,
                        MoreWeaponry.ESSENCE_TRANSLATOR).build(null));
        CIRTICT_FORGE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MoreWeaponry.MOD_ID, "cirtict_forge"),
                FabricBlockEntityTypeBuilder.create(CirtictForgeEntity::new,
                        MoreWeaponry.CIRTICT_FORGE).build(null));
        ECHO_INFUSER_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MoreWeaponry.MOD_ID, "echo_infuser"),
                FabricBlockEntityTypeBuilder.create(EchoInfuserEntity::new,
                        MoreWeaponry.ECHO_INFUSER).build(null));

        FluidRenderHandlerRegistry.INSTANCE.register(MoreWeaponry.CELESTIALITE_STILL,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0xFFF499));

        FluidRenderHandlerRegistry.INSTANCE.register(MoreWeaponry.CELESTIALITE_FLOWING,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0xFFF499));


        FluidRenderHandlerRegistry.INSTANCE.register(MoreWeaponry.BARD_CELESTIALITE_STILL,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0x8185E8));

        FluidRenderHandlerRegistry.INSTANCE.register(MoreWeaponry.BARD_CELESTIALITE_FLOWING,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0x8185E8));

        FluidRenderHandlerRegistry.INSTANCE.register(MoreWeaponry.CRACKLER_CELESTIALITE_STILL,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0xAAE59C));

        FluidRenderHandlerRegistry.INSTANCE.register(MoreWeaponry.CRACKLER_CELESTIALITE_FLOWING,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0xAAE59C));

        FluidRenderHandlerRegistry.INSTANCE.register(MoreWeaponry.WANDERER_CELESTIALITE_STILL,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0xAF6960));

        FluidRenderHandlerRegistry.INSTANCE.register(MoreWeaponry.WANDERER_CELESTIALITE_FLOWING,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0xAF6960));

        FluidRenderHandlerRegistry.INSTANCE.register(MoreWeaponry.WATCHER_CELESTIALITE_STILL,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0x420059));

        FluidRenderHandlerRegistry.INSTANCE.register(MoreWeaponry.WATCHER_CELESTIALITE_FLOWING,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0x420059));

        FluidRenderHandlerRegistry.INSTANCE.register(MoreWeaponry.SICKENED_CELESTIALITE_STILL,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0x4A8442));

        FluidRenderHandlerRegistry.INSTANCE.register(MoreWeaponry.SICKENED_CELESTIALITE_FLOWING,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0x4A8442));

        FluidRenderHandlerRegistry.INSTANCE.register(MoreWeaponry.SICKENED_HUSK_CELESTIALITE_STILL,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0xD3BA89));

        FluidRenderHandlerRegistry.INSTANCE.register(MoreWeaponry.SICKENED_HUSK_CELESTIALITE_FLOWING,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0xD3BA89));

        EntityRendererRegistry.register(MoreWeaponry.IRON_BOLT, IronBoltEntityRenderer::new);

        ParticleFactoryRegistry.getInstance().register(MoreWeaponry.CELESTIAL_MEDALLION_PARTICLE,
                CelestialMedallionParticle.Factory::new);

        ScreenRegistry.register(MoreWeaponry.CORE_FORGE_SCREEN_HANDLER, CoreForgeScreen::new);
        ScreenRegistry.register(MoreWeaponry.ESSENCE_TRANSLATOR_SCREEN_HANDLER, EssenceTranslatorScreen::new);
        ScreenRegistry.register(MoreWeaponry.CIRTICT_FORGE_SCREEN_HANDLER, CirtictForgeScreen::new);
        ScreenRegistry.register(MoreWeaponry.ECHO_INFUSER_SCREEN_HANDLER, EchoInfuserScreen::new);

        MoreWeaponryRendererHelper.setRenderLayers();
        MoreWeaponryRendererHelper.setTransparentBlocks();

        MoreWeaponryModelPredicateProvider.registerMoreWeaponryModels();

        MoreWeaponryEntityRegistry.registerMoreWeaponryEntities();

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
        GeoArmorRenderer.registerArmorRenderer(new BaseHornsRenderer(), MoreWeaponry.COSMETIC_HORNS);
        GeoArmorRenderer.registerArmorRenderer(new RainbowHornsRenderer(), MoreWeaponry.RAINBOW_HORNS);
        GeoArmorRenderer.registerArmorRenderer(new RedHornsRenderer(), MoreWeaponry.RED_HORNS);
        GeoArmorRenderer.registerArmorRenderer(new OrangeHornsRenderer(), MoreWeaponry.ORANGE_HORNS);
        GeoArmorRenderer.registerArmorRenderer(new YellowHornsRenderer(), MoreWeaponry.YELLOW_HORNS);
        GeoArmorRenderer.registerArmorRenderer(new GreenHornsRenderer(), MoreWeaponry.GREEN_HORNS);
        GeoArmorRenderer.registerArmorRenderer(new BlueHornsRenderer(), MoreWeaponry.BLUE_HORNS);
        GeoArmorRenderer.registerArmorRenderer(new PurpleHornsRenderer(), MoreWeaponry.PURPLE_HORNS);
        GeoArmorRenderer.registerArmorRenderer(new PinkHornsRenderer(), MoreWeaponry.PINK_HORNS);
        GeoArmorRenderer.registerArmorRenderer(new BlackHornsRenderer(), MoreWeaponry.BLACK_HORNS);
        GeoArmorRenderer.registerArmorRenderer(new WhiteHornsRenderer(), MoreWeaponry.WHITE_HORNS);
        GeoArmorRenderer.registerArmorRenderer(new NonBinaryHornsRenderer(), MoreWeaponry.NONBINARY_HORNS);
        GeoArmorRenderer.registerArmorRenderer(new TransgenderHornsRenderer(), MoreWeaponry.TRANS_HORNS);
        GeoArmorRenderer.registerArmorRenderer(new BisexualHornsRenderer(), MoreWeaponry.BI_HORNS);
        GeoArmorRenderer.registerArmorRenderer(new PansexualHornsRenderer(), MoreWeaponry.PAN_HORNS);

    }
}