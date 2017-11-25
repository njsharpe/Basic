package com.noeffort.basic.util.handlers;

import com.noeffort.basic.entity.EntityCrawler;
import com.noeffort.basic.entity.render.RenderCrawler;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler
{
    public static void registerEntityRenders()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityCrawler.class, new IRenderFactory<EntityCrawler>()
        {
            @Override
            public Render<? super EntityCrawler> createRenderFor(RenderManager manager) {
                return new RenderCrawler(manager);
            }
        });
    }
}
