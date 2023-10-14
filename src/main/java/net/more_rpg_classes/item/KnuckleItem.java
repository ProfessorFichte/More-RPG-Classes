package net.more_rpg_classes.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.Vec3d;
import net.spell_engine.api.item.weapon.SpellWeaponItem;
import net.spell_power.api.attributes.EntityAttributes_SpellPower;

import static net.more_rpg_classes.item.MRPGCItems.SPELL_HASTE_MODIFIER_ID;

public class KnuckleItem extends SpellWeaponItem {
    private final float attackDamage;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;


    public KnuckleItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, float haste, Item.Settings settings) {
        super(toolMaterial, settings);
        this.attackDamage = (float) attackDamage + toolMaterial.getAttackDamage();
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
                "Weapon modifier", (double) this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
                "Weapon modifier", (double) attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes_SpellPower.HASTE, new EntityAttributeModifier(SPELL_HASTE_MODIFIER_ID,
                "Weapon modifier", haste, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        this.attributeModifiers = builder.build();
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int knuckle_chance_knockup = 20;
        int randomrange_knockup = (int) ((Math.random() * (1 + knuckle_chance_knockup)) + 1);
        int stonhand_stun_chance = 5;
        int randomrange_stun = (int) ((Math.random() * (1 + stonhand_stun_chance)) + 1);
        int stun_duration = 100;
        PlayerEntity player = (PlayerEntity) attacker;

        if (randomrange_knockup >= knuckle_chance_knockup ){
        if (target.isPlayer()) {
            Vec3d currentMovement = target.getVelocity();
            target.setVelocity(currentMovement.x, currentMovement.y + 0.75, currentMovement.z);
            target.velocityModified = true;
        } else {
            target.addVelocity(0, 0.4, 0);
        }
    stack.damage(1, attacker, (e)->{
        e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
    });
    }
        if(player.hasStatusEffect(MRPGCEffects.STONE_HAND)){
            if (randomrange_stun >= stonhand_stun_chance ){
                target.addStatusEffect(new StatusEffectInstance(MRPGCEffects.STUNNED, stun_duration));
            }
        }
        stack.damage(1, attacker, (e) -> {
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }


    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            return this.attributeModifiers;
        }
        return super.getAttributeModifiers(slot);
    }

}
