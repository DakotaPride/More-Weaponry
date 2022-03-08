package net.DakotaPride.moreweaponry.screen;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class MoreWeaponryScreenHandlers {
    public static ScreenHandlerType<CoreForgeScreenHandler> CORE_FORGE_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(MoreWeaponry.MOD_ID, "orichalcum_blaster"),
                    CoreForgeScreenHandler::new);
}
