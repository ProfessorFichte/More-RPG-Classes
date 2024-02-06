package net.more_rpg_classes.client.armor.forcemaster;

import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;
import net.more_rpg_classes.item.armor.NorthlingArmor;

public class NorthlingArmorRenderer extends GeoArmorRenderer<NorthlingArmor> {
    public NorthlingArmorRenderer() {
        super(new NorthlingArmorModel());
    }
}
