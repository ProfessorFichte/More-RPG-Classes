package net.more_rpg_classes.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;


public class MRPGCItems {
    //Custom Loot
    public static Item WOLF_FUR = new Item(new FabricItemSettings().maxCount(64));
    public static Item POLAR_BEAR_FUR = new Item(new FabricItemSettings().maxCount(64));
    public static Item HARDENED_LEATHER = new Item(new FabricItemSettings().maxCount(64));


    public static void registerModItems(){
        //SpellBooks.register(new SpellBookItem(new Identifier(MRPGCMod.MOD_ID,"forcemaster"), new Item.Settings()));
        Registry.register(Registries.ITEM,new Identifier(MRPGCMod.MOD_ID,"wolf_fur"),WOLF_FUR);
        Registry.register(Registries.ITEM,new Identifier(MRPGCMod.MOD_ID,"polar_bear_fur"),POLAR_BEAR_FUR);
        Registry.register(Registries.ITEM,new Identifier(MRPGCMod.MOD_ID,"hardened_leather"),HARDENED_LEATHER);


        MRPGCMod.LOGGER.info("Registering Mod Items for " + MRPGCMod.MOD_ID);
    }
}
