package net.DakotaPride.moreweaponry;

import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.DakotaPride.moreweaponry.enchantments.ModEnchantments;
import net.DakotaPride.moreweaponry.item.ModItems;
import net.DakotaPride.moreweaponry.registries.ModRegistries;
import net.DakotaPride.moreweaponry.util.ModRendererHelper;
import net.DakotaPride.moreweaponry.world.features.ModConfiguredFeatures;
import net.DakotaPride.moreweaponry.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.biome.Biome;



public class MoreWeaponry implements ModInitializer {
	public static final String MOD_ID = "moreweaponry";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	private static final ConfiguredFeature<?, ?> OVERWORLD_MARE_DIAMOND_ORE_CONFIGURED_FEATURE = Feature.ORE
			.configure(new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
					Blocks.DIAMOND_BLOCK.getDefaultState(),
					14)); // vein size
	public static PlacedFeature OVERWORLD_MARE_DIAMOND_ORE_PLACED_FEATURE = OVERWORLD_MARE_DIAMOND_ORE_CONFIGURED_FEATURE.withPlacement(
			CountPlacementModifier.of(30), // number of veins per chunk
			SquarePlacementModifier.of(), // spreading horizontally
			HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(20))); // height


	private static final ConfiguredFeature<?, ?> OVERWORLD_LIMESTONE_CONFIGURED_FEATURE = Feature.ORE
			.configure(new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
					Blocks.IRON_BLOCK.getDefaultState(),
					34)); // vein size
	public static PlacedFeature OVERWORLD_LIMESTONE_PLACED_FEATURE = OVERWORLD_LIMESTONE_CONFIGURED_FEATURE.withPlacement(
			CountPlacementModifier.of(30), // number of veins per chunk
			SquarePlacementModifier.of(), // spreading horizontally
			HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(20))); // height


	@Override
	public void onInitialize() {

		ModConfiguredFeatures.registerConfiguredFeatures();

		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("moreweaponry", "overworld_mare_diamond_ore"), OVERWORLD_MARE_DIAMOND_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("moreweaponry", "overworld_mare_diamond_ore"),
				OVERWORLD_MARE_DIAMOND_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("moreweaponry", "overworld_mare_diamond_ore")));


		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("moreweaponry", "overworld_limestone"), OVERWORLD_LIMESTONE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("moreweaponry", "overworld_limestone"),
				OVERWORLD_LIMESTONE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("moreweaponry", "overworld_limestone")));



		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NITRIS_TRAPDOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NITRIS_DOOR, RenderLayer.getCutout());

		ModRendererHelper.setRenderLayers();

		ModEnchantments.registerModEnchantments();

		ModRegistries.registerStrippables();

		ModWorldGen.generateModWorldGen();

	}

}
