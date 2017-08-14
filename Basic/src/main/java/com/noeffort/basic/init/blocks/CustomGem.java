package com.noeffort.basic.init.blocks;

import net.minecraft.block.SoundType;

public class CustomGem extends CustomBlock {

    public CustomGem(String name, float hardness, float resistance, int harvestLevel, SoundType sound) {
        super(name, hardness, resistance);

        setHarvestLevel("pickaxe", harvestLevel);
        setSoundType(sound);
    }

}
