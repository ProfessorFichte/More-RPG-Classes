package net.more_rpg_classes.client.armor.forcemaster;

import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;
import net.more_rpg_classes.item.armor.OrieneArmor;

public class OrieneArmorRenderer extends GeoArmorRenderer<OrieneArmor> {
    public OrieneArmorRenderer() {
        super(new OrieneArmorModel());
    }
}
