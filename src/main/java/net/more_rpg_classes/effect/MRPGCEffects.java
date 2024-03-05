package net.more_rpg_classes.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.spell_engine.api.effect.*;
import net.spell_power.api.MagicSchool;
import net.spell_power.api.SpellPower;
import net.spell_power.api.attributes.EntityAttributes_SpellPower;

public class MRPGCEffects {
    public static float ragedmg_misshealth_inc = 0.15f;
    public static float rage_incoming_damage_increase = 0.10f;
    public static float rage_attack_speed_increase = 0.0050f;
    public static float molten_armor_reduce_factor = -2.0f;
    public static float molten_toughness_reduce_factor = -1.0f;
    public static float stone_hand_attack = 1.0f;
    public static float stone_hand_attack_speed = -0.50f;
    public static float aerondight_attack = 0.050f;
    public static float aerondight_spell_crit_chance = 0.0250f;
    public static float aerondight_spell_crit_damage = 0.05f;
    public static float magical_trap_speed = -0.350f;
    public static float frozen_solid_dmg_inc = 0.50F;
    public static float axii_dmg_inc = 0.250F;
    public static float fear_dmg_inc = 0.20F;
    public static float fear_dmg_dec = -0.30F;
    public static float arcane_overflow_fuse_inc = 0.15F;
    public static float arcane_overflow_arcane_inc = 0.10F;
    public static float adrenaline_atk_inc = 0.10F;
    public static float adrenaline_sign_inc = 0.05F;
    public static float soul_collecter_inc = 0.10F;
    public static float quen_reflect_dmg = 0.50F;
    public static float adrenaline_gain = 0.001F;
    public static float frosted_move_dec = -0.25F;


