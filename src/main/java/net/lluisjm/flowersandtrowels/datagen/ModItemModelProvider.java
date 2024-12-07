package net.lluisjm.flowersandtrowels.datagen;

import net.lluisjm.flowersandtrowels.FlowersAndTrowels;
import net.lluisjm.flowersandtrowels.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FlowersAndTrowels.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        crossBlockItem(ModBlocks.ALLIUM_CLUSTER.asItem());
        crossBlockItem(ModBlocks.AZURE_BLUET_CLUSTER.asItem());
        crossBlockItem(ModBlocks.BLUE_ORCHID_CLUSTER.asItem());
        crossBlockItem(ModBlocks.CORNFLOWER_CLUSTER.asItem());
        crossBlockItem(ModBlocks.DANDELION_CLUSTER.asItem());
        crossBlockItem(ModBlocks.LILY_OF_THE_VALLEY_CLUSTER.asItem());
        crossBlockItem(ModBlocks.OXEYE_DAISY_CLUSTER.asItem());
        crossBlockItem(ModBlocks.POPPY_CLUSTER.asItem());
        crossBlockItem(ModBlocks.ORANGE_TULIP_CLUSTER.asItem());
        crossBlockItem(ModBlocks.PINK_TULIP_CLUSTER.asItem());
        crossBlockItem(ModBlocks.RED_TULIP_CLUSTER.asItem());
        crossBlockItem(ModBlocks.WHITE_TULIP_CLUSTER.asItem());
    }

    private ItemModelBuilder crossBlockItem(Item item) {
        ResourceLocation resourceLocation = (ResourceLocation) Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        return (ItemModelBuilder) this.getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0",
                        ResourceLocation.fromNamespaceAndPath(resourceLocation.getNamespace(), "block/" + resourceLocation.getPath()));
    }
}
