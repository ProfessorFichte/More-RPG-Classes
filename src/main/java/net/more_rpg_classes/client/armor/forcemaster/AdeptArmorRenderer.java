package net.more_rpg_classes.client.armor.forcemaster;

import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;
import net.more_rpg_classes.item.armor.AdeptArmor;

public class AdeptArmorRenderer extends GeoArmorRenderer<AdeptArmor> {
    public AdeptArmorRenderer() {
        super(new AdeptArmorModel());
    }
}