package net.more_rpg_classes.mixin;

import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.spell_power.api.SpellSchools;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

import static net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes.SIGN_INTENSITY;

@Mixin(value = AttributeContainer.class)
public class AttributeMixin {
    @Final @Shadow
    private Map<EntityAttribute, EntityAttributeInstance> custom;
    @Final @Shadow
    private DefaultAttributeContainer fallback;

    @Inject(at = @At("HEAD"), method = "getValue", cancellable = true)
    private void getAttributeValueArcaneSign(EntityAttribute attribute, CallbackInfoReturnable<Double> info) {
        if(attribute == SpellSchools.ARCANE.attribute){
            EntityAttributeInstance signamount = this.custom.get(SIGN_INTENSITY);
            double value1 = 0;
            if(signamount != null) {
                value1 = signamount.getValue();
            }
            double sign = value1;
            EntityAttributeInstance addedsign = this.custom.get(SIGN_INTENSITY);
            if(signamount != null) {
                addedsign.getValue();
            }
            EntityAttributeInstance arcaneinstance = this.custom.get(SpellSchools.ARCANE.attribute);
            double total = this.fallback.getValue(SpellSchools.ARCANE.attribute);
            if(arcaneinstance != null){
                total = arcaneinstance.getValue();
            }
            if( sign > 0 && attribute == SpellSchools.ARCANE.attribute){
                total += sign;
            }
            if(sign > 0){
                info.setReturnValue(total);
            }
        }
    }
    @Inject(at = @At("HEAD"), method = "getValue", cancellable = true)
    private void getAttributeValueFireSign(EntityAttribute attribute, CallbackInfoReturnable<Double> info) {
        if(attribute == SpellSchools.FIRE.attribute){
            EntityAttributeInstance signamount = this.custom.get(SIGN_INTENSITY);
            double value1 = 0;
            if(signamount != null) {
                value1 = signamount.getValue();
            }
            double sign = value1;
            EntityAttributeInstance addedsign = this.custom.get(SIGN_INTENSITY);
            if(signamount != null) {
                addedsign.getValue();
            }
            EntityAttributeInstance fireinstance = this.custom.get(SpellSchools.FIRE.attribute);
            double total = this.fallback.getValue(SpellSchools.FIRE.attribute);
            if(fireinstance != null){
                total = fireinstance.getValue();
            }
            if( sign > 0 && attribute == SpellSchools.FIRE.attribute){
                total += sign;
            }
            if(sign > 0){
                info.setReturnValue(total);
            }
        }
    }
    @Inject(at = @At("HEAD"), method = "getValue", cancellable = true)
    private void getAttributeValueLightningSign(EntityAttribute attribute, CallbackInfoReturnable<Double> info) {
        if(attribute == SpellSchools.LIGHTNING.attribute){
            EntityAttributeInstance signamount = this.custom.get(SIGN_INTENSITY);
            double value1 = 0;
            if(signamount != null) {
                value1 = signamount.getValue();
            }
            double sign = value1;
            EntityAttributeInstance addedsign = this.custom.get(SIGN_INTENSITY);
            if(signamount != null) {
                addedsign.getValue();
            }
            EntityAttributeInstance lightninginstance = this.custom.get(SpellSchools.LIGHTNING.attribute);
            double total = this.fallback.getValue(SpellSchools.LIGHTNING.attribute);
            if(lightninginstance != null){
                total = lightninginstance.getValue();
            }
            if( sign > 0 && attribute == SpellSchools.LIGHTNING.attribute){
                total += sign;
            }
            if(sign > 0){
                info.setReturnValue(total);
            }
        }
    }
    @Inject(at = @At("HEAD"), method = "getValue", cancellable = true)
    private void getAttributeValueSoulSign(EntityAttribute attribute, CallbackInfoReturnable<Double> info) {
        if(attribute == SpellSchools.SOUL.attribute){
            EntityAttributeInstance signamount = this.custom.get(SIGN_INTENSITY);
            double value1 = 0;
            if(signamount != null) {
                value1 = signamount.getValue();
            }
            double sign = value1;
            EntityAttributeInstance addedsign = this.custom.get(SIGN_INTENSITY);
            if(signamount != null) {
                addedsign.getValue();
            }
            EntityAttributeInstance soulinstance = this.custom.get(SpellSchools.SOUL.attribute);
            double total = this.fallback.getValue(SpellSchools.SOUL.attribute);
            if(soulinstance != null){
                total = soulinstance.getValue();
            }
            if( sign > 0 && attribute == SpellSchools.SOUL.attribute){
                total += sign;
            }
            if(sign > 0){
                info.setReturnValue(total);
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "getValue", cancellable = true)
    private void getAttributeValueHealSign(EntityAttribute attribute, CallbackInfoReturnable<Double> info) {
        if(attribute == SpellSchools.HEALING.attribute){
            EntityAttributeInstance signamount = this.custom.get(SIGN_INTENSITY);
            double value1 = 0;
            if(signamount != null) {
                value1 = signamount.getValue();
            }
            double sign = value1;
            EntityAttributeInstance addedsign = this.custom.get(SIGN_INTENSITY);
            if(signamount != null) {
                addedsign.getValue();
            }
            EntityAttributeInstance healinginstance = this.custom.get(SpellSchools.HEALING.attribute);
            double total = this.fallback.getValue(SpellSchools.HEALING.attribute);
            if(healinginstance != null){
                total = healinginstance.getValue();
            }
            if( sign > 0 && attribute == SpellSchools.HEALING.attribute){
                total += sign;
            }
            if(sign > 0){
                info.setReturnValue(total);
            }
        }
    }

}