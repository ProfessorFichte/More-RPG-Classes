package net.more_rpg_classes.config;

import net.more_rpg_classes.item.armor.Armors;
import net.more_rpg_classes.item.weapons.Weapons;
import net.spell_engine.api.item.ItemConfig;
import net.spell_engine.api.loot.LootConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collection;

public class Default {
    public final static ItemConfig itemConfig;
    public final static LootConfig lootConfig;

    static {
        itemConfig = new ItemConfig();
        for (var armorSet : Armors.entries) {
            itemConfig.armor_sets.put(armorSet.name(), armorSet.defaults());
        }
        for (var weapon: Weapons.entries) {
            itemConfig.weapons.put(weapon.name(), weapon.defaults());
        }

        lootConfig = new LootConfig();
        final var weapons_beginner = "weapons_beginner";
        lootConfig.item_groups.put(weapons_beginner, new LootConfig.ItemGroup(List.of(
                Weapons.wooden_knuckle.id().toString(),
                Weapons.stone_berserker_axe.id().toString()),
                0.5F,
                0,
                1
        ));

        final var weapons_golden = "weapons_golden";
        lootConfig.item_groups.put(weapons_golden, new LootConfig.ItemGroup(List.of(
                Weapons.golden_witcher_sword.id().toString(),
                Weapons.golden_knuckle.id().toString(),
                Weapons.golden_berserker_axe.id().toString()),
                1
        ).chance(0.4F).enchant());


        final var weapons_advanced = "weapons_advanced";
        lootConfig.item_groups.put(weapons_advanced, new LootConfig.ItemGroup(List.of(
                Weapons.iron_knuckle.id().toString(),
                Weapons.iron_berserker_axe.id().toString(),
                Weapons.witcher_silver_sword.id().toString(),
                Weapons.iron_witcher_sword.id().toString()),
                1
        ).chance(0.3F));


        final var weapons_mid = "weapons_mid";
        lootConfig.item_groups.put(weapons_mid, new LootConfig.ItemGroup(List.of(
                Weapons.diamond_knuckle.id().toString(),
                Weapons.diamond_berserker_axe.id().toString(),
                Weapons.diamond_witcher_sword.id().toString()),
                1
        ).chance(0.3F));


        final var weapons_mid_enchanted = "weapons_mid_enchanted";
        lootConfig.item_groups.put(weapons_mid_enchanted, new LootConfig.ItemGroup(
                new ArrayList(lootConfig.item_groups.get("weapons_mid").ids),
                1
        ).chance(0.3F).enchant());

        final var armor_beginner = "armor_beginner";
        lootConfig.item_groups.put(armor_beginner, new LootConfig.ItemGroup(joinLists(
                Armors.orieneArmorSet.idStrings(),
                Armors.adeptArmorSet.idStrings(),
                Armors.wildlingArmorSet.idStrings()),
                1
        ).chance(0.25F));
        final var armor_beginner_enchanted = "armor_beginner_enchanted";
        lootConfig.item_groups.put(armor_beginner_enchanted, new LootConfig.ItemGroup(
                new ArrayList(lootConfig.item_groups.get(armor_beginner).ids),
                1
        ).chance(0.25F).enchant());
        final var armor_advanced = "armor_advanced";
        lootConfig.item_groups.put(armor_advanced, new LootConfig.ItemGroup(joinLists(
                Armors.witcherArmorSet.idStrings(),
                Armors.phaslebArmorSet.idStrings(),
                Armors.northlingArmorSet.idStrings()),
                1
        ).chance(0.5F));


        List.of("minecraft:chests/ruined_portal")
                .forEach(id -> lootConfig.loot_tables.put(id, List.of(weapons_golden)));

        List.of("minecraft:chests/spawn_bonus_chest",
                        "minecraft:chests/igloo_chest",
                        "minecraft:chests/shipwreck_supply",
                        "minecraft:chests/jungle_temple")
                .forEach(id -> lootConfig.loot_tables.put(id, List.of(weapons_beginner)));

        List.of("minecraft:chests/desert_pyramid",
                        "minecraft:chests/bastion_bridge",
                        "minecraft:chests/jungle_temple",
                        "minecraft:chests/pillager_outpost",
                        "minecraft:chests/underwater_ruin_small",
                        "minecraft:chests/stronghold_crossing")
                .forEach(id -> lootConfig.loot_tables.put(id, List.of(weapons_advanced)));

        List.of("minecraft:chests/nether_bridge")
                .forEach(id -> lootConfig.loot_tables.put(id, List.of(weapons_mid)));

        List.of("minecraft:chests/shipwreck_supply",
                        "minecraft:chests/stronghold_corridor")
                .forEach(id -> lootConfig.loot_tables.put(id, List.of(armor_beginner)));

        List.of("minecraft:chests/stronghold_library",
                        "minecraft:chests/underwater_ruin_big",
                        "minecraft:chests/bastion_other",
                        "minecraft:chests/woodland_mansion",
                        "minecraft:chests/simple_dungeon",
                        "minecraft:chests/underwater_ruin_big.json")
                .forEach(id -> lootConfig.loot_tables.put(id, List.of(weapons_advanced, armor_beginner_enchanted)));

        List.of("minecraft:chests/end_city_treasure",
                        "minecraft:chests/bastion_treasure",
                        "minecraft:chests/ancient_city",
                        "minecraft:chests/stronghold_library")
                .forEach(id -> lootConfig.loot_tables.put(id, List.of(weapons_mid_enchanted, armor_advanced)));

    }

    @SafeVarargs
    private static <T> List<T> joinLists(List<T>... lists) {
        return Arrays.stream(lists).flatMap(Collection::stream).collect(Collectors.toList());
    }
}