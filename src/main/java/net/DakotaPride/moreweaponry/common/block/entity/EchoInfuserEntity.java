package net.DakotaPride.moreweaponry.common.block.entity;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.item.inventory.ImplementedInventory;
import net.DakotaPride.moreweaponry.common.recipe.EchoInfuserRecipe;
import net.DakotaPride.moreweaponry.common.screen.EchoInfuserScreenHandler;
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

public class EchoInfuserEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(8, ItemStack.EMPTY);


    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 288;
    private int fuelTime = 0;
    private int maxFuelTime = 0;

    public EchoInfuserEntity(BlockPos pos, BlockState state) {
        super(MoreWeaponry.ECHO_INFUSER_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return EchoInfuserEntity.this.progress;
                    case 1: return EchoInfuserEntity.this.maxProgress;
                    case 2: return EchoInfuserEntity.this.fuelTime;
                    case 3: return EchoInfuserEntity.this.maxFuelTime;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: EchoInfuserEntity.this.progress = value; break;
                    case 1: EchoInfuserEntity.this.maxProgress = value; break;
                    case 2: EchoInfuserEntity.this.fuelTime = value; break;
                    case 3: EchoInfuserEntity.this.maxFuelTime = value; break;
                }
            }

            public int size() {
                return 8;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("gui.moreweaponry.echo_infuser.label");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new EchoInfuserScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("echo_infuser.progress", progress);
        nbt.putInt("echo_infuser.fuelTime", fuelTime);
        nbt.putInt("echo_infuser.maxFuelTime", maxFuelTime);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("echo_infuser.progress");
        fuelTime = nbt.getInt("echo_infuser.fuelTime");
        maxFuelTime = nbt.getInt("echo_infuser.maxFuelTime");
    }

    public static void tick(World world, BlockPos pos, BlockState state, EchoInfuserEntity entity) {
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

    private static boolean hasRecipe(EchoInfuserEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<EchoInfuserRecipe> match = world.getRecipeManager()
                .getFirstMatch(EchoInfuserRecipe.Type.INSTANCE, inventory, world);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static void craftItem(EchoInfuserEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<EchoInfuserRecipe> match = world.getRecipeManager()
                .getFirstMatch(EchoInfuserRecipe.Type.INSTANCE, inventory, world);

        if(match.isPresent()) {
            entity.removeStack(1,1);
            entity.removeStack(2,1);
            entity.removeStack(3,1);
            entity.removeStack(4,1);
            entity.removeStack(5,1);
            entity.removeStack(6,1);

            entity.setStack(7, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(7).getCount() + 1));


            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(8).getItem() == output.getItem() || inventory.getStack(8).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(8).getMaxCount() > inventory.getStack(8).getCount();
    }

}
