package net.DakotaPride.moreweaponry.client.render.armor;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.watcher_tools.WatcherArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WatcherArmorModel extends AnimatedGeoModel<WatcherArmorItem> {
    @Override
    public Identifier getModelResource(WatcherArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/watcher_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(WatcherArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/watcher_armor.png");
    }

    @Override
    public Identifier getAnimationResource(WatcherArmorItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/watcher_armor_animation.json");
    }
}
