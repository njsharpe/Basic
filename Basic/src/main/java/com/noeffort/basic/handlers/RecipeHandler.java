package com.noeffort.basic.handlers;

import com.noeffort.basic.init.ArmorInit;
import com.noeffort.basic.init.BlockInit;
import com.noeffort.basic.init.ItemInit;
import com.noeffort.basic.init.ToolInit;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {

    public static void registerCrafting() {
        GameRegistry.addShapedRecipe(new ResourceLocation("basic:strange_block"), new ResourceLocation("basic:basic_blocks"),
                new ItemStack(BlockInit.strange_block), new Object[]{"III", "III", "III", 'I', ItemInit.strange_ingot});
        GameRegistry.addShapelessRecipe(new ResourceLocation("basic:strange_ingot"), new ResourceLocation("basic:basic_items"),
                new ItemStack(ItemInit.strange_ingot, 9), new Ingredient[]{Ingredient.fromItem(Item.getItemFromBlock(BlockInit.strange_block))});
        registerArmorCrafting(ArmorInit.strange_helmet, ArmorInit.strange_chestplate, ArmorInit.strange_leggings, ArmorInit.strange_boots, ItemInit.strange_ingot);
        registerToolCrafting(ToolInit.strange_sword, ToolInit.strange_pickaxe, ToolInit.strange_axe, ToolInit.strange_shovel, ToolInit.strange_hoe, ItemInit.strange_ingot);
    }

    public static void registerSmelting() {
        GameRegistry.addSmelting(BlockInit.strange_ore, new ItemStack(ItemInit.strange_ingot), 10);
        GameRegistry.addSmelting(BlockInit.planks, new ItemStack(ItemInit.strange_charcoal), 7);
    }

    private static void registerToolCrafting(Item sword, Item pickaxe, Item axe, Item shovel, Item hoe, Item ingot) {
        GameRegistry.addShapedRecipe(new ResourceLocation("" + sword.getRegistryName()), new ResourceLocation("basic:basic_tools"),
                new ItemStack(sword), new Object[]{" I ", " I ", " S ", 'S', Items.STICK, 'I', ItemInit.strange_ingot});
        GameRegistry.addShapedRecipe(new ResourceLocation("" + pickaxe.getRegistryName()), new ResourceLocation("basic:basic_tools"),
                new ItemStack(pickaxe), new Object[]{"III", " S ", " S ", 'S', Items.STICK, 'I', ItemInit.strange_ingot});
        GameRegistry.addShapedRecipe(new ResourceLocation("" + axe.getRegistryName()), new ResourceLocation("basic:basic_tools"),
                new ItemStack(axe), new Object[]{"II ", "IS ", " S ", 'S', Items.STICK, 'I', ItemInit.strange_ingot});
        GameRegistry.addShapedRecipe(new ResourceLocation("" + shovel.getRegistryName()), new ResourceLocation("basic:basic_tools"),
                new ItemStack(shovel), new Object[]{" I ", " S ", " S ", 'S', Items.STICK, 'I', ItemInit.strange_ingot});
        GameRegistry.addShapedRecipe(new ResourceLocation("" + hoe.getRegistryName()), new ResourceLocation("basic:basic_tools"),
                new ItemStack(hoe), new Object[]{"II ", " S ", " S ", 'S', Items.STICK, 'I', ItemInit.strange_ingot});
    }

    private static void registerArmorCrafting(Item helmet, Item chestplate, Item leggings, Item boots, Item ingot) {
        GameRegistry.addShapedRecipe(new ResourceLocation("" + helmet.getRegistryName()), new ResourceLocation("basic:basic_armor"),
                new ItemStack(ArmorInit.strange_helmet), new Object[]{"III", "I I", "   ", 'I', ItemInit.strange_ingot});
        GameRegistry.addShapedRecipe(new ResourceLocation("" + chestplate.getRegistryName()), new ResourceLocation("basic:basic_armor"),
                new ItemStack(ArmorInit.strange_chestplate), new Object[]{"I I", "III", "III", 'I', ItemInit.strange_ingot});
        GameRegistry.addShapedRecipe(new ResourceLocation("" + leggings.getRegistryName()), new ResourceLocation("basic:basic_armor"),
                new ItemStack(ArmorInit.strange_leggings), new Object[]{"III", "I I", "I I", 'I', ItemInit.strange_ingot});
        GameRegistry.addShapedRecipe(new ResourceLocation("" + boots.getRegistryName()), new ResourceLocation("basic:basic_armor"),
                new ItemStack(ArmorInit.strange_boots), new Object[]{"   ", "I I", "I I", 'I', ItemInit.strange_ingot});
    }

}
