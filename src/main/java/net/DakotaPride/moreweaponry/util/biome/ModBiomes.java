package net.DakotaPride.moreweaponry.util.biome;


import net.DakotaPride.moreweaponry.util.structure.ModStructures;

public class ModBiomes {
    public static void registerModBiomes() {
        WretchedWasteland();
        PeplexionPlains();
        MelodicCaves();
        BombatonNuclearZone();
        TobuntolHills();
    }

    public static void WretchedWasteland() {
        ModStructures.registerWretchedStructures();

        // Wretched Spawn Location Biome
        // Wretched Found In The Center Of This Biome

        // Cave Biome
        // Made Out Of Dripstone, Cracked Dripstone, And Granite
        // Spiders And Cave Spiders Spawn More Frequently
        // Only Mobs That Spawn Are Spiders And Cave Spiders (As Well As The Wretched Boss)

    }

    public static void PeplexionPlains() {
        ModStructures.registerWatcherStructures();

        // Watcher Spawn Location Biome
        // Watcher Found In The Large Obsidian Tower

        // End Biome
        // Made Out Of Peplex Nylium, With End Stone Below it
        // Endermen are always hostile while in this biome
        // Endermen spawn more frequently
        // Only Mobs That Spawn Are Endermen And Endermen Variants (As Well As The Watcher Boss)

    }

    public static void MelodicCaves() {
        ModStructures.registerMaidenStructures();

        // Maiden Spawn Location Biome
        // Maiden Found On A Large Rock In The Middle Of A Large Lake

        // Above Ground Ocean/Plains Biome
        // Made Out Of Mainly Water, with Rocks Structures scattered around
        // Aquatic/Underwater Mobs spawn less frequently, though Skeletons spawn more frequently with a small chance of becoming a Stray upon spawning
        // Aquatic/Underwater Mobs, as well as Skeletons, with a rare chance of a Stray (As Well As The Maiden Boss)

    }

    public static void BombatonNuclearZone() {
        ModStructures.registerSuppressedStructures();

        // Suppressed Spawn Location Biome
        // Suppressed Found In A Large Nuclear Plant-like Structure

        // Plains Biome
        // Made Out Of Intoxicated Grass Blocks, as well as other intoxicated variants of blocks
        // Creepers Spawn More Frequently
        // Only Mobs That Spawn Are Creepers (As Well As The Suppressed Boss)

    }

    public static void TobuntolHills() {
        ModStructures.registerPlaguedStructures();

        // Plagued Spawn Location Biome
        // Plagued Found Randomly 50 Blocks into the Biome

        // Plains/Hills Biome
        // Made Out Of Mostly Intoxicated Stone Variants, with very little other blocks
        // Zombies Spawn More Frequently And Always Spawn with a helmet of sorts when in this biome, with a small chance to turn into either a husk or a drowned
        // Only Mobs That Spawn Are Zombies, with a rare chance of a Husk or Drowned (As Well As The Plagued Boss)

    }

}
