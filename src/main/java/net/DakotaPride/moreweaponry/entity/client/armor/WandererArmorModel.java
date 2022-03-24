package net.DakotaPride.moreweaponry.entity.client.armor;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.item.custom.wanderer_tools.WandererArmorItem;
import net.DakotaPride.moreweaponry.item.custom.watcher_tools.WatcherArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WandererArmorModel extends AnimatedGeoModel<WandererArmorItem> {
    @Override
    public Identifier getModelLocation(WandererArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/wanderer_armor.geo.json");
    }

    @Override
    public Identifier getTextureLocation(WandererArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/wanderer_armor.png");
    }

    @Override
    public Identifier getAnimationFileLocation(WandererArmorItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/wanderer_armor_animation.json");
    }
}
