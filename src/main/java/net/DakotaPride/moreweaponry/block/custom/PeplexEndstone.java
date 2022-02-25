package net.DakotaPride.moreweaponry.block.custom;

import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class PeplexEndstone extends Block implements Fertilizable {
    public PeplexEndstone(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        boolean bl = false;
        boolean bl2 = false;
        for (BlockPos blockPos : BlockPos.iterate(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.isOf(ModBlocks.PEPLEX_NYLIUM)) {
                bl2 = true;
            }
            if (!bl2 || !bl) continue;
            break;
        }
        if (bl2 && bl) {
            world.setBlockState(pos, random.nextBoolean() ? ModBlocks.PEPLEX_NYLIUM.getDefaultState() : ModBlocks.PEPLEX_NYLIUM.getDefaultState(), Block.NOTIFY_ALL);
        } else if (bl2) {
            world.setBlockState(pos, ModBlocks.PEPLEX_NYLIUM.getDefaultState(), Block.NOTIFY_ALL);
        }
    }

}
