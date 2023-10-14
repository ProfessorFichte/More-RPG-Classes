package net.more_rpg_classes.client.effect;

import net.minecraft.entity.LivingEntity;
import net.spell_engine.api.effect.CustomParticleStatusEffect;
import net.spell_engine.api.spell.ParticleBatch;
import net.spell_engine.particle.ParticleHelper;

public class MoltenArmorParticles implements CustomParticleStatusEffect.Spawner{
    private final ParticleBatch particles;

    public MoltenArmorParticles(int particleCount) {
        this.particles = new ParticleBatch(
                "minecraft:lava",
                ParticleBatch.Shape.SPHERE, ParticleBatch.Origin.LAUNCH_POINT,
                null, particleCount, 0.1F, 0.3F, 0);
    }

    @Override
    public void spawnParticles(LivingEntity livingEntity, int amplifier) {
        var scaledParticles = new ParticleBatch(particles);
        scaledParticles.count *= (amplifier + 1);
        ParticleHelper.play(livingEntity.getWorld(), livingEntity, scaledParticles);
    }
}
