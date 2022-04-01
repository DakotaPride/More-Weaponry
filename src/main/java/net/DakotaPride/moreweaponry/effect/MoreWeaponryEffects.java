package net.DakotaPride.moreweaponry.effect;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.DakotaPride.moreweaponry.effect.status_effects.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreWeaponryEffects {

    public static final StatusEffect BARD = new BardStatusEffect(StatusEffectCategory.BENEFICIAL, 0xF4F4F4);
    public static final StatusEffect SICKENED = new SickenedStatusEffect(StatusEffectCategory.BENEFICIAL, 0x42773B);
    public static final StatusEffect CRACKLER = new BardStatusEffect(StatusEffectCategory.BENEFICIAL, 0xBDEAB2);
    public static final StatusEffect WANDERER = new SickenedStatusEffect(StatusEffectCategory.BENEFICIAL, 0x4C4138);
    public static final StatusEffect WATCHER = new SickenedStatusEffect(StatusEffectCategory.BENEFICIAL, 0x3D0051);

    public static void registerEffects() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreWeaponry.MOD_ID, "bard"), BARD);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreWeaponry.MOD_ID, "sickened"), SICKENED);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreWeaponry.MOD_ID, "crackler"), CRACKLER);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreWeaponry.MOD_ID, "wanderer"), WANDERER);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MoreWeaponry.MOD_ID, "watcher"), WATCHER);
    }

}
