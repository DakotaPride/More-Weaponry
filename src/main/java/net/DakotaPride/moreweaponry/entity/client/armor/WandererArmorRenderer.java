package net.DakotaPride.moreweaponry.entity.client.armor;

import net.DakotaPride.moreweaponry.item.custom.wanderer_tools.WandererArmorItem;
import net.DakotaPride.moreweaponry.item.custom.watcher_tools.WatcherArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class WandererArmorRenderer extends GeoArmorRenderer<WandererArmorItem> {
    public WandererArmorRenderer() {
        super(new WandererArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorLeftArm";
        this.leftArmBone = "armorRightArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}
