package net.lluisjm.flowersandtrowels.block.custom;

import net.lluisjm.flowersandtrowels.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.Map;

public class FlowerBasketBlock extends Block {

    public static final int MAX_AGE = 5;
    public static final IntegerProperty FLOWER_AGE = IntegerProperty.create("flower_age", 0, 5);
    // public static final BooleanProperty PREPARED = BooleanProperty.create("prepared");
    public FlowerBasketBlock(Properties properties) {
        super(properties);
        //this.registerDefaultState((BlockState)((BlockState)this.defaultBlockState().setValue(FLOWER_AGE, 0)).setValue(PREPARED, false));
        this.registerDefaultState(defaultBlockState()
                .setValue(FLOWER_AGE, 0));
                //.setValue(PREPARED, false));
    }

    public IntegerProperty getAgeProperty() {
        return FLOWER_AGE;
    }
    private static final Map<Block, Block> FLOWER_MAP =
            Map.ofEntries(
                    Map.entry(Blocks.ALLIUM, ModBlocks.ALLIUM_CLUSTER.get()),
                    Map.entry(Blocks.AZURE_BLUET, ModBlocks.AZURE_BLUET_CLUSTER.get()),
                    Map.entry(Blocks.BLUE_ORCHID, ModBlocks.BLUE_ORCHID_CLUSTER.get()),
                    Map.entry(Blocks.CORNFLOWER, ModBlocks.CORNFLOWER_CLUSTER.get()),
                    Map.entry(Blocks.DANDELION, ModBlocks.DANDELION_CLUSTER.get()),
                    Map.entry(Blocks.LILY_OF_THE_VALLEY, ModBlocks.LILY_OF_THE_VALLEY_CLUSTER.get()),
                    Map.entry(Blocks.OXEYE_DAISY, ModBlocks.OXEYE_DAISY_CLUSTER.get()),
                    Map.entry(Blocks.POPPY, ModBlocks.POPPY_CLUSTER.get()),
                    Map.entry(Blocks.ORANGE_TULIP, ModBlocks.ORANGE_TULIP_CLUSTER.get()),
                    Map.entry(Blocks.PINK_TULIP, ModBlocks.PINK_TULIP_CLUSTER.get()),
                    Map.entry(Blocks.RED_TULIP, ModBlocks.RED_TULIP_CLUSTER.get()),
                    Map.entry(Blocks.WHITE_TULIP, ModBlocks.WHITE_TULIP_CLUSTER.get())
            );

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(!level.isClientSide) {
            if(level.isAreaLoaded(pos.above(), 1)) {
                if (level.getRawBrightness(pos.above(), 0) >= 9) {
                    Block flower = level.getBlockState(pos.above()).getBlock();
                    if (FLOWER_MAP.containsKey(flower)) {
                        int currentFlowerAge = state.getValue(FLOWER_AGE);
                        if(currentFlowerAge >= MAX_AGE) {
                            level.setBlockAndUpdate(pos.above(), FLOWER_MAP.get(flower).defaultBlockState());
                        } else {
                            level.setBlockAndUpdate(pos, state.setValue(FLOWER_AGE, currentFlowerAge + 1));
                        }
                    }
                }
            }
        }

        super.randomTick(state, level, pos, random);
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {
        if(!level.isClientSide) {
            if(level.isAreaLoaded(pos.above(), 1)) {
                Block flower = level.getBlockState(pos.above()).getBlock();
                if (!FLOWER_MAP.containsKey(flower)) {
                    level.setBlockAndUpdate(pos, state.setValue(FLOWER_AGE, 0));
                }
            }
        }

        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, movedByPiston);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FLOWER_AGE);
    }
}
