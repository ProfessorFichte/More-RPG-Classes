package net.more_rpg_classes;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.more_rpg_classes.client.particle.MoreParticles;
import net.more_rpg_classes.config.EffectsConfig;
import net.more_rpg_classes.custom.Enchantment_CustomSpellSchool;
import net.more_rpg_classes.custom.MoreSpellSchools;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.more_rpg_classes.item.MRPGCGroup;
import net.more_rpg_classes.item.MRPGCItems;
import net.more_rpg_classes.sounds.ModSounds;
import net.more_rpg_classes.util.loot.MRPGCLootTableEntityModifiers;
import net.tinyconfig.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.spell_power.SpellPowerMod.enchantmentConfig;

public class MRPGCMod implements ModInitializer {
	public static final String MOD_ID = "more_rpg_classes";
	public static final Logger LOGGER = LoggerFactory.getLogger("more_rpg_classes");

	public static ConfigManager<EffectsConfig> effectsConfig = new ConfigManager<EffectsConfig>
			("effects", new EffectsConfig())
			.builder()
			.setDirectory(MOD_ID)
			.sanitize(true)
			.build();

		@Override
	public void onInitialize() {
		MRPGCItems.registerModItems();
		MRPGCGroup.registerItemGroups();
		MRPGCLootTableEntityModifiers.modifyLootEntityTables();
		effectsConfig.refresh();
		MRPGCEffects.register();
		MRPGCEntityAttributes.registerAttributes();
		MoreParticles.register();
		ModSounds.register();
		MoreSpellSchools.initialize();

			for(var entry: Enchantment_CustomSpellSchool.all.entrySet()) {
				Registry.register(Registries.ENCHANTMENT, entry.getKey(), entry.getValue());
			}
			enchantmentConfig.value.apply();
			Enchantment_CustomSpellSchool.attach();
	}

}


