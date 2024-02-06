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
import net.more_rpg_classes.client.armor.forcemaster.NorthlingArmorRenderer;
import net.spell_engine.api.item.armor.Armor;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.UUID;
import java.util.function.Consumer;

public class NorthlingArmor extends ModArmorItem implements GeoItem {
    public NorthlingArmor(Armor.CustomMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    private static final EnumMap MODIFIERS = (EnumMap) Util.make(new EnumMap(Type.class), (uuidMap) -> {
        uuidMap.put(Type.BOOTS, UUID.fromString("1834090e-2df8-4b36-be51-ce552df4f93b"));
        uuidMap.put(Type.LEGGINGS, UUID.fromString("cc66063b-a5ad-4008-b948-c3380d5b2be6"));
        uuidMap.put(Type.CHESTPLATE, UUID.fromString("a5b538b0-f22d-4a3e-8bc6-af3e8cf3f83a"));
        uuidMap.put(Type.HELMET, UUID.fromString("82bbb149-54e4-42d4-831f-f088090f5eb1"));
    });

    public void setAttributes(Multimap<EntityAttribute, EntityAttributeModifier> attributes) {
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.putAll(attributes);
        UUID uuid = (UUID)MODIFIERS.get(this.type);
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED,new EntityAttributeModifier(uuid,"attack_speed",0.15f, EntityAttributeModifier.Operation.ADDITION));
        this.attributes = builder.build();
    }


    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private NorthlingArmorRenderer renderer;

            @Override
            public @NotNull BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, BipedEntityModel<LivingEntity> original) {
                if (renderer == null)
                    renderer = new NorthlingArmorRenderer();

                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return renderer;
            }
        });
    }

}
