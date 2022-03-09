package net.DakotaPride.moreweaponry.block;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.block.custom.*;
import net.DakotaPride.moreweaponry.block.entity.CoreForgeBlock;
import net.DakotaPride.moreweaponry.block.entity.EssenceTranslatorBlock;
import net.DakotaPride.moreweaponry.item.MoreWeaponryItemGroup;
import net.DakotaPride.moreweaponry.item.custom.KuroPlantBlock;
import net.DakotaPride.moreweaponry.world.features.MoreWeaponryConfiguredFeatures;
import net.DakotaPride.moreweaponry.world.features.tree.FrodonSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreWeaponryBlocks {

    public static final Block MOON_STONE_DUST_BLOCK = registerBlock("moon_stone_dust_block",
            new Block(FabricBlockSettings.of(Material.SNOW_BLOCK).strength(1f)
                    .sounds(BlockSoundGroup.LANTERN)
                    ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block KURO_WHEAT_BLOCK = registerBlock("kuro_wheat_block",
            new PillarBlock(FabricBlockSettings.of(Material.PLANT).strength(1f)
                    .sounds(BlockSoundGroup.GRASS)
                    ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block BLACKSTONE_METAL_BLOCK = registerBlock("blackstone_metal_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3f)
                    .sounds(BlockSoundGroup.BONE)
                    .requiresTool()), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block GLIMMERING_AMETHYST_BLOCK = registerBlock("glimmering_amethyst_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST).strength(2f)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .requiresTool()), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE = registerBlock("limestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE = registerBlock("cobbled_limestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block FRODON_LOG = registerBlock("frodon_log",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block FRODON_WOOD = registerBlock("frodon_wood",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block FRODON_PLANKS = registerBlock("frodon_planks",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block STRIPPED_FRODON_LOG = registerBlock("stripped_frodon_log",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block STRIPPED_FRODON_WOOD = registerBlock("stripped_frodon_wood",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block FRODON_LEAVES = registerBlock("frodon_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block FRODON_SAPLING = registerBlock("frodon_sapling",
            new FrodonSaplingBlock(new FrodonSaplingGenerator(MoreWeaponryConfiguredFeatures.FRODON_TREE),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block NIGHT_CURON = registerBlock("night_curon",
            new FlowerBlock(StatusEffects.WITHER, 100,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque().noCollision()),
                    MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block FRODON_SLAB = registerBlock("frodon_slab",
            new SlabBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block FRODON_STAIRS = registerBlock("frodon_stairs",
            new MoreWeaponryStairsBlock(MoreWeaponryBlocks.FRODON_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE_SLAB = registerBlock("limestone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE_STAIRS = registerBlock("limestone_stairs",
            new MoreWeaponryStairsBlock(MoreWeaponryBlocks.LIMESTONE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE_SLAB = registerBlock("cobbled_limestone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE_STAIRS = registerBlock("cobbled_limestone_stairs",
            new MoreWeaponryStairsBlock(MoreWeaponryBlocks.COBBLED_LIMESTONE.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(2f)
                            .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block FRODON_FENCE = registerBlock("frodon_fence",
            new FenceBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block FRODON_FENCE_GATE = registerBlock("frodon_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE_WALL = registerBlock("limestone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE_WALL = registerBlock("cobbled_limestone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block FRODON_BUTTON = registerBlock("frodon_button",
            new MoreWeaponryWoodenButtonBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE_BUTTON = registerBlock("limestone_button",
            new MoreWeaponryStoneButtonBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block COBBLESTONE_BUTTON = registerBlock("cobblestone_button",
            new MoreWeaponryStoneButtonBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE_BUTTON = registerBlock("cobbled_limestone_button",
            new MoreWeaponryStoneButtonBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block FRODON_PRESSURE_PLATE = registerBlock("frodon_pressure_plate",
            new MoreWeaponryPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE_PRESSURE_PLATE = registerBlock("limestone_pressure_plate",
            new MoreWeaponryPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block COBBLESTONE_PRESSURE_PLATE = registerBlock("cobblestone_pressure_plate",
            new MoreWeaponryPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE_PRESSURE_PLATE = registerBlock("cobbled_limestone_pressure_plate",
            new MoreWeaponryPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block FRODON_DOOR = registerBlock("frodon_door",
            new MoreWeaponryDoorBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                            .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                        ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block FRODON_TRAPDOOR = registerBlock("frodon_trapdoor",
            new MoreWeaponryTrapdoorBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block MARE_DIAMOND_BLOCK = registerBlock("mare_diamond_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block CIRTICT_BLOCK = registerBlock("cirtict_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f)
                    .sounds(BlockSoundGroup.METAL)
                    .requiresTool()
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block CROP_CUTTER_BLOCK = registerBlock("crop_cutter_block",
            new Block(FabricBlockSettings.of(Material.WOOD)), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block MARE_DIAMOND_ORE = registerBlock("mare_diamond_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block DEEPSLATE_MARE_DIAMOND_ORE = registerBlock("deepslate_mare_diamond_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block BLUESTONE = registerBlock("bluestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_BLUESTONE = registerBlock("cobbled_bluestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block BLUESTONE_STAIRS = registerBlock("bluestone_stairs",
            new MoreWeaponryStairsBlock(MoreWeaponryBlocks.BLUESTONE.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_BLUESTONE_STAIRS = registerBlock("cobbled_bluestone_stairs",
            new MoreWeaponryStairsBlock(MoreWeaponryBlocks.COBBLED_BLUESTONE.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block BLUESTONE_SLAB = registerBlock("bluestone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_BLUESTONE_SLAB = registerBlock("cobbled_bluestone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block BLUESTONE_WALL = registerBlock("bluestone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_BLUESTONE_WALL = registerBlock("cobbled_bluestone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block CIRTICT_DEBRIS = registerBlock("cirtict_debris",
            new Block(FabricBlockSettings.copy(Blocks.ANCIENT_DEBRIS)), MoreWeaponryItemGroup.MORE_WEAPONRY);


    // Plague Update

    public static final Block SANDSTONE_DUST_BLOCK = registerBlock("sandstone_dust_block",
            new SandstoneDustBlock((11098145),FabricBlockSettings.copy(Blocks.SAND)), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block CRACKED_DRIPSTONE_BLOCK = registerBlock("cracked_dripstone_block",
            new Block(FabricBlockSettings.copy(Blocks.DRIPSTONE_BLOCK)), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block INFESTED_CRACKED_DRIPSTONE_BLOCK = registerBlock("infested_cracked_dripstone_block",
            new WretchedInfestedBlock(MoreWeaponryBlocks.CRACKED_DRIPSTONE_BLOCK, FabricBlockSettings.copy(Blocks.INFESTED_STONE)),
            MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block INFESTED_DRIPSTONE_BLOCK = registerBlock("infested_dripstone_block",
            new WretchedInfestedBlock(Blocks.DRIPSTONE_BLOCK, FabricBlockSettings.copy(Blocks.INFESTED_STONE)),
            MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block ESSENCE_TRANSLATOR = registerBlock("essence_translator",
            new EssenceTranslatorBlock(FabricBlockSettings.copy(Blocks.STONE)), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block CORE_FORGE = registerBlock("core_forge",
            new CoreForgeBlock(FabricBlockSettings.copy(Blocks.OBSIDIAN)), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block PEPLEX_NYLIUM = registerBlock("peplex_nylium",
            new EndNyliumBlock(FabricBlockSettings.copy(Blocks.END_STONE)), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block INTOXICATED_STONE = registerBlock("intoxicated_stone",
            new Block(FabricBlockSettings.copy(Blocks.STONE)), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block INTOXICATED_GRASS_BLOCK = registerBlock("intoxicated_grass_block",
            new IntoxicatedGrassBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK)), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block INTOXICATED_GRASS = registerBlock("intoxicated_grass",
            new IntoxicatedFernBlock(FabricBlockSettings.copy(Blocks.GRASS)), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block INTOXICATED_FERN = registerBlock("intoxicated_fern",
            new IntoxicatedFernBlock(FabricBlockSettings.copy(Blocks.FERN)), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block INTOXICATED_TALL_GRASS = registerBlock("intoxicated_tall_grass",
            new IntoxicatedTallPlantBlock(FabricBlockSettings.copy(Blocks.TALL_GRASS)), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block INTOXICATED_LARGE_FERN = registerBlock("intoxicated_large_fern",
            new IntoxicatedTallPlantBlock(FabricBlockSettings.copy(Blocks.LARGE_FERN)), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block SUPPRESSED_EXPLOSION = registerBlock("suppressed_explosion",
            new SuppressedExplosive(FabricBlockSettings.copy(Blocks.TNT)), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block INTOXICATED_POPPY = registerBlock("intoxicated_poppy",
            new IntoxicatedFlowerBlock(StatusEffects.POISON, 100,
                    FabricBlockSettings.copy(Blocks.POPPY).nonOpaque().noCollision()),
            MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block INTOXICATED_DANDELION = registerBlock("intoxicated_dandelion",
            new IntoxicatedFlowerBlock(StatusEffects.ABSORPTION, 100,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque().noCollision()),
            MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block PACKED_WATCHER_CLOTH_BLOCK = registerBlock("packed_watcher_cloth_block",
            new Block(FabricBlockSettings.copy(Blocks.BLACK_WOOL)), MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block WRETCHED_SKULL = registerBlock("wretched_skull",
            new WretchedSkullBlock(FabricBlockSettings.copy(Blocks.PLAYER_HEAD).nonOpaque()),
            MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block WATCHER_SKULL = registerBlock("watcher_skull",
            new WatcherSkullBlock(FabricBlockSettings.copy(Blocks.PLAYER_HEAD).nonOpaque()),
            MoreWeaponryItemGroup.MORE_WEAPONRY);


    public static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(MoreWeaponry.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(MoreWeaponry.MOD_ID, name),
        new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static Block registerCompostableBlock(String name, Block block, ItemGroup group, float compostValue) {
        Item blockItem = registerBlockItem(name, block, group);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(blockItem, compostValue);
        return Registry.register(Registry.BLOCK, new Identifier(MoreWeaponry.MOD_ID, name), block);
    }


    public static final Block KURO_PLANT = registerBlockWithoutBlockItem("kuro_plant",
            new KuroPlantBlock(FabricBlockSettings.of(Material.PLANT).sounds(BlockSoundGroup.ROOTS).nonOpaque()
                    .noCollision()), MoreWeaponryItemGroup.MORE_WEAPONRY);


    public static final Block POTTED_NIGHT_CURON = registerBlockWithoutBlockItem("potted_night_curon",
            new FlowerPotBlock(MoreWeaponryBlocks.NIGHT_CURON, FabricBlockSettings.copy(Blocks.POTTED_ALLIUM)),
            MoreWeaponryItemGroup.MORE_WEAPONRY);


    public static final Block FRODON_WALL_SIGN = registerBlockWithoutBlockItem("frodon_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), MoreWeaponrySignTypes.FRODON),
            MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static final Block FRODON_SIGN = registerBlockWithoutBlockItem("frodon_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), MoreWeaponrySignTypes.FRODON),
            MoreWeaponryItemGroup.MORE_WEAPONRY);

    public static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.BLOCK, new Identifier(MoreWeaponry.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        MoreWeaponry.LOGGER.info("Registering Mod Blocks for" + MoreWeaponry.MOD_ID);
    }



}
