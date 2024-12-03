package net.lluisjm.seedsandtrowels.item;

import net.lluisjm.seedsandtrowels.SeedsAndTrowels;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SeedsAndTrowels.MOD_ID);

    public static final DeferredItem<Item> WOODEN_TROWEL = ITEMS.register("wooden_trowel",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
