package net.DakotaPride.moreweaponry.painting;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreWeaponryPaintings {
    public static final PaintingMotive MASTERS = registerPainting("masters", new PaintingMotive(32, 32));
    public static final PaintingMotive WATCHER = registerPainting("watcher", new PaintingMotive(64, 64));

    private static PaintingMotive registerPainting(String name, PaintingMotive paintingMotive) {
        return Registry.register(Registry.PAINTING_MOTIVE, new Identifier(MoreWeaponry.MOD_ID, name), paintingMotive);
    }

    public static void registerMoreWeaponryPaintings() {
        System.out.println("Registering Paintings for " + MoreWeaponry.MOD_ID);
    }
}
