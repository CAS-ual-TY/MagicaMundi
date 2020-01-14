package de.cas_ual_ty.magicamundi.target;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class TargetEntity implements Target
{
    protected Entity entity;
    protected LivingEntity livingEntity;
    protected PlayerEntity playerEntity;
    
    public TargetEntity(Entity entity)
    {
        this.entity = entity;
        
        if(entity instanceof LivingEntity)
        {
            this.livingEntity = (LivingEntity)entity;
            
            if(entity instanceof PlayerEntity)
            {
                this.playerEntity = (PlayerEntity)entity;
            }
            else
            {
                this.playerEntity = null;
            }
        }
        else
        {
            this.livingEntity = null;
        }
    }
    
    @Override
    public BlockPos getBlockPos()
    {
        return this.getEntity().getPosition();
    }
    
    @Override
    public Vec3d getPos()
    {
        return this.getEntity().getPositionVec();
    }
    
    @Override
    public boolean equals(Object target)
    {
        if(target instanceof TargetEntity)
        {
            return ((TargetEntity)target).getEntity() == this.getEntity();
        }
        else
        {
            return false;
        }
    }
    
    public Entity getEntity()
    {
        return this.entity;
    }
    
    public LivingEntity getLivingEntity()
    {
        return this.livingEntity;
    }
    
    public PlayerEntity getPlayerEntity()
    {
        return this.playerEntity;
    }
    
    public boolean isLivingEntity()
    {
        return this.getLivingEntity() != null;
    }
    
    public boolean isPlayerEntity()
    {
        return this.getPlayerEntity() != null;
    }
}
