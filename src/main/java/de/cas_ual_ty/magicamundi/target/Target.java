package de.cas_ual_ty.magicamundi.target;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public interface Target
{
    public abstract BlockPos getBlockPos();
    
    public abstract Vec3d getPos();
    
    @Override
    public abstract boolean equals(Object o);
}
