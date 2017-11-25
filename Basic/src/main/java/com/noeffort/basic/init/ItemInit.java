package com.noeffort.basic.init;

import com.noeffort.basic.objects.armor.ArmorBase;
import com.noeffort.basic.objects.items.ItemBase;
import com.noeffort.basic.objects.tools.ToolAxe;
import com.noeffort.basic.objects.tools.ToolHoe;
import com.noeffort.basic.objects.tools.ToolPickaxe;
import com.noeffort.basic.objects.tools.ToolShovel;
import com.noeffort.basic.objects.tools.ToolSword;
import com.noeffort.basic.util.Ref;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemInit
{
    public static final List<Item> ITEMS = new ArrayList<Item>();

    //MATERIALS
    public static final ToolMaterial TOOL_STRANGE = EnumHelper.addToolMaterial("tool_strange", 2, 175, 5.0F, 1.3F, 11);
    public static final ArmorMaterial ARMOR_STRANGE = EnumHelper.addArmorMaterial("armor_strange", Ref.MODID + ":strange", 15, new int[]{3, 6, 4, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 1.0F);

    //ITEMS
    public static final Item INGOT_STRANGE = new ItemBase("ingot_strange");
    public static final Item CHARCOAL_STRANGE = new ItemBase("charcoal_strange");

    //TOOLS
    public static final Item AXE_STRANGE = new ToolAxe("axe_strange", TOOL_STRANGE);
    public static final Item HOE_STRANGE = new ToolHoe("hoe_strange", TOOL_STRANGE);
    public static final Item PICKAXE_STRANGE = new ToolPickaxe("pickaxe_strange", TOOL_STRANGE);
    public static final Item SHOVEL_STRANGE = new ToolShovel("shovel_strange", TOOL_STRANGE);
    public static final Item SWORD_STRANGE = new ToolSword("sword_strange", TOOL_STRANGE);

    //ARMOR
    public static final Item HELMET_STRANGE = new ArmorBase("helmet_strange", ARMOR_STRANGE, 1, EntityEquipmentSlot.HEAD);
    public static final Item CHESTPLATE_STRANGE = new ArmorBase("chestplate_strange", ARMOR_STRANGE, 1, EntityEquipmentSlot.CHEST);
    public static final Item LEGGINGS_STRANGE = new ArmorBase("leggings_strange", ARMOR_STRANGE, 1, EntityEquipmentSlot.LEGS);
    public static final Item BOOTS_STRANGE = new ArmorBase("boots_strange", ARMOR_STRANGE, 1, EntityEquipmentSlot.FEET);

}

