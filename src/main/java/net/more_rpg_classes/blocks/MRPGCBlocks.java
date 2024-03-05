package net.more_rpg_classes.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.more_rpg_classes.MRPGCMod;
import net.more_rpg_classes.item.MRPGCGroup;

import java.util.ArrayList;

public class MRPGCBlocks {
    public record Entry(String name, Block block, BlockItem item) {
        public Entry(String name, Block block) {
            this(name, block, new BlockItem(block, new FabricItemSettings()));
        }
    }

    public static final ArrayList<Entry> all = new ArrayList<>();

    private static Entry entry(String name, Block block) {
        var entry = new Entry(name, block);
        all.add(entry);
        return entry;
    }

    public static final Entry SILVER_ORE = entry("silver_ore", new ExperienceDroppingBlock(
            FabricBlockSettings.create()
                    .mapColor(MapColor.STONE_GRAY)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(3.0F, 3.0F),
            UniformIntProvider.create(3, 7)
    ));
    public static final Entry DEEPSLATE_SILVER_ORE= entry("deepslate_silver_ore", new ExperienceDroppingBlock(
            FabricBlockSettings.create()
                    .mapColor(MapColor.STONE_GRAY)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(4.5F, 3.0F),
            UniformIntProvider.create(3, 7)
    ));
    public static final Entry METEORITE_ORE= entry("meteorite_ore", new ExperienceDroppingBlock(
            FabricBlockSettings.create()
                    .mapColor(MapColor.TERRACOTTA_BROWN)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(4.5F, 3.0F),
            UniformIntProvider.create(3, 7)
    ));
    public static final Entry DEEPSLATE_DARK_IRON_ORE= entry("deepslate_dark_iron_ore", new ExperienceDroppingBlock(
            FabricBlockSettings.create()
                    .mapColor(MapColor.STONE_GRAY)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(4.5F, 3.0F),
            UniformIntProvider.create(3, 7)
    ));
    public static final Entry DARK_IRON_ORE= entry("dark_iron_ore", new ExperienceDroppingBlock(
            FabricBlockSettings.create()
                    .mapColor(MapColor.STONE_GRAY)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(3.0F, 3.0F),
            UniformIntProvider.create(3, 7)
    ));


    public static void register() {
        for (var entry : all) {
            Registry.register(Registries.BLOCK, new Identifier(MRPGCMod.MOD_ID, entry.name), entry.block);
            Registry.register(Registries.ITEM, new Identifier(MRPGCMod.MOD_ID, entry.name), entry.item());
        }
        ItemGroupEvents.modifyEntriesEvent(MRPGCGroup.KEY).register((content) -> {
            for (var entry : all) {
                content.add(entry.item());
            }
        });
    }


}
