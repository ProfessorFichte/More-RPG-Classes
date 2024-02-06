package net.more_rpg_classes.client.armor.forcemaster;

import mod.azure.azurelibarmor.model.GeoModel;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;
import net.more_rpg_classes.item.armor.AdeptArmor;

public class AdeptArmorModel extends GeoModel<AdeptArmor> {
    @Override
    public Identifier getModelResource(AdeptArmor object) {
        return new Identifier(MRPGCMod.MOD_ID, "geo/adept_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(AdeptArmor armor) {
        return new Identifier(MRPGCMod.MOD_ID, "textures/armor/adept_armor.png");
    }

    @Override
    public Identifier getAnimationResource(AdeptArmor animatable) {
        return null;
    }
}
