package net.more_rpg_classes.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;
import net.more_rpg_classes.item.armor.Armors;
import net.more_rpg_classes.item.weapons.WeaponsRegister;
import net.spell_engine.api.item.trinket.SpellBooks;

import java.util.HashMap;
import java.util.UUID;


public class MRPGCItems {
    public static final UUID ARCANE_FUSE_MODIFIER_ID = UUID.fromString("e87944fc-96f2-4f37-87a3-da137a7f8827");
    public static final UUID ARCANE_SPELLPOWER_MODIFIER_ID = UUID.fromString("c14a4b73-81ff-4c3f-8d09-a4752c830fe2");
    public static final UUID FROST_SPELLPOWER_MODIFIER_ID = UUID.fromString("6a17869a-3060-4a02-b9f0-379ae9de6de8");
    public static final UUID LIGHTNING_SPELLPOWER_MODIFIER_ID = UUID.fromString("db7059ae-6612-4991-857e-26f01c70565e");
    public static final UUID SOUL_SPELLPOWER_MODIFIER_ID = UUID.fromString("6e30be54-388f-43e4-8d86-9e4b2a30c3bb");
    public static final UUID FIRE_SPELLPOWER_MODIFIER_ID = UUID.fromString("d8f0311a-1ace-4b91-9638-229eaa2ef96a");
    public static final UUID HASTE_MODIFIER_ID = UUID.fromString("321cc202-3f1f-4951-b136-fe5902e85949");
    public static final UUID SPELL_CRIT_CHANCE_MODIFIER_ID = UUID.fromString("7dfc8893-5c57-4f99-9b04-eed646f2d117");
    public static final UUID SPELL_CRIT_DAMAGE_MODIFIER_ID = UUID.fromString("ebdf8fee-d71e-4255-ba34-dc7574cc9de9");
    public static final UUID LIFESTEAL_MODIFIER_ID = UUID.fromString("9089e0d1-d6f8-4a16-8c5d-943b32dda251");
    public static final UUID ADRENALINE_MODIFIER_ID = UUID.fromString("00e4c410-b30c-4bf4-8ed2-6e9f5678066a");
    public static final UUID SIGN_INTENSITY_MODIFIER_ID = UUID.fromString("d6b2ce5a-01fa-4d8e-90f5-0f1d6478aa87");
    public static final UUID RAGE_MODIFIER_ID = UUID.fromString("20cbe7c4-223a-42df-913f-fe8593247b77");

    public static final HashMap<String, Item> entries;
    static {
        entries = new HashMap<>();
        for(var weaponEntry: WeaponsRegister.entries) {
            entries.put(weaponEntry.id().toString(), weaponEntry.item());
        }
        for(var entry: Armors.entries) {
            var set = entry.armorSet();
            for (var piece: set.pieces()) {
                var armorItem = (ArmorItem) piece;
                entries.put(set.idOf(armorItem).toString(), armorItem);
            }
        }
    }

    //Custom Loot
    public static Item WOLF_FUR = new Item(new FabricItemSettings().maxCount(64));
    public static Item SILVER_INGOT  = new Item(new FabricItemSettings().maxCount(64));
    public static Item METEORITE_SILVER_INGOT = new Item(new FabricItemSettings().maxCount(64));
    public static Item DARK_STEEL_INGOT= new Item(new FabricItemSettings().maxCount(64));
    public static Item STEEL_INGOT= new Item(new FabricItemSettings().maxCount(64));
    public static Item RAW_SILVER = new Item(new FabricItemSettings().maxCount(64));
    public static Item POLAR_BEAR_FUR = new Item(new FabricItemSettings().maxCount(64));
    public static Item METEORITE = new Item(new FabricItemSettings().maxCount(64));
    public static Item METEORITE_INGOT = new Item(new FabricItemSettings().maxCount(64));
    public static Item DARK_IRON_INGOT = new Item(new FabricItemSettings().maxCount(64));
    public static Item RAW_DARK_IRON = new Item(new FabricItemSettings().maxCount(64));
    public static Item HARDENED_LEATHER = new Item(new FabricItemSettings().maxCount(64));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(MRPGCMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        SpellBooks.createAndRegister(new Identifier(MRPGCMod.MOD_ID,"berserker"),MRPGCGroup.KEY);
        SpellBooks.createAndRegister(new Identifier(MRPGCMod.MOD_ID,"witcher_signs"),MRPGCGroup.KEY);
        SpellBooks.createAndRegister(new Identifier(MRPGCMod.MOD_ID,"witcher_combat"),MRPGCGroup.KEY);
        SpellBooks.createAndRegister(new Identifier(MRPGCMod.MOD_ID,"forcemaster"),MRPGCGroup.KEY);
        //SpellBooks.register(new SpellBookItem(new Identifier(MRPGCMod.MOD_ID,"forcemaster"), new Item.Settings()));


        Registry.register(Registries.ITEM,new Identifier(MRPGCMod.MOD_ID,"wolf_fur"),WOLF_FUR);
        Registry.register(Registries.ITEM,new Identifier(MRPGCMod.MOD_ID,"silver_ingot"),SILVER_INGOT);
        Registry.register(Registries.ITEM,new Identifier(MRPGCMod.MOD_ID,"meteorite_silver_ingot"),METEORITE_SILVER_INGOT);
        Registry.register(Registries.ITEM,new Identifier(MRPGCMod.MOD_ID,"raw_silver"),RAW_SILVER );
        Registry.register(Registries.ITEM,new Identifier(MRPGCMod.MOD_ID,"steel_ingot"),STEEL_INGOT);
        Registry.register(Registries.ITEM,new Identifier(MRPGCMod.MOD_ID,"dark_steel_ingot"),DARK_STEEL_INGOT);
        Registry.register(Registries.ITEM,new Identifier(MRPGCMod.MOD_ID,"polar_bear_fur"),POLAR_BEAR_FUR);
        Registry.register(Registries.ITEM,new Identifier(MRPGCMod.MOD_ID,"meteorite"),METEORITE );
        Registry.register(Registries.ITEM,new Identifier(MRPGCMod.MOD_ID,"meteorite_ingot"),METEORITE_INGOT);
        Registry.register(Registries.ITEM,new Identifier(MRPGCMod.MOD_ID,"dark_iron_ingot"),DARK_IRON_INGOT);
        Registry.register(Registries.ITEM,new Identifier(MRPGCMod.MOD_ID,"raw_dark_iron"),RAW_DARK_IRON);
        Registry.register(Registries.ITEM,new Identifier(MRPGCMod.MOD_ID,"hardened_leather"),HARDENED_LEATHER);

        ItemGroupEvents.modifyEntriesEvent(MRPGCGroup.KEY).register((content) -> {
            content.add(WOLF_FUR);
            content.add(POLAR_BEAR_FUR);
            content.add(RAW_SILVER);
            content.add(RAW_DARK_IRON);
            content.add(METEORITE);
            content.add(SILVER_INGOT);
            content.add(METEORITE_SILVER_INGOT);
            content.add(STEEL_INGOT);
            content.add(METEORITE_INGOT);
            content.add(DARK_IRON_INGOT);
            content.add(DARK_STEEL_INGOT);
            content.add(HARDENED_LEATHER);
        });

        MRPGCMod.LOGGER.info("Registering Mod Items for " + MRPGCMod.MOD_ID);
    }
}
