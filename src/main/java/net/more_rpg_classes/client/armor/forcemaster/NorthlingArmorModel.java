package net.more_rpg_classes.client.armor.forcemaster;

import mod.azure.azurelibarmor.model.GeoModel;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;
import net.more_rpg_classes.item.armor.NorthlingArmor;
import net.more_rpg_classes.item.armor.OrieneArmor;

public class NorthlingArmorModel extends GeoModel<NorthlingArmor> {
    @Override
    public Identifier getModelResource(NorthlingArmor object) {
        return new Identifier(MRPGCMod.MOD_ID, "geo/northling_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(NorthlingArmor armor) {
        return new Identifier(MRPGCMod.MOD_ID, "textures/armor/northling_armor.png");
    }

    @Override
    public Identifier getAnimationResource(NorthlingArmor animatable) {
        return null;
    }
}
