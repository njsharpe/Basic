package com.noeffort.basic.objects.blocks;

import com.noeffort.basic.Basic;
import com.noeffort.basic.init.BlockInit;
import com.noeffort.basic.init.ItemInit;
import com.noeffort.basic.util.ItemBlockVariants;
import com.noeffort.basic.util.handlers.EnumHandler;
import com.noeffort.basic.util.interfaces.IHasModel;
import com.noeffort.basic.util.interfaces.IMetaName;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class BlockGrasses extends BlockGrass implements IMetaName, IHasModel
{
    public static final PropertyEnum<EnumHandler.EnumType> VARIANT = PropertyEnum.<EnumHandler.EnumType>create("variant", EnumHandler.EnumType.class);

    private String name;

    public BlockGrasses(String name)
    {
        super();
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(SoundType.PLANT);
        setDefaultState(this.blockState.getBaseState().withProperty(SNOWY, Boolean.valueOf(false)).withProperty(VARIANT, EnumHandler.EnumType.STRANGE));
        setCreativeTab(Basic.basictab);

        this.name = name;

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));

    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for(EnumHandler.EnumType customblockplanks$enumtype : EnumHandler.EnumType.values())
        {
            items.add(new ItemStack(this, 1, customblockplanks$enumtype.getMeta()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {SNOWY, VARIANT});
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(Blocks.DIRT);
    }

    @Override
    public String getSpecialName(ItemStack stack)
    {
        return EnumHandler.EnumType.values()[stack.getItemDamage()].getName();
    }

    @Override
    public void registerModels()
    {
        for(int i = 0; i < EnumHandler.EnumType.values().length; i++)
        {
            Basic.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "grass_" + EnumHandler.EnumType.values()[i].getName(), "inventory");
        }
    }

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable)
    {
        return true;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        this.spreadGrass(worldIn, pos, state, rand, 4, 1, 3, 1);
    }

    public void spreadGrass(World worldIn, BlockPos pos, IBlockState state, Random rand, int tries, int xzSpread, int downSpread, int upSpread )
    {
        if(worldIn.getLightFromNeighbors(pos.up()) >= 9)
        {
            for(int i = 0; i < tries; i++)
            {
                BlockPos newPos = pos.add(rand.nextInt(xzSpread * 2 + 1) - xzSpread, rand.nextInt(downSpread + upSpread + 1) - downSpread, rand.nextInt(xzSpread * 2 + 1) -xzSpread);
                IBlockState target = worldIn.getBlockState(newPos);
                IBlockState blockAboveTarget = worldIn.getBlockState(newPos.up());

                IBlockState targetGrass = spreadsToGrass(state, target);
                if(targetGrass == null) { break; }

                if(worldIn.getLightFromNeighbors(newPos.up()) >= 4 && blockAboveTarget.getLightOpacity(worldIn, newPos.up()) <= 2)
                {
                    worldIn.setBlockState(newPos, targetGrass);
                }
            }
        }
    }

    public static IBlockState spreadsToGrass(IBlockState state, IBlockState target)
    {
        switch((EnumHandler.EnumType)state.getValue(VARIANT))
        {
            case STRANGE:
                if(target.getBlock() == Blocks.DIRT && target.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT)
                {
                    return BlockInit.GRASSES.getDefaultState();
                }
                break;
        }
        return null;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return true;
    }
}
