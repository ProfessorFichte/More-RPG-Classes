package net.more_rpg_classes.item;

import net.minecraft.entity.attribute.EntityAttributeModifier;

public class ItemConfig {
    public static class Attribute {
        public String id;
        public float value;
        public EntityAttributeModifier.Operation operation;

        public Attribute() {
        }

        public Attribute(String id, float value, EntityAttributeModifier.Operation operation) {
            this.id = id;
            this.value = value;
            this.operation = operation;
        }

        public static net.spell_engine.api.item.ItemConfig.Attribute bonus(String id, float value) {
            return new net.spell_engine.api.item.ItemConfig.Attribute(id, value, EntityAttributeModifier.Operation.ADDITION);
        }

        public static net.spell_engine.api.item.ItemConfig.Attribute multiply(String id, float value) {
            return new net.spell_engine.api.item.ItemConfig.Attribute(id, value, EntityAttributeModifier.Operation.MULTIPLY_BASE);
        }

    }
}
