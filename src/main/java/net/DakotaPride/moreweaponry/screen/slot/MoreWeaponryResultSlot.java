package net.DakotaPride.moreweaponry.screen.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class MoreWeaponryResultSlot  extends Slot {
    public MoreWeaponryResultSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }
}