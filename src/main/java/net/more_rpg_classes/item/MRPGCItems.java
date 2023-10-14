package net.more_rpg_classes.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.more_rpg_classes.MRPGCMod;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.UUID;


public class MRPGCItems {
    //protected static final UUID INCOMING_DAMAGE_MODIFIER_ID = UUID.fromString("f8e5213e-fa22-413a-99ea-f7be068795b2");
    //protected static final UUID ARMOR_MODIFIER_ID = UUID.fromString("c0e6f0a8-ba89-4a77-bfd5-7c930a3d81ef");
    protected static final UUID SPELL_HASTE_MODIFIER_ID = UUID.fromString("d48115ce-e4b9-422c-a418-e6ebfd2ff550");
    protected static final UUID SPELL_POWER_FROST_MODIFIER_ID = UUID.fromString("441b2252-db4b-45cd-856a-81ecd1e717bf");
    protected static final UUID SPELL_POWER_LIGHTNING_MODIFIER_ID = UUID.fromString("695091c9-cef4-4bb9-b4cf-044ed111e674");
    protected static final UUID SPELL_POWER_FIRE_MODIFIER_ID = UUID.fromString("6a0b3f36-e231-42f8-9b6e-b6489171f808");
    //protected static final UUID SPELL_POWER_ARCANE_MODIFIER_ID = UUID.fromString("66f5e13a-bb5e-49d7-94e8-9a56c5394b55");
    //protected static final UUID SPELL_POWER_HEALING_MODIFIER_ID = UUID.fromString("e0016e47-8423-473c-879d-044262748882");
    protected static final UUID SPELL_CRIT_DAMAGE_MODIFIER_ID = UUID.fromString("0510491d-1ea4-4055-8666-383b95b23dd1");
    protected static final UUID SPELL_CRIT_CHANCE_MODIFIER_ID = UUID.fromString("042b3a30-d2ad-406c-9483-b6444daa61d5");

    public static float berserker_axe_attackDamage = 6.5f;
    public static float berserker_axe_attackSpeed = -3.2f;

    public static float witcher_sword_attackDamage = 0.6f;
    public static float witcher_sword_attackSpeed = -2.0f;

    public static float knuckle_attackDamage = 0.5f;
    public static float knuckle_atackSpeed = -1.6f;


    ///Mod Weapons
    //BERSERKER AXES
    public static final Item STONE_BERSERKER_AXE =registerItem("stone_berserker_axe", new BerserkerAxeItem(ToolMaterials.STONE,
            berserker_axe_attackDamage,berserker_axe_attackSpeed ,new FabricItemSettings()));
    public static final Item IRON_BERSERKER_AXE =registerItem("iron_berserker_axe", new BerserkerAxeItem(ToolMaterials.IRON,
            berserker_axe_attackDamage,berserker_axe_attackSpeed ,new FabricItemSettings()));
    public static final Item GOLD_BERSERKER_AXE =registerItem("golden_berserker_axe", new BerserkerAxeItem(ToolMaterials.GOLD,
            berserker_axe_attackDamage, berserker_axe_attackSpeed ,new FabricItemSettings()));
    public static final Item DIAMOND_BERSERKER_AXE =registerItem("diamond_berserker_axe", new BerserkerAxeItem(ToolMaterials.DIAMOND,
            berserker_axe_attackDamage, berserker_axe_attackSpeed ,new FabricItemSettings()));
    public static final Item NETHERITE_BERSERKER_AXE =registerItem("netherite_berserker_axe", new BerserkerAxeItem(ToolMaterials.NETHERITE,
            berserker_axe_attackDamage, berserker_axe_attackSpeed ,new FabricItemSettings()));

