package com.noeffort.basic.init.blocks;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;

public class CustomBlockStairs extends BlockStairs {

    public CustomBlockStairs(String name, IBlockState modelState, SoundType sound) {

        super(modelState);
        setUnlocalizedName(name);
        setRegistryName(name);
        this.useNeighborBrightness = true;
    }

}
