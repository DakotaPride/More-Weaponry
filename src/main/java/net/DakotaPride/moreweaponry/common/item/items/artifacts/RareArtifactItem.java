package net.DakotaPride.moreweaponry.common.item.items.artifacts;

import net.DakotaPride.moreweaponry.common.MoreWeaponry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static java.lang.Boolean.TYPE;

public class RareArtifactItem extends Item {
    public RareArtifactItem(Settings settings) {
        super(settings);
    }

    public enum ArtifactItemList {
        WATCHER,
        WANDERER,
        SICKENED,
        SICKENED_HUSK,
        BARD,
        CRACKLER
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.addStatusEffect(getArtifactEffect(getArtifactType(user.getStackInHand(hand).getItem())));
        return super.use(world, user, hand);
    }

    public static StatusEffectInstance getArtifactEffect(ArtifactItemList type) {
        switch (type) {
            case WATCHER -> {
                return new StatusEffectInstance(StatusEffects.STRENGTH, 10000, 2);
            }
            case BARD -> {
                return new StatusEffectInstance(StatusEffects.REGENERATION, 8000, 2);
            }
            case CRACKLER -> {
                return new StatusEffectInstance(StatusEffects.RESISTANCE, 7000, 2);
            }
            case WANDERER -> {
                return new StatusEffectInstance(MoreWeaponry.COLD_BLOODED, 9000, 2);
            }
            case SICKENED -> {
                return new StatusEffectInstance(StatusEffects.SPEED, 5000, 2);
            }
            case SICKENED_HUSK -> {
                return new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 2);
            }
        }

        return null;
    }



    public ArtifactItemList getArtifactType(Item item) {
        ArtifactItemList type = null;

        if (item == MoreWeaponry.CORRUPTED_EYE_OF_ENDER) {
            type = ArtifactItemList.WATCHER;
        } else if (item == MoreWeaponry.FORGOTTEN_MUSIC_SHEET) {
            type = ArtifactItemList.BARD;
        } else if (item == MoreWeaponry.TICKING_HEART) {
            type = ArtifactItemList.CRACKLER;
        } else if (item == MoreWeaponry.POISONOUS_FANG) {
            type = ArtifactItemList.WANDERER;
        } else if (item == MoreWeaponry.LIFE_CORE) {
            type = ArtifactItemList.SICKENED;
        } else if (item == MoreWeaponry.DUSTED_LIFE_CORE) {
            type = ArtifactItemList.SICKENED_HUSK;
        }

        return type;
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.moreweaponry.tooltip.artifact.rare").formatted(Formatting.GOLD));
    }
}
