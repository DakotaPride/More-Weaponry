package net.DakotaPride.moreweaponry.particle;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreWeaponryParticles {
    public static final DefaultParticleType CELESTIAL_MEDALLION_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(MoreWeaponry.MOD_ID, "celestial_medallion_particle"),
                CELESTIAL_MEDALLION_PARTICLE);
    }
}
