package de.cas_ual_ty.magicamundi.target;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TargetBlockPos implements Target
{
    protected World world;
    protected BlockPos blockPos;
    protected Vec3d pos;
    
    public TargetBlockPos(World world, BlockPos blockPos)
    {
        this.world = world;
        this.blockPos = blockPos;
        this.pos = new Vec3d(this.getBlockPos()).add(0.5D, 0.5D, 0.5D);
    }
    
    @Override
    public World getWorld()
    {
        return this.world;
    }
    
    @Override
    public BlockPos getBlockPos()
    {
        return this.blockPos;
    }
    
    @Override
    public Vec3d getPos()
    {
        return this.pos;
    }
    
    @Override
    public boolean equals(Object target)
    {
        if(target instanceof TargetBlockPos)
        {
            return ((TargetBlockPos)target).getBlockPos().equals(this.getBlockPos());
        }
        else
        {
            return false;
        }
    }
}
