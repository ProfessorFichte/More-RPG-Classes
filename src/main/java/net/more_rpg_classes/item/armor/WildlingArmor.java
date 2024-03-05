package net.more_rpg_classes.item.armor;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import mod.azure.azurelibarmor.animatable.GeoItem;
import mod.azure.azurelibarmor.animatable.client.RenderProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import net.more_rpg_classes.client.armor.forcemaster.WildlingArmorRenderer;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.spell_engine.api.item.armor.Armor;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.UUID;
import java.util.function.Consumer;

public class WildlingArmor extends ModArmorItem implements GeoItem {
    public WildlingArmor(Armor.CustomMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    private static final EnumMap MODIFIERS = (EnumMap) Util.make(new EnumMap(Type.class), (uuidMap) -> {
        uuidMap.put(Type.BOOTS, UUID.fromString("2199e856-3554-4e66-bc5d-a794036d1901"));
        uuidMap.put(Type.LEGGINGS, UUID.fromString("1c6c4b4b-239b-497b-a65b-bde7c0455c60"));
        uuidMap.put(Type.CHESTPLATE, UUID.fromString("b8ce9a43-75be-4be8-b216-daa59c98b00a"));
        uuidMap.put(Type.HELMET, UUID.fromString("12ff6ec7-fe28-4ed6-a953-02da932ebd78"));
    });

    public void setAttributes(Multimap<EntityAttribute, EntityAttributeModifier> attributes) {
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.putAll(attributes);
        UUID uuid = (UUID)MODIFIERS.get(this.type);
        builder.put(MRPGCEntityAttributes.RAGE_MODIFIER,new EntityAttributeModifier(uuid,"rage_inc",0.02, EntityAttributeModifier.Operation.MULTIPLY_BASE));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED,new EntityAttributeModifier(uuid,"atk_speed",0.010, EntityAttributeModifier.Operation.MULTIPLY_BASE));
        this.attributes = builder.build();
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private WildlingArmorRenderer renderer;

            @Override
            public @NotNull BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, BipedEntityModel<LivingEntity> original) {
                if (renderer == null)
                    renderer = new WildlingArmorRenderer();

                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return renderer;
            }
        });
    }

}
