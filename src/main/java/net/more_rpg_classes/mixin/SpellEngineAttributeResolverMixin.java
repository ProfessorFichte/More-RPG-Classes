package net.more_rpg_classes.mixin;

import net.spell_engine.api.item.AttributeResolver;
import org.spongepowered.asm.mixin.Mixin;


@Mixin(AttributeResolver.class)
public class SpellEngineAttributeResolverMixin {
    /*private static final HashMap<Identifier, EntityAttribute> attributes = new HashMap<>();
    @Inject(method = "setup", at = @At("TAIL"))
    private static void setup(CallbackInfo ci){
        if (FabricLoader.getInstance().isModLoaded("more_rpg_classes")) {
            register(MRPGCEntityAttributes.incoming_damage_id,MRPGCEntityAttributes.INCOMING_DAMAGE_MODIFIER);
        }
    }
    private static void register(Identifier id, EntityAttribute attribute) {
        attributes.put(id, attribute);
    }*/
}
