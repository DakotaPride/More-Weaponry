package net.DakotaPride.moreweaponry.client.render.armor.horns.colours;

import net.DakotaPride.moreweaponry.common.item.items.horns_items.BlackHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.WhiteHornsItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class WhiteHornsRenderer extends GeoArmorRenderer<WhiteHornsItem> {
    public WhiteHornsRenderer() {
        super(new WhiteHornsModel());

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
