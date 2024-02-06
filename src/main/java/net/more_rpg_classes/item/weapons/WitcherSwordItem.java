package net.more_rpg_classes.item.weapons;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.spell_engine.api.item.weapon.SpellSwordItem;

public class WitcherSwordItem extends SpellSwordItem {
    public WitcherSwordItem(ToolMaterial material, Settings settings) {
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

    /*@Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.addStatusEffect(new StatusEffectInstance(MRPGCEffects.RAGE, 100));
        return true;
    }*/

}
