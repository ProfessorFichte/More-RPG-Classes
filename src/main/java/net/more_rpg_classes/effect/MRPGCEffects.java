package net.more_rpg_classes.effect;

import net.more_rpg_classes.MRPGCMod;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.spell_engine.api.effect.ActionImpairing;
import net.spell_engine.api.effect.EntityActionsAllowed;
import net.spell_engine.api.effect.RemoveOnHit;
import net.spell_engine.api.effect.Synchronized;

public class MRPGCEffects {
    public static float rage_damage_increase = +0.5f;
    public static float rage_incoming_damage_increase = 0.5f;
    public static float rage_attack_speed_increase = +0.2f;

    public static float molten_armor_reduce_factor = -2.0f;
    public static float molten_toughness_reduce_factor = -1.0f;

    public static float stone_hand_attack = 1.0f;
    public static float stone_hand_attack_speed = -0.7f;

    public static float aerondight_attack = 0.1f;


    //RAGE
    public static StatusEffect RAGE = new RageStatusEffect(StatusEffectCategory.BENEFICIAL, 0xf70000)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "0b0701a4-4bdc-42a7-9b7e-06d0e397ae77",
            rage_damage_increase, EntityAttributeModifier.Operation.ADDITION)
            .addAttributeModifier(MRPGCEntityAttributes.INCOMING_DAMAGE_MODIFIER, "0bf30a36-798a-450d-bd74-959910e6778e",
            rage_incoming_damage_increase, EntityAttributeModifier.Operation.ADDITION)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "3098b421-2316-4b40-9fcf-71c84fd85fc3",
            rage_attack_speed_increase, EntityAttributeModifier.Operation.ADDITION);

    //MOLTEN_ARMOR
    public static final StatusEffect MOLTEN_ARMOR = new MoltenArmorEffect(StatusEffectCategory.HARMFUL,0xdd4e00)
            .addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "d20cbd0d-4101-4dc8-9bbc-140494951dc8",
            molten_armor_reduce_factor, EntityAttributeModifier.Operation.ADDITION)
            .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "0371dbb7-136a-471e-a7a8-512afa10389c",
            molten_toughness_reduce_factor, EntityAttributeModifier.Operation.ADDITION);

    //QUEN_EXPLODE
    public static StatusEffect QUEN_EXPLODE = new QuenExplodeEffect(StatusEffectCategory.BENEFICIAL, 0xdd4e00)
            .addAttributeModifier(MRPGCEntityAttributes.INCOMING_DAMAGE_MODIFIER, "4040a638-4ec1-44af-baf6-f4685d1c3ae8",
                    1.0f, EntityAttributeModifier.Operation.ADDITION);

    //MOONLIGHT
    public static StatusEffect MOONLIGHT = new MoonLightEffect(StatusEffectCategory.HARMFUL, 0xbce5fe);

    //STONE_HAND
    public static StatusEffect STONE_HAND = new StoneHandEffect(StatusEffectCategory.BENEFICIAL, 0xbce5fe)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "d1843e0f-8a63-4c96-a854-9c9444981042",
                    stone_hand_attack, EntityAttributeModifier.Operation.ADDITION)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "9bf58fe9-4b58-4174-9f41-a492a3510271",
                    stone_hand_attack_speed, EntityAttributeModifier.Operation.ADDITION);

    //STUNNED
    public static StatusEffect STUNNED = new StunEffect(StatusEffectCategory.HARMFUL, 0xfffeca);

    //FROZEN_SOLID
    public static StatusEffect FROZEN_SOLID= new FrozenSolidEffect(StatusEffectCategory.HARMFUL, 0x3beeff);

    //AERONDIGHT_CHARGE
    public static StatusEffect AERONDIGHT_CHARGE= new AerondightChargeEffect(StatusEffectCategory.BENEFICIAL, 0x6afecf)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "d1843e0f-8a63-4c96-a854-9c9444981042",
                    aerondight_attack, EntityAttributeModifier.Operation.ADDITION);

    public static void register(){
        Synchronized.configure(RAGE,true);
        Synchronized.configure(MOLTEN_ARMOR,true);
        Synchronized.configure(QUEN_EXPLODE,true);
        Synchronized.configure(MOONLIGHT,true);
        Synchronized.configure(STONE_HAND,true);
        Synchronized.configure(STUNNED,true);
        ActionImpairing.configure(STUNNED, EntityActionsAllowed.STUN);
        ActionImpairing.configure(FROZEN_SOLID, EntityActionsAllowed.STUN);
        RemoveOnHit.configure(FROZEN_SOLID, true);
        Synchronized.configure(FROZEN_SOLID,true);
        Synchronized.configure(AERONDIGHT_CHARGE,true);

        int mrpgc_spellid = 900;
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "rage").toString(), RAGE);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "molten_armor").toString(), MOLTEN_ARMOR);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "quen_explode").toString(), QUEN_EXPLODE);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "moonlight").toString(), MOONLIGHT);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "stone_hand").toString(), STONE_HAND);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "stun").toString(), STUNNED);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "frozen_solid").toString(), FROZEN_SOLID);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "aerondight_charge").toString(), AERONDIGHT_CHARGE);
    }
}
