package net.more_rpg_classes.item.armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;
import net.more_rpg_classes.MRPGCMod;
import net.more_rpg_classes.item.MRPGCGroup;
import net.more_rpg_classes.item.MRPGCItems;
import net.spell_engine.api.item.ItemConfig;
import net.spell_engine.api.item.armor.Armor;
import net.spell_power.api.MagicSchool;
import net.spell_power.api.attributes.SpellAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Armors {
    private static final Supplier<Ingredient> ORIENE_INGREDIENTS = () -> Ingredient.ofItems(
            Items.WHITE_WOOL, Items.ORANGE_WOOL, Items.MAGENTA_WOOL, Items.LIGHT_BLUE_WOOL, Items.YELLOW_WOOL,
            Items.LIME_WOOL, Items.PINK_WOOL, Items.GRAY_WOOL, Items.LIGHT_GRAY_WOOL, Items.CYAN_WOOL, Items.PURPLE_WOOL,
            Items.BLUE_WOOL, Items.BROWN_WOOL, Items.GREEN_WOOL, Items.RED_WOOL, Items.BLACK_WOOL, Items.LEATHER
    );
    private static final Supplier<Ingredient> PHASLEB_INGREDIENTS = () -> Ingredient.ofItems(
            Items.LEATHER, Items.GOLD_INGOT, Items.AMETHYST_SHARD
    );
    private static final Supplier<Ingredient> WILDLING_INGREDIENTS = () -> Ingredient.ofItems(
            Items.LEATHER, Items.CHAIN, MRPGCItems.WOLF_FUR
    );
    private static final Supplier<Ingredient> NORTHLING_INGREDIENTS = () -> Ingredient.ofItems(
            Items.IRON_INGOT, Items.CHAIN, MRPGCItems.WOLF_FUR
    );


    private static final float orieneRobeSpellPower = 1.5F;
    private static final float orieneHaste = 0.025F;
    private static final float phaslebRobeSpellPower = 0.15F;
    private static final float phaslebHaste = 0.05F;
    private static final float wildlingSpellChance = 0.01F;
    private static final float northlingSpellChance = 0.03F;
    private static final float adeptSpellPower = 0.5F;
    private static final float witcherSpellPower = 1.0F;
    private static final float adeptSuitCritDmg = 0.05F;
    private static final float witcherSuitCritDmg = 0.1F;



    public static final ArrayList<Armor.Entry> entries = new ArrayList<>();
    private static Armor.Entry create(Armor.CustomMaterial material, ItemConfig.ArmorSet defaults) {
        return new Armor.Entry(material, null, defaults);
    }


    public static final Armor.Set orieneArmorSet =
            create(
                    new Armor.CustomMaterial(
                            "oriene",
                            10,
                            9,
                            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                            ORIENE_INGREDIENTS
                    ),
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellAttributes.HASTE, orieneHaste)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.bonus(SpellAttributes.POWER.get(MagicSchool.ARCANE), orieneRobeSpellPower),
                                            ItemConfig.Attribute.multiply(SpellAttributes.HASTE, orieneHaste)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellAttributes.HASTE, orieneHaste)
                                    )),
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellAttributes.HASTE, orieneHaste)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(MRPGCMod.MOD_ID,
                            new OrieneArmor(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new OrieneArmor(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new OrieneArmor(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new OrieneArmor(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet().allowSpellPowerEnchanting(true);

    public static final Armor.Set phaslebArmorSet =
            create(
                    new Armor.CustomMaterial(
                            "phasleb",
                            20,
                            11,
                            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                            PHASLEB_INGREDIENTS
                    ),
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellAttributes.HASTE, phaslebHaste),
                                            ItemConfig.Attribute.multiply(SpellAttributes.POWER.get(MagicSchool.ARCANE), phaslebRobeSpellPower)
                                    )),
                            new ItemConfig.ArmorSet.Piece(4)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellAttributes.HASTE, phaslebHaste),
                                            ItemConfig.Attribute.multiply(SpellAttributes.POWER.get(MagicSchool.ARCANE), phaslebRobeSpellPower)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellAttributes.HASTE, phaslebHaste),
                                            ItemConfig.Attribute.multiply(SpellAttributes.POWER.get(MagicSchool.ARCANE), phaslebRobeSpellPower)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellAttributes.HASTE, phaslebHaste),
                                            ItemConfig.Attribute.multiply(SpellAttributes.POWER.get(MagicSchool.ARCANE), phaslebRobeSpellPower)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(MRPGCMod.MOD_ID,
                            new PhaslebArmor(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new PhaslebArmor(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new PhaslebArmor(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new PhaslebArmor(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet().allowSpellPowerEnchanting(true);

    public static final Armor.Set wildlingArmorSet =
            create(
                    new Armor.CustomMaterial(
                            "wildling",
                            10,
                            9,
                            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                            WILDLING_INGREDIENTS
                    ),
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_CHANCE, wildlingSpellChance)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_CHANCE, wildlingSpellChance)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_CHANCE, wildlingSpellChance)
                                    )),
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_CHANCE, wildlingSpellChance)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(MRPGCMod.MOD_ID,
                            new WildlingArmor(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new WildlingArmor(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new WildlingArmor(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new WildlingArmor(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet()
                    .allowSpellPowerEnchanting(false);

    public static final Armor.Set northlingArmorSet =
            create(
                    new Armor.CustomMaterial(
                            "northling",
                            20,
                            10,
                            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                            NORTHLING_INGREDIENTS
                    ),
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_CHANCE, northlingSpellChance)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_CHANCE, northlingSpellChance)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_CHANCE, northlingSpellChance)
                                    )),
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_CHANCE, northlingSpellChance)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(MRPGCMod.MOD_ID,
                            new NorthlingArmor(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new NorthlingArmor(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new NorthlingArmor(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new NorthlingArmor(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet()
                    .allowSpellPowerEnchanting(false);

    public static final Armor.Set adeptArmorSet =
            create(
                    new Armor.CustomMaterial(
                            "adept",
                            10,
                            9,
                            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                            NORTHLING_INGREDIENTS
                    ),
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_DAMAGE, adeptSuitCritDmg)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                    )),
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(MRPGCMod.MOD_ID,
                            new AdeptArmor(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new AdeptArmor(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new AdeptArmor(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new AdeptArmor(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet()
                    .allowSpellPowerEnchanting(true);

    public static final Armor.Set witcherArmorSet =
            create(
                    new Armor.CustomMaterial(
                            "witcher",
                            20,
                            10,
                            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                            NORTHLING_INGREDIENTS
                    ),
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                    )),
                            new ItemConfig.ArmorSet.Piece(4)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellAttributes.CRITICAL_DAMAGE, witcherSuitCritDmg)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(MRPGCMod.MOD_ID,
                            new WitcherArmor(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new WitcherArmor(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new WitcherArmor(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new WitcherArmor(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet()
                    .allowSpellPowerEnchanting(true);


    public static void register(Map<String, ItemConfig.ArmorSet> configs) {
        Armor.register(configs, entries, MRPGCGroup.KEY);
    }
}