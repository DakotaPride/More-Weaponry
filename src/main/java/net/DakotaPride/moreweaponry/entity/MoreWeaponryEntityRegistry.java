package net.DakotaPride.moreweaponry.entity;

import net.DakotaPride.moreweaponry.entity.client.LurkerRenderer;
import net.DakotaPride.moreweaponry.entity.client.WatcherRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class MoreWeaponryEntityRegistry {
    public static void registerMoreWeaponryEntities() {
        EntityRendererRegistry.register(MoreWeaponryEntities.WATCHER, WatcherRenderer::new);
        EntityRendererRegistry.register(MoreWeaponryEntities.LURKER, LurkerRenderer::new);
    }
}
