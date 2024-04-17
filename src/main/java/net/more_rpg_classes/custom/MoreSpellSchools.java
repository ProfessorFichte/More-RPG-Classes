package net.more_rpg_classes.custom;

import net.spell_power.api.SpellSchool;
import net.spell_power.api.SpellSchools;

public class MoreSpellSchools {
    public static final SpellSchool EARTH = SpellSchools.register(SpellSchools.createMagic("earth", 0xbd8b00));
    public static final SpellSchool WATER = SpellSchools.register(SpellSchools.createMagic("water", 0x4dd9ff));
    public static final SpellSchool AIR = SpellSchools.register(SpellSchools.createMagic("air", 0xd4e3fe));

    public static void initialize() {
        SpellSchools.register(EARTH);
        SpellSchools.register(WATER);
        SpellSchools.register(AIR);
    }
}
