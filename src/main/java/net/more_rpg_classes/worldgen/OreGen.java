package net.more_rpg_classes.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.more_rpg_classes.MRPGCMod;

public class OreGen {
    public static final Identifier SILVER_ORE_ID = new Identifier(MRPGCMod.MOD_ID, "silver_ore_placed");
    public static final Identifier METEORITE_ORE_ID = new Identifier(MRPGCMod.MOD_ID, "meteorite_ore_placed");
    public static final Identifier DARK_IRON_ORE_ID = new Identifier(MRPGCMod.MOD_ID, "dark_iron_ore_placed");
    public static final RegistryKey<PlacedFeature> SILVER_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MRPGCMod.MOD_ID, "silver_ore_placed"));
    public static final RegistryKey<PlacedFeature> METEORITE_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MRPGCMod.MOD_ID, "meteorite_ore_placed"));
    public static final RegistryKey<PlacedFeature> DARK_IRON_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MRPGCMod.MOD_ID, "dark_iron_ore_placed"));

    public static void register() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                SILVER_ORE_PLACED_KEY
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                METEORITE_ORE_PLACED_KEY
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                DARK_IRON_ORE_PLACED_KEY
        );
    }

}
