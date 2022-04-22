package net.DakotaPride.moreweaponry;

import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.DakotaPride.moreweaponry.effect.MoreWeaponryEffects;
import net.DakotaPride.moreweaponry.effect.MoreWeaponryPotions;
import net.DakotaPride.moreweaponry.enchantments.MoreWeaponryEnchantments;
import net.DakotaPride.moreweaponry.entity.IronBoltEntity;
import net.DakotaPride.moreweaponry.item.IronBoltItem;
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
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;


public class MoreWeaponry implements ModInitializer {
	public static final String MOD_ID = "moreweaponry";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	private static <T extends Entity> EntityType<T> registerEntity(String name, EntityType<T> entityType) {
		return Registry.register(Registry.ENTITY_TYPE, new Identifier(MOD_ID, name), entityType);
	}

	public static EntityType<IronBoltEntity> IRON_BOLT;




	@Override
	public void onInitialize() {

		IRON_BOLT = registerEntity("iron_bolt",FabricEntityTypeBuilder .<IronBoltEntity>create
						(SpawnGroup.MISC, IronBoltEntity::new)
				.dimensions(EntityDimensions.changing(0.5f, 0.5f)).trackRangeBlocks(4).trackedUpdateRate(20).build());

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
