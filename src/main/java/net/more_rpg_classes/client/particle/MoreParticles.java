package net.more_rpg_classes.client.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;

public class MoreParticles {
    public static final DefaultParticleType STUN_PAR = FabricParticleTypes.simple();
    public static final DefaultParticleType BLOOD_DROP = FabricParticleTypes.simple();
    public static final DefaultParticleType MOLTEN_ARMOR= FabricParticleTypes.simple();


    public static void register(){
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "stun_particle"), STUN_PAR);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "blood_drop"), BLOOD_DROP);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "molten_armor"), MOLTEN_ARMOR);
    }

}
