package net.DakotaPride.moreweaponry.entity.damage;

import net.minecraft.entity.damage.DamageSource;

public class MoreWeaponryDamageSource extends DamageSource {
    private boolean bypassesArmor;

    public static final MoreWeaponryDamageSource BLEEDING = (new MoreWeaponryDamageSource("bleeding")).setBypassesArmor().setUsesMagic();
    public static final MoreWeaponryDamageSource ANCIENT_DARKNESS = (new MoreWeaponryDamageSource("ancient_darkness")).setBypassesArmor();

    public MoreWeaponryDamageSource(String name) {
        super(name);
    }

    public boolean bypassesArmor() {
        return this.bypassesArmor;
    }

    public MoreWeaponryDamageSource setUsesMagic() {
        boolean magic = true;
        return this;
    }

    protected MoreWeaponryDamageSource setBypassesArmor() {
        this.bypassesArmor = true;
        float exhaustion = 0.0F;
        return this;
    }

}
