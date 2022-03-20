package net.DakotaPride.moreweaponry.mixin;

import com.mojang.serialization.DataResult;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TagKey.class)
public abstract class NotATagHelper {
    @Inject(at=@At(value="INVOKE",target="com/mojang/serialization/DataResult.error (Ljava/lang/String;)Lcom/mojang/serialization/DataResult;"),method="method_40091")
    private static void NotATagHelper$onError(RegistryKey registryKey, String string, CallbackInfoReturnable<DataResult> cir) {
        System.out.println(string);
    }
}
