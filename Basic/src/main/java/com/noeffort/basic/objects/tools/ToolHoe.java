package com.noeffort.basic.objects.tools;

import com.noeffort.basic.Basic;
import com.noeffort.basic.init.BlockInit;
import com.noeffort.basic.init.ItemInit;
import com.noeffort.basic.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ToolHoe extends ItemHoe implements IHasModel
{
    public ToolHoe(String name, ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Basic.basictab);

        ItemInit.ITEMS.add(this);
    }

    @Override
    protected void setBlock(ItemStack stack, EntityPlayer player, World worldIn, BlockPos pos, IBlockState state) {
        super.setBlock(stack, player, worldIn, pos, state);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();

        if(block == BlockInit.GRASSES.getDefaultState())
        {
            setBlock(itemstack, player, worldIn, pos, Blocks.FARMLAND.getDefaultState());
            return EnumActionResult.SUCCESS;
        }

        return EnumActionResult.PASS;
    }

    @Override
    public void registerModels()
    {
        Basic.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
