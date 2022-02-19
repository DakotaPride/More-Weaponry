package net.DakotaPride.moreweaponry.mixin;

import net.DakotaPride.moreweaponry.block.ModBlocks;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.StructurePiece;


@Mixin(StructurePiece.class)
public abstract class MixinStructurePiece {

    @ModifyVariable(method = "addBlock", at = @At("HEAD"))
    private BlockState onaddBlock(BlockState blockState_1) {

        if (blockState_1.equals(ModBlocks.CRACKED_DRIPSTONE_BLOCK.getDefaultState())) {
            if (new Random().nextInt(12) == 0)
                blockState_1 = ModBlocks.INFESTED_CRACKED_DRIPSTONE_BLOCK.getDefaultState();

        } else if (blockState_1.equals(Blocks.DRIPSTONE_BLOCK.getDefaultState())) {
            if (new Random().nextInt(12) == 0)
                blockState_1 = ModBlocks.INFESTED_DRIPSTONE_BLOCK.getDefaultState();
        }

        return blockState_1;
    }
}
