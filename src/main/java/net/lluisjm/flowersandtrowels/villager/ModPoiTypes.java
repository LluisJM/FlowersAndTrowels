package net.lluisjm.flowersandtrowels.villager;

import com.google.common.collect.ImmutableSet;
import net.lluisjm.flowersandtrowels.FlowersAndTrowels;
import net.lluisjm.flowersandtrowels.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPoiTypes {

    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, FlowersAndTrowels.MOD_ID);

    public static final DeferredHolder<PoiType, PoiType> FLORIST = POI_TYPES.register("florist",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.FLOWER_BASKET.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
    }
}
