package net.DakotaPride.moreweaponry.common.world.gen;

public class MoreWeaponryWorldGen {
    public static void generateMoreWeaponryWorldGen() {

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

        MoreWeaponryOreGeneration.generateOres();
        MoreWeaponryRawGeneration.generateRawGeneration();

        MoreWeaponryTreeGeneration.generateTrees();
        MoreWeaponryFlowerGeneration.generateFlowers();

        MoreWeaponryTopLayerModification.generateTopLayerModifications();
    }


}
