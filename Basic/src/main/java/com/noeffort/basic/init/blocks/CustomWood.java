package com.noeffort.basic.init.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CustomWood extends Block {

    public CustomWood(String name, float hardness, float resistance) {
        super(Material.WOOD);

        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        setResistance(resistance);
    }
}
