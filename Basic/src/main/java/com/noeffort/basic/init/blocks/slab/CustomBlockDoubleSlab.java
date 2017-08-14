package com.noeffort.basic.init.blocks.slab;

import net.minecraft.block.SoundType;

public class CustomBlockDoubleSlab extends CustomBlockSlab {

    public CustomBlockDoubleSlab(String name, float hardness, float resistance, SoundType sound) {
        super(name, hardness, resistance);
        setSoundType(sound);
    }

    @Override
    public boolean isDouble() {
        return true;
    }
}
