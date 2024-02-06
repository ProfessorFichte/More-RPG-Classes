package net.more_rpg_classes.item.weapons;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;
import net.more_rpg_classes.item.MRPGCGroup;
import net.spell_engine.api.item.ItemConfig;
import net.spell_engine.api.item.weapon.Weapon;
import net.spell_power.api.MagicSchool;
import net.spell_power.api.attributes.SpellAttributes;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Supplier;

public class Weapons {
    public static final ArrayList<Weapon.Entry> entries = new ArrayList<>();

    private static Weapon.Entry entry(String name, Weapon.CustomMaterial material, Item item, ItemConfig.Weapon defaults) {
        return entry(null, name, material, item, defaults);
    }

    private static Weapon.Entry entry(String requiredMod, String name, Weapon.CustomMaterial material, Item item, ItemConfig.Weapon defaults) {
        var entry = new Weapon.Entry(MRPGCMod.MOD_ID, name, material, item, defaults, null);
        if (entry.isRequiredModInstalled()) {
            entries.add(entry);
        }
        return entry;
    }

    private static Supplier<Ingredient> ingredient(String idString) {
        return ingredient(idString, Items.DIAMOND);
    }

    private static Supplier<Ingredient> ingredient(String idString, Item fallback) {
        var id = new Identifier(idString);
        return () -> {
            var item = Registries.ITEM.get(id);
            var ingredient = item != null ? item : fallback;
            return Ingredient.ofItems(ingredient);
        };
    }

    public static float witcher_sword_attackSpeed = -2.0f;
    public static float knuckle_attackSpeed = -1.4f;
    public static float berserker_axe_attackSpeed = -3.4f;

    // BASE_WITCHER-SWORDS
    private static Weapon.Entry witcherswords(String name, Weapon.CustomMaterial material, float damage) {
        return witcherswords(null, name, material, damage);
    }

    private static Weapon.Entry witcherswords(String requiredMod, String name, Weapon.CustomMaterial material, float damage) {
        var settings = new Item.Settings();
        var item = new WitcherSwordItem(material, settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed));
    }

    public static final Weapon.Entry iron_witcher_sword = witcherswords("iron_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.IRON, () -> Ingredient.ofItems(Items.IRON_INGOT)), 3.6F)
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.FIRE), 0.5F))
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.LIGHTNING), 0.5F));
    public static final Weapon.Entry golden_witcher_sword = witcherswords("golden_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.GOLD, () -> Ingredient.ofItems(Items.GOLD_INGOT)), 1.6F)
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.FIRE), 1.0F))
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.LIGHTNING), 1.0F));
    public static final Weapon.Entry diamond_witcher_sword = witcherswords("diamond_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(Items.DIAMOND)), 4.6F)
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.FIRE), 1.5F))
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.LIGHTNING), 1.5F));
    public static final Weapon.Entry netherite_witcher_sword = witcherswords("netherite_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)), 5.6F)
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.FIRE), 2.0F))
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.LIGHTNING), 2.0F));

    //KNUCKLES
    private static Weapon.Entry knuckles(String name, Weapon.CustomMaterial material, float damage) {
        return knuckles(null, name, material, damage);
    }

    private static Weapon.Entry knuckles(String requiredMod, String name, Weapon.CustomMaterial material, float damage) {
        var settings = new Item.Settings();
        var item = new KnuckleItem(material, settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, knuckle_attackSpeed));
    }


    public static final Weapon.Entry wooden_knuckle = knuckles("wooden_knuckle",
            Weapon.CustomMaterial.matching(ToolMaterials.WOOD, () -> Ingredient.fromTag(ItemTags.PLANKS)), 1.5F)
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.ARCANE), 0.5F));
    public static final Weapon.Entry stone_knuckle = knuckles("stone_knuckle",
            Weapon.CustomMaterial.matching(ToolMaterials.STONE, () -> Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS)), 2.5F)
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.ARCANE), 1.0F))
            .attribute(ItemConfig.Attribute.multiply(SpellAttributes.HASTE, 0.01F));
    public static final Weapon.Entry iron_knuckle = knuckles("iron_knuckle",
            Weapon.CustomMaterial.matching(ToolMaterials.IRON, () -> Ingredient.ofItems(Items.IRON_INGOT)), 3.5F)
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.ARCANE), 2.0F))
            .attribute(ItemConfig.Attribute.multiply(SpellAttributes.HASTE, 0.02F));
    public static final Weapon.Entry golden_knuckle = knuckles("golden_knuckle",
            Weapon.CustomMaterial.matching(ToolMaterials.GOLD, () -> Ingredient.ofItems(Items.GOLD_INGOT)), 1.5F)
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.ARCANE), 2F))
            .attribute(ItemConfig.Attribute.multiply(SpellAttributes.HASTE, 0.02F));
    public static final Weapon.Entry diamond_knuckle = knuckles("diamond_knuckle",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(Items.DIAMOND)), 4.5F)
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.ARCANE), 3.0F))
            .attribute(ItemConfig.Attribute.multiply(SpellAttributes.HASTE, 0.03F));
    public static final Weapon.Entry netherite_knuckle = knuckles("netherite_knuckle",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)), 5.5F)
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.ARCANE), 3.5F))
            .attribute(ItemConfig.Attribute.multiply(SpellAttributes.HASTE, 0.05F));


    //BERSERKER-AXE
    private static Weapon.Entry berserker_axes(String name, Weapon.CustomMaterial material, float damage) {
        return berserker_axes(null, name, material, damage);
    }

    private static Weapon.Entry berserker_axes(String requiredMod, String name, Weapon.CustomMaterial material, float damage) {
        var settings = new Item.Settings();
        var item = new BerserkerAxeItem(material, settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, berserker_axe_attackSpeed));
    }

    public static final Weapon.Entry stone_berserker_axe = berserker_axes("stone_berserker_axe",
            Weapon.CustomMaterial.matching(ToolMaterials.STONE, () -> Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS)), 8.5F)
            .attribute(ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_CHANCE, 0.025F));
    public static final Weapon.Entry iron_berserker_axe = berserker_axes("iron_berserker_axe",
            Weapon.CustomMaterial.matching(ToolMaterials.IRON, () -> Ingredient.ofItems(Items.IRON_INGOT)), 9.5F)
            .attribute(ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_CHANCE, 0.05F));
    public static final Weapon.Entry golden_berserker_axe = berserker_axes("golden_berserker_axe",
            Weapon.CustomMaterial.matching(ToolMaterials.GOLD, () -> Ingredient.ofItems(Items.GOLD_INGOT)), 7.5F)
            .attribute(ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_CHANCE, 0.05F));
    public static final Weapon.Entry diamond_berserker_axe = berserker_axes("diamond_berserker_axe",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(Items.DIAMOND)), 10.5F)
            .attribute(ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_CHANCE, 0.075F));
    public static final Weapon.Entry netherite_berserker_axe = berserker_axes("netherite_berserker_axe",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)), 11.5F)
            .attribute(ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_CHANCE, 0.1F));

    ///SPECIAL-WEAPONS
        //AERONDIGHT
    private static Weapon.Entry aerondight(String name, Weapon.CustomMaterial material, float damage) {
        return aerondight(null, name, material, damage);
    }

    private static Weapon.Entry aerondight(String requiredMod, String name, Weapon.CustomMaterial material, float damage) {
        var settings = new Item.Settings();
        var item = new AerondightRelictItem(material, settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed));
    }

    public static final Weapon.Entry aerondight = aerondight("aerondight_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, ingredient("more_rpg_classes:silver_ingot")), 6.5F)
            .attribute(ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_CHANCE, 0.01F))
            .attribute(ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_DAMAGE, 0.25F));

        //ULTIMATUM
    private static Weapon.Entry ultimatum(String name, Weapon.CustomMaterial material, float damage) {
            return ultimatum(null, name, material, damage);
        }

    private static Weapon.Entry ultimatum(String requiredMod, String name, Weapon.CustomMaterial material, float damage) {
        var settings = new Item.Settings();
        var item = new UltimatumRelicItem(material, settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed));
    }

    public static final Weapon.Entry ultimatum = ultimatum("ultimatum_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(Items.IRON_INGOT)), 5.0F)
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.FIRE), 4.0F))
            .attribute(ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_CHANCE, 0.05F));

        //WINTERS_BLADE
    private static Weapon.Entry winters_blade(String name, Weapon.CustomMaterial material, float damage) {
            return winters_blade(null, name, material, damage);
        }

    private static Weapon.Entry winters_blade(String requiredMod, String name, Weapon.CustomMaterial material, float damage) {
        var settings = new Item.Settings();
        var item = new WintersBladeRelicItem(material, settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed));
    }

    public static final Weapon.Entry winters_blade = winters_blade("winters_blade_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(Items.IRON_INGOT)), 5.0F)
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.FROST), 4.0F))
            .attribute(ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_DAMAGE, 0.15F));

    //WITCHER_SILVER_SWORD
    private static Weapon.Entry witcher_silver_sword(String name, Weapon.CustomMaterial material, float damage) {
        return witcher_silver_sword(null, name, material, damage);
    }

    private static Weapon.Entry witcher_silver_sword(String requiredMod, String name, Weapon.CustomMaterial material, float damage) {
        var settings = new Item.Settings();
        var item = new WitcherSilverSwordItem(material, settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed));
    }

    public static final Weapon.Entry witcher_silver_sword = witcher_silver_sword("silver_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.IRON, ingredient("more_rpg_classes:silver_ingot")), 3.6F)
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.FIRE), 1.5F))
            .attribute(ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.ARCANE), 1.5F));

    //Registration
    public static void register(Map<String, ItemConfig.Weapon> configs) {
        Weapon.register(configs, entries, MRPGCGroup.KEY);
    }
}
