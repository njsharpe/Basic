package com.noeffort.basic.entity.render;

import com.noeffort.basic.entity.EntityCrawler;
import com.noeffort.basic.entity.model.ModelCrawler;
import com.noeffort.basic.util.Ref;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCrawler extends RenderLiving<EntityCrawler>
{
    public static final ResourceLocation TEXTURES = new ResourceLocation(Ref.MODID + ":textures/entity/crawler.png");

    public RenderCrawler(RenderManager manager)
    {
        super(manager, new ModelCrawler(), 0.5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCrawler entity) {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityCrawler entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
