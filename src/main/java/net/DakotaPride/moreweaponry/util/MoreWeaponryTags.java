package net.DakotaPride.moreweaponry.util;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreWeaponryTags {

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

        private static TagKey<Block> createCommonTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier("c", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BATTLEAXES = createCommonTag("battleaxes");
        public static final TagKey<Item> ESSENCE = createCommonTag("essence");
        public static final TagKey<Item> HANDLES = createCommonTag("handles");
        public static final TagKey<Item> RAPIERS = createCommonTag("rapiers");
        public static final TagKey<Item> SHIELDS = createCommonTag("shields");
        public static final TagKey<Item> BLUESTONE = createCommonTag("bluestone");
        public static final TagKey<Item> COBBLED_BLUESTONE = createCommonTag("cobbled_bluestone");
        public static final TagKey<Item> COBBLED_LIMESTONE = createCommonTag("cobbled_limestone");


        private static TagKey<Item> createTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier(MoreWeaponry.MOD_ID, name));
        }

        private static TagKey<Item> createCommonTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier("c", name));
        }

        private static class Identified<T> {
        }
    }

}
