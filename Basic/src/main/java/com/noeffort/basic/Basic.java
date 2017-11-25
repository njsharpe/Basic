package com.noeffort.basic;

import com.noeffort.basic.proxy.CommonProxy;
import com.noeffort.basic.tabs.BasicTab;
import com.noeffort.basic.util.Ref;
import com.noeffort.basic.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Ref.MODID, name = Ref.NAME, version = Ref.VERSION)
public class Basic {

    @Instance
    public static Basic instance;

    public static final CreativeTabs basictab = new BasicTab("basictab");

    @SidedProxy(clientSide = Ref.CLIENTPROXY, serverSide = Ref.COMMONPROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) { RegistryHandler.preInitRegistries(); }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) { RegistryHandler.initRegistries(); }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) { RegistryHandler.postInitRegistries(); }

}
