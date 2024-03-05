package net.more_rpg_classes.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;

public class ModSounds {

    public static final Identifier AARD_SIGN_ID = new Identifier(MRPGCMod.MOD_ID, "aard_sign");
    public static SoundEvent AARD_SIGN_EVENT= SoundEvent.of(AARD_SIGN_ID);
    public static final Identifier IGNI_SIGN_ID = new Identifier(MRPGCMod.MOD_ID, "igni_sign");
    public static SoundEvent IGNI_SIGN_EVENT= SoundEvent.of(IGNI_SIGN_ID);
    public static final Identifier QUEN_SIGN_ID = new Identifier(MRPGCMod.MOD_ID, "quen_sign");
    public static SoundEvent QUEN_SIGN_EVENT= SoundEvent.of(QUEN_SIGN_ID);
    public static final Identifier KNUCKLE_ATTACK_ID = new Identifier(MRPGCMod.MOD_ID, "knuckle_attack");
    public static SoundEvent KNUCKLE_ATTACK_EVENT= SoundEvent.of(KNUCKLE_ATTACK_ID);
    public static final Identifier ASAL_RELEASE_ID = new Identifier(MRPGCMod.MOD_ID, "asal_release");
    public static SoundEvent ASAL_RELEASE_EVENT= SoundEvent.of(ASAL_RELEASE_ID);
    public static final Identifier STONEHAND_CAST_ID = new Identifier(MRPGCMod.MOD_ID, "stonehand_cast");
    public static SoundEvent STONEHAND_CAST_EVENT= SoundEvent.of(STONEHAND_CAST_ID);
    public static final Identifier KNUCKLE_SPELL_CAST_ID = new Identifier(MRPGCMod.MOD_ID, "knuckle_spell_cast");
    public static SoundEvent KNUCKLE_SPELL_CAST_EVENT= SoundEvent.of(KNUCKLE_SPELL_CAST_ID);
    public static final Identifier KNUCKLE_SPELL_IMPACT_ID = new Identifier(MRPGCMod.MOD_ID, "knuckle_spell_impact");
    public static SoundEvent KNUCKLE_SPELL_IMPACT_EVENT= SoundEvent.of(KNUCKLE_SPELL_IMPACT_ID);
    public static final Identifier YRDEN_SIGN_ID = new Identifier(MRPGCMod.MOD_ID, "yrden_sign");
    public static SoundEvent YRDEN_SIGN_EVENT= SoundEvent.of(YRDEN_SIGN_ID);
    public static final Identifier AARD_FROST_SIGN_ID = new Identifier(MRPGCMod.MOD_ID, "aard_frost_sign");
    public static SoundEvent AARD_FROST_SIGN_EVENT= SoundEvent.of(AARD_FROST_SIGN_ID);
    public static final Identifier AXII_SIGN_ID = new Identifier(MRPGCMod.MOD_ID, "axii_sign");
    public static SoundEvent AXII_SIGN_EVENT= SoundEvent.of(AXII_SIGN_ID);
    public static final Identifier QUEN_BREAK_ID = new Identifier(MRPGCMod.MOD_ID, "quen_sign_break");
    public static SoundEvent QUEN_BREAK_EVENT= SoundEvent.of(QUEN_BREAK_ID);
    public static final Identifier REND_SPELL_ID = new Identifier(MRPGCMod.MOD_ID, "rend_spell");
    public static SoundEvent REND_SPELL_EVENT= SoundEvent.of(REND_SPELL_ID);
    public static final Identifier ICICLE_SPELL_ID = new Identifier(MRPGCMod.MOD_ID, "icicle_crash");
    public static SoundEvent ICICLE_SPELL_EVENT= SoundEvent.of(ICICLE_SPELL_ID);
    public static final Identifier WHIRL_ID = new Identifier(MRPGCMod.MOD_ID, "whirl");
    public static SoundEvent WHIRL_EVENT= SoundEvent.of(WHIRL_ID);
    public static final Identifier STRONG_ATTACK_ID = new Identifier(MRPGCMod.MOD_ID, "strong_attack");
    public static SoundEvent STRONG_ATTACK_EVENT= SoundEvent.of(STRONG_ATTACK_ID);
    public static final Identifier CRIPPLING_STRIKE_ID = new Identifier(MRPGCMod.MOD_ID, "crippling_strike");
    public static SoundEvent CRIPPLING_STRIKE_EVENT= SoundEvent.of(CRIPPLING_STRIKE_ID);
    public static final Identifier SLAHS_IMPACT_ID = new Identifier(MRPGCMod.MOD_ID, "slash_impact");
    public static SoundEvent SLAHS_IMPACT_EVENT= SoundEvent.of(SLAHS_IMPACT_ID);
    public static final Identifier SONIC_HAND_ID = new Identifier(MRPGCMod.MOD_ID, "sonic_hand");
    public static SoundEvent SONIC_HAND_EVENT= SoundEvent.of(SONIC_HAND_ID);




    public static void register() {
        Registry.register(Registries.SOUND_EVENT, AARD_SIGN_ID, AARD_SIGN_EVENT);
        Registry.register(Registries.SOUND_EVENT, IGNI_SIGN_ID, IGNI_SIGN_EVENT);
        Registry.register(Registries.SOUND_EVENT, QUEN_SIGN_ID, QUEN_SIGN_EVENT);
        Registry.register(Registries.SOUND_EVENT, KNUCKLE_ATTACK_ID, KNUCKLE_ATTACK_EVENT);
        Registry.register(Registries.SOUND_EVENT, ASAL_RELEASE_ID, ASAL_RELEASE_EVENT);
        Registry.register(Registries.SOUND_EVENT, STONEHAND_CAST_ID, STONEHAND_CAST_EVENT);
        Registry.register(Registries.SOUND_EVENT, KNUCKLE_SPELL_CAST_ID, KNUCKLE_SPELL_CAST_EVENT);
        Registry.register(Registries.SOUND_EVENT, KNUCKLE_SPELL_IMPACT_ID, KNUCKLE_SPELL_IMPACT_EVENT);
        Registry.register(Registries.SOUND_EVENT, YRDEN_SIGN_ID, YRDEN_SIGN_EVENT);
        Registry.register(Registries.SOUND_EVENT, AARD_FROST_SIGN_ID, AARD_FROST_SIGN_EVENT);
        Registry.register(Registries.SOUND_EVENT, AXII_SIGN_ID, AXII_SIGN_EVENT);
        Registry.register(Registries.SOUND_EVENT, QUEN_BREAK_ID, QUEN_BREAK_EVENT);
        Registry.register(Registries.SOUND_EVENT, REND_SPELL_ID, REND_SPELL_EVENT);
        Registry.register(Registries.SOUND_EVENT, ICICLE_SPELL_ID, ICICLE_SPELL_EVENT);
        Registry.register(Registries.SOUND_EVENT, WHIRL_ID, WHIRL_EVENT);
        Registry.register(Registries.SOUND_EVENT, STRONG_ATTACK_ID, STRONG_ATTACK_EVENT);
        Registry.register(Registries.SOUND_EVENT, CRIPPLING_STRIKE_ID, CRIPPLING_STRIKE_EVENT);
        Registry.register(Registries.SOUND_EVENT, SLAHS_IMPACT_ID, SLAHS_IMPACT_EVENT);
        Registry.register(Registries.SOUND_EVENT, SONIC_HAND_ID, SONIC_HAND_EVENT);

    }
}