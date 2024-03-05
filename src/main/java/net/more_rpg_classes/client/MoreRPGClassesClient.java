package net.more_rpg_classes.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.*;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.client.effect.*;
import net.more_rpg_classes.client.particle.MoreParticles;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.spell_engine.api.effect.CustomModelStatusEffect;
import net.spell_engine.api.effect.CustomParticleStatusEffect;
import net.spell_engine.api.render.CustomModels;

import java.util.List;

import static net.more_rpg_classes.MRPGCMod.MOD_ID;

@Environment(EnvType.CLIENT)
public class MoreRPGClassesClient implements ClientModInitializer {

    public void  onInitializeClient(){
        CustomModels.registerModelIds(List.of(
                new Identifier(MOD_ID, "projectile/barqesna_projectile"),
                new Identifier(MOD_ID, "projectile/lightning_bolt"),
                new Identifier(MOD_ID, "projectile/fist_projectile"),
                FrozenSolidRenderer.modelId,
                RageRenderer.modelIdRage,
                IceImpaledRenderer.modelId,
                ArcaneOverDriveRenderer.modelId,
                SoulDevourerRenderer.modelId
        ));


        ParticleFactoryRegistry.getInstance().register(MoreParticles.IGNI_SIGN, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.YRDEN_SIGN, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.AARD_SIGN, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.QUEN_SIGN, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.AXII_SIGN, FireworksSparkParticle.ExplosionFactory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.RAGE_PAR, DamageParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.STUN_PAR, DamageParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.ASAL_EXPLODE, ExplosionLargeParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.SMALL_THUNDER, ExplosionLargeParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.BARQ_ESNA_FLAME, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.BLOOD_DROP, DamageParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.YRDEN_IMPACT, DamageParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(MoreParticles.ICICLE_FLOOR, SoulParticle.SculkSoulFactory::new);
        //ParticleFactoryRegistry.getInstance().register(MoreParticles.ICICLE_FLOOR, EndRodParticle.Factory::new);

        CustomParticleStatusEffect.register(MRPGCEffects.RAGE, new RageParticles(1));
        CustomParticleStatusEffect.register(MRPGCEffects.AXII, new AxiiParticles(1));
        CustomParticleStatusEffect.register(MRPGCEffects.STUNNED, new StunnedParticles(3));
        CustomParticleStatusEffect.register(MRPGCEffects.MOLTEN_ARMOR, new MoltenArmorParticles(1));
        CustomParticleStatusEffect.register(MRPGCEffects.BARQ_ESNA, new BarqEsnaParticles(1));
        CustomModelStatusEffect.register(MRPGCEffects.FROZEN_SOLID, new FrozenSolidRenderer());
        CustomModelStatusEffect.register(MRPGCEffects.RAGE, new RageRenderer());
        CustomModelStatusEffect.register(MRPGCEffects.ICE_IMPALED, new IceImpaledRenderer());
        CustomModelStatusEffect.register(MRPGCEffects.ARCANE_OVERFLOW, new ArcaneOverDriveRenderer());
        CustomModelStatusEffect.register(MRPGCEffects.SOUL_DEVOURER, new SoulDevourerRenderer());
    }
}
