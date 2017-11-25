package com.noeffort.basic.world.biome;

import com.noeffort.basic.init.BlockInit;
import com.noeffort.basic.objects.blocks.BlockGrasses;
import com.noeffort.basic.util.handlers.EnumHandler;
import com.noeffort.basic.world.gen.WorldGenStrangeTree;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeStrange extends Biome
{

    protected static final WorldGenAbstractTree TREE = new WorldGenStrangeTree();

    public BiomeStrange()
    {
        super(new BiomeProperties("Strange").setBaseHeight(0.2F).setHeightVariation(0.4F).setTemperature(0.95F).setRainfall(0.8F).setWaterColor(0x00FFC3));

        topBlock = BlockInit.GRASSES.getDefaultState().withProperty(BlockGrasses.VARIANT, EnumHandler.EnumType.STRANGE);
        fillerBlock = Blocks.DIRT.getDefaultState();

        this.decorator.treesPerChunk = 2;
        this.decorator.grassPerChunk = 20;
        this.decorator.flowersPerChunk = 1;

        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return TREE;
    }

    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0x6CC449;
    }

    @Override
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0x6CC449;
    }
}
