package net.more_rpg_classes.custom;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.config.PowerEnchantingConfig;
import net.spell_power.api.SpellSchool;
import net.spell_power.api.enchantment.SpellPowerEnchanting;
import net.spell_power.internals.AmplifierEnchantment;

import java.util.Iterator;
import java.util.Set;

public class CustomSchoolEnchanting extends AmplifierEnchantment {
    private Set<SpellSchool> schools;

    public Set<SpellSchool> poweredSchools() {
        return this.schools;
    }

    public void setPoweredSchools(Set<SpellSchool> schools) {
        this.schools = schools;
    }

    public CustomSchoolEnchanting(Rarity weight, AmplifierEnchantment.Operation operation, PowerEnchantingConfig config, Set<SpellSchool> schools, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, operation, config, type, slotTypes);
        this.schools = schools;
    }

    public CustomSchoolEnchanting requireTag(Identifier tagId) {
        this.tagId = tagId;
        return this;
    }

    protected boolean method_8180(Enchantment other) {
        return !(other instanceof CustomSchoolEnchanting) && super.canAccept(other);
    }

    public boolean requiresRelatedAttributes() {
        return ((PowerEnchantingConfig)this.config).requires_related_attributes;
    }

    public static boolean schoolsIntersect(Set<SpellSchool> schools, ItemStack stack) {
        Set<SpellSchool> itemStackSchools = SpellPowerEnchanting.relevantSchools(stack);
        Iterator var3 = itemStackSchools.iterator();

        SpellSchool school;
        do {
            if (!var3.hasNext()) {
                return false;
            }

            school = (SpellSchool)var3.next();
        } while(!schools.contains(school));

        return true;
    }
}