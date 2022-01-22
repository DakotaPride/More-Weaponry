package net.DakotaPride.moreweaponry.painting;

import net.DakotaPride.moreweaponry.MoreWeaponry;
import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPaintings {
    public static final PaintingMotive NIGHT_OF_THE_UNDEAD = registerPainting("night_of_the_undead", new PaintingMotive(32, 48));

    private static PaintingMotive registerPainting(String name, PaintingMotive paintingMotive) {
        return Registry.register(Registry.PAINTING_MOTIVE, new Identifier(MoreWeaponry.MOD_ID, name), paintingMotive);
    }

    public static void registerPaintings() {
        System.out.println("Registering Paintings for " + MoreWeaponry.MOD_ID);
    }
}
