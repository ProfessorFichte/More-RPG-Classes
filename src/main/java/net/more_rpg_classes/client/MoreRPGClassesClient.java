package net.more_rpg_classes.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.*;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;
import net.more_rpg_classes.client.effect.*;
import net.more_rpg_classes.client.particle.MoreParticles;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.spell_engine.api.effect.CustomModelStatusEffect;
import net.spell_engine.api.effect.CustomParticleStatusEffect;
import net.spell_engine.api.render.CustomModels;

import java.util.List;

@Environment(EnvType.CLIENT)
public class MoreRPGClassesClient implements ClientModInitializer{

    @Override
    public void onInitializeClient() {
        CustomModels.registerModelIds(List.of(
                new Identifier(MRPGCMod.MOD_ID, "projectile/barqesna_projectile"),
                FrozenSolidRenderer.modelId
        ));
        ParticleFactoryRegistry.getInstance().register(MoreParticles.IGNI_SIGN, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.AARD_SIGN, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.QUEN_SIGN, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.RAGE_PAR, BubblePopParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.STUN_PAR, DamageParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.ASAL_EXPLODE, ExplosionLargeParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.SMALL_THUNDER, ExplosionLargeParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.BARQ_ESNA_FLAME, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.BLOOD_DROP, DamageParticle.Factory::new);

        CustomParticleStatusEffect.register(MRPGCEffects.RAGE, new RageParticles(1));
        CustomParticleStatusEffect.register(MRPGCEffects.STUNNED, new StunnedParticles(3));
        CustomParticleStatusEffect.register(MRPGCEffects.MOLTEN_ARMOR, new MoltenArmorParticles(1));
        CustomParticleStatusEffect.register(MRPGCEffects.BARQ_ESNA, new BarqEsnaParticles(1));
        CustomModelStatusEffect.register(MRPGCEffects.FROZEN_SOLID, new FrozenSolidRenderer());

    }
}
