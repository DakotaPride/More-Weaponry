package net.DakotaPride.moreweaponry.client.render.armor.horns.pride;

import net.DakotaPride.moreweaponry.common.item.items.horns_items.PansexualHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.RainbowHornsItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class PansexualHornsRenderer extends GeoArmorRenderer<PansexualHornsItem> {
    public PansexualHornsRenderer() {
        super(new PansexualHornsModel());

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
