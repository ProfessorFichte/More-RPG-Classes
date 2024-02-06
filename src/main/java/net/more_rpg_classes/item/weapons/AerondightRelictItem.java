package net.more_rpg_classes.item.weapons;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.spell_engine.api.item.weapon.SpellSwordItem;

import static net.more_rpg_classes.util.CustomMethods.increaseAmpAndDuration;

public class AerondightRelictItem extends SpellSwordItem {
    public AerondightRelictItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isOf(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            return state.isIn(BlockTags.SWORD_EFFICIENT) ? 1.5F : 1.0F;
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        PlayerEntity player = (PlayerEntity) attacker;
        int charge_duration = 400;
        int charge_duration_inc = 200;
        int charge_amplifier_max = 10;
        int charge_incamp =1;

        if(target.isUndead()){
            target.damage(target.getDamageSources().magic(), 2.0f);
            player.addEnchantedHitParticles(player);
        }
        increaseAmpAndDuration(player, MRPGCEffects.AERONDIGHT_CHARGE, charge_duration, charge_incamp, charge_amplifier_max, charge_duration_inc);
            int currentAmplifier = player.getStatusEffect(MRPGCEffects.AERONDIGHT_CHARGE).getAmplifier();
            if(currentAmplifier == charge_amplifier_max){
                target.damage(target.getDamageSources().magic(), 6.0f);
                player.removeStatusEffect(MRPGCEffects.AERONDIGHT_CHARGE);
                player.addEnchantedHitParticles(player);
                player.addCritParticles(target);
            }
        stack.damage(1, attacker, (e)->{
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }
}