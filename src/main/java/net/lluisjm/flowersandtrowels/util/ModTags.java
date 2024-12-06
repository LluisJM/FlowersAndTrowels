package net.lluisjm.flowersandtrowels.util;

import net.lluisjm.flowersandtrowels.FlowersAndTrowels;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> MINEABLE_WITH_TROWEL = createTag("mineable_with_trowel");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(FlowersAndTrowels.MOD_ID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(FlowersAndTrowels.MOD_ID, name));
        }
    }
}
