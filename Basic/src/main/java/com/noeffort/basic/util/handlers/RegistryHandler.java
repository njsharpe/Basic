package com.noeffort.basic.util.handlers;

import com.noeffort.basic.init.*;
import com.noeffort.basic.util.interfaces.IHasModel;
import com.noeffort.basic.world.WorldGenCustomOres;
import com.noeffort.basic.world.WorldGenCustomTrees;
import com.noeffort.basic.world.types.WorldTypeCustom;
import com.noeffort.basic.world.types.WorldTypeStrange;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event)
    {
        for(Item item : ItemInit.ITEMS)
        {
            if(item instanceof IHasModel)
            {
                ((IHasModel)item).registerModels();
            }
        }
        for (Block block : BlockInit.BLOCKS)
        {
            if(block instanceof IHasModel)
            {
                ((IHasModel)block).registerModels();
            }
        }
    }

    public static void preInitRegistries()
    {
        GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenCustomTrees(), 0);

        BiomeInit.registerBiomes();

        EntityInit.registerEntities();
        RenderHandler.registerEntityRenders();
    }

    public static void initRegistries()
    {
        MapColorHandler.registerColorHandlers();
    }

    public static void postInitRegistries()
    {
        WorldType STRANGE = new WorldTypeStrange();
        WorldType CUSTOM = new WorldTypeCustom();
    }
}
