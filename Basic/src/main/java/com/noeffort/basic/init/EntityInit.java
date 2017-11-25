package com.noeffort.basic.init;

import com.noeffort.basic.Basic;
import com.noeffort.basic.entity.EntityCrawler;
import com.noeffort.basic.util.Ref;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit
{
    public static void registerEntities()
    {
        registerEntity("crawler", EntityCrawler.class, Ref.ENTITY_CRAWLER, 7, 8540215, 2956808);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int colorPrimary, int colorSecondary)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(Ref.MODID + ":" + name), entity, name, id, Basic.instance, range, 1, true, colorPrimary, colorSecondary);
    }
}
