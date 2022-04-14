package net.DakotaPride.moreweaponry;

import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.DakotaPride.moreweaponry.block.entity.MoreWeaponryBlockEntities;
import net.DakotaPride.moreweaponry.effect.MoreWeaponryEffects;
import net.DakotaPride.moreweaponry.effect.MoreWeaponryPotions;
import net.DakotaPride.moreweaponry.enchantments.MoreWeaponryEnchantments;
import net.DakotaPride.moreweaponry.item.MoreWeaponryItems;
import net.DakotaPride.moreweaponry.painting.MoreWeaponryPaintings;
import net.DakotaPride.moreweaponry.recipe.MoreWeaponryRecipes;
import net.DakotaPride.moreweaponry.structure.MoreWeaponryStructureTypes;
import net.DakotaPride.moreweaponry.util.MoreWeaponryHeadLootTables;
import net.DakotaPride.moreweaponry.util.MoreWeaponryLootTableModifiers;
import net.DakotaPride.moreweaponry.util.MoreWeaponryRegistries;
import net.DakotaPride.moreweaponry.util.MoreWeaponryTags;
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

		MoreWeaponryStructureTypes.registerStructureFeatures();

		MoreWeaponryConfiguredFeatures.registerConfiguredFeatures();

		MoreWeaponryRecipes.registerMoreWeaponryRecipes();

		MoreWeaponryItems.registerMoreWeaponryItems();
		MoreWeaponryBlocks.registerMoreWeaponryBlocks();

		MoreWeaponryEnchantments.registerMoreWeaponryEnchantments();

		MoreWeaponryPotions.registerMoreWeaponryPotions();
		MoreWeaponryPotions.registerMoreWeaponryPotionRecipes();

		MoreWeaponryPaintings.registerMoreWeaponryPaintings();

		MoreWeaponryPortals.registerMoreWeaponryPortals();

		MoreWeaponryRegistries.registerMoreWeaponryFeatures();

		MoreWeaponryRegistries.registerMoreWeaponryComposterChances();

		MoreWeaponryRegistries.registerMoreWeaponryStrippables();

		MoreWeaponryWorldGen.generateMoreWeaponryWorldGen();

		MoreWeaponryLootTableModifiers.modifyLootTables();
		MoreWeaponryHeadLootTables.registerMoreWeaponryHeadLootTables();

		MoreWeaponryTags.MoreWeaponryBlockTags();
		MoreWeaponryTags.MoreWeaponryItemTags();

		MoreWeaponryEffects.registerMoreWeaponryEffects();

		GeckoLib.initialize();

	}

}
