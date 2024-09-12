package net.more_rpg_classes.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.more_rpg_classes.MRPGCMod;

public class FrostedEffect extends StatusEffect {
    public FrostedEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }



    public boolean applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        pLivingEntity.setFrozenTicks(pLivingEntity.getFrozenTicks() + 1);
        if(pAmplifier == MRPGCMod.effectsConfig.value.frosted_amplifier_frozen_solid_conversion){
            pLivingEntity.addStatusEffect(new StatusEffectInstance(MRPGCEffects.FROZEN_SOLID.registryEntry,100,0,false,false,true));
            pLivingEntity.removeStatusEffect(MRPGCEffects.FROSTED.registryEntry);
        }
        super.applyUpdateEffect(pLivingEntity, pAmplifier);
        return true;
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
