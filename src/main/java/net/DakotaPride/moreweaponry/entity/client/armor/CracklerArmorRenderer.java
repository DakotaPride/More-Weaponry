package net.DakotaPride.moreweaponry.entity.client.armor;

import net.DakotaPride.moreweaponry.item.custom.crackler_tools.CracklerArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class CracklerArmorRenderer extends GeoArmorRenderer<CracklerArmorItem> {
    public CracklerArmorRenderer() {
        super(new CracklerArmorModel());

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
