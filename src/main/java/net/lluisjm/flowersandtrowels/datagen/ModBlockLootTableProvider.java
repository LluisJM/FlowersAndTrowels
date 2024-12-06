package net.lluisjm.flowersandtrowels.datagen;

import net.lluisjm.flowersandtrowels.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.PREPARED_DIRT.get());
        dropSelf(ModBlocks.FLOWER_BASKET.get());

        add(ModBlocks.ALLIUM_CLUSTER.get(),
                block -> createFlowerClusterDrops(ModBlocks.ALLIUM_CLUSTER.get(), Blocks.ALLIUM, 3, 5));
        add(ModBlocks.AZURE_BLUET_CLUSTER.get(),
                block -> createFlowerClusterDrops(ModBlocks.AZURE_BLUET_CLUSTER.get(), Blocks.AZURE_BLUET, 3, 5));
        add(ModBlocks.BLUE_ORCHID_CLUSTER.get(),
                block -> createFlowerClusterDrops(ModBlocks.BLUE_ORCHID_CLUSTER.get(), Blocks.BLUE_ORCHID, 3, 5));
        add(ModBlocks.CORNFLOWER_CLUSTER.get(),
                block -> createFlowerClusterDrops(ModBlocks.CORNFLOWER_CLUSTER.get(), Blocks.CORNFLOWER, 3, 5));
        add(ModBlocks.DANDELION_CLUSTER.get(),
                block -> createFlowerClusterDrops(ModBlocks.DANDELION_CLUSTER.get(), Blocks.DANDELION, 3, 5));
        add(ModBlocks.LILY_OF_THE_VALLEY_CLUSTER.get(),
                block -> createFlowerClusterDrops(ModBlocks.LILY_OF_THE_VALLEY_CLUSTER.get(), Blocks.LILY_OF_THE_VALLEY, 3, 5));
        add(ModBlocks.OXEYE_DAISY_CLUSTER.get(),
                block -> createFlowerClusterDrops(ModBlocks.OXEYE_DAISY_CLUSTER.get(), Blocks.OXEYE_DAISY, 3, 5));
        add(ModBlocks.POPPY_CLUSTER.get(),
                block -> createFlowerClusterDrops(ModBlocks.POPPY_CLUSTER.get(), Blocks.POPPY, 3, 5));
        add(ModBlocks.ORANGE_TULIP_CLUSTER.get(),
                block -> createFlowerClusterDrops(ModBlocks.ORANGE_TULIP_CLUSTER.get(), Blocks.ORANGE_TULIP, 3, 5));
        add(ModBlocks.PINK_TULIP_CLUSTER.get(),
                block -> createFlowerClusterDrops(ModBlocks.PINK_TULIP_CLUSTER.get(), Blocks.PINK_TULIP, 3, 5));
        add(ModBlocks.RED_TULIP_CLUSTER.get(),
                block -> createFlowerClusterDrops(ModBlocks.RED_TULIP_CLUSTER.get(), Blocks.RED_TULIP, 3, 5));
        add(ModBlocks.WHITE_TULIP_CLUSTER.get(),
                block -> createFlowerClusterDrops(ModBlocks.WHITE_TULIP_CLUSTER.get(), Blocks.WHITE_TULIP, 3, 5));
    }

    protected LootTable.Builder createFlowerClusterDrops(Block flowerClusterBlock, Block flowerBlock, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createShearsDispatchTable(flowerClusterBlock,
                this.applyExplosionDecay(flowerClusterBlock, LootItem.lootTableItem(flowerBlock)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
