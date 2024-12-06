package net.lluisjm.flowersandtrowels.block;

import net.lluisjm.flowersandtrowels.FlowersAndTrowels;
import net.lluisjm.flowersandtrowels.block.custom.FlowerBasketBlock;
import net.lluisjm.flowersandtrowels.item.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(FlowersAndTrowels.MOD_ID);

    // FLOWER CLUSTERS
    public static final DeferredBlock<Block> ALLIUM_CLUSTER = registerBlock("allium_cluster",
            () -> new FlowerBlock(MobEffects.FIRE_RESISTANCE, 6.0F, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> AZURE_BLUET_CLUSTER = registerBlock("azure_bluet_cluster",
            () -> new FlowerBlock(MobEffects.JUMP, 5.0F, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> BLUE_ORCHID_CLUSTER = registerBlock("blue_orchid_cluster",
            () -> new FlowerBlock(MobEffects.JUMP, 5.0F, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> CORNFLOWER_CLUSTER = registerBlock("cornflower_cluster",
            () -> new FlowerBlock(MobEffects.JUMP, 5.0F, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> DANDELION_CLUSTER = registerBlock("dandelion_cluster",
            () -> new FlowerBlock(MobEffects.SATURATION, 0.7F, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> LILY_OF_THE_VALLEY_CLUSTER = registerBlock("lily_of_the_valley_cluster",
            () -> new FlowerBlock(MobEffects.JUMP, 5.0F, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> OXEYE_DAISY_CLUSTER = registerBlock("oxeye_daisy_cluster",
            () -> new FlowerBlock(MobEffects.REGENERATION, 14.0F, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> POPPY_CLUSTER = registerBlock("poppy_cluster",
            () -> new FlowerBlock(MobEffects.NIGHT_VISION, 10.0F, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> ORANGE_TULIP_CLUSTER = registerBlock("orange_tulip_cluster",
            () -> new FlowerBlock(MobEffects.JUMP, 5.0F, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> PINK_TULIP_CLUSTER = registerBlock("pink_tulip_cluster",
            () -> new FlowerBlock(MobEffects.JUMP, 5.0F, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> RED_TULIP_CLUSTER = registerBlock("red_tulip_cluster",
            () -> new FlowerBlock(MobEffects.JUMP, 5.0F, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> WHITE_TULIP_CLUSTER = registerBlock("white_tulip_cluster",
            () -> new FlowerBlock(MobEffects.JUMP, 5.0F, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)));

    // MISC BLOCKS
    public static final DeferredBlock<Block> PREPARED_DIRT = registerBlock("prepared_dirt",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIRT).strength(0.5f).sound(SoundType.GRAVEL)));
    public static final DeferredBlock<Block> FLOWER_BASKET = registerBlock("flower_basket",
            () -> new FlowerBasketBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIRT).strength(2f).sound(SoundType.WOOD).randomTicks().noOcclusion()));

    private  static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
