package com.noeffort.basic.entity;

import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityCrawler extends EntityEndermite
{
    public EntityCrawler(World worldIn)
    {
        super(worldIn);
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return super.getAmbientSound();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return super.getHurtSound(source);
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return super.getDeathSound();
    }
}
