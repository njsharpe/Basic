package com.noeffort.basic.init;

import com.noeffort.basic.Basic;
import com.noeffort.basic.init.blocks.CustomBlockStairs;
import com.noeffort.basic.init.blocks.CustomGem;
import com.noeffort.basic.init.blocks.CustomLog;
import com.noeffort.basic.init.blocks.CustomOre;
import com.noeffort.basic.init.blocks.CustomPlank;
import com.noeffort.basic.init.blocks.slab.CustomBlockDoubleSlab;
import com.noeffort.basic.init.blocks.slab.CustomBlockHalfSlab;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockInit {

    public static Block strange_log;
    public static Block strange_plank;
    public static Block strange_ore;
    public static Block nether_strange_ore, end_strange_ore;
    public static Block strange_block;
    public static Block strange_plank_stairs;
    public static CustomBlockHalfSlab strange_plank_slab_half;
    public static CustomBlockDoubleSlab strange_plank_slab_double;

    public static void init() {
        strange_log = new CustomLog("strange_log", 1.0f, 2.0f, 1, SoundType.WOOD);
        strange_plank = new CustomPlank("strange_plank", 1.0f, 2.0f, 1, SoundType.WOOD);
        strange_ore = new CustomOre("strange_ore", 2.0f, 4.0f, 2, SoundType.STONE);
        strange_block = new CustomGem("strange_block", 3.2f, 5.0f, 2, SoundType.METAL);
        nether_strange_ore = new CustomOre("nether_strange_ore", 2.0f, 4.0f, 2, SoundType.STONE);
        end_strange_ore = new CustomOre("end_strange_ore", 2.5f, 4.5f, 2, SoundType.STONE);
        strange_plank_stairs = new CustomBlockStairs("strange_plank_stairs", strange_plank.getDefaultState(), SoundType.WOOD);
        strange_plank_slab_half = new CustomBlockHalfSlab("strange_plank_slab_half", 1.0f, 2.0f, SoundType.WOOD);
        strange_plank_slab_double = new CustomBlockDoubleSlab("strange_plank_slab_double", 1.0f, 2.0f, SoundType.WOOD);
    }

    public static void register() {
        registerBlock(strange_log);
        registerBlock(strange_plank);
        registerBlock(strange_ore);
        registerBlock(strange_block);
        registerBlock(nether_strange_ore);
        registerBlock(end_strange_ore);
        registerBlock(strange_plank_stairs);
        registerBlock(strange_plank_slab_half, new ItemSlab(strange_plank_slab_half, strange_plank_slab_half, strange_plank_slab_double));
        ForgeRegistries.BLOCKS.register(strange_plank_slab_double);
    }

    public static void registerBlock(Block block) {
        ForgeRegistries.BLOCKS.register(block);

        block.setCreativeTab(Basic.basictab);
        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(block.getRegistryName());
        ForgeRegistries.ITEMS.register(item);

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
                new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

    public static void registerBlock(Block block, ItemBlock itemBlock) {
        ForgeRegistries.BLOCKS.register(block);

        block.setCreativeTab(Basic.basictab);
        itemBlock.setRegistryName(block.getRegistryName());
        ForgeRegistries.ITEMS.register(itemBlock);

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
                new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

}
