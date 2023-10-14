package net.more_rpg_classes.entity.attribute;

import net.more_rpg_classes.MRPGCMod;
import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MRPGCEntityAttributes{

    public static final EntityAttribute INCOMING_DAMAGE_MODIFIER = createAttribute(
            "incoming_damage_modifier", 0.0f, -10.0f, 10.0f);



    public static EntityAttribute register(String id, EntityAttribute attribute){
        return Registry.register(Registries.ATTRIBUTE, new Identifier(MRPGCMod.MOD_ID, id), attribute);
    }
    private static EntityAttribute createAttribute(final String name, double base, double min, double max){
        return new ClampedEntityAttribute("attribute.name.generic." + MRPGCMod.MOD_ID + '.' +name, base, min, max).setTracked(true);
    }

    public static void registerAttributes(){
        register("incoming_damage_modifier", INCOMING_DAMAGE_MODIFIER);
    }
}
