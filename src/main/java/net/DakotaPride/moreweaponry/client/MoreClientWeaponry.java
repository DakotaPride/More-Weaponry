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
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.lwjgl.glfw.GLFW;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class MoreClientWeaponry implements ClientModInitializer {
    public static final String KEY_CATEGORY_MORE_WEAPONRY = "key.category.moreweaponry.abilities";
    public static final String KEY_ACTIVATE_ABILITY_1 = "key.moreweaponry.ability_1";
    public static KeyBinding activateAbility1;
    public static final String KEY_ACTIVATE_ABILITY_2 = "key.moreweaponry.ability_2";
    public static KeyBinding activateAbility2;
    public static final String KEY_ACTIVATE_ABILITY_3 = "key.moreweaponry.ability_3";
    public static KeyBinding activateAbility3;
    public static final String KEY_ACTIVATE_ABILITY_4 = "key.moreweaponry.ability_4";
    public static KeyBinding activateAbility4;
    public static final String KEY_ACTIVATE_ABILITY_5 = "key.moreweaponry.ability_5";
    public static KeyBinding activateAbility5;

    private void abilityKeybindings() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (activateAbility1.wasPressed()) {
                if (client.player.getEquippedStack(EquipmentSlot.HEAD).isOf(MoreWeaponry.WATCHER_HELMET)
                        && client.player.getEquippedStack(EquipmentSlot.CHEST).isOf(MoreWeaponry.WATCHER_BREASTPLATE)) {
                    client.player.sendMessage(Text.translatable("text.abilities.watcher.activated"), false);

                    client.player.addStatusEffect(new StatusEffectInstance(MoreWeaponry.WATCHER, 2000, 0));
                }
            } else if (activateAbility2.wasPressed()) {
                if (client.player.getEquippedStack(EquipmentSlot.HEAD).isOf(MoreWeaponry.SICKENED_HELMET)
                        && client.player.getEquippedStack(EquipmentSlot.CHEST).isOf(MoreWeaponry.SICKENED_BREASTPLATE)) {
                    client.player.sendMessage(Text.translatable("text.abilities.sickened.activated"), false);

                    client.player.addStatusEffect(new StatusEffectInstance(MoreWeaponry.SICKENED, 2000, 0));
                }
            } else if (activateAbility3.wasPressed()) {
                if (client.player.getEquippedStack(EquipmentSlot.HEAD).isOf(MoreWeaponry.BARD_HELMET)
                        && client.player.getEquippedStack(EquipmentSlot.CHEST).isOf(MoreWeaponry.BARD_BREASTPLATE)) {
                    client.player.sendMessage(Text.translatable("text.abilities.bard.activated"), false);

                    client.player.addStatusEffect(new StatusEffectInstance(MoreWeaponry.BARD, 2000, 0));
                }
            } else if (activateAbility4.wasPressed()) {
                if (client.player.getEquippedStack(EquipmentSlot.HEAD).isOf(MoreWeaponry.CRACKLER_HELMET)
                        && client.player.getEquippedStack(EquipmentSlot.CHEST).isOf(MoreWeaponry.CRACKLER_BREASTPLATE)) {
                    client.player.sendMessage(Text.translatable("text.abilities.crackler.activated"), false);

                    client.player.addStatusEffect(new StatusEffectInstance(MoreWeaponry.CRACKLER, 2000, 0));
                }
            } else if (activateAbility5.wasPressed()) {
                if (client.player.getEquippedStack(EquipmentSlot.HEAD).isOf(MoreWeaponry.WANDERER_HELMET)
                        && client.player.getEquippedStack(EquipmentSlot.CHEST).isOf(MoreWeaponry.WANDERER_BREASTPLATE)) {
                    client.player.sendMessage(Text.translatable("text.abilities.wanderer.activated"), false);

                    client.player.addStatusEffect(new StatusEffectInstance(MoreWeaponry.WANDERER, 2000, 0));
                }
            }
        });

        activateAbility1 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_ACTIVATE_ABILITY_1,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_Z,
                KEY_CATEGORY_MORE_WEAPONRY
        ));
        activateAbility2 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_ACTIVATE_ABILITY_2,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_X,
                KEY_CATEGORY_MORE_WEAPONRY
        ));
        activateAbility3 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_ACTIVATE_ABILITY_3,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_C,
                KEY_CATEGORY_MORE_WEAPONRY
        ));
        activateAbility4 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_ACTIVATE_ABILITY_4,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_V,
                KEY_CATEGORY_MORE_WEAPONRY
        ));
        activateAbility5 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_ACTIVATE_ABILITY_5,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_B,
                KEY_CATEGORY_MORE_WEAPONRY
        ));

    }

    @Override
    public void onInitializeClient() {

        abilityKeybindings();

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