package net.more_rpg_classes.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.spell_engine.api.item.weapon.SpellSwordItem;
import net.spell_power.api.MagicSchool;
import net.spell_power.api.attributes.EntityAttributes_SpellPower;

import static net.more_rpg_classes.item.MRPGCItems.*;

public class UltimatumRelicItem extends SpellSwordItem {

    private final float attackDamage;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;


    public UltimatumRelicItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, float fire, float critchance, Item.Settings settings) {
        super(toolMaterial, settings);
        this.attackDamage = (float) attackDamage + toolMaterial.getAttackDamage();
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
                "Weapon modifier", (double) this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
                "Weapon modifier", (double) attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes_SpellPower.POWER.get(MagicSchool.FIRE), new EntityAttributeModifier(SPELL_POWER_FROST_MODIFIER_ID,
                "Weapon modifier", fire, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes_SpellPower.CRITICAL_CHANCE, new EntityAttributeModifier(SPELL_CRIT_CHANCE_MODIFIER_ID,
                "Weapon modifier", critchance, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));

        this.attributeModifiers = builder.build();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int fire_duration = 4;
        int fire_chance = 40;
        int randomrange_fire = (int) ((Math.random() * (1 + fire_chance)) + 1);

        if (randomrange_fire >= fire_duration ) {
            target.setOnFireFor(5);
        }
        stack.damage(1, attacker, (e)->{
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }


    public float getAttackDamage() {
        return this.attackDamage;
    }


    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            return this.attributeModifiers;
        }
        return super.getAttributeModifiers(slot);
    }


}
