package com.noeffort.basic.init;

import com.noeffort.basic.Basic;
import com.noeffort.basic.util.Ref;
import com.noeffort.basic.init.blocks.*;
import com.noeffort.basic.init.blocks.item.ItemBlockVariants;
import com.noeffort.basic.init.blocks.ores.CustomOre;
import com.noeffort.basic.init.blocks.slab.CustomBlockDoubleSlab;
import com.noeffort.basic.init.blocks.slab.CustomBlockHalfSlab;
import com.noeffort.basic.init.blocks.trees.CustomLeaves;
import com.noeffort.basic.init.blocks.trees.CustomLog;
import com.noeffort.basic.init.blocks.trees.CustomPlank;
import com.noeffort.basic.init.blocks.trees.CustomSapling;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockInit {

    public static Block strange_block;
    public static Block strange_plank_stairs;
    public static CustomBlockHalfSlab strange_plank_slab_half;
    public static CustomBlockDoubleSlab strange_plank_slab_double;

    public static Block planks, log, leaves, sapling;
    public static Block ore;

    public static void init() {

        planks = new CustomPlank("planks", SoundType.WOOD);
        log = new CustomLog("log", SoundType.WOOD);
        leaves = new CustomLeaves("leaves", SoundType.PLANT);
        sapling = new CustomSapling("sapling", SoundType.PLANT);
        ore = new CustomOre("ore", SoundType.STONE);

        strange_block = new CustomGem("strange_block", 3.2f, 5.0f,  SoundType.METAL);
        strange_plank_stairs = new CustomBlockStairs("strange_plank_stairs", planks.getDefaultState(), SoundType.WOOD);
        strange_plank_slab_half = new CustomBlockHalfSlab("strange_plank_slab_half", 1.0f, 2.0f, SoundType.WOOD);
        strange_plank_slab_double = new CustomBlockDoubleSlab("strange_plank_slab_double", 1.0f, 2.0f, SoundType.WOOD);
    }

    public static void register() {
        registerBlock(strange_block);
        registerBlock(strange_plank_stairs);

        registerBlock(strange_plank_slab_half, new ItemSlab(strange_plank_slab_half, strange_plank_slab_half, strange_plank_slab_double));
        ForgeRegistries.BLOCKS.register(strange_plank_slab_double);

        registerBlockWithVariants(planks, new ItemBlockVariants(planks));
        registerBlockWithVariants(log, new ItemBlockVariants(log));
        registerBlockWithVariants(leaves, new ItemBlockVariants(leaves));
        registerBlockWithVariants(sapling, new ItemBlockVariants(sapling));
        registerBlockWithVariants(ore, new ItemBlockVariants(ore));

    }

    public static void registerRenders() {
        for(int i = 0; i < CustomPlank.EnumType.values().length; i++) {
            registerRender(planks, i, "planks_" + CustomPlank.EnumType.values()[i].getName());
            registerRender(log, i, "log_" + CustomPlank.EnumType.values()[i].getName());
            registerRender(leaves, i, "leaves_" + CustomPlank.EnumType.values()[i].getName());
            registerRender(sapling, i, "sapling_" + CustomPlank.EnumType.values()[i].getName());
        }

        for(int i = 0; i < CustomOre.EnumType.values().length; i++) {
            registerRender(ore, i, "ore_" + CustomOre.EnumType.values()[i].getName());
        }
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

    public static void registerBlockWithVariants(Block block, ItemBlock itemBlock) {
        ForgeRegistries.BLOCKS.register(block);

        block.setCreativeTab(Basic.basictab);
        itemBlock.setRegistryName(block.getRegistryName());
        ForgeRegistries.ITEMS.register(itemBlock);

    }

    public static void registerRender(Block block, int meta, String fileName) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                new ModelResourceLocation(new ResourceLocation(Ref.MODID, fileName), "inventory"));
    }

}
