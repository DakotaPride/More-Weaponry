package net.DakotaPride.moreweaponry.entity.custom.abstract_cases;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.EvokerEntity;
import net.minecraft.world.World;

public class AbstractNecromancerEntity extends EvokerEntity {
    public AbstractNecromancerEntity(EntityType<? extends EvokerEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected boolean isDisallowedInPeaceful() {
        return false;
    }


}
