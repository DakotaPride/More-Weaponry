package net.DakotaPride.moreweaponry.world.features;

import net.DakotaPride.moreweaponry.util.MoreWeaponryTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.*;

public class MoreWeaponryOreConfiguredFeatures extends OreConfiguredFeatures {

    public static final RuleTest SAND_REPLACEABLE_OVERWORLD = new TagMatchRuleTest(MoreWeaponryTags.Blocks.SAND_REPLACEABLE_OVERWORLD);
    public static final RuleTest DRIPSTONE_REPLACEABLE_OVERWORLD = new TagMatchRuleTest(MoreWeaponryTags.Blocks.DRIPSTONE_REPLACEABLE_OVERWORLD);
    public static final RuleTest PEPLEX_REPLACEABLE = new TagMatchRuleTest(MoreWeaponryTags.Blocks.PEPLEX_REPLACEABLE);




}
