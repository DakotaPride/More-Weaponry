package net.DakotaPride.moreweaponry.client.render.armor.horns.colours;

import net.DakotaPride.moreweaponry.common.item.items.horns_items.BlackHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.BlueHornsItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class BlackHornsRenderer extends GeoArmorRenderer<BlackHornsItem> {
    public BlackHornsRenderer() {
        super(new BlackHornsModel());

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
