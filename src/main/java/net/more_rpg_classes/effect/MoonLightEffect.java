package net.more_rpg_classes.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class MoonLightEffect extends StatusEffect {
    public MoonLightEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        /*if (!pLivingEntity.getWorld().isClient()) {
            pLivingEntity.damage(pLivingEntity.getDamageSources().magic(), 0.5f);
        }*/
        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

}
