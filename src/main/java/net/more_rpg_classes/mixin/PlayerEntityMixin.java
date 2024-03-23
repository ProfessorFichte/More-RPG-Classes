package net.more_rpg_classes.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.spell_power.api.MagicSchool;
import net.spell_power.api.attributes.SpellAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.more_rpg_classes.util.CustomMethods.increaseAmpByChance;
import static net.more_rpg_classes.util.CustomMethods.increaseEffectLevel;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {


    @Inject(method = "createPlayerAttributes()Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;", require = 1, allow = 1, at = @At("RETURN"))
    private static void moreEntityAttributes$addAttributes(final CallbackInfoReturnable<DefaultAttributeContainer.Builder> info) {
        info.getReturnValue().add(MRPGCEntityAttributes.INCOMING_DAMAGE_MODIFIER);
        info.getReturnValue().add(MRPGCEntityAttributes.DAMAGE_REFLECT_MODIFIER);
        info.getReturnValue().add(MRPGCEntityAttributes.ARCANE_FUSE_MODIFIER);
        info.getReturnValue().add(MRPGCEntityAttributes.LIFESTEAL_MODIFIER);
        info.getReturnValue().add(MRPGCEntityAttributes.SIGN_INTENSITY);
        info.getReturnValue().add(MRPGCEntityAttributes.RAGE_MODIFIER);
        info.getReturnValue().add(MRPGCEntityAttributes.ADRENALINE_MODIFIER);
    }




    @Inject(at = @At("HEAD"), method = "onKilledOther")
    public void mrpgc$onKilledOther(ServerWorld world, LivingEntity other, CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity)(Object)this;
        if (player instanceof ServerPlayerEntity) {
            if (player.hasStatusEffect(MRPGCEffects.SOUL_DEVOURER)) {
                if(!player.hasStatusEffect(MRPGCEffects.COLLECTED_SOUL)){
                    player.addStatusEffect(new StatusEffectInstance(MRPGCEffects.COLLECTED_SOUL,400,0,false,false,true));
                }else{
                    increaseEffectLevel(player,MRPGCEffects.COLLECTED_SOUL,400,1,20);
                }
            }
        }
    }


    @Redirect(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;getAttributeValue(Lnet/minecraft/entity/attribute/EntityAttribute;)D", ordinal = 0))
    public double modifyBaseDamage(PlayerEntity instance, EntityAttribute entityAttribute, Entity target) {
        float damage = (float) instance.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        EntityAttributeInstance adrenaline = ((LivingEntity) (Object) this).getAttributeInstance(MRPGCEntityAttributes.ADRENALINE_MODIFIER);
        int value1 = (int) adrenaline.getValue();
        EntityAttributeInstance lifesteal = ((LivingEntity) (Object) this).getAttributeInstance(MRPGCEntityAttributes.LIFESTEAL_MODIFIER);
        int value3 = (int) lifesteal.getValue();
            if ((instance instanceof ServerPlayerEntity) && (target instanceof LivingEntity)) {
                if(instance.hasStatusEffect(MRPGCEffects.RAGE)){
                    int rage_berserker_chance = 10; int rage_duration = 500; int rage_amplifier_max = 4;
                    increaseAmpByChance(instance,MRPGCEffects.RAGE,rage_duration,1,rage_amplifier_max,rage_berserker_chance);
                }if(value1 != 100){
                    value1 = value1 -100;
                    int duration_multiplier = value1 * 5;
                    if(!instance.hasStatusEffect(MRPGCEffects.ADRENALINE_GAIN)){
                        instance.addStatusEffect(new StatusEffectInstance(MRPGCEffects.ADRENALINE_GAIN,350+duration_multiplier,0,false,false,true));
                    }else{
                        int adrenaline_chance_inc = (int) Math.round((float) value1 /5);
                        increaseAmpByChance(instance,MRPGCEffects.ADRENALINE_GAIN,350+duration_multiplier,1,20+adrenaline_chance_inc,10-adrenaline_chance_inc);
                    }
                }
                if(value3 != 100){
                    value3 = value3 -100;
                    float heal = (damage * ((float) value3 /100));
                    instance.heal(heal);
                    return damage;
                }
            }
        return damage;
    }

    @ModifyArg(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"), index = 1)
    private float modifyDamage(float damage) {
        EntityAttributeInstance ragedmg = ((LivingEntity) (Object) this).getAttributeInstance(MRPGCEntityAttributes.RAGE_MODIFIER);
        int value1 = (int) ragedmg.getValue();
        EntityAttributeInstance arcanefuse = ((LivingEntity) (Object) this).getAttributeInstance(MRPGCEntityAttributes.ARCANE_FUSE_MODIFIER);
        int value2 = (int) arcanefuse.getValue();
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (value1 != 100){
            float actual_health = player.getHealth();
            return (float) (damage * (1.0F + (((1.2F + ((ragedmg.getValue()-100)/100)) * ((float) player.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH) - actual_health)) / 25)));
        }
        if(value2 != 100){
            return (float) (damage + (((arcanefuse.getValue()-100)/100) * (float) player.getAttributeValue(SpellAttributes.POWER.get(MagicSchool.ARCANE).attribute)));
        }
        return damage;
    }
}
