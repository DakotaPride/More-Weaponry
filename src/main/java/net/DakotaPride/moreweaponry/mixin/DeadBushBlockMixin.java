package net.DakotaPride.moreweaponry.mixin;

import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.DeadBushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DeadBushBlock.class)
public class DeadBushBlockMixin {

    @Inject(method = "canPlantOnTop", at = @At("RETURN"), cancellable = true)
    protected void canPlantOnTop(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(floor.isOf(MoreWeaponryBlocks.SANDSTONE_DUST_BLOCK));
    }
    
}
