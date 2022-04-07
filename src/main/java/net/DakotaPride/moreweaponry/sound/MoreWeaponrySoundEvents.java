package net.DakotaPride.moreweaponry.sound;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreWeaponrySoundEvents {

    public static SoundEvent ENTITY_BURIED_KNIGHT_AMBIENT = registerSoundEvent("entity_buried_knight_ambient");
    public static SoundEvent ENTITY_BURIED_KNIGHT_DEATH = registerSoundEvent("entity_buried_knight_death");
    public static SoundEvent ENTITY_BURIED_KNIGHT_HURT = registerSoundEvent("entity_buried_knight_hurt");
    public static SoundEvent WARDENS_STEP = registerSoundEvent("wardens_step");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(MoreWeaponry.MOD_ID, name);
                return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static final BlockSoundGroup SUMMONER = new BlockSoundGroup(1f, 1f,
            SoundEvents.ENTITY_ENDER_DRAGON_SHOOT, SoundEvents.BLOCK_STONE_STEP, SoundEvents.BLOCK_STONE_PLACE,
            SoundEvents.BLOCK_STONE_HIT, SoundEvents.BLOCK_STONE_FALL);

}
