package net.more_rpg_classes.client.armor.forcemaster;

import mod.azure.azurelibarmor.model.GeoModel;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;
import net.more_rpg_classes.item.armor.PhaslebArmor;

public class PhaslebArmorModel extends GeoModel<PhaslebArmor> {
    @Override
    public Identifier getModelResource(PhaslebArmor object) {
        return new Identifier(MRPGCMod.MOD_ID, "geo/phasleb_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(PhaslebArmor armor) {
        return new Identifier(MRPGCMod.MOD_ID, "textures/armor/phasleb_armor.png");
    }

    @Override
    public Identifier getAnimationResource(PhaslebArmor animatable) {
        return null;
    }

}
