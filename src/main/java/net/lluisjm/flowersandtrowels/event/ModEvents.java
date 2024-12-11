package net.lluisjm.flowersandtrowels.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.lluisjm.flowersandtrowels.FlowersAndTrowels;
import net.lluisjm.flowersandtrowels.block.ModBlocks;
import net.lluisjm.flowersandtrowels.item.ModItems;
import net.lluisjm.flowersandtrowels.villager.ModVillagers;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
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
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(ModItems.WOODEN_TROWEL.get(), 1),
                    3, 8, 0.02F));

            // NOVICE / Slot 2
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModBlocks.DANDELION_CLUSTER.get().asItem(), 2),
                    new ItemStack(Items.EMERALD, 1),
                    5, 3, 0.02F));
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModBlocks.POPPY_CLUSTER.get().asItem(), 2),
                    new ItemStack(Items.EMERALD, 1),
                    5, 3, 0.02F));

            // APPRENTICE / Slot 3
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(ModBlocks.FLOWER_BASKET.get().asItem(), 1),
                    5, 3, 0.02F));

            // APPRENTICE / Slot 4
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlocks.ORANGE_TULIP_CLUSTER.get().asItem(), 1),
                    5, 3, 0.02F));
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlocks.PINK_TULIP_CLUSTER.get().asItem(), 1),
                    5, 3, 0.02F));
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlocks.RED_TULIP_CLUSTER.get().asItem(), 1),
                    5, 3, 0.02F));
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlocks.WHITE_TULIP_CLUSTER.get().asItem(), 1),
                    5, 3, 0.02F));

            // JOURNEYMAN / Slot 5
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 5),
                    new ItemStack(Items.BLUE_ORCHID, 16),
                    5, 5, 0.02F));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 5),
                    new ItemStack(Items.ALLIUM, 16),
                    5, 5, 0.02F));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 5),
                    new ItemStack(Items.LILY_OF_THE_VALLEY, 16),
                    5, 5, 0.02F));

            // EXPERT / Slot 6
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(Items.SUSPICIOUS_STEW, 1),
                    5, 3, 0.02F));

            // MASTER / Slot 7
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 8),
                    new ItemStack(ModItems.TROWEL.get(), 1),
                    5, 3, 0.02F));

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
}
