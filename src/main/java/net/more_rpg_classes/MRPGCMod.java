package net.more_rpg_classes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.more_rpg_classes.item.MRPGCBooks;
import net.more_rpg_classes.item.MRPGCGroup;
import net.more_rpg_classes.item.MRPGCItems;
import net.more_rpg_classes.util.MRPGCLootTableChestModifiers;
import net.more_rpg_classes.util.MRPGCLootTableEntityModifiers;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MRPGCMod implements ModInitializer {
	public static final String MOD_ID = "more_rpg_classes";
	public static final Logger LOGGER = LoggerFactory.getLogger("more_rpg_classes");

	public static final DefaultParticleType IGNI_SIGN = FabricParticleTypes.simple();
	public static final DefaultParticleType AARD_SIGN = FabricParticleTypes.simple();
	public static final DefaultParticleType QUEN_SIGN = FabricParticleTypes.simple();


	@Override
	public void onInitialize() {
		MRPGCItems.registerModItems();
		MRPGCGroup.registerItemGroups();
		MRPGCLootTableEntityModifiers.modifyLootEntityTables();
		MRPGCLootTableChestModifiers.modifyChestLootTables();
		MRPGCEffects.register();
		MRPGCBooks.register();
		MRPGCEntityAttributes.registerAttributes();
		Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "igni_sign_cast"), IGNI_SIGN);
		Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "aard_sign_cast"), AARD_SIGN);
		Registry.register(Registries.PARTICLE_TYPE, new Identifier(MRPGCMod.MOD_ID, "quen_sign_cast"), QUEN_SIGN);
	}

}