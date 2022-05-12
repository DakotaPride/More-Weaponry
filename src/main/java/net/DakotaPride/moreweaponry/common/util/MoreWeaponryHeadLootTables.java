package net.DakotaPride.moreweaponry.common.util;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
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

    public static void registerMoreWeaponryHeadLootTables() {
        LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
            if (WATCHER_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(100.0f))
                        .with(ItemEntry.builder(MoreWeaponry.WATCHER_SKULL.asItem()))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            } if (WANDERER_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(100.0f))
                        .with(ItemEntry.builder(MoreWeaponry.WANDERER_SKULL.asItem()))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            } if (BARD_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(100.0f))
                        .with(ItemEntry.builder(MoreWeaponry.BARD_SKULL.asItem()))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            } if (CRACKLER_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(100.0f))
                        .with(ItemEntry.builder(MoreWeaponry.CRACKLER_SKULL.asItem()))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            } if (SICKENED_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(100.0f))
                        .with(ItemEntry.builder(MoreWeaponry.SICKENED_SKULL.asItem()))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }
        }));
    }


}