    //RAGE
    public static StatusEffect RAGE = new RageStatusEffect(StatusEffectCategory.BENEFICIAL, 0xf70000)
            .addAttributeModifier(MRPGCEntityAttributes.INCOMING_DAMAGE_MODIFIER, "0bf30a36-798a-450d-bd74-959910e6778e",
            rage_incoming_damage_increase, EntityAttributeModifier.Operation.MULTIPLY_BASE)
            .addAttributeModifier(MRPGCEntityAttributes.RAGE_MODIFIER, "4ff7e39a-22d1-4b65-b87a-815883237180",
                    ragedmg_misshealth_inc, EntityAttributeModifier.Operation.ADDITION)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "3098b421-2316-4b40-9fcf-71c84fd85fc3",
            rage_attack_speed_increase, EntityAttributeModifier.Operation.ADDITION);

    //MOLTEN_ARMOR
    public static final StatusEffect MOLTEN_ARMOR = new MoltenArmorEffect(StatusEffectCategory.HARMFUL,0xdd4e00)
            .addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "d20cbd0d-4101-4dc8-9bbc-140494951dc8",
            molten_armor_reduce_factor, EntityAttributeModifier.Operation.ADDITION)
            .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "0371dbb7-136a-471e-a7a8-512afa10389c",
            molten_toughness_reduce_factor, EntityAttributeModifier.Operation.ADDITION);

    //BARQ_ESNA
    public static StatusEffect BARQ_ESNA = new BarqEsnaEffect(StatusEffectCategory.HARMFUL, 0x8db4fe)
        .setVulnerability(MagicSchool.ARCANE, new SpellPower.Vulnerability(0.2F, 0.05F, 0.1F));

    //MOONLIGHT
    public static StatusEffect MOONLIGHT = new MoonLightEffect(StatusEffectCategory.HARMFUL, 0xbce5fe)
    .addAttributeModifier(MRPGCEntityAttributes.INCOMING_DAMAGE_MODIFIER, "0bf30a36-798a-450d-bd74-959910e6778e",
                      1, EntityAttributeModifier.Operation.MULTIPLY_BASE)
        .addAttributeModifier(MRPGCEntityAttributes.LIFESTEAL_MODIFIER, "e5647c1b-ea2d-4275-aa5d-88da8fb2ab93",
            100, EntityAttributeModifier.Operation.MULTIPLY_BASE);

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
                    aerondight_attack, EntityAttributeModifier.Operation.MULTIPLY_BASE)
            .addAttributeModifier(EntityAttributes_SpellPower.CRITICAL_CHANCE, "6e8a21f5-a47e-4663-876c-970f0e562369",
                    aerondight_spell_crit_chance, EntityAttributeModifier.Operation.MULTIPLY_BASE)
            .addAttributeModifier(EntityAttributes_SpellPower.CRITICAL_DAMAGE, "8424908e-0e3b-4bb0-bf1c-98bb9bc1e175",
                    aerondight_spell_crit_damage, EntityAttributeModifier.Operation.MULTIPLY_BASE);
    //QUEN SHIELD
    public static StatusEffect QUEN_SHIELD= new QuenEffect(StatusEffectCategory.BENEFICIAL, 0x3beeff);

    //YRDEN MAGICAL TRAP
    public static StatusEffect MAGICAL_TRAP= new MagicalTrapEffect(StatusEffectCategory.HARMFUL, 0xe717fe)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "5e58808d-6042-45c6-bb4d-f5fcd82f485e",
                    magical_trap_speed, EntityAttributeModifier.Operation.MULTIPLY_BASE);
    //AXII
    public static StatusEffect AXII= new AxiiEffect(StatusEffectCategory.HARMFUL, 0x008000);

    //FEAR
    public static StatusEffect FEAR= new FearEffect(StatusEffectCategory.HARMFUL, 0x01d9cf)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "57f28eca-112d-418b-8a0b-f826103d4c35",
                    fear_dmg_dec, EntityAttributeModifier.Operation.MULTIPLY_BASE);
    //ICEIMPALED
    public static StatusEffect ICE_IMPALED = new IceImpaledEffect(StatusEffectCategory.HARMFUL, 0xeefffe)
            .setVulnerability(MagicSchool.FROST, new SpellPower.Vulnerability(0.2F, 0.0F, 0.1F))
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "5e58808d-6042-45c6-bb4d-f5fcd82f485e",
            -1.0F, EntityAttributeModifier.Operation.MULTIPLY_BASE);

    //ARCANE OVERFLOW
    public static StatusEffect ARCANE_OVERFLOW = new ArcaneOverflowEffect(StatusEffectCategory.BENEFICIAL, 0xff8bef)
            .addAttributeModifier(MRPGCEntityAttributes.ARCANE_FUSE_MODIFIER, "1077f55d-9d26-49ef-8804-f52eee72dca7",
                    arcane_overflow_fuse_inc, EntityAttributeModifier.Operation.MULTIPLY_BASE)
            .addAttributeModifier(EntityAttributes_SpellPower.POWER.get(MagicSchool.ARCANE), "0f88e4e8-becb-437b-9beb-6ef08fda3b49",
                    arcane_overflow_arcane_inc, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

    //SOUL DEVOURER
    public static StatusEffect SOUL_DEVOURER = new SoulDevourerEffect(StatusEffectCategory.BENEFICIAL, 0x01d9cf);

    //ADRENALINE
    public static StatusEffect ADRENALINE_GAIN = new AdrenalineGainEffect(StatusEffectCategory.BENEFICIAL, 0xdd4e00)
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "8df38693-8f24-4c8c-b346-75ab7e6cc1aa",
    adrenaline_atk_inc, EntityAttributeModifier.Operation.ADDITION)
            .addAttributeModifier(MRPGCEntityAttributes.SIGN_INTENSITY, "0f88e4e8-becb-437b-9beb-6ef08fda3b49",
    adrenaline_sign_inc, EntityAttributeModifier.Operation.ADDITION)
            .addAttributeModifier(MRPGCEntityAttributes.ADRENALINE_MODIFIER,"355df58b-0a17-481f-b6f9-5fe2501ca6c8",
                    adrenaline_gain,EntityAttributeModifier.Operation.MULTIPLY_BASE);

    //COLLECTED SOUL
    public static StatusEffect COLLECTED_SOUL = new CollectedSoulEffect(StatusEffectCategory.BENEFICIAL, 0x01d9cf)
            .addAttributeModifier(EntityAttributes_SpellPower.POWER.get(MagicSchool.SOUL), "5cab7893-044d-45df-8736-ffcadf28d6c8",
                    soul_collecter_inc, EntityAttributeModifier.Operation.ADDITION);

    //QUEN EXPLODE
    public static StatusEffect QUEN_EXPLODE = new QuenEffect(StatusEffectCategory.BENEFICIAL, 0x01d9cf)
            .addAttributeModifier(MRPGCEntityAttributes.DAMAGE_REFLECT_MODIFIER, "7c097c68-1e70-497f-88d7-b78cfa34cd0e",
                    quen_reflect_dmg, EntityAttributeModifier.Operation.MULTIPLY_BASE);

    //GRIEVOUS_WOUNDS
    public static StatusEffect GRIEVOUS_WOUNDS = new GrievousWoundsEffect(StatusEffectCategory.HARMFUL, 0x01d9cf)
            .setVulnerability(MagicSchool.PHYSICAL_MELEE, new SpellPower.Vulnerability(0.25F, 0.5F, 0.15F));
    //FROSTED
    public static StatusEffect FROSTED = new QuenEffect(StatusEffectCategory.BENEFICIAL, 0x01d9cf)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "5e58808d-6042-45c6-bb4d-f5fcd82f485e",
                    frosted_move_dec, EntityAttributeModifier.Operation.MULTIPLY_BASE);



    public static void register(){
        Synchronized.configure(RAGE,true);
        Synchronized.configure(MOLTEN_ARMOR,true);
        Synchronized.configure(BARQ_ESNA,true);
        Synchronized.configure(MOONLIGHT,true);
        Synchronized.configure(STONE_HAND,true);
        Synchronized.configure(STUNNED,true);
        Synchronized.configure(FROZEN_SOLID,true);
        Synchronized.configure(AERONDIGHT_CHARGE,true);
        Synchronized.configure(QUEN_SHIELD,true);
        Synchronized.configure(MAGICAL_TRAP,true);
        Synchronized.configure(ARCANE_OVERFLOW,true);
        Synchronized.configure(AXII,true);
        Synchronized.configure(FEAR,true);
        Synchronized.configure(ICE_IMPALED,true);
        Synchronized.configure(SOUL_DEVOURER,true);
        Synchronized.configure(ADRENALINE_GAIN,true);
        Synchronized.configure(COLLECTED_SOUL,true);
        Synchronized.configure(QUEN_EXPLODE,true);
        Synchronized.configure(GRIEVOUS_WOUNDS,true);
        Synchronized.configure(FROSTED,true);

        RemoveOnHit.configure(STUNNED, true);
        RemoveOnHit.configure(FROZEN_SOLID, true);
        RemoveOnHit.configure(AXII, true);

        ActionImpairing.configure(STUNNED, EntityActionsAllowed.STUN);
        ActionImpairing.configure(FROZEN_SOLID, EntityActionsAllowed.STUN);
        ActionImpairing.configure(AXII, EntityActionsAllowed.STUN);
        ActionImpairing.configure(FEAR, EntityActionsAllowed.INCAPACITATE);

        HealthImpacting.configureDamageTaken(AXII, axii_dmg_inc);
        HealthImpacting.configureDamageTaken(FROZEN_SOLID, frozen_solid_dmg_inc);
        HealthImpacting.configureDamageTaken(FEAR, fear_dmg_inc);

        HealthImpacting.configureHealingTaken(GRIEVOUS_WOUNDS, fear_dmg_inc);



        int mrpgc_spellid = 900;
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "rage").toString(), RAGE);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "molten_armor").toString(), MOLTEN_ARMOR);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "barq_esna").toString(), BARQ_ESNA);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "moonlight").toString(), MOONLIGHT);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "stone_hand").toString(), STONE_HAND);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "stun").toString(), STUNNED);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "frozen_solid").toString(), FROZEN_SOLID);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "aerondight_charge").toString(), AERONDIGHT_CHARGE);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "quen_shield").toString(), QUEN_SHIELD);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "magical_trap").toString(), MAGICAL_TRAP);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "axii").toString(), AXII);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "fear").toString(), FEAR);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "ice_impaled").toString(), ICE_IMPALED);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "arcane_overflow").toString(), ARCANE_OVERFLOW);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "soul_devourer").toString(), SOUL_DEVOURER);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "adrenaline_gain").toString(), ADRENALINE_GAIN);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "collected_soul").toString(), COLLECTED_SOUL);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "quen_explode").toString(), QUEN_EXPLODE);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "grievous_wounds").toString(), GRIEVOUS_WOUNDS);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "frosted").toString(), FROSTED);
    }
}
