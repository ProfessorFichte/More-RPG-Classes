package net.more_rpg_classes.mixin;


import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow
    @Nullable
    protected PlayerEntity attackingPlayer;

    @Inject(method = "createLivingAttributes()Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;",
            require = 1, allow = 1, at = @At("RETURN"))
    private static void moreAdditionalEntityAttributes$addAttributes
            (CallbackInfoReturnable<DefaultAttributeContainer.Builder> info){
        info.getReturnValue().add(MRPGCEntityAttributes.INCOMING_DAMAGE_MODIFIER);
    }


    @ModifyVariable(method = "modifyAppliedDamage", at = @At(value ="LOAD", ordinal = 4), argsOnly = true)
    private float moreAdditionalEntityAttributes$increaseMobDamage(float damage, DamageSource source){
        EntityAttributeInstance dmgInc = ((LivingEntity) (Object) this)
                .getAttributeInstance(MRPGCEntityAttributes.INCOMING_DAMAGE_MODIFIER);

        if(dmgInc == null){
            return damage;
        }
        if(source.isOf(DamageTypes.MOB_ATTACK) && dmgInc.getValue() > 0){
            damage = (float) Math.max(damage + dmgInc.getValue(), 0);
        }
        if(source.isOf(DamageTypes.MAGIC) && dmgInc.getValue() > 0){
            damage = (float) Math.max(damage + dmgInc.getValue(), 0);
        }
        if(source.isOf(DamageTypes.TRIDENT) && dmgInc.getValue() > 0){
            damage = (float) Math.max(damage + dmgInc.getValue(), 0);
        }
        if(source.isOf(DamageTypes.ARROW) && dmgInc.getValue() > 0){
            damage = (float) Math.max(damage + dmgInc.getValue(), 0);
        }
        if(source.isOf(DamageTypes.MOB_ATTACK_NO_AGGRO) && dmgInc.getValue() > 0){
            damage = (float) Math.max(damage + dmgInc.getValue(), 0);
        }
        if(source.isOf(DamageTypes.MOB_PROJECTILE) && dmgInc.getValue() > 0){
            damage = (float) Math.max(damage + dmgInc.getValue(), 0);
        }
        if(source.isOf(DamageTypes.PLAYER_ATTACK) && dmgInc.getValue() > 0){
            damage = (float) Math.max(damage + dmgInc.getValue(), 0);
        }
        return damage;
    }
}
