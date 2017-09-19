package com.noeffort.basic.util.handlers;

import com.noeffort.basic.init.*;
import com.noeffort.basic.world.gen.BasicOreGen;
import com.noeffort.basic.world.gen.StrangeTreeGen;
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

        BasicOreGen.register();
        StrangeTreeGen.register();

    }

}
