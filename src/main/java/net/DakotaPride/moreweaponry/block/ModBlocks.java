package net.DakotaPride.moreweaponry.block;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.block.custom.*;
import net.DakotaPride.moreweaponry.item.ModItemGroup;
import net.DakotaPride.moreweaponry.item.custom.KuroPlantBlock;
import net.DakotaPride.moreweaponry.world.features.ModConfiguredFeatures;
import net.DakotaPride.moreweaponry.world.features.tree.ModSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
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
            new Block(FabricBlockSettings.of(Material.WOOL).strength(1f)
                    .sounds(BlockSoundGroup.LANTERN).breakByTool(FabricToolTags.SHOVELS)
                    ), ModItemGroup.MORE_WEAPONRY);

    public static final Block KURO_WHEAT_BLOCK = registerBlock("kuro_wheat_block",
            new PillarBlock(FabricBlockSettings.of(Material.PLANT).strength(1f)
                    .sounds(BlockSoundGroup.GRASS).breakByTool(FabricToolTags.HOES)
                    ), ModItemGroup.MORE_WEAPONRY);

    public static final Block BLACKSTONE_METAL_BLOCK = registerBlock("blackstone_metal_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3f)
                    .sounds(BlockSoundGroup.BONE).breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()), ModItemGroup.MORE_WEAPONRY);

    public static final Block GLIMMERING_AMETHYST_BLOCK = registerBlock("glimmering_amethyst_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST).strength(2f)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK).breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()), ModItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE = registerBlock("limestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE = registerBlock("cobbled_limestone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_LOG = registerBlock("nitris_log",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)
                    ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_WOOD = registerBlock("nitris_wood",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)
                    ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_PLANKS = registerBlock("nitris_planks",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)
                    ), ModItemGroup.MORE_WEAPONRY);

    public static final Block STRIPPED_NITRIS_LOG = registerBlock("stripped_nitris_log",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)
                    ), ModItemGroup.MORE_WEAPONRY);

    public static final Block STRIPPED_NITRIS_WOOD = registerBlock("stripped_nitris_wood",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_LEAVES = registerBlock("nitris_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_SAPLING = registerBlock("nitris_sapling",
            new ModSaplingBlock(new ModSaplingGenerator(ModConfiguredFeatures.NITRIS_TREE),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)), ModItemGroup.MORE_WEAPONRY);

    public static final Block NIGHT_CURON = registerBlock("night_curon",
            new FlowerBlock(StatusEffects.WITHER, 100,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque().noCollision()),
                    ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_SLAB = registerBlock("nitris_slab",
            new SlabBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_STAIRS = registerBlock("nitris_stairs",
            new ModStairsBlock(ModBlocks.NITRIS_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE_SLAB = registerBlock("limestone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE_STAIRS = registerBlock("limestone_stairs",
            new ModStairsBlock(ModBlocks.LIMESTONE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE_SLAB = registerBlock("cobbled_limestone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE_STAIRS = registerBlock("cobbled_limestone_stairs",
            new ModStairsBlock(ModBlocks.COBBLED_LIMESTONE.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(2f)
                            .requiresTool()
                    .sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_FENCE = registerBlock("nitris_fence",
            new FenceBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_FENCE_GATE = registerBlock("nitris_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE_WALL = registerBlock("limestone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE_WALL = registerBlock("cobbled_limestone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_BUTTON = registerBlock("nitris_button",
            new ModWoodenButtonBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE_BUTTON = registerBlock("limestone_button",
            new ModStoneButtonBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLESTONE_BUTTON = registerBlock("cobblestone_button",
            new ModStoneButtonBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE_BUTTON = registerBlock("cobbled_limestone_button",
            new ModStoneButtonBlock(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_PRESSURE_PLATE = registerBlock("nitris_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block LIMESTONE_PRESSURE_PLATE = registerBlock("limestone_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLESTONE_PRESSURE_PLATE = registerBlock("cobblestone_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block COBBLED_LIMESTONE_PRESSURE_PLATE = registerBlock("cobbled_limestone_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_DOOR = registerBlock("nitris_door",
            new ModDoorBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                            .sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)
                    .nonOpaque()
                        ), ModItemGroup.MORE_WEAPONRY);

    public static final Block NITRIS_TRAPDOOR = registerBlock("nitris_trapdoor",
            new ModTrapdoorBlock(FabricBlockSettings.of(Material.WOOD).strength(2f)
                    .sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES)
                    .nonOpaque()
            ), ModItemGroup.MORE_WEAPONRY);

    public static final Block MARE_DIAMOND_BLOCK = registerBlock("mare_diamond_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3f)
                    .sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()
            ), ModItemGroup.MORE_WEAPONRY);

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

    public static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.BLOCK, new Identifier(MoreWeaponry.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        MoreWeaponry.LOGGER.info("Registering Mod Blocks for" + MoreWeaponry.MOD_ID);
    }



}
