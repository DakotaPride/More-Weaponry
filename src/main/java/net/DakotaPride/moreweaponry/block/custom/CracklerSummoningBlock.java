package net.DakotaPride.moreweaponry.block.custom;

import com.google.common.collect.Maps;
import net.DakotaPride.moreweaponry.entity.MoreWeaponryEntities;
import net.DakotaPride.moreweaponry.entity.custom.CracklerEntity;
import net.DakotaPride.moreweaponry.entity.custom.WatcherEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.Map;

public class CracklerSummoningBlock extends Block {
    private final Block regularBlock;
    private static final Map<Block, Block> REGULAR_TO_INFESTED_BLOCK = Maps.newIdentityHashMap();

    /**
     * Creates an infested block
     *
     * @param regularBlock the block this infested block should mimic
     * @param settings block settings
     */
    public CracklerSummoningBlock(Block regularBlock, Settings settings) {
        super(settings);
        this.regularBlock = regularBlock;
        REGULAR_TO_INFESTED_BLOCK.put(regularBlock, this);
    }

    public CracklerSummoningBlock(Settings settings, Block regularBlock) {
        super(settings);
        this.regularBlock = regularBlock;
    }

    public Block getRegularBlock() {
        return this.regularBlock;
    }

    public static boolean isInfestable(BlockState block) {
        return REGULAR_TO_INFESTED_BLOCK.containsKey(block.getBlock());
    }

    private void spawnCrackler(ServerWorld world, BlockPos pos) {
        CracklerEntity cracklerEntity = MoreWeaponryEntities.CRACKLER.create(world);
        assert cracklerEntity != null;
        cracklerEntity.refreshPositionAndAngles((double)pos.getX() + 0.5, pos.getY(), (double)pos.getZ() + 0.5, 0.0f, 0.0f);
        world.spawnEntity(cracklerEntity);
        cracklerEntity.playSpawnEffects();
    }

    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
        super.onStacksDropped(state, world, pos, stack);
        if (world.getGameRules().getBoolean(GameRules.DO_TILE_DROPS) && EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
            this.spawnCrackler(world, pos);
        }
    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        if (world instanceof ServerWorld) {
            this.spawnCrackler((ServerWorld)world, pos);
        }
    }


}


