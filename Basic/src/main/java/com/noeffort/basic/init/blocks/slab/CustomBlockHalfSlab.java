package com.noeffort.basic.init.blocks.slab;

import net.minecraft.block.SoundType;

public class CustomBlockHalfSlab extends CustomBlockSlab {

    public CustomBlockHalfSlab(String name,float hardness, float resistance, SoundType sound) {
        super(name, hardness, resistance);
        setSoundType(sound);
    }

    @Override
    public boolean isDouble() {
        return false;
    }
}
