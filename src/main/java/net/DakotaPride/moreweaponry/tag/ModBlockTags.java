package net.DakotaPride.moreweaponry.tag;

import net.minecraft.block.Block;
import net.minecraft.tag.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.List;

public class ModBlockTags {
    public static final Tag.Identified<Block> SAND_REPLACEABLE_OVERWORLD = ModBlockTags.register("sand_repleacable_overworld");
    public static final Tag.Identified<Block> DRIPSTONE_REPLACEABLE_OVERWORLD = ModBlockTags.register("dripstone_replaceable_overworld");


    private ModBlockTags() {
    }

    private static Tag.Identified<Block> register(String id) {
        return new Tag.Identified<Block>() {
            @Override
            public Identifier getId() {
                return null;
            }

            @Override
            public boolean contains(Block entry) {
                return false;
            }

            @Override
            public List<Block> values() {
                return null;
            }
        };
    }



}
