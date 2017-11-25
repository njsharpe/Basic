package com.noeffort.basic.objects.blocks;

import com.noeffort.basic.Basic;
import com.noeffort.basic.init.BlockInit;
import com.noeffort.basic.init.ItemInit;
import com.noeffort.basic.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel
{
    public BlockBase(String name, Material material, SoundType sound)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Basic.basictab);
        setSoundType(sound);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Basic.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
