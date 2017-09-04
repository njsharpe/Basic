package com.noeffort.basic.util.handlers;

import com.noeffort.basic.util.gen.BasicOreGen;
import com.noeffort.basic.init.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegistryHandler {

    public static void Client() {

        RecipeHandler.registerCrafting();
        RecipeHandler.registerSmelting();
        GameRegistry.registerFuelHandler(new Fuels());

    }

    public static void Common() {

        ToolInit.init();
        ToolInit.register();

        ArmorInit.init();
        ArmorInit.register();

        ItemInit.init();
        ItemInit.register();

        BlockInit.init();
        BlockInit.register();
        BlockInit.registerRenders();

        GameRegistry.registerWorldGenerator(new BasicOreGen(), 0);

    }

}
