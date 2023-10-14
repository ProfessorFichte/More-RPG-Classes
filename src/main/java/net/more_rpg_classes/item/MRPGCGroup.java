package net.more_rpg_classes.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.more_rpg_classes.MRPGCMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MRPGCGroup {
    public static RegistryKey<ItemGroup> KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),new Identifier(MRPGCMod.MOD_ID,"generic"));
    public static ItemGroup MRPGC = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MRPGCMod.MOD_ID, "iron_berserker_axe"),
            FabricItemGroup.builder().displayName(Text.translatable("More RPG Classes"))
                    .icon(() -> new ItemStack(MRPGCItems.DIAMOND_BERSERKER_AXE)).entries((displayContext, entries) -> {
                        entries.add(MRPGCItems.STONE_BERSERKER_AXE);
                        entries.add(MRPGCItems.IRON_BERSERKER_AXE);
                        entries.add(MRPGCItems.GOLD_BERSERKER_AXE);
                        entries.add(MRPGCItems.DIAMOND_BERSERKER_AXE);
                        entries.add(MRPGCItems.NETHERITE_BERSERKER_AXE);
                        entries.add(MRPGCItems.WOLF_FUR);
                        entries.add(MRPGCItems.IRON_WITCHER_SWORD);
                        entries.add(MRPGCItems.GOLD_WITCHER_SWORD);
                        entries.add(MRPGCItems.DIAMOND_WITCHER_SWORD);
                        entries.add(MRPGCItems.NETHERITE_WITCHER_SWORD);
                        entries.add(MRPGCItems.SILVER_WITCHER_SWORD);
                        entries.add(MRPGCItems.WOODEN_KNUCKLE);
                        entries.add(MRPGCItems.STONE_KNUCKLE);
                        entries.add(MRPGCItems.IRON_KNUCKLE);
                        entries.add(MRPGCItems.GOLD_KNUCKLE);
                        entries.add(MRPGCItems.DIAMOND_KNUCKLE);
                        entries.add(MRPGCItems.NETHERITE_KNUCKLE);
                        entries.add(MRPGCItems.WINTER_WITCHER_SWORD);
                        entries.add(MRPGCItems.ULTIMATUM_WITCHER_SWORD);
                        entries.add(MRPGCItems.SILVER_INGOT);
                        entries.add(MRPGCItems.METEORITE_SILVER_INGOT);
                        entries.add(MRPGCItems.DARK_STEEL_INGOT);
                        entries.add(MRPGCItems.AERONDIGHT_WITCHER_SWORD);
                    }).build());


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(MRPGCItems.WOLF_FUR);
        entries.add(MRPGCItems.SILVER_INGOT);
        entries.add(MRPGCItems.METEORITE_SILVER_INGOT);
        entries.add(MRPGCItems.DARK_STEEL_INGOT);
    }
    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries){
        entries.add(MRPGCItems.STONE_BERSERKER_AXE);
        entries.add(MRPGCItems.IRON_BERSERKER_AXE);
        entries.add(MRPGCItems.GOLD_BERSERKER_AXE);
        entries.add(MRPGCItems.DIAMOND_BERSERKER_AXE);
        entries.add(MRPGCItems.NETHERITE_BERSERKER_AXE);
        entries.add(MRPGCItems.IRON_WITCHER_SWORD);
        entries.add(MRPGCItems.GOLD_WITCHER_SWORD);
        entries.add(MRPGCItems.DIAMOND_WITCHER_SWORD);
        entries.add(MRPGCItems.NETHERITE_WITCHER_SWORD);
        entries.add(MRPGCItems.SILVER_WITCHER_SWORD);
        entries.add(MRPGCItems.WOODEN_KNUCKLE);
        entries.add(MRPGCItems.STONE_KNUCKLE);
        entries.add(MRPGCItems.IRON_KNUCKLE);
        entries.add(MRPGCItems.GOLD_KNUCKLE);
        entries.add(MRPGCItems.DIAMOND_KNUCKLE);
        entries.add(MRPGCItems.NETHERITE_KNUCKLE);
        entries.add(MRPGCItems.WINTER_WITCHER_SWORD);
        entries.add(MRPGCItems.ULTIMATUM_WITCHER_SWORD);
        entries.add(MRPGCItems.AERONDIGHT_WITCHER_SWORD);
    }


    public static void registerItemGroups() {
        MRPGCMod.LOGGER.info("Registering Item Groups for " + MRPGCMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(MRPGCGroup::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(MRPGCGroup::addItemsToCombatItemGroup);

    }
}