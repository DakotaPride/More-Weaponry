package net.DakotaPride.moreweaponry.item.items;

import com.google.common.collect.Lists;
import net.DakotaPride.moreweaponry.item.MoreWeaponryItems;
import net.DakotaPride.moreweaponry.item.inventory.HeavyCrossbowUser;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class HeavyCrossBowItem extends CrossbowItem
        implements Vanishable
{
    private static final String CHARGED_KEY = "Charged";
    private static final String CHARGED_PROJECTILES_KEY = "ChargedProjectiles";
    private static final int field_30866 = 25;
    public static final int RANGE = 8;
    private boolean charged;
    private boolean loaded;
    private static final float field_30867 = 0.2F;
    private static final float field_30868 = 0.5F;
    private static final float field_30869 = 3.15F;
    private static final float field_30870 = 1.6F;

    public HeavyCrossBowItem(Item.Settings settings) {
        super(settings);
        this.charged = false;
        this.loaded = false;
    }


    @Override
    public Predicate<ItemStack> getHeldProjectiles() {
        return itemStack -> itemStack.isOf(MoreWeaponryItems.IRON_BOLT) || itemStack.isOf(Items.FIREWORK_ROCKET);
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return itemStack -> itemStack.isOf(MoreWeaponryItems.IRON_BOLT);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (isCharged(itemStack)) {
            shootAll(world, user, hand, itemStack, getSpeed(itemStack), 1.0F);
            setCharged(itemStack, false);
            return TypedActionResult.consume(itemStack);
        }

        if (!user.getArrowType(itemStack).isEmpty()) {
            if (!isCharged(itemStack)) {
                this.charged = false;
                this.loaded = false;
                user.setCurrentHand(hand);
            }
            return TypedActionResult.consume(itemStack);
        }
        return TypedActionResult.fail(itemStack);
    }

    private static float getSpeed(ItemStack stack) {
        if (hasProjectile(stack, Items.FIREWORK_ROCKET)) {
            return 1.6F;
        }
        return 3.15F;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        int i = getMaxUseTime(stack) - remainingUseTicks;
        float f = getPullProgress(i, stack);

        if (f >= 1.0F && !isCharged(stack) &&
                loadProjectiles(user, stack)) {
            setCharged(stack, true);
            SoundCategory soundCategory = (user instanceof PlayerEntity) ? SoundCategory.PLAYERS : SoundCategory.HOSTILE;
            world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_CROSSBOW_LOADING_END, soundCategory, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.5F + 1.0F) + 0.2F);
        }
    }


    private boolean loadProjectiles(LivingEntity shooter, ItemStack projectile) {
        int i = EnchantmentHelper.getLevel(Enchantments.MULTISHOT, projectile);
        int j = (i == 0) ? 1 : 3;
        boolean bl = (shooter instanceof PlayerEntity && (((PlayerEntity)shooter).getAbilities()).creativeMode);

        ItemStack itemStack = shooter.getArrowType(projectile);
        ItemStack itemStack2 = itemStack.copy();
        for (int k = 0; k < j; k++) {
            if (k > 0) {
                itemStack = itemStack2.copy();
            }

            if (itemStack.isEmpty() && bl) {
                itemStack = new ItemStack(MoreWeaponryItems.IRON_BOLT);
                itemStack2 = itemStack.copy();
            }

            if (!loadProjectile(shooter, projectile, itemStack, (k > 0), bl)) {
                return false;
            }
        }

        return true;
    }

    private static boolean loadProjectile(LivingEntity shooter, ItemStack item, ItemStack projectile, boolean simulated, boolean creative) {
        ItemStack itemStack;
        if (projectile.isEmpty()) {
            return false;
        }
        boolean bl = (creative && projectile.getItem() instanceof IronBoltItem);


        if (!bl && !creative && !simulated) {
            itemStack = projectile.split(1);
            if (projectile.isEmpty() && shooter instanceof PlayerEntity)
            {
                ((PlayerEntity)shooter).getInventory().removeOne(projectile);
            }
        } else {
            itemStack = projectile.copy();
        }

        putProjectile(item, itemStack);
        return true;
    }

    public static boolean isCharged(ItemStack stack) {
        NbtCompound nbtCompound = stack.getNbt();
        return (nbtCompound != null && nbtCompound.getBoolean("Charged"));
    }

    public static void setCharged(ItemStack stack, boolean charged) {
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        nbtCompound.putBoolean("Charged", charged);
    }

    private static void putProjectile(ItemStack itemStack, ItemStack projectile) {
        NbtList nbtList;
        NbtCompound nbtCompound = itemStack.getOrCreateNbt();

        if (nbtCompound.contains("ChargedProjectiles", 9)) {
            nbtList = nbtCompound.getList("ChargedProjectiles", 10);
        } else {
            nbtList = new NbtList();
        }
        NbtCompound nbtCompound2 = new NbtCompound();
        projectile.writeNbt(nbtCompound2);
        nbtList.add(nbtCompound2);
        nbtCompound.put("ChargedProjectiles", nbtList);
    }

    private static List<ItemStack> getProjectiles(ItemStack itemStack) {
        List<ItemStack> list = Lists.newArrayList();
        NbtCompound nbtCompound = itemStack.getNbt();
        if (nbtCompound != null &&
                nbtCompound.contains("ChargedProjectiles", 9)) {
            NbtList nbtList = nbtCompound.getList("ChargedProjectiles", 10);
            if (nbtList != null) {
                for (int i = 0; i < nbtList.size(); i++) {
                    NbtCompound nbtCompound2 = nbtList.getCompound(i);
                    list.add(ItemStack.fromNbt(nbtCompound2));
                }
            }
        }

        return list;
    }

    private static void clearProjectiles(ItemStack itemStack) {
        NbtCompound nbtCompound = itemStack.getNbt();
        if (nbtCompound != null) {
            NbtList nbtList = nbtCompound.getList("ChargedProjectiles", 9);
            nbtList.clear();
            nbtCompound.put("ChargedProjectiles", nbtList);
        }
    }

    public static boolean hasProjectile(ItemStack itemStack, Item item) {
        return getProjectiles(itemStack).stream().anyMatch(s -> s.isOf(item));
    }

    private static void shoot(World world, LivingEntity shooter, Hand hand, ItemStack itemStack, ItemStack projectile, float soundPitch, boolean creative, float speed, float divergence, float simulated) {
        ProjectileEntity projectileEntity;
        if (world.isClient) {
            return;
        }

        boolean bl = projectile.isOf(Items.FIREWORK_ROCKET);


        if (bl) {
            projectileEntity = new FireworkRocketEntity(world, projectile, shooter, shooter.getX(), shooter.getEyeY() - 0.15000000596046448D, shooter.getZ(), true);
        } else {
            projectileEntity = createIronBolt(world, shooter, itemStack, projectile);
            if (creative || simulated != 0.0F) {
                ((PersistentProjectileEntity)projectileEntity).pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
            }
        }

        if (shooter instanceof HeavyCrossbowUser) {
            HeavyCrossbowUser heavyCrossbowUser = (HeavyCrossbowUser)shooter;
            heavyCrossbowUser.shoot(heavyCrossbowUser.getTarget(), itemStack, projectileEntity, simulated);
        } else {
            Vec3d crossbowUser = shooter.getOppositeRotationVector(1.0F);
            Quaternion quaternion = new Quaternion(new Vec3f(crossbowUser), simulated, true);
            Vec3d vec3d = shooter.getRotationVec(1.0F);
            Vec3f vec3f = new Vec3f(vec3d);
            vec3f.rotate(quaternion);
            projectileEntity.setVelocity(vec3f.getX(), vec3f.getY(), vec3f.getZ(), speed, divergence);
        }

        itemStack.damage(bl ? 3 : 1, shooter, e -> e.sendToolBreakStatus(hand));
        world.spawnEntity(projectileEntity);
        world.playSound((PlayerEntity)null, shooter.getX(), shooter.getY(), shooter.getZ(), SoundEvents.ITEM_CROSSBOW_SHOOT, SoundCategory.PLAYERS, 1.0F, soundPitch);
    }

    private static PersistentProjectileEntity createIronBolt(World world, LivingEntity entity, ItemStack itemStack, ItemStack ironBolt) {
        IronBoltItem ironBoltItem = (ironBolt.getItem() instanceof IronBoltItem) ? (IronBoltItem)ironBolt.getItem() : (IronBoltItem)MoreWeaponryItems.IRON_BOLT;
        PersistentProjectileEntity persistentProjectileEntity = ironBoltItem.createIronBolt(world, ironBolt, entity);
        if (entity instanceof PlayerEntity) {
            persistentProjectileEntity.setCritical(true);
        }
        persistentProjectileEntity.setSound(SoundEvents.ITEM_CROSSBOW_HIT);
        persistentProjectileEntity.setShotFromCrossbow(true);

        int i = EnchantmentHelper.getLevel(Enchantments.PIERCING, itemStack);
        if (i > 0) {
            persistentProjectileEntity.setPierceLevel((byte)i);
        }

        return persistentProjectileEntity;
    }

    public static void shootAll(World world, LivingEntity entity, Hand hand, ItemStack stack, float speed, float divergence) {
        List<ItemStack> list = getProjectiles(stack);
        float[] fs = getSoundPitches(entity.getRandom());

        for (int i = 0; i < list.size(); i++) {
            ItemStack itemStack = list.get(i);
            boolean bl = (entity instanceof PlayerEntity && (((PlayerEntity)entity).getAbilities()).creativeMode);

            if (!itemStack.isEmpty())
            {


                if (i == 0) {
                    shoot(world, entity, hand, stack, itemStack, fs[i], bl, speed, divergence, 0.0F);
                } else if (i == 1) {
                    shoot(world, entity, hand, stack, itemStack, fs[i], bl, speed, divergence, -10.0F);
                } else if (i == 2) {
                    shoot(world, entity, hand, stack, itemStack, fs[i], bl, speed, divergence, 10.0F);
                }
            }
        }
        postShoot(world, entity, stack);
    }

    private static float[] getSoundPitches(Random random) {
        boolean bl = random.nextBoolean();
        return new float[] { 1.0F, getSoundPitch(bl, random), getSoundPitch(!bl, random) };
    }

    private static float getSoundPitch(boolean flag, Random random) {
        float f = flag ? 0.63F : 0.43F;
        return 1.0F / (random.nextFloat() * 0.5F + 1.8F) + f;
    }

    private static void postShoot(World world, LivingEntity entity, ItemStack stack) {
        if (entity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity;
            if (!world.isClient) {
                Criteria.SHOT_CROSSBOW.trigger(serverPlayerEntity, stack);
            }

            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
        }

        clearProjectiles(stack);
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClient) {
            int i = EnchantmentHelper.getLevel(Enchantments.QUICK_CHARGE, stack);
            SoundEvent soundEvent = getQuickChargeSound(i);
            SoundEvent soundEvent2 = (i == 0) ? SoundEvents.ITEM_CROSSBOW_LOADING_MIDDLE : null;
            float f = (stack.getMaxUseTime() - remainingUseTicks) / getPullTime(stack);

            if (f < 0.2F) {
                this.charged = false;
                this.loaded = false;
            }

            if (f >= 0.2F && !this.charged) {
                this.charged = true;
                world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), soundEvent, SoundCategory.PLAYERS, 0.5F, 1.0F);
            }

            if (f >= 0.5F && soundEvent2 != null && !this.loaded) {
                this.loaded = true;
                world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), soundEvent2, SoundCategory.PLAYERS, 0.5F, 1.0F);
            }
        }
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return getPullTime(stack) + 3;
    }

    public static int getPullTime(ItemStack stack) {
        int i = EnchantmentHelper.getLevel(Enchantments.QUICK_CHARGE, stack);
        return (i == 0) ? 25 : (25 - 5 * i);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.CROSSBOW;
    }

    private SoundEvent getQuickChargeSound(int stage) {
        switch (stage) {
            case 1:
                return SoundEvents.ITEM_CROSSBOW_QUICK_CHARGE_1;
            case 2:
                return SoundEvents.ITEM_CROSSBOW_QUICK_CHARGE_2;
            case 3:
                return SoundEvents.ITEM_CROSSBOW_QUICK_CHARGE_3;
        }
        return SoundEvents.ITEM_CROSSBOW_LOADING_START;
    }


    private static float getPullProgress(int useTicks, ItemStack stack) {
        float f = useTicks / getPullTime(stack);
        if (f > 1.0F) {
            f = 1.0F;
        }
        return f;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText("item.moreweaponry.description.double_handed").formatted(Formatting.DARK_RED));
        List<ItemStack> list = getProjectiles(stack);
        if (!isCharged(stack) || list.isEmpty()) {
            return;
        }

        ItemStack itemStack = list.get(0);
        tooltip.add((new TranslatableText("item.minecraft.crossbow.projectile")).append(" ").append(itemStack.toHoverableText()));
        if (context.isAdvanced() && itemStack.isOf(Items.FIREWORK_ROCKET)) {
            List<Text> list2 = Lists.newArrayList();
            Items.FIREWORK_ROCKET.appendTooltip(itemStack, world, list2, context);
            if (!list2.isEmpty()) {
                for (int i = 0; i < list2.size(); i++) {
                    list2.set(i, (new LiteralText("  ")).append(list2.get(i)).formatted(Formatting.GRAY));
                }

                tooltip.addAll(list2);
            }
        }
    }

    @Override
    public boolean isUsedOnRelease(ItemStack stack) {
        return stack.isOf(this);
    }

    @Override
    public int getRange() {
        return 8;
    }
}
