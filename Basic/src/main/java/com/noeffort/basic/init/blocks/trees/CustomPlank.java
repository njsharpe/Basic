package com.noeffort.basic.init.blocks.trees;

import com.noeffort.basic.util.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class CustomPlank extends Block implements IMetaName {

    public static final PropertyEnum<CustomPlank.EnumType> VARIANT =
            PropertyEnum.<CustomPlank.EnumType>create("variant", CustomPlank.EnumType.class);

    public CustomPlank(String name, SoundType sound) {

        super(Material.WOOD);
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(sound);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumType.STRANGE));
    }

    @Override
    public int damageDropped(IBlockState state) {
        return ((CustomPlank.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for(CustomPlank.EnumType customplank$enumtype : CustomPlank.EnumType.values()) {
            items.add(new ItemStack(this, 1, customplank$enumtype.getMeta()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, CustomPlank.EnumType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((CustomPlank.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(Item.getItemFromBlock(this), 1, (int)(getMetaFromState(world.getBlockState(pos))));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

    public static enum EnumType implements IStringSerializable {

        STRANGE(0, "strange");

        private static final CustomPlank.EnumType[] META_LOOKUP = new CustomPlank.EnumType[values().length];
        private final int meta;
        private final String name, unlocalizedName;

        private EnumType(int meta, String name) {
            this(meta, name, name);
        }

        private EnumType(int meta, String name, String unlocalizedName) {
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = unlocalizedName;
        }

        @Override
        public String getName() {
            return this.name;
        }

        public int getMeta() {
            return this.meta;
        }

        public String getUnlocalizedName() {
            return this.getUnlocalizedName();
        }

        @Override
        public String toString() {
            return this.name;
        }

        public static CustomPlank.EnumType byMetadata(int meta) {
            return META_LOOKUP[meta];
        }

        static {
            for(CustomPlank.EnumType customplank$enumtype : values()) {
                META_LOOKUP[customplank$enumtype.getMeta()] = customplank$enumtype;
            }
        }
    }

    @Override
    public String getSpecialName(ItemStack stack) {
        return CustomPlank.EnumType.values()[stack.getItemDamage()].getName();
    }
}
