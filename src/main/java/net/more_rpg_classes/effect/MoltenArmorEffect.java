package net.more_rpg_classes.effect;

import net.more_rpg_classes.damage.MoltenDamageSource;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class MoltenArmorEffect extends StatusEffect {
    public MoltenArmorEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.getWorld().isClient()) {
            pLivingEntity.damage(new MoltenDamageSource(pLivingEntity.getDamageSources().lava().getTypeRegistryEntry()), 0.5F);
        }
        if(!pLivingEntity.getWorld().isClient()){
            if(pLivingEntity.isInsideWaterOrBubbleColumn()){
                pLivingEntity.removeStatusEffect(MRPGCEffects.MOLTEN_ARMOR);
            }
        }
        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        entity.sendEquipmentBreakStatus(EquipmentSlot.HEAD);
        entity.sendEquipmentBreakStatus(EquipmentSlot.CHEST);
        entity.sendEquipmentBreakStatus(EquipmentSlot.LEGS);
        entity.sendEquipmentBreakStatus(EquipmentSlot.FEET);
        super.onRemoved(entity, attributes, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}