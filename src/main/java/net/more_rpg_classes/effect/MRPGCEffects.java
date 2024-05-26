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
import net.spell_power.api.SpellSchools;


public class MRPGCEffects {

    //MOONLIGHT (FOR TESTING)
    public static StatusEffect MOONLIGHT = new MoonLightEffect(StatusEffectCategory.HARMFUL, 0xbce5fe)
            .addAttributeModifier(MRPGCEntityAttributes.LIFESTEAL_MODIFIER, "e5647c1b-ea2d-4275-aa5d-88da8fb2ab93",
                    100, EntityAttributeModifier.Operation.MULTIPLY_BASE);

    //MOLTEN_ARMOR
    public static final StatusEffect MOLTEN_ARMOR = new MoltenArmorEffect(StatusEffectCategory.HARMFUL,0xdd4e00);

    //STUNNED
    public static StatusEffect STUNNED = new StunEffect(StatusEffectCategory.HARMFUL, 0xfffeca);

    //FROZEN_SOLID
    public static StatusEffect FROZEN_SOLID= new FrozenSolidEffect(StatusEffectCategory.HARMFUL, 0x3beeff);

    //FEAR
    public static StatusEffect FEAR= new FearEffect(StatusEffectCategory.HARMFUL, 0x01d9cf);

    //COLLECTED SOUL
    public static StatusEffect COLLECTED_SOUL = new CollectedSoulEffect(StatusEffectCategory.BENEFICIAL, 0x01d9cf);

    //GRIEVOUS_WOUNDS
    public static StatusEffect GRIEVOUS_WOUNDS = new GrievousWoundsEffect(StatusEffectCategory.HARMFUL, 0x01d9cf);

    //FROSTED
    public static StatusEffect FROSTED= new FrostedEffect(StatusEffectCategory.HARMFUL, 0x3beeff);

    //FROSTED
    public static StatusEffect BLEEDING= new BleedingEffect(StatusEffectCategory.HARMFUL, 0xdd4e00);

    public static void register(){
        MOLTEN_ARMOR.addAttributeModifier(
                EntityAttributes.GENERIC_ARMOR, "d20cbd0d-4101-4dc8-9bbc-140494951dc8",
                        MRPGCMod.effectsConfig.value.molten_armor_armor_reduction_per_stack, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "0371dbb7-136a-471e-a7a8-512afa10389c",
                        MRPGCMod.effectsConfig.value.molten_armor_armor_toughness_reduction_per_stack, EntityAttributeModifier.Operation.ADDITION);
        FEAR.addAttributeModifier(
                EntityAttributes.GENERIC_ATTACK_DAMAGE, "57f28eca-112d-418b-8a0b-f826103d4c35",
                MRPGCMod.effectsConfig.value.fear_attack_damage_reduction, EntityAttributeModifier.Operation.MULTIPLY_BASE);
        COLLECTED_SOUL.addAttributeModifier(
                SpellSchools.SOUL.attribute, "5cab7893-044d-45df-8736-ffcadf28d6c8",
                MRPGCMod.effectsConfig.value.collected_soul_soul_power_per_stack, EntityAttributeModifier.Operation.ADDITION
        );
        FROSTED.addAttributeModifier(
                EntityAttributes.GENERIC_MOVEMENT_SPEED, "5e58808d-6042-45c6-bb4d-f5fcd82f485e",
                MRPGCMod.effectsConfig.value.frosted_decreased_movement_speed_per_stack, EntityAttributeModifier.Operation.MULTIPLY_BASE
        );


        Synchronized.configure(MOLTEN_ARMOR,true);
        Synchronized.configure(MOONLIGHT,true);
        Synchronized.configure(STUNNED,true);
        Synchronized.configure(FROZEN_SOLID,true);
        Synchronized.configure(FEAR,true);
        Synchronized.configure(COLLECTED_SOUL,true);
        Synchronized.configure(GRIEVOUS_WOUNDS,true);
        Synchronized.configure(FROSTED,true);
        Synchronized.configure(BLEEDING,true);

        //RemoveOnHit.configure(STUNNED, true);
        RemoveOnHit.configure(FROZEN_SOLID, true);

        ActionImpairing.configure(STUNNED, EntityActionsAllowed.STUN);
        ActionImpairing.configure(FROZEN_SOLID, EntityActionsAllowed.STUN);
        ActionImpairing.configure(FEAR, EntityActionsAllowed.INCAPACITATE);

        HealthImpacting.configureDamageTaken(FROZEN_SOLID, MRPGCMod.effectsConfig.value.frozen_solid_increased_damage_taken);
        HealthImpacting.configureDamageTaken(FEAR,  MRPGCMod.effectsConfig.value.fear_increased_damage_taken);
        HealthImpacting.configureDamageTaken(GRIEVOUS_WOUNDS,  MRPGCMod.effectsConfig.value.grievous_wounds_increased_damage_taken);

        HealthImpacting.configureHealingTaken(GRIEVOUS_WOUNDS,  MRPGCMod.effectsConfig.value.grievous_wounds_healing_taken);



        int mrpgc_spellid = 900;
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "molten_armor").toString(), MOLTEN_ARMOR);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "moonlight").toString(), MOONLIGHT);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "stun").toString(), STUNNED);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "frozen_solid").toString(), FROZEN_SOLID);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "fear").toString(), FEAR);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "collected_soul").toString(), COLLECTED_SOUL);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "grievous_wounds").toString(), GRIEVOUS_WOUNDS);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "frosted").toString(), FROSTED);
        Registry.register(Registries.STATUS_EFFECT, mrpgc_spellid++, new Identifier(MRPGCMod.MOD_ID, "bleeding").toString(), BLEEDING);
    }
}
