package net.DakotaPride.moreweaponry.structure;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.PostPlacementProcessor;
import net.minecraft.structure.StructureGeneratorFactory;
import net.minecraft.structure.StructurePiecesGenerator;
import net.minecraft.structure.StructureSetKeys;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import org.apache.logging.log4j.Level;

import java.util.Optional;

public class BardRockStructure extends StructureFeature<StructurePoolFeatureConfig> {

    public BardRockStructure() {
        super(StructurePoolFeatureConfig.CODEC, BardRockStructure::createPiecesGenerator, PostPlacementProcessor.EMPTY);
    }

    private static boolean isFeatureChunk(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context) {
        // Grabs the chunk position we are at
        ChunkPos chunkpos = context.chunkPos();

        return !context.chunkGenerator().method_41053(StructureSetKeys.DESERT_PYRAMIDS, context.seed(), chunkpos.x, chunkpos.z, 10);
    }

    public static Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> createPiecesGenerator(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context) {

        if (!BardRockStructure.isFeatureChunk(context)) {
            return Optional.empty();
        }

        BlockPos blockpos = context.chunkPos().getCenterAtY(0);
        int topLandY = context.chunkGenerator().getHeightOnGround(blockpos.getX(), blockpos.getZ(), Heightmap.Type.WORLD_SURFACE_WG, context.world());
        blockpos = blockpos.up(topLandY + -3);

        Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> structurePiecesGenerator =
                StructurePoolBasedGenerator.generate(
                        context,
                        PoolStructurePiece::new,
                        blockpos,
                        false,
                        false
                );

        if(structurePiecesGenerator.isPresent()) {
            MoreWeaponry.LOGGER.log(Level.DEBUG, "Bard Rock Structure at {}", blockpos);
        }

        return structurePiecesGenerator;
    }
}
