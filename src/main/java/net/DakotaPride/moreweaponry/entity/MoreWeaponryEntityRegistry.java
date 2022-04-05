package net.DakotaPride.moreweaponry.entity;

import net.DakotaPride.moreweaponry.entity.client.*;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class MoreWeaponryEntityRegistry {
    public static void registerMoreWeaponryEntities() {
        EntityRendererRegistry.register(MoreWeaponryEntities.WATCHER, WatcherRenderer::new);
        EntityRendererRegistry.register(MoreWeaponryEntities.LURKER, LurkerRenderer::new);
        EntityRendererRegistry.register(MoreWeaponryEntities.WANDERER, WandererRenderer::new);
        EntityRendererRegistry.register(MoreWeaponryEntities.CRACKLER, CracklerRenderer::new);
        EntityRendererRegistry.register(MoreWeaponryEntities.BARD, BardRenderer::new);
        EntityRendererRegistry.register(MoreWeaponryEntities.SICKENED, SickenedRenderer::new);
        EntityRendererRegistry.register(MoreWeaponryEntities.SICKENED_HUSK, SickenedHuskRenderer::new);
    }
}
