package net.more_rpg_classes.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.more_rpg_classes.MRPGCMod;
import net.more_rpg_classes.client.effect.FrozenSolidRenderer;
import net.more_rpg_classes.client.effect.MoltenArmorParticles;
import net.more_rpg_classes.client.effect.RageParticles;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.minecraft.client.particle.SoulParticle;
import net.spell_engine.api.effect.CustomModelStatusEffect;
import net.spell_engine.api.effect.CustomParticleStatusEffect;
import net.spell_engine.api.render.CustomModels;

import java.util.List;

public class MoreRPGClassesClient implements ClientModInitializer{



    @Override
    public void onInitializeClient() {
        CustomModels.registerModelIds(List.of(
                FrozenSolidRenderer.modelId
        ));


        ParticleFactoryRegistry.getInstance().register(MRPGCMod.IGNI_SIGN, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MRPGCMod.AARD_SIGN, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MRPGCMod.QUEN_SIGN, SoulParticle.Factory::new);

        CustomParticleStatusEffect.register(MRPGCEffects.RAGE, new RageParticles(1));
        CustomParticleStatusEffect.register(MRPGCEffects.MOLTEN_ARMOR, new MoltenArmorParticles(1));
        CustomModelStatusEffect.register(MRPGCEffects.FROZEN_SOLID, new FrozenSolidRenderer());

    }
}
