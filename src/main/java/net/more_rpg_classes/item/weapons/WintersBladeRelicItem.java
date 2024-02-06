package net.more_rpg_classes.item.weapons;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.spell_engine.api.item.weapon.SpellWeaponItem;


public class WintersBladeRelicItem extends SpellWeaponItem {
    public WintersBladeRelicItem(ToolMaterial material, Settings settings) {
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
    public boolean isSuitableFor(BlockState state) {
        return state.isOf(Blocks.COBWEB);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int frozen_duration = 100;
        int freeze_chance = 25;
        int randomrange_freeze = (int) ((Math.random() * (1 + freeze_chance)) + 1);

        if (randomrange_freeze >= frozen_duration ) {
            target.addStatusEffect(new StatusEffectInstance(MRPGCEffects.FROZEN_SOLID, frozen_duration));

        }
        stack.damage(1, attacker, (e)->{
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }
}
