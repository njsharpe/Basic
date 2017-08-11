package com.noeffort.basic.init.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CustomStone extends Block{

    public CustomStone(String name, float hardness, float resistance) {
        super(Material.ROCK);

        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        setResistance(resistance);
    }
}
