package com.noeffort.basic.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelEnderMite - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelCrawler extends ModelBase {
    public ModelRenderer tail_middle;
    public ModelRenderer tail_end;
    public ModelRenderer head;
    public ModelRenderer body;

    public ModelCrawler() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.body = new ModelRenderer(this, 0, 5);
        this.body.setRotationPoint(0.14F, 20.0F, 0.0F);
        this.body.addBox(-3.0F, 0.0F, -2.5F, 6, 4, 5, 0.0F);
        this.setRotateAngle(body, 0.0F, 0.056025068989017976F, 0.0F);
        this.tail_middle = new ModelRenderer(this, 0, 14);
        this.tail_middle.setRotationPoint(0.0F, 21.0F, 3.0F);
        this.tail_middle.addBox(-1.5F, 0.0F, -0.5F, 3, 3, 1, 0.0F);
        this.setRotateAngle(tail_middle, 0.0F, 0.018500490071139894F, 0.0F);
        this.tail_end = new ModelRenderer(this, 0, 18);
        this.tail_end.setRotationPoint(0.31F, 22.0F, 4.0F);
        this.tail_end.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(tail_end, 0.0F, 0.009773843811168246F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 21.0F, -3.5F);
        this.head.addBox(-2.0F, 0.0F, -1.0F, 4, 3, 2, 0.0F);
        this.setRotateAngle(head, 0.0F, 0.0942477796076938F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body.render(f5);
        this.tail_middle.render(f5);
        this.tail_end.render(f5);
        this.head.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
