package net.DakotaPride.moreweaponry.effect;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.effect.status_effects.NumbedStatusEffect;
import net.DakotaPride.moreweaponry.effect.status_effects.celestial.*;
import net.DakotaPride.moreweaponry.effect.status_effects.unfortuned.SirenStatusEffect;
import net.DakotaPride.moreweaponry.effect.status_effects.unfortuned.TickedStatusEffect;
import net.DakotaPride.moreweaponry.effect.status_effects.unfortuned.WebbedStatusEffect;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreWeaponryEffects {


    // Celestial Effects

    public static final StatusEffect BARD = new BardStatusEffect(StatusEffectCategory.BENEFICIAL, 0xF4F4F4)
            .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC",
                    12.0D, EntityAttributeModifier.Operation.ADDITION);
    public static final StatusEffect SICKENED = new SickenedStatusEffect(StatusEffectCategory.BENEFICIAL, 0x42773B)
            .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC",
                    8.0D, EntityAttributeModifier.Operation.ADDITION);
    public static final StatusEffect CRACKLER = new CracklerStatusEffect(StatusEffectCategory.BENEFICIAL, 0xBDEAB2)
            .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC",
                    10.0D, EntityAttributeModifier.Operation.ADDITION);
    public static final StatusEffect WANDERER = new WandererStatusEffect(StatusEffectCategory.BENEFICIAL, 0x4C4138)
            .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC",
                    14.0D, EntityAttributeModifier.Operation.ADDITION);
    public static final StatusEffect WATCHER = new WatcherStatusEffect(StatusEffectCategory.BENEFICIAL, 0x3D0051)
            .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC",
                    16.0D, EntityAttributeModifier.Operation.ADDITION);


    // Unfortuned Effects

    public static final StatusEffect TICKED = new TickedStatusEffect(StatusEffectCategory.HARMFUL, 0x3D0051)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635",
                    -0.7D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3",
                    -0.8D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
    public static final StatusEffect WEBBED = new WebbedStatusEffect(StatusEffectCategory.HARMFUL, 0x4C4138)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635",
                    -0.6D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3",
                    -0.7D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
    public static final StatusEffect SIREN = new SirenStatusEffect(StatusEffectCategory.HARMFUL, 0xF4F4F4)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635",
                    -0.5D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3",
                    -0.6D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
    public static final StatusEffect EXPLOSIVE = new SirenStatusEffect(StatusEffectCategory.HARMFUL, 0xBDEAB2)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635",
                    -0.4D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3",
                    -0.5D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
    public static final StatusEffect PLAGUED = new SirenStatusEffect(StatusEffectCategory.HARMFUL, 0x42773B)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635",
                    -0.3D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3",
                    -0.4D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);


    // Misc

    public static final StatusEffect NUMBED = new NumbedStatusEffect(StatusEffectCategory.NEUTRAL, 0x1F1F1F)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3",
                    -1.0D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);


    public static void registerEffects() {

        // Celestial Effects

        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreWeaponry.MOD_ID, "bard"), BARD);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreWeaponry.MOD_ID, "sickened"), SICKENED);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreWeaponry.MOD_ID, "crackler"), CRACKLER);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreWeaponry.MOD_ID, "wanderer"), WANDERER);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreWeaponry.MOD_ID, "watcher"), WATCHER);


        // Unfortuned Effects

        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreWeaponry.MOD_ID, "ticked"), TICKED);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreWeaponry.MOD_ID, "webbed"), WEBBED);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreWeaponry.MOD_ID, "siren"), SIREN);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreWeaponry.MOD_ID, "explosive"), EXPLOSIVE);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreWeaponry.MOD_ID, "plagued"), PLAGUED);


        // Misc

        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreWeaponry.MOD_ID, "numbed"), NUMBED);

    }

}
