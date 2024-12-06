package net.lluisjm.flowersandtrowels.item.custom;

import net.lluisjm.flowersandtrowels.block.ModBlocks;
import net.lluisjm.flowersandtrowels.util.ModTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class TrowelItem extends DiggerItem {
    private static final Map<Block, Block> DIG_MAP =
            Map.of(
                    Blocks.DIRT, ModBlocks.PREPARED_DIRT.get(),
                    Blocks.GRASS_BLOCK, Blocks.DIRT,
                    Blocks.PODZOL, Blocks.DIRT,
                    Blocks.ROOTED_DIRT, Blocks.DIRT,
                    Blocks.DIRT_PATH, Blocks.DIRT,
                    Blocks.COARSE_DIRT, Blocks.DIRT
            );
    public TrowelItem(Tier tier, Properties properties) {
        super(tier, ModTags.Blocks.MINEABLE_WITH_TROWEL, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(DIG_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), DIG_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.ROOTED_DIRT_HIT, SoundSource.BLOCKS);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.FAIL;
    }
}
