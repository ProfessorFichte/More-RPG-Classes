package net.more_rpg_classes.client.armor.forcemaster;

import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;
import net.more_rpg_classes.item.armor.WildlingArmor;

public class WildlingArmorRenderer extends GeoArmorRenderer<WildlingArmor> {
    public WildlingArmorRenderer() {
        super(new WildlingArmorModel());
    }
}
