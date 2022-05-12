package net.DakotaPride.moreweaponry.client.render.armor;

import net.DakotaPride.moreweaponry.common.item.items.wanderer_tools.WandererArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class WandererArmorRenderer extends GeoArmorRenderer<WandererArmorItem> {
    public WandererArmorRenderer() {
        super(new WandererArmorModel());

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
