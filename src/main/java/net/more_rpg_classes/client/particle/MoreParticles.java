package net.more_rpg_classes.client.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;

public class MoreParticles {
    public static final DefaultParticleType IGNI_SIGN = FabricParticleTypes.simple();
    public static final DefaultParticleType YRDEN_SIGN = FabricParticleTypes.simple();
    public static final DefaultParticleType AARD_SIGN = FabricParticleTypes.simple();
    public static final DefaultParticleType QUEN_SIGN = FabricParticleTypes.simple();
    public static final DefaultParticleType AXII_SIGN = FabricParticleTypes.simple();
    public static final DefaultParticleType RAGE_PAR = FabricParticleTypes.simple();
    public static final DefaultParticleType STUN_PAR = FabricParticleTypes.simple();
    public static final DefaultParticleType ASAL_EXPLODE = FabricParticleTypes.simple();
    public static final DefaultParticleType BARQ_ESNA_FLAME = FabricParticleTypes.simple();
    public static final DefaultParticleType SMALL_THUNDER = FabricParticleTypes.simple();
    public static final DefaultParticleType BLOOD_DROP = FabricParticleTypes.simple();
    public static final DefaultParticleType YRDEN_IMPACT = FabricParticleTypes.simple();


    public static void register(){
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "igni_sign_cast"), IGNI_SIGN);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "yrden_sign_cast"), YRDEN_SIGN);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "aard_sign_cast"), AARD_SIGN);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "quen_sign_cast"), QUEN_SIGN);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "axii_sign_cast"), AXII_SIGN);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "rage_particle"), RAGE_PAR);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "stun_particle"), STUN_PAR);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "asal_explode"), ASAL_EXPLODE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "barq_esna_flame"), BARQ_ESNA_FLAME);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "small_thunder"), SMALL_THUNDER);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "blood_drop"), BLOOD_DROP);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "yrden_impact"), YRDEN_IMPACT);
    }

}
