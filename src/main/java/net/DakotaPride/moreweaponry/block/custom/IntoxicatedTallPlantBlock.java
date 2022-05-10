package net.DakotaPride.moreweaponry.block.custom;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class IntoxicatedTallPlantBlock extends TallPlantBlock {
    public IntoxicatedTallPlantBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(MoreWeaponry.INTOXICATED_GRASS_BLOCK) || floor.isOf(MoreWeaponry.SANDSTONE_DUST_BLOCK)
                || floor.isOf(Blocks.DIRT);
    }

}
