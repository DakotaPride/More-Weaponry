package net.DakotaPride.moreweaponry.client.render.armor.horns.colours;

import net.DakotaPride.moreweaponry.common.item.items.horns_items.GreenHornsItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class GreenHornsRenderer extends GeoArmorRenderer<GreenHornsItem> {
    public GreenHornsRenderer() {
        super(new GreenHornsModel());

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
