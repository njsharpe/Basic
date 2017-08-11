package com.noeffort.basic.init.blocks;

import net.minecraft.block.SoundType;

public class CustomPlank extends CustomWood {

    public CustomPlank(String name, float hardness, float resistance, int harvestLevel, SoundType sound) {
        super(name, hardness, resistance);

        setHarvestLevel("axe", harvestLevel);
        setSoundType(sound);
    }

}
