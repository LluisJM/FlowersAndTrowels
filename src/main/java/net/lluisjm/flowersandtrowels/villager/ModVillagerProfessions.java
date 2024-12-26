package net.lluisjm.flowersandtrowels.villager;

import com.google.common.collect.ImmutableSet;
import net.lluisjm.flowersandtrowels.FlowersAndTrowels;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModVillagerProfessions {

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(Registries.VILLAGER_PROFESSION, FlowersAndTrowels.MOD_ID);

    public static final DeferredHolder<VillagerProfession, VillagerProfession> FLORIST =
            VILLAGER_PROFESSIONS.register("florist", () -> new VillagerProfession("florist",
                    holder -> holder.is(ModPoiTypes.FLORIST), holder -> holder.is(ModPoiTypes.FLORIST),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_FARMER));

    public static void register(IEventBus eventBus) {
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
