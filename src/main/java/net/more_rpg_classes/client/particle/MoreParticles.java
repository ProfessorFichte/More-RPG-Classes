package net.more_rpg_classes.client.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;

public class MoreParticles {
    public static final SimpleParticleType STUN_PAR = FabricParticleTypes.simple();
    public static final SimpleParticleType BLOOD_DROP = FabricParticleTypes.simple();
    public static final SimpleParticleType MOLTEN_ARMOR= FabricParticleTypes.simple();
    public static final SimpleParticleType BUBBLE = FabricParticleTypes.simple();
    public static final SimpleParticleType BUBBLE_POP = FabricParticleTypes.simple();
    public static final SimpleParticleType WATER_MIST = FabricParticleTypes.simple();
    public static final SimpleParticleType SPLASH = FabricParticleTypes.simple();
    public static final SimpleParticleType BIG_SPLASH = FabricParticleTypes.simple();
    public static final SimpleParticleType WAVE = FabricParticleTypes.simple();
    public static final SimpleParticleType DRIPPING_WATER = FabricParticleTypes.simple();
    public static final SimpleParticleType HOT_SPLASH = FabricParticleTypes.simple();
    public static final SimpleParticleType WATER_WHIP = FabricParticleTypes.simple();
    public static final SimpleParticleType WATER_CIRCLE = FabricParticleTypes.simple();
    public static final SimpleParticleType WATER_HEAL = FabricParticleTypes.simple();
    public static final SimpleParticleType WATER_SPLASH = FabricParticleTypes.simple();
    public static final SimpleParticleType STONE_EXPLOSION = FabricParticleTypes.simple();
    public static final SimpleParticleType STONE_PARTICLE = FabricParticleTypes.simple();
    public static final SimpleParticleType WIND_VACUUM = FabricParticleTypes.simple();
    public static final SimpleParticleType SMALL_GUST = FabricParticleTypes.simple();


    public static void register(){
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "stun_particle"), STUN_PAR);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "blood_drop"), BLOOD_DROP);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "molten_armor"), MOLTEN_ARMOR);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "bubble"), BUBBLE);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "bubble_pop"), BUBBLE_POP);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "water_mist"), WATER_MIST);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "splash"), SPLASH);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "big_splash"), BIG_SPLASH);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "wave"), WAVE);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "dripping_water"), DRIPPING_WATER);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "hot_splash"), HOT_SPLASH);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "water_whip"), WATER_WHIP);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "water_circle"), WATER_CIRCLE);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "water_heal"), WATER_HEAL);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "water_splash"), WATER_SPLASH);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "stone_explosion"), STONE_EXPLOSION);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "stone_particle"), STONE_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "wind_vacuum"), WIND_VACUUM);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MRPGCMod.MOD_ID, "small_gust"), SMALL_GUST);
    }

}
