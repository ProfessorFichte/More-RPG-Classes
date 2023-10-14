package net.more_rpg_classes.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.spell_engine.api.item.weapon.SpellSwordItem;
import net.spell_power.api.MagicSchool;
import net.spell_power.api.attributes.EntityAttributes_SpellPower;

import static net.more_rpg_classes.item.MRPGCItems.SPELL_POWER_FIRE_MODIFIER_ID;
import static net.more_rpg_classes.item.MRPGCItems.SPELL_POWER_LIGHTNING_MODIFIER_ID;

public class WitcherSilverSwordItem extends SpellSwordItem {

    private final float attackDamage;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;


    public WitcherSilverSwordItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, float fire, float lightning, Item.Settings settings) {
        super(toolMaterial, settings);
        this.attackDamage = (float) attackDamage + toolMaterial.getAttackDamage();
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
                "Weapon modifier", (double) this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
                "Weapon modifier", (double) attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes_SpellPower.POWER.get(MagicSchool.FIRE), new EntityAttributeModifier(SPELL_POWER_FIRE_MODIFIER_ID,
                "Weapon modifier", fire, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes_SpellPower.POWER.get(MagicSchool.LIGHTNING), new EntityAttributeModifier(SPELL_POWER_LIGHTNING_MODIFIER_ID,
                "Weapon modifier", lightning, EntityAttributeModifier.Operation.ADDITION));

        this.attributeModifiers = builder.build();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(target.isUndead()){
            target.damage(target.getDamageSources().magic(), 1.0f);
        }
        stack.damage(1, attacker, (e)->{
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }


    public float getAttackDamage() {
        return this.attackDamage;
    }


    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            return this.attributeModifiers;
        }
        return super.getAttributeModifiers(slot);

    }

}
