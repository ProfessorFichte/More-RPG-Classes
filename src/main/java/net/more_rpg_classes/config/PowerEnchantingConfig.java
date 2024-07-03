package net.more_rpg_classes.config;

import net.tinyconfig.models.EnchantmentConfig;

public class PowerEnchantingConfig extends EnchantmentConfig {
    public boolean requires_related_attributes = false;

    public PowerEnchantingConfig(boolean requires_related_attributes, int max_level, int min_cost, int step_cost, float bonus_per_level) {
        super(max_level, min_cost, step_cost, bonus_per_level);
        this.requires_related_attributes = requires_related_attributes;
    }
}
