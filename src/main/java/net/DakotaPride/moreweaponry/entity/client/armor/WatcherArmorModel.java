package net.DakotaPride.moreweaponry.entity.client.armor;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.item.items.watcher_tools.WatcherArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WatcherArmorModel extends AnimatedGeoModel<WatcherArmorItem> {
    @Override
    public Identifier getModelLocation(WatcherArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/watcher_armor.geo.json");
    }

    @Override
    public Identifier getTextureLocation(WatcherArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/watcher_armor.png");
    }

    @Override
    public Identifier getAnimationFileLocation(WatcherArmorItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/watcher_armor_animation.json");
    }
}
