package net.fichte.more_rpg_classes.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

public class CustomMethods {

    public static void increaseAmpAndDuration(
            LivingEntity livingEntity, StatusEffect statusEffect, int duration, int amplifier, int max_amp, int durationinc) {

        if (livingEntity.hasStatusEffect(statusEffect)) {
            int currentAmplifier = livingEntity.getStatusEffect(statusEffect).getAmplifier();

            if (currentAmplifier >= max_amp) { livingEntity.addStatusEffect(
                    new StatusEffectInstance(statusEffect, duration, currentAmplifier));
                return;
            }

            livingEntity.addStatusEffect(new StatusEffectInstance(
                    statusEffect, duration + durationinc, currentAmplifier + amplifier));
        }
        livingEntity.addStatusEffect(new StatusEffectInstance(
                statusEffect, duration));
    }

}
