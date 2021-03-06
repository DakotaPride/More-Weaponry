package net.DakotaPride.moreweaponry.common.entity.custom.abstract_cases;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class AbstractHostileEntity extends HostileEntity {
    public AbstractHostileEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean cannotDespawn() {
        return true;
    }

    @Override
    protected boolean isDisallowedInPeaceful() {
        return false;
    }

}
