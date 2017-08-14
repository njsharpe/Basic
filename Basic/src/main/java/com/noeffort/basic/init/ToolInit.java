package com.noeffort.basic.init;

import com.noeffort.basic.Basic;
import com.noeffort.basic.init.tools.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ToolInit {

    public static final ToolMaterial basic_tools =
            EnumHelper.addToolMaterial("basic", 2, 200, 5.0F, 1.75F, 24);
    public static final ToolMaterial op_tools =
            EnumHelper.addToolMaterial("op", 10, 2147483647, 9001.0f, 9001.0f, 22);

    public static Item strange_sword;
    public static Item strange_pickaxe;
    public static Item strange_axe;
    public static Item strange_shovel;
    public static Item strange_hoe;

    public static Item quasar_sword;
    public static Item quasar_pickaxe;

    public static void init() {
        strange_sword = new CustomSword("strange_sword", basic_tools);
        strange_pickaxe = new CustomPickaxe("strange_pickaxe", basic_tools);
        strange_axe = new CustomAxe("strange_axe", basic_tools);
        strange_shovel = new CustomShovel("strange_shovel", basic_tools);
        strange_hoe = new CustomHoe("strange_hoe", basic_tools);

        quasar_sword = new CustomSword("quasar_sword", op_tools);
        quasar_pickaxe = new CustomPickaxe("quasar_pickaxe", op_tools);
    }

    public static void register() {
        registerItem(strange_sword);
        registerItem(strange_pickaxe);
        registerItem(strange_axe);
        registerItem(strange_shovel);
        registerItem(strange_hoe);

        registerItem(quasar_sword);
        registerItem(quasar_pickaxe);
    }

    public static void registerItem(Item item) {
        ForgeRegistries.ITEMS.register(item);

        item.setCreativeTab(Basic.basictab);

        ModelLoader.setCustomModelResourceLocation(item, 0,
                new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }


}
