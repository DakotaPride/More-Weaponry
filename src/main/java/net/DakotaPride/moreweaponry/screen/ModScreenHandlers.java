package net.DakotaPride.moreweaponry.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.DakotaPride.moreweaponry.MoreWeaponry;

public class ModScreenHandlers {
    public static ScreenHandlerType<CropCutterScreenHandler> CROP_CUTTER_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(MoreWeaponry.MOD_ID, "crop_cutter_block"),
                    CropCutterScreenHandler::new);
}