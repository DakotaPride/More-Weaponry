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
import net.DakotaPride.moreweaponry.effect.status_effects.BleedingStatusEffect;
import net.DakotaPride.moreweaponry.effect.status_effects.NumbedStatusEffect;
import net.DakotaPride.moreweaponry.effect.status_effects.base.CelestialEffect;
import net.DakotaPride.moreweaponry.effect.status_effects.base.UnfortunedEffect;
import net.DakotaPride.moreweaponry.effect.status_effects.celestial.*;
import net.DakotaPride.moreweaponry.effect.status_effects.unfortuned.*;
import net.DakotaPride.moreweaponry.enchantments.*;
import net.DakotaPride.moreweaponry.entity.custom.*;
import net.DakotaPride.moreweaponry.item.custom.*;
import net.DakotaPride.moreweaponry.item.custom.bard_tools.*;
import net.DakotaPride.moreweaponry.item.custom.blessed_tools.BlessedArmorItem;
import net.DakotaPride.moreweaponry.item.custom.celestial_madalian.*;
import net.DakotaPride.moreweaponry.item.custom.cirtict.CooledCirtictClusterItem;
import net.DakotaPride.moreweaponry.item.custom.cirtict.HeatedCirtictClusterItem;
import net.DakotaPride.moreweaponry.item.custom.cirtict.cooled.*;
import net.DakotaPride.moreweaponry.item.custom.cirtict.essence.*;
import net.DakotaPride.moreweaponry.item.custom.cirtict.heated.*;
import net.DakotaPride.moreweaponry.item.custom.cores.*;
import net.DakotaPride.moreweaponry.item.custom.crackler_tools.*;
import net.DakotaPride.moreweaponry.item.custom.elder_scale_items.ElderScaleArtifactItem;
import net.DakotaPride.moreweaponry.item.custom.mod_tools.BluestoneIgnitor;
import net.DakotaPride.moreweaponry.item.custom.mod_tools.ModBattleaxeItem;
import net.DakotaPride.moreweaponry.item.custom.mod_tools.ModKnifeItem;
import net.DakotaPride.moreweaponry.item.custom.phantom_helm.PhantomScaleHelm;
import net.DakotaPride.moreweaponry.item.custom.powered_cores.*;
import net.DakotaPride.moreweaponry.item.custom.sickened_tools.*;
import net.DakotaPride.moreweaponry.item.custom.wanderer_tools.*;
import net.DakotaPride.moreweaponry.item.custom.watcher_tools.*;
import net.DakotaPride.moreweaponry.item.extra.MoreWeaponryItemGroup;
import net.DakotaPride.moreweaponry.particle.CelestialMedallionParticle;
import net.DakotaPride.moreweaponry.recipe.CirtictForgeRecipe;
import net.DakotaPride.moreweaponry.recipe.CoreForgeRecipe;
import net.DakotaPride.moreweaponry.recipe.EssenceTranslatorRecipe;
import net.DakotaPride.moreweaponry.screen.CirtictForgeScreenHandler;
import net.DakotaPride.moreweaponry.screen.CoreForgeScreenHandler;
import net.DakotaPride.moreweaponry.screen.EssenceTranslatorScreenHandler;
import net.DakotaPride.moreweaponry.structure.BardRockStructure;
import net.DakotaPride.moreweaponry.structure.DarkestCavernFortressStructure;
import net.DakotaPride.moreweaponry.structure.SickenedGravesStructure;
import net.DakotaPride.moreweaponry.structure.WandererLibraryStructure;
import net.DakotaPride.moreweaponry.util.MoreWeaponryHeadLootTables;
import net.DakotaPride.moreweaponry.util.MoreWeaponryLootTableModifiers;
import net.DakotaPride.moreweaponry.util.MoreWeaponryRegistries;
import net.DakotaPride.moreweaponry.util.MoreWeaponryTags;
import net.DakotaPride.moreweaponry.world.dimension.MoreWeaponryPortals;
import net.DakotaPride.moreweaponry.world.features.MoreWeaponryConfiguredFeatures;
import net.DakotaPride.moreweaponry.world.features.tree.FrodonSaplingGenerator;
import net.DakotaPride.moreweaponry.world.gen.MoreWeaponryWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.StructureFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;


