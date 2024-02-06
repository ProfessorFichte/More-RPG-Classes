package net.more_rpg_classes.client.armor.forcemaster;

import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;
import net.more_rpg_classes.item.armor.PhaslebArmor;

public class PhaslebArmorRenderer extends GeoArmorRenderer<PhaslebArmor> {
    public PhaslebArmorRenderer() {
        super(new PhaslebArmorModel());
    }
}
