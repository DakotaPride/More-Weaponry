package net.DakotaPride.moreweaponry.item.custom.celestial_madalian;

import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.DakotaPride.moreweaponry.entity.MoreWeaponryEntities;
import net.DakotaPride.moreweaponry.entity.custom.BardEntity;
import net.DakotaPride.moreweaponry.entity.custom.SickenedHuskEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SickenedHuskCelestialMadalianItem extends CelestialMadalianItem{
    public SickenedHuskCelestialMadalianItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockPos = context.getBlockPos();
        World world = context.getWorld();
        LivingEntity livingEntity = context.getPlayer();
        if (world.getBlockState(blockPos).isOf(MoreWeaponryBlocks.SICKENED_HUSK_SUMMONER)) {
            world.playSound(null, blockPos, SoundEvents.PARTICLE_SOUL_ESCAPE, SoundCategory.PLAYERS, 1.0F, 1.0F);

            SickenedHuskEntity sickenedHuskEntity = MoreWeaponryEntities.SICKENED_HUSK.create(world);
            assert sickenedHuskEntity != null;
            sickenedHuskEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, blockPos.getY() + 1.5, (double)blockPos.getZ() + 0.5, 0.0f, 0.0f);
            world.spawnEntity(sickenedHuskEntity);
            sickenedHuskEntity.playSpawnEffects();

            this.getItemCooldownManager().set(this, 1200);

        }
        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText("item.moreweaponry.description.celestial_medallion").formatted(Formatting.YELLOW));

    }


}
