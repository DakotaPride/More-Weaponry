package net.DakotaPride.moreweaponry.common.item.items;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.DakotaPride.moreweaponry.common.fluid.CelestialiteFluid;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class ReinforcedBucketItem extends Item
        implements FluidModificationItem {
    private final Fluid fluid;
    private CelestialiteFluid celestialiteFluid;

    public ReinforcedBucketItem(Fluid fluid, FabricItemSettings settings) {
        super(settings);
        this.fluid = fluid;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult blockHitResult = ReinforcedBucketItem.raycast(world, user, this.fluid == Fluids.EMPTY ? RaycastContext.FluidHandling.SOURCE_ONLY : RaycastContext.FluidHandling.NONE);
        if (blockHitResult.getType() == HitResult.Type.MISS) {
            return TypedActionResult.pass(itemStack);
        }
        if (blockHitResult.getType() == HitResult.Type.BLOCK) {
            BlockPos fluidDrainable;
            BlockPos blockPos = blockHitResult.getBlockPos();
            Direction direction = blockHitResult.getSide();
            BlockPos blockPos2 = blockPos.offset(direction);
            if (!world.canPlayerModifyAt(user, blockPos) || !user.canPlaceOn(blockPos2, direction, itemStack)) {
                return TypedActionResult.fail(itemStack);
            }
            if (this.fluid == Fluids.EMPTY) {
                FluidDrainable fluidDrainable2;
                ItemStack itemStack2;
                BlockState blockState = world.getBlockState(blockPos);
                if (blockState.getBlock() instanceof FluidDrainable && !(itemStack2 = (fluidDrainable2 = (FluidDrainable) ((Object) blockState.getBlock())).tryDrainFluid(world, blockPos, blockState)).isEmpty()) {
                    user.incrementStat(Stats.USED.getOrCreateStat(this));
                    fluidDrainable2.getBucketFillSound().ifPresent(sound -> user.playSound((SoundEvent) sound, 1.0f, 1.0f));
                    world.emitGameEvent((Entity) user, GameEvent.FLUID_PICKUP, blockPos);
                    ItemStack itemStack3 = ItemUsage.exchangeStack(itemStack, user, itemStack2);
                    if (!world.isClient) {
                        Criteria.FILLED_BUCKET.trigger((ServerPlayerEntity) user, itemStack2);
                    }
                    return TypedActionResult.success(itemStack3, world.isClient());
                }
                return TypedActionResult.fail(itemStack);
            }
            BlockState blockState = world.getBlockState(blockPos);
            BlockPos blockPos3 = fluidDrainable = blockState.getBlock() instanceof FluidFillable && this.fluid == MoreWeaponry.CELESTIALITE_STILL ? blockPos : blockPos2;
            if (this.placeFluid(user, world, fluidDrainable, blockHitResult)) {
                this.onEmptied(user, world, itemStack, fluidDrainable);
                if (user instanceof ServerPlayerEntity) {
                    Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity) user, fluidDrainable, itemStack);
                }
                user.incrementStat(Stats.USED.getOrCreateStat(this));
                return TypedActionResult.success(ReinforcedBucketItem.getEmptiedStack(itemStack, user), world.isClient());
            }
            return TypedActionResult.fail(itemStack);
        }
        return TypedActionResult.pass(itemStack);
    }

    public static ItemStack getEmptiedStack(ItemStack stack, PlayerEntity player) {
        if (!player.getAbilities().creativeMode) {
            return new ItemStack(MoreWeaponry.REINFORCED_BUCKET);
        }
        return stack;
    }

    @Override
    public void onEmptied(@Nullable PlayerEntity player, World world, ItemStack stack, BlockPos pos) {
    }

    @Override
    public boolean placeFluid(@Nullable PlayerEntity player, World world, BlockPos pos, @Nullable BlockHitResult hitResult) {
        boolean bl2;
        if (!(this.fluid instanceof FlowableFluid)) {
            return false;
        }
        BlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();
        Material material = blockState.getMaterial();
        boolean bl = blockState.canBucketPlace(this.fluid);
        boolean bl3 = bl2 = blockState.isAir() || bl || block instanceof FluidFillable && ((FluidFillable) ((Object) block)).canFillWithFluid(world, pos, blockState, this.fluid);
        if (!bl2) {
            return hitResult != null && this.placeFluid(player, world, hitResult.getBlockPos().offset(hitResult.getSide()), null);
        }
        if (block instanceof FluidFillable && this.fluid == MoreWeaponry.CELESTIALITE_STILL) {
            ((FluidFillable) ((Object) block)).tryFillWithFluid(world, pos, blockState, ((FlowableFluid) this.fluid).getStill(false));
            this.playEmptyingSound(player, world, pos);
            return true;
        }
        if (!world.isClient && bl && !material.isLiquid()) {
            world.breakBlock(pos, true);
        }
        if (world.setBlockState(pos, this.fluid.getDefaultState().getBlockState(), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD) || blockState.getFluidState().isStill()) {
            this.playEmptyingSound(player, world, pos);
            return true;
        }
        return false;
    }

    protected void playEmptyingSound(@Nullable PlayerEntity player, WorldAccess world, BlockPos pos) {
        SoundEvent soundEvent = SoundEvents.ITEM_BUCKET_EMPTY;
        world.playSound(player, pos, soundEvent, SoundCategory.BLOCKS, 1.0f, 1.0f);
        world.emitGameEvent((Entity) player, GameEvent.FLUID_PLACE, pos);
    }
}