package com.noeffort.basic.init.blocks.trees;

import com.google.common.base.Predicate;
import com.noeffort.basic.util.interfaces.IMetaName;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class CustomLeaves extends BlockLeaves implements IMetaName {

    public static final PropertyEnum<CustomPlank.EnumType> VARIANT =
            PropertyEnum.<CustomPlank.EnumType>create("variant", CustomPlank.EnumType.class, new Predicate<CustomPlank.EnumType>() {
        @Override
        public boolean apply(@Nullable CustomPlank.EnumType apply) {
            return apply.getMeta() < 1;
        }
    });

    public CustomLeaves(String name, SoundType sound) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(sound);
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, CustomPlank.EnumType.STRANGE)
                .withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, CustomPlank.EnumType.byMetadata(meta % 1));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = ((CustomPlank.EnumType)state.getValue(VARIANT)).getMeta();
        if(!((Boolean)state.getValue(DECAYABLE)).booleanValue()) {
            i |= 2;
        }

        if (!((Boolean)state.getValue(CHECK_DECAY)).booleanValue()) {
            i |= 4;
        }
        return i;
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for(CustomPlank.EnumType customplank$enumtype : CustomPlank.EnumType.values()) {
            items.add(new ItemStack(this, 1, customplank$enumtype.getMeta()));
        }
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state) {
        return new ItemStack(Item.getItemFromBlock(this), 1, ((CustomPlank.EnumType)state.getValue(VARIANT)).getMeta());
    }

    @Override
    public int damageDropped(IBlockState state) {
        return ((CustomPlank.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public String getSpecialName(ItemStack stack) {
        return CustomPlank.EnumType.values()[stack.getItemDamage()].getName();
    }

    @Override
    protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {
        return;
    }

    @Override
    protected int getSaplingDropChance(IBlockState state) {
        return 25;
    }

    @Override
    public BlockPlanks.EnumType getWoodType(int meta) {
        return null;
    }

    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        return NonNullList.withSize(1, new ItemStack(this, 1 , world.getBlockState(pos).getValue(VARIANT).getMeta()));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {VARIANT, DECAYABLE, CHECK_DECAY});
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
