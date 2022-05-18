package net.DakotaPride.moreweaponry.client.render.armor.horns.pride;

import net.DakotaPride.moreweaponry.common.item.items.horns_items.NonBinaryHornsItem;
import net.DakotaPride.moreweaponry.common.item.items.horns_items.TransgenderHornsItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class TransgenderHornsRenderer extends GeoArmorRenderer<TransgenderHornsItem> {
    public TransgenderHornsRenderer() {
        super(new TransgenderHornsModel());

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
