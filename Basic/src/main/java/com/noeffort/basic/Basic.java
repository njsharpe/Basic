package com.noeffort.basic;

import com.noeffort.basic.proxy.CommonProxy;
import com.noeffort.basic.tabs.BasicTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.logging.Logger;

@Mod(modid = Ref.MODID, name = Ref.NAME, version = Ref.VERSION)
public class Basic {

    @Mod.Instance
    public static Basic instance;

    public static final Logger LOGGER = Logger.getLogger(Ref.MODID);

    public static final CreativeTabs basictab = new BasicTab("basictab");

    @SidedProxy(clientSide = Ref.CLIENTPROXY, serverSide = Ref.COMMONPROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("Starting Pre-Initialization...");
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        LOGGER.info("Starting Initialization...");
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LOGGER.info("Starting Post-Initialization...");
        proxy.postInit(event);
    }

}
