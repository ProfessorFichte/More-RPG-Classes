package net.more_rpg_classes.compat;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;

import static net.more_rpg_classes.MRPGCMod.MOD_ID;

public class CompatDatapackLoader {
    public static void register(){



        if(FabricLoader.getInstance().isModLoaded("kevstierifymodifiers") && MRPGCMod.tweaksConfig.value.kevstierifymodifiers_compat) {
            ResourceManagerHelper.registerBuiltinResourcePack(Identifier.of("kevstierifymodifiers_mrpgc"),
                    FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(), ResourcePackActivationType.ALWAYS_ENABLED);
        }
        if(FabricLoader.getInstance().isModLoaded("simplyskills") && MRPGCMod.tweaksConfig.value.simply_skills_compat) {
            ResourceManagerHelper.registerBuiltinResourcePack(Identifier.of("simplyskills_mrpgc"),
                    FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(), ResourcePackActivationType.ALWAYS_ENABLED);
        }
        if((FabricLoader.getInstance().isModLoaded("tiered") && MRPGCMod.tweaksConfig.value.tieredz_compat)) {
            ResourceManagerHelper.registerBuiltinResourcePack(Identifier.of("tieredz_mrpgc"),
                    FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(), ResourcePackActivationType.ALWAYS_ENABLED);
        }
        if(FabricLoader.getInstance().isModLoaded("tierify") && MRPGCMod.tweaksConfig.value.tierify_compat) {
            ResourceManagerHelper.registerBuiltinResourcePack(Identifier.of("tierify_mrpgc"),
                    FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(), ResourcePackActivationType.ALWAYS_ENABLED);
        }
    }

}
