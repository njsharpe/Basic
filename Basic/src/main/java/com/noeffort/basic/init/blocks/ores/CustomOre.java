package com.noeffort.basic.init.blocks.ores;

import com.noeffort.basic.util.interfaces.IMetaName;
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

public class CustomOre extends Block implements IMetaName {

    public static final PropertyEnum<CustomOre.EnumType> VARIANT =
            PropertyEnum.<CustomOre.EnumType>create("variant", CustomOre.EnumType.class);

    public CustomOre(String name, SoundType sound) {

        super(Material.ROCK);
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(sound);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumType.STRANGE));
    }

    @Override
    public int damageDropped(IBlockState state) {
        return ((CustomOre.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for(CustomOre.EnumType customore$enumtype : CustomOre.EnumType.values()) {
            items.add(new ItemStack(this, 1, customore$enumtype.getMeta()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, CustomOre.EnumType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((CustomOre.EnumType)state.getValue(VARIANT)).getMeta();
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

        STRANGE(0, "strange"),
        END_STRANGE(1, "end_strange"),
        NETHER_STRANGE(2, "nether_strange");

        private static final CustomOre.EnumType[] META_LOOKUP = new CustomOre.EnumType[values().length];
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

        public static CustomOre.EnumType byMetadata(int meta) {
            return META_LOOKUP[meta];
        }

        static {
            for(CustomOre.EnumType customore$enumtype : values()) {
                META_LOOKUP[customore$enumtype.getMeta()] = customore$enumtype;
            }
        }
    }

    @Override
    public String getSpecialName(ItemStack stack) {
        return CustomOre.EnumType.values()[stack.getItemDamage()].getName();
    }
}
