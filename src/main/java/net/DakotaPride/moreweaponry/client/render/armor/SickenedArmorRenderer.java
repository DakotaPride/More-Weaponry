package net.DakotaPride.moreweaponry.client.render.armor;

import net.DakotaPride.moreweaponry.common.item.items.sickened_tools.SickenedArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class SickenedArmorRenderer extends GeoArmorRenderer<SickenedArmorItem> {
    public SickenedArmorRenderer() {
        super(new SickenedArmorModel());

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
