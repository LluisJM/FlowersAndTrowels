package net.lluisjm.flowersandtrowels.block.custom;

import net.lluisjm.flowersandtrowels.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class FlowerBasketBlock extends Block {
    protected static final VoxelShape OUTER_SHAPE;
    protected static final VoxelShape SHAPE;

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected VoxelShape getInteractionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return OUTER_SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

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

    static {
        //SHAPE = Block.box(0.0F, 0.0F, 0.0F, 16.0F, 17.0F, 16.0F);
        OUTER_SHAPE = Block.box(0.0F, 0.0F, 0.0F, 16.0F, 17.0F, 16.0F);
        SHAPE = Shapes.join(
                Block.box(0.0F, 0.0F, 0.0F, 16.0F, 17.0F, 16.0F),
                Block.box(3.0F, 16.0F, 3.0F, 13.0F, 17.0F, 13.0F),
                BooleanOp.ONLY_FIRST);
    }
}
