package net.more_rpg_classes.mixin;


import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "createLivingAttributes()Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;",
            require = 1, allow = 1, at = @At("RETURN"))
    private static void moreEntityAttributes$addAttributes
            (CallbackInfoReturnable<DefaultAttributeContainer.Builder> info){
        info.getReturnValue().add(MRPGCEntityAttributes.INCOMING_DAMAGE_MODIFIER);
        info.getReturnValue().add(MRPGCEntityAttributes.DAMAGE_REFLECT_MODIFIER);
        info.getReturnValue().add(MRPGCEntityAttributes.ARCANE_FUSE_MODIFIER);
        info.getReturnValue().add(MRPGCEntityAttributes.LIFESTEAL_MODIFIER);
        info.getReturnValue().add(MRPGCEntityAttributes.SIGN_INTENSITY);
        info.getReturnValue().add(MRPGCEntityAttributes.RAGE_MODIFIER);
        info.getReturnValue().add(MRPGCEntityAttributes.ADRENALINE_MODIFIER);
        info.getReturnValue().add(MRPGCEntityAttributes.INCOMING_DAMAGE_REDUCTION);
    }


    @ModifyVariable(method = "modifyAppliedDamage", at = @At(value ="LOAD", ordinal = 4), argsOnly = true)
    private float Modify$MobDamage(float damage, DamageSource source){
        EntityAttributeInstance dmgInc = ((LivingEntity) (Object) this)
                .getAttributeInstance(MRPGCEntityAttributes.INCOMING_DAMAGE_MODIFIER);
        int value1 = (int) dmgInc.getValue();
        EntityAttributeInstance dmgDec = ((LivingEntity) (Object) this)
                .getAttributeInstance(MRPGCEntityAttributes.INCOMING_DAMAGE_REDUCTION);
        int value2 = (int) dmgDec.getValue();

        if(value1 != 100){
            value1 = value1 -100;
            return damage + (damage * ((float) value1 /100));
        }if(value2 != 100){
            value2 = value2 -100;
            return damage - (damage * ((float) value2 /100));
        }
        return damage;
    }


    @Inject(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;applyDamage(Lnet/minecraft/entity/damage/DamageSource;F)V"))
    private void applyBeforeDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        EntityAttributeInstance dmgReflect = ((LivingEntity) (Object) this)
                .getAttributeInstance(MRPGCEntityAttributes.DAMAGE_REFLECT_MODIFIER);
        int value1 = (int) dmgReflect.getValue();
        float reflectDamage = 0;
        if (value1 != 100) {
            value1 = value1 -100;
            reflectDamage += reflectMethod(value1, source, amount);
        }
        if (reflectDamage > 0) {
            source.getAttacker().damage(source.getAttacker().getDamageSources().thorns((PlayerEntity) (Object) this), reflectDamage);
        }
    }




    @Unique
    private float reflectMethod(int reflectamount, DamageSource source, float damage) {
        if (reflectamount != 0) {
            Entity attacker = source.getAttacker();
            if (attacker instanceof LivingEntity && !attacker.getWorld().isClient) {
                return damage * ((float) reflectamount / 100);
            }
        }
        return 0;
    }
}
