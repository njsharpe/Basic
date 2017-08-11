package com.noeffort.basic.handlers;

import com.noeffort.basic.init.ArmorInit;
import com.noeffort.basic.init.BlockInit;
import com.noeffort.basic.init.ItemInit;
import com.noeffort.basic.init.ToolInit;

public class RegistryHandler {

    public static void Client() {

        RecipeHandler.registerCrafting();
        RecipeHandler.registerSmelting();

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
    }

}
