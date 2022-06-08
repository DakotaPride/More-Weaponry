package net.DakotaPride.moreweaponry.client.render.armor;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.items.wanderer_tools.WandererArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WandererArmorModel extends AnimatedGeoModel<WandererArmorItem> {
    @Override
    public Identifier getModelResource(WandererArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "geo/wanderer_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(WandererArmorItem object) {
        return new Identifier(MoreWeaponry.MOD_ID, "textures/models/armor/wanderer_armor.png");
    }

    @Override
    public Identifier getAnimationResource(WandererArmorItem animatable) {
        return new Identifier(MoreWeaponry.MOD_ID, "animations/wanderer_armor_animation.json");
    }
}
