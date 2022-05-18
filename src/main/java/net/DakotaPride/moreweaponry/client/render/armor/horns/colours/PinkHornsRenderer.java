package net.DakotaPride.moreweaponry.client.render.armor.horns.colours;

import net.DakotaPride.moreweaponry.common.item.items.horns_items.PinkHornsItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class PinkHornsRenderer extends GeoArmorRenderer<PinkHornsItem> {
    public PinkHornsRenderer() {
        super(new PinkHornsModel());

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
