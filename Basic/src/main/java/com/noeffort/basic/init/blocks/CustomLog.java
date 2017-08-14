package com.noeffort.basic.init.blocks;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;

public class CustomLog extends BlockRotatedPillar {

    public CustomLog(String name, float hardness, float resistance, int harvestLevel, SoundType sound) {

        super(Material.WOOD);
        setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.Y));
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel("axe", harvestLevel);
        setSoundType(sound);
    }

}
