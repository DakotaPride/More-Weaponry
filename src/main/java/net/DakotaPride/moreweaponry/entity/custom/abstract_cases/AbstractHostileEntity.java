package net.DakotaPride.moreweaponry.entity.custom.abstract_cases;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class AbstractHostileEntity extends HostileEntity {
    public AbstractHostileEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tickMovement() {
        this.tickHandSwing();
        this.updateDespawnCounter();
        super.tickMovement();
    }

    @Override
    protected void updateDespawnCounter() {
        float f = this.getBrightnessAtEyes();
        if (f > 0.5f) {
            this.despawnCounter += 10000;
        }
    }

    @Override
    protected boolean isDisallowedInPeaceful() {
        return false;
    }

}
