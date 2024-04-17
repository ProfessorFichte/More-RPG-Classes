package net.more_rpg_classes.entity.attribute;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;

public class MRPGCEntityAttributes{

    public static final String incoming_damage_name = "incoming_damage_modifier";
    public static final Identifier incoming_damage_id = new Identifier(MRPGCMod.MOD_ID + ":" + incoming_damage_name);
    public static final EntityAttribute INCOMING_DAMAGE_MODIFIER = createAttribute(
            "incoming_damage_modifier", 100.0, 100.0, 1024.0);
    public static final EntityAttribute DAMAGE_REFLECT_MODIFIER = createAttribute(
            "damage_reflect_modifier", 100.0, 100.0, 1024.0);
    public static final EntityAttribute ARCANE_FUSE_MODIFIER = createAttribute(
            "arcane_fuse_modifier", 100.0, 100.0, 1024.0);
    public static final EntityAttribute LIFESTEAL_MODIFIER = createAttribute(
            "lifesteal_modifier", 100.0, 100.0, 1024.0);
    public static final EntityAttribute SIGN_INTENSITY = createAttribute(
            "sign_intensity", 0.0, 0.0, 1024.0);
    public static final EntityAttribute RAGE_MODIFIER = createAttribute(
            "rage_modifier", 100.0, 100.0, 1024.0);
    public static final EntityAttribute ADRENALINE_MODIFIER = createAttribute(
            "adrenaline_modifier", 100.0, 100.0, 1024.0);
    public static final EntityAttribute INCOMING_DAMAGE_REDUCTION = createAttribute(
            "incoming_damage_reduction", 100.0, 100.0, 1024.0);


    public static EntityAttribute register(String id, EntityAttribute attribute){
        return Registry.register(Registries.ATTRIBUTE, new Identifier(MRPGCMod.MOD_ID, id), attribute);
    }
    private static EntityAttribute createAttribute(final String name, double base, double min, double max){
        return new ClampedEntityAttribute("attribute.name.generic." + MRPGCMod.MOD_ID + '.' +name, base, min, max).setTracked(true);
    }


    public static void registerAttributes(){
        register("incoming_damage_modifier", INCOMING_DAMAGE_MODIFIER);
        register("damage_reflect_modifier", DAMAGE_REFLECT_MODIFIER);
        register("arcane_fuse_modifier", ARCANE_FUSE_MODIFIER);
        register("lifesteal_modifier", LIFESTEAL_MODIFIER);
        register("sign_intensity", SIGN_INTENSITY);
        register("rage_modifier", RAGE_MODIFIER);
        register("adrenaline_modifier", ADRENALINE_MODIFIER);
        register("incoming_damage_reduction", INCOMING_DAMAGE_REDUCTION);
    }
}
