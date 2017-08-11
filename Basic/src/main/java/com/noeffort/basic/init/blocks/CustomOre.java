package com.noeffort.basic.init.blocks;

import net.minecraft.block.SoundType;

public class CustomOre extends CustomStone {

    public CustomOre(String name, float hardness, float resistance, int harvestLevel, SoundType sound) {
        super(name, hardness, resistance);

        setHarvestLevel("pickaxe", harvestLevel);
        setSoundType(sound);
    }

}
