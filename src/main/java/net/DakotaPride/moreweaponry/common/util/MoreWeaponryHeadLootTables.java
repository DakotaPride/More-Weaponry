package net.DakotaPride.moreweaponry.common.util;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

public class MoreWeaponryHeadLootTables {
    private static final Identifier WATCHER_ID
            = new Identifier(MoreWeaponry.MOD_ID, "entities/watcher");
    private static final Identifier WANDERER_ID
            = new Identifier(MoreWeaponry.MOD_ID, "entities/wanderer");
    private static final Identifier BARD_ID
            = new Identifier(MoreWeaponry.MOD_ID, "entities/bard");
    private static final Identifier CRACKLER_ID
            = new Identifier(MoreWeaponry.MOD_ID, "entities/crackler");
    private static final Identifier SICKENED_ID
            = new Identifier(MoreWeaponry.MOD_ID, "entities/sickened");
    private static final Identifier SICKENED_HUSK_ID
            = new Identifier(MoreWeaponry.MOD_ID, "entities/sickened_husk");

    public static void registerMoreWeaponryHeadLootTables() {
        LootTableEvents.MODIFY.register(((resourceManager, manager, id, supplier, setter) -> {
            if (WATCHER_ID.equals(id)) {
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(MoreWeaponry.WATCHER_SKULL.asItem()))
                        .conditionally(RandomChanceLootCondition.builder(100.0f))
                        .build();
                supplier.pool(poolBuilder);
            } if (WANDERER_ID.equals(id)) {
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(MoreWeaponry.WANDERER_SKULL.asItem()))
                        .conditionally(RandomChanceLootCondition.builder(100.0f))
                        .build();
                supplier.pool(poolBuilder);
            } if (BARD_ID.equals(id)) {
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(MoreWeaponry.BARD_SKULL.asItem()))
                        .conditionally(RandomChanceLootCondition.builder(100.0f))
                        .build();
                supplier.pool(poolBuilder);
            } if (CRACKLER_ID.equals(id)) {
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(MoreWeaponry.CRACKLER_SKULL.asItem()))
                        .conditionally(RandomChanceLootCondition.builder(100.0f))
                        .build();
                supplier.pool(poolBuilder);
            } if (SICKENED_ID.equals(id)) {
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(MoreWeaponry.SICKENED_SKULL.asItem()))
                        .conditionally(RandomChanceLootCondition.builder(100.0f))
                        .build();
                supplier.pool(poolBuilder);
            } if (SICKENED_HUSK_ID.equals(id)) {
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(MoreWeaponry.SICKENED_HUSK_SKULL.asItem()))
                        .conditionally(RandomChanceLootCondition.builder(100.0f))
                        .build();
                supplier.pool(poolBuilder);
            }
        }));
    }


}
