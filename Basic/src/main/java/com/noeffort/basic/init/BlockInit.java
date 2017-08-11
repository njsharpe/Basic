package com.noeffort.basic.init;

import com.noeffort.basic.Basic;
import com.noeffort.basic.init.blocks.CustomGem;
import com.noeffort.basic.init.blocks.CustomOre;
import com.noeffort.basic.init.blocks.CustomPlank;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockInit {

    public static Block strange_plank;
    public static Block strange_ore;
    public static Block strange_block;

    public static void init() {
        strange_plank = new CustomPlank("strange_plank", 1.0f, 2.0f, 1, SoundType.WOOD);
        strange_ore = new CustomOre("strange_ore", 2.0f, 4.0f, 2, SoundType.STONE);
        strange_block = new CustomGem("strange_block", 3.2f, 5.0f, 2, SoundType.METAL);
    }

    public static void register() {
        registerBlock(strange_plank);
        registerBlock(strange_ore);
        registerBlock(strange_block);
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

}
