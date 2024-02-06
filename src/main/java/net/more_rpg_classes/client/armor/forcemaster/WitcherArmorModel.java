package net.more_rpg_classes.client.armor.forcemaster;

import mod.azure.azurelibarmor.model.GeoModel;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;
import net.more_rpg_classes.item.armor.WitcherArmor;

public class WitcherArmorModel extends GeoModel<WitcherArmor> {
    @Override
    public Identifier getModelResource(WitcherArmor object) {
        return new Identifier(MRPGCMod.MOD_ID, "geo/witcher_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(WitcherArmor armor) {
        return new Identifier(MRPGCMod.MOD_ID, "textures/armor/witcher_armor.png");
    }

    @Override
    public Identifier getAnimationResource(WitcherArmor animatable) {
        return null;
    }
}
