package net.more_rpg_classes.entity.attribute;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;

public class MRPGCEntityAttributes{
    public static EntityAttribute DAMAGE_REFLECT_MODIFIER = createAttribute(
            "damage_reflect_modifier", 100.0, 100.0, 1024.0);
    public static EntityAttribute ARCANE_FUSE_MODIFIER = createAttribute(
            "arcane_fuse_modifier", 100.0, 100.0, 1024.0);
    public static EntityAttribute LIFESTEAL_MODIFIER = createAttribute(
            "lifesteal_modifier", 100.0, 100.0, 1024.0);
    public static EntityAttribute RAGE_MODIFIER = createAttribute(
            "rage_modifier", 100.0, 100.0, 1024.0);



    public static void registerAttributes(){
        register("damage_reflect_modifier", DAMAGE_REFLECT_MODIFIER);
        register("arcane_fuse_modifier", ARCANE_FUSE_MODIFIER);
        register("lifesteal_modifier", LIFESTEAL_MODIFIER);
        register("rage_modifier", RAGE_MODIFIER);
    }


    public static EntityAttribute register(String id, EntityAttribute attribute){
        return Registry.register(Registries.ATTRIBUTE, new Identifier(MRPGCMod.MOD_ID, id), attribute);
    }
    private static EntityAttribute createAttribute(final String name, double base, double min, double max){
        return new ClampedEntityAttribute("attribute.name.generic." + MRPGCMod.MOD_ID + '.' +name, base, min, max).setTracked(true);
    }
}