    //WITCHER SWORDS
    public static final Item IRON_WITCHER_SWORD =registerItem("iron_witcher_sword", new WitcherSwordItem(ToolMaterials.IRON,
            witcher_sword_attackDamage, witcher_sword_attackSpeed,0.5f,0.5f,new FabricItemSettings()));
    public static final Item GOLD_WITCHER_SWORD =registerItem("golden_witcher_sword", new WitcherSwordItem(ToolMaterials.GOLD,
            witcher_sword_attackDamage, witcher_sword_attackSpeed,0.5f,0.5f,new FabricItemSettings()));
    public static final Item DIAMOND_WITCHER_SWORD =registerItem("diamond_witcher_sword", new WitcherSwordItem(ToolMaterials.DIAMOND,
            witcher_sword_attackDamage, witcher_sword_attackSpeed,1.0f,1.0f,new FabricItemSettings()));
    public static final Item NETHERITE_WITCHER_SWORD =registerItem("netherite_witcher_sword", new WitcherSwordItem(ToolMaterials.NETHERITE,
            witcher_sword_attackDamage, witcher_sword_attackSpeed,2.0f,2.0f,new FabricItemSettings()));
    public static final Item SILVER_WITCHER_SWORD =registerItem("silver_witcher_sword", new WitcherSilverSwordItem(ModToolMaterial.SILVER,
            witcher_sword_attackDamage, witcher_sword_attackSpeed,1.5f,1.5f,new FabricItemSettings()));
    public static final Item WINTER_WITCHER_SWORD =registerItem("winters_blade_sword", new WintersBladeRelicItem(ModToolMaterial.RELICT_STEEL,
            0, -2.0f, 4.0f, 0.15f, new FabricItemSettings()));
    public static final Item ULTIMATUM_WITCHER_SWORD =registerItem("ultimatum_sword", new UltimatumRelicItem(ModToolMaterial.RELICT_STEEL,
            0, -2.0f, 4.0f, 0.05f, new FabricItemSettings()));
    public static final Item AERONDIGHT_WITCHER_SWORD =registerItem("aerondight_sword", new AerondightRelictItem(ModToolMaterial.RELICT_SILVER,
            2, -2.0f, 0.20f, 0.05f, new FabricItemSettings()));

    //KNUCKLES
    public static final Item WOODEN_KNUCKLE =registerItem("wooden_knuckle", new KnuckleItem(ToolMaterials.WOOD,
            knuckle_attackDamage,knuckle_atackSpeed,0.0f, new FabricItemSettings()));
    public static final Item STONE_KNUCKLE =registerItem("stone_knuckle", new KnuckleItem(ToolMaterials.STONE,
            knuckle_attackDamage, knuckle_atackSpeed, 0.02f, new FabricItemSettings()));
    public static final Item GOLD_KNUCKLE =registerItem("golden_knuckle", new KnuckleItem(ToolMaterials.GOLD,
            knuckle_attackDamage, knuckle_atackSpeed, 0.04f, new FabricItemSettings()));
    public static final Item IRON_KNUCKLE =registerItem("iron_knuckle", new KnuckleItem(ToolMaterials.IRON,
            knuckle_attackDamage, knuckle_atackSpeed, 0.04f, new FabricItemSettings()));
    public static final Item DIAMOND_KNUCKLE =registerItem("diamond_knuckle", new KnuckleItem(ToolMaterials.DIAMOND,
            knuckle_attackDamage, knuckle_atackSpeed, 0.06f, new FabricItemSettings()));
    public static final Item NETHERITE_KNUCKLE =registerItem("netherite_knuckle", new KnuckleItem(ToolMaterials.NETHERITE,
            knuckle_attackDamage, knuckle_atackSpeed, 0.08f, new FabricItemSettings()));



    //Custom Loot
    public static final Item WOLF_FUR = registerItem("wolf_fur", new Item(new FabricItemSettings()));
    public static final Item SILVER_INGOT = registerItem("silver_ingot", new Item(new FabricItemSettings()));
    public static final Item METEORITE_SILVER_INGOT = registerItem("meteorite_silver_ingot", new Item(new FabricItemSettings()));
    public static final Item DARK_STEEL_INGOT = registerItem("dark_steel_ingot", new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(MRPGCMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        MRPGCMod.LOGGER.info("Registering Mod Items for " + MRPGCMod.MOD_ID);
    }
}
