package net.more_rpg_classes.effect;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.more_rpg_classes.damage.MoltenDamageSource;

public class MoltenArmorEffect extends StatusEffect {
    public float damage_onearmor_piece = 0.5f;
    public float damage_fullarmor = 1.5f;

    public MoltenArmorEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    public boolean applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.getWorld().isClient()) {
            if(pLivingEntity.hasStackEquipped(EquipmentSlot.CHEST)& pLivingEntity.hasStackEquipped(EquipmentSlot.HEAD)&
                    pLivingEntity.hasStackEquipped(EquipmentSlot.FEET)& pLivingEntity.hasStackEquipped(EquipmentSlot.LEGS)){
                return  pLivingEntity.damage(new MoltenDamageSource(pLivingEntity.getDamageSources().lava().getTypeRegistryEntry()), damage_fullarmor);
            }
            else if(pLivingEntity.hasStackEquipped(EquipmentSlot.CHEST)){
                return   pLivingEntity.damage(new MoltenDamageSource(pLivingEntity.getDamageSources().lava().getTypeRegistryEntry()), damage_onearmor_piece);
            }
            else if(pLivingEntity.hasStackEquipped(EquipmentSlot.HEAD)){
                return pLivingEntity.damage(new MoltenDamageSource(pLivingEntity.getDamageSources().lava().getTypeRegistryEntry()), damage_onearmor_piece);
            }
            else if(pLivingEntity.hasStackEquipped(EquipmentSlot.FEET)){
                return  pLivingEntity.damage(new MoltenDamageSource(pLivingEntity.getDamageSources().lava().getTypeRegistryEntry()), damage_onearmor_piece);
            }
            else if(pLivingEntity.hasStackEquipped(EquipmentSlot.LEGS)){
                return pLivingEntity.damage(new MoltenDamageSource(pLivingEntity.getDamageSources().lava().getTypeRegistryEntry()), damage_onearmor_piece);
            }
        }
        if(!pLivingEntity.getWorld().isClient()){
            if(pLivingEntity.isInsideWaterOrBubbleColumn()){
                pLivingEntity.removeStatusEffect(MRPGCEffects.MOLTEN_ARMOR.registryEntry);
            } else if(!pLivingEntity.hasStackEquipped(EquipmentSlot.CHEST)& !pLivingEntity.hasStackEquipped(EquipmentSlot.HEAD)&
                    !pLivingEntity.hasStackEquipped(EquipmentSlot.FEET)& !pLivingEntity.hasStackEquipped(EquipmentSlot.LEGS)){
                pLivingEntity.removeStatusEffect(MRPGCEffects.MOLTEN_ARMOR.registryEntry);
            }
        }
        super.applyUpdateEffect(pLivingEntity, pAmplifier);
        return true;
    }


    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}