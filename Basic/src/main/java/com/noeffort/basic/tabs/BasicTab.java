package com.noeffort.basic.tabs;

import com.noeffort.basic.init.BlockInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import com.noeffort.basic.init.ItemInit;

public class BasicTab extends CreativeTabs {

    public BasicTab(String label) {
        super("basictab");
        this.setBackgroundImageName("basic.png");
    }

    public ItemStack getTabIconItem() {
        return new ItemStack(BlockInit.sapling);
    }


}
