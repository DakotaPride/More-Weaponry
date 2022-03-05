package net.DakotaPride.moreweaponry.sound;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreWeaponrySounds {

    public static SoundEvent WARDENS_STEP = registerSoundEvent("wardens_step");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(MoreWeaponry.MOD_ID, name);
                return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

}
