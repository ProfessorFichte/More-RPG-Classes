package net.more_rpg_classes.mixin;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.spell_engine.api.item.AttributeResolver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;

@Mixin(AttributeResolver.class)
public class SpellEngineAttributeResolverMixin {
    private static final HashMap<Identifier, EntityAttribute> attributes = new HashMap<>();
    private static void register(Identifier id, EntityAttribute attribute) {
        attributes.put(id, attribute);
    }

    @Inject(method = "setup", at = @At("TAIL"), remap = false)
    private static void init(CallbackInfo ci){
        if (FabricLoader.getInstance().isModLoaded("more_rpg_classes")) {
            register(new Identifier("more_rpg_classes", "incoming_damage_modifier"), MRPGCEntityAttributes.INCOMING_DAMAGE_MODIFIER);
            register(new Identifier("more_rpg_classes", "damage_reflect_modifier"), MRPGCEntityAttributes.DAMAGE_REFLECT_MODIFIER);
            register(new Identifier("more_rpg_classes", "arcane_fuse_modifier"), MRPGCEntityAttributes.ARCANE_FUSE_MODIFIER);
            register(new Identifier("more_rpg_classes", "lifesteal_modifier"), MRPGCEntityAttributes.LIFESTEAL_MODIFIER);
            register(new Identifier("more_rpg_classes", "sign_intensity"), MRPGCEntityAttributes.SIGN_INTENSITY);
            register(new Identifier("more_rpg_classes", "rage_modifier"), MRPGCEntityAttributes.RAGE_MODIFIER);
            register(new Identifier("more_rpg_classes", "adrenaline_modifier"), MRPGCEntityAttributes.ADRENALINE_MODIFIER);
            register(new Identifier("more_rpg_classes", "incoming_damage_reduction"), MRPGCEntityAttributes.INCOMING_DAMAGE_REDUCTION);
        }
    }
}
