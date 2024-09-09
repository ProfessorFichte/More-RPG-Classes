package net.more_rpg_classes.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;
import net.spell_engine.api.effect.*;
import net.spell_power.api.SpellSchools;

import java.util.ArrayList;

import static net.more_rpg_classes.MRPGCMod.MOD_ID;


public class MRPGCEffects {
    private static final ArrayList<Entry> entries = new ArrayList<>();
    public static class Entry {
        public final Identifier id;
        public final StatusEffect effect;
        public RegistryEntry<StatusEffect> registryEntry;
        public Entry(String name, StatusEffect effect) {
            this.id = Identifier.of(MOD_ID, name);
            this.effect = effect;
            entries.add(this);
        }
        public void register() {
            registryEntry = Registry.registerReference(Registries.STATUS_EFFECT, id, effect);
        }
        public Identifier modifierId() {
            return Identifier.of(MOD_ID, "effect." + id.getPath());
        }
    }

    public static final Entry MOLTEN_ARMOR = new Entry("molten_armor", new MoltenArmorEffect(StatusEffectCategory.HARMFUL,0xdd4e00));
    public static final Entry STUNNED = new Entry("stun", new CustomStatusEffect(StatusEffectCategory.HARMFUL,0xfffeca));
    public static final Entry FROZEN_SOLID = new Entry("frozen_solid", new FrozenSolidEffect(StatusEffectCategory.HARMFUL, 0x3beeff));
    public static final Entry COLLECTED_SOUL = new Entry("collected_soul", new CustomStatusEffect(StatusEffectCategory.BENEFICIAL, 0x01d9cf));
    public static final Entry GRIEVOUS_WOUNDS = new Entry("grievous_wounds", new CustomStatusEffect(StatusEffectCategory.HARMFUL, 0x01d9cf));
    public static final Entry FROSTED = new Entry("frosted", new FrostedEffect(StatusEffectCategory.HARMFUL, 0x3beeff));
    public static final Entry BLEEDING = new Entry("bleeding", new BleedingEffect(StatusEffectCategory.HARMFUL, 0xdd4e00));
    public static final Entry FEAR = new Entry("fear", new CustomStatusEffect(StatusEffectCategory.HARMFUL, 0x01d9cf));


    public static void register(){
        MOLTEN_ARMOR.effect.addAttributeModifier(
                EntityAttributes.GENERIC_ARMOR, MOLTEN_ARMOR.modifierId(),
                        MRPGCMod.effectsConfig.value.molten_armor_armor_reduction_per_stack, EntityAttributeModifier.Operation.ADD_VALUE)
                .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, MOLTEN_ARMOR.modifierId(),
                        MRPGCMod.effectsConfig.value.molten_armor_armor_toughness_reduction_per_stack, EntityAttributeModifier.Operation.ADD_VALUE);
        FEAR.effect.addAttributeModifier(
                EntityAttributes.GENERIC_ATTACK_DAMAGE, FEAR.modifierId(),
                MRPGCMod.effectsConfig.value.fear_attack_damage_reduction, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        COLLECTED_SOUL.effect.addAttributeModifier(
                SpellSchools.SOUL.attributeEntry, COLLECTED_SOUL.modifierId(),
                MRPGCMod.effectsConfig.value.collected_soul_soul_power_per_stack, EntityAttributeModifier.Operation.ADD_VALUE
        );
        FROSTED.effect.addAttributeModifier(
                EntityAttributes.GENERIC_MOVEMENT_SPEED, FROSTED.modifierId(),
                MRPGCMod.effectsConfig.value.frosted_decreased_movement_speed_per_stack,  EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
        );


        Synchronized.configure(MOLTEN_ARMOR.effect,true);
        Synchronized.configure(STUNNED.effect,true);
        Synchronized.configure(FROZEN_SOLID.effect,true);
        Synchronized.configure(FEAR.effect,true);
        Synchronized.configure(COLLECTED_SOUL.effect,true);
        Synchronized.configure(GRIEVOUS_WOUNDS.effect,true);
        Synchronized.configure(FROSTED.effect,true);
        Synchronized.configure(BLEEDING.effect,true);

        RemoveOnHit.configure(FROZEN_SOLID.effect, true);

        ActionImpairing.configure(STUNNED.effect, EntityActionsAllowed.STUN);
        ActionImpairing.configure(FROZEN_SOLID.effect, EntityActionsAllowed.STUN);
        ActionImpairing.configure(FEAR.effect, EntityActionsAllowed.INCAPACITATE);

        HealthImpacting.configureDamageTaken(FROZEN_SOLID.effect, MRPGCMod.effectsConfig.value.frozen_solid_increased_damage_taken);
        HealthImpacting.configureDamageTaken(FEAR.effect,  MRPGCMod.effectsConfig.value.fear_increased_damage_taken);
        HealthImpacting.configureDamageTaken(GRIEVOUS_WOUNDS.effect,  MRPGCMod.effectsConfig.value.grievous_wounds_increased_damage_taken);

        HealthImpacting.configureHealingTaken(GRIEVOUS_WOUNDS.effect,  MRPGCMod.effectsConfig.value.grievous_wounds_healing_taken);

        for (var entry: entries) {
            entry.register();
        }
    }
}
