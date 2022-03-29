package net.DakotaPride.moreweaponry.structure;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.mixin.StructureFeatureAccessor;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.StructureFeature;

public class MoreWeaponryStructureTypes {

    /**
     /**
     * Registers the structure itself and sets what its path is. In this case, the
     * structure will have the Identifier of structure_tutorial:sky_structures.
     *
     * It is always a good idea to register your Structures so that other mods and datapacks can
     * use them too directly from the registries. It great for mod/datapacks compatibility.
     */
    public static StructureFeature<?> BARD_ROCK = new BardRockStructure();
    public static StructureFeature<?> WANDERER_LIBRARY = new WandererLibraryStructure();

    public static void registerStructureFeatures() {
        // The generation step for when to generate the structure. there are 10 stages you can pick from!
        // This surface structure stage places the structure before plants and ores are generated.
        StructureFeatureAccessor.callRegister(MoreWeaponry.MOD_ID + ":bard_rock",
                BARD_ROCK, GenerationStep.Feature.SURFACE_STRUCTURES);

        StructureFeatureAccessor.callRegister(MoreWeaponry.MOD_ID + ":wanderer_library",
                WANDERER_LIBRARY, GenerationStep.Feature.UNDERGROUND_STRUCTURES);
    }
}
