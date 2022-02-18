package net.DakotaPride.moreweaponry.world.gen;

public class ModWorldGen {
    public static void generateModWorldGen() {

        /// RAW_GENERATION,
        //        LAKES,
        //        LOCAL_MODIFICATIONS,
        //        UNDERGROUND_STRUCTURES,
        //        SURFACE_STRUCTURES,
        //        STRONGHOLDS,
        //        UNDERGROUND_ORES,
        //        UNDERGROUND_DECORATION,
        //        FLUID_SPRINGS,
        //        VEGETAL_DECORATION,
        //        TOP_LAYER_MODIFICATION

        ModOreGeneration.generateOres();
        ModRawGeneration.generateRawGeneration();

        ModTreeGeneration.generateTrees();
        ModFlowerGeneration.generateFlowers();

        ModTopLayerModification.generateTopLayerModifications();
    }


}
