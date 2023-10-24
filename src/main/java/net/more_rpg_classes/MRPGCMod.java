package net.more_rpg_classes;

import net.fabricmc.api.ModInitializer;
import net.more_rpg_classes.client.particle.MoreParticles;
import net.more_rpg_classes.custom.custom_spells.CustomSpells;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.more_rpg_classes.item.MRPGCBooks;
import net.more_rpg_classes.item.MRPGCGroup;
import net.more_rpg_classes.item.MRPGCItems;
import net.more_rpg_classes.sounds.ModSounds;
import net.more_rpg_classes.util.MRPGCLootTableChestModifiers;
import net.more_rpg_classes.util.MRPGCLootTableEntityModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MRPGCMod implements ModInitializer {
	public static final String MOD_ID = "more_rpg_classes";
	public static final Logger LOGGER = LoggerFactory.getLogger("more_rpg_classes");

	@Override
	public void onInitialize() {
		MRPGCItems.registerModItems();
		MRPGCGroup.registerItemGroups();
		MRPGCLootTableEntityModifiers.modifyLootEntityTables();
		MRPGCLootTableChestModifiers.modifyChestLootTables();
		MRPGCEffects.register();
		MRPGCBooks.register();
		CustomSpells.register();
		MRPGCEntityAttributes.registerAttributes();
		MoreParticles.register();
		ModSounds.register();
	}
}