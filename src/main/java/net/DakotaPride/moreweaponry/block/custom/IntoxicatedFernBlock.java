package net.DakotaPride.moreweaponry.block.custom;

import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FernBlock;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class IntoxicatedFernBlock extends FernBlock {
    public IntoxicatedFernBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        TallPlantBlock tallPlantBlock =
                (TallPlantBlock)(state.isOf(ModBlocks.INTOXICATED_FERN) ?
                        ModBlocks.INTOXICATED_LARGE_FERN : ModBlocks.INTOXICATED_TALL_GRASS);
        if (tallPlantBlock.getDefaultState().canPlaceAt(world, pos) && world.isAir(pos.up())) {
            TallPlantBlock.placeAt(world, tallPlantBlock.getDefaultState(), pos, 2);
        }
    }

}
