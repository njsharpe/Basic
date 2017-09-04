package com.noeffort.basic.proxy;

import com.noeffort.basic.util.handlers.RegistryHandler;
import net.minecraftforge.fml.common.event.*;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        RegistryHandler.Common();
    }
    public void init(FMLInitializationEvent event) {}
    public void postInit(FMLPostInitializationEvent event) {}

}
