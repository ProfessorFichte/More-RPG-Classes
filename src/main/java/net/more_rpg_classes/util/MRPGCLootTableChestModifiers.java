package net.more_rpg_classes.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.more_rpg_classes.item.MRPGCItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class MRPGCLootTableChestModifiers {
    private static final Identifier WEAPON_SMITH_CHEST =
            new Identifier("minecraft", "chests/village/village_weaponsmith");
    private static final Identifier TOOL_SMITH_CHEST =
            new Identifier("minecraft", "chests/village/village_weaponsmith");
    private static final Identifier ABANDONED_MINESHAFT =
            new Identifier("minecraft", "chests/abandoned_mineshaft");
    private static final Identifier NETHER_BRIDGE =
            new Identifier("minecraft", "chests/nether_bridge");
    private static final Identifier RUINED_PORTAL =
            new Identifier("minecraft", "chests/ruined_portal");
    private static final Identifier STRONGHOLD_CORRIDOR =
            new Identifier("minecraft", "chests/stronghold_corridor");

    private static final float silver_ingot_chance = 0.8f;
    private static final float darK_steel_ingot_chance = 0.2f;
    private static final float meteorite_silver_ingot_chance = 0.2f;
    private static final float iron_witcher_sword_chance = 0.4f;
    private static final float iron_berserker_axe_chance = 0.4f;
    private static final float iron_knuckle_chance = 0.4f;
    private static final float silver_witcher_sword_chance = 0.3f;
    private static final float ultimatum_sword_chance = 0.15f;
    private static final float winters_blade_chance = 0.15f;



    public static void modifyChestLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) ->{
            if(WEAPON_SMITH_CHEST.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(silver_ingot_chance))
                        .with(ItemEntry.builder(MRPGCItems.SILVER_INGOT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(meteorite_silver_ingot_chance))
                        .with(ItemEntry.builder(MRPGCItems.METEORITE_SILVER_INGOT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(darK_steel_ingot_chance))
                        .with(ItemEntry.builder(MRPGCItems.DARK_STEEL_INGOT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                /*LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(iron_witcher_sword_chance))
                        .with(ItemEntry.builder(MRPGCItems.IRON_WITCHER_SWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                LootPool.Builder poolBuilder5 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(iron_berserker_axe_chance))
                        .with(ItemEntry.builder(MRPGCItems.IRON_BERSERKER_AXE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                LootPool.Builder poolBuilder6 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(iron_knuckle_chance))
                        .with(ItemEntry.builder(MRPGCItems.IRON_KNUCKLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                LootPool.Builder poolBuilder7 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(silver_witcher_sword_chance))
                        .with(ItemEntry.builder(MRPGCItems.SILVER_WITCHER_SWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());*/
                tableBuilder.pool(poolBuilder.build());
                tableBuilder.pool(poolBuilder2.build());
                tableBuilder.pool(poolBuilder3.build());
                /*tableBuilder.pool(poolBuilder4.build());
                tableBuilder.pool(poolBuilder5.build());
                tableBuilder.pool(poolBuilder6.build());
                tableBuilder.pool(poolBuilder7.build());*/
            }
            if(TOOL_SMITH_CHEST.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(silver_ingot_chance))
                        .with(ItemEntry.builder(MRPGCItems.SILVER_INGOT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(meteorite_silver_ingot_chance))
                        .with(ItemEntry.builder(MRPGCItems.METEORITE_SILVER_INGOT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(darK_steel_ingot_chance))
                        .with(ItemEntry.builder(MRPGCItems.DARK_STEEL_INGOT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
                tableBuilder.pool(poolBuilder2.build());
                tableBuilder.pool(poolBuilder3.build());
            }
            /*if(ABANDONED_MINESHAFT.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(winters_blade_chance))
                        .with(ItemEntry.builder(MRPGCItems.WINTER_WITCHER_SWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(STRONGHOLD_CORRIDOR.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(winters_blade_chance))
                        .with(ItemEntry.builder(MRPGCItems.WINTER_WITCHER_SWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(RUINED_PORTAL.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(ultimatum_sword_chance))
                        .with(ItemEntry.builder(MRPGCItems.ULTIMATUM_WITCHER_SWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(NETHER_BRIDGE.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(ultimatum_sword_chance))
                        .with(ItemEntry.builder(MRPGCItems.ULTIMATUM_WITCHER_SWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }*/
        });
    }
}
