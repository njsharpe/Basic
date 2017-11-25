package com.noeffort.basic.init;

import com.noeffort.basic.objects.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block BLOCK_STRANGE = new BlockBase("block_strange", Material.IRON, SoundType.METAL);

    public static final Block PLANKS = new BlockPlank("planks");
    public static final Block LOG = new BlockLogs("log");
    public static final Block LEAVES = new BlockLeaf("leaves");
    public static final Block SAPLING = new BlockSaplings("sapling");
    public static final Block GRASSES = new BlockGrasses("grass");

    public static final Block ORE_END = new BlockOres("ore_end", "end");
    public static final Block ORE_OVERWORLD = new BlockOres("ore_overworld", "overworld");
    public static final Block ORE_NETHER = new BlockOres("ore_nether", "nether");
}
