package net.DakotaPride.moreweaponry.structure;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.mixin.StructureFeatureAccessor;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.StructureFeature;

public class MoreWeaponryStructureTypes {

    public static StructureFeature<?> BARD_ROCK = new BardRockStructure();
    public static StructureFeature<?> WANDERER_LIBRARY = new WandererLibraryStructure();
    public static StructureFeature<?> SICKENED_GRAVES = new SickenedGravesStructure();
    public static StructureFeature<?> DARKEST_CAVERN_FORTRESS = new DarkestCavernFortressStructure();


    public static void registerStructureFeatures() {
        StructureFeatureAccessor.callRegister(MoreWeaponry.MOD_ID + ":bard_rock",
                BARD_ROCK, GenerationStep.Feature.SURFACE_STRUCTURES);

        StructureFeatureAccessor.callRegister(MoreWeaponry.MOD_ID + ":wanderer_library",
                WANDERER_LIBRARY, GenerationStep.Feature.UNDERGROUND_STRUCTURES);

        StructureFeatureAccessor.callRegister(MoreWeaponry.MOD_ID + ":sickened_graves",
                SICKENED_GRAVES, GenerationStep.Feature.SURFACE_STRUCTURES);

        StructureFeatureAccessor.callRegister(MoreWeaponry.MOD_ID + ":darkest_cavern_fortress",
                DARKEST_CAVERN_FORTRESS, GenerationStep.Feature.UNDERGROUND_STRUCTURES);

    }
}
