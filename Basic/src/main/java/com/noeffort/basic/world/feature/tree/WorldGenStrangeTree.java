package com.noeffort.basic.world.feature.tree;

import com.noeffort.basic.init.BlockInit;
import com.noeffort.basic.init.blocks.trees.CustomLeaves;
import com.noeffort.basic.init.blocks.trees.CustomLog;
import com.noeffort.basic.init.blocks.trees.CustomPlank;
import com.noeffort.basic.init.blocks.trees.CustomSapling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class WorldGenStrangeTree extends WorldGenAbstractTree
{
    private static final IBlockState LOG = BlockInit.log.getDefaultState().withProperty(CustomLog.VARIANT, CustomPlank.EnumType.STRANGE);
    private static final IBlockState LEAF = BlockInit.leaves.getDefaultState().withProperty(CustomLeaves.VARIANT, CustomPlank.EnumType.STRANGE).withProperty(CustomLeaves.CHECK_DECAY, Boolean.valueOf(false));

    private final int minHeight;

    public WorldGenStrangeTree()
    {
        super(false);
        this.minHeight = 5;
    }

    @Override
    public boolean generate(World world, Random random, BlockPos pos)
    {
        int height = random.nextInt(3) + this.minHeight;
        boolean flag = true;

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        for(int yPos = y; yPos <= y + 1 + height; yPos++)
        {
            int b0 = 2;
            if(yPos == y) b0 = 1;
            if(yPos >= y + 1 + height - 2) b0 = 2;

            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

            for(int xPos = x - b0; xPos <= x + b0 && flag; xPos++)
            {
                for(int zPos = z - b0; zPos <= z + b0 && flag; zPos++)
                {
                    if(yPos >= 0 && yPos < world.getHeight())
                    {
                        if(!this.isReplaceable(world, blockpos$mutableblockpos.setPos(xPos, yPos, zPos)))
                        {
                            flag = false;
                        }
                    }
                    else
                    {
                        flag = false;
                    }
                }
            }
        }

        if(!flag)
        {
            return false;
        }
        else
        {
            BlockPos down = pos.down();
            IBlockState state = world.getBlockState(down);
            boolean isSoil = state.getBlock().canSustainPlant(state, world, down, EnumFacing.UP, (CustomSapling)BlockInit.sapling);

            if(isSoil && y < world.getHeight() - height - 1)
            {
                state.getBlock().onPlantGrow(state, world, down, pos);


                for(int yPosAlt = y - 3 + height; yPosAlt <= y + height; yPosAlt++)
                {
                    int b1 = yPosAlt - (y + height);
                    int b2 = 1 - b1 / 2;

                    for(int xPosAlt = x - b2; xPosAlt <= x + b2; xPosAlt++)
                    {
                        int b3 = xPosAlt - x;

                        for(int zPosAlt = z - b2; zPosAlt <= z + b2; zPosAlt++)
                        {
                            int b4 = zPosAlt - z;

                            if(Math.abs(b3) != b2 || Math.abs(b4) != b2 || random.nextInt(2) != 0 && b1 != 0)
                            {
                                BlockPos blockPos = new BlockPos(xPosAlt, yPosAlt, zPosAlt);
                                IBlockState iBlockState = world.getBlockState(blockPos);
                                if(iBlockState.getBlock().isAir(iBlockState, world, blockPos) || iBlockState.getBlock().isAir(iBlockState, world, blockPos))
                                {
                                    this.setBlockAndNotifyAdequately(world, blockPos, LEAF);
                                }
                            }
                        }
                    }
                }

                for (int logHeight = 0; logHeight < height; logHeight++)
                {
                    BlockPos up = pos.up(logHeight);
                    IBlockState iBlockState = world.getBlockState(up);

                    if (iBlockState.getBlock().isAir(iBlockState, world, up) || iBlockState.getBlock().isLeaves(iBlockState, world, up))
                    {
                        this.setBlockAndNotifyAdequately(world, pos.up(logHeight), LOG);
                    }
                }

                return true;
            }
        }
        return true;
    }
}
