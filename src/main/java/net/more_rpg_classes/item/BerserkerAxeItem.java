package net.more_rpg_classes.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.spell_engine.api.item.weapon.SpellWeaponItem;

import static net.more_rpg_classes.util.CustomMethods.increaseAmpAndDuration;

public class BerserkerAxeItem extends SpellWeaponItem {
    private final float attackDamage;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;


    public BerserkerAxeItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(toolMaterial, settings);
        this.attackDamage = (float) attackDamage + toolMaterial.getAttackDamage();
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
                "Weapon modifier", (double) this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
                "Weapon modifier", (double) attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int rage_berserker_chance = 6;
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


    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            return this.attributeModifiers;
        }
        return super.getAttributeModifiers(slot);
    }
}


