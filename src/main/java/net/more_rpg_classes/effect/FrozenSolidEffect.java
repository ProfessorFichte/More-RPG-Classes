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
        if(pLivingEntity.isOnFire()){
            pLivingEntity.removeStatusEffect(MRPGCEffects.FROZEN_SOLID);
        } else if (pLivingEntity.isInLava()) {
            pLivingEntity.removeStatusEffect(MRPGCEffects.FROZEN_SOLID);
        }
        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if(entity.isOnFire()){

        } else if (entity.isInLava()) {

        } else {
            entity.damage(entity.getDamageSources().freeze(), 6.0f);
        }
        super.onRemoved(entity, attributes, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
