package net.more_rpg_classes.item.weapons;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.spell_engine.api.item.weapon.SpellWeaponItem;
import net.spell_power.api.MagicSchool;
import net.spell_power.api.attributes.EntityAttributes_SpellPower;

import static net.more_rpg_classes.item.MRPGCItems.*;

public class LegendaryGoldenKnuckleItem extends SpellWeaponItem {
    private final float attackDamage;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public LegendaryGoldenKnuckleItem(ToolMaterial material, float attackDamage, float attackSpeed, float afuse,
                             float haste, float arcanep, float scritchance, float scritdamage,Item.Settings settings) {
        super(material, settings);
        this.attackDamage = (float) attackDamage + material.getAttackDamage();
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
                "Weapon modifier", (double) this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
                "Weapon modifier", (double) attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        builder.put(MRPGCEntityAttributes.ARCANE_FUSE_MODIFIER, new EntityAttributeModifier(ARCANE_FUSE_MODIFIER_ID,
                "Weapon modifier", (double) afuse, EntityAttributeModifier.Operation.MULTIPLY_BASE));
        builder.put(EntityAttributes_SpellPower.POWER.get(MagicSchool.ARCANE), new EntityAttributeModifier(ARCANE_SPELLPOWER_MODIFIER_ID,
                "Weapon modifier", (double) arcanep, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes_SpellPower.HASTE, new EntityAttributeModifier(HASTE_MODIFIER_ID,
                "Weapon modifier", (double) haste, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        builder.put(EntityAttributes_SpellPower.CRITICAL_CHANCE, new EntityAttributeModifier(SPELL_CRIT_CHANCE_MODIFIER_ID,
                "Weapon modifier", (double) scritchance, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        builder.put(EntityAttributes_SpellPower.CRITICAL_DAMAGE, new EntityAttributeModifier(SPELL_CRIT_DAMAGE_MODIFIER_ID,
                "Weapon modifier", (double) scritdamage, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        this.attributeModifiers = builder.build();

    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isOf(Blocks.DIRT)) {
            return 10.0F;
        } else if (state.isIn(BlockTags.PICKAXE_MINEABLE)){
            return 10.0F;
        }else{
            return state.isIn(BlockTags.SHOVEL_MINEABLE) ? 10.0F : 1.0F;
        }
    }
    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && state.getHardness(world, pos) != 0.0f) {
            stack.damage(1, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
        return true;
    }



    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int knuckle_chance_knockup = 15;
        int randomrange_knockup = (int) ((Math.random() * (1 + knuckle_chance_knockup)) + 1);
        int stonhand_stun_chance = 8;
        int randomrange_stun = (int) ((Math.random() * (1 + stonhand_stun_chance)) + 1);
        int stun_duration = 100;
        PlayerEntity player = (PlayerEntity) attacker;

        if (randomrange_knockup >= knuckle_chance_knockup) {
            if (target.isPlayer()) {
                Vec3d currentMovement = target.getVelocity();
                target.setVelocity(currentMovement.x, currentMovement.y + 0.95, currentMovement.z);
                target.velocityModified = true;
            } else {
                target.addVelocity(0, 0.4, 0);
            }
            stack.damage(1, attacker, (e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });
        }
        if (player.hasStatusEffect(MRPGCEffects.STONE_HAND)) {
            if (randomrange_stun >= stonhand_stun_chance) {
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
