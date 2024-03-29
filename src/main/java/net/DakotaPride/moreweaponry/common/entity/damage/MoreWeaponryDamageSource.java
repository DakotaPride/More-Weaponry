package net.DakotaPride.moreweaponry.common.entity.damage;

import net.minecraft.entity.damage.DamageSource;

public class MoreWeaponryDamageSource extends DamageSource {
    private boolean bypassesArmor;
    private boolean unblockable;
    private float exhaustion = 0.1F;

    public static final MoreWeaponryDamageSource BLEEDING = (new MoreWeaponryDamageSource("bleeding")).setBypassesArmor().setUnblockable();
    public static final MoreWeaponryDamageSource ANCIENT_DARKNESS = (new MoreWeaponryDamageSource("ancient_darkness")).setBypassesArmor();
    public static final MoreWeaponryDamageSource CELESTIALITE = (new MoreWeaponryDamageSource("celestialite")).setBypassesArmor().setUnblockable();

    public MoreWeaponryDamageSource(String name) {
        super(name);
    }

    public MoreWeaponryDamageSource setUsesMagic() {
        boolean magic = true;
        return this;
    }

    public MoreWeaponryDamageSource setUnblockable() {
        this.unblockable = true;

        this.exhaustion = 0.0F;
        return this;
    }

    public MoreWeaponryDamageSource setBypassesArmor() {
        this.bypassesArmor = true;
        float exhaustion = 0.0F;
        return this;
    }

    @Override
    public float getExhaustion() {
        return exhaustion;
    }

    @Override
    public boolean isUnblockable() {
        return unblockable;
    }

    public boolean bypassesArmor() {
        return bypassesArmor;
    }
}
