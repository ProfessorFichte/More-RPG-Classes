package net.fichte.more_rpg_classes.client.effect;

import net.minecraft.entity.LivingEntity;
import net.spell_engine.api.effect.CustomParticleStatusEffect;
import net.spell_engine.api.spell.ParticleBatch;
import net.spell_engine.particle.ParticleHelper;

public class RageParticles implements CustomParticleStatusEffect.Spawner{
    private final ParticleBatch particles;

    public RageParticles(int particleCount) {
        this.particles = new ParticleBatch(
                "minecraft:angry_villager",
                ParticleBatch.Shape.PIPE, ParticleBatch.Origin.LAUNCH_POINT,
                null, particleCount, 0.00001F, 0.00002F, 0);
    }

    @Override
    public void spawnParticles(LivingEntity livingEntity, int amplifier) {
        var scaledParticles = new ParticleBatch(particles);
        scaledParticles.count *= (amplifier + 1);
        ParticleHelper.play(livingEntity.getWorld(), livingEntity, scaledParticles);
    }
}

