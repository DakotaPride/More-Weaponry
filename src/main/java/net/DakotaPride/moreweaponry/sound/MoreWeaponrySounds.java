package net.DakotaPride.moreweaponry.sound;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreWeaponrySounds {

    public static SoundEvent WARDENS_STEP = registerSoundEvent("wardens_step");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(MoreWeaponry.MOD_ID, name);
                return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static final BlockSoundGroup SUMMONER = new BlockSoundGroup(1f, 1f,
            SoundEvents.ENTITY_ENDER_DRAGON_SHOOT, SoundEvents.BLOCK_STONE_STEP, SoundEvents.BLOCK_STONE_PLACE,
            SoundEvents.BLOCK_STONE_HIT, SoundEvents.BLOCK_STONE_FALL);

    public static final BlockSoundGroup SUMMONER_TWO = new BlockSoundGroup(1f, 1f,
            SoundEvents.ENTITY_ENDER_DRAGON_SHOOT, SoundEvents.BLOCK_GRASS_STEP, SoundEvents.BLOCK_GRASS_PLACE,
            SoundEvents.BLOCK_GRASS_HIT, SoundEvents.BLOCK_GRASS_FALL);

}
