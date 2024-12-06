package net.lluisjm.flowersandtrowels.datagen;

import net.lluisjm.flowersandtrowels.FlowersAndTrowels;
import net.lluisjm.flowersandtrowels.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FlowersAndTrowels.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModBlocks.ALLIUM_CLUSTER.asItem());
        basicItem(ModBlocks.AZURE_BLUET_CLUSTER.asItem());
        basicItem(ModBlocks.BLUE_ORCHID_CLUSTER.asItem());
        basicItem(ModBlocks.CORNFLOWER_CLUSTER.asItem());
        basicItem(ModBlocks.DANDELION_CLUSTER.asItem());
        basicItem(ModBlocks.LILY_OF_THE_VALLEY_CLUSTER.asItem());
        basicItem(ModBlocks.OXEYE_DAISY_CLUSTER.asItem());
        basicItem(ModBlocks.POPPY_CLUSTER.asItem());
        basicItem(ModBlocks.ORANGE_TULIP_CLUSTER.asItem());
        basicItem(ModBlocks.PINK_TULIP_CLUSTER.asItem());
        basicItem(ModBlocks.RED_TULIP_CLUSTER.asItem());
        basicItem(ModBlocks.WHITE_TULIP_CLUSTER.asItem());
    }
}
