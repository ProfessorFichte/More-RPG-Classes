package net.more_rpg_classes.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;

public class ModSounds {
    public static final Identifier ICICLE_SPELL_ID = new Identifier(MRPGCMod.MOD_ID, "icicle_crash");
    public static SoundEvent ICICLE_SPELL_EVENT= SoundEvent.of(ICICLE_SPELL_ID);
    public static final Identifier STRONG_ATTACK_ID = new Identifier(MRPGCMod.MOD_ID, "strong_attack");
    public static SoundEvent STRONG_ATTACK_EVENT= SoundEvent.of(STRONG_ATTACK_ID);
    public static final Identifier CRIPPLING_STRIKE_ID = new Identifier(MRPGCMod.MOD_ID, "crippling_strike");
    public static SoundEvent CRIPPLING_STRIKE_EVENT= SoundEvent.of(CRIPPLING_STRIKE_ID);
    public static final Identifier SLAHS_IMPACT_ID = new Identifier(MRPGCMod.MOD_ID, "slash_impact");
    public static SoundEvent SLAHS_IMPACT_EVENT= SoundEvent.of(SLAHS_IMPACT_ID);
    public static final Identifier WATER_IMPACT1_ID = new Identifier(MRPGCMod.MOD_ID, "water_magic_impact1");
    public static SoundEvent WATER_IMPACT1= SoundEvent.of(WATER_IMPACT1_ID);
    public static final Identifier EARTH_IMPACT1_ID = new Identifier(MRPGCMod.MOD_ID, "earth_magic_impact1");
    public static SoundEvent EARTH_IMPACT1= SoundEvent.of(EARTH_IMPACT1_ID);
    public static final Identifier EARTH_IMPACT2_ID = new Identifier(MRPGCMod.MOD_ID, "earth_magic_impact2");
    public static SoundEvent EARTH_IMPACT2= SoundEvent.of(EARTH_IMPACT2_ID);
    public static final Identifier EARTH_CAST1_ID = new Identifier(MRPGCMod.MOD_ID, "earth_magic_cast1");
    public static SoundEvent EARTH_CAST1= SoundEvent.of(EARTH_CAST1_ID);

    public static void register() {
        Registry.register(Registries.SOUND_EVENT, ICICLE_SPELL_ID, ICICLE_SPELL_EVENT);
        Registry.register(Registries.SOUND_EVENT, STRONG_ATTACK_ID, STRONG_ATTACK_EVENT);
        Registry.register(Registries.SOUND_EVENT, CRIPPLING_STRIKE_ID, CRIPPLING_STRIKE_EVENT);
        Registry.register(Registries.SOUND_EVENT, SLAHS_IMPACT_ID, SLAHS_IMPACT_EVENT);
        Registry.register(Registries.SOUND_EVENT, WATER_IMPACT1_ID, WATER_IMPACT1);
        Registry.register(Registries.SOUND_EVENT, EARTH_IMPACT1_ID, EARTH_IMPACT1);
        Registry.register(Registries.SOUND_EVENT, EARTH_IMPACT2_ID, EARTH_IMPACT2);
        Registry.register(Registries.SOUND_EVENT, EARTH_CAST1_ID, EARTH_CAST1);

    }
}