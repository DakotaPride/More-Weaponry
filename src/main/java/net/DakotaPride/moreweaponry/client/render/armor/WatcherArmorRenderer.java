package net.DakotaPride.moreweaponry.client.render.armor;

import net.DakotaPride.moreweaponry.common.item.items.watcher_tools.WatcherArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class WatcherArmorRenderer extends GeoArmorRenderer<WatcherArmorItem> {
    public WatcherArmorRenderer() {
        super(new WatcherArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}
