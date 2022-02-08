package net.DakotaPride.moreweaponry;

import net.DakotaPride.moreweaponry.block.ModBlocks;
import net.DakotaPride.moreweaponry.enchantments.ModEnchantments;
import net.DakotaPride.moreweaponry.item.ModItems;
import net.DakotaPride.moreweaponry.painting.ModPaintings;
import net.DakotaPride.moreweaponry.util.ModRegistries;
import net.DakotaPride.moreweaponry.util.ModRendererHelper;
import net.DakotaPride.moreweaponry.world.dimension.ModPortals;
import net.DakotaPride.moreweaponry.world.features.ModConfiguredFeatures;
import net.DakotaPride.moreweaponry.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MoreWeaponry implements ModInitializer {
	public static final String MOD_ID = "moreweaponry";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


	@Override
	public void onInitialize() {

		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModEnchantments.registerModEnchantments();

		ModPaintings.registerPaintings();

		ModPortals.registerPortals();

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NITRIS_TRAPDOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NITRIS_DOOR, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_NIGHT_CURON, RenderLayer.getCutout());

		ModRendererHelper.setRenderLayers();

		ModRegistries.registerModFeatures();

		ModRegistries.registerModComposterChances();

		ModRegistries.registerStrippables();

		ModWorldGen.generateModWorldGen();

		ModEnchantments.registerModEnchantments();

	}

}
