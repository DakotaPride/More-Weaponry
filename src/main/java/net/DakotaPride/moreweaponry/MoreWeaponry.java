package net.DakotaPride.moreweaponry;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.DakotaPride.moreweaponry.block.MoreWeaponrySignTypes;
import net.DakotaPride.moreweaponry.block.custom.*;
import net.DakotaPride.moreweaponry.block.entity.CirtictForgeBlock;
import net.DakotaPride.moreweaponry.block.entity.CoreForgeBlock;
import net.DakotaPride.moreweaponry.block.entity.EssenceTranslatorBlock;
import net.DakotaPride.moreweaponry.block.skulls.BardSkullBlock;
import net.DakotaPride.moreweaponry.block.skulls.CracklerSkullBlock;
import net.DakotaPride.moreweaponry.block.skulls.SickenedSkullBlock;
import net.DakotaPride.moreweaponry.effect.MoreWeaponryEffects;
import net.DakotaPride.moreweaponry.effect.status_effects.BleedingStatusEffect;
import net.DakotaPride.moreweaponry.effect.status_effects.NumbedStatusEffect;
import net.DakotaPride.moreweaponry.effect.status_effects.base.CelestialEffect;
import net.DakotaPride.moreweaponry.effect.status_effects.base.UnfortunedEffect;
import net.DakotaPride.moreweaponry.effect.status_effects.celestial.*;
import net.DakotaPride.moreweaponry.effect.status_effects.unfortuned.*;
import net.DakotaPride.moreweaponry.enchantments.*;
import net.DakotaPride.moreweaponry.entity.MoreWeaponryEntityRegistry;
import net.DakotaPride.moreweaponry.entity.custom.*;
import net.DakotaPride.moreweaponry.item.MoreWeaponryItems;
import net.DakotaPride.moreweaponry.item.items.*;
import net.DakotaPride.moreweaponry.item.items.bard_tools.*;
import net.DakotaPride.moreweaponry.item.items.blessed_tools.BlessedArmorItem;
import net.DakotaPride.moreweaponry.item.items.celestial_madalian.*;
import net.DakotaPride.moreweaponry.item.items.cirtict.CooledCirtictClusterItem;
import net.DakotaPride.moreweaponry.item.items.cirtict.HeatedCirtictClusterItem;
import net.DakotaPride.moreweaponry.item.items.cirtict.cooled.*;
import net.DakotaPride.moreweaponry.item.items.cirtict.essence.*;
import net.DakotaPride.moreweaponry.item.items.cirtict.heated.*;
import net.DakotaPride.moreweaponry.item.items.cores.*;
import net.DakotaPride.moreweaponry.item.items.crackler_tools.*;
import net.DakotaPride.moreweaponry.item.items.elder_scale_items.ElderScaleArtifactItem;
import net.DakotaPride.moreweaponry.item.items.mod_tools.BattleaxeItem;
import net.DakotaPride.moreweaponry.item.items.mod_tools.BluestoneIgnitor;
import net.DakotaPride.moreweaponry.item.items.mod_tools.KnifeItem;
import net.DakotaPride.moreweaponry.item.items.phantom_helm.PhantomScaleHelm;
import net.DakotaPride.moreweaponry.item.items.powered_cores.*;
import net.DakotaPride.moreweaponry.item.items.sickened_tools.*;
import net.DakotaPride.moreweaponry.item.items.wanderer_tools.*;
import net.DakotaPride.moreweaponry.item.items.watcher_tools.*;
import net.DakotaPride.moreweaponry.painting.MoreWeaponryPaintings;
import net.DakotaPride.moreweaponry.particle.CelestialMedallionParticle;
import net.DakotaPride.moreweaponry.particle.MoreWeaponryParticles;
import net.DakotaPride.moreweaponry.recipe.CirtictForgeRecipe;
import net.DakotaPride.moreweaponry.recipe.CoreForgeRecipe;
import net.DakotaPride.moreweaponry.recipe.EssenceTranslatorRecipe;
import net.DakotaPride.moreweaponry.recipe.MoreWeaponryRecipes;
import net.DakotaPride.moreweaponry.screen.CirtictForgeScreenHandler;
import net.DakotaPride.moreweaponry.screen.CoreForgeScreenHandler;
import net.DakotaPride.moreweaponry.screen.EssenceTranslatorScreenHandler;
import net.DakotaPride.moreweaponry.screen.MoreWeaponryScreenHandlers;
import net.DakotaPride.moreweaponry.structure.*;
import net.DakotaPride.moreweaponry.util.MoreWeaponryHeadLootTables;
import net.DakotaPride.moreweaponry.util.MoreWeaponryLootTableModifiers;
import net.DakotaPride.moreweaponry.util.MoreWeaponryRegistries;
import net.DakotaPride.moreweaponry.util.MoreWeaponryTags;
import net.DakotaPride.moreweaponry.world.dimension.MoreWeaponryPortals;
import net.DakotaPride.moreweaponry.world.features.MoreWeaponryConfiguredFeatures;
import net.DakotaPride.moreweaponry.world.features.tree.FrodonSaplingGenerator;
import net.DakotaPride.moreweaponry.world.gen.MoreWeaponryWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.Ingredient;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Lazy;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.StructureFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.function.Supplier;

import static net.DakotaPride.moreweaponry.MoreWeaponry.MoreWeaponryArmorMaterials.*;
import static net.DakotaPride.moreweaponry.MoreWeaponry.MoreWeaponryMiningLevels.*;
import static net.DakotaPride.moreweaponry.MoreWeaponry.MoreWeaponryToolMaterials.*;


public class MoreWeaponry implements ModInitializer {
	public static final String MOD_ID = "moreweaponry";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	private static <T extends Entity> EntityType<T> registerEntity(String name, EntityType<T> entityType) {
		return Registry.register(Registry.ENTITY_TYPE, new Identifier(MOD_ID, name), entityType);
	}


	// Entities
	public static EntityType<IronBoltEntity> IRON_BOLT;
	public static EntityType<CracklerEntity> CRACKLER_ENTITY;
	public static EntityType<WandererEntity> WANDERER_ENTITY;
	public static EntityType<WatcherEntity> WATCHER_ENTITY;
	public static EntityType<BardEntity> BARD_ENTITY;
	public static EntityType<SickenedEntity> SICKENED_ENTITY;
	public static EntityType<SickenedHuskEntity> SICKENED_HUSK_ENTITY;
	public static EntityType<LeechEntity> LEECH_ENTITY;
	public static EntityType<NecromancerEntity> NECROMANCER_ENTITY;
	public static EntityType<BuriedKnightEntity> BURIED_KNIGHT_ENTITY;
	public static EntityType<CrawlerEntity> CRAWLER_ENTITY;

	// Effects
	public static BardStatusEffect BARD_EFFECT;
	public static SickenedStatusEffect SICKENED_EFFECT;
	public static WandererStatusEffect WANDERER_EFFECT;
	public static CracklerStatusEffect CRACKLER_EFFECT;
	public static WatcherStatusEffect WATCHER_EFFECT;

	public static TickedStatusEffect TICKED_EFFECT;
	public static WebbedStatusEffect WEBBED_EFFECT;
	public static SirenStatusEffect SIREN_EFFECT;
	public static ExplosiveStatusEffect EXPLOSIVE_EFFECT;
	public static PlaguedStatusEffect PLAGUED_EFFECT;

	public static NumbedStatusEffect NUMBED_EFFECT;
	public static BleedingStatusEffect BLEEDING_EFFECT;
	public static CelestialEffect CELESTIAL_EFFECT;
	public static UnfortunedEffect CONFUSION_EFFECT;
	public static UnfortunedEffect OVER_PACKAGED_EFFECT;

	// Enchantments
	public static EvokersRevengeEnchantment EVOKERS_REVENGE_ENCHANT;
	public static PowerOfTheWitherEnchantment POWER_OF_WITHER_ENCHANT;
	public static StrayBonageEnchantment STRAY_BONAGE_ENCHANT;
	public static GuardiansSmiteEnchantment GUARDIANS_SMITE_ENCHANT;
	public static AutoMendingEnchantment AUTO_MENDING_ENCHANT;
	public static BleedingEnchantment BLEEDING_ENCHANT;

	// Paintings
	public static PaintingMotive MASTERS_PAINTING;
	public static PaintingMotive WATCHER_PAINTING;

	// Particles
	public static CelestialMedallionParticle CELESTIAL_MEDALLION_PARTICLE;

	// Recipes
	public static CoreForgeRecipe CORE_FORGE_RECIPE;
	public static EssenceTranslatorRecipe ESSENCE_TRANSLATOR_RECIPE;
	public static CirtictForgeRecipe CIRTICT_FORGE_RECIPE;

	// Screen Handlers
	public static ScreenHandlerType<CoreForgeScreenHandler> CORE_FORGE_SCREEN_HANDLER;
	public static ScreenHandlerType<EssenceTranslatorScreenHandler> ESSENCE_TRANSLATOR_SCREEN_HANDLER;
	public static ScreenHandlerType<CirtictForgeScreenHandler> CIRTICT_FORGE_SCREEN_HANDLER;

	// Sounds
	public static SoundEvent ENTITY_BURIED_KNIGHT_AMBIENT;
	public static SoundEvent ENTITY_BURIED_KNIGHT_DEATH;
	public static SoundEvent ENTITY_BURIED_KNIGHT_HURT;
	public static SoundEvent ENTITY_CRAWLER_AMBIENT;
	public static SoundEvent WARDENS_STEP;

	// Structures
	public static StructureFeature<?> BARD_ROCK = new BardRockStructure();
	public static StructureFeature<?> WANDERER_LIBRARY = new WandererLibraryStructure();
	public static StructureFeature<?> SICKENED_GRAVES = new SickenedGravesStructure();
	public static StructureFeature<?> DARKEST_CAVERN_FORTRESS = new DarkestCavernFortressStructure();

	// Potions
	public static Potion NUMBING_POTION;

	// Items
	public static Item BLASTED_AMETHYST;
	public static Item GLIMMERING_AMETHYST;
	public static Item MOON_STONE_DUST;
	public static Item REFINED_MOON_STONE;
	public static HandleItem HANDLE;
	public static BlockItem KURO_SEEDS;
	public static Item KURO;
	public static Item KURO_BREAD;
	public static NightCuronBrewItem CURON_BREW;
	public static Item FRODON_BOWL;
	public static Item CURON_FLOWER_PETALS;
	public static Item CRUSHED_KURO;
	public static Item BLACKSTONE_INGOT;
	public static HandleItem NETHERITE_HANDLE;
	public static Item MARE_DIAMOND;
	public static Item NETHERITE_NUGGET;
	public static HandleItem AMETHYST_HANDLE;
	public static Item GUARDIAN_SCALE;
	public static Item ELDER_GUARDIAN_SCALE;
	public static Item ELDER_GUARDIANS_EYE;
	public static HandleItem PRISMARINE_HANDLE;
	public static Item WITHER_ESSENCE;
	public static Item WITHER_BONE;
	public static Item PHANTOM_ESSENCE;
	public static PhantomScaleHelm PHANTOM_HELMET;
	public static Item PHANTOM_SCALE;
	public static Item CIRTICT_INGOT;
	public static SwordItem GLIMMERING_SWORD;
	public static ShovelItem GLIMMERING_SHOVEL;
	public static BetterPickaxeItem GLIMMERING_PICKAXE;
	public static BetterAxeItem GLIMMERING_AXE;
	public static BetterHoeItem GLIMMERING_HOE;
	public static BattleaxeItem GLIMMERING_BATTLEAXE;
	public static SwordItem MOON_STONE_SWORD;
	public static ShovelItem MOON_STONE_SHOVEL;
	public static BetterPickaxeItem MOON_STONE_PICKAXE;
	public static BetterAxeItem MOON_STONE_AXE;
	public static BetterHoeItem MOON_STONE_HOE;
	public static BattleaxeItem MOON_STONE_BATTLEAXE;
	public static SwordItem BLACKSTONE_METAL_SWORD;
	public static ShovelItem BLACKSTONE_METAL_SHOVEL;
	public static BetterPickaxeItem BLACKSTONE_METAL_PICKAXE;
	public static BetterAxeItem BLACKSTONE_METAL_AXE;
	public static BetterHoeItem BLACKSTONE_METAL_HOE;
	public static BattleaxeItem BLACKSTONE_METAL_BATTLEAXE;
	public static BattleaxeItem NETHERITE_BATTLEAXE;
	public static BattleaxeItem DIAMOND_BATTLEAXE;
	public static ArmorItem GLIMMERING_HELMET;
	public static ArmorItem GLIMMERING_BREASTPLATE;
	public static ArmorItem GLIMMERING_LEGGINGS;
	public static ArmorItem GLIMMERING_BOOTS;
	public static ArmorItem MOON_STONE_HELMET;
	public static ArmorItem MOON_STONE_BREASTPLATE;
	public static ArmorItem MOON_STONE_LEGGINGS;
	public static ArmorItem MOON_STONE_BOOTS;
	public static ArmorItem BLACKSTONE_METAL_HELMET;
	public static ArmorItem BLACKSTONE_METAL_BREASTPLATE;
	public static ArmorItem BLACKSTONE_METAL_LEGGINGS;
	public static ArmorItem BLACKSTONE_METAL_BOOTS;
	public static ElderScaleArmorItem ELDER_GUARDIAN_SCALE_HELMET;
	public static ElderScaleArmorItem ELDER_GUARDIAN_SCALE_BREASTPLATE;
	public static ElderScaleArmorItem ELDER_GUARDIAN_SCALE_LEGGINGS;
	public static ElderScaleArmorItem ELDER_GUARDIAN_SCALE_BOOTS;
	public static SwordItem ELDER_GUARDIAN_SCALE_SWORD;
	public static ShovelItem ELDER_GUARDIAN_SCALE_SHOVEL;
	public static BetterPickaxeItem ELDER_GUARDIAN_SCALE_PICKAXE;
	public static BetterAxeItem ELDER_GUARDIAN_SCALE_AXE;
	public static BetterHoeItem ELDER_GUARDIAN_SCALE_HOE;
	public static BattleaxeItem ELDER_GUARDIAN_SCALE_BATTLEAXE;
	public static ArmorItem GUARDIAN_SCALE_HELMET;
	public static ArmorItem GUARDIAN_SCALE_BREASTPLATE;
	public static ArmorItem GUARDIAN_SCALE_LEGGINGS;
	public static ArmorItem GUARDIAN_SCALE_BOOTS;
	public static SwordItem GUARDIAN_SCALE_SWORD;
	public static ShovelItem GUARDIAN_SCALE_SHOVEL;
	public static BetterPickaxeItem GUARDIAN_SCALE_PICKAXE;
	public static BetterAxeItem GUARDIAN_SCALE_AXE;
	public static BetterHoeItem GUARDIAN_SCALE_HOE;
	public static BattleaxeItem GUARDIAN_SCALE_BATTLEAXE;
	public static FabricShieldItem GLIMMERING_SHIELD;
	public static FabricShieldItem MOON_STONE_SHIELD;
	public static FabricShieldItem BLACKSTONE_METAL_SHIELD;
	public static FabricShieldItem GUARDIAN_SCALE_SHIELD;
	public static FabricShieldItem ELDER_SCALE_SHIELD;
	public static ElderScaleArtifactItem ELDER_SCALE_ARTIFACT;
	public static KnifeItem GOLDEN_KNIFE;
	public static KnifeItem STONE_KNIFE;
	public static KnifeItem IRON_KNIFE;
	public static KnifeItem DIAMOND_KNIFE;
	public static KnifeItem WOODEN_KNIFE;
	public static KnifeItem NETHERITE_KNIFE;
	public static KnifeItem REFINED_MOON_KNIFE;
	public static KnifeItem GLIMMERED_AMETHYST_KNIFE;
	public static KnifeItem BLACKSTONE_METAL_KNIFE;
	public static KnifeItem GUARDIAN_SCALE_KNIFE;
	public static KnifeItem ELDER_GUARDIAN_SCALE_KNIFE;
	public static BattleaxeItem GOLDEN_BATTLEAXE;
	public static BattleaxeItem WOODEN_BATTLEAXE;
	public static BattleaxeItem STONE_BATTLEAXE;
	public static BattleaxeItem IRON_BATTLEAXE;
	public static BattleaxeItem CIRTICT_BATTLEAXE;
	public static BattleaxeItem HEATED_CIRTICT_BATTLEAXE;
	public static BattleaxeItem COOLED_CIRTICT_BATTLEAXE;
	public static BluestoneIgnitor BLUESTONE_IGNITOR;
	public static Item BLUESTONE_ROCK;
	public static Item CIRTICT_SCRAP;
	public static CooledCirtictIngot COOLED_CIRTICT_INGOT;
	public static MoreWeaponryMusicDiscItem WARDENS_STEP_MUSIC_DISC;
	public static SignItem FRODON_SIGN;
	public static Item DRAGON_SCALE;
	public static ShulkerShellBoots SHULKER_SHELL_BOOTS;
	public static WitherBroadHammerItem WITHER_BROAD_HAMMER;
	public static HandleItem WITHERING_HANDLE;
	public static Item WITHER_BROAD_HAMMER_HEAD;
	public static HeatedCirtictIngot HEATED_CIRTICT_INGOT;
	public static CooledCirtictSword COOLED_CIRTICT_SWORD;
	public static CooledCirtictShovel COOLED_CIRTICT_SHOVEL;
	public static CooledCirtictPickaxe COOLED_CIRTICT_PICKAXE;
	public static CooledCirtictAxe COOLED_CIRTICT_AXE;
	public static CooledCirtictHoe COOLED_CIRTICT_HOE;
	public static CooledCirtictKnife COOLED_CIRTICT_KNIFE;
	public static HeatedCirtictSword HEATED_CIRTICT_SWORD;
	public static HeatedCirtictShovel HEATED_CIRTICT_SHOVEL;
	public static HeatedCirtictPickaxe HEATED_CIRTICT_PICKAXE;
	public static HeatedCirtictAxe HEATED_CIRTICT_AXE;
	public static HeatedCirtictHoe HEATED_CIRTICT_HOE;
	public static HeatedCirtictKnife HEATED_CIRTICT_KNIFE;
	public static SwordItem CIRTICT_SWORD;
	public static ShovelItem CIRTICT_SHOVEL;
	public static BetterPickaxeItem CIRTICT_PICKAXE;
	public static BetterAxeItem CIRTICT_AXE;
	public static BetterHoeItem CIRTICT_HOE;
	public static KnifeItem CIRTICT_KNIFE;
	public static CooledCirtictShield COOLED_CIRTICT_SHIELD;
	public static HeatedCirtictShield HEATED_CIRTICT_SHIELD;
	public static FabricShieldItem CIRTICT_SHIELD;
	public static Item CIRTICT_NUGGET;
	public static HeatedCirtictNugget HEATED_CIRTICT_NUGGET;
	public static CooledCirtictNugget COOLED_CIRTICT_NUGGET;
	public static EndicateStaffItem ENDICATE_STAFF;
	public static HandleItem ENDICATE_HANDLE;
	public static Item SANDSTONE_DUST;
	public static Item WRETCHED_ESSENCE;
	public static Item CIRTICT_CLUSTER;
	public static HeatedCirtictClusterItem HEATED_CIRTICT_CLUSTER;
	public static CooledCirtictClusterItem COOLED_CIRTICT_CLUSTER;
	public static WandererCoreItem WRETCHED_CORE;
	public static WatcherCoreItem WATCHER_CORE;
	public static BardCoreItem MAIDEN_CORE;
	public static SickenedCoreItem PLAGUED_CORE;
	public static SickenedHuskCoreItem SICKENED_HUSK_CORE;
	public static CracklerCoreItem SUPPRESSED_CORE;
	public static EmptyCoreItem MOB_CORE;
	public static ChargedMobCoreItem CHARGED_MOB_CORE;
	public static EssenceCirtictSword ESSENCE_CIRTICT_SWORD;
	public static EssenceCirtictShovel ESSENCE_CIRTICT_SHOVEL;
	public static EssenceCirtictPickaxe ESSENCE_CIRTICT_PICKAXE;
	public static EssenceCirtictAxe ESSENCE_CIRTICT_AXE;
	public static EssenceCirtictHoe ESSENCE_CIRTICT_HOE;
	public static EssenceCirtictKnife ESSENCE_CIRTICT_KNIFE;
	public static EssenceCirtictBattleaxe ESSENCE_CIRTICT_BATTLEAXE;
	public static PoweredWandererItem POWERED_WRETCHED_MOB_CORE;
	public static PoweredWatcherItem POWERED_WATCHER_MOB_CORE;
	public static PoweredBardItem POWERED_MAIDEN_MOB_CORE;
	public static PoweredSickenedItem POWERED_PLAGUED_MOB_CORE;
	public static PoweredSickenedHuskItem POWERED_SICKENED_MOB_CORE;
	public static PoweredCracklerItem POWERED_SUPPRESSED_MOB_CORE;
	public static WatcherAxe WATCHER_ESSENCE_CIRTICT_AXE;
	public static WatcherSword WATCHER_ESSENCE_CIRTICT_SWORD;
	public static WatcherShovel WATCHER_ESSENCE_CIRTICT_SHOVEL;
	public static WatcherPickaxe WATCHER_ESSENCE_CIRTICT_PICKAXE;
	public static WatcherHoe WATCHER_ESSENCE_CIRTICT_HOE;
	public static WatcherBattleaxe WATCHER_ESSENCE_CIRTICT_BATTLEAXE;
	public static WatcherKnife WATCHER_ESSENCE_CIRTICT_KNIFE;
	public static WandererAxe WANDERER_ESSENCE_CIRTICT_AXE;
	public static WandererSword WANDERER_ESSENCE_CIRTICT_SWORD;
	public static WandererShovel WANDERER_ESSENCE_CIRTICT_SHOVEL;
	public static WandererPickaxe WANDERER_ESSENCE_CIRTICT_PICKAXE;
	public static WandererHoe WANDERER_ESSENCE_CIRTICT_HOE;
	public static WandererBattleaxe WANDERER_ESSENCE_CIRTICT_BATTLEAXE;
	public static WandererKnife WANDERER_ESSENCE_CIRTICT_KNIFE;
	public static BardAxe MAIDEN_ESSENCE_CIRTICT_AXE;
	public static BardSword MAIDEN_ESSENCE_CIRTICT_SWORD;
	public static BardShovel MAIDEN_ESSENCE_CIRTICT_SHOVEL;
	public static BardPickaxe MAIDEN_ESSENCE_CIRTICT_PICKAXE;
	public static BardHoe MAIDEN_ESSENCE_CIRTICT_HOE;
	public static BardBattleaxe MAIDEN_ESSENCE_CIRTICT_BATTLEAXE;
	public static BardKnife MAIDEN_ESSENCE_CIRTICT_KNIFE;
	public static Item LEECHING_ESSENCE;
	public static WatcherEffectItem WATCHER_HELMET;
	public static WatcherEffectItem WATCHER_BREASTPLATE;
	public static WatcherStaffItem WATCHER_STAFF;
	public static BoneMealItem WITHER_BONE_MEAL;
	public static Item WATCHER_CLOTH;
	public static Item MAIDEN_STEM;
	public static Item BARD_CLOTH;
	public static Item REINFORCED_BONE;
	public static Item MELODIC_ESSENCE;
	public static Item EXPLOSIVE_ESSENCE;
	public static Item RUSTED_MARE_DIAMOND;
	public static CracklerAxe SUPPRESSED_ESSENCE_CIRTICT_AXE;
	public static CracklerSword SUPPRESSED_ESSENCE_CIRTICT_SWORD;
	public static CracklerShovel SUPPRESSED_ESSENCE_CIRTICT_SHOVEL;
	public static CracklerPickaxe SUPPRESSED_ESSENCE_CIRTICT_PICKAXE;
	public static CracklerHoe SUPPRESSED_ESSENCE_CIRTICT_HOE;
	public static CracklerBattleaxe SUPPRESSED_ESSENCE_CIRTICT_BATTLEAXE;
	public static CracklerKnife SUPPRESSED_ESSENCE_CIRTICT_KNIFE;
	public static SickenedAxe PLAGUED_ESSENCE_CIRTICT_AXE;
	public static SickenedSword PLAGUED_ESSENCE_CIRTICT_SWORD;
	public static SickenedShovel PLAGUED_ESSENCE_CIRTICT_SHOVEL;
	public static SickenedPickaxe PLAGUED_ESSENCE_CIRTICT_PICKAXE;
	public static SickenedHoe PLAGUED_ESSENCE_CIRTICT_HOE;
	public static SickenedBattleaxe PLAGUED_ESSENCE_CIRTICT_BATTLEAXE;
	public static SickenedKnife PLAGUED_ESSENCE_CIRTICT_KNIFE;
	public static SpawnEggItem CRAWLER_SPAWN_EGG;
	public static SpawnEggItem BURIED_KNIGHT_SPAWN_EGG;
	public static SpawnEggItem NECROMANCER_SPAWN_EGG;
	public static SpawnEggItem WATCHER_SPAWN_EGG;
	public static SpawnEggItem BARD_SPAWN_EGG;
	public static SpawnEggItem SICKENED_SPAWN_EGG;
	public static SpawnEggItem LURKER_SPAWN_EGG;
	public static SpawnEggItem WANDERER_SPAWN_EGG;
	public static SpawnEggItem CRACKLER_SPAWN_EGG;
	public static SpawnEggItem LEECH_SPAWN_EGG;
	public static WandererEffectItem WANDERER_HELMET;
	public static WandererEffectItem WANDERER_BREASTPLATE;
	public static CracklerEffectItem CRACKLER_HELMET;
	public static CracklerEffectItem CRACKLER_BREASTPLATE;
	public static BardEffectItem BARD_HELMET;
	public static BardEffectItem BARD_BREASTPLATE;
	public static SickenedEffectItem SICKENED_HELMET;
	public static SickenedEffectItem SICKENED_BREASTPLATE;
	public static ArmorItem RUSTED_MARE_DIAMOND_HELMET;
	public static HeavySwordItem HEAVY_SWORD;
	public static HeavyCrossBowItem HEAVY_CROSSBOW;
	public static IronBoltItem IRON_BOLT_ITEM;
	public static BotheringMightSwordItem BOTHERING_MIGHT;
	public static Item CRAWLER_TOOTH;
	public static Item TITANIUM;
	public static Item BLESSSED_TITANIUM;
	public static Item SPECTRAL_ESSENCE;
	public static BlessedArmorItem BLESSED_HELMET;
	public static BlessedArmorItem BLESSED_BREASTPLATE;
	public static Item HEAVENLY_LEATHER;
	public static CelestialMadalianItem CELESTIAL_MEDALLION;
	public static SickenedCelestialMedallionItem CELESTIAL_MEDALLION_SICKENED;
	public static SickenedHuskCelestialMadalianItem CELESTIAL_MEDALLION_SICKENED_HUSK;
	public static CracklerCelestialMedallionItem CELESTIAL_MEDALLION_CRACKLER;
	public static BardCelestialMedallionItem CELESTIAL_MEDALLION_BARD;
	public static WandererCelestialMedallionItem CELESTIAL_MEDALLION_WANDERER;
	public static WatcherCelestialMedallionItem CELESTIAL_MEDALLION_WATCHER;

	// Blocks
	public static Block MOON_STONE_DUST_BLOCK;
	public static PillarBlock KURO_WHEAT_BLOCK;
	public static Block BLACKSTONE_METAL_BLOCK;
	public static Block GLIMMERING_AMETHYST_BLOCK;
	public static Block LIMESTONE;
	public static Block COBBLED_LIMESTONE;
	public static PillarBlock FRODON_LOG;
	public static PillarBlock FRODON_WOOD;
	public static Block FRODON_PLANKS;
	public static PillarBlock STRIPPED_FRODON_LOG;
	public static PillarBlock STRIPPED_FRODON_WOOD;
	public static LeavesBlock FRODON_LEAVES;
	public static FrodonSaplingBlock FRODON_SAPLING;
	public static FlowerBlock NIGHT_CURON;
	public static SlabBlock FRODON_SLAB;
	public static StairsBlock FRODON_STAIRS;
	public static SlabBlock LIMESTONE_SLAB;
	public static StairsBlock LIMESTONE_STAIRS;
	public static SlabBlock COBBLED_LIMESTONE_SLAB;
	public static StairsBlock COBBLED_LIMESTONE_STAIRS;
	public static FenceBlock FRODON_FENCE;
	public static FenceGateBlock FRODON_FENCE_GATE;
	public static WallBlock LIMESTONE_WALL;
	public static WallBlock COBBLED_LIMESTONE_WALL;
	public static WoodenButtonBlock FRODON_BUTTON;
	public static StoneButtonBlock LIMESTONE_BUTTON;
	public static StoneButtonBlock COBBLESTONE_BUTTON;
	public static StoneButtonBlock COBBLED_LIMESTONE_BUTTON;
	public static PressurePlateBlock FRODON_PRESSURE_PLATE;
	public static PressurePlateBlock LIMESTONE_PRESSURE_PLATE;
	public static PressurePlateBlock COBBLESTONE_PRESSURE_PLATE;
	public static PressurePlateBlock COBBLED_LIMESTONE_PRESSURE_PLATE;
	public static DoorBlock FRODON_DOOR;
	public static TrapdoorBlock FRODON_TRAPDOOR;
	public static Block MARE_DIAMOND_BLOCK;
	public static Block CIRTICT_BLOCK;
	public static Block CROP_CUTTER;
	public static OreBlock MARE_DIAMOND_ORE;
	public static OreBlock DEEPSLATE_MARE_DIAMOND_ORE;
	public static Block BLUESTONE;
	public static Block COBBLED_BLUESTONE;
	public static StairsBlock BLUESTONE_STAIRS;
	public static StairsBlock COBBLED_BLUESTONE_STAIRS;
	public static SlabBlock BLUESTONE_SLAB;
	public static SlabBlock COBBLED_BLUESTONE_SLAB;
	public static WallBlock BLUESTONE_WALL;
	public static WallBlock COBBLED_BLUESTONE_WALL;
	public static Block CIRTICT_DEBRIS;
	public static SandstoneDustBlock SANDSTONE_DUST_BLOCK;
	public static Block CRACKED_DRIPSTONE;
	public static WandererInfestedBlock INFESTED_CRACKED_DRIPSTONE;
	public static WandererInfestedBlock INFESTED_DRIPSTONE;
	public static EssenceTranslatorBlock ESSENCE_TRANSLATOR;
	public static CoreForgeBlock CORE_FORGE;
	public static EndNyliumBlock PEPLEX_NYLIUM;
	public static Block INTOXICATED_STONE;
	public static SickenedStoneGraveBlock SICKENED_STONE_GRAVE;
	public static IntoxicatedGrassBlock INTOXICATED_GRASS_BLOCK;
	public static IntoxicatedFernBlock INTOXICATED_GRASS;
	public static IntoxicatedFernBlock INTOXICATED_FERN;
	public static IntoxicatedTallPlantBlock INTOXICATED_TALL_GRASS;
	public static IntoxicatedTallPlantBlock INTOXICATED_TALL_FERN;
	public static IntoxicatedFlowerBlock INTOXICATED_POPPY;
	public static IntoxicatedFlowerBlock INTOXICATED_DANDELION;
	public static Block PACKED_WATCHER_CLOTH_BLOCK;
	public static WandererSkullBlock WANDERER_SKULL;
	public static WatcherSkullBlock WATCHER_SKULL;
	public static CracklerSkullBlock CRACKLER_SKULL;
	public static SickenedSkullBlock SICKENED_SKULL;
	public static BardSkullBlock BARD_SKULL;
	public static SickenedSkullBlock SICKENED_HUSK_SKULL;
	public static Block WATCHER_SUMMONER;
	public static Block CRACKLER_SUMMONER;
	public static Block WANDERER_SUMMONER;
	public static Block BARD_SUMMONER;
	public static Block SICKENED_SUMMONER;
	public static Block SICKENED_HUSK_SUMMONER;
	public static CirtictForgeBlock CIRTICT_FORGE;
	public static GlassBlock WATCHER_CELESTIAL_BLOCK;
	public static GlassBlock CRYSTALINE_WATCHER_CORE;
	public static GlassBlock CRACKLER_CELESTIAL_BLOCK;
	public static GlassBlock CRYSTALINE_CRACKLER_CORE;
	public static GlassBlock BARD_CELESTIAL_BLOCK;
	public static GlassBlock CRYSTALINE_BARD_CORE;
	public static GlassBlock WANDERER_CELESTIAL_BLOCK;
	public static GlassBlock CRYSTALINE_WANDERER_CORE;
	public static GlassBlock SICKENED_CELESTIAL_BLOCK;
	public static GlassBlock CRYSTALINE_SICKENED_CORE;
	public static Block LIMESTONE_TILES;
	public static Block BLUESTONE_TILES;
	public static Block EMPTY_BOOKSHELF;
	public static Block CORRUPTED_END_STONE_BRICKS;
	public static Block CORRUPTED_END_STONE;
	public static KuroPlantBlock KURO_PLANT;
	public static FlowerPotBlock POTTED_NIGHT_CURON;
	public static WallSignBlock FRODON_WALL_SIGN;
	public static SignBlock FRODON_SIGN_BLOCK;

	// Armor Materials
	public enum MoreWeaponryArmorMaterials implements ArmorMaterial
	{
		GLIMMERING_AMETHYST_ARMOR("glimmering_amethyst", 14,
									new int[]{1, 4, 5, 2}, 13, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME,
				0.0f, 0.0f, () -> Ingredient.ofItems(MoreWeaponryItems.GLIMMERING_AMETHYST)),
		REFINED_MOON_STONE_ARMOR("refined_moon_stone", 16,
								   new int[]{3, 4, 7, 1}, 10, SoundEvents.BLOCK_NOTE_BLOCK_CHIME,
				0.0f, 0.0f, () -> Ingredient.ofItems(MoreWeaponryItems.REFINED_MOON_STONE)),
		BLACKSTONE_METAL_ARMOR("blackstone_metal", 38,
								 new int[]{3, 7, 8, 4}, 16, SoundEvents.BLOCK_BASALT_PLACE,
				3.5f, 0.2f, () -> Ingredient.ofItems(MoreWeaponryItems.BLACKSTONE_INGOT)),
		RUSTED_ARMOR("rusted_mare_diamond", 38,
					   new int[]{3, 7, 8, 4}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
				3.5f, 0.2f, () -> Ingredient.ofItems(MoreWeaponryItems.BLACKSTONE_INGOT)),
		GUARDIAN_SCALE_ARMOR("guardian_scale", 40,
							   new int[]{4, 8, 8, 5}, 17, SoundEvents.ENTITY_GUARDIAN_AMBIENT,
				3.5f, 0.3f, () -> Ingredient.ofItems(MoreWeaponryItems.GUARDIAN_SCALE)),
		ELDER_GUARDIAN_SCALE_ARMOR("elder_guardian_scale", 42,
									 new int[]{5, 8, 9, 6}, 19, SoundEvents.ENTITY_ELDER_GUARDIAN_AMBIENT,
				4.0f, 0.4f, () -> Ingredient.ofItems(MoreWeaponryItems.ELDER_GUARDIAN_SCALE)),
		PHANTOM_SCALE_ARMOR("phantom_scale", 23,
							  new int[]{5, 7, 6, 5}, 18, SoundEvents.ENTITY_PHANTOM_BITE,
				3.5f, 0.3f, () -> Ingredient.ofItems(MoreWeaponryItems.PHANTOM_SCALE)),
		ENDER_ARMOR("ender", 45,
					  new int[]{10, 13, 12, 11}, 21, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
				4.5f, 0.5f, () -> Ingredient.ofItems(MoreWeaponryItems.WATCHER_CLOTH)),
		WANDERER_ARMOR("wanderer", 45,
						 new int[]{9, 12, 11, 10}, 21, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
				4.5f, 0.5f, () -> Ingredient.ofItems(MoreWeaponryItems.WRETCHED_ESSENCE)),
		CRACKLER_ARMOR("crackler", 45,
						 new int[]{7, 10, 9, 8}, 21, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
				4.5f, 0.5f, () -> Ingredient.ofItems(MoreWeaponryItems.EXPLOSIVE_ESSENCE)),
		BARD_ARMOR("bard", 45,
					 new int[]{8, 11, 10, 9}, 21, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
				4.5f, 0.5f, () -> Ingredient.ofItems(MoreWeaponryItems.MELODIC_ESSENCE)),
		SICKENED_ARMOR("sickened", 45,
						 new int[]{6, 9, 8, 7}, 21, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
				4.5f, 0.5f, () -> Ingredient.ofItems(MoreWeaponryItems.LEECHING_ESSENCE)),
		SHULKER_SHELL_ARMOR("shulker_shell", 25,
							  new int[]{5, 9, 8, 6}, 17, SoundEvents.BLOCK_SHULKER_BOX_OPEN,
				5.0f, 0.6f, () -> Ingredient.ofItems(Items.SHULKER_SHELL)),
		CIRTICT_ARMOR("cirtict", 51,
						new int[]{6, 9, 10, 7}, 16, SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE,
				6.5f, 0.7f, () -> Ingredient.ofItems(MoreWeaponryItems.CIRTICT_INGOT)),
		HEATED_CIRTICT_ARMOR("heated_cirtict", 57,
							   new int[]{7, 10, 11, 8}, 17, SoundEvents.ITEM_BUCKET_EMPTY_LAVA,
				7.5f, 0.9f, () -> Ingredient.ofItems(MoreWeaponryItems.HEATED_CIRTICT_INGOT)),
		COOLED_CIRTICT_ARMOR("cooled_cirtict", 57,
							   new int[]{7, 10, 11, 8}, 17, SoundEvents.ITEM_BUCKET_EMPTY_POWDER_SNOW,
				7.5f, 0.9f, () -> Ingredient.ofItems(MoreWeaponryItems.COOLED_CIRTICT_INGOT)),
		BLESSED_ARMOR("blessed", 59,
						new int[]{11, 14, 13, 12}, 21, SoundEvents.PARTICLE_SOUL_ESCAPE,
				7.8f, 1.0f, () -> Ingredient.ofItems(MoreWeaponryItems.SPECTRAL_ESSENCE));

		private static final int[] BASE_DURABILITY;
		private final String name;
		private final int durabilityMultiplier;
		private final int[] protectionAmounts;
		private final int enchantability;
		private final SoundEvent equipSound;
		private final float toughness;
		private final float knockbackResistance;
		private final Lazy<Ingredient> repairIngredientSupplier;

		MoreWeaponryArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
			this.name = name;
			this.durabilityMultiplier = durabilityMultiplier;
			this.protectionAmounts = protectionAmounts;
			this.enchantability = enchantability;
			this.equipSound = equipSound;
			this.toughness = toughness;
			this.knockbackResistance = knockbackResistance;
			this.repairIngredientSupplier = new Lazy<Ingredient>(repairIngredientSupplier);
		}

		@Override
		public int getDurability(EquipmentSlot slot) {
			return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
		}

		@Override
		public int getProtectionAmount(EquipmentSlot slot) {
			return this.protectionAmounts[slot.getEntitySlotId()];
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public SoundEvent getEquipSound() {
			return this.equipSound;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return this.repairIngredientSupplier.get();
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public float getToughness() {
			return this.toughness;
		}

		@Override
		public float getKnockbackResistance() {
			return this.knockbackResistance;
		}

		static {
			BASE_DURABILITY = new int[]{13, 15, 16, 11};
		}
	}

	// Mining Levels
	public static class MoreWeaponryMiningLevels {
		public static final int CIRTICT_LEVEL = 6;

		public static final int COOLED_CIRTICT_LEVEL = 7;

		public static final int HEATED_CIRTICT_LEVEL = 7;

		public static final int GUARDIAN_SCALE_LEVEL = 5;

		public static final int ELDER_GUARDIAN_SCALE_LEVEL = 5;

		public static final int ESSENCE_LEVEL = 8;
	}


	// Tool Materials
	public enum MoreWeaponryToolMaterials implements ToolMaterial {
		GLIMMERING_AMETHYST_TOOLS(MiningLevels.IRON, 546, 6.5f,
				1.5f, 23,
				() -> Ingredient.ofItems(MoreWeaponryItems.GLIMMERING_AMETHYST)),
		REFINED_MOON_STONE_TOOLS(MiningLevels.DIAMOND, 1278,8.5f,
				2.5f, 17,
				() -> Ingredient.ofItems(MoreWeaponryItems.REFINED_MOON_STONE)),
		BLACKSTONE_METAL_TOOLS(MiningLevels.NETHERITE, 2176, 9.5f,
				4.5f, 16,
				() -> Ingredient.ofItems(MoreWeaponryItems.BLACKSTONE_INGOT)),
		GUARDIAN_SCALE_TOOLS(GUARDIAN_SCALE_LEVEL, 2458, 10.0f,
				5.5f, 18,
				() -> Ingredient.ofItems(MoreWeaponryItems.GUARDIAN_SCALE)),
		ELDER_GUARDIAN_SCALE_TOOLS(ELDER_GUARDIAN_SCALE_LEVEL, 2986, 10.5f,
				7.0f, 17,
				() -> Ingredient.ofItems(MoreWeaponryItems.ELDER_GUARDIAN_SCALE)),
		WITHERED_TOOLS(MiningLevels.NETHERITE, 3182, 11.0f,
				8.5f, 14,
				() -> Ingredient.ofItems(MoreWeaponryItems.WITHER_ESSENCE)),
		COOLED_CIRTICT_TOOLS(COOLED_CIRTICT_LEVEL, 3182, 12.0f,
				18.0f, 18,
				() -> Ingredient.ofItems(MoreWeaponryItems.COOLED_CIRTICT_INGOT)),
		CIRTICT_TOOLS(CIRTICT_LEVEL, 3003, 11.5f,
				16.0f, 15,
				() -> Ingredient.ofItems(MoreWeaponryItems.CIRTICT_INGOT)),
		HEATED_CIRTICT_TOOLS(HEATED_CIRTICT_LEVEL, 3182, 12.0f,
				18.0f, 18,
				() -> Ingredient.ofItems(MoreWeaponryItems.HEATED_CIRTICT_INGOT)),
		DRAGON_SCALE_TOOLS(MiningLevels.NETHERITE, 3486, 13.0f,
				19.5f, 18,
				() -> Ingredient.ofItems(MoreWeaponryItems.DRAGON_SCALE)),
		ENDICATE_STAFF_TOOLS(MiningLevels.NETHERITE, 388, 14.0f,
				20.0f, 23,
				() -> Ingredient.ofItems(Items.ENDER_EYE)),
		WATCHER_STAFF_TOOLS(MiningLevels.NETHERITE, 593, 14.0f,
				21.0f, 25,
				() -> Ingredient.ofItems(Items.ENDER_EYE)),
		ESSENCE_CIRTICT_TOOLS(ESSENCE_LEVEL, 3875, 12.5f,
				21.0f, 24,
				() -> Ingredient.ofItems(MoreWeaponryItems.WITHER_ESSENCE));


		private final int miningLevel;
		private final int itemDurability;
		private final float miningSpeed;
		private final float attackDamage;
		private final int enchantability;
		private final Lazy<Ingredient> repairIngredient;

		MoreWeaponryToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
			this.miningLevel = miningLevel;
			this.itemDurability = itemDurability;
			this.miningSpeed = miningSpeed;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
		}

		@Override
		public int getDurability() {
			return this.itemDurability;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return this.miningSpeed;
		}

		@Override
		public float getAttackDamage() {
			return this.attackDamage;
		}

		@Override
		public int getMiningLevel() {
			return this.miningLevel;
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return this.repairIngredient.get();
		}
	}


