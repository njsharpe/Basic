package com.noeffort.basic.init;


import com.noeffort.basic.init.items.CustomCharcoal;
import com.noeffort.basic.init.items.CustomIngot;
import com.noeffort.basic.init.items.CustomSapling;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemInit {

    public static Item strange_sapling;
    public static Item strange_charcoal;
    public static Item strange_ingot;

    public static void init() {
        strange_sapling = new CustomSapling("strange_sapling");
        strange_charcoal = new CustomCharcoal("strange_charcoal");
        strange_ingot = new CustomIngot("strange_ingot");
    }

    public static void register() {
        registerItem(strange_sapling);
        registerItem(strange_charcoal);
        registerItem(strange_ingot);
    }

    public static void registerItem(Item item) {
        ForgeRegistries.ITEMS.register(item);

        ModelLoader.setCustomModelResourceLocation(item, 0,
                new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
