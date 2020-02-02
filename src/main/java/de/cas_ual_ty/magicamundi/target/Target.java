package de.cas_ual_ty.magicamundi.target;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public interface Target
{
    public abstract World getWorld();
    public abstract BlockPos getBlockPos();
    public abstract Vec3d getPos();
    
    @Override
    public abstract boolean equals(Object o);
}
