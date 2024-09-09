package net.more_rpg_classes.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.entry.RegistryEntry;

public class FrozenSolidEffect extends StatusEffect {

    public FrozenSolidEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        pLivingEntity.setFrozenTicks(pLivingEntity.getFrozenTicks() + 1);
        if(pLivingEntity.isOnFire()){
           return pLivingEntity.removeStatusEffect((RegistryEntry<StatusEffect>) MRPGCEffects.FROZEN_SOLID);
        } else if (pLivingEntity.isInLava()) {
            return pLivingEntity.removeStatusEffect((RegistryEntry<StatusEffect>) MRPGCEffects.FROZEN_SOLID);
        }
        super.applyUpdateEffect(pLivingEntity, pAmplifier);
        return false;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }


    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        entity.setFrozenTicks(entity.getFrozenTicks() + 40);
    }

    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        entity.setFrozenTicks(entity.getFrozenTicks() + 200);
    }
}
