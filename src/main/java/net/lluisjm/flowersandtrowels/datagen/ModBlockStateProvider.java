package net.lluisjm.flowersandtrowels.datagen;

import net.lluisjm.flowersandtrowels.FlowersAndTrowels;
import net.lluisjm.flowersandtrowels.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FlowersAndTrowels.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.PREPARED_DIRT);
        //blockBottomTopWithItem(ModBlocks.FLOWER_BASKET);
        simpleBlockWithItem(ModBlocks.FLOWER_BASKET.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/flower_basket")));

        blockCrossWithItem(ModBlocks.ALLIUM_CLUSTER);
        blockCrossWithItem(ModBlocks.AZURE_BLUET_CLUSTER);
        blockCrossWithItem(ModBlocks.BLUE_ORCHID_CLUSTER);
        blockCrossWithItem(ModBlocks.CORNFLOWER_CLUSTER);
        blockCrossWithItem(ModBlocks.DANDELION_CLUSTER);
        blockCrossWithItem(ModBlocks.LILY_OF_THE_VALLEY_CLUSTER);
        blockCrossWithItem(ModBlocks.OXEYE_DAISY_CLUSTER);
        blockCrossWithItem(ModBlocks.POPPY_CLUSTER);
        blockCrossWithItem(ModBlocks.ORANGE_TULIP_CLUSTER);
        blockCrossWithItem(ModBlocks.PINK_TULIP_CLUSTER);
        blockCrossWithItem(ModBlocks.RED_TULIP_CLUSTER);
        blockCrossWithItem(ModBlocks.WHITE_TULIP_CLUSTER);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    private void blockBottomTopWithItem(DeferredBlock<?> deferredBlock) {
        String path = deferredBlock.getId().getPath();
        simpleBlockWithItem(deferredBlock.get(), itemModels().cubeBottomTop(
                blockTexture(deferredBlock.get()).toString(),
                extend(blockTexture(deferredBlock.get()), "_side"),
                extend(blockTexture(deferredBlock.get()), "_bottom"),
                extend(blockTexture(deferredBlock.get()), "_top")
        ));
    }
    private void blockCrossWithItem(DeferredBlock<?> deferredBlock) {
        String path = deferredBlock.getId().getPath();
        simpleBlock(deferredBlock.get(), itemModels().cross(
                blockTexture(deferredBlock.get()).toString(),
                ResourceLocation.fromNamespaceAndPath(FlowersAndTrowels.MOD_ID, "block/" + path)
        ).renderType("minecraft:cutout"));
    }
    /*private void existingBlockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(),
                itemModels().withExistingParent(
                        blockTexture(deferredBlock.get()).toString(),
                        deferredBlock.get().asItem().toString()));
    }*/

    private ResourceLocation extend(ResourceLocation resourceLocation, String suffix) {
        String namespace = resourceLocation.getNamespace();
        String path = resourceLocation.getPath();
        return ResourceLocation.fromNamespaceAndPath(namespace, path + suffix);
    }
}
