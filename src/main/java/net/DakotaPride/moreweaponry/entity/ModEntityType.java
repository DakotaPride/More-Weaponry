package net.DakotaPride.moreweaponry.entity;

import com.google.common.collect.ImmutableSet;
import net.DakotaPride.moreweaponry.entity.projectile.ElderScaleTridentEntity;
import net.minecraft.block.Block;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.Util;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ModEntityType<T extends Entity> extends EntityType<PersistentProjectileEntity>
        implements TypeFilter<Entity, T> {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String ENTITY_TAG_KEY = "EntityTag";
    private static final float field_30054 = 1.3964844f;

    public static final Entity ELDER_SCALE_TRIDENT = EntityType.createInstanceFromId("elder_scale_trident", EntityType.Builder.create(ElderScaleTridentEntity::new, SpawnGroup.MISC).setDimensions(0.5f, 0.5f).maxTrackingRange(4).trackingTickInterval(20));

    public ModEntityType(EntityFactory<PersistentProjectileEntity> factory, SpawnGroup spawnGroup, boolean saveable, boolean summonable, boolean fireImmune, boolean spawnableFarFromPlayer, ImmutableSet<Block> canSpawnInside, EntityDimensions dimensions, int maxTrackDistance, int trackTickInterval) {
        super((EntityType.EntityFactory<PersistentProjectileEntity>) factory, spawnGroup, saveable, summonable, fireImmune, spawnableFarFromPlayer, canSpawnInside, dimensions, maxTrackDistance, trackTickInterval);
    }

    @Override
    public Class<? extends Entity> getBaseClass() {
        return null;
    }
    public static class Builder<T extends Entity> {
        private final EntityType.EntityFactory<T> factory;
        private final SpawnGroup spawnGroup;
        private ImmutableSet<Block> canSpawnInside = ImmutableSet.of();
        private boolean saveable = true;
        private boolean summonable = true;
        private boolean fireImmune;
        private boolean spawnableFarFromPlayer;
        private int maxTrackingRange = 5;
        private int trackingTickInterval = 3;
        private EntityDimensions dimensions = EntityDimensions.changing(0.6f, 1.8f);

        private Builder(EntityType.EntityFactory<T> factory, SpawnGroup spawnGroup) {
            this.factory = factory;
            this.spawnGroup = spawnGroup;
            this.spawnableFarFromPlayer = spawnGroup == SpawnGroup.CREATURE || spawnGroup == SpawnGroup.MISC;
        }

        public static <T extends Entity> Builder<T> create(EntityType.EntityFactory<T> factory, SpawnGroup spawnGroup) {
            return new ModEntityType.Builder<T>(factory, spawnGroup);
        }

        public static <T extends Entity> Builder<Entity> create(SpawnGroup spawnGroup) {
            return new ModEntityType.Builder<Entity>((entityType, world) -> null, spawnGroup);
        }

        public Builder<T> setDimensions(float width, float height) {
            this.dimensions = EntityDimensions.changing(width, height);
            return this;
        }

        public Builder<T> disableSummon() {
            this.summonable = false;
            return this;
        }

        public Builder<T> disableSaving() {
            this.saveable = false;
            return this;
        }

        public Builder<T> makeFireImmune() {
            this.fireImmune = true;
            return this;
        }

        public Builder<T> allowSpawningInside(Block ... blocks) {
            this.canSpawnInside = ImmutableSet.copyOf(blocks);
            return this;
        }

        public Builder<T> spawnableFarFromPlayer() {
            this.spawnableFarFromPlayer = true;
            return this;
        }

        public Builder<T> maxTrackingRange(int maxTrackingRange) {
            this.maxTrackingRange = maxTrackingRange;
            return this;
        }

        public Builder<T> trackingTickInterval(int trackingTickInterval) {
            this.trackingTickInterval = trackingTickInterval;
            return this;
        }

        public EntityType<T> build(String id) {
            if (this.saveable) {
                Util.getChoiceType(TypeReferences.ENTITY_TREE, id);
            }
            return new EntityType<T>(this.factory, this.spawnGroup, this.saveable, this.summonable, this.fireImmune, this.spawnableFarFromPlayer, this.canSpawnInside, this.dimensions, this.maxTrackingRange, this.trackingTickInterval);
        }
    }

    public static interface EntityFactory<T extends Entity> {
        public T create(EntityType<T> var1, World var2);
    }
}
