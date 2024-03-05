package net.more_rpg_classes.item.weapons;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.annotation.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.spell_engine.api.item.weapon.SpellSwordItem;

import java.util.List;

import static net.more_rpg_classes.util.CustomMethods.increaseHiddenEffectLevel;

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
        int charge_duration = 130;
        int charge_amplifier_max = 9;
        int charge_incamp =1;

        if(target.isUndead()){
            target.damage(target.getDamageSources().magic(), 2.0f);
            player.addEnchantedHitParticles(target);
        }
        increaseHiddenEffectLevel(player,MRPGCEffects.AERONDIGHT_CHARGE,charge_duration,charge_incamp,charge_amplifier_max);
        int currentAmplifier = player.getStatusEffect(MRPGCEffects.AERONDIGHT_CHARGE).getAmplifier();
        if(currentAmplifier == charge_amplifier_max){
                target.damage(target.getDamageSources().magic(), 5.0f);
                player.addEnchantedHitParticles(target);
            }
        stack.damage(1, attacker, (e)->{
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable(this.getTranslationKey() + ".description_1").formatted(Formatting.AQUA));
        tooltip.add(Text.translatable(this.getTranslationKey() + ".description_2").formatted(Formatting.DARK_AQUA));
        tooltip.add(Text.translatable(this.getTranslationKey() + ".description_3").formatted(Formatting.DARK_AQUA));
        tooltip.add(Text.translatable(this.getTranslationKey() + ".description_4").formatted(Formatting.DARK_AQUA));
    }
}