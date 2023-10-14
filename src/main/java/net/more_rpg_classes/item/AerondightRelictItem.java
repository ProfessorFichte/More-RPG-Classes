package net.more_rpg_classes.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.spell_engine.api.item.weapon.SpellSwordItem;
import net.spell_power.api.attributes.EntityAttributes_SpellPower;

import static net.more_rpg_classes.item.MRPGCItems.SPELL_CRIT_CHANCE_MODIFIER_ID;
import static net.more_rpg_classes.util.CustomMethods.increaseAmpAndDuration;

public class AerondightRelictItem extends SpellSwordItem {

    private final float attackDamage;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;


    public AerondightRelictItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, float critdamage, float critchance, Item.Settings settings) {
        super(toolMaterial, settings);
        this.attackDamage = (float) attackDamage + toolMaterial.getAttackDamage();
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
                "Weapon modifier", (double) this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
                "Weapon modifier", (double) attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes_SpellPower.CRITICAL_DAMAGE, new EntityAttributeModifier(SPELL_CRIT_CHANCE_MODIFIER_ID,
                "Weapon modifier", critdamage, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        builder.put(EntityAttributes_SpellPower.CRITICAL_CHANCE, new EntityAttributeModifier(SPELL_CRIT_CHANCE_MODIFIER_ID,
                "Weapon modifier", critchance, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        this.attributeModifiers = builder.build();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        PlayerEntity player = (PlayerEntity) attacker;
        int charge_duration = 400;
        int charge_duration_inc = 200;
        int charge_amplifier_max = 10;
        int charge_incamp =1;

        if(target.isUndead()){
            target.damage(target.getDamageSources().magic(), 2.0f);
            player.addEnchantedHitParticles(player);
        }

        increaseAmpAndDuration(player, MRPGCEffects.AERONDIGHT_CHARGE, charge_duration, charge_incamp, charge_amplifier_max, charge_duration_inc);
            int currentAmplifier = player.getStatusEffect(MRPGCEffects.AERONDIGHT_CHARGE).getAmplifier();
            if(currentAmplifier == charge_amplifier_max){
                target.damage(target.getDamageSources().magic(), 10.0f);
                player.removeStatusEffect(MRPGCEffects.AERONDIGHT_CHARGE);
                player.addEnchantedHitParticles(player);
                player.addCritParticles(target);
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