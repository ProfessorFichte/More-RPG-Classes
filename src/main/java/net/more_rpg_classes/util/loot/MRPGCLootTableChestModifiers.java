package net.more_rpg_classes.util.loot;

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
    private static final float silver_ingot_chance = 0.75f;
    private static final float steel_ingot_chance = 0.75f;
    private static final float dark_iron_ingot_chance = 0.2f;
    private static final float meteorite_ingot_chance = 0.2f;


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
                        .conditionally(RandomChanceLootCondition.builder(dark_iron_ingot_chance))
                        .with(ItemEntry.builder(MRPGCItems.DARK_IRON_INGOT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(steel_ingot_chance))
                        .with(ItemEntry.builder(MRPGCItems.STEEL_INGOT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                LootPool.Builder poolBuilder4 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(meteorite_ingot_chance))
                        .with(ItemEntry.builder(MRPGCItems.METEORITE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
                tableBuilder.pool(poolBuilder2.build());
                tableBuilder.pool(poolBuilder3.build());
                tableBuilder.pool(poolBuilder4.build());
            }
        });
    }
}
