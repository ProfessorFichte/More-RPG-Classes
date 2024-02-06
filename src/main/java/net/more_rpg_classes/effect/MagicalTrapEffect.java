package net.more_rpg_classes.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.more_rpg_classes.damage.MagicalTrapDamageSource;

public class MagicalTrapEffect extends StatusEffect {

    public MagicalTrapEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity.isUndead()){
            pLivingEntity.damage(new MagicalTrapDamageSource(pLivingEntity.getDamageSources().magic().getTypeRegistryEntry()), 1.0F);
            pLivingEntity.setMovementSpeed(0.0F);
        }else{
            pLivingEntity.setMovementSpeed(75.0F);
        }
        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}