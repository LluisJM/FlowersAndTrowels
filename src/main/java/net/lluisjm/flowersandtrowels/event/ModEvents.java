package net.lluisjm.flowersandtrowels.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.lluisjm.flowersandtrowels.FlowersAndTrowels;
import net.lluisjm.flowersandtrowels.block.ModBlocks;
import net.lluisjm.flowersandtrowels.item.ModItems;
import net.lluisjm.flowersandtrowels.villager.ModVillagers;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

import java.util.List;

@EventBusSubscriber(modid = FlowersAndTrowels.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.FLORIST.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // NOVICE / Slot 1
            trades.get(1).add((entity, randomSource) -> emeraldForItems(
                    2, ModItems.WOODEN_TROWEL.get(), 1, 3, 8, 0.02F));

            // NOVICE / Slot 2
            trades.get(1).add((entity, randomSource) -> itemForEmeralds(
                    1, Items.DANDELION, 16, 5, 3, 0.02F));
            trades.get(1).add((entity, randomSource) -> itemForEmeralds(
                    1, Items.POPPY, 16, 5, 3, 0.02F));

            // APPRENTICE / Slot 3
            trades.get(2).add((entity, randomSource) -> emeraldForItems(
                    2, ModBlocks.FLOWER_BASKET.get(), 1, 5, 3, 0.02F));

            // APPRENTICE / Slot 4
            trades.get(2).add((entity, randomSource) -> itemForEmeralds(
                    2, ModBlocks.ORANGE_TULIP_CLUSTER.get(), 8, 4, 5, 0.02F));
            trades.get(2).add((entity, randomSource) -> itemForEmeralds(
                    2, ModBlocks.PINK_TULIP_CLUSTER.get(), 8, 4, 5, 0.02F));
            trades.get(2).add((entity, randomSource) -> itemForEmeralds(
                    2, ModBlocks.RED_TULIP_CLUSTER.get(), 8, 4, 5, 0.02F));
            trades.get(2).add((entity, randomSource) -> itemForEmeralds(
                    2, ModBlocks.WHITE_TULIP_CLUSTER.get(), 8, 4, 5, 0.02F));

            // JOURNEYMAN / Slot 5
            trades.get(3).add((entity, randomSource) -> emeraldForItems(
                    2, Items.CORNFLOWER, 8, 4, 5, 0.02F));
            trades.get(3).add((entity, randomSource) -> emeraldForItems(
                    2, Items.ALLIUM, 8, 4, 5, 0.02F));
            trades.get(3).add((entity, randomSource) -> emeraldForItems(
                    2, Items.LILY_OF_THE_VALLEY, 8, 4, 5, 0.02F));

            // EXPERT / Slot 6
            trades.get(4).add((entity, randomSource) -> itemForEmeralds(
                    4, Items.BLUE_ORCHID, 16, 4, 5, 0.02F));

            // MASTER / Slot 7
            trades.get(5).add((entity, randomSource) -> emeraldForItems(
                    16, ModItems.TROWEL.get(), 1, 4, 5, 0.02F));

            /*trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.DANDELION, 32),
                    new ItemStack(Items.EMERALD, 1),
                    3, 4, 0.02F));
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.POPPY, 32),
                    new ItemStack(Items.EMERALD, 1),
                    3, 4, 0.02F));
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.AZURE_BLUET, 32),
                    new ItemStack(Items.EMERALD, 1),
                    3, 4, 0.02F));
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.OXEYE_DAISY, 32),
                    new ItemStack(Items.EMERALD, 1),
                    3, 4, 0.02F));
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.CORNFLOWER, 32),
                    new ItemStack(Items.EMERALD, 1),
                    3, 4, 0.02F));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.ORANGE_TULIP, 32),
                    new ItemStack(Items.EMERALD, 1),
                    3, 4, 0.02F));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.PINK_TULIP, 32),
                    new ItemStack(Items.EMERALD, 1),
                    3, 4, 0.02F));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.RED_TULIP, 32),
                    new ItemStack(Items.EMERALD, 1),
                    3, 4, 0.02F));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.WHITE_TULIP, 32),
                    new ItemStack(Items.EMERALD, 1),
                    3, 4, 0.02F));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.LILY_OF_THE_VALLEY, 32),
                    new ItemStack(Items.EMERALD, 1),
                    3, 4, 0.02F));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.BLUE_ORCHID, 32),
                    new ItemStack(Items.EMERALD, 1),
                    3, 4, 0.02F));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 16),
                    new ItemStack(ModItems.TROWEL.get(), 1),
                    3, 4, 0.02F));*/
        }
    }

    private static MerchantOffer emeraldForItems(int emeraldCount, ItemLike item, int itemCount, int maxUses, int xp, float priceMultiplier) {
        return new MerchantOffer(
                new ItemCost(Items.EMERALD, emeraldCount),
                new ItemStack(item, itemCount),
                maxUses, xp, priceMultiplier);
    }

    private static MerchantOffer itemForEmeralds(int emeraldCount, ItemLike item, int itemCount, int maxUses, int xp, float priceMultiplier) {
        return new MerchantOffer(
                new ItemCost(item, itemCount),
                new ItemStack(Items.EMERALD, emeraldCount),
                maxUses, xp, priceMultiplier);
    }
}
