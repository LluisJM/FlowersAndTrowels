package net.lluisjm.flowersandtrowels.datagen;

import net.lluisjm.flowersandtrowels.FlowersAndTrowels;
import net.lluisjm.flowersandtrowels.block.ModBlocks;
import net.lluisjm.flowersandtrowels.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FlowersAndTrowels.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Blocks.MINEABLE_WITH_TROWEL)
                .add(Blocks.GRASS_BLOCK)
                .add(Blocks.DIRT)
                .add(Blocks.COARSE_DIRT)
                .add(Blocks.FARMLAND)
                .add(Blocks.DIRT_PATH)
                .add(Blocks.PODZOL)
                .add(Blocks.MYCELIUM)
                .add(ModBlocks.PREPARED_DIRT.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.FLOWER_BASKET.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.PREPARED_DIRT.get());

        tag(BlockTags.DIRT)
                .add(ModBlocks.PREPARED_DIRT.get())
                .add(ModBlocks.FLOWER_BASKET.get());
        tag(BlockTags.FLOWERS)
                .add(ModBlocks.ALLIUM_CLUSTER.get())
                .add(ModBlocks.AZURE_BLUET_CLUSTER.get())
                .add(ModBlocks.BLUE_ORCHID_CLUSTER.get())
                .add(ModBlocks.CORNFLOWER_CLUSTER.get())
                .add(ModBlocks.DANDELION_CLUSTER.get())
                .add(ModBlocks.LILY_OF_THE_VALLEY_CLUSTER.get())
                .add(ModBlocks.OXEYE_DAISY_CLUSTER.get())
                .add(ModBlocks.POPPY_CLUSTER.get())
                .add(ModBlocks.ORANGE_TULIP_CLUSTER.get())
                .add(ModBlocks.PINK_TULIP_CLUSTER.get())
                .add(ModBlocks.RED_TULIP_CLUSTER.get())
                .add(ModBlocks.WHITE_TULIP_CLUSTER.get());
    }
}
