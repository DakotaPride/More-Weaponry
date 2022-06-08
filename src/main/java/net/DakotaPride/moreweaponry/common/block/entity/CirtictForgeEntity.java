package net.DakotaPride.moreweaponry.common.block.entity;

import net.DakotaPride.moreweaponry.client.MoreClientWeaponry;
import net.DakotaPride.moreweaponry.common.item.inventory.ImplementedInventory;
import net.DakotaPride.moreweaponry.common.recipe.CirtictForgeRecipe;
import net.DakotaPride.moreweaponry.common.screen.CirtictForgeScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CirtictForgeEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(4, ItemStack.EMPTY);


    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private int fuelTime = 0;
    private int maxFuelTime = 0;

    public CirtictForgeEntity(BlockPos pos, BlockState state) {
        super(MoreClientWeaponry.CIRTICT_FORGE_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return CirtictForgeEntity.this.progress;
                    case 1: return CirtictForgeEntity.this.maxProgress;
                    case 2: return CirtictForgeEntity.this.fuelTime;
                    case 3: return CirtictForgeEntity.this.maxFuelTime;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: CirtictForgeEntity.this.progress = value; break;
                    case 1: CirtictForgeEntity.this.maxProgress = value; break;
                    case 2: CirtictForgeEntity.this.fuelTime = value; break;
                    case 3: CirtictForgeEntity.this.maxFuelTime = value; break;
                }
            }

            public int size() {
                return 4;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("gui.moreweaponry.cirtict_forge.label");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new CirtictForgeScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("cirtict_forge.progress", progress);
        nbt.putInt("cirtict_forge.fuelTime", fuelTime);
        nbt.putInt("cirtict_forge.maxFuelTime", maxFuelTime);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("cirtict_forge.progress");
        fuelTime = nbt.getInt("cirtict_forge.fuelTime");
        maxFuelTime = nbt.getInt("cirtict_forge.maxFuelTime");
    }

    public static void tick(World world, BlockPos pos, BlockState state, CirtictForgeEntity entity) {
            if(hasRecipe(entity)) {
                entity.progress++;
                if(entity.progress > entity.maxProgress) {
                    craftItem(entity);
                }
            }
        else {
            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(CirtictForgeEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<CirtictForgeRecipe> match = world.getRecipeManager()
                .getFirstMatch(CirtictForgeRecipe.Type.INSTANCE, inventory, world);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static void craftItem(CirtictForgeEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<CirtictForgeRecipe> match = world.getRecipeManager()
                .getFirstMatch(CirtictForgeRecipe.Type.INSTANCE, inventory, world);

        if(match.isPresent()) {
            entity.removeStack(1,1);
            entity.removeStack(2,1);

            entity.setStack(3, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(3).getCount() + 1));

            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(3).getItem() == output.getItem() || inventory.getStack(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(3).getMaxCount() > inventory.getStack(3).getCount();
    }

}
