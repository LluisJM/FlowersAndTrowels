package net.lluisjm.flowersandtrowels.villager;

import com.google.common.collect.ImmutableSet;
import net.lluisjm.flowersandtrowels.FlowersAndTrowels;
import net.lluisjm.flowersandtrowels.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Predicate;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, FlowersAndTrowels.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(Registries.VILLAGER_PROFESSION, FlowersAndTrowels.MOD_ID);

    public static final DeferredHolder<PoiType, PoiType> FLORIST_POI = POI_TYPES.register("florist_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.FLOWER_BASKET.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    /*public static final DeferredHolder<VillagerProfession, VillagerProfession> FLORIST =
            VILLAGER_PROFESSIONS.register("florist", () -> new VillagerProfession("florist",
                    poiTypeHolder -> poiTypeHolder, FLORIST_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_FARMER));*/
    public static final DeferredHolder<VillagerProfession, VillagerProfession> FLORIST =
            VILLAGER_PROFESSIONS.register("florist", () -> new VillagerProfession("florist",
                    holder -> holder.is(FLORIST_POI), holder -> holder.is(FLORIST_POI), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_FARMER));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
