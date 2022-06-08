package net.DakotaPride.moreweaponry.common.item.items.horns_items;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.ArrayList;
import java.util.List;

public class TransgenderHornsItem extends ArmorItem implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);

    public TransgenderHornsItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.moreweaponry.horns.type.transgender"));
    }

    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        // This is all the extradata this event carries. The livingentity is the entity
        // that's wearing the armor. The itemstack and equipmentslottype are self
        // explanatory.
        LivingEntity livingEntity = event.getExtraDataOfType(LivingEntity.class).get(0);

        // Always loop the animation but later on in this method we'll decide whether or
        // not to actually play it
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));

        // If the living entity is an armorstand just play the animation nonstop
        if (livingEntity instanceof ArmorStandEntity) {
            return PlayState.CONTINUE;
        }

        // The entity is a player, so we want to only play if the player is wearing the
        // full set of armor
        else if (livingEntity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) livingEntity;

            // Get all the equipment, aka the armor, currently held item, and offhand item
            List<Item> equipmentList = new ArrayList<>();
            player.getItemsEquipped().forEach((x) -> equipmentList.add(x.getItem()));

            // elements 2 to 6 are the armor so we take the sublist. Armorlist now only
            // contains the 4 armor slots
            List<Item> armorList = equipmentList.subList(2, 6);

            // Make sure the player is wearing all the armor. If they are, continue playing
            // the animation, otherwise stop
            boolean isWearingAll = armorList.contains(MoreWeaponry.TRANS_HORNS);
            return isWearingAll ? PlayState.CONTINUE : PlayState.STOP;
        }
        return PlayState.STOP;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this,
                "controller", 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

}
