package net.DakotaPride.moreweaponry;

import net.minecraft.entity.Entity;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class MoreWeaponrySimpleTradeFactory implements TradeOffers.Factory {
    private final TradeOffer offer;

    MoreWeaponrySimpleTradeFactory(TradeOffer offer) {
        this.offer = offer;
    }

    @Override
    public TradeOffer create(Entity entity, Random random) {
        // ALWAYS supply a copy of the offer.
        return new TradeOffer(this.offer.toNbt());
    }
}