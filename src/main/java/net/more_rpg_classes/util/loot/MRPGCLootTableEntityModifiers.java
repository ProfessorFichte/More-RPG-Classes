package net.more_rpg_classes.util.loot;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.item.MRPGCItems;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootPool;

public class MRPGCLootTableEntityModifiers {

    private static final Identifier WOLF_ID =
            Identifier.of("minecraft", "entities/wolf");
    private static final Identifier POLAR_BEAR_ID =
            Identifier.of("minecraft", "entities/polar_bear");
    private static final Identifier RAVAGER_ID =
            Identifier.of("minecraft", "entities/ravager");


    private static float wolf_fur_chance = 0.8f;
    private static float polar_bear_fur_chance = 1.0f;
    private static float ravager_hardened_leather_chance = 1.0f;


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
            if(POLAR_BEAR_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(polar_bear_fur_chance))
                        .with(ItemEntry.builder(MRPGCItems.POLAR_BEAR_FUR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if(RAVAGER_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(ravager_hardened_leather_chance))
                        .with(ItemEntry.builder(MRPGCItems.HARDENED_LEATHER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

        });
    }

}
