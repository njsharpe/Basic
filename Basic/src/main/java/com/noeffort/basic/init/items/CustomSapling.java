package com.noeffort.basic.init.items;

import com.noeffort.basic.Basic;
import net.minecraft.item.Item;

public class CustomSapling extends Item {

    public CustomSapling(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);

        setCreativeTab(Basic.basictab);
    }

}
