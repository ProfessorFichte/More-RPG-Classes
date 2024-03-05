package net.more_rpg_classes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.more_rpg_classes.blocks.MRPGCBlocks;
import net.more_rpg_classes.client.particle.MoreParticles;
import net.more_rpg_classes.config.Default;
import net.more_rpg_classes.custom.custom_spells.CustomSpells;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.more_rpg_classes.item.MRPGCGroup;
import net.more_rpg_classes.item.MRPGCItems;
import net.more_rpg_classes.item.armor.Armors;
import net.more_rpg_classes.item.weapons.WeaponsRegister;
import net.more_rpg_classes.sounds.ModSounds;
import net.more_rpg_classes.util.loot.MRPGCLootTableChestModifiers;
import net.more_rpg_classes.util.loot.MRPGCLootTableEntityModifiers;
import net.more_rpg_classes.worldgen.OreGen;
import net.spell_engine.api.item.ItemConfig;
import net.spell_engine.api.loot.LootConfig;
import net.spell_engine.api.loot.LootHelper;
import net.spell_power.tinyconfig.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MRPGCMod implements ModInitializer {
	public static final String MOD_ID = "more_rpg_classes";
	public static final Logger LOGGER = LoggerFactory.getLogger("more_rpg_classes");

	public static ConfigManager<ItemConfig> itemConfig = new ConfigManager<ItemConfig>
			("items_1", Default.itemConfig)
			.builder()
			.setDirectory(MOD_ID)
			.sanitize(true)
			.build();

	public static ConfigManager<LootConfig> lootConfig = new ConfigManager<>
			("loot_1", Default.lootConfig)
			.builder()
			.setDirectory(MOD_ID)
			.sanitize(true)
			.constrain(LootConfig::constrainValues)
			.build();

	private void registerItemGroup() {
		MRPGCGroup.MRPGC = FabricItemGroup.builder()
				.icon(() -> new ItemStack(Armors.phaslebArmorSet.chest.asItem()))
				.displayName(Text.translatable("itemGroup." + MOD_ID + ".general"))
				.build();
		Registry.register(Registries.ITEM_GROUP, MRPGCGroup.KEY, MRPGCGroup.MRPGC);
	}

	private void subscribeEvents() {
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			LootHelper.configure(id, tableBuilder, MRPGCMod.lootConfig.value, MRPGCItems.entries);
		});
	}


		@Override
	public void onInitialize() {
		lootConfig.refresh();
		itemConfig.refresh();
		MRPGCItems.registerModItems();
		MRPGCGroup.registerItemGroups();
		OreGen.register();
		MRPGCBlocks.register();
		MRPGCLootTableEntityModifiers.modifyLootEntityTables();
		MRPGCLootTableChestModifiers.modifyChestLootTables();
		MRPGCEffects.register();
		CustomSpells.register();
		MRPGCEntityAttributes.registerAttributes();
		MoreParticles.register();
		ModSounds.register();
		WeaponsRegister.register(itemConfig.value.weapons);
		Armors.register(itemConfig.value.armor_sets);
		itemConfig.save();
		registerItemGroup();
		subscribeEvents();
	}
}