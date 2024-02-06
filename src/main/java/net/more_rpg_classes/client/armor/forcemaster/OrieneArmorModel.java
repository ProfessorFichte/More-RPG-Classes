package net.more_rpg_classes.client.armor.forcemaster;

import mod.azure.azurelibarmor.model.GeoModel;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;
import net.more_rpg_classes.item.armor.OrieneArmor;

public class OrieneArmorModel extends GeoModel<OrieneArmor> {
    @Override
    public Identifier getModelResource(OrieneArmor object) {
        return new Identifier(MRPGCMod.MOD_ID, "geo/oriene_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(OrieneArmor armor) {
        return new Identifier(MRPGCMod.MOD_ID, "textures/armor/oriene_armor.png");
    }

    @Override
    public Identifier getAnimationResource(OrieneArmor animatable) {
        return null;
    }
}