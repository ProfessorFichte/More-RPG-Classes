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

public class BerserkerAxeItem extends SpellSwordItem {
    public BerserkerAxeItem(ToolMaterial material, Settings settings) {
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
        int rage_berserker_chance = 10;
        int rage_duration = 300;
        int rage_duration_inc = 200;
        int rage_amplifier_max = 4;
        int rage_incamp =1;
        int randomrange_rage = (int) ((Math.random() * (1 + rage_berserker_chance)) + 1);
        PlayerEntity player = (PlayerEntity) attacker;

        if(player.hasStatusEffect(MRPGCEffects.RAGE)) {
            if (randomrange_rage >= rage_berserker_chance ) {
                increaseAmpAndDuration(player, MRPGCEffects.RAGE, rage_duration, rage_incamp, rage_amplifier_max, rage_duration_inc);
            }
            stack.damage(1, attacker, (e)->{
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });
        }
        return true;
    }
}


