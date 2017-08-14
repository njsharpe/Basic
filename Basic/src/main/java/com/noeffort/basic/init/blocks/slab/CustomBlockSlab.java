package com.noeffort.basic.init.blocks.slab;

import com.noeffort.basic.init.BlockInit;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public abstract class CustomBlockSlab extends BlockSlab {

    public CustomBlockSlab(String name, float hardness, float resistance) {
        super(Material.WOOD);
        setUnlocalizedName(name);
        setRegistryName(name);

        IBlockState state = this.blockState.getBaseState();

        if(!this.isDouble()) {
            state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);
        }

        setDefaultState(state);
        this.useNeighborBrightness = true;
    }

    @Override
    public String getUnlocalizedName(int meta) {
        return this.getUnlocalizedName();
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return HALF;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return EnumBlockHalf.BOTTOM;
    }

    @Override
    public int damageDropped(IBlockState state) {
        return 0;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        if(!this.isDouble()) {
            return this.getDefaultState().withProperty(HALF, EnumBlockHalf.values()[meta % EnumBlockHalf.values().length]);
        }
        return this.getDefaultState();
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        if(!this.isDouble()) {
            return 0;
        }
        return ((EnumBlockHalf)state.getValue(HALF)).ordinal() + 1;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(BlockInit.strange_plank_slab_half);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {HALF});
    }
}
