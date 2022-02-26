package net.DakotaPride.moreweaponry.util;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

import static net.DakotaPride.moreweaponry.util.ModTags.Blocks.*;
import static net.DakotaPride.moreweaponry.util.ModTags.Items.*;

public class ModTags {

    public static void registerBlockTags() {
        Tag.Identified<Block> sand_replaceable = SAND_REPLACEABLE_OVERWORLD;
        Tag.Identified<Block> dripstone_replaceable = DRIPSTONE_REPLACEABLE_OVERWORLD;
        Tag.Identified<Block> peplex_replaceable = PEPLEX_REPLACEABLE;
    }

    public static void registerItemTags() {
        Tag.Identified<Item> battleaxes = BATTLEAXES;
        Tag.Identified<Item> essence = ESSENCE;
        Tag.Identified<Item> handles = HANDLES;
        Tag.Identified<Item> rapiers = RAPIERS;
        Tag.Identified<Item> shields = SHIELDS;
        Tag.Identified<Item> bluestone = BLUESTONE;
        Tag.Identified<Item> cobbled_bluestone = COBBLED_BLUESTONE;
        Tag.Identified<Item> cobbled_limestone = COBBLED_LIMESTONE;
    }

    public static class Blocks {
        public static final Tag.Identified<Block> SAND_REPLACEABLE_OVERWORLD =
                createTag("sand_repleacable_overworld");
        public static final Tag.Identified<Block> DRIPSTONE_REPLACEABLE_OVERWORLD =
                createTag("dripstone_replaceable_overworld");
        public static final Tag.Identified<Block> PEPLEX_REPLACEABLE =
                createTag("peplex_replaceable");

        private static Tag.Identified<Block> createTag(String name) {
            return TagFactory.BLOCK.create(new Identifier(MoreWeaponry.MOD_ID, name));
        }

        private static Tag.Identified<Block> createCommonTag(String name) {
            return TagFactory.BLOCK.create(new Identifier("c", name));
        }
    }

    public static class Items {
        public static final Tag.Identified<Item> BATTLEAXES = createCommonTag("battleaxes");
        public static final Tag.Identified<Item> ESSENCE = createCommonTag("essence");
        public static final Tag.Identified<Item> HANDLES = createCommonTag("handles");
        public static final Tag.Identified<Item> RAPIERS = createCommonTag("rapiers");
        public static final Tag.Identified<Item> SHIELDS = createCommonTag("shields");
        public static final Tag.Identified<Item> BLUESTONE = createCommonTag("bluestone");
        public static final Tag.Identified<Item> COBBLED_BLUESTONE = createCommonTag("cobbled_bluestone");
        public static final Tag.Identified<Item> COBBLED_LIMESTONE = createCommonTag("cobbled_limestone");


        private static Tag.Identified<Item> createTag(String name) {
            return TagFactory.ITEM.create(new Identifier(MoreWeaponry.MOD_ID, name));
        }

        private static Tag.Identified<Item> createCommonTag(String name) {
            return TagFactory.ITEM.create(new Identifier("c", name));
        }
    }

}
