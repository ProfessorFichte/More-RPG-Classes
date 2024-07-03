package net.more_rpg_classes.custom;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;
import net.more_rpg_classes.config.EnchantingConfig;
import net.spell_power.api.enchantment.EnchantmentRestriction;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static net.minecraft.enchantment.EnchantmentTarget.BREAKABLE;
import static net.spell_power.internals.AmplifierEnchantment.Operation.ADD;

public class Enchantment_CustomSpellSchool {
    public static final String elementalName = "elemental";
    public static final Identifier elemental = new Identifier(MRPGCMod.MOD_ID, elementalName);
    public static final CustomSchoolEnchanting ELEMENTAL = new CustomSchoolEnchanting(
            Enchantment.Rarity.COMMON,
            ADD,
            config().elemental_mastery,
            //new EnchantmentsConfig.PowerEnchantmentConfig(true, 5, 10, 9, 0.03F),
            Set.of(MoreSpellSchools.EARTH, MoreSpellSchools.AIR,MoreSpellSchools.WATER),
            BREAKABLE,
            EquipmentSlot.values())
            .requireTag(new Identifier(MRPGCMod.MOD_ID, "enchant_elemental_mastery"));


    private static EnchantingConfig config() {
        return (EnchantingConfig)MRPGCMod.enchantmentConfig.value;
    }


    public static final Map<Identifier, CustomSchoolEnchanting> all;
    static {
        all = new HashMap<>();
        all.put(elemental, ELEMENTAL);

        for(var entry: all.entrySet()) {
            var enchantment = entry.getValue();
            EnchantmentRestriction.prohibit(enchantment, itemStack -> {
                var typeMatches = enchantment.matchesRequiredTag(itemStack);
                var schoolMatches = !enchantment.requiresRelatedAttributes() || CustomSchoolEnchanting.schoolsIntersect(enchantment.poweredSchools(), itemStack);
                return !typeMatches || !schoolMatches;
            });
        }
    }

}
