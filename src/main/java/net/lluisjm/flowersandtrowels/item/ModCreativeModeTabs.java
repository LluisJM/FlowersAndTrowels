package net.lluisjm.flowersandtrowels.item;

import net.lluisjm.flowersandtrowels.FlowersAndTrowels;
import net.lluisjm.flowersandtrowels.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FlowersAndTrowels.MOD_ID);

    public static final Supplier<CreativeModeTab> MOD_ITEMS_TAB = CREATIVE_MODE_TAB.register("mod_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TROWEL.get()))
                    .title(Component.translatable("creativetab.flowersandtrowels.mod_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // TOOLS
                        output.accept(ModItems.WOODEN_TROWEL);
                        output.accept(ModItems.TROWEL);

                        // FOODS & DRINKS
                        output.accept(ModItems.CHAMOMILE_TEA);

                        // BLOCKS
                        output.accept(ModBlocks.PREPARED_DIRT);
                        output.accept(ModBlocks.FLOWER_BASKET);

                        // FLOWER CLUSTERS
                        output.accept(ModBlocks.ALLIUM_CLUSTER);
                        output.accept(ModBlocks.AZURE_BLUET_CLUSTER);
                        output.accept(ModBlocks.BLUE_ORCHID_CLUSTER);
                        output.accept(ModBlocks.CORNFLOWER_CLUSTER);
                        output.accept(ModBlocks.DANDELION_CLUSTER);
                        output.accept(ModBlocks.LILY_OF_THE_VALLEY_CLUSTER);
                        output.accept(ModBlocks.OXEYE_DAISY_CLUSTER);
                        output.accept(ModBlocks.POPPY_CLUSTER);
                        output.accept(ModBlocks.ORANGE_TULIP_CLUSTER);
                        output.accept(ModBlocks.PINK_TULIP_CLUSTER);
                        output.accept(ModBlocks.RED_TULIP_CLUSTER);
                        output.accept(ModBlocks.WHITE_TULIP_CLUSTER);
                        output.accept(ModBlocks.CHAMOMILE_DAISIES);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
