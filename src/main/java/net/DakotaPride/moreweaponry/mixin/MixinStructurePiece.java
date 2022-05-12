package net.DakotaPride.moreweaponry.mixin;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.StructurePiece;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Random;


@Mixin(StructurePiece.class)
public abstract class MixinStructurePiece {

    @ModifyVariable(method = "addBlock", at = @At("HEAD"), argsOnly = true)
    private BlockState onaddBlock(BlockState blockState_1) {

        if (blockState_1.equals(MoreWeaponry.CRACKED_DRIPSTONE.getDefaultState())) {
            if (new Random().nextInt(12) == 0)
                blockState_1 = MoreWeaponry.INFESTED_CRACKED_DRIPSTONE.getDefaultState();

        } else if (blockState_1.equals(Blocks.DRIPSTONE_BLOCK.getDefaultState())) {
            if (new Random().nextInt(12) == 0)
                blockState_1 = MoreWeaponry.INFESTED_DRIPSTONE.getDefaultState();
        }

        return blockState_1;
    }
}
