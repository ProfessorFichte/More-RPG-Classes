package net.more_rpg_classes.client.armor.forcemaster;

import mod.azure.azurelibarmor.model.GeoModel;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;
import net.more_rpg_classes.item.armor.WildlingArmor;

public class WildlingArmorModel extends GeoModel<WildlingArmor> {
    @Override
    public Identifier getModelResource(WildlingArmor object) {
        return new Identifier(MRPGCMod.MOD_ID, "geo/wildling_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(WildlingArmor armor) {
        return new Identifier(MRPGCMod.MOD_ID, "textures/armor/wildling_armor.png");
    }

    @Override
    public Identifier getAnimationResource(WildlingArmor animatable) {
        return null;
    }
}