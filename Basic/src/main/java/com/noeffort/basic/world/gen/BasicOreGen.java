package com.noeffort.basic.world.gen;

import com.noeffort.basic.init.BlockInit;
import com.noeffort.basic.init.blocks.ores.CustomOre;
import com.sun.deploy.panel.IProperty;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

public class BasicOreGen implements IWorldGenerator {

    private WorldGenerator ore, nether, end;

    public BasicOreGen() {
        ore = new WorldGenMinable(BlockInit.ore.getDefaultState(), 5);
        nether = new WorldGenMinable(BlockInit.ore.getDefaultState().withProperty(CustomOre.VARIANT, CustomOre.EnumType.byMetadata(2)), 5, BlockMatcher.forBlock(Blocks.NETHERRACK));
        end = new WorldGenMinable(BlockInit.ore.getDefaultState().withProperty(CustomOre.VARIANT, CustomOre.EnumType.byMetadata(1)), 5, BlockMatcher.forBlock(Blocks.END_STONE));
    }

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimension()) {
            case 0:
                runGenerator(ore, world, random, chunkX, chunkZ, 35, 15, 50);
                break;

            case 1:
                runGenerator(end, world, random, chunkX, chunkZ, 25, 15, 70);
                break;

            case -1:
                runGenerator(nether, world, random, chunkX, chunkZ, 45, 0, 255);
                break;
        }
    }

    private void runGenerator(WorldGenerator gen, World world, Random random, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight) {
        if (minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore Generated [Out of Bounds]");
        int heightDifference = maxHeight - minHeight + 1;

        for(int i = 0; i < chance; i++) {
            int x = chunkX * 16 + random.nextInt(16);
            int y = minHeight + random.nextInt(heightDifference);
            int z = chunkZ * 16 + random.nextInt(16);

            gen.generate(world, random, new BlockPos(x, y, z));
        }
    }

    public static void register() {
        GameRegistry.registerWorldGenerator(new BasicOreGen(), 0);
    }

}
