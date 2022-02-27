package net.DakotaPride.moreweaponry.block.custom;

import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;


public class FrodonSaplingBlock extends SaplingBlock {
    public FrodonSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.DIRT) || floor.isOf(Blocks.GRASS_BLOCK);
    }

}
