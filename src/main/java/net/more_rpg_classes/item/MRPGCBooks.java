package net.more_rpg_classes.item;

import net.more_rpg_classes.MRPGCMod;
import net.minecraft.util.Identifier;
import net.spell_engine.api.item.trinket.SpellBooks;

public class MRPGCBooks {
    public static void register() {
            SpellBooks.createAndRegister(new Identifier(MRPGCMod.MOD_ID,"berserker"),MRPGCGroup.KEY);
            SpellBooks.createAndRegister(new Identifier(MRPGCMod.MOD_ID,"witcher"),MRPGCGroup.KEY);
            SpellBooks.createAndRegister(new Identifier(MRPGCMod.MOD_ID,"forcemaster"),MRPGCGroup.KEY);
    }
}