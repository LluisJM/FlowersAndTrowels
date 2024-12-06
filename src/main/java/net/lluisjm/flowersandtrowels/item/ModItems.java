package net.lluisjm.flowersandtrowels.item;

import net.lluisjm.flowersandtrowels.FlowersAndTrowels;
import net.lluisjm.flowersandtrowels.item.custom.TrowelItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FlowersAndTrowels.MOD_ID);

    // Trowels
    public static final DeferredItem<Item> WOODEN_TROWEL = ITEMS.register("wooden_trowel",
            () -> new TrowelItem(Tiers.WOOD, new Item.Properties().durability(12)));
    public static final DeferredItem<Item> TROWEL = ITEMS.register("trowel",
            () -> new TrowelItem(Tiers.IRON, new Item.Properties().durability(32)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
