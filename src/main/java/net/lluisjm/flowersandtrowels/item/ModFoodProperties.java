package net.lluisjm.flowersandtrowels.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodProperties {
    public static final FoodProperties CHAMOMILE_TEA = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3F)
            .alwaysEdible().usingConvertsTo(Items.GLASS_BOTTLE).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200), 0.75F)
            .build();
}
