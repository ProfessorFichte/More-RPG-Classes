package net.more_rpg_classes.custom.custom_spells;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.more_rpg_classes.damage.BerserkerSpellCostSource;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.spell_engine.api.spell.CustomSpellHandler;
import net.spell_engine.api.spell.Spell;
import net.spell_engine.internals.SpellHelper;
import net.spell_engine.particle.ParticleHelper;
import net.spell_engine.utils.SoundHelper;
import net.spell_engine.utils.TargetHelper;
import net.spell_power.api.MagicSchool;
import net.spell_power.api.SpellDamageSource;
import net.spell_power.api.SpellPower;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static net.more_rpg_classes.MRPGCMod.MOD_ID;
import static net.more_rpg_classes.util.CustomMethods.*;
import static net.spell_engine.internals.SpellRegistry.getSpell;

public class CustomSpells {
    public static void register() {

        int speed_belial_smashing = 4;
        double knockup_burstcrack = 0.35;
        double knockup_burstcrack_stonehand = 0.65;
        int stun_duration_straight_punch = 60;
        float bloody_strike_heal = 0.5F;
        float spellcost_soulaxe_drain = 1.0f;
        int wild_rage_duration = 600;

        ////BERSERKER_SPELLS
        /// BLOODY STRIKE
        CustomSpellHandler.register(new Identifier(MOD_ID, "bloody_strike"), (data) -> {
            MagicSchool actualSchool = MagicSchool.PHYSICAL_MELEE;
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            float modifier = getSpell(new Identifier(MOD_ID, "bloody_strike")).impact[0].action.damage.spell_power_coefficient;
            for (Entity entity : data1.targets()) {
                SpellPower.Result power = SpellPower.getSpellPower(actualSchool, data1.caster());
                SpellPower.Vulnerability vulnerability ;
                if (entity instanceof LivingEntity living) {
                    vulnerability = SpellPower.getVulnerability(living, actualSchool);
                    double amount = modifier * power.randomValue(vulnerability);
                    if (living.isUndead()) {
                        entity.damage(SpellDamageSource.player(actualSchool, data1.caster()), (float) amount);
                    } else {
                        SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, getSpell(new Identifier(MOD_ID, "bloody_strike")), data1.impactContext());
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
                data1.caster().addStatusEffect(new StatusEffectInstance(MRPGCEffects.RAGE, wild_rage_duration));
                List<Entity> list = data1.caster().getWorld().getOtherEntities(data1.caster(), data1.caster().getBoundingBox().expand(getSpell(new Identifier(MOD_ID, "wild_rage")).range), selectionPredicate);
                for (Entity entity : list) {
                    SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, getSpell(new Identifier(MOD_ID, "wild_rage")), data1.impactContext());
                }
            }
            return true;
        });
        /// OUTRAGE
        CustomSpellHandler.register(new Identifier(MOD_ID, "outrage"), (data) -> {
            MagicSchool actualSchool = MagicSchool.PHYSICAL_MELEE;
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;

            Predicate<Entity> selectionPredicate = (target2) -> {
                return (TargetHelper.actionAllowed(TargetHelper.TargetingMode.DIRECT, TargetHelper.Intent.HARMFUL, data1.caster(), target2)
                );
            };
            if (!data1.caster().getWorld().isClient) {
                double outrage = data1.caster().getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED)
                        + (((data1.caster().getAttributeValue(MRPGCEntityAttributes.RAGE_MODIFIER)-100)/100)*1.2);
                data1.caster().velocityDirty = true;
                data1.caster().velocityModified = true;
                if(data1.caster().hasStatusEffect(MRPGCEffects.RAGE)){
                    data1.caster().setVelocity(data1.caster().getRotationVec(1).subtract(0, data1.caster().getRotationVec(1).y, 0).normalize().multiply(outrage, outrage * 1, outrage).add(0, data1.caster().getVelocity().y, 0));
                }
                for (Entity entity : data1.targets()) {
                    SpellPower.Result power = SpellPower.getSpellPower(actualSchool, data1.caster());
                    SpellPower.Vulnerability vulnerability = SpellPower.Vulnerability.none;

                    if (data1.caster().hasStatusEffect(MRPGCEffects.RAGE)) {
                        int rageamp = data1.caster().getStatusEffect(MRPGCEffects.RAGE).getAmplifier();
                        SoundHelper.playSound(data1.caster().getWorld(), entity, getSpell(new Identifier(MOD_ID, "outrage")).impact[0].sound);
                        vulnerability = SpellPower.getVulnerability((LivingEntity) entity, actualSchool);
                        double amount = (((float)rageamp /10) * power.randomValue(vulnerability));
                        entity.damage(SpellDamageSource.player(actualSchool, data1.caster()), (float) amount);
                        SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, getSpell(new Identifier(MOD_ID, "outrage")), data1.impactContext());
                        clearNegativeEffects(data1.caster(),true);
                    }else{
                        SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, getSpell(new Identifier(MOD_ID, "outrage")), data1.impactContext());
                        SoundHelper.playSound(data1.caster().getWorld(), entity, getSpell(new Identifier(MOD_ID, "outrage")).impact[0].sound);
                    }
                }
            }
            return false;
        });
        /// SOULAXE DRAIN
        CustomSpellHandler.register(new Identifier(MOD_ID,"soulaxe_drain"),(data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            Predicate<Entity> selectionPredicate = (target2) -> {
                return (TargetHelper.actionAllowed(TargetHelper.TargetingMode.AREA, TargetHelper.Intent.HARMFUL, data1.caster(), target2)
                );
            };
            if (!data1.caster().getWorld().isClient) {
                data1.caster().damage(new BerserkerSpellCostSource(data1.caster().getDamageSources().starve().getTypeRegistryEntry()), spellcost_soulaxe_drain);
                List<Entity> list = data1.caster().getWorld().getOtherEntities(data1.caster(), data1.caster().getBoundingBox().expand(getSpell(new Identifier(MOD_ID, "soulaxe_drain")).range), selectionPredicate);
                for (Entity entity : list) {
                    SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, getSpell(new Identifier(MOD_ID, "soulaxe_drain")), data1.impactContext());
                }
            }
            return false;
        });
        /// RUMBLING SWING
        CustomSpellHandler.register(new Identifier(MOD_ID,"rumbling_swing"),(data) -> {
            float range = getSpell(new Identifier(MOD_ID, "rumbling_swing")).range;
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            BlockHitResult result = data1.caster().getWorld().raycast(new RaycastContext(data1.caster().getEyePos(), data1.caster().getEyePos()
                    .add(data1.caster().getRotationVector().multiply(getSpell(new Identifier(MOD_ID,"rumbling_swing")).range)),
                    RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE,data1.caster()));
            if(result.getPos() != null) {
                data1.caster().requestTeleport(result.getPos().getX(),result.getPos().getY(),result.getPos().getZ());
            }
            List<Entity> list = TargetHelper.targetsFromArea(data1.caster(),data1.caster().getEyePos(),range,new Spell.Release.Target.Area(), target -> TargetHelper.allowedToHurt(data1.caster(),target) );
            for(Entity entity : list){
                SpellHelper.performImpacts(data1.caster().getWorld(),data1.caster(),entity,data1.caster(), getSpell(new Identifier(MOD_ID,"rumbling_swing")),data1.impactContext());
            }
            return true;
        });
        /// NORDIC STORM
        CustomSpellHandler.register(new Identifier(MOD_ID, "nordic_storm"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;

            Predicate<Entity> selectionPredicate = (target2) -> {
                return (TargetHelper.actionAllowed(TargetHelper.TargetingMode.AREA, TargetHelper.Intent.HARMFUL, data1.caster(), target2)
                );
            };
                if (!data1.caster().getWorld().isClient) {
                    List<Entity> list = data1.caster().getWorld().getOtherEntities(data1.caster(), data1.caster().getBoundingBox().expand(getSpell(new Identifier(MOD_ID, "nordic_storm")).range), selectionPredicate);
                    ParticleHelper.sendBatches(data1.caster(), getSpell(new Identifier(MOD_ID, "nordic_storm")).release.particles);
                    for (Entity entity : list) {
                        SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity , getSpell(new Identifier(MOD_ID, "nordic_storm")), data1.impactContext());
                        SoundHelper.playSound(data1.caster().getWorld(), entity, getSpell(new Identifier(MOD_ID, "nordic_storm")).impact[0].sound);
                    }
                }
            return false;
        });
        ///////WITCHER_SPELLS
        /// QUEN
        CustomSpellHandler.register(new Identifier(MOD_ID, "quen"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            if (!data1.caster().getWorld().isClient) {
                clearNegativeEffects(data1.caster(),true);
                SpellHelper.performImpacts(data1.caster().getWorld(), data1.caster(), data1.caster(), data1.caster(), getSpell(new Identifier(MOD_ID, "quen")), data1.impactContext());
            }
            return true;
        });
        /// STRONG_ATTACK
        CustomSpellHandler.register(new Identifier(MOD_ID, "strong_attack"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            for (Entity entity : data1.targets()) {
                if (entity instanceof LivingEntity ) {
                    SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, getSpell(new Identifier(MOD_ID, "strong_attack")), data1.impactContext());
                    if(!data1.caster().hasStatusEffect(MRPGCEffects.ADRENALINE_GAIN)){
                        data1.caster().addStatusEffect(new StatusEffectInstance(MRPGCEffects.ADRENALINE_GAIN, 350, 0, false, false, true));
                    }
                    increaseAmpByChance(data1.caster(), MRPGCEffects.ADRENALINE_GAIN,350,1,20,3);
                    return true;
                }
            }
            return true;
        });
        /// WHIRL
        CustomSpellHandler.register(new Identifier(MOD_ID, "whirl"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            Predicate<Entity> selectionPredicate = (target2) -> {
                return (TargetHelper.actionAllowed(TargetHelper.TargetingMode.DIRECT, TargetHelper.Intent.HARMFUL, data1.caster(), target2)
                );
            };

            double whirlspeed = data1.caster().getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED)
                    + (((data1.caster().getAttributeValue(MRPGCEntityAttributes.ADRENALINE_MODIFIER)-100)/100)*2);
            data1.caster().velocityDirty = true;
            data1.caster().velocityModified = true;
            data1.caster().setVelocity(data1.caster().getRotationVec(1).subtract(0, data1.caster().getRotationVec(1).y, 0).normalize().multiply(whirlspeed, whirlspeed * 1, whirlspeed).add(0, data1.caster().getVelocity().y, 0));
            if (!data1.caster().getWorld().isClient) {
                List<Entity> list = data1.caster().getWorld().getOtherEntities(data1.caster(), data1.caster().getBoundingBox().expand(getSpell(new Identifier(MOD_ID, "whirl")).range), selectionPredicate);
                for (Entity entity : list) {
                    SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, getSpell(new Identifier(MOD_ID, "whirl")), data1.impactContext());
                }
            }
            return false;
        });
        /// REND
        CustomSpellHandler.register(new Identifier(MOD_ID, "rend"), (data) -> {
            MagicSchool actualSchool = MagicSchool.PHYSICAL_MELEE;
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            float adrenaline_damage_multiplier = (float) ((data1.caster().getAttributeValue(MRPGCEntityAttributes.ADRENALINE_MODIFIER)-100)/10);
            for (Entity entity : data1.targets()) {
                SpellPower.Result power = SpellPower.getSpellPower(actualSchool,data1.caster());
                SpellPower.Vulnerability vulnerability;
                if (entity instanceof LivingEntity living) {
                    vulnerability = SpellPower.getVulnerability(living, actualSchool);
                    double amount = adrenaline_damage_multiplier * power.randomValue(vulnerability);
                    SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, getSpell(new Identifier(MOD_ID, "rend")), data1.impactContext());
                    if(data1.caster().hasStatusEffect(MRPGCEffects.ADRENALINE_GAIN)){
                        entity.damage(SpellDamageSource.player(actualSchool, data1.caster()), (float) amount);}
                    decreaseEffectLevel(data1.caster(), MRPGCEffects.ADRENALINE_GAIN,1);
                }
                return true;
            }
            return true;
        });

        /////FORCEMASTER_SPELLS
        /// STRAIGHT PUNCH
        CustomSpellHandler.register(new Identifier(MOD_ID, "straight_punch"), (data) -> {
            MagicSchool actualSchool = MagicSchool.PHYSICAL_MELEE;
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            float modifier = getSpell(new Identifier(MOD_ID, "straight_punch")).impact[0].action.damage.spell_power_coefficient;
            for (Entity entity : data1.targets()) {
                SpellPower.Result power = SpellPower.getSpellPower(actualSchool, data1.caster());
                SpellPower.Vulnerability vulnerability;
                if (entity instanceof LivingEntity living) {
                    vulnerability = SpellPower.getVulnerability(living, actualSchool);
                    double amount = modifier * power.randomValue(vulnerability);
                    entity.damage(SpellDamageSource.player(actualSchool, data1.caster()), (float) amount);
                    SoundHelper.playSound(data1.caster().getWorld(), living, getSpell(new Identifier(MOD_ID, "straight_punch")).impact[0].sound);
                    if (data1.caster().hasStatusEffect(MRPGCEffects.STONE_HAND)) {
                        living.addStatusEffect(new StatusEffectInstance(MRPGCEffects.STUNNED, stun_duration_straight_punch));
                    }
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
                List<Entity> list = data1.caster().getWorld().getOtherEntities(data1.caster(), data1.caster().getBoundingBox().expand(getSpell(new Identifier(MOD_ID, "burstcrack")).range), selectionPredicate);
                for (Entity entity : list) {
                    SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, getSpell(new Identifier(MOD_ID, "burstcrack")), data1.impactContext());
                    SoundHelper.playSound(data1.caster().getWorld(), entity, getSpell(new Identifier(MOD_ID, "burstcrack")).impact[0].sound);
                    Vec3d currentMovement = entity.getVelocity();
                    entity.setVelocity(currentMovement.x, currentMovement.y + knockup_burstcrack, currentMovement.z);
                    entity.velocityModified = true;
                    if (data1.caster().hasStatusEffect(MRPGCEffects.STONE_HAND)) {
                        SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity , getSpell(new Identifier(MOD_ID, "burstcrack")), data1.impactContext());
                        SoundHelper.playSound(data1.caster().getWorld(), entity, getSpell(new Identifier(MOD_ID, "burstcrack")).impact[0].sound);
                        Vec3d currentMovement2 = entity.getVelocity();
                        entity.setVelocity(currentMovement2.x, currentMovement2.y + knockup_burstcrack_stonehand, currentMovement2.z);
                        entity.velocityModified = true;
                    }
                }
            }
            return true;
        });
        /// BELIAL SMASHING
        CustomSpellHandler.register(new Identifier(MOD_ID, "belial_smashing"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            List<Entity> list = TargetHelper.targetsFromRaycast(data1.caster(), getSpell(new Identifier(MOD_ID,"belial_smashing")).range, Objects::nonNull);
            if (!data1.caster().getWorld().isClient) {
                data1.caster().velocityDirty = true;
                data1.caster().velocityModified = true;
                Vec3d rotationVector = data1.caster().getRotationVector();
                Vec3d velocity = data1.caster().getVelocity();
                data1.caster().addVelocity(rotationVector.x * 0.1 + (rotationVector.x * 2.5 - velocity.x) * speed_belial_smashing,  0, rotationVector.z * 0.1 + (rotationVector.z * 2.5 - velocity.z) * speed_belial_smashing);
                for (Entity entity : list) {
                    SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, getSpell(new Identifier(MOD_ID, "belial_smashing")), data1.impactContext());
                    Vec3d currentMovement2 = entity.getVelocity();
                    entity.setVelocity(currentMovement2.x, currentMovement2.y + 0.6f, currentMovement2.z);
                }
            }
            return true;
        });

    }
}
