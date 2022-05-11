package net.DakotaPride.moreweaponry.item.items.celestial_madalian;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.entity.MoreWeaponryEntities;
import net.DakotaPride.moreweaponry.entity.custom.SickenedEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SickenedCelestialMedallionItem extends CelestialMadalianItem {
    public SickenedCelestialMedallionItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockPos = context.getBlockPos();
        World world = context.getWorld();
        LivingEntity livingEntity = context.getPlayer();
        if (world.getBlockState(blockPos).isOf(MoreWeaponry.SICKENED_SUMMONER)) {
            world.playSound(null, blockPos, SoundEvents.PARTICLE_SOUL_ESCAPE, SoundCategory.PLAYERS, 1.0F, 1.0F);

            SickenedEntity sickenedEntity = MoreWeaponryEntities.SICKENED.create(world);
            assert sickenedEntity != null;
            sickenedEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, blockPos.getY() + 1.5, (double)blockPos.getZ() + 0.5, 0.0f, 0.0f);
            world.spawnEntity(sickenedEntity);
            sickenedEntity.playSpawnEffects();

            this.getItemCooldownManager().set(this, 1200);

        }
        return super.useOnBlock(context);
    }

}
