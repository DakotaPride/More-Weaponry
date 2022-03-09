package net.DakotaPride.moreweaponry.util;

import net.DakotaPride.moreweaponry.item.MoreWeaponryItems;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantRandomlyLootFunction;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class MoreWeaponryLootTableModifiers {
    private static final Identifier CALCITE_ID
            = new Identifier("minecraft", "blocks/calcite");
    private static final Identifier ELDER_GUARDIAN_ID
            = new Identifier("minecraft", "entities/elder_guardian");
    private static final Identifier GUARDIAN_ID
            = new Identifier("minecraft", "entities/guardian");
    private static final Identifier PHANTOM_ID
            = new Identifier("minecraft", "entities/phantom");
    private static final Identifier WITHER_SKELETON_ID
            = new Identifier("minecraft", "entities/wither_skeleton");
    private static final Identifier ABANDONED_MINESHAFT_ID
            = new Identifier("minecraft", "chests/abandoned_mineshaft");

    public static void modifyMoreWeaponryLootTables() {
        LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
            if(CALCITE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(MoreWeaponryItems.MOON_STONE_DUST))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }

            if(ABANDONED_MINESHAFT_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.9f))
                        .with(ItemEntry.builder(MoreWeaponryItems.KURO_SEEDS))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 8.0f)).build())

                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                                .with(ItemEntry.builder(MoreWeaponryItems.MOON_STONE_BATTLEAXE))
                                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())

                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(MoreWeaponryItems.GLIMMERING_BATTLEAXE))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }

            if(ELDER_GUARDIAN_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(MoreWeaponryItems.ELDER_GUARDIAN_SCALE))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)).build())

                        .conditionally(RandomChanceLootCondition.builder(1f))
                                .with(ItemEntry.builder(MoreWeaponryItems.ELDER_GUARDIANS_EYE))
                                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }
            if(GUARDIAN_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(MoreWeaponryItems.GUARDIAN_SCALE))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)).build());
                supplier.withPool(poolBuilder.build());
            }
            if(WITHER_SKELETON_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(MoreWeaponryItems.WITHER_BONE))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)).build());
                supplier.withPool(poolBuilder.build());
            }
        }));
    }
}
