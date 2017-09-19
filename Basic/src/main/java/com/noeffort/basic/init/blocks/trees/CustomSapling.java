package com.noeffort.basic.init.blocks.trees;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.noeffort.basic.util.interfaces.IMetaName;
import com.noeffort.basic.world.feature.tree.WorldGenStrangeTree;
import net.minecraft.block.IGrowable;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class CustomSapling extends BlockBush implements IGrowable,IMetaName
{
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
    public static final PropertyEnum<CustomPlank.EnumType> VARIANT = PropertyEnum.<CustomPlank.EnumType>create("variant", CustomPlank.EnumType.class, new Predicate<CustomPlank.EnumType>() {

        public boolean apply(@Nullable CustomPlank.EnumType apply)
        {
            return apply.getMeta() < 2;
        }
    });

    public CustomSapling(String name, SoundType sound)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(sound);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, CustomPlank.EnumType.STRANGE).withProperty(STAGE, Integer.valueOf(0)));
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return SAPLING_AABB;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }

    public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
        WorldGenerator worldgenerator = (WorldGenerator)(rand.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true));
        int i = 0, j = 0;
        boolean flag = false;

        switch((CustomPlank.EnumType)state.getValue(VARIANT))
        {
            case STRANGE:
                worldgenerator = new WorldGenStrangeTree();
                break;
            default:
                break;
        }

        IBlockState iblockstate = Blocks.AIR.getDefaultState();
        if (flag)
        {
            worldIn.setBlockState(pos.add(i, 0, j), iblockstate, 4);
            worldIn.setBlockState(pos.add(i + 1, 0, j), iblockstate, 4);
            worldIn.setBlockState(pos.add(i, 0, j + 1), iblockstate, 4);
            worldIn.setBlockState(pos.add(i + 1, 0, j + 1), iblockstate, 4);
        }
        else
        {
            worldIn.setBlockState(pos, iblockstate, 4);
        }

        if (!worldgenerator.generate(worldIn, rand, pos.add(i, 0, j)))
        {
            if (flag)
            {
                worldIn.setBlockState(pos.add(i, 0, j), state, 4);
                worldIn.setBlockState(pos.add(i + 1, 0, j), state, 4);
                worldIn.setBlockState(pos.add(i, 0, j + 1), state, 4);
                worldIn.setBlockState(pos.add(i + 1, 0, j + 1), state, 4);
            }
            else
            {
                worldIn.setBlockState(pos, state, 4);
            }
        }
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return ((CustomPlank.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for(CustomPlank.EnumType customblockplanks$enumtype : CustomPlank.EnumType.values())
        {
            items.add(new ItemStack(this, 1, customblockplanks$enumtype.getMeta()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, CustomPlank.EnumType.byMetadata(meta & 1)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((CustomPlank.EnumType)state.getValue(VARIANT)).getMeta();
        i = i | ((Integer)state.getValue(STAGE)).intValue() << 3;
        return i;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT, STAGE});
    }

    @Override
    public String getSpecialName(ItemStack stack)
    {
        return CustomPlank.EnumType.values()[stack.getItemDamage()].getName();
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        if (((Integer)state.getValue(STAGE)).intValue() == 0)
        {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            this.generateTree(worldIn, pos, state, rand);
        }
    }
}