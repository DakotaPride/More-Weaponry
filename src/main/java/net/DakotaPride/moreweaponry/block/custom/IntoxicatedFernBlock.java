package net.DakotaPride.moreweaponry.block.custom;

import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.FernBlock;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.Random;

public class IntoxicatedFernBlock extends FernBlock {
    public IntoxicatedFernBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        TallPlantBlock tallPlantBlock =
                (TallPlantBlock)(state.isOf(MoreWeaponryBlocks.INTOXICATED_FERN) ?
                        MoreWeaponryBlocks.INTOXICATED_LARGE_FERN : MoreWeaponryBlocks.INTOXICATED_TALL_GRASS);
        if (tallPlantBlock.getDefaultState().canPlaceAt(world, pos) && world.isAir(pos.up())) {
            TallPlantBlock.placeAt(world, tallPlantBlock.getDefaultState(), pos, 2);
        }
    }

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(MoreWeaponryBlocks.INTOXICATED_GRASS_BLOCK);
    }

}
