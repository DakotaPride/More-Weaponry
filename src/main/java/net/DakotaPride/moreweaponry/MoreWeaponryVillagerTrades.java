package net.DakotaPride.moreweaponry;

import net.DakotaPride.moreweaponry.block.MoreWeaponryBlocks;
import net.DakotaPride.moreweaponry.item.MoreWeaponryItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class MoreWeaponryVillagerTrades {
    public static void registerTrades(){
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 3, factories -> {
            factories.add(new MoreWeaponrySimpleTradeFactory(new TradeOffer(new ItemStack(MoreWeaponryBlocks.BLUESTONE.asItem(), 16),
                    new ItemStack(Items.EMERALD, 1), 16, 20, 0.15F)));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON, 3, factories -> {
            factories.add(new MoreWeaponrySimpleTradeFactory(new TradeOffer(new ItemStack(MoreWeaponryBlocks.LIMESTONE.asItem(), 16),
                    new ItemStack(Items.EMERALD, 1), 16, 20, 0.15F)));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
            factories.add(new MoreWeaponrySimpleTradeFactory(new TradeOffer(new ItemStack(MoreWeaponryItems.KURO, 16),
                    new ItemStack(Items.EMERALD, 1), 16, 2, 0.15F)));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
            factories.add(new MoreWeaponrySimpleTradeFactory(new TradeOffer(new ItemStack(Items.EMERALD, 1),
                    new ItemStack(MoreWeaponryItems.KURO_BREAD, 6), 16, 1, 0.15F)));
        });

    }
}