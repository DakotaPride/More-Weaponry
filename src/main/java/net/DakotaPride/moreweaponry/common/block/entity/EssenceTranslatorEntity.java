package net.DakotaPride.moreweaponry.common.block.entity;

import net.DakotaPride.moreweaponry.client.MoreClientWeaponry;
import net.DakotaPride.moreweaponry.common.item.inventory.ImplementedInventory;
import net.DakotaPride.moreweaponry.common.recipe.EssenceTranslatorRecipe;
import net.DakotaPride.moreweaponry.common.screen.EssenceTranslatorScreenHandler;
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
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class EssenceTranslatorEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(4, ItemStack.EMPTY);


    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private int fuelTime = 0;
    private int maxFuelTime = 0;

    public EssenceTranslatorEntity(BlockPos pos, BlockState state) {
        super(MoreClientWeaponry.ESSENCE_TRANSLATOR_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return EssenceTranslatorEntity.this.progress;
                    case 1: return EssenceTranslatorEntity.this.maxProgress;
                    case 2: return EssenceTranslatorEntity.this.fuelTime;
                    case 3: return EssenceTranslatorEntity.this.maxFuelTime;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: EssenceTranslatorEntity.this.progress = value; break;
                    case 1: EssenceTranslatorEntity.this.maxProgress = value; break;
                    case 2: EssenceTranslatorEntity.this.fuelTime = value; break;
                    case 3: EssenceTranslatorEntity.this.maxFuelTime = value; break;
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
        return new TranslatableText("gui.moreweaponry.essence_translator.label");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new EssenceTranslatorScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("essence_translator.progress", progress);
        nbt.putInt("essence_translator.fuelTime", fuelTime);
        nbt.putInt("essence_translator.maxFuelTime", maxFuelTime);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("essence_translator.progress");
        fuelTime = nbt.getInt("essence_translator.fuelTime");
        maxFuelTime = nbt.getInt("essence_translator.maxFuelTime");
    }

    public static void tick(World world, BlockPos pos, BlockState state, EssenceTranslatorEntity entity) {
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

    private static boolean hasRecipe(EssenceTranslatorEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<EssenceTranslatorRecipe> match = world.getRecipeManager()
                .getFirstMatch(EssenceTranslatorRecipe.Type.INSTANCE, inventory, world);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static void craftItem(EssenceTranslatorEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<EssenceTranslatorRecipe> match = world.getRecipeManager()
                .getFirstMatch(EssenceTranslatorRecipe.Type.INSTANCE, inventory, world);

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
