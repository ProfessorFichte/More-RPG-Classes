package net.more_rpg_classes.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class FrozenSolidEffect extends StatusEffect {

    public FrozenSolidEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        pLivingEntity.setFrozenTicks(pLivingEntity.getFrozenTicks() + 1);
        if(pLivingEntity.isOnFire()){
           return pLivingEntity.removeStatusEffect(MRPGCEffects.FROZEN_SOLID.registryEntry);
        } else if (pLivingEntity.isInLava()) {
            return pLivingEntity.removeStatusEffect(MRPGCEffects.FROZEN_SOLID.registryEntry);
        }
        super.applyUpdateEffect(pLivingEntity, pAmplifier);
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    public static void onRemove(LivingEntity entity) {
        entity.setFrozenTicks(entity.getFrozenTicks() + 100);
    }
}
