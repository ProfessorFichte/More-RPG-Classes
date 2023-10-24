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



    public static void register() {
        Registry.register(Registries.SOUND_EVENT, AARD_SIGN_ID, AARD_SIGN_EVENT);
        Registry.register(Registries.SOUND_EVENT, IGNI_SIGN_ID, IGNI_SIGN_EVENT);
        Registry.register(Registries.SOUND_EVENT, QUEN_SIGN_ID, QUEN_SIGN_EVENT);
        Registry.register(Registries.SOUND_EVENT, KNUCKLE_ATTACK_ID, KNUCKLE_ATTACK_EVENT);
        Registry.register(Registries.SOUND_EVENT, ASAL_RELEASE_ID, ASAL_RELEASE_EVENT);
        Registry.register(Registries.SOUND_EVENT, STONEHAND_CAST_ID, STONEHAND_CAST_EVENT);
        Registry.register(Registries.SOUND_EVENT, KNUCKLE_SPELL_CAST_ID, KNUCKLE_SPELL_CAST_EVENT);
        Registry.register(Registries.SOUND_EVENT, KNUCKLE_SPELL_IMPACT_ID, KNUCKLE_SPELL_IMPACT_EVENT);
    }
}