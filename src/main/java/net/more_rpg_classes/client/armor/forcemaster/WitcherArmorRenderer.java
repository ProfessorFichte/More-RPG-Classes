package net.more_rpg_classes.client.armor.forcemaster;

import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;
import net.more_rpg_classes.item.armor.WitcherArmor;

public class WitcherArmorRenderer extends GeoArmorRenderer<WitcherArmor> {
    public WitcherArmorRenderer() {
        super(new WitcherArmorModel());
    }
}
