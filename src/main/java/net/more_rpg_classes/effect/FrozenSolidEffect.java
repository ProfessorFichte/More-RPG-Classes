package net.more_rpg_classes.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class FrozenSolidEffect extends StatusEffect {

    public FrozenSolidEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        pLivingEntity.setFrozenTicks(pLivingEntity.getFrozenTicks() + 1);
        if(pLivingEntity.isOnFire()){
            pLivingEntity.removeStatusEffect(MRPGCEffects.FROZEN_SOLID);
        } else if (pLivingEntity.isInLava()) {
            pLivingEntity.removeStatusEffect(MRPGCEffects.FROZEN_SOLID);
        }
        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        entity.setFrozenTicks(entity.getFrozenTicks() + 40);
    }
    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        entity.setFrozenTicks(entity.getFrozenTicks() + 200);
    }
}
