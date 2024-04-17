package net.more_rpg_classes.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.DamageParticle;
import net.minecraft.client.particle.RainSplashParticle;
import net.more_rpg_classes.client.effect.FrostedParticles;
import net.more_rpg_classes.client.effect.FrozenSolidRenderer;
import net.more_rpg_classes.client.effect.MoltenArmorParticles;
import net.more_rpg_classes.client.particle.MoreParticles;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.spell_engine.api.effect.CustomModelStatusEffect;
import net.spell_engine.api.effect.CustomParticleStatusEffect;
import net.spell_engine.api.render.CustomModels;
import net.spell_engine.api.render.StunParticleSpawner;

import java.util.List;

@Environment(EnvType.CLIENT)
public class MoreRPGClassesClient implements ClientModInitializer {

    public void  onInitializeClient(){
        CustomModels.registerModelIds(List.of(
                FrozenSolidRenderer.modelId
        ));


        ParticleFactoryRegistry.getInstance().register(MoreParticles.STUN_PAR, DamageParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.BLOOD_DROP, DamageParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.MOLTEN_ARMOR, RainSplashParticle.Factory::new);

        CustomParticleStatusEffect.register(MRPGCEffects.STUNNED, new StunParticleSpawner());
        CustomParticleStatusEffect.register(MRPGCEffects.MOLTEN_ARMOR, new MoltenArmorParticles(1));
        CustomParticleStatusEffect.register(MRPGCEffects.FROSTED, new FrostedParticles(3));
        CustomModelStatusEffect.register(MRPGCEffects.FROZEN_SOLID, new FrozenSolidRenderer());

    }
}
