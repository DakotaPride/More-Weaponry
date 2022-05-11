package net.DakotaPride.moreweaponry.entity.client.armor;

import net.DakotaPride.moreweaponry.item.items.blessed_tools.BlessedArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class BlessedArmorRenderer extends GeoArmorRenderer<BlessedArmorItem> {
    public BlessedArmorRenderer() {
        super(new BlessedArmorModel());

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
