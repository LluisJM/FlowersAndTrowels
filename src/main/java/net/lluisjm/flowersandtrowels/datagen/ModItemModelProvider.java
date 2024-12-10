package net.lluisjm.flowersandtrowels.datagen;

import net.lluisjm.flowersandtrowels.FlowersAndTrowels;
import net.lluisjm.flowersandtrowels.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FlowersAndTrowels.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        flatBlockItem(ModBlocks.ALLIUM_CLUSTER.asItem());
        flatBlockItem(ModBlocks.AZURE_BLUET_CLUSTER.asItem());
        flatBlockItem(ModBlocks.BLUE_ORCHID_CLUSTER.asItem());
        flatBlockItem(ModBlocks.CORNFLOWER_CLUSTER.asItem());
        flatBlockItem(ModBlocks.DANDELION_CLUSTER.asItem());
        flatBlockItem(ModBlocks.LILY_OF_THE_VALLEY_CLUSTER.asItem());
        flatBlockItem(ModBlocks.OXEYE_DAISY_CLUSTER.asItem());
        flatBlockItem(ModBlocks.POPPY_CLUSTER.asItem());
        flatBlockItem(ModBlocks.ORANGE_TULIP_CLUSTER.asItem());
        flatBlockItem(ModBlocks.PINK_TULIP_CLUSTER.asItem());
        flatBlockItem(ModBlocks.RED_TULIP_CLUSTER.asItem());
        flatBlockItem(ModBlocks.WHITE_TULIP_CLUSTER.asItem());

        flatBlockItem(ModBlocks.CHAMOMILE_DAISIES.asItem());

    }

    private ItemModelBuilder flatBlockItem(Item item) {
        ResourceLocation resourceLocation = (ResourceLocation) Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        return (ItemModelBuilder) this.getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0",
                        ResourceLocation.fromNamespaceAndPath(resourceLocation.getNamespace(), "block/" + resourceLocation.getPath()));
    }
}
