package net.DakotaPride.moreweaponry.block;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.block.custom.*;
import net.DakotaPride.moreweaponry.item.ModItemGroup;
import net.DakotaPride.moreweaponry.item.custom.KuroPlantBlock;
import net.DakotaPride.moreweaponry.world.features.ModConfiguredFeatures;
import net.DakotaPride.moreweaponry.world.features.tree.NitrisSaplingGenerator;
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

public class ModBlocks {

    public static final Block MOON_STONE_DUST_BLOCK = registerBlock("moon_stone_dust_block",
            new Block(FabricBlockSettings.of(Material.SNOW_BLOCK).strength(1f)
                    .sounds(BlockSoundGroup.LANTERN)
                    ), ModItemGroup.MORE_WEAPONRY);

    public static final Block KURO_WHEAT_BLOCK = registerBlock("kuro_wheat_block",
            new PillarBlock(FabricBlockSettings.of(Material.PLANT).strength(1f)
                    .sounds(BlockSoundGroup.GRASS)
                    ), ModItemGroup.MORE_WEAPONRY);

    public static final Block BLACKSTONE_METAL_BLOCK = registerBlock("blackstone_metal_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3f)
                    .sounds(BlockSoundGroup.BONE)
                    .requiresTool()), ModItemGroup.MORE_WEAPONRY);

    public static final Block GLIMMERING_AMETHYST_BLOCK = registerBlock("glimmering_amethyst_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST).strength(2f)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .requiresTool()), ModItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE = registerBlock("limestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE = registerBlock("cobbled_limestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_LOG = registerBlock("nitris_log",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_WOOD = registerBlock("nitris_wood",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_PLANKS = registerBlock("nitris_planks",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    ), ModItemGroup.MORE_WEAPONRY);

    public static final Block STRIPPED_NITRIS_LOG = registerBlock("stripped_nitris_log",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    ), ModItemGroup.MORE_WEAPONRY);

    public static final Block STRIPPED_NITRIS_WOOD = registerBlock("stripped_nitris_wood",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_LEAVES = registerBlock("nitris_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_SAPLING = registerBlock("nitris_sapling",
            new ModSaplingBlock(new NitrisSaplingGenerator(ModConfiguredFeatures.NITRIS_TREE),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)), ModItemGroup.MORE_WEAPONRY);

    public static final Block NIGHT_CURON = registerBlock("night_curon",
            new FlowerBlock(StatusEffects.WITHER, 100,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque().noCollision()),
                    ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_SLAB = registerBlock("nitris_slab",
            new SlabBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_STAIRS = registerBlock("nitris_stairs",
            new ModStairsBlock(ModBlocks.NITRIS_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE_SLAB = registerBlock("limestone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE_STAIRS = registerBlock("limestone_stairs",
            new ModStairsBlock(ModBlocks.LIMESTONE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE_SLAB = registerBlock("cobbled_limestone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE_STAIRS = registerBlock("cobbled_limestone_stairs",
            new ModStairsBlock(ModBlocks.COBBLED_LIMESTONE.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(2f)
                            .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_FENCE = registerBlock("nitris_fence",
            new FenceBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_FENCE_GATE = registerBlock("nitris_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE_WALL = registerBlock("limestone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE_WALL = registerBlock("cobbled_limestone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_BUTTON = registerBlock("nitris_button",
            new ModWoodenButtonBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE_BUTTON = registerBlock("limestone_button",
            new ModStoneButtonBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLESTONE_BUTTON = registerBlock("cobblestone_button",
            new ModStoneButtonBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE_BUTTON = registerBlock("cobbled_limestone_button",
            new ModStoneButtonBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_PRESSURE_PLATE = registerBlock("nitris_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE_PRESSURE_PLATE = registerBlock("limestone_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLESTONE_PRESSURE_PLATE = registerBlock("cobblestone_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE_PRESSURE_PLATE = registerBlock("cobbled_limestone_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_DOOR = registerBlock("nitris_door",
            new ModDoorBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                            .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
                        ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_TRAPDOOR = registerBlock("nitris_trapdoor",
            new ModTrapdoorBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block MARE_DIAMOND_BLOCK = registerBlock("mare_diamond_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block CIRTICT_BLOCK = registerBlock("cirtict_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f)
                    .sounds(BlockSoundGroup.METAL)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block CROP_CUTTER_BLOCK = registerBlock("crop_cutter_block",
            new Block(FabricBlockSettings.of(Material.WOOD)), ModItemGroup.MORE_WEAPONRY);

    public static final Block MARE_DIAMOND_ORE = registerBlock("mare_diamond_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block DEEPSLATE_MARE_DIAMOND_ORE = registerBlock("deepslate_mare_diamond_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block BLUESTONE = registerBlock("bluestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_BLUESTONE = registerBlock("cobbled_bluestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()), ModItemGroup.MORE_WEAPONRY);

    public static final Block BLUESTONE_STAIRS = registerBlock("bluestone_stairs",
            new ModStairsBlock(ModBlocks.BLUESTONE.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_BLUESTONE_STAIRS = registerBlock("cobbled_bluestone_stairs",
            new ModStairsBlock(ModBlocks.COBBLED_BLUESTONE.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()), ModItemGroup.MORE_WEAPONRY);

    public static final Block BLUESTONE_SLAB = registerBlock("bluestone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_BLUESTONE_SLAB = registerBlock("cobbled_bluestone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()), ModItemGroup.MORE_WEAPONRY);

    public static final Block BLUESTONE_WALL = registerBlock("bluestone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_BLUESTONE_WALL = registerBlock("cobbled_bluestone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block CIRTICT_DEBRIS = registerBlock("cirtict_debris",
            new Block(FabricBlockSettings.copy(Blocks.ANCIENT_DEBRIS)), ModItemGroup.MORE_WEAPONRY);


    // Plague Update

    public static final Block SANDSTONE_DUST_BLOCK = registerBlock("sandstone_dust_block",
            new SandstoneDustBlock((11098145),FabricBlockSettings.copy(Blocks.SAND)), ModItemGroup.MORE_WEAPONRY);

    public static final Block CRACKED_DRIPSTONE_BLOCK = registerBlock("cracked_dripstone_block",
            new Block(FabricBlockSettings.copy(Blocks.DRIPSTONE_BLOCK)), ModItemGroup.MORE_WEAPONRY);

    public static final Block INFESTED_CRACKED_DRIPSTONE_BLOCK = registerBlock("infested_cracked_dripstone_block",
            new WretchedInfestedBlock(ModBlocks.CRACKED_DRIPSTONE_BLOCK, FabricBlockSettings.copy(Blocks.INFESTED_STONE)),
            ModItemGroup.MORE_WEAPONRY);

    public static final Block WRETCHED_SPAWN_BLOCK = registerBlock("wretched_spawn_block",
            new WretchedSpawnBlock(ModBlocks.CRACKED_DRIPSTONE_BLOCK, FabricBlockSettings.copy(Blocks.INFESTED_STONE)),
            ModItemGroup.MORE_WEAPONRY);

    public static final Block INFESTED_DRIPSTONE_BLOCK = registerBlock("infested_dripstone_block",
            new WretchedInfestedBlock(Blocks.DRIPSTONE_BLOCK, FabricBlockSettings.copy(Blocks.INFESTED_STONE)),
            ModItemGroup.MORE_WEAPONRY);

    public static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(MoreWeaponry.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(MoreWeaponry.MOD_ID, name),
        new BlockItem(block, new FabricItemSettings().group(group)));
    }


    public static final Block KURO_PLANT = registerBlockWithoutBlockItem("kuro_plant",
            new KuroPlantBlock(FabricBlockSettings.of(Material.PLANT).sounds(BlockSoundGroup.ROOTS).nonOpaque()
                    .noCollision()), ModItemGroup.MORE_WEAPONRY);


    public static final Block POTTED_NIGHT_CURON = registerBlockWithoutBlockItem("potted_night_curon",
            new FlowerPotBlock(ModBlocks.NIGHT_CURON, FabricBlockSettings.copy(Blocks.POTTED_ALLIUM)),
            ModItemGroup.MORE_WEAPONRY);


    public static final Block NITRIS_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("nitris_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), ModSignTypes.NITRIS),
            ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_SIGN_BLOCK = registerBlockWithoutBlockItem("nitris_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.NITRIS),
            ModItemGroup.MORE_WEAPONRY);

    public static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.BLOCK, new Identifier(MoreWeaponry.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        MoreWeaponry.LOGGER.info("Registering Mod Blocks for" + MoreWeaponry.MOD_ID);
    }



}
