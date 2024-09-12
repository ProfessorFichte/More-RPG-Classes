package net.more_rpg_classes.util;

import net.minecraft.entity.LivingEntity;
import net.spell_engine.internals.WorldScheduler;

public class CustomMethods {
    public static boolean clearNegativeEffects(LivingEntity entity, boolean debuff) {
        var effects = entity.getStatusEffects();
        for (var instance : effects) {
            var effect = instance.getEffectType().value();
            if (!effect.isBeneficial()) {
                ((WorldScheduler)entity.getWorld()).schedule(1, () -> entity.removeStatusEffect(instance.getEffectType()));
            }
        }
        return debuff;
    }
}
