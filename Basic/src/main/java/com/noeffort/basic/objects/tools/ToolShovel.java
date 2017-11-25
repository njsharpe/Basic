package com.noeffort.basic.objects.tools;

import com.noeffort.basic.Basic;
import com.noeffort.basic.init.ItemInit;
import com.noeffort.basic.util.interfaces.IHasModel;
import net.minecraft.item.ItemSpade;

public class ToolShovel extends ItemSpade implements IHasModel
{
    public ToolShovel(String name, ToolMaterial material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Basic.basictab);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Basic.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
