package net.DakotaPride.moreweaponry.common.structure;

/*

public class WandererLibraryStructure extends StructureFeature<StructurePoolFeatureConfig> {

    public WandererLibraryStructure() {
        super(StructurePoolFeatureConfig.CODEC, WandererLibraryStructure::createPiecesGenerator, PostPlacementProcessor.EMPTY);
    }
    private static boolean isFeatureChunk(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context) {
        ChunkPos chunkpos = context.chunkPos();

        return !context.chunkGenerator().method_41053(StructureSetKeys.JUNGLE_TEMPLES, context.seed(), chunkpos.x, chunkpos.z, 10);
    }

    public static Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> createPiecesGenerator(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context) {

        if (!WandererLibraryStructure.isFeatureChunk(context)) {
            return Optional.empty();
        }

        BlockPos blockpos = context.chunkPos().getCenterAtY(0);

        int topLandY = context.chunkGenerator().getHeightOnGround(blockpos.getX(), blockpos.getZ(), Heightmap.Type.WORLD_SURFACE_WG, context.world());
        blockpos = blockpos.up(topLandY + -50);

        Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> structurePiecesGenerator =
                StructurePoolBasedGenerator.generate(
                        context,
                        PoolStructurePiece::new,
                        blockpos,
                        false,
                        false
                );
        if(structurePiecesGenerator.isPresent()) {
            MoreWeaponry.LOGGER.log(Level.DEBUG, "Wanderer Library Structure at {}", blockpos);
        }

        return structurePiecesGenerator;
    }
}


 */