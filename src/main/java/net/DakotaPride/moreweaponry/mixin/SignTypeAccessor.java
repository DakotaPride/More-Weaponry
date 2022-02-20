package net.DakotaPride.moreweaponry.mixin;

import net.minecraft.util.SignType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

// GPL-3.0 License: https://github.com/nyuppo/fabric-sign-example by nyuppo
@Mixin(SignType.class)
public interface SignTypeAccessor {
    @Invoker("<init>")
    static SignType newSignType(String name) {
        throw new AssertionError();
    }

    @Invoker("register")
    static SignType registerNew(SignType type) {
        throw new AssertionError();
    }
}