package net.DakotaPride.moreweaponry.common.util;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import static net.DakotaPride.moreweaponry.common.util.MoreWeaponryTags.Blocks.*;
import static net.DakotaPride.moreweaponry.common.util.MoreWeaponryTags.Items.*;
import static net.DakotaPride.moreweaponry.common.util.MoreWeaponryTags.Biomes.*;

public class MoreWeaponryTags {

    public static void MoreWeaponryBlockTags() {
        TagKey<Block> sand_replaceable_overworld = SAND_REPLACEABLE_OVERWORLD;
        TagKey<Block> dripstone_replaceable = DRIPSTONE_REPLACEABLE_OVERWORLD;
        TagKey<Block> peplex_replaceable = PEPLEX_REPLACEABLE;
        TagKey<Block> intoxicated_plants = INTOXICATED_PLANTS;
        TagKey<Block> small_intoxicated_flowers = SMALL_INTOXICATED_FLOWERS;
    }

    public static void MoreWeaponryItemTags() {
        TagKey<Item> battleaxes = BATTLEAXES;
        TagKey<Item> essence = ESSENCE;
        TagKey<Item> handles = HANDLES;
        TagKey<Item> rapiers = RAPIERS;
        TagKey<Item> shields = SHIELDS;
        TagKey<Item> horns = HORNS;
    }

    public static void MoreWeaponryBiomeTags() {
        TagKey<Biome> night_curon_biomes = NIGHT_CURON;
        TagKey<Biome> sandstone_dust_biomes = SANDSTONE_DUST;
        TagKey<Biome> has_frodon_tress = FRODON_TREES;
    }

    public static class Blocks {
        public static final TagKey<Block> SAND_REPLACEABLE_OVERWORLD =
                createTag("sand_repleacable_overworld");
        public static final TagKey<Block> DRIPSTONE_REPLACEABLE_OVERWORLD =
                createTag("dripstone_replaceable_overworld");
        public static final TagKey<Block> PEPLEX_REPLACEABLE =
                createTag("peplex_replaceable");
        public static final TagKey<Block> INTOXICATED_PLANTS =
                createTag("intoxicated_plants");
        public static final TagKey<Block> SMALL_INTOXICATED_FLOWERS =
                createTag("small_intoxicated_flowers");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier(MoreWeaponry.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BATTLEAXES = createCommonTag("battleaxes");
        public static final TagKey<Item> ESSENCE = createCommonTag("essence");
        public static final TagKey<Item> HANDLES = createCommonTag("handles");
        public static final TagKey<Item> RAPIERS = createCommonTag("rapiers");
        public static final TagKey<Item> SHIELDS = createCommonTag("shields");
        public static final TagKey<Item> HORNS = createTag("horns");

        private static TagKey<Item> createCommonTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier("c", name));
        }

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier(MoreWeaponry.MOD_ID, name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> NIGHT_CURON = createTag("night_curon_biomes");
        public static final TagKey<Biome> SANDSTONE_DUST = createTag("sandstone_dust_biomes");
        public static final TagKey<Biome> FRODON_TREES = createTag("has_frodon_trees");

        private static TagKey<Biome> createTag(String name) {
            return TagKey.of(Registry.BIOME_KEY, new Identifier(MoreWeaponry.MOD_ID, name));
        }
    }

}
