package net.DakotaPride.moreweaponry.common.block.custom;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class IntoxicatedFlowerBlock extends PlantBlock {
    protected static final float field_31094 = 3.0f;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 10.0, 11.0);
    private final StatusEffect effectInWatcherBrew;
    private final int effectInWatcherBrewDuration;

    public IntoxicatedFlowerBlock(StatusEffect watcherBrewEffect, int effectDuration, AbstractBlock.Settings settings) {
        super(settings);
        this.effectInWatcherBrew = watcherBrewEffect;
        this.effectInWatcherBrewDuration = watcherBrewEffect.isInstant() ? effectDuration : effectDuration * 20;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        return SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
    }

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(MoreWeaponry.INTOXICATED_GRASS_BLOCK) || floor.isOf(MoreWeaponry.SANDSTONE_DUST_BLOCK)
                || floor.isOf(Blocks.DIRT);
    }

    @Override
    public AbstractBlock.OffsetType getOffsetType() {
        return AbstractBlock.OffsetType.XZ;
    }

    public StatusEffect getEffectInStew() {
        return this.effectInWatcherBrew;
    }

    public int getEffectInStewDuration() {
        return this.effectInWatcherBrewDuration;
    }
}