	// Tools
	private static class BetterPickaxeItem extends PickaxeItem {
		public BetterPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
			super(material, attackDamage, attackSpeed, settings);
		}
	}

	private static class BetterAxeItem extends AxeItem {
		public BetterAxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
			super(material, attackDamage, attackSpeed, settings);
		}
	}

	private static class BetterHoeItem extends HoeItem {
		public BetterHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
			super(material, attackDamage, attackSpeed, settings);
		}
	}

	// Register
	public static <T extends Block> T registerBlock(String name, T block) {
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, name), block);
		return block;
	}

	public static <T extends Item> T registerItem(String name, T item) {
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, name), item);
		return item;
	}

	public static <T extends Block> T registerBlockWithoutBlockItem(String name, T block) {
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, name), block);
		return block;
	}

	private static SoundEvent registerSoundEvent(String name) {
		Identifier id = new Identifier(MoreWeaponry.MOD_ID, name);
		return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
	}


	
	// Group
	public static final ItemGroup MORE_WEAPONRY = FabricItemGroupBuilder.create(
					new Identifier(MOD_ID, "more_weaponry"))
			.icon(() -> new ItemStack(MoreWeaponryItems.HEATED_CIRTICT_BATTLEAXE)).build();


	@Override
	public void onInitialize() {

		// Entities
		IRON_BOLT = registerEntity("iron_bolt",FabricEntityTypeBuilder .<IronBoltEntity>create
						(SpawnGroup.MISC, IronBoltEntity::new)
				.dimensions(EntityDimensions.changing(0.5f, 0.5f)).trackRangeBlocks(4).trackedUpdateRate(20).build());


		// Blocks
		MOON_STONE_DUST_BLOCK = registerBlock("moon_stone_dust_block",
				new Block(FabricBlockSettings.copy(Blocks.SNOW_BLOCK)));
		KURO_WHEAT_BLOCK = registerBlock("kuro_wheat_block",
				new PillarBlock(FabricBlockSettings.copy(Blocks.HAY_BLOCK)));
		BLACKSTONE_METAL_BLOCK = registerBlock("blackstone_metal_block",
				new Block(FabricBlockSettings.copy(Blocks.HAY_BLOCK)));
		GLIMMERING_AMETHYST_BLOCK = registerBlock("glimmering_amethyst_block",
				new Block(FabricBlockSettings.copy(Blocks.AMETHYST_BLOCK)));
		LIMESTONE = registerBlock("limestone",
				new Block(FabricBlockSettings.copy(Blocks.STONE)));
		COBBLED_LIMESTONE = registerBlock("cobbled_limestone",
				new Block(FabricBlockSettings.copy(Blocks.COBBLESTONE)));
		FRODON_LOG = registerBlock("frodon_log",
				new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
		FRODON_WOOD = registerBlock("frodon_wood",
				new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
		FRODON_PLANKS = registerBlock("frodon_planks",
				new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
		STRIPPED_FRODON_LOG = registerBlock("stripped_frodon_log",
				new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
		STRIPPED_FRODON_WOOD = registerBlock("stripped_frodon_wood",
				new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));
		FRODON_LEAVES = registerBlock("frodon_leaves",
				new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));
		FRODON_SAPLING = registerBlock("frodon_sapling",
				new FrodonSaplingBlock(new FrodonSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));
		NIGHT_CURON = registerBlock("night_curon",
				new FlowerBlock(StatusEffects.WITHER, 100, FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque().noCollision()));
		FRODON_SLAB = registerBlock("frodon_slab",
				new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)));
		FRODON_STAIRS = registerBlock("frodon_stairs",
				new StairsBlock(FRODON_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS)));
		LIMESTONE_SLAB = registerBlock("limestone_slab",
				new SlabBlock(FabricBlockSettings.copy(Blocks.STONE_SLAB)));
		LIMESTONE_STAIRS = registerBlock("limestone_stairs",
				new StairsBlock(LIMESTONE.getDefaultState(), FabricBlockSettings.copy(Blocks.STONE_STAIRS)));
		COBBLED_LIMESTONE_SLAB = registerBlock("cobbled_limestone_slab",
				new SlabBlock(FabricBlockSettings.copy(Blocks.COBBLESTONE_SLAB)));
		COBBLED_LIMESTONE_STAIRS = registerBlock("cobbled_limestone_stairs",
				new StairsBlock(COBBLED_LIMESTONE.getDefaultState(), FabricBlockSettings.copy(Blocks.COBBLESTONE_STAIRS)));
		FRODON_FENCE = registerBlock("frodon_fence",
				new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE)));
		FRODON_FENCE_GATE = registerBlock("frodon_fence_gate",
				new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE)));
		LIMESTONE_WALL = registerBlock("limestone_wall",
				new WallBlock(FabricBlockSettings.copy(Blocks.COBBLESTONE_WALL)));
		COBBLED_LIMESTONE_WALL = registerBlock("cobbled_limestone_wall",
				new WallBlock(FabricBlockSettings.copy(Blocks.COBBLESTONE_WALL)));
		FRODON_BUTTON = registerBlock("frodon_button",
				new WoodenButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON)));
		LIMESTONE_BUTTON = registerBlock("limestone_button",
				new StoneButtonBlock(FabricBlockSettings.copy(Blocks.STONE_BUTTON)));
		COBBLESTONE_BUTTON = registerBlock("cobblestone_button",
				new StoneButtonBlock(FabricBlockSettings.copy(Blocks.STONE_BUTTON)));
		COBBLED_LIMESTONE_BUTTON = registerBlock("cobbled_limestone_button",
				new StoneButtonBlock(FabricBlockSettings.copy(Blocks.STONE_BUTTON)));
		FRODON_PRESSURE_PLATE = registerBlock("frodon_pressure_plate",
				new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE)));
		LIMESTONE_PRESSURE_PLATE = registerBlock("limestone_pressure_plate",
				new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.STONE_PRESSURE_PLATE)));
		COBBLESTONE_PRESSURE_PLATE = registerBlock("cobblestone_pressure_plate",
				new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.STONE_PRESSURE_PLATE)));
		COBBLED_LIMESTONE_PRESSURE_PLATE = registerBlock("cobbled_limestone_pressure_plate",
				new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.STONE_PRESSURE_PLATE)));
		FRODON_DOOR = registerBlock("frodon_door",
				new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR)));
		FRODON_TRAPDOOR = registerBlock("frodon_trapdoor",
				new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR)));
		MARE_DIAMOND_ORE = registerBlock("mare_diamond_ore",
				new OreBlock(FabricBlockSettings.copy(Blocks.DIAMOND_ORE)));
		CIRTICT_BLOCK = registerBlock("cirtict_block",
				new Block(FabricBlockSettings.copy(Blocks.NETHERITE_BLOCK)));
		MARE_DIAMOND_BLOCK = registerBlock("mare_diamond_block",
				new Block(FabricBlockSettings.copy(Blocks.DIAMOND_BLOCK)));
		CROP_CUTTER = registerBlock("crop_cutter_block",
				new Block(FabricBlockSettings.copy(Blocks.FLETCHING_TABLE)));
		DEEPSLATE_MARE_DIAMOND_ORE = registerBlock("deepslate_mare_diamond_ore",
				new OreBlock(FabricBlockSettings.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));
		BLUESTONE = registerBlock("bluestone",
				new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
		COBBLED_BLUESTONE = registerBlock("cobbled_bluestone",
				new Block(FabricBlockSettings.copy(Blocks.COBBLED_DEEPSLATE)));
		BLUESTONE_STAIRS = registerBlock("bluestone_stairs",
				new StairsBlock(BLUESTONE.getDefaultState(), FabricBlockSettings.copy(Blocks.COBBLED_DEEPSLATE_STAIRS)));
		COBBLED_BLUESTONE_STAIRS = registerBlock("cobbled_bluestone_stairs",
				new StairsBlock(COBBLED_BLUESTONE.getDefaultState(), FabricBlockSettings.copy(Blocks.COBBLED_DEEPSLATE_STAIRS)));
		BLUESTONE_SLAB = registerBlock("bluestone_slab",
				new SlabBlock(FabricBlockSettings.copy(Blocks.STONE_SLAB)));
		COBBLED_BLUESTONE_SLAB = registerBlock("cobbled_bluestone_slab",
				new SlabBlock(FabricBlockSettings.copy(Blocks.COBBLED_DEEPSLATE_SLAB)));
		BLUESTONE_WALL = registerBlock("bluestone_wall",
				new WallBlock(FabricBlockSettings.copy(Blocks.STONE_BRICK_WALL)));
		COBBLED_BLUESTONE_WALL = registerBlock("cobbled_bluestone_wall",
				new WallBlock(FabricBlockSettings.copy(Blocks.COBBLED_DEEPSLATE_WALL)));
		CIRTICT_DEBRIS = registerBlock("cirtict_debris",
				new Block(FabricBlockSettings.copy(Blocks.ANCIENT_DEBRIS)));
		SANDSTONE_DUST_BLOCK = registerBlock("sandstone_dust_block",
				new SandstoneDustBlock((11098145), FabricBlockSettings.copy(Blocks.SAND)));
		CRACKED_DRIPSTONE = registerBlock("cracked_dripstone_block",
				new Block(FabricBlockSettings.copy(Blocks.DRIPSTONE_BLOCK)));
		INFESTED_CRACKED_DRIPSTONE = registerBlock("infested_cracked_dripstone_block",
				new WandererInfestedBlock(CRACKED_DRIPSTONE, FabricBlockSettings.copy(Blocks.DRIPSTONE_BLOCK)));
		INFESTED_DRIPSTONE = registerBlock("infested_dripstone_block",
				new WandererInfestedBlock(Blocks.DRIPSTONE_BLOCK, FabricBlockSettings.copy(Blocks.DRIPSTONE_BLOCK)));
		ESSENCE_TRANSLATOR = registerBlock("essence_translator",
				new EssenceTranslatorBlock(FabricBlockSettings.copy(Blocks.OBSIDIAN)));
		CORE_FORGE = registerBlock("core_forge",
				new CoreForgeBlock(FabricBlockSettings.copy(Blocks.CRYING_OBSIDIAN)));
		PEPLEX_NYLIUM = registerBlock("peplex_nylium",
				new EndNyliumBlock(FabricBlockSettings.copy(Blocks.END_STONE)));
		INTOXICATED_STONE = registerBlock("intoxicated_stone",
				new Block(FabricBlockSettings.copy(Blocks.STONE)));
		SICKENED_STONE_GRAVE = registerBlock("sickened_stone_grave",
				new SickenedStoneGraveBlock(FabricBlockSettings.copy(Blocks.STONE)));
		INTOXICATED_GRASS_BLOCK = registerBlock("intoxicated_grass_block",
				new IntoxicatedGrassBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK)));
		INTOXICATED_FERN = registerBlock("intoxicated_fern",
				new IntoxicatedFernBlock(FabricBlockSettings.copy(Blocks.FERN)));
		INTOXICATED_TALL_GRASS = registerBlock("intoxicated_tall_grass",
				new IntoxicatedTallPlantBlock(FabricBlockSettings.copy(Blocks.TALL_GRASS)));
		INTOXICATED_TALL_FERN = registerBlock("intoxicated_large_fern",
				new IntoxicatedTallPlantBlock(FabricBlockSettings.copy(Blocks.LARGE_FERN)));
		INTOXICATED_POPPY = registerBlock("intoxicated_poppy",
				new IntoxicatedFlowerBlock(StatusEffects.POISON, 100,
						FabricBlockSettings.copy(Blocks.POPPY).noCollision().nonOpaque()));
		INTOXICATED_DANDELION = registerBlock("intoxicated_dandelion",
				new IntoxicatedFlowerBlock(StatusEffects.ABSORPTION, 100,
						FabricBlockSettings.copy(Blocks.DANDELION).noCollision().nonOpaque()));
		PACKED_WATCHER_CLOTH_BLOCK = registerBlock("packed_watcher_cloth_block",
				new Block(FabricBlockSettings.copy(Blocks.BLACK_WOOL)));
		WANDERER_SKULL = registerBlock("wanderer_skull",
				new WandererSkullBlock(FabricBlockSettings.copy(Blocks.PLAYER_HEAD).nonOpaque()));
		WATCHER_SKULL = registerBlock("watcher_skull",
				new WatcherSkullBlock(FabricBlockSettings.copy(Blocks.PLAYER_HEAD).nonOpaque()));
		BARD_SKULL = registerBlock("bard_skull",
				new BardSkullBlock(FabricBlockSettings.copy(Blocks.PLAYER_HEAD).nonOpaque()));
		SICKENED_SKULL = registerBlock("sickened_skull",
				new SickenedSkullBlock(FabricBlockSettings.copy(Blocks.PLAYER_HEAD).nonOpaque()));
		SICKENED_HUSK_SKULL = registerBlock("sickened_husk_skull",
				new SickenedSkullBlock(FabricBlockSettings.copy(Blocks.PLAYER_HEAD).nonOpaque()));
		CRACKLER_SKULL = registerBlock("crackler_skull",
				new CracklerSkullBlock(FabricBlockSettings.copy(Blocks.PLAYER_HEAD)));
		WATCHER_SUMMONER = registerBlock("watcher_summoner",
				new Block(FabricBlockSettings.copy(Blocks.END_STONE)));
		CRACKLER_SUMMONER = registerBlock("crackler_summoner",
				new Block(FabricBlockSettings.copy(Blocks.COARSE_DIRT)));
		WANDERER_SUMMONER = registerBlock("wanderer_summoner",
				new Block(FabricBlockSettings.copy(Blocks.DRIPSTONE_BLOCK)));
		BARD_SUMMONER = registerBlock("bard_summoner",
				new Block(FabricBlockSettings.copy(Blocks.ANDESITE)));
		SICKENED_SUMMONER = registerBlock("sickened_summoner",
				new Block(FabricBlockSettings.copy(Blocks.STONE)));
		SICKENED_HUSK_SUMMONER = registerBlock("sickend_summoner",
				new Block(FabricBlockSettings.copy(Blocks.SAND)));
		CIRTICT_FORGE = registerBlock("cirtict_forge",
				new CirtictForgeBlock(FabricBlockSettings.copy(Blocks.CARTOGRAPHY_TABLE)));
		WATCHER_CELESTIAL_BLOCK = registerBlock("watcher_celestial_block",
				new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS)));
		CRYSTALINE_WATCHER_CORE = registerBlock("crystaline_watcher_core",
				new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS)));
		CRACKLER_CELESTIAL_BLOCK = registerBlock("crackler_celestial_block",
				new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS)));
		CRYSTALINE_CRACKLER_CORE = registerBlock("crystaline_crackler_core",
				new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS)));
		BARD_CELESTIAL_BLOCK = registerBlock("bard_celestial_block",
				new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS)));
		CRYSTALINE_BARD_CORE = registerBlock("crystaline_bard_core",
				new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS)));
		SICKENED_CELESTIAL_BLOCK = registerBlock("sickened_celestial_block",
				new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS)));
		CRYSTALINE_SICKENED_CORE = registerBlock("crystaline_sickened_core",
				new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS)));
		WANDERER_CELESTIAL_BLOCK = registerBlock("wanderer_celestial_block",
				new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS)));
		CRYSTALINE_WANDERER_CORE = registerBlock("crystaline_wanderer_core",
				new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS)));
		LIMESTONE_TILES = registerBlock("limestone_tiles",
				new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE_TILES)));
		BLUESTONE_TILES = registerBlock("bluestone_tiles",
				new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE_TILES)));
		EMPTY_BOOKSHELF = registerBlock("empty_bookshelf",
				new Block(FabricBlockSettings.copy(Blocks.BOOKSHELF)));
		CORRUPTED_END_STONE_BRICKS = registerBlock("corrupted_end_stone_bricks",
				new Block(FabricBlockSettings.copy(Blocks.END_STONE_BRICKS)));
		CORRUPTED_END_STONE = registerBlock("corrupted_end_stone",
				new Block(FabricBlockSettings.copy(Blocks.END_STONE)));
		KURO_PLANT = registerBlockWithoutBlockItem("kuro_plant",
				new KuroPlantBlock(FabricBlockSettings.copy(Blocks.WHEAT)));
		POTTED_NIGHT_CURON = registerBlockWithoutBlockItem("potted_night_curon",
				new FlowerPotBlock(NIGHT_CURON, FabricBlockSettings.copy(Blocks.POTTED_DANDELION)));
		FRODON_WALL_SIGN = registerBlockWithoutBlockItem("frodon_wall_sign",
				new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), MoreWeaponrySignTypes.FRODON));
		FRODON_SIGN_BLOCK = registerBlockWithoutBlockItem("frodon_sign",
				new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), MoreWeaponrySignTypes.FRODON));
		INTOXICATED_GRASS = registerBlock("intoxicated_grass",
				new IntoxicatedFernBlock(FabricBlockSettings.copy(Blocks.GRASS)));
		
		// Items
		BLASTED_AMETHYST = registerItem("blasted_amethyst",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		GLIMMERING_AMETHYST = registerItem("glimmering_amethyst",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		MOON_STONE_DUST = registerItem("moon_stone_dust",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		REFINED_MOON_STONE = registerItem("refined_moon_stone",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		HANDLE = registerItem("handle",
				new HandleItem(new FabricItemSettings().group(MORE_WEAPONRY)));
		KURO_SEEDS = registerItem("kuro_seeds",
				new BlockItem(KURO_PLANT, new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		KURO = registerItem("kuro",
				new Item(new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		KURO_BREAD = registerItem("kuro_bread",
				new Item(new FabricItemSettings().fireproof().food
						(new FoodComponent.Builder().alwaysEdible().hunger(8).statusEffect
								(new StatusEffectInstance(StatusEffects.ABSORPTION, 20*10), 1f)
								.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20*5), 0.5f)
								.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*25), 1f)
								.saturationModifier(0.7f).build()).group(MORE_WEAPONRY)));
		CURON_BREW = registerItem("curon_brew",
				new NightCuronBrewItem(new FabricItemSettings().maxCount(1).food
						(new FoodComponent.Builder().alwaysEdible().hunger(7).statusEffect
										(new StatusEffectInstance(StatusEffects.BLINDNESS, 20*10), 1f)
								.statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20*5), 1f)
								.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20*5), 1f)
								.statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 20*3), 1f)
								.statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 20*10), 1f)
								.statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*5), 1f)
								.statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20*10), 1f)
								.statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20*10), 1f)
								.statusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 20*5), 1f)
								.saturationModifier(0.6f).build()).group(MORE_WEAPONRY)));
		FRODON_BOWL = registerItem("frodon_bowl",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		CURON_FLOWER_PETALS = registerItem("curon_flower_petals",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		CRUSHED_KURO = registerItem("crushed_kuro",
				new Item(new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		BLACKSTONE_INGOT = registerItem("blackstone_ingot",
				new Item(new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		NETHERITE_HANDLE = registerItem("netherite_handle",
				new HandleItem(new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		MARE_DIAMOND = registerItem("mare_diamond",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		NETHERITE_NUGGET = registerItem("netherite_nugget",
				new Item(new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		AMETHYST_HANDLE = registerItem("amethyst_handle",
				new HandleItem(new FabricItemSettings().group(MORE_WEAPONRY)));
		GUARDIAN_SCALE = registerItem("guardian_scale",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		ELDER_GUARDIAN_SCALE = registerItem("elder_guardian_scale",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		ELDER_GUARDIANS_EYE = registerItem("elder_guardians_eye",
				new Item(new FabricItemSettings().food
						(new FoodComponent.Builder().hunger(8).statusEffect
								(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 20*5), 1f)
								.saturationModifier(1.0f).build()).group(MORE_WEAPONRY)));
		PRISMARINE_HANDLE = registerItem("prismarine_handle",
				new HandleItem(new FabricItemSettings().group(MORE_WEAPONRY)));
		WITHER_ESSENCE = registerItem("wither_essence",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		WITHER_BONE = registerItem("wither_bone",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		PHANTOM_ESSENCE = registerItem("phantom_essence",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		PHANTOM_SCALE = registerItem("phantom_scale",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		PHANTOM_HELMET = registerItem("phantom_helmet",
				new PhantomScaleHelm(PHANTOM_SCALE_ARMOR, EquipmentSlot.HEAD,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		CIRTICT_INGOT = registerItem("cirtict_ingot",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		GLIMMERING_SWORD = registerItem("glimmering_sword",
				new SwordItem((ToolMaterial) GLIMMERING_AMETHYST_TOOLS, 3, -2.4f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GLIMMERING_SHOVEL = registerItem("glimmering_shovel",
				new ShovelItem((ToolMaterial) GLIMMERING_AMETHYST_TOOLS, 1, -3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GLIMMERING_PICKAXE = registerItem("glimmering_pickaxe",
				new BetterPickaxeItem((ToolMaterial) GLIMMERING_AMETHYST_TOOLS, 1, -2.8f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GLIMMERING_AXE = registerItem("glimmering_axe",
				new BetterAxeItem((ToolMaterial) GLIMMERING_AMETHYST_TOOLS, 5, -3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GLIMMERING_HOE = registerItem("glimmering_hoe",
				new BetterHoeItem((ToolMaterial) GLIMMERING_AMETHYST_TOOLS, -1, 0f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GLIMMERING_BATTLEAXE = registerItem("glimmering_battleaxe",
				new BattleaxeItem((ToolMaterial) GLIMMERING_AMETHYST_TOOLS, 6, -3.3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		MOON_STONE_SWORD = registerItem("moon_stone_sword",
				new SwordItem((ToolMaterial) REFINED_MOON_STONE_TOOLS, 3, -2.4f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		MOON_STONE_SHOVEL = registerItem("moon_stone_shovel",
				new ShovelItem((ToolMaterial) REFINED_MOON_STONE_TOOLS, 1, -3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		MOON_STONE_PICKAXE = registerItem("moon_stone_pickaxe",
				new BetterPickaxeItem((ToolMaterial) REFINED_MOON_STONE_TOOLS, 1, -2.8f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		MOON_STONE_AXE = registerItem("moon_stone_axe",
				new BetterAxeItem((ToolMaterial) REFINED_MOON_STONE_TOOLS, 6, -3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		MOON_STONE_HOE = registerItem("moon_stone_hoe",
				new BetterHoeItem((ToolMaterial) REFINED_MOON_STONE_TOOLS, 0, 0f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		MOON_STONE_BATTLEAXE = registerItem("moon_stone_battleaxe",
				new BattleaxeItem((ToolMaterial) REFINED_MOON_STONE_TOOLS, 8, -3.3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		BLACKSTONE_METAL_SWORD = registerItem("blackstone_metal_sword",
				new SwordItem((ToolMaterial) BLACKSTONE_METAL_TOOLS, 4, -2.4f,
						new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		BLACKSTONE_METAL_SHOVEL = registerItem("blackstone_metal_shovel",
				new ShovelItem((ToolMaterial) BLACKSTONE_METAL_TOOLS, 2, -3f,
						new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		BLACKSTONE_METAL_PICKAXE = registerItem("blackstone_metal_pickaxe",
				new BetterPickaxeItem((ToolMaterial) BLACKSTONE_METAL_TOOLS, 1, -2.8f,
						new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		BLACKSTONE_METAL_AXE = registerItem("blackstone_metal_axe",
				new BetterAxeItem((ToolMaterial) BLACKSTONE_METAL_TOOLS, 6, -3f,
						new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		BLACKSTONE_METAL_HOE = registerItem("blackstone_metal_hoe",
				new BetterHoeItem((ToolMaterial) BLACKSTONE_METAL_TOOLS, 8, -3.3f,
						new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		BLACKSTONE_METAL_BATTLEAXE = registerItem("blackstone_metal_battleaxe",
				new BattleaxeItem((ToolMaterial) BLACKSTONE_METAL_TOOLS, 9, -3.3f,
						new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		NETHERITE_BATTLEAXE = registerItem("netherite_battleaxe",
				new BattleaxeItem((ToolMaterial) ToolMaterials.NETHERITE, 8, -3.3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		DIAMOND_BATTLEAXE = registerItem("diamond_battleaxe",
				new BattleaxeItem((ToolMaterial) ToolMaterials.DIAMOND, 7, -3.3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GLIMMERING_HELMET = registerItem("glimmering_helmet",
				new ArmorItem(GLIMMERING_AMETHYST_ARMOR, EquipmentSlot.HEAD,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GLIMMERING_BREASTPLATE = registerItem("glimmering_chestplate",
				new ArmorItem(GLIMMERING_AMETHYST_ARMOR, EquipmentSlot.CHEST,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GLIMMERING_LEGGINGS = registerItem("glimmering_leggings",
				new ArmorItem(GLIMMERING_AMETHYST_ARMOR, EquipmentSlot.LEGS,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GLIMMERING_BOOTS = registerItem("glimmering_boots",
				new ArmorItem(GLIMMERING_AMETHYST_ARMOR, EquipmentSlot.FEET,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		MOON_STONE_HELMET = registerItem("moon_stone_helmet",
				new ArmorItem(REFINED_MOON_STONE_ARMOR, EquipmentSlot.HEAD,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		MOON_STONE_BREASTPLATE = registerItem("moon_stone_chestplate",
				new ArmorItem(REFINED_MOON_STONE_ARMOR, EquipmentSlot.CHEST,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		MOON_STONE_LEGGINGS = registerItem("moon_stone_leggings",
				new ArmorItem(REFINED_MOON_STONE_ARMOR, EquipmentSlot.LEGS,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		MOON_STONE_BOOTS = registerItem("moon_stone_boots",
				new ArmorItem(REFINED_MOON_STONE_ARMOR, EquipmentSlot.FEET,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		BLACKSTONE_METAL_HELMET = registerItem("blackstone_metal_helmet",
				new ArmorItem(BLACKSTONE_METAL_ARMOR, EquipmentSlot.HEAD,
						new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		BLACKSTONE_METAL_BREASTPLATE = registerItem("blackstone_metal_chestplate",
				new ArmorItem(BLACKSTONE_METAL_ARMOR, EquipmentSlot.CHEST,
						new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		BLACKSTONE_METAL_LEGGINGS = registerItem("blackstone_metal_leggings",
				new ArmorItem(BLACKSTONE_METAL_ARMOR, EquipmentSlot.LEGS,
						new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		BLACKSTONE_METAL_BOOTS = registerItem("blackstone_metal_boots",
				new ArmorItem(BLACKSTONE_METAL_ARMOR, EquipmentSlot.FEET,
						new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		ELDER_GUARDIAN_SCALE_HELMET = registerItem("elder_guardian_scale_helmet",
				new ElderScaleArmorItem(ELDER_GUARDIAN_SCALE_ARMOR, EquipmentSlot.HEAD,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		ELDER_GUARDIAN_SCALE_BREASTPLATE = registerItem("elder_guardian_scale_chestplate",
				new ElderScaleArmorItem(ELDER_GUARDIAN_SCALE_ARMOR, EquipmentSlot.CHEST,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		ELDER_GUARDIAN_SCALE_LEGGINGS = registerItem("elder_guardian_scale_leggings",
				new ElderScaleArmorItem(ELDER_GUARDIAN_SCALE_ARMOR, EquipmentSlot.LEGS,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		ELDER_GUARDIAN_SCALE_BOOTS = registerItem("elder_guardian_scale_boots",
				new ElderScaleArmorItem(ELDER_GUARDIAN_SCALE_ARMOR, EquipmentSlot.FEET,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GUARDIAN_SCALE_HELMET = registerItem("guardian_scale_helmet",
				new ArmorItem(GUARDIAN_SCALE_ARMOR, EquipmentSlot.HEAD,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GUARDIAN_SCALE_BREASTPLATE = registerItem("guardian_scale_chestplate",
				new ArmorItem(GUARDIAN_SCALE_ARMOR, EquipmentSlot.CHEST,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GUARDIAN_SCALE_LEGGINGS = registerItem("guardian_scale_leggings",
				new ArmorItem(GUARDIAN_SCALE_ARMOR, EquipmentSlot.LEGS,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GUARDIAN_SCALE_BOOTS = registerItem("guardian_scale_boots",
				new ArmorItem(GUARDIAN_SCALE_ARMOR, EquipmentSlot.FEET,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		ELDER_GUARDIAN_SCALE_SWORD = registerItem("elder_guardian_scale_sword",
				new SwordItem((ToolMaterial) ELDER_GUARDIAN_SCALE_TOOLS, 5, -2.4f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		ELDER_GUARDIAN_SCALE_SHOVEL = registerItem("elder_guardian_scale_shovel",
				new ShovelItem((ToolMaterial) ELDER_GUARDIAN_SCALE_TOOLS, 2, -3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		ELDER_GUARDIAN_SCALE_PICKAXE = registerItem("elder_guardian_scale_pickaxe",
				new BetterPickaxeItem((ToolMaterial) ELDER_GUARDIAN_SCALE_TOOLS, 2, -2.8f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		ELDER_GUARDIAN_SCALE_AXE = registerItem("elder_guardian_scale_axe",
				new BetterAxeItem((ToolMaterial) ELDER_GUARDIAN_SCALE_TOOLS, 7, -3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		ELDER_GUARDIAN_SCALE_HOE = registerItem("elder_guardian_scale_hoe",
				new BetterHoeItem((ToolMaterial) ELDER_GUARDIAN_SCALE_TOOLS, -5, -0f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		ELDER_GUARDIAN_SCALE_BATTLEAXE = registerItem("elder_guardian_scale_battleaxe",
				new BattleaxeItem((ToolMaterial) ELDER_GUARDIAN_SCALE_TOOLS, 11, -3.3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GUARDIAN_SCALE_SWORD = registerItem("guardian_scale_sword",
				new SwordItem((ToolMaterial) GUARDIAN_SCALE_TOOLS, 4, -2.4f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GUARDIAN_SCALE_SHOVEL = registerItem("guardian_scale_shovel",
				new ShovelItem((ToolMaterial) GUARDIAN_SCALE_TOOLS, 1, -3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GUARDIAN_SCALE_PICKAXE = registerItem("guardian_scale_pickaxe",
				new BetterPickaxeItem((ToolMaterial) GUARDIAN_SCALE_TOOLS, 2, -2.8f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GUARDIAN_SCALE_AXE = registerItem("guardian_scale_axe",
				new BetterAxeItem((ToolMaterial) GUARDIAN_SCALE_TOOLS, 7, -3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GUARDIAN_SCALE_HOE = registerItem("guardian_scale_hoe",
				new BetterHoeItem((ToolMaterial) GUARDIAN_SCALE_TOOLS, -4, -0f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GUARDIAN_SCALE_BATTLEAXE = registerItem("guardian_scale_battleaxe",
				new BattleaxeItem((ToolMaterial) GUARDIAN_SCALE_TOOLS, 10, -3.3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GLIMMERING_SHIELD = registerItem("glimmering_shield",
				new FabricShieldItem(new FabricItemSettings().maxDamage(1782).group(MORE_WEAPONRY),
						20, 23, GLIMMERING_AMETHYST));
		BLACKSTONE_METAL_SHIELD = registerItem("blackstone_metal_shield",
				new FabricShieldItem(new FabricItemSettings().maxDamage(2476).group(MORE_WEAPONRY),
						10, 17, BLACKSTONE_INGOT));
		MOON_STONE_SHIELD = registerItem("moon_stone_shield",
				new FabricShieldItem(new FabricItemSettings().maxDamage(2006).group(MORE_WEAPONRY),
						15, 19, REFINED_MOON_STONE));
		GUARDIAN_SCALE_SHIELD = registerItem("guardian_scale_shield",
				new FabricShieldItem(new FabricItemSettings().maxDamage(2938).group(MORE_WEAPONRY),
						8, 17, GUARDIAN_SCALE));
		ELDER_SCALE_SHIELD = registerItem("elder_scale_shield",
				new FabricShieldItem(new FabricItemSettings().maxDamage(3276).group(MORE_WEAPONRY),
						7, 18, ELDER_GUARDIAN_SCALE));
		ELDER_SCALE_ARTIFACT = registerItem("elder_scale_artifact",
				new ElderScaleArtifactItem((ToolMaterial) ELDER_GUARDIAN_SCALE_TOOLS, 9, -2.9f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GOLDEN_KNIFE = registerItem("golden_knife",
				new KnifeItem((ToolMaterial) ToolMaterials.GOLD, 2, -1f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		STONE_KNIFE = registerItem("stone_knife",
				new KnifeItem((ToolMaterial) ToolMaterials.STONE, 3, -1f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		IRON_KNIFE = registerItem("iron_knife",
				new KnifeItem((ToolMaterial) ToolMaterials.IRON, 4, -1f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		DIAMOND_KNIFE = registerItem("diamond_knife",
				new KnifeItem((ToolMaterial) ToolMaterials.DIAMOND, 5, -1f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		NETHERITE_KNIFE = registerItem("netherite_knife",
				new KnifeItem((ToolMaterial) ToolMaterials.NETHERITE, 6, -1f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		WOODEN_KNIFE = registerItem("wooden_knife",
				new KnifeItem((ToolMaterial) ToolMaterials.WOOD, 1, -1f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		REFINED_MOON_KNIFE = registerItem("refined_moon_knife",
				new KnifeItem((ToolMaterial) REFINED_MOON_STONE_TOOLS, 3, -1f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GLIMMERED_AMETHYST_KNIFE = registerItem("glimmered_amethyst_knife",
				new KnifeItem((ToolMaterial) GLIMMERING_AMETHYST_TOOLS, 2, -1f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		BLACKSTONE_METAL_KNIFE = registerItem("blackstone_metal_knife",
				new KnifeItem((ToolMaterial) BLACKSTONE_METAL_TOOLS, (int) 2.5, -1f,
						new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		GUARDIAN_SCALE_KNIFE = registerItem("guardian_scale_knife",
				new KnifeItem((ToolMaterial) GUARDIAN_SCALE_TOOLS, 3, -1f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		ELDER_GUARDIAN_SCALE_KNIFE = registerItem("elder_guardian_scale_knife",
				new KnifeItem((ToolMaterial) ELDER_GUARDIAN_SCALE_TOOLS, 3, -1f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		GOLDEN_BATTLEAXE = registerItem("golden_battleaxe",
				new BattleaxeItem((ToolMaterial) ToolMaterials.GOLD, 2, -3.3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		WOODEN_BATTLEAXE = registerItem("wooden_battleaxe",
				new BattleaxeItem((ToolMaterial) ToolMaterials.WOOD, 1, -3.3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		STONE_BATTLEAXE = registerItem("stone_battleaxe",
				new BattleaxeItem((ToolMaterial) ToolMaterials.STONE, 2, -3.3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		IRON_BATTLEAXE = registerItem("iron_battleaxe",
				new BattleaxeItem((ToolMaterial) ToolMaterials.IRON, 3, -3.3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		CIRTICT_BATTLEAXE = registerItem("cirtict_battleaxe",
				new BattleaxeItem((ToolMaterial) CIRTICT_TOOLS, 4, -3.3f,
						new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		HEATED_CIRTICT_BATTLEAXE = registerItem("heated_cirtict_battleaxe",
				new BattleaxeItem((ToolMaterial) HEATED_CIRTICT_TOOLS, 5, -3.3f,
						new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		COOLED_CIRTICT_BATTLEAXE = registerItem("cooled_cirtict_battleaxe",
				new BattleaxeItem((ToolMaterial) COOLED_CIRTICT_TOOLS, 5, -3.3f,
						new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		BLUESTONE_IGNITOR = registerItem("bluestone_ignitor",
				new BluestoneIgnitor(new FabricItemSettings().group(MORE_WEAPONRY)));
		BLUESTONE_ROCK = registerItem("bluestone_rock",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		CIRTICT_SCRAP = registerItem("cirtict_scrap",
				new Item(new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		COOLED_CIRTICT_INGOT = registerItem("cooled_cirtict_ingot",
				new CooledCirtictIngot(new FabricItemSettings().fireproof().group(MORE_WEAPONRY)));
		WARDENS_STEP_MUSIC_DISC = registerItem("wardens_step_music_disc",
				new MoreWeaponryMusicDiscItem(9, WARDENS_STEP,
						new FabricItemSettings().maxCount(1).group(MORE_WEAPONRY)));
		FRODON_SIGN = registerItem("frodon_sign",
				new SignItem(new FabricItemSettings().group(MORE_WEAPONRY).maxCount(16),
						FRODON_SIGN_BLOCK, FRODON_WALL_SIGN));
		DRAGON_SCALE = registerItem("dragon_scale",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		SHULKER_SHELL_BOOTS = registerItem("shulker_shell_boots",
				new ShulkerShellBoots(SHULKER_SHELL_ARMOR, EquipmentSlot.FEET,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		WITHER_BROAD_HAMMER = registerItem("wither_broad_hammer",
				new WitherBroadHammerItem((ToolMaterial) WITHERED_TOOLS, 11, -3.0f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		WITHERING_HANDLE = registerItem("withering_handle",
				new HandleItem(new FabricItemSettings().group(MORE_WEAPONRY)));
		WITHER_BROAD_HAMMER_HEAD = registerItem("wither_broad_hammer_head",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		HEATED_CIRTICT_INGOT = registerItem("heated_cirtict_ingot",
				new HeatedCirtictIngot(new FabricItemSettings().group(MORE_WEAPONRY)));
		COOLED_CIRTICT_SWORD = registerItem("cooled_cirtict_sword",
				new CooledCirtictSword((ToolMaterial) COOLED_CIRTICT_TOOLS, -1, -2.4f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		COOLED_CIRTICT_AXE = registerItem("cooled_cirtict_axe",
				new CooledCirtictAxe((ToolMaterial) COOLED_CIRTICT_TOOLS, 2, -3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		COOLED_CIRTICT_HOE = registerItem("cooled_cirtict_hoe",
				new CooledCirtictHoe((ToolMaterial) COOLED_CIRTICT_TOOLS, -13, 0f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		COOLED_CIRTICT_PICKAXE = registerItem("cooled_cirtict_pickaxe",
				new CooledCirtictPickaxe((ToolMaterial) COOLED_CIRTICT_TOOLS, -4, -2.8f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		COOLED_CIRTICT_SHOVEL = registerItem("cooled_cirtict_shovel",
				new CooledCirtictShovel((ToolMaterial) COOLED_CIRTICT_TOOLS, -5, -3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		COOLED_CIRTICT_KNIFE = registerItem("cooled_cirtict_knife",
				new CooledCirtictKnife((ToolMaterial) COOLED_CIRTICT_TOOLS, -2, -1f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		HEATED_CIRTICT_SWORD = registerItem("heated_cirtict_sword",
				new HeatedCirtictSword((ToolMaterial) HEATED_CIRTICT_TOOLS, -1, -2.4f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		HEATED_CIRTICT_AXE = registerItem("heated_cirtict_axe",
				new HeatedCirtictAxe((ToolMaterial) HEATED_CIRTICT_TOOLS, 2, -3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		HEATED_CIRTICT_HOE = registerItem("heated_cirtict_hoe",
				new HeatedCirtictHoe((ToolMaterial) HEATED_CIRTICT_TOOLS, -13, 0f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		HEATED_CIRTICT_PICKAXE = registerItem("heated_cirtict_pickaxe",
				new HeatedCirtictPickaxe((ToolMaterial) HEATED_CIRTICT_TOOLS, -4, -2.8f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		HEATED_CIRTICT_SHOVEL = registerItem("heated_cirtict_shovel",
				new HeatedCirtictShovel((ToolMaterial) HEATED_CIRTICT_TOOLS, -5, -3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		HEATED_CIRTICT_KNIFE = registerItem("heated_cirtict_knife",
				new HeatedCirtictKnife((ToolMaterial) HEATED_CIRTICT_TOOLS, -2, -1f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		CIRTICT_SWORD = registerItem("cirtict_sword",
				new SwordItem((ToolMaterial) CIRTICT_TOOLS, -2, -2.4f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		CIRTICT_AXE = registerItem("cirtict_axe",
				new BetterAxeItem((ToolMaterial) CIRTICT_TOOLS, 1, -3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		CIRTICT_HOE = registerItem("cirtict_hoe",
				new BetterHoeItem((ToolMaterial) CIRTICT_TOOLS, -13, 0f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		CIRTICT_PICKAXE = registerItem("cirtict_pickaxe",
				new BetterPickaxeItem((ToolMaterial) CIRTICT_TOOLS, -5, -2.8f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		CIRTICT_SHOVEL = registerItem("cirtict_shovel",
				new ShovelItem((ToolMaterial) CIRTICT_TOOLS, -4, -3f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		CIRTICT_KNIFE = registerItem("cirtict_knife",
				new KnifeItem((ToolMaterial) CIRTICT_TOOLS, -4, -1f,
						new FabricItemSettings().group(MORE_WEAPONRY)));
		COOLED_CIRTICT_SHIELD = registerItem("cooled_cirtict_shield",
				new CooledCirtictShield(new FabricItemSettings().maxDamage(3583).group(MORE_WEAPONRY),
						5, 16, COOLED_CIRTICT_INGOT));
		HEATED_CIRTICT_SHIELD = registerItem("heated_cirtict_shield",
				new HeatedCirtictShield(new FabricItemSettings().maxDamage(3583).group(MORE_WEAPONRY),
						5, 16, HEATED_CIRTICT_INGOT));
		CIRTICT_SHIELD = registerItem("cirtict_shield",
				new FabricShieldItem(new FabricItemSettings().maxDamage(3456).group(MORE_WEAPONRY),
						6, 17, CIRTICT_INGOT));
		CIRTICT_NUGGET = registerItem("cirtict_nugget",
				new Item(new FabricItemSettings().group(MORE_WEAPONRY)));
		HEATED_CIRTICT_NUGGET = registerItem("heated_cirtict_nugget",
				new HeatedCirtictNugget(new FabricItemSettings().group(MORE_WEAPONRY)));
		COOLED_CIRTICT_NUGGET = registerItem("cooled_cirtict_nugget",
				new CooledCirtictNugget(new FabricItemSettings().group(MORE_WEAPONRY)));






		// Sound Events
		WARDENS_STEP = registerSoundEvent("wardens_step");
		ENTITY_BURIED_KNIGHT_AMBIENT = registerSoundEvent("entity_buried_knight_ambient");
		ENTITY_BURIED_KNIGHT_DEATH = registerSoundEvent("entity_buried_knight_death");
		ENTITY_BURIED_KNIGHT_HURT = registerSoundEvent("entity_buried_knight_hurt");
		ENTITY_CRAWLER_AMBIENT = registerSoundEvent("entity_crawler_ambient");


		// Block Items
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "moon_stone_dust_block"), new BlockItem(MOON_STONE_DUST_BLOCK,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "kuro_wheat_block"), new BlockItem(KURO_WHEAT_BLOCK,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blackstone_metal_block"), new BlockItem(BLACKSTONE_METAL_BLOCK,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "glimmering_amethyst_block"), new BlockItem(GLIMMERING_AMETHYST_BLOCK,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "limestone"), new BlockItem(LIMESTONE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cobbled_limestone"), new BlockItem(COBBLED_LIMESTONE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "frodon_log"), new BlockItem(FRODON_LOG,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "frodon_wood"), new BlockItem(FRODON_WOOD,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "frodon_planks"), new BlockItem(FRODON_PLANKS,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_frodon_log"), new BlockItem(STRIPPED_FRODON_LOG,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stripped_frodon_wood"), new BlockItem(STRIPPED_FRODON_WOOD,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "frodon_leaves"), new BlockItem(FRODON_LEAVES,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "frodon_sapling"), new BlockItem(FRODON_SAPLING,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "night_curon"), new BlockItem(NIGHT_CURON,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "frodon_slab"), new BlockItem(FRODON_SLAB,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "frodon_stairs"), new BlockItem(FRODON_STAIRS,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "limestone_slab"), new BlockItem(LIMESTONE_SLAB,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "limestone_stairs"), new BlockItem(LIMESTONE_STAIRS,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cobbled_limestone_slab"), new BlockItem(COBBLED_LIMESTONE_SLAB,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cobbled_limestone_stairs"), new BlockItem(COBBLED_LIMESTONE_STAIRS,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "frodon_fence"), new BlockItem(FRODON_FENCE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "frodon_fence_gate"), new BlockItem(FRODON_FENCE_GATE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "limestone_wall"), new BlockItem(LIMESTONE_WALL,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cobbled_limestone_wall"), new BlockItem(COBBLED_LIMESTONE_WALL,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "frodon_button"), new BlockItem(FRODON_BUTTON,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "limestone_button"), new BlockItem(LIMESTONE_BUTTON,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cobbled_limestone_button"), new BlockItem(COBBLED_LIMESTONE_BUTTON,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cobblestone_button"), new BlockItem(COBBLESTONE_BUTTON,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "frodon_pressure_plate"), new BlockItem(FRODON_PRESSURE_PLATE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "limestone_pressure_plate"), new BlockItem(LIMESTONE_PRESSURE_PLATE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cobbled_limestone_pressure_plate"), new BlockItem(COBBLED_LIMESTONE_PRESSURE_PLATE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cobblestone_pressure_plate"), new BlockItem(COBBLESTONE_PRESSURE_PLATE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "frodon_door"), new BlockItem(FRODON_DOOR,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "frodon_trapdoor"), new BlockItem(FRODON_TRAPDOOR,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "mare_diamond_ore"), new BlockItem(MARE_DIAMOND_ORE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cirtict_block"), new BlockItem(CIRTICT_BLOCK,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "mare_diamond_block"), new BlockItem(MARE_DIAMOND_BLOCK,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crop_cutter_block"), new BlockItem(CROP_CUTTER,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "deepslate_mare_diamond_ore"), new BlockItem(DEEPSLATE_MARE_DIAMOND_ORE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bluestone"), new BlockItem(BLUESTONE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cobbled_bluestone"), new BlockItem(COBBLED_BLUESTONE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bluestone_stairs"), new BlockItem(BLUESTONE_STAIRS,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cobbled_bluestone_stairs"), new BlockItem(COBBLED_BLUESTONE_STAIRS,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bluestone_slab"), new BlockItem(BLUESTONE_SLAB,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cobbled_bluestone_slab"), new BlockItem(COBBLED_BLUESTONE_SLAB,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bluestone_wall"), new BlockItem(BLUESTONE_WALL,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cobbled_bluestone_wall"), new BlockItem(COBBLED_BLUESTONE_WALL,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cirtict_debris"), new BlockItem(CIRTICT_DEBRIS,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "sandstone_dust_block"), new BlockItem(SANDSTONE_DUST_BLOCK,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cracked_dripstone_block"), new BlockItem(CRACKED_DRIPSTONE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "infested_dripstone_block"), new BlockItem(INFESTED_DRIPSTONE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "infested_cracked_dripstone_block"), new BlockItem(INFESTED_CRACKED_DRIPSTONE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "essence_translator"), new BlockItem(ESSENCE_TRANSLATOR,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "core_forge"), new BlockItem(CORE_FORGE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "peplex_nylium"), new BlockItem(PEPLEX_NYLIUM,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "intoxicated_stone"), new BlockItem(INTOXICATED_STONE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "sickened_stone_grave"), new BlockItem(SICKENED_STONE_GRAVE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "intoxicated_grass_block"), new BlockItem(INTOXICATED_GRASS_BLOCK,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "intoxicated_fern"), new BlockItem(INTOXICATED_FERN,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "intoxicated_tall_grass"), new BlockItem(INTOXICATED_TALL_GRASS,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "intoxicated_large_fern"), new BlockItem(INTOXICATED_TALL_FERN,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "intoxicated_poppy"), new BlockItem(INTOXICATED_POPPY,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "intoxicated_dandelion"), new BlockItem(INTOXICATED_DANDELION,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "packed_watcher_cloth_block"), new BlockItem(PACKED_WATCHER_CLOTH_BLOCK,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "wanderer_skull"), new BlockItem(WANDERER_SKULL,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "watcher_skull"), new BlockItem(WATCHER_SKULL,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bard_skull"), new BlockItem(BARD_SKULL,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "sickened_skull"), new BlockItem(SICKENED_SKULL,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "sickened_husk_skull"), new BlockItem(SICKENED_HUSK_SKULL,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crackler_skull"), new BlockItem(CRACKLER_SKULL,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "watcher_summoner"), new BlockItem(WATCHER_SUMMONER,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crackler_summoner"), new BlockItem(CRACKLER_SUMMONER,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "wanderer_summoner"), new BlockItem(WANDERER_SUMMONER,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bard_summoner"), new BlockItem(BARD_SUMMONER,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "sickened_summoner"), new BlockItem(SICKENED_SUMMONER,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "sickened_husk_summoner"), new BlockItem(SICKENED_HUSK_SUMMONER,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cirtict_forge"), new BlockItem(CIRTICT_FORGE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "watcher_celestial_block"), new BlockItem(WATCHER_CELESTIAL_BLOCK,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crystaline_watcher_core"), new BlockItem(CRYSTALINE_WATCHER_CORE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crackler_celestial_block"), new BlockItem(CRACKLER_CELESTIAL_BLOCK,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crystaline_crackler_core"), new BlockItem(CRYSTALINE_CRACKLER_CORE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bard_celestial_block"), new BlockItem(BARD_CELESTIAL_BLOCK,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crystaline_bard_core"), new BlockItem(CRYSTALINE_BARD_CORE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "sickened_celestial_block"), new BlockItem(SICKENED_CELESTIAL_BLOCK,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crystaline_sickened_core"), new BlockItem(CRYSTALINE_SICKENED_CORE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "wanderer_celestial_block"), new BlockItem(WANDERER_CELESTIAL_BLOCK,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "crystaline_wanderer_core"), new BlockItem(CRYSTALINE_WANDERER_CORE,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "limestone_tiles"), new BlockItem(LIMESTONE_TILES,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bluestone_tiles"), new BlockItem(BLUESTONE_TILES,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "empty_bookshelf"), new BlockItem(EMPTY_BOOKSHELF,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "corrupted_end_stone_bricks"), new BlockItem(CORRUPTED_END_STONE_BRICKS,
				new FabricItemSettings().group(MORE_WEAPONRY)));
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "corrupted_end_stone"), new BlockItem(CORRUPTED_END_STONE,
				new FabricItemSettings().group(MORE_WEAPONRY)));







		MoreWeaponryEffects.registerMoreWeaponryEffects();
		MoreWeaponryEnchantments.registerMoreWeaponryEnchantments();
		MoreWeaponryEntityRegistry.registerMoreWeaponryEntities();
		MoreWeaponryPaintings.registerMoreWeaponryPaintings();
		MoreWeaponryParticles.registerParticles();
		MoreWeaponryRecipes.registerMoreWeaponryRecipes();
		MoreWeaponryScreenHandlers.registerScreenHandlers();
		MoreWeaponryStructureTypes.registerStructureFeatures();


		MoreWeaponryConfiguredFeatures.registerConfiguredFeatures();
		MoreWeaponryPortals.registerMoreWeaponryPortals();
		MoreWeaponryRegistries.registerMoreWeaponryFeatures();
		MoreWeaponryRegistries.registerMoreWeaponryComposterChances();
		MoreWeaponryRegistries.registerMoreWeaponryStrippables();
		MoreWeaponryWorldGen.generateMoreWeaponryWorldGen();
		MoreWeaponryLootTableModifiers.modifyLootTables();
		MoreWeaponryHeadLootTables.registerMoreWeaponryHeadLootTables();
		MoreWeaponryTags.MoreWeaponryBlockTags();
		MoreWeaponryTags.MoreWeaponryItemTags();
		GeckoLib.initialize();


	}

}
