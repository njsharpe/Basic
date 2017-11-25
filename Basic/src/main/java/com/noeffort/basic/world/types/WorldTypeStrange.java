package com.noeffort.basic.world.types;

import com.noeffort.basic.init.BiomeInit;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;

public class WorldTypeStrange extends WorldType {

    public WorldTypeStrange()
    {
        super("Strange");
    }

    @Override
    public BiomeProvider getBiomeProvider(World world)
    {
        return new BiomeProviderSingle(BiomeInit.STRANGE);
    }
}
