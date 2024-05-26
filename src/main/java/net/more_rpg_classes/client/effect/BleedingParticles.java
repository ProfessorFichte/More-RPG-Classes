package net.more_rpg_classes.client.effect;

import net.minecraft.entity.LivingEntity;
import net.spell_engine.api.effect.CustomParticleStatusEffect;
import net.spell_engine.api.spell.ParticleBatch;
import net.spell_engine.particle.ParticleHelper;

public class BleedingParticles implements CustomParticleStatusEffect.Spawner{
    private final ParticleBatch particles;

    public BleedingParticles(int particleCount) {
        this.particles = new ParticleBatch(
                "more_rpg_classes:blood_drop",
                ParticleBatch.Shape.SPHERE, ParticleBatch.Origin.CENTER,
                null, particleCount, 0.05F, 0.08F, 360);
    }

    @Override
    public void spawnParticles(LivingEntity livingEntity, int amplifier) {
        var scaledParticles = new ParticleBatch(particles);
        scaledParticles.count *= (1);
        ParticleHelper.play(livingEntity.getWorld(), livingEntity, scaledParticles);
    }
}
