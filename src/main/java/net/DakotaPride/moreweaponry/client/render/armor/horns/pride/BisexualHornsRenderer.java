package net.DakotaPride.moreweaponry.client.render.armor.horns.pride;

import net.DakotaPride.moreweaponry.common.item.items.horns_items.BisexualHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.NonBinaryHornsItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class BisexualHornsRenderer extends GeoArmorRenderer<BisexualHornsItem> {
    public BisexualHornsRenderer() {
        super(new BisexualHornsModel());

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
