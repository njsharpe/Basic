package com.noeffort.basic.objects.items;

import com.noeffort.basic.Basic;
import com.noeffort.basic.init.ItemInit;
import com.noeffort.basic.util.interfaces.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{
    public ItemBase(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Basic.basictab);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Basic.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
