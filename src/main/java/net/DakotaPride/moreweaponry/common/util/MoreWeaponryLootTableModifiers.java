package net.DakotaPride.moreweaponry.common.util;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class MoreWeaponryLootTableModifiers {
    private static final Identifier CALCITE_BLOCK_ID
            = new Identifier("minecraft", "blocks/calcite");
    private static final Identifier GUARDIAN_ID
            = new Identifier("minecraft", "entities/guardian");
    private static final Identifier ELDER_GUARDIAN_ID
            = new Identifier("minecraft", "entities/elder_guardian");
    private static final Identifier WITHER_SKELETON_ID
            = new Identifier("minecraft", "entities/wither_skeleton");
    private static final Identifier PHANTOM_ID
            = new Identifier("minecraft", "entities/phantom");



    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (CALCITE_BLOCK_ID.equals(id)) {
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(MoreWeaponry.MOON_STONE_DUST))
                        .conditionally(RandomChanceLootCondition.builder(0.30F).build())
                        .build();
                supplier.pool(poolBuilder);
            }

            if(GUARDIAN_ID.equals(id)) {
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(MoreWeaponry.GUARDIAN_SCALE))
                        .conditionally(RandomChanceLootCondition.builder(0.30F).build())
                        .build();
                supplier.pool(poolBuilder);
            }
            if(ELDER_GUARDIAN_ID.equals(id)) {
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(MoreWeaponry.ELDER_GUARDIAN_SCALE))
                        .conditionally(RandomChanceLootCondition.builder(0.65f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(MoreWeaponry.ELDER_GUARDIANS_EYE))
                        .conditionally(RandomChanceLootCondition.builder(0.99f))
                        .build();
                supplier.pool(poolBuilder);
            }

            if(WITHER_SKELETON_ID.equals(id)) {
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(MoreWeaponry.WITHER_BONE))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(MoreWeaponry.WITHER_ESSENCE))
                        .conditionally(RandomChanceLootCondition.builder(0.42f))
                        .build();
                supplier.pool(poolBuilder);
            }

            if(PHANTOM_ID.equals(id)) {
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(MoreWeaponry.PHANTOM_ESSENCE))
                        .conditionally(RandomChanceLootCondition.builder(0.75f))
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(MoreWeaponry.PHANTOM_SCALE))
                        .conditionally(RandomChanceLootCondition.builder(0.65f))
                        .build();
                supplier.pool(poolBuilder);
            }
        });
        MoreWeaponryHeadLootTables.registerMoreWeaponryHeadLootTables();
    }

}
