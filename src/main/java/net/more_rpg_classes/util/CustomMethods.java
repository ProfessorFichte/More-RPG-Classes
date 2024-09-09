package net.more_rpg_classes.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.List;

public class CustomMethods {

    public static void increaseAmpByChance(
            LivingEntity entity, StatusEffect statusEffect, int duration, int amplifier, int max_amp, int chance) {
        int roll = (int) ((Math.random() * (1 + chance)) + 1);
        if (roll >= chance)    {
            if (entity.hasStatusEffect((RegistryEntry<StatusEffect>) statusEffect)) {
                int currentAmplifier = entity.getStatusEffect((RegistryEntry<StatusEffect>) statusEffect).getAmplifier();
                if (currentAmplifier >= max_amp) {
                    entity.addStatusEffect(new StatusEffectInstance((RegistryEntry<StatusEffect>) statusEffect, duration, currentAmplifier, false, false, true));
                    return;
                }
                entity.addStatusEffect(new StatusEffectInstance((RegistryEntry<StatusEffect>) statusEffect, duration, currentAmplifier + amplifier, false, false, true));
            }
            entity.addStatusEffect(new StatusEffectInstance((RegistryEntry<StatusEffect>) statusEffect, duration, amplifier, false,false, true ));
    }
    }
    public static void increaseHiddenAmpByChance(
            LivingEntity entity, StatusEffect statusEffect, int duration, int amplifier, int max_amp, int chance) {
        int roll = (int) ((Math.random() * (1 + chance)) + 1);
        if (roll >= chance)    {
            if (entity.hasStatusEffect((RegistryEntry<StatusEffect>) statusEffect)) {
                int currentAmplifier = entity.getStatusEffect((RegistryEntry<StatusEffect>) statusEffect).getAmplifier();
                int currentDuration= entity.getStatusEffect((RegistryEntry<StatusEffect>) statusEffect).getDuration();
                if (currentAmplifier >= max_amp) {
                    entity.addStatusEffect(new StatusEffectInstance((RegistryEntry<StatusEffect>) statusEffect, currentDuration, currentAmplifier, false, false, false));
                    return;
                }
                entity.addStatusEffect(new StatusEffectInstance((RegistryEntry<StatusEffect>) statusEffect, currentDuration, currentAmplifier + amplifier, false, false, false));
            }
            entity.addStatusEffect(new StatusEffectInstance((RegistryEntry<StatusEffect>) statusEffect, duration, amplifier, false,false, false ));
        }
    }

    public static void decreaseAmpByChance(
            LivingEntity entity, StatusEffect statusEffect, int removedampstack, int chance) {
        int roll = (int) ((Math.random() * (1 + chance)) + 1);
        if (roll >= chance){
            if (entity.hasStatusEffect((RegistryEntry<StatusEffect>) statusEffect)){
                int currentAmp = entity.getStatusEffect((RegistryEntry<StatusEffect>) statusEffect).getAmplifier();
                int Duration = entity.getStatusEffect((RegistryEntry<StatusEffect>) statusEffect).getDuration();
                if (currentAmp < 1 ) {
                    entity.removeStatusEffect((RegistryEntry<StatusEffect>) statusEffect);
                    return;
                }
                entity.removeStatusEffect((RegistryEntry<StatusEffect>) statusEffect);
                entity.addStatusEffect(new StatusEffectInstance(
                        (RegistryEntry<StatusEffect>) statusEffect, Duration, currentAmp - removedampstack, false, false, true));
            }
        }
    }

    public static void decreaseAmp(
            LivingEntity entity, StatusEffect statusEffect, int removedampstack) {
            if (entity.hasStatusEffect((RegistryEntry<StatusEffect>) statusEffect)){
                int currentAmp = entity.getStatusEffect((RegistryEntry<StatusEffect>) statusEffect).getAmplifier();
                int Duration = entity.getStatusEffect((RegistryEntry<StatusEffect>) statusEffect).getDuration();
                if (currentAmp < 1 ) {
                    entity.removeStatusEffect((RegistryEntry<StatusEffect>) statusEffect);
                    return;
                }
                entity.removeStatusEffect((RegistryEntry<StatusEffect>) statusEffect);
                entity.addStatusEffect(new StatusEffectInstance(
                        (RegistryEntry<StatusEffect>) statusEffect, Duration, currentAmp - removedampstack, false, false, true));
            }
    }

    public static void increaseEffectLevel(LivingEntity entity, StatusEffect statusEffect, int duration, int amplifier, int amplifierMax) {
        if (entity.hasStatusEffect((RegistryEntry<StatusEffect>) statusEffect)) {
            int currentAmplifier = entity.getStatusEffect((RegistryEntry<StatusEffect>) statusEffect).getAmplifier();
            if (currentAmplifier >= amplifierMax) {
                entity.addStatusEffect(new StatusEffectInstance((RegistryEntry<StatusEffect>) statusEffect, duration, currentAmplifier, false, false, true));
                return;
            }
            entity.addStatusEffect(new StatusEffectInstance((RegistryEntry<StatusEffect>) statusEffect, duration, currentAmplifier + amplifier, false, false, true));
        }
        entity.addStatusEffect(new StatusEffectInstance((RegistryEntry<StatusEffect>) statusEffect, duration, amplifier, false,false, true ));
    }
    public static void increaseHiddenEffectLevel(LivingEntity entity, StatusEffect statusEffect, int duration, int amplifier, int amplifierMax) {
        if (entity.hasStatusEffect((RegistryEntry<StatusEffect>) statusEffect)) {
            int currentAmplifier = entity.getStatusEffect((RegistryEntry<StatusEffect>) statusEffect).getAmplifier();
            if (currentAmplifier >= amplifierMax) {
                entity.addStatusEffect(new StatusEffectInstance((RegistryEntry<StatusEffect>) statusEffect, duration, currentAmplifier, false, false, false));
                return;
            }
            entity.addStatusEffect(new StatusEffectInstance((RegistryEntry<StatusEffect>) statusEffect, duration, currentAmplifier + amplifier, false, false, false));
        }
        entity.addStatusEffect(new StatusEffectInstance((RegistryEntry<StatusEffect>) statusEffect, duration, amplifier, false,false, false ));
    }

    public static void decreaseEffectLevel(LivingEntity entity, StatusEffect statusEffect, int amplifier) {
        if (entity.hasStatusEffect((RegistryEntry<StatusEffect>) statusEffect)) {
            int currentAmplifier = entity.getStatusEffect((RegistryEntry<StatusEffect>) statusEffect).getAmplifier();
            int currentDuration = entity.getStatusEffect((RegistryEntry<StatusEffect>) statusEffect).getDuration();
            if (currentAmplifier < 1 ) {
                entity.removeStatusEffect((RegistryEntry<StatusEffect>) statusEffect);
                return;
            }
            entity.removeStatusEffect((RegistryEntry<StatusEffect>) statusEffect);
            entity.addStatusEffect(new StatusEffectInstance((RegistryEntry<StatusEffect>) statusEffect, currentDuration, currentAmplifier - amplifier, false, false, true));
        }
    }

    public static boolean clearNegativeEffects(LivingEntity entity, boolean debuff) {
        List<StatusEffectInstance> list = entity.getStatusEffects().stream().toList();
        if (list.isEmpty())
            return false;
        for (StatusEffectInstance statusEffectInstance : list) {
            StatusEffect statusEffect = (StatusEffect) statusEffectInstance.getEffectType();
            if (!statusEffect.isBeneficial() && debuff) {
                entity.removeStatusEffect((RegistryEntry<StatusEffect>) statusEffect);
            }
        }
        return true;
    }
}
