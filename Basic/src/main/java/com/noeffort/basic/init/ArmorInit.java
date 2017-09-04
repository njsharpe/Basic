package com.noeffort.basic.init;

import com.noeffort.basic.Basic;
import com.noeffort.basic.util.Ref;
import com.noeffort.basic.init.armor.CustomArmor;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ArmorInit {

    public static final ArmorMaterial basic_armor =
            EnumHelper.addArmorMaterial("basic_armor", Ref.MODID + ":basic", 12, new int[]{3, 4, 7, 3}, 27, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5F);

    public static Item strange_helmet;
    public static Item strange_chestplate;
    public static Item strange_leggings;
    public static Item strange_boots;

    public static void init() {
        strange_helmet = new CustomArmor("strange_helmet", basic_armor, 1, EntityEquipmentSlot.HEAD);
        strange_chestplate = new CustomArmor("strange_chestplate", basic_armor, 1, EntityEquipmentSlot.CHEST);
        strange_leggings = new CustomArmor("strange_leggings", basic_armor, 2, EntityEquipmentSlot.LEGS);
        strange_boots = new CustomArmor("strange_boots", basic_armor, 1, EntityEquipmentSlot.FEET);
    }

    public static void register() {
        registerItem(strange_helmet);
        registerItem(strange_chestplate);
        registerItem(strange_leggings);
        registerItem(strange_boots);
    }

    public static void registerItem(Item item) {
        ForgeRegistries.ITEMS.register(item);

        item.setCreativeTab(Basic.basictab);

        ModelLoader.setCustomModelResourceLocation(item, 0,
                new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}

