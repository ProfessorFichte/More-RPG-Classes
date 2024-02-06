package net.more_rpg_classes.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.spell_power.api.MagicSchool;
import net.spell_power.api.SpellPower;

public class QuenEffect extends StatusEffect {
    public int quen_shield_amount = 4;
    public float lightningpower_amount = 0.5F;
    MagicSchool actualSchool = MagicSchool.LIGHTNING;

    protected QuenEffect(StatusEffectCategory statusEffectCategory, int i) {
        super(statusEffectCategory, i);
    }


    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        SpellPower.Result power = SpellPower.getSpellPower(actualSchool, entity);
        double amount = lightningpower_amount * power.baseValue();
        entity.setAbsorptionAmount(entity.getAbsorptionAmount() - (float)((quen_shield_amount + amount) * (amplifier + 1)));
        super.onRemoved(entity, attributes, amplifier);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        SpellPower.Result power = SpellPower.getSpellPower(actualSchool, entity);
        double amount = lightningpower_amount * power.baseValue();
        entity.setAbsorptionAmount(entity.getAbsorptionAmount() + (float)((quen_shield_amount + amount) * (amplifier + 1)));
        super.onApplied(entity, attributes, amplifier);
    }
}
