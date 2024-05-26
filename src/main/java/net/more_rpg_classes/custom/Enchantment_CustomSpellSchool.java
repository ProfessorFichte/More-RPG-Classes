package net.more_rpg_classes.custom;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;
import net.spell_power.SpellPowerMod;
import net.spell_power.api.SpellSchool;
import net.spell_power.api.SpellSchools;
import net.spell_power.api.enchantment.EnchantmentRestriction;
import net.spell_power.api.enchantment.SpellPowerEnchanting;
import net.spell_power.config.EnchantmentsConfig;
import net.spell_power.internals.SchoolFilteredEnchantment;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static net.minecraft.enchantment.EnchantmentTarget.BREAKABLE;
import static net.spell_power.internals.AmplifierEnchantment.Operation.ADD;

public class Enchantment_CustomSpellSchool {
    public static final String elementalName = "elemental";
    public static final Identifier elemental = new Identifier(MRPGCMod.MOD_ID, elementalName);
    public static final SchoolFilteredEnchantment ELEMENTAL = new SchoolFilteredEnchantment(
            Enchantment.Rarity.COMMON,
            ADD,
            config().spell_power,
            Set.of(MoreSpellSchools.EARTH, MoreSpellSchools.AIR,MoreSpellSchools.WATER),
            BREAKABLE,
            EquipmentSlot.values());
    public static final String waterName = "water_mastery";
    public static final Identifier water = new Identifier(MRPGCMod.MOD_ID, waterName);
    public static final SchoolFilteredEnchantment WATER_MASTERY = new SchoolFilteredEnchantment(
            Enchantment.Rarity.RARE,
            ADD,
            config().soulfrost,
            Set.of(MoreSpellSchools.WATER),
            BREAKABLE,
            EquipmentSlot.values());
    public static final String earthName = "earth_mastery";
    public static final Identifier earth = new Identifier(MRPGCMod.MOD_ID, earthName);
    public static final SchoolFilteredEnchantment EARTH_MASTERY = new SchoolFilteredEnchantment(
            Enchantment.Rarity.RARE,
            ADD,
            config().soulfrost,
            Set.of(MoreSpellSchools.EARTH),
            BREAKABLE,
            EquipmentSlot.values());
    public static final String airName = "air_mastery";
    public static final Identifier air = new Identifier(MRPGCMod.MOD_ID, airName);
    public static final SchoolFilteredEnchantment AIR_MASTERY = new SchoolFilteredEnchantment(
            Enchantment.Rarity.RARE,
            ADD,
            config().soulfrost,
            Set.of(MoreSpellSchools.AIR),
            BREAKABLE,
            EquipmentSlot.values());


    public static final Map<Identifier, SchoolFilteredEnchantment> all;
    static {
        all = new HashMap<>();
        all.put(elemental, ELEMENTAL);
        all.put(water, WATER_MASTERY);
        all.put(earth, EARTH_MASTERY);
        all.put(air, AIR_MASTERY);

        for(var entry: all.entrySet()) {
            var enchantment = entry.getValue();
            EnchantmentRestriction.prohibit(enchantment, itemStack -> {
                var itemTypeRequirement = enchantment.config.requires;
                var typeMatches = true;
                var schoolMatches = true;
                if (itemTypeRequirement != null) {
                    typeMatches = itemTypeRequirement.matches(itemStack);
                    if (itemTypeRequirement.requiresMagic()) {
                        schoolMatches = SchoolFilteredEnchantment.schoolsIntersect(enchantment.poweredSchools(), itemStack);
                    }
                }
                return !typeMatches || !schoolMatches;
            });
        }
    }

    private static EnchantmentsConfig config() {
        return SpellPowerMod.enchantmentConfig.value;
    }

    public static void attach() {
        for(var school: SpellSchools.all()) {
            var poweringEnchantments = all.entrySet().stream()
                    .filter(entry -> entry.getValue().poweredSchools().contains(school))
                    .map(Map.Entry::getValue)
                    .toList();
            school.addSource(SpellSchool.Trait.POWER, new SpellSchool.Source(SpellSchool.Apply.MULTIPLY, query -> {
                double value = 0;
                for (var enchantment: poweringEnchantments) {
                    var level = SpellPowerEnchanting.getEnchantmentLevel(enchantment, query.entity(), null);
                    value = enchantment.amplified(value, level);
                }
                return value;
            }));
        }
    }


}
