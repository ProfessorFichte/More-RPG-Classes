package net.more_rpg_classes.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;

import static net.more_rpg_classes.item.MRPGCItems.*;

public class MRPGCGroup {
    public static Identifier ID = new Identifier(MRPGCMod.MOD_ID, "generic");
    public static RegistryKey<ItemGroup> KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),new Identifier(MRPGCMod.MOD_ID,"generic"));
    public static ItemGroup MRPGC;


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(MRPGCItems.WOLF_FUR);
        entries.add(MRPGCItems.POLAR_BEAR_FUR);
        entries.add(MRPGCItems.HARDENED_LEATHER);
    }
    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries){
        entries.add(AQUA_STONE);
        entries.add(TERRA_STONE);
        entries.add(STORM_STONE);
    }


    public static void registerItemGroups() {
        MRPGCMod.LOGGER.info("Registering Item Groups for " + MRPGCMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(MRPGCGroup::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(MRPGCGroup::addItemsToCombatItemGroup);
    }
}