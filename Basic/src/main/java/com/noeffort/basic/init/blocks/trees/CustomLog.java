package com.noeffort.basic.init.blocks.trees;


import com.google.common.base.Predicate;
import com.noeffort.basic.util.interfaces.IMetaName;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nullable;

public class CustomLog extends BlockLog implements IMetaName {

    public static final PropertyEnum<CustomPlank.EnumType> VARIANT =
            PropertyEnum.<CustomPlank.EnumType>create("variant", CustomPlank.EnumType.class, new Predicate<CustomPlank.EnumType>() {
        @Override
        public boolean apply(@Nullable CustomPlank.EnumType apply) {
            return apply.getMeta() < 1;
        }
    });

    public CustomLog(String name, SoundType sound) {

        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(sound);
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, CustomPlank.EnumType.STRANGE).withProperty(LOG_AXIS, EnumAxis.Y));
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for(CustomPlank.EnumType customplank$enumtype : CustomPlank.EnumType.values()) {
            items.add(new ItemStack(this, 1, customplank$enumtype.getMeta()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState state = this.getDefaultState().withProperty(VARIANT, CustomPlank.EnumType.byMetadata((meta & 1) % 1));
        switch(meta & 3) {
            case 0:
                state = state.withProperty(LOG_AXIS, EnumAxis.Y);
                break;
            case 1:
                state = state.withProperty(LOG_AXIS, EnumAxis.X);
                break;
            case 2:
                state = state.withProperty(LOG_AXIS, EnumAxis.Z);
                break;
            default:
                state = state.withProperty(LOG_AXIS, EnumAxis.NONE);
        }
        return state;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | ((CustomPlank.EnumType)state.getValue(VARIANT)).getMeta();

        switch((BlockLog.EnumAxis)state.getValue(LOG_AXIS)) {
            case X:
                i |= 1;
                break;
            case Y:
                i |= 2;
                break;
            case Z:
                i |= 3;
        }
        return i;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {VARIANT, LOG_AXIS});
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
}
