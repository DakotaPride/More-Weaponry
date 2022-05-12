package net.DakotaPride.moreweaponry.common.item.items.celestial_madalian;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CelestialMadalianItem extends Item {
    public CelestialMadalianItem(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack itemStack = playerEntity.getStackInHand(hand);
      //  ItemUsageContext context = ;
     //   BlockPos positionClicked = context.getBlockPos();
        playerEntity.playSound(SoundEvents.PARTICLE_SOUL_ESCAPE, 2.0F, 1.0F);
        playerEntity.addStatusEffect(new StatusEffectInstance(MoreWeaponry.CELESTIAL, 3600, 0), playerEntity);
        playerEntity.getItemCooldownManager().set(this, 1200);
        itemStack.damage(1, playerEntity, (player) -> player.sendToolBreakStatus(player.getActiveHand()));
        playerEntity.sendMessage(new TranslatableText("message.moreweaponry.celestial_medallion.activated", playerEntity.getEntityName()).formatted(Formatting.YELLOW), true);
        return TypedActionResult.success(itemStack);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos positionClicked = context.getBlockPos();
        spawnFoundParticles(context, positionClicked);
        return super.useOnBlock(context);
    }

    private void spawnFoundParticles(ItemUsageContext pContext, BlockPos positionClicked) {
        for(int i = 0; i < 360; i++) {
            if(i % 20 == 0) {
                pContext.getWorld().addParticle(MoreWeaponry.CELESTIAL_MEDALLION_PARTICLE,
                        positionClicked.getX() + 0.5d, positionClicked.getY() + 1, positionClicked.getZ() + 0.5d,
                        Math.cos(i) * 2.0d, 2.0d, Math.sin(i) * 2.0d);
            }
        }
    }



    public ItemCooldownManager getItemCooldownManager() {
        return this.itemCooldownManager;
    }

    private final ItemCooldownManager itemCooldownManager = createCooldownManager();

    protected ItemCooldownManager createCooldownManager() {
        return new ItemCooldownManager();
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText("item.moreweaponry.description.celestial_medallion").formatted(Formatting.YELLOW));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }

}
