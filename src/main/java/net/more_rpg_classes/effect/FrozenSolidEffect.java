package net.more_rpg_classes.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;

import java.util.List;

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
        if (entity.isInLava() || entity.isOnFire() ) {

        } else{
            int damage_freeze_chance = 10;
            int ice_shard_chance1 = 6;
            int ice_shard_chance2 = 9;
            int randomrange_freeze = (int) ((Math.random() * (1 + damage_freeze_chance)) + 1);
            if (damage_freeze_chance ==  randomrange_freeze){
                entity.damage(entity.getDamageSources().freeze(), 20.0f);
            } else if (randomrange_freeze >= ice_shard_chance1 && randomrange_freeze <= ice_shard_chance2){
                entity.getWorld().addParticle(ParticleTypes.SNOWFLAKE, true,entity.getX(),entity.getY(),entity.getZ(),1,1,1);
                List<Entity> entities = entity.getWorld().getOtherEntities(entity, entity.getBoundingBox().expand(3.0D), e -> e instanceof LivingEntity);
                for (Entity e : entities) {
                    if (e instanceof LivingEntity && (e.distanceTo(entity) <= 3.0D)) {
                        ((LivingEntity) e).damage(entity.getDamageSources().freeze(), 5.0f);
                    }
                }
            }
        }
        super.onRemoved(entity, attributes, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
