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

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Supplier;

public class WeaponsRegister {
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

    public static float witcher_sword_attackSpeed = -2.2f;
    public static float knuckle_attackSpeed = -1.4f;
    public static float berserker_axe_attackSpeed = -3.2f;

    // BASE_WITCHER-SWORDS
    private static Weapon.Entry witcherswords(String name, Weapon.CustomMaterial material, float damage,float sign, float adrenaline) {
        return witcherswords(null, name, material, damage, sign,adrenaline);
    }
    private static Weapon.Entry witcherswords(String requiredMod, String name, Weapon.CustomMaterial material, float damage, float sign, float adrenaline) {
        var settings = new Item.Settings();
        var item = new WitcherSwordItem(material, damage,witcher_sword_attackSpeed, sign,adrenaline,settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed));
    }

    private static Weapon.Entry witcher_silver_sword(String name, Weapon.CustomMaterial material, float damage,float sign, float adrenaline) {
        return witcher_silver_sword(null, name, material, damage, sign,adrenaline);
    }
    private static Weapon.Entry witcher_silver_sword(String requiredMod, String name, Weapon.CustomMaterial material, float damage, float sign, float adrenaline) {
        var settings = new Item.Settings();
        var item = new WitcherSilverSwordItem(material, damage,witcher_sword_attackSpeed,sign,adrenaline,settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed));
    }

    private static Weapon.Entry witcher_steel_sword(String name, Weapon.CustomMaterial material, float damage,float sign, float adrenaline) {
        return witcher_steel_sword(null, name, material, damage, sign,adrenaline);
    }
    private static Weapon.Entry witcher_steel_sword(String requiredMod, String name, Weapon.CustomMaterial material, float damage, float sign, float adrenaline) {
        var settings = new Item.Settings();
        var item = new WitcherSteelSwordItem(material, damage, witcher_sword_attackSpeed,sign,adrenaline,settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed));
    }
    private static Weapon.Entry aerondight(String name, Weapon.CustomMaterial material, float damage) {
        return aerondight(null, name, material, damage);
    }
    private static Weapon.Entry aerondight(String requiredMod, String name, Weapon.CustomMaterial material, float damage) {
        var settings = new Item.Settings();
        var item = new AerondightRelictItem(material, settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed));
    }
    private static Weapon.Entry ultimatum(String name, Weapon.CustomMaterial material, float damage, float scritchance, float scritdamage,float fire) {
        return ultimatum(null, name, material, damage, scritchance,scritdamage,fire);
    }
    private static Weapon.Entry ultimatum(String requiredMod, String name, Weapon.CustomMaterial material, float damage,float scritchance, float scritdamage,float fire) {
        var settings = new Item.Settings();
        var item = new UltimatumRelicItem(material, damage, witcher_sword_attackSpeed, scritchance,scritdamage,fire ,settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed));
    }
    private static Weapon.Entry winters_blade(String name, Weapon.CustomMaterial material, float damage, float scritdamage, float frost) {
        return winters_blade(null, name, material, damage,scritdamage,frost);
    }
    private static Weapon.Entry winters_blade(String requiredMod, String name, Weapon.CustomMaterial material, float damage, float scritdamage, float frost) {
        var settings = new Item.Settings();
        var item = new WintersBladeRelicItem(material, damage, witcher_sword_attackSpeed, scritdamage,frost, settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed));
    }

    public static final Weapon.Entry iron_witcher_sword = witcherswords("iron_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.IRON, () -> Ingredient.ofItems(Items.IRON_INGOT)),
            4.0F,0.5F,0.005F);
    public static final Weapon.Entry golden_witcher_sword = witcherswords("golden_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.GOLD, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
            2.0F, 1.0F,0.01F);
    public static final Weapon.Entry diamond_witcher_sword = witcherswords("diamond_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(Items.DIAMOND)),
            5.0F,1.5F,0.015F);
    public static final Weapon.Entry netherite_witcher_sword = witcherswords("netherite_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
            6.0F, 2.0F,0.02F);
    public static final Weapon.Entry steel_witcher_sword = witcher_steel_sword("steel_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.IRON, ingredient("more_rpg_classes:steel_ingot")),
            4.5F,0.0F,0.04F);
    public static final Weapon.Entry dark_iron_witcher_sword = witcher_steel_sword("dark_iron_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, ingredient("more_rpg_classes:steel_ingot")),
            5.5F,0.5F,0.075F);
    public static final Weapon.Entry dark_steel_witcher_sword = witcherswords("dark_steel_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, ingredient("more_rpg_classes:dark_steel_ingot")),
            6.5F,1.0F,0.1F );
    public static final Weapon.Entry witcher_silver_sword = witcher_silver_sword("silver_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.IRON, ingredient("more_rpg_classes:silver_ingot")),
            2.2F,2.0F,0.0F);
    public static final Weapon.Entry witcher_meteorite_sword = witcher_silver_sword("meteorite_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, ingredient("more_rpg_classes:meteorite_ingot")),
            3.2F,3.0F,0.02F);
    public static final Weapon.Entry witcher_meteorite_silver_sword = witcher_silver_sword("meteorite_silver_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, ingredient("more_rpg_classes:meteorite_silver_ingot")),
            4.2F,4.0F,0.04F);
public static final Weapon.Entry aerondight = aerondight("aerondight_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, ingredient("more_rpg_classes:meteorite_silver_ingot")), 7.5F);
public static final Weapon.Entry ultimatum = ultimatum("ultimatum_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, ingredient("more_rpg_classes:steel_ingot")),
        5.5F,0.03F,0.1F,4.0F);
    public static final Weapon.Entry winters_blade = winters_blade("winters_blade_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, ingredient("more_rpg_classes:steel_ingot")),
            5.5F, 0.15F,4);


    //KNUCKLES
    private static Weapon.Entry knuckles(String name, Weapon.CustomMaterial material,
                                         float damage, float afuse ,float haste,float arcanep) {
        return knuckles(null, name, material, damage, afuse,haste,arcanep);
    }
    private static Weapon.Entry knuckles(String requiredMod, String name, Weapon.CustomMaterial material,
                                         float damage, float afuse,float haste,float arcanep) {
        var settings = new Item.Settings();
        var item = new KnuckleItem(material, damage, knuckle_attackSpeed, afuse,haste,arcanep,settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage,knuckle_attackSpeed));
    }

    private static Weapon.Entry bloody_knuckles(Weapon.CustomMaterial material) {
        return bloody_knuckles(null, material);
    }
    private static Weapon.Entry bloody_knuckles(String requiredMod, Weapon.CustomMaterial material) {
        var settings = new Item.Settings();
        var item = new BloodyKnuckleItem(material, (float) 6.5, knuckle_attackSpeed, (float) 0.05, (float) 0.07, (float) 5.0, (float) 0.0,(float) 0.25,settings);
        return entry(requiredMod, "bloody_knuckle", material, item, new ItemConfig.Weapon());
    }
    private static Weapon.Entry lg_knuckles(Weapon.CustomMaterial material) {
        return lg_knuckles(null, material);
    }
    private static Weapon.Entry lg_knuckles(String requiredMod, Weapon.CustomMaterial material) {
        var settings = new Item.Settings();
        var item = new LegendaryGoldenKnuckleItem(material, (float) 4.5, knuckle_attackSpeed, (float) 0.04, (float) 0.05, (float) 4.0, (float) 0.0,(float) 0.0,settings);
        return entry(requiredMod, "legendary_golden_knuckle", material, item, new ItemConfig.Weapon());
    }
    private static Weapon.Entry g_knuckles(Weapon.CustomMaterial material) {
        return g_knuckles(null, material);
    }
    private static Weapon.Entry g_knuckles(String requiredMod, Weapon.CustomMaterial material) {
        var settings = new Item.Settings();
        var item = new GuardianKnuckleItem(material, (float) 5.0, knuckle_attackSpeed, (float) 0.04, (float) 0.0, (float) 3.5, (float) 0.050,(float) 0.10,settings);
        return entry(requiredMod, "guardian_knuckle", material, item, new ItemConfig.Weapon());
    }
    

    public static final Weapon.Entry wooden_knuckle = knuckles("wooden_knuckle",
            Weapon.CustomMaterial.matching(ToolMaterials.WOOD, () -> Ingredient.fromTag(ItemTags.PLANKS)),
            1.5F,0.0F,0.0F,0.5F);
    public static final Weapon.Entry stone_knuckle = knuckles("stone_knuckle",
            Weapon.CustomMaterial.matching(ToolMaterials.STONE, () -> Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS)),
                    2.5F,0.0F,0.01F,1.0F);
    public static final Weapon.Entry iron_knuckle = knuckles("iron_knuckle",
            Weapon.CustomMaterial.matching(ToolMaterials.IRON, () -> Ingredient.ofItems(Items.IRON_INGOT)),
                    3.5F,0.01F,0.02F,2.0F);
    public static final Weapon.Entry golden_knuckle = knuckles("golden_knuckle",
            Weapon.CustomMaterial.matching(ToolMaterials.GOLD, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
                    1.5F,0.01F,0.02F,2.0F);
    public static final Weapon.Entry diamond_knuckle = knuckles("diamond_knuckle",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(Items.DIAMOND)),
                    4.5F,0.03F,0.03F,3.0F);
    public static final Weapon.Entry netherite_knuckle = knuckles("netherite_knuckle",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
                    5.5F,0.05F,0.05F,4.5F);
    public static final Weapon.Entry legendary_golden_knuckle = lg_knuckles(
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(Items.GOLD_INGOT)));
    public static final Weapon.Entry guardian_knuckle = g_knuckles(
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(Items.IRON_INGOT)));
    public static final Weapon.Entry bloody_knuckle = bloody_knuckles(
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)));

    //BERSERKER-AXE
    private static Weapon.Entry berserker_axes(String name, Weapon.CustomMaterial material, float damage, float rage,float scritdmg) {
        return berserker_axes(null, name, material, damage,rage,scritdmg);}
    private static Weapon.Entry berserker_axes(String requiredMod, String name, Weapon.CustomMaterial material, float damage, float rage,float scritdmg) {
        var settings = new Item.Settings();
        var item = new BerserkerAxeItem(material,damage,berserker_axe_attackSpeed, rage,scritdmg,settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, berserker_axe_attackSpeed));}

    private static Weapon.Entry special_berserker_axe_1(String name, Weapon.CustomMaterial material) {
        return special_berserker_axe_1(null, name, material);}
    private static Weapon.Entry special_berserker_axe_1(String requiredMod, String name, Weapon.CustomMaterial material) {
        var settings = new Item.Settings();
        var item = new FrozenBerserkerAxeItem(material, (float) 9.5,berserker_axe_attackSpeed, (float) 0.055, (float) 0.06, (float) 4.0, settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon());}

    private static Weapon.Entry special_berserker_axe_2(String name, Weapon.CustomMaterial material) {
        return special_berserker_axe_2(null, name, material);}
    private static Weapon.Entry special_berserker_axe_2(String requiredMod, String name, Weapon.CustomMaterial material) {
        var settings = new Item.Settings();
        var item = new ThunderBerserkerAxeItem(material, (float) 9.5,berserker_axe_attackSpeed, (float) 0.055, (float) 0.15, (float) 4.0,settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon((float) 10.0, berserker_axe_attackSpeed));}

    private static Weapon.Entry special_berserker_axe_3(String name, Weapon.CustomMaterial material) {
        return special_berserker_axe_3(null, name, material);}
    private static Weapon.Entry special_berserker_axe_3(String requiredMod, String name, Weapon.CustomMaterial material) {
        var settings = new Item.Settings();
        var item = new SoulBerserkerAxeItem(material, (float) 10.5,berserker_axe_attackSpeed, (float)0.075, (float) 0.25, (float) 5.0,settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon((float) 11.0, berserker_axe_attackSpeed));}

    public static final Weapon.Entry flint_berserker_axe = berserker_axes("flint_berserker_axe",
            Weapon.CustomMaterial.matching(ToolMaterials.WOOD, () -> Ingredient.ofItems(Items.FLINT)),
            7.0F,0.0F,0.01F);
    public static final Weapon.Entry stone_berserker_axe = berserker_axes("stone_berserker_axe",
            Weapon.CustomMaterial.matching(ToolMaterials.STONE, () -> Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS)),
            9.0F,0.0F,0.02F);
    public static final Weapon.Entry iron_berserker_axe = berserker_axes("iron_berserker_axe",
            Weapon.CustomMaterial.matching(ToolMaterials.IRON, () -> Ingredient.ofItems(Items.IRON_INGOT)),
            9.0F,0.02F,0.05F);
    public static final Weapon.Entry golden_berserker_axe = berserker_axes("golden_berserker_axe",
            Weapon.CustomMaterial.matching(ToolMaterials.GOLD, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
            7.0F,0.01F,0.02F);
    public static final Weapon.Entry diamond_berserker_axe = berserker_axes("diamond_berserker_axe",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(Items.DIAMOND)),
            9.0F,0.03F,0.075F);
    public static final Weapon.Entry netherite_berserker_axe = berserker_axes("netherite_berserker_axe",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
            10.0F,0.05F,0.1F);
    public static final Weapon.Entry frozen_berserker_axe = special_berserker_axe_1("frozen_berserker_axe",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, () -> Ingredient.ofItems(Items.DIAMOND)));
    public static final Weapon.Entry thunder_berserker_axe = special_berserker_axe_2("thunder_berserker_axe",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, () -> Ingredient.ofItems(Items.DIAMOND))
    );
    public static final Weapon.Entry soul_berserker_axe = special_berserker_axe_3("soul_berserker_axe",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, () -> Ingredient.ofItems(Items.NETHERITE_INGOT))
    );

    //Registration
    public static void register(Map<String, ItemConfig.Weapon> configs) {
        Weapon.register(configs, entries, MRPGCGroup.KEY);
    }
}
