package net.DakotaPride.moreweaponry;

import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.DakotaPride.moreweaponry.block.entity.MoreWeaponryBlockEntities;
import net.DakotaPride.moreweaponry.enchantments.MoreWeaponryEnchantments;
import net.DakotaPride.moreweaponry.item.MoreWeaponryItems;
import net.DakotaPride.moreweaponry.painting.MoreWeaponryPaintings;
import net.DakotaPride.moreweaponry.recipe.MoreWeaponryRecipes;
import net.DakotaPride.moreweaponry.util.MoreWeaponryRegistries;
import net.DakotaPride.moreweaponry.util.MoreWeaponryTags;
import net.DakotaPride.moreweaponry.util.biome.MoreWeaponryBiomes;
import net.DakotaPride.moreweaponry.util.structure.MoreWeaponryStructures;
import net.DakotaPride.moreweaponry.world.dimension.MoreWeaponryPortals;
import net.DakotaPride.moreweaponry.world.features.MoreWeaponryConfiguredFeatures;
import net.DakotaPride.moreweaponry.world.gen.MoreWeaponryWorldGen;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;


public class MoreWeaponry implements ModInitializer {
	public static final String MOD_ID = "moreweaponry";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


	@Override
	public void onInitialize() {

		MoreWeaponryConfiguredFeatures.registerConfiguredFeatures();

		MoreWeaponryBlockEntities.registerMoreWeaponryBlockEntities();
		MoreWeaponryRecipes.registerMoreWeaponryRecipes();

		MoreWeaponryItems.registerModItems();
		MoreWeaponryBlocks.registerModBlocks();

		MoreWeaponryEnchantments.registerModEnchantments();

		MoreWeaponryVillagerTrades.registerTrades();

		MoreWeaponryPaintings.registerPaintings();

		MoreWeaponryPortals.registerMoreWeaponryPortals();

		MoreWeaponryRegistries.registerModFeatures();

		MoreWeaponryRegistries.registerModComposterChances();

		MoreWeaponryRegistries.registerStrippables();

		MoreWeaponryWorldGen.generateModWorldGen();

		MoreWeaponryBiomes.registerModBiomes();

		MoreWeaponryStructures.registerMaidenStructures();
		MoreWeaponryStructures.registerPlaguedStructures();
		MoreWeaponryStructures.registerSuppressedStructures();
		MoreWeaponryStructures.registerWatcherStructures();
		MoreWeaponryStructures.registerWretchedStructures();

		MoreWeaponryTags.registerItemTags();
		MoreWeaponryTags.registerBlockTags();

		GeckoLib.initialize();

	}

}
