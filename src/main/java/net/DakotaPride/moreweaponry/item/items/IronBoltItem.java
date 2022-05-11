package net.DakotaPride.moreweaponry.item.items;

import net.DakotaPride.moreweaponry.entity.custom.IronBoltEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IronBoltItem extends Item {
    public IronBoltItem(Settings settings) {
        super(settings);
    }

    public PersistentProjectileEntity createIronBolt(World world, ItemStack stack, LivingEntity shooter) {
        IronBoltEntity ironBoltEntity = new IronBoltEntity(world, shooter);
        ironBoltEntity.initFromStack(stack);
        return ironBoltEntity;
    }


}
