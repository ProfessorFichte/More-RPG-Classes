package net.more_rpg_classes.item.weapons;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.spell_engine.api.item.weapon.SpellSwordItem;
import net.spell_power.api.MagicSchool;
import net.spell_power.api.attributes.EntityAttributes_SpellPower;

import static net.more_rpg_classes.item.MRPGCItems.*;

public class SoulBerserkerAxeItem extends SpellSwordItem {

    private final float attackDamage;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public SoulBerserkerAxeItem(ToolMaterial material, float attackDamage, float attackSpeed,
                                float rage, float lifesteal,float soul, Item.Settings settings) {
        super(material, settings);
        this.attackDamage = (float) attackDamage + material.getAttackDamage();
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
                "Weapon modifier", (double) this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
                "Weapon modifier", (double) attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        builder.put(MRPGCEntityAttributes.RAGE_MODIFIER, new EntityAttributeModifier(RAGE_MODIFIER_ID,
                "Weapon modifier", (double) rage, EntityAttributeModifier.Operation.MULTIPLY_BASE));
        builder.put(MRPGCEntityAttributes.LIFESTEAL_MODIFIER, new EntityAttributeModifier(LIFESTEAL_MODIFIER_ID,
                "Weapon modifier", (double) lifesteal, EntityAttributeModifier.Operation.MULTIPLY_BASE));
        builder.put(EntityAttributes_SpellPower.POWER.get(MagicSchool.SOUL), new EntityAttributeModifier(SOUL_SPELLPOWER_MODIFIER_ID,
                "Weapon modifier", (double) soul, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
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
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            return this.attributeModifiers;
        }
        return super.getAttributeModifiers(slot);
    }
}
