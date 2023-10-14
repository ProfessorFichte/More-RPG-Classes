package net.fichte.more_rpg_classes.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fichte.more_rpg_classes.item.MRPGCItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class MRPGCLootTableEntityModifiers {
    private static final Identifier WOLF_ID =
            new Identifier("minecraft", "entities/wolf");
    private static final Identifier WARDEN_ID =
            new Identifier("minecraft", "entities/warden");


    private static float wolf_fur_chance = 0.9f;
    private static float aerondight_chance = 0.2f;


    public static void modifyLootEntityTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) ->{
            if(WOLF_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(wolf_fur_chance))
                        .with(ItemEntry.builder(MRPGCItems.WOLF_FUR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(WARDEN_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(aerondight_chance))
                        .with(ItemEntry.builder(MRPGCItems.AERONDIGHT_WITCHER_SWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

        });
    }
}
