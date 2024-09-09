package net.more_rpg_classes.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.entry.RegistryEntry;
import net.more_rpg_classes.damage.BleedingDamageSource;

public class BleedingEffect extends StatusEffect {
    protected BleedingEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public  boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        return entity.damage(new BleedingDamageSource(entity.getDamageSources().starve().getTypeRegistryEntry()), 1.0F);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i;
        if (this == MRPGCEffects.BLEEDING.effect) {
            i = 35 >> amplifier;
            if (i > 0) {
                return duration % i == 0;
            } else {
                return true;
            }
        }
        return true;
    }

    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, amplifier);
    if(entity.isDead()){
        entity.removeStatusEffect((RegistryEntry<StatusEffect>) MRPGCEffects.BLEEDING.effect);
    }
    }
}
