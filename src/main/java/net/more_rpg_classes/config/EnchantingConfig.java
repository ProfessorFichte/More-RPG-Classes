package net.more_rpg_classes.config;

import net.more_rpg_classes.custom.Enchantment_CustomSpellSchool;
import net.tinyconfig.versioning.VersionableConfig;

public class EnchantingConfig extends VersionableConfig {
    public boolean allow_stacking = true;
    public PowerEnchantingConfig elemental_mastery = new PowerEnchantingConfig(true, 5, 10, 9, 0.03F);

    public EnchantingConfig() {
    }

    public void apply() {
        Enchantment_CustomSpellSchool.ELEMENTAL.config = this.elemental_mastery ;
    }
}
