package net.DakotaPride.moreweaponry.client.render.armor.horns.colours;

import net.DakotaPride.moreweaponry.common.item.items.horns_items.YellowHornsItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class YellowHornsRenderer extends GeoArmorRenderer<YellowHornsItem> {
    public YellowHornsRenderer() {
        super(new YellowHornsModel());

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
