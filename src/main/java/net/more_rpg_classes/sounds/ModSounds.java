package net.more_rpg_classes.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

import static net.more_rpg_classes.MRPGCMod.MOD_ID;

public class ModSounds {
    public static List<String> soundKeys = List.of(
            "icicle_crash",
            "strong_attack",
            "crippling_strike",
            "crippling_strike",
            "water_magic_impact1",
            "earth_magic_impact1",
            "earth_magic_impact2",
            "earth_magic_cast1"
    );
    public static Map<String, Float> soundDistances = Map.of(
    );

    public static void registerSounds() {
        for (var soundKey: soundKeys) {
            var soundId = Identifier.of(MOD_ID, soundKey);
            var customTravelDistance = soundDistances.get(soundKey);
            var soundEvent = (customTravelDistance == null)
                    ? SoundEvent.of(soundId)
                    : SoundEvent.of(soundId, customTravelDistance);
            Registry.register(Registries.SOUND_EVENT, soundId, soundEvent);
        }
    }
}