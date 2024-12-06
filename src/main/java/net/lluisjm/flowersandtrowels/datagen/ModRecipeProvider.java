package net.lluisjm.flowersandtrowels.datagen;

import net.lluisjm.flowersandtrowels.FlowersAndTrowels;
import net.lluisjm.flowersandtrowels.block.ModBlocks;
import net.lluisjm.flowersandtrowels.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FLOWER_BASKET.get())
                .pattern("# #")
                .pattern("#@#")
                .pattern("###")
                .define('#', ItemTags.WOODEN_SLABS)
                .define('@', ModBlocks.PREPARED_DIRT)
                .unlockedBy("has_prepared_dirt", has(ModBlocks.PREPARED_DIRT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_TROWEL.get())
                .pattern(" # ")
                .pattern(" ##")
                .pattern("@  ")
                .define('#', ItemTags.PLANKS)
                .define('@', Items.STICK)
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TROWEL.get())
                .pattern(" I ")
                .pattern(" #I")
                .pattern("@  ")
                .define('#', Items.IRON_INGOT)
                .define('I', Items.IRON_NUGGET)
                .define('@', Items.STICK)
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_ingot", has(Items.IRON_INGOT)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.DIRT)
                .requires(ModBlocks.PREPARED_DIRT)
                .requires(Blocks.GRAVEL)
                .unlockedBy("had_prepared_dirt", has(ModBlocks.PREPARED_DIRT)).save(recipeOutput, ResourceLocation.fromNamespaceAndPath(FlowersAndTrowels.MOD_ID, "dirt"));
    }
}
