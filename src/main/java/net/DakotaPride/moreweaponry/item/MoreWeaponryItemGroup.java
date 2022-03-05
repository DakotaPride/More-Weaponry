package net.DakotaPride.moreweaponry.item;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class MoreWeaponryItemGroup {
    public static final ItemGroup MORE_WEAPONRY = FabricItemGroupBuilder.create(
                    new Identifier("moreweaponry", "more_weaponry"))
            .icon(() -> new ItemStack(MoreWeaponryItems.HEATED_CIRTICT_BATTLEAXE))
            .appendItems(stacks -> {

                // Moon Stone
                stacks.add(new ItemStack(MoreWeaponryItems.MOON_STONE_DUST));
                stacks.add(new ItemStack(MoreWeaponryItems.REFINED_MOON_STONE));
                stacks.add(new ItemStack(MoreWeaponryBlocks.MOON_STONE_DUST_BLOCK));
                stacks.add(new ItemStack(MoreWeaponryItems.MOON_STONE_SWORD));
                stacks.add(new ItemStack(MoreWeaponryItems.MOON_STONE_PICKAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.MOON_STONE_AXE));
                stacks.add(new ItemStack(MoreWeaponryItems.MOON_STONE_SHOVEL));
                stacks.add(new ItemStack(MoreWeaponryItems.MOON_STONE_HOE));
                stacks.add(new ItemStack(MoreWeaponryItems.REFINED_MOON_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.MOON_STONE_BATTLEAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.MOON_STONE_SHIELD));
                stacks.add(new ItemStack(MoreWeaponryItems.MOON_STONE_HELMET));
                stacks.add(new ItemStack(MoreWeaponryItems.MOON_STONE_CHESTPLATE));
                stacks.add(new ItemStack(MoreWeaponryItems.MOON_STONE_LEGGINGS));
                stacks.add(new ItemStack(MoreWeaponryItems.MOON_STONE_BOOTS));

                // Glimmering Amethyst
                stacks.add(new ItemStack(MoreWeaponryItems.BLASTED_AMETHYST));
                stacks.add(new ItemStack(MoreWeaponryItems.GLIMMERING_AMETHYST));
                stacks.add(new ItemStack(MoreWeaponryBlocks.GLIMMERING_AMETHYST_BLOCK));
                stacks.add(new ItemStack(MoreWeaponryItems.GLIMMERING_SWORD));
                stacks.add(new ItemStack(MoreWeaponryItems.GLIMMERING_PICKAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.GLIMMERING_AXE));
                stacks.add(new ItemStack(MoreWeaponryItems.GLIMMERING_SHOVEL));
                stacks.add(new ItemStack(MoreWeaponryItems.GLIMMERING_HOE));
                stacks.add(new ItemStack(MoreWeaponryItems.GLIMMERED_AMETHYST_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.GLIMMERING_BATTLEAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.GLIMMERING_SHIELD));
                stacks.add(new ItemStack(MoreWeaponryItems.GLIMMERING_HELMET));
                stacks.add(new ItemStack(MoreWeaponryItems.GLIMMERING_CHESTPLATE));
                stacks.add(new ItemStack(MoreWeaponryItems.GLIMMERING_LEGGINGS));
                stacks.add(new ItemStack(MoreWeaponryItems.GLIMMERING_BOOTS));

                // Blackstone Metal
                stacks.add(new ItemStack(MoreWeaponryItems.BLACKSTONE_INGOT));
                stacks.add(new ItemStack(MoreWeaponryBlocks.BLACKSTONE_METAL_BLOCK));
                stacks.add(new ItemStack(MoreWeaponryItems.BLACKSTONE_METAL_SWORD));
                stacks.add(new ItemStack(MoreWeaponryItems.BLACKSTONE_METAL_PICKAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.BLACKSTONE_METAL_AXE));
                stacks.add(new ItemStack(MoreWeaponryItems.BLACKSTONE_METAL_SHOVEL));
                stacks.add(new ItemStack(MoreWeaponryItems.BLACKSTONE_METAL_HOE));
                stacks.add(new ItemStack(MoreWeaponryItems.BLACKSTONE_METAL_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.BLACKSTONE_METAL_BATTLEAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.BLACKSTONE_METAL_SHIELD));
                stacks.add(new ItemStack(MoreWeaponryItems.BLACKSTONE_METAL_HELMET));
                stacks.add(new ItemStack(MoreWeaponryItems.BLACKSTONE_METAL_CHESTPLATE));
                stacks.add(new ItemStack(MoreWeaponryItems.BLACKSTONE_METAL_LEGGINGS));
                stacks.add(new ItemStack(MoreWeaponryItems.BLACKSTONE_METAL_BOOTS));

                // Guardian Scale
                stacks.add(new ItemStack(MoreWeaponryItems.GUARDIAN_SCALE));
                stacks.add(new ItemStack(MoreWeaponryItems.GUARDIAN_SCALE_SWORD));
                stacks.add(new ItemStack(MoreWeaponryItems.GUARDIAN_SCALE_PICKAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.GUARDIAN_SCALE_AXE));
                stacks.add(new ItemStack(MoreWeaponryItems.GUARDIAN_SCALE_SHOVEL));
                stacks.add(new ItemStack(MoreWeaponryItems.GUARDIAN_SCALE_HOE));
                stacks.add(new ItemStack(MoreWeaponryItems.GUARDIAN_SCALE_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.GUARDIAN_SCALE_BATTLEAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.GUARDIAN_SCALE_SHIELD));
                stacks.add(new ItemStack(MoreWeaponryItems.GUARDIAN_SCALE_HELMET));
                stacks.add(new ItemStack(MoreWeaponryItems.GUARDIAN_SCALE_CHESTPLATE));
                stacks.add(new ItemStack(MoreWeaponryItems.GUARDIAN_SCALE_LEGGINGS));
                stacks.add(new ItemStack(MoreWeaponryItems.GUARDIAN_SCALE_BOOTS));

                // Elder Guardian Scale
                stacks.add(new ItemStack(MoreWeaponryItems.ELDER_GUARDIAN_SCALE));
                stacks.add(new ItemStack(MoreWeaponryItems.ELDER_GUARDIANS_EYE));
                stacks.add(new ItemStack(MoreWeaponryItems.ELDER_GUARDIAN_SCALE_SWORD));
                stacks.add(new ItemStack(MoreWeaponryItems.ELDER_GUARDIAN_SCALE_PICKAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.ELDER_GUARDIAN_SCALE_AXE));
                stacks.add(new ItemStack(MoreWeaponryItems.ELDER_GUARDIAN_SCALE_SHOVEL));
                stacks.add(new ItemStack(MoreWeaponryItems.ELDER_GUARDIAN_SCALE_HOE));
                stacks.add(new ItemStack(MoreWeaponryItems.ELDER_GUARDIAN_SCALE_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.ELDER_GUARDIAN_SCALE_BATTLEAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.ELDER_SCALE_SHIELD));
                stacks.add(new ItemStack(MoreWeaponryItems.ELDER_SCALE_ARTIFACT));
                stacks.add(new ItemStack(MoreWeaponryItems.ELDER_GUARDIAN_SCALE_HELMET));
                stacks.add(new ItemStack(MoreWeaponryItems.ELDER_GUARDIAN_SCALE_CHESTPLATE));
                stacks.add(new ItemStack(MoreWeaponryItems.ELDER_GUARDIAN_SCALE_LEGGINGS));
                stacks.add(new ItemStack(MoreWeaponryItems.ELDER_GUARDIAN_SCALE_BOOTS));

                // Cirtict
                stacks.add(new ItemStack(MoreWeaponryItems.CIRTICT_SCRAP));
                stacks.add(new ItemStack(MoreWeaponryItems.CIRTICT_INGOT));
                stacks.add(new ItemStack(MoreWeaponryItems.CIRTICT_NUGGET));
                stacks.add(new ItemStack(MoreWeaponryBlocks.CIRTICT_DEBRIS));
                stacks.add(new ItemStack(MoreWeaponryBlocks.CIRTICT_BLOCK));
                stacks.add(new ItemStack(MoreWeaponryItems.CIRTICT_SWORD));
                stacks.add(new ItemStack(MoreWeaponryItems.CIRTICT_PICKAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.CIRTICT_AXE));
                stacks.add(new ItemStack(MoreWeaponryItems.CIRTICT_SHOVEL));
                stacks.add(new ItemStack(MoreWeaponryItems.CIRTICT_HOE));
                stacks.add(new ItemStack(MoreWeaponryItems.CIRTICT_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.CIRTICT_BATTLEAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.CIRTICT_SHIELD));

                // Heated Cirtict
                stacks.add(new ItemStack(MoreWeaponryItems.HEATED_CIRTICT_INGOT));
                stacks.add(new ItemStack(MoreWeaponryItems.HEATED_CIRTICT_NUGGET));
                stacks.add(new ItemStack(MoreWeaponryItems.HEATED_CIRTICT_SWORD));
                stacks.add(new ItemStack(MoreWeaponryItems.HEATED_CIRTICT_PICKAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.HEATED_CIRTICT_AXE));
                stacks.add(new ItemStack(MoreWeaponryItems.HEATED_CIRTICT_SHOVEL));
                stacks.add(new ItemStack(MoreWeaponryItems.HEATED_CIRTICT_HOE));
                stacks.add(new ItemStack(MoreWeaponryItems.HEATED_CIRTICT_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.HEATED_CIRTICT_BATTLEAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.HEATED_CIRTICT_SHIELD));

                // Cooled Cirtict
                stacks.add(new ItemStack(MoreWeaponryItems.COOLED_CIRTICT_INGOT));
                stacks.add(new ItemStack(MoreWeaponryItems.COOLED_CIRTICT_NUGGET));
                stacks.add(new ItemStack(MoreWeaponryItems.COOLED_CIRTICT_SWORD));
                stacks.add(new ItemStack(MoreWeaponryItems.COOLED_CIRTICT_PICKAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.COOLED_CIRTICT_AXE));
                stacks.add(new ItemStack(MoreWeaponryItems.COOLED_CIRTICT_SHOVEL));
                stacks.add(new ItemStack(MoreWeaponryItems.COOLED_CIRTICT_HOE));
                stacks.add(new ItemStack(MoreWeaponryItems.COOLED_CIRTICT_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.COOLED_CIRTICT_BATTLEAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.COOLED_CIRTICT_SHIELD));

                // Essence Cirtict
                stacks.add(new ItemStack(MoreWeaponryItems.ESSENCE_CIRTICT_SWORD));
                stacks.add(new ItemStack(MoreWeaponryItems.ESSENCE_CIRTICT_PICKAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.ESSENCE_CIRTICT_AXE));
                stacks.add(new ItemStack(MoreWeaponryItems.ESSENCE_CIRTICT_SHOVEL));
                stacks.add(new ItemStack(MoreWeaponryItems.ESSENCE_CIRTICT_HOE));
                stacks.add(new ItemStack(MoreWeaponryItems.ESSENCE_CIRTICT_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.ESSENCE_CIRTICT_BATTLEAXE));

                // Maiden Essence Cirtict
                stacks.add(new ItemStack(MoreWeaponryItems.MAIDEN_ESSENCE_CIRTICT_SWORD));
                stacks.add(new ItemStack(MoreWeaponryItems.MAIDEN_ESSENCE_CIRTICT_PICKAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.MAIDEN_ESSENCE_CIRTICT_AXE));
                stacks.add(new ItemStack(MoreWeaponryItems.MAIDEN_ESSENCE_CIRTICT_SHOVEL));
                stacks.add(new ItemStack(MoreWeaponryItems.MAIDEN_ESSENCE_CIRTICT_HOE));
                stacks.add(new ItemStack(MoreWeaponryItems.MAIDEN_ESSENCE_CIRTICT_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.MAIDEN_ESSENCE_CIRTICT_BATTLEAXE));

                // Watcher Essence Cirtict
                stacks.add(new ItemStack(MoreWeaponryItems.WATCHER_ESSENCE_CIRTICT_SWORD));
                stacks.add(new ItemStack(MoreWeaponryItems.WATCHER_ESSENCE_CIRTICT_PICKAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.WATCHER_ESSENCE_CIRTICT_AXE));
                stacks.add(new ItemStack(MoreWeaponryItems.WATCHER_ESSENCE_CIRTICT_SHOVEL));
                stacks.add(new ItemStack(MoreWeaponryItems.WATCHER_ESSENCE_CIRTICT_HOE));
                stacks.add(new ItemStack(MoreWeaponryItems.WATCHER_ESSENCE_CIRTICT_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.WATCHER_ESSENCE_CIRTICT_BATTLEAXE));

                // Suppressed Essence Cirtict
                stacks.add(new ItemStack(MoreWeaponryItems.SUPPRESSED_ESSENCE_CIRTICT_SWORD));
                stacks.add(new ItemStack(MoreWeaponryItems.SUPPRESSED_ESSENCE_CIRTICT_PICKAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.SUPPRESSED_ESSENCE_CIRTICT_AXE));
                stacks.add(new ItemStack(MoreWeaponryItems.SUPPRESSED_ESSENCE_CIRTICT_SHOVEL));
                stacks.add(new ItemStack(MoreWeaponryItems.SUPPRESSED_ESSENCE_CIRTICT_HOE));
                stacks.add(new ItemStack(MoreWeaponryItems.SUPPRESSED_ESSENCE_CIRTICT_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.SUPPRESSED_ESSENCE_CIRTICT_BATTLEAXE));

                // Plagued Essence Cirtict
                stacks.add(new ItemStack(MoreWeaponryItems.PLAGUED_ESSENCE_CIRTICT_SWORD));
                stacks.add(new ItemStack(MoreWeaponryItems.PLAGUED_ESSENCE_CIRTICT_PICKAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.PLAGUED_ESSENCE_CIRTICT_AXE));
                stacks.add(new ItemStack(MoreWeaponryItems.PLAGUED_ESSENCE_CIRTICT_SHOVEL));
                stacks.add(new ItemStack(MoreWeaponryItems.PLAGUED_ESSENCE_CIRTICT_HOE));
                stacks.add(new ItemStack(MoreWeaponryItems.PLAGUED_ESSENCE_CIRTICT_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.PLAGUED_ESSENCE_CIRTICT_BATTLEAXE));

                // Watcher Stuff
                stacks.add(new ItemStack(MoreWeaponryItems.WATCHER_HELMET));
                stacks.add(new ItemStack(MoreWeaponryItems.WATCHER_CHESTPLATE));
                stacks.add(new ItemStack(MoreWeaponryItems.WATCHER_STAFF));

                // Maiden Stuff
                stacks.add(new ItemStack(MoreWeaponryItems.REINFORCED_BONE));
                stacks.add(new ItemStack(MoreWeaponryItems.MAIDEN_STEM));
                stacks.add(new ItemStack(MoreWeaponryItems.MAIDENS_STEM_BOW));

                // Mob Cores
                stacks.add(new ItemStack(MoreWeaponryItems.MAIDEN_CORE));
                stacks.add(new ItemStack(MoreWeaponryItems.POWERED_MAIDEN_MOB_CORE));
                stacks.add(new ItemStack(MoreWeaponryItems.WRETCHED_CORE));
                stacks.add(new ItemStack(MoreWeaponryItems.POWERED_WRETCHED_MOB_CORE));
                stacks.add(new ItemStack(MoreWeaponryItems.WATCHER_CORE));
                stacks.add(new ItemStack(MoreWeaponryItems.POWERED_WATCHER_MOB_CORE));
                stacks.add(new ItemStack(MoreWeaponryItems.SUPPRESSED_CORE));
                stacks.add(new ItemStack(MoreWeaponryItems.POWERED_SUPPRESSED_MOB_CORE));
                stacks.add(new ItemStack(MoreWeaponryItems.PLAGUED_CORE));
                stacks.add(new ItemStack(MoreWeaponryItems.POWERED_PLAGUED_MOB_CORE));

                stacks.add(new ItemStack(MoreWeaponryItems.MOB_CORE));
                stacks.add(new ItemStack(MoreWeaponryItems.CHARGED_MOB_CORE));

                // Essence
                stacks.add(new ItemStack(MoreWeaponryBlocks.PACKED_WATCHER_CLOTH_BLOCK));
                stacks.add(new ItemStack(MoreWeaponryItems.EXPLOSIVE_ESSENCE));
                stacks.add(new ItemStack(MoreWeaponryItems.LEECHING_ESSENCE));
                stacks.add(new ItemStack(MoreWeaponryItems.MELODIC_ESSENCE));
                stacks.add(new ItemStack(MoreWeaponryItems.PHANTOM_ESSENCE));
                stacks.add(new ItemStack(MoreWeaponryItems.WITHER_ESSENCE));
                stacks.add(new ItemStack(MoreWeaponryItems.WRETCHED_ESSENCE));
                stacks.add(new ItemStack(MoreWeaponryItems.WATCHER_CLOTH));

                // Frodon Wood
                stacks.add(new ItemStack(MoreWeaponryItems.FRODON_BOWL));
                stacks.add(new ItemStack(MoreWeaponryItems.FRODON_SIGN));
                stacks.add(new ItemStack(MoreWeaponryBlocks.FRODON_DOOR));
                stacks.add(new ItemStack(MoreWeaponryBlocks.FRODON_BUTTON));
                stacks.add(new ItemStack(MoreWeaponryBlocks.FRODON_LEAVES));
                stacks.add(new ItemStack(MoreWeaponryBlocks.FRODON_PLANKS));
                stacks.add(new ItemStack(MoreWeaponryBlocks.FRODON_SAPLING));
                stacks.add(new ItemStack(MoreWeaponryBlocks.FRODON_FENCE));
                stacks.add(new ItemStack(MoreWeaponryBlocks.FRODON_FENCE_GATE));
                stacks.add(new ItemStack(MoreWeaponryBlocks.FRODON_LOG));
                stacks.add(new ItemStack(MoreWeaponryBlocks.FRODON_WOOD));
                stacks.add(new ItemStack(MoreWeaponryBlocks.STRIPPED_FRODON_LOG));
                stacks.add(new ItemStack(MoreWeaponryBlocks.STRIPPED_FRODON_WOOD));
                stacks.add(new ItemStack(MoreWeaponryBlocks.FRODON_PRESSURE_PLATE));
                stacks.add(new ItemStack(MoreWeaponryBlocks.FRODON_SLAB));
                stacks.add(new ItemStack(MoreWeaponryBlocks.FRODON_STAIRS));
                stacks.add(new ItemStack(MoreWeaponryBlocks.FRODON_TRAPDOOR));

                // Bluestone
                stacks.add(new ItemStack(MoreWeaponryItems.BLUESTONE_IGNITOR));
                stacks.add(new ItemStack(MoreWeaponryItems.BLUESTONE_ROCK));
                stacks.add(new ItemStack(MoreWeaponryBlocks.BLUESTONE));
                stacks.add(new ItemStack(MoreWeaponryBlocks.BLUESTONE_SLAB));
                stacks.add(new ItemStack(MoreWeaponryBlocks.BLUESTONE_STAIRS));
                stacks.add(new ItemStack(MoreWeaponryBlocks.BLUESTONE_WALL));
                stacks.add(new ItemStack(MoreWeaponryBlocks.COBBLED_BLUESTONE));
                stacks.add(new ItemStack(MoreWeaponryBlocks.COBBLED_BLUESTONE_SLAB));
                stacks.add(new ItemStack(MoreWeaponryBlocks.COBBLED_BLUESTONE_STAIRS));
                stacks.add(new ItemStack(MoreWeaponryBlocks.COBBLED_BLUESTONE_WALL));

                // Limestone
                stacks.add(new ItemStack(MoreWeaponryBlocks.LIMESTONE));
                stacks.add(new ItemStack(MoreWeaponryBlocks.LIMESTONE_SLAB));
                stacks.add(new ItemStack(MoreWeaponryBlocks.LIMESTONE_STAIRS));
                stacks.add(new ItemStack(MoreWeaponryBlocks.LIMESTONE_WALL));
                stacks.add(new ItemStack(MoreWeaponryBlocks.LIMESTONE_BUTTON));
                stacks.add(new ItemStack(MoreWeaponryBlocks.LIMESTONE_PRESSURE_PLATE));
                stacks.add(new ItemStack(MoreWeaponryBlocks.COBBLED_LIMESTONE));
                stacks.add(new ItemStack(MoreWeaponryBlocks.COBBLED_LIMESTONE_SLAB));
                stacks.add(new ItemStack(MoreWeaponryBlocks.COBBLED_LIMESTONE_STAIRS));
                stacks.add(new ItemStack(MoreWeaponryBlocks.COBBLED_LIMESTONE_WALL));
                stacks.add(new ItemStack(MoreWeaponryBlocks.COBBLED_LIMESTONE_BUTTON));
                stacks.add(new ItemStack(MoreWeaponryBlocks.COBBLED_LIMESTONE_PRESSURE_PLATE));

                // Handles
                stacks.add(new ItemStack(MoreWeaponryItems.HANDLE));
                stacks.add(new ItemStack(MoreWeaponryItems.AMETHYST_HANDLE));
                stacks.add(new ItemStack(MoreWeaponryItems.ENDICATE_HANDLE));
                stacks.add(new ItemStack(MoreWeaponryItems.NETHERITE_HANDLE));
                stacks.add(new ItemStack(MoreWeaponryItems.PRISMARINE_HANDLE));
                stacks.add(new ItemStack(MoreWeaponryItems.WITHERING_HANDLE));

                // Kuro And Night Curon
                stacks.add(new ItemStack(MoreWeaponryItems.KURO));
                stacks.add(new ItemStack(MoreWeaponryItems.KURO_BREAD));
                stacks.add(new ItemStack(MoreWeaponryItems.KURO_SEEDS));
                stacks.add(new ItemStack(MoreWeaponryItems.CRUSHED_KURO));
                stacks.add(new ItemStack(MoreWeaponryBlocks.KURO_WHEAT_BLOCK));

                stacks.add(new ItemStack(MoreWeaponryBlocks.NIGHT_CURON));
                stacks.add(new ItemStack(MoreWeaponryItems.CURON_FLOWER_PETALS));
                stacks.add(new ItemStack(MoreWeaponryItems.CURON_BREW));

                // Mare Diamond
                stacks.add(new ItemStack(MoreWeaponryItems.MARE_DIAMOND));
                stacks.add(new ItemStack(MoreWeaponryBlocks.MARE_DIAMOND_ORE));
                stacks.add(new ItemStack(MoreWeaponryBlocks.DEEPSLATE_MARE_DIAMOND_ORE));
                stacks.add(new ItemStack(MoreWeaponryBlocks.MARE_DIAMOND_BLOCK));

                // Cobblestone+
                stacks.add(new ItemStack(MoreWeaponryBlocks.COBBLESTONE_BUTTON));
                stacks.add(new ItemStack(MoreWeaponryBlocks.COBBLESTONE_PRESSURE_PLATE));

                // Makeshift Block Entities
                stacks.add(new ItemStack(MoreWeaponryBlocks.CROP_CUTTER_BLOCK));
                stacks.add(new ItemStack(MoreWeaponryBlocks.ESSENCE_TRANSLATOR));
                stacks.add(new ItemStack(MoreWeaponryBlocks.CORE_FORGE));

                // Dripstone+
                stacks.add(new ItemStack(MoreWeaponryBlocks.CRACKED_DRIPSTONE_BLOCK));
                stacks.add(new ItemStack(MoreWeaponryBlocks.INFESTED_CRACKED_DRIPSTONE_BLOCK));
                stacks.add(new ItemStack(MoreWeaponryBlocks.INFESTED_DRIPSTONE_BLOCK));

                // Sandstone Dust
                stacks.add(new ItemStack(MoreWeaponryBlocks.SANDSTONE_DUST_BLOCK));
                stacks.add(new ItemStack(MoreWeaponryItems.SANDSTONE_DUST));

                // Peplex Nylium
                stacks.add(new ItemStack(MoreWeaponryBlocks.PEPLEX_NYLIUM));

                // Intoxicated
                stacks.add(new ItemStack(MoreWeaponryBlocks.INTOXICATED_DANDELION));
                stacks.add(new ItemStack(MoreWeaponryBlocks.INTOXICATED_POPPY));
                stacks.add(new ItemStack(MoreWeaponryBlocks.INTOXICATED_FERN));
                stacks.add(new ItemStack(MoreWeaponryBlocks.INTOXICATED_LARGE_FERN));
                stacks.add(new ItemStack(MoreWeaponryBlocks.INTOXICATED_GRASS));
                stacks.add(new ItemStack(MoreWeaponryBlocks.INTOXICATED_TALL_GRASS));
                stacks.add(new ItemStack(MoreWeaponryBlocks.INTOXICATED_GRASS_BLOCK));
                stacks.add(new ItemStack(MoreWeaponryBlocks.INTOXICATED_STONE));

                // Suppressed Explosion
                stacks.add(new ItemStack(MoreWeaponryBlocks.SUPPRESSED_EXPLOSION));

                // Nether+
                stacks.add(new ItemStack(MoreWeaponryItems.WITHER_BONE));
                stacks.add(new ItemStack(MoreWeaponryItems.WITHER_BONE_MEAL));
                stacks.add(new ItemStack(MoreWeaponryItems.NETHERITE_NUGGET));
                stacks.add(new ItemStack(MoreWeaponryItems.WITHER_BROAD_HAMMER_HEAD));
                stacks.add(new ItemStack(MoreWeaponryItems.WITHER_BROAD_HAMMER));

                // Armor Addons
                stacks.add(new ItemStack(MoreWeaponryItems.PHANTOM_SCALE));
                stacks.add(new ItemStack(MoreWeaponryItems.PHANTOM_HELMET));
                stacks.add(new ItemStack(MoreWeaponryItems.SHULKER_SHELL_BOOTS));

                // Battleaxes
                stacks.add(new ItemStack(MoreWeaponryItems.WOODEN_BATTLEAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.STONE_BATTLEAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.IRON_BATTLEAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.GOLDEN_BATTLEAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.DIAMOND_BATTLEAXE));
                stacks.add(new ItemStack(MoreWeaponryItems.NETHERITE_BATTLEAXE));

                // Knives
                stacks.add(new ItemStack(MoreWeaponryItems.WOODEN_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.STONE_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.IRON_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.GOLDEN_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.DIAMOND_KNIFE));
                stacks.add(new ItemStack(MoreWeaponryItems.NETHERITE_KNIFE));

                // Warden's Step Disc
                stacks.add(new ItemStack(MoreWeaponryItems.WARDENS_STEP_MUSIC_DISC));

                // Endicate Staff
                stacks.add(new ItemStack(MoreWeaponryItems.ENDICATE_STAFF));

            })
            .build();
}
