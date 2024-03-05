package net.more_rpg_classes.mixin;

import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.spell_power.api.MagicSchool;
import net.spell_power.api.attributes.SpellAttributes;
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
        if(attribute == SpellAttributes.POWER.get(MagicSchool.ARCANE).attribute){
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
            EntityAttributeInstance arcaneinstance = this.custom.get(SpellAttributes.POWER.get(MagicSchool.ARCANE).attribute);
            double total = this.fallback.getValue(SpellAttributes.POWER.get(MagicSchool.ARCANE).attribute);
            if(arcaneinstance != null){
                total = arcaneinstance.getValue();
            }
            if( sign > 0 && attribute == SpellAttributes.POWER.get(MagicSchool.ARCANE).attribute){
                total += sign;
            }
            if(sign > 0){
                info.setReturnValue(total);
            }
        }
    }
    @Inject(at = @At("HEAD"), method = "getValue", cancellable = true)
    private void getAttributeValueFireSign(EntityAttribute attribute, CallbackInfoReturnable<Double> info) {
        if(attribute == SpellAttributes.POWER.get(MagicSchool.FIRE).attribute){
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
            EntityAttributeInstance arcaneinstance = this.custom.get(SpellAttributes.POWER.get(MagicSchool.FIRE).attribute);
            double total = this.fallback.getValue(SpellAttributes.POWER.get(MagicSchool.FIRE).attribute);
            if(arcaneinstance != null){
                total = arcaneinstance.getValue();
            }
            if( sign > 0 && attribute == SpellAttributes.POWER.get(MagicSchool.FIRE).attribute){
                total += sign;
            }
            if(sign > 0){
                info.setReturnValue(total);
            }
        }
    }
    @Inject(at = @At("HEAD"), method = "getValue", cancellable = true)
    private void getAttributeValueLightningSign(EntityAttribute attribute, CallbackInfoReturnable<Double> info) {
        if(attribute == SpellAttributes.POWER.get(MagicSchool.LIGHTNING).attribute){
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
            EntityAttributeInstance arcaneinstance = this.custom.get(SpellAttributes.POWER.get(MagicSchool.LIGHTNING).attribute);
            double total = this.fallback.getValue(SpellAttributes.POWER.get(MagicSchool.LIGHTNING).attribute);
            if(arcaneinstance != null){
                total = arcaneinstance.getValue();
            }
            if( sign > 0 && attribute == SpellAttributes.POWER.get(MagicSchool.LIGHTNING).attribute){
                total += sign;
            }
            if(sign > 0){
                info.setReturnValue(total);
            }
        }
    }
    @Inject(at = @At("HEAD"), method = "getValue", cancellable = true)
    private void getAttributeValueSoulSign(EntityAttribute attribute, CallbackInfoReturnable<Double> info) {
        if(attribute == SpellAttributes.POWER.get(MagicSchool.SOUL).attribute){
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
            EntityAttributeInstance arcaneinstance = this.custom.get(SpellAttributes.POWER.get(MagicSchool.SOUL).attribute);
            double total = this.fallback.getValue(SpellAttributes.POWER.get(MagicSchool.SOUL).attribute);
            if(arcaneinstance != null){
                total = arcaneinstance.getValue();
            }
            if( sign > 0 && attribute == SpellAttributes.POWER.get(MagicSchool.SOUL).attribute){
                total += sign;
            }
            if(sign > 0){
                info.setReturnValue(total);
            }
        }
    }

}