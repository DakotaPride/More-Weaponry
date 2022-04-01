package net.DakotaPride.moreweaponry.entity.client.armor;

import net.DakotaPride.moreweaponry.item.custom.sickened_tools.SickenedArmorItem;
import net.DakotaPride.moreweaponry.item.custom.wanderer_tools.WandererArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class SickenedArmorRenderer extends GeoArmorRenderer<SickenedArmorItem> {
    public SickenedArmorRenderer() {
        super(new SickenedArmorModel());

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