public class MoreWeaponry implements ModInitializer {
	public static final String MOD_ID = "moreweaponry";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	private static BlockItem blockItemState;

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
	public static ModHandleItem HANDLE;
	public static BlockItem KURO_SEEDS;
	public static Item KURO;
	public static Item KURO_BREAD;
	public static NightCuronBrewItem CURON_BREW;
	public static Item FRODON_BOWL;
	public static Item CURON_FLOWER_PETALS;
	public static Item CRUSTED_KURO;
	public static Item BLACKSTONE_INGOT;
	public static ModHandleItem NETHERITE_HANDLE;
	public static Item MARE_DIAMOND;
	public static Item NETHERITE_NUGGET;
	public static ModHandleItem AMETHYST_HANDLE;
	public static Item GUARDIAN_SCALE;
	public static Item ELDER_GUARDIAN_SCALE;
	public static Item ELDER_GUARDIANS_EYE;
	public static ModHandleItem PRISMARINE_HANDLE;
	public static Item WTIHER_ESSENCE;
	public static Item WITHER_BONE;
	public static Item PHANTOM_ESSENCE;
	public static PhantomScaleHelm PHANTOM_HELMET;
	public static Item PHANTOM_SCALE;
	public static Item CIRTICT_INGOT;
	public static SwordItem GLIMMERING_SWORD;
	public static ShovelItem GLIMMERING_SHOVEL;
	public static PickaxeItem GLIMMERING_PICKAXE;
	public static AxeItem GLIMMERING_AXE;
	public static HoeItem GLIMMERING_HOE;
	public static ModBattleaxeItem GLIMMERING_BATTLEAXE;
	public static SwordItem MOON_STONE_SWORD;
	public static ShovelItem MOON_STONE_SHOVEL;
	public static PickaxeItem MOON_STONE_PICKAXE;
	public static AxeItem MOON_STONE_AXE;
	public static HoeItem MOON_STONE_HOE;
	public static ModBattleaxeItem MOON_STONE_BATTLEAXE;
	public static SwordItem BLACKSTONE_METAL_SWORD;
	public static ShovelItem BLACKSTONE_METAL_SHOVEL;
	public static PickaxeItem BLACKSTONE_METAL_PICKAXE;
	public static AxeItem BLACKSTONE_METAL_AXE;
	public static HoeItem BLACKSTONE_METAL_HOE;
	public static ModBattleaxeItem BLACKSTONE_METAL_BATTLEAXE;
	public static ModBattleaxeItem NETHERITE_BATTLEAXE;
	public static ModBattleaxeItem DIAMOND_BATTLEAXE;
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
	public static ArmorItem ELDER_GUARDIAN_SCALE_HELMET;
	public static ArmorItem ELDER_GUARDIAN_SCALE_BREASTPLATE;
	public static ArmorItem ELDER_GUARDIAN_SCALE_LEGGINGS;
	public static ArmorItem ELDER_GUARDIAN_SCALE_BOOTS;
	public static SwordItem ELDER_GUARDIAN_SCALE_SWORD;
	public static ShovelItem ELDER_GUARDIAN_SCALE_SHOVEL;
	public static PickaxeItem ELDER_GUARDIAN_SCALE_PICKAXE;
	public static AxeItem ELDER_GUARDIAN_SCALE_AXE;
	public static HoeItem ELDER_GUARDIAN_SCALE_HOE;
	public static ModBattleaxeItem ELDER_GUARDIAN_SCALE_BATTLEAXE;
	public static ArmorItem GUARDIAN_SCALE_HELMET;
	public static ArmorItem GUARDIAN_SCALE_BREASTPLATE;
	public static ArmorItem GUARDIAN_SCALE_LEGGINGS;
	public static ArmorItem GUARDIAN_SCALE_BOOTS;
	public static SwordItem GUARDIAN_SCALE_SWORD;
	public static ShovelItem GUARDIAN_SCALE_SHOVEL;
	public static PickaxeItem GUARDIAN_SCALE_PICKAXE;
	public static AxeItem GUARDIAN_SCALE_AXE;
	public static HoeItem GUARDIAN_SCALE_HOE;
	public static ModBattleaxeItem GUARDIAN_SCALE_BATTLEAXE;
	public static FabricShieldItem GLIMMERING_SHIELD;
	public static FabricShieldItem MOON_STONE_SHIELD;
	public static FabricShieldItem BLACKSTONE_METAL_SHIELD;
	public static FabricShieldItem GUARDIAN_SCALE_SHIELD;
	public static FabricShieldItem ELDER_SCALE_SHIELD;
	public static ElderScaleArtifactItem ELDER_SCALE_ARTIFACT;
	public static ModKnifeItem GOLDEN_KNIFE;
	public static ModKnifeItem STONE_KNIFE;
	public static ModKnifeItem IRON_KNIFE;
	public static ModKnifeItem DIAMOND_KNIFE;
	public static ModKnifeItem WOODEN_KNIFE;
	public static ModKnifeItem NETHERITE_KNIFE;
	public static ModKnifeItem REFINED_MOON_KNIFE;
	public static ModKnifeItem GLIMMERED_AMETHYST_KNIFE;
	public static ModKnifeItem BLACKSTONE_METAL_KNIFE;
	public static ModKnifeItem GUARDIAN_SCALE_KNIFE;
	public static ModKnifeItem ELDER_GUARDIAN_SCALE_KNIFE;
	public static ModBattleaxeItem GOLDEN_BATTLEAXE;
	public static ModBattleaxeItem WOODEN_BATTLEAXE;
	public static ModBattleaxeItem STONE_BATTLEAXE;
	public static ModBattleaxeItem IRON_BATTLEAXE;
	public static ModBattleaxeItem CIRTICT_BATTLEAXE;
	public static ModBattleaxeItem HEATED_CIRTICT_BATTLEAXE;
	public static ModBattleaxeItem COOLED_CIRTICT_BATTLEAXE;
	public static BluestoneIgnitor BLUESTONE_IGNITOR;
	public static Item BLUESTONE_ROCK;
	public static Item CIRTICT_SCRAP;
	public static CooledCirtictIngot COOLED_CIRTICT_INGOT;
	public static MoreWeaponryMusicDiscItem WARDENS_STEP_MUSIC_DISC;
	public static SignItem FRODON_SIGN;
	public static Item DRAGON_SCALE;
	public static ShulkerShellBoots SHULKER_SHELL_BOOTS;
	public static WitherBroadHammerItem WITHER_BROAD_HAMMER;
	public static ModHandleItem WITHERING_HANDLE;
	public static Item WITHER_BROAD_HAMMER_HEAD;
	public static HeatedCirtictIngot HEATED_CIRTICT_INGOT;
	public static CooledCirtictSword COOLED_CIRTICT_SWORD;
	public static CooledCirtictShovel COOLED_CIRTICT_SHOVEL;
	public static CooledCirtictPickaxe COOLED_CIRTICT_PICKAXE;
	public static CooledCirtictAxe COOLED_CIRTICT_AXE;
	public static CooledCirtictHoe COOLED_CIRTICT_HOE;
	public static CooledCirtictBattleaxe COOLED_CIRTICT_KNIFE;
	public static HeatedCirtictSword HEATED_CIRTICT_SWORD;
	public static HeatedCirtictShovel HEATED_CIRTICT_SHOVEL;
	public static HeatedCirtictPickaxe HEATED_CIRTICT_PICKAXE;
	public static HeatedCirtictAxe HEATED_CIRTICT_AXE;
	public static HeatedCirtictHoe HEATED_CIRTICT_HOE;
	public static HeatedCirtictBattleaxe HEATED_CIRTICT_KNIFE;
	public static SwordItem CIRTICT_SWORD;
	public static ShovelItem CIRTICT_SHOVEL;
	public static PickaxeItem CIRTICT_PICKAXE;
	public static AxeItem CIRTICT_AXE;
	public static HoeItem CIRTICT_HOE;
	public static ModKnifeItem CIRTICT_KNIFE;
	public static CooledCirtictShield COOLED_CIRTICT_SHIELD;
	public static HeatedCirtictShield HEATED_CIRTICT_SHIELD;
	public static FabricShieldItem CIRTICT_SHIELD;
	public static Item CIRTICT_NUGGET;
	public static HeatedCirtictNugget HEATED_CIRTICT_NUGGET;
	public static CooledCirtictNugget COOLED_CIRTICT_NUGGET;
	public static EndicateStaffItem ENDICATE_STAFF;
	public static ModHandleItem ENDICATE_HANDLE;
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


	// Register
	public static <T extends Block> T registerBlock(String name, T block) {
		BlockItem blockItem = blockItemState;
		registerBlockItem(name, blockItem);
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

	public static <T extends BlockItem> void registerBlockItem(String name, T blockItem) {
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, name),
				new Item(new FabricItemSettings().group(MoreWeaponryItemGroup.MORE_WEAPONRY)));
	}


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
