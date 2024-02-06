package net.more_rpg_classes.client.effect;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.more_rpg_classes.MRPGCMod;
import net.spell_engine.api.effect.CustomModelStatusEffect;
import net.spell_engine.api.render.CustomLayers;
import net.spell_engine.api.render.CustomModels;
import net.spell_engine.api.render.LightEmission;

public class RageRenderer implements CustomModelStatusEffect.Renderer{
    private static final RenderLayer RENDER_LAYER = CustomLayers.spellEffect(LightEmission.RADIATE, false);
    public static final Identifier modelIdRage = new Identifier(MRPGCMod.MOD_ID, "effect/rage_model");

    @Override
    public void renderEffect(int amplifier, LivingEntity livingEntity, float delta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumers, int light) {
        var itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        var camera =  MinecraftClient.getInstance().gameRenderer.getCamera();
        var direction = camera.getPos().subtract(livingEntity.getPos()).normalize().multiply(livingEntity.getWidth() * 0.5F);
        matrixStack.push();
        matrixStack.translate(direction.x, direction.y + livingEntity.getHeight() * 1.1F, direction.z + -0.15F);
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180F + (float)Math.toDegrees(Math.atan2(direction.x, direction.z)) ));
        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(camera.getPitch()));
        CustomModels.render(RENDER_LAYER, itemRenderer, modelIdRage, matrixStack, vertexConsumers, light, livingEntity.getId());
        matrixStack.pop();
    }
}
