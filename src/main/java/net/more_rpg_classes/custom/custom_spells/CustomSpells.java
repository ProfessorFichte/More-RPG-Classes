package net.more_rpg_classes.custom.custom_spells;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.more_rpg_classes.damage.BerserkerSpellCostSource;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.spell_engine.api.spell.CustomSpellHandler;
import net.spell_engine.api.spell.Spell;
import net.spell_engine.internals.SpellHelper;
import net.spell_engine.internals.SpellRegistry;
import net.spell_engine.particle.ParticleHelper;
import net.spell_engine.utils.SoundHelper;
import net.spell_engine.utils.TargetHelper;
import net.spell_power.api.MagicSchool;
import net.spell_power.api.SpellDamageSource;
import net.spell_power.api.SpellPower;

import java.util.List;
import java.util.function.Predicate;

import static net.more_rpg_classes.MRPGCMod.MOD_ID;

public class CustomSpells {
    public static <string> void register() {

        double knockup_burstcrack = 0.15;
        double knockup_burstcrack_stonehand = 0.35;
        int stun_duration_straight_punch = 100;
        float bloody_strike_heal = 0.5F;
        float spellcost_rumbling_swing = 2.0f;
        float spellcost_nordic_storm = 0.25f;
        int wild_rage_duration = 400;

        /// STRAIGHT PUNCH
        CustomSpellHandler.register(new Identifier(MOD_ID, "straight_punch"), (data) -> {
            MagicSchool actualSchool = MagicSchool.PHYSICAL_MELEE;
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            float modifier = SpellRegistry.getSpell(new Identifier(MOD_ID, "straight_punch")).impact[0].action.damage.spell_power_coefficient;
            for (Entity entity : data1.targets()) {
                SpellPower.Result power = SpellPower.getSpellPower(actualSchool, (LivingEntity) data1.caster());
                SpellPower.Vulnerability vulnerability = SpellPower.Vulnerability.none;
                if (entity instanceof LivingEntity living) {
                    vulnerability = SpellPower.getVulnerability(living, actualSchool);
                    double amount = modifier * power.randomValue(vulnerability);
                    entity.damage(SpellDamageSource.player(actualSchool, data1.caster()), (float) amount);
                    SoundHelper.playSound(data1.caster().getWorld(), living, SpellRegistry.getSpell(new Identifier(MOD_ID, "straight_punch")).impact[0].sound);
                    if (data1.caster().hasStatusEffect(MRPGCEffects.STONE_HAND)) {
                        living.addStatusEffect(new StatusEffectInstance(MRPGCEffects.STUNNED, stun_duration_straight_punch));
                    }
                    return true;
                }
            }
            return true;
        });

        /// ASAL
        CustomSpellHandler.register(new Identifier(MOD_ID, "asal"), (data) -> {
            MagicSchool actualSchool = MagicSchool.ARCANE;
            MagicSchool actualSchool2 = MagicSchool.PHYSICAL_MELEE;
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            float modifier = SpellRegistry.getSpell(new Identifier(MOD_ID, "asal")).impact[0].action.damage.spell_power_coefficient;
            for (Entity entity : data1.targets()) {
                SpellPower.Result power = SpellPower.getSpellPower(actualSchool, (LivingEntity) data1.caster());
                SpellPower.Result power2 = SpellPower.getSpellPower(actualSchool2, (LivingEntity) data1.caster());
                SpellPower.Vulnerability vulnerability = SpellPower.Vulnerability.none;
                SpellPower.Vulnerability vulnerability2 = SpellPower.Vulnerability.none;
                if (entity instanceof LivingEntity living) {
                    vulnerability = SpellPower.getVulnerability(living, actualSchool);
                    vulnerability2 = SpellPower.getVulnerability(living, actualSchool);
                    double amount = modifier * power.randomValue(vulnerability);
                    double amount2 = power2.randomValue(vulnerability2);
                    entity.timeUntilRegen = 0;
                    entity.damage(SpellDamageSource.player(actualSchool, data1.caster()), (float) amount + (float) amount2);
                    SoundHelper.playSound(data1.caster().getWorld(), living, SpellRegistry.getSpell(new Identifier(MOD_ID, "asal")).impact[0].sound);
                    ParticleHelper.sendBatches(living, SpellRegistry.getSpell(new Identifier(MOD_ID, "asal")).impact[0].particles);
                    return true;
                }
            }
            return true;
        });


        /// BURSTCRACK
        CustomSpellHandler.register(new Identifier(MOD_ID, "burstcrack"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            Predicate<Entity> selectionPredicate = (target2) -> {
                return (TargetHelper.actionAllowed(TargetHelper.TargetingMode.AREA, TargetHelper.Intent.HARMFUL, data1.caster(), target2)
                );
            };
            if (!data1.caster().getWorld().isClient) {
                List<Entity> list = data1.caster().getWorld().getOtherEntities(data1.caster(), data1.caster().getBoundingBox().expand(SpellRegistry.getSpell(new Identifier(MOD_ID, "burstcrack")).range), selectionPredicate);
                ParticleHelper.sendBatches(data1.caster(), SpellRegistry.getSpell(new Identifier(MOD_ID, "burstcrack")).release.particles);
                for (Entity entity : list) {
                    SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity,SpellRegistry.getSpell(new Identifier(MOD_ID, "burstcrack")), data1.impactContext());
                    SoundHelper.playSound(data1.caster().getWorld(), entity, SpellRegistry.getSpell(new Identifier(MOD_ID, "burstcrack")).impact[0].sound);
                    Vec3d currentMovement = entity.getVelocity();
                    entity.setVelocity(currentMovement.x, currentMovement.y + knockup_burstcrack, currentMovement.z);
                    entity.velocityModified = true;
                    if (data1.caster().hasStatusEffect(MRPGCEffects.STONE_HAND)) {
                        SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity ,SpellRegistry.getSpell(new Identifier(MOD_ID, "burstcrack")), data1.impactContext());
                        SoundHelper.playSound(data1.caster().getWorld(), entity, SpellRegistry.getSpell(new Identifier(MOD_ID, "burstcrack")).impact[0].sound);
                        Vec3d currentMovement2 = entity.getVelocity();
                        entity.setVelocity(currentMovement2.x, currentMovement2.y + knockup_burstcrack_stonehand, currentMovement2.z);
                        entity.velocityModified = true;
                    }
                }
            }
            return false;
        });

        /// BLOODY STRIKE
        CustomSpellHandler.register(new Identifier(MOD_ID, "bloody_strike"), (data) -> {
            MagicSchool actualSchool = MagicSchool.PHYSICAL_MELEE;
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            float modifier = SpellRegistry.getSpell(new Identifier(MOD_ID, "bloody_strike")).impact[0].action.damage.spell_power_coefficient;
            for (Entity entity : data1.targets()) {
                SpellPower.Result power = SpellPower.getSpellPower(actualSchool, (LivingEntity) data1.caster());
                SpellPower.Vulnerability vulnerability = SpellPower.Vulnerability.none;
                if (entity instanceof LivingEntity living) {
                    vulnerability = SpellPower.getVulnerability(living, actualSchool);
                    double amount = modifier * power.randomValue(vulnerability);
                    if (living.isUndead()) {
                        entity.damage(SpellDamageSource.player(actualSchool, data1.caster()), (float) amount);
                    } else {
                        SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, SpellRegistry.getSpell(new Identifier(MOD_ID, "bloody_strike")), data1.impactContext());
                        float healamount = (float) amount * bloody_strike_heal;
                        data1.caster().heal(healamount);
                    }
                    return true;
                }
            }
            return true;
        });
        /// WILD RAGE
        CustomSpellHandler.register(new Identifier(MOD_ID, "wild_rage"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            Predicate<Entity> selectionPredicate = (target2) -> {
                return (TargetHelper.actionAllowed(TargetHelper.TargetingMode.AREA, TargetHelper.Intent.HARMFUL, data1.caster(), target2)
                );
            };
            if (!data1.caster().getWorld().isClient) {
                List<Entity> list = data1.caster().getWorld().getOtherEntities(data1.caster(), data1.caster().getBoundingBox().expand(SpellRegistry.getSpell(new Identifier(MOD_ID, "wild_rage")).range), selectionPredicate);
                for (Entity entity : list) {
                    SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity,SpellRegistry.getSpell(new Identifier(MOD_ID, "wild_rage")), data1.impactContext());
                    data1.caster().addStatusEffect(new StatusEffectInstance(MRPGCEffects.RAGE, wild_rage_duration));
                }
            }
            return true;
        });


        /// NORDIC STORM
        CustomSpellHandler.register(new Identifier(MOD_ID, "nordic_storm"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            data1.caster().damage(new BerserkerSpellCostSource(data1.caster().getDamageSources().starve().getTypeRegistryEntry()), spellcost_nordic_storm);
            float currenthealth = data1.caster().getHealth();
            Predicate<Entity> selectionPredicate = (target2) -> {
                return (TargetHelper.actionAllowed(TargetHelper.TargetingMode.AREA, TargetHelper.Intent.HARMFUL, data1.caster(), target2)
                );
            };
            if (currenthealth >= spellcost_nordic_storm + 0.75f) {
                if (!data1.caster().getWorld().isClient) {
                    List<Entity> list = data1.caster().getWorld().getOtherEntities(data1.caster(), data1.caster().getBoundingBox().expand(SpellRegistry.getSpell(new Identifier(MOD_ID, "nordic_storm")).range), selectionPredicate);
                    ParticleHelper.sendBatches(data1.caster(), SpellRegistry.getSpell(new Identifier(MOD_ID, "nordic_storm")).release.particles);
                    for (Entity entity : list) {
                        SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity ,SpellRegistry.getSpell(new Identifier(MOD_ID, "nordic_storm")), data1.impactContext());
                        SoundHelper.playSound(data1.caster().getWorld(), entity, SpellRegistry.getSpell(new Identifier(MOD_ID, "nordic_storm")).impact[0].sound);
                    }
                } else {
                    data1.caster().shouldCancelInteraction();
                }
            }
            return false;
        });

        /// RUMBLING SWING
        CustomSpellHandler.register(new Identifier(MOD_ID,"rumbling_swing"),(data) -> {
            float range = SpellRegistry.getSpell(new Identifier(MOD_ID, "rumbling_swing")).range;
            MagicSchool actualSchool = MagicSchool.LIGHTNING;
            MagicSchool actualSchool2 = MagicSchool.PHYSICAL_MELEE;
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            BlockHitResult result = data1.caster().getWorld().raycast(new RaycastContext(data1.caster().getEyePos(),data1.caster().getEyePos().add(data1.caster().getRotationVector().multiply(SpellRegistry.getSpell(new Identifier(MOD_ID,"rumbling_swing")).range)), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE,data1.caster()));
            if(result.getPos() != null) {
                data1.caster().requestTeleport(result.getPos().getX(),result.getPos().getY(),result.getPos().getZ());
            }
            List<Entity> list = TargetHelper.targetsFromArea(data1.caster(),data1.caster().getEyePos(),range,new Spell.Release.Target.Area(), target -> TargetHelper.allowedToHurt(data1.caster(),target) );
            for(Entity entity : list){
                SpellHelper.performImpacts(data1.caster().getWorld(),data1.caster(),entity,data1.caster(),SpellRegistry.getSpell(new Identifier(MOD_ID,"rumbling_swing")),data1.impactContext());
            }
            return true;
        });

        /// QUEN
        CustomSpellHandler.register(new Identifier(MOD_ID, "quen"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            data1.caster().clearStatusEffects();
            SpellHelper.performImpacts(data1.caster().getWorld(), data1.caster(), data1.caster(), data1.caster(), SpellRegistry.getSpell(new Identifier(MOD_ID, "quen")),data1.impactContext());
            return true;
        });

        /// RUMBLING SWING
        /*CustomSpellHandler.register(new Identifier(MOD_ID, "rumbling_swing"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            float currenthealth = data1.caster().getHealth();
            float range = SpellRegistry.getSpell(new Identifier(MOD_ID, "rumbling_swing")).range;
            if (currenthealth >= spellcost_rumbling_swing + 0.5f) {
                data1.caster().damage(new BerserkerSpellCostSource(data1.caster().getDamageSources().starve().getTypeRegistryEntry()), spellcost_rumbling_swing);
                data1.caster().velocityDirty = true;
                data1.caster().velocityModified = true;
                float y = data1.caster().getYaw();
                float p = data1.caster().getPitch();
                float a = -MathHelper.sin(y * 0.017453292F) * MathHelper.cos(p * 0.017453292F);
                float b = -MathHelper.sin(p * 0.017453292F);
                float c = MathHelper.cos(y * 0.017453292F) * MathHelper.cos(p * 0.017453292F);
                float d = MathHelper.sqrt(a * a + b * b + c * c);
                a *= (range/2) / d;
                b *= (range/2) / d;
                c *= (range/2) / d;
                data1.caster().addVelocity((double) a, (double) b + 0.2, (double) c);
                if (!data1.caster().getWorld().isClient) {
                    for (Entity entity : data1.targets()) {
                        SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, SpellRegistry.getSpell(new Identifier(MOD_ID, "rumbling_swing")), data1.impactContext());
                    }
                }
            } else {
                data1.caster().shouldCancelInteraction();
            }
            return true;
        });
        */
    }
}
