package net.DakotaPride.moreweaponry.client.render;

import net.DakotaPride.moreweaponry.client.render.renderer.*;
import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class MoreWeaponryEntityRegistry {
    public static void registerMoreWeaponryEntities() {
        EntityRendererRegistry.register(MoreWeaponry.WATCHER_ENTITY, WatcherRenderer::new);
        EntityRendererRegistry.register(MoreWeaponry.LURKER_ENTITY, LurkerRenderer::new);
        EntityRendererRegistry.register(MoreWeaponry.WANDERER_ENTITY, WandererRenderer::new);
        EntityRendererRegistry.register(MoreWeaponry.CRACKLER_ENTITY, CracklerRenderer::new);
        EntityRendererRegistry.register(MoreWeaponry.BARD_ENTITY, BardRenderer::new);
        EntityRendererRegistry.register(MoreWeaponry.SICKENED_ENTITY, SickenedRenderer::new);
        EntityRendererRegistry.register(MoreWeaponry.LEECH_ENTITY, LeechRenderer::new);
        EntityRendererRegistry.register(MoreWeaponry.SICKENED_HUSK_ENTITY, SickenedHuskRenderer::new);

        EntityRendererRegistry.register(MoreWeaponry.BURIED_KNIGHT_ENTITY, BuriedKnightRenderer::new);
        EntityRendererRegistry.register(MoreWeaponry.CRAWLER_ENTITY, CrawlerRenderer::new);
        EntityRendererRegistry.register(MoreWeaponry.NECROMANCER_ENTITY, NecromancerRenderer::new);

    }
}
