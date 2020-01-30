package de.cas_ual_ty.magicamundi.util;

import java.util.function.BiFunction;

import de.cas_ual_ty.magicamundi.provider.MMDataProvider;
import de.cas_ual_ty.magicamundi.target.Target;
import de.cas_ual_ty.magicamundi.target.TargetBlockPos;
import de.cas_ual_ty.magicamundi.target.TargetEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;

public class MMTargetHelper
{
    public static class TargetFunction implements BiFunction<MMDataProvider, Target, Boolean>
    {
        private final BiFunction<MMDataProvider, BlockPos, Boolean> functionBlock;
        private final BiFunction<MMDataProvider, Entity, Boolean> functionEntity;
        
        public TargetFunction(BiFunction<MMDataProvider, BlockPos, Boolean> functionBlock, BiFunction<MMDataProvider, Entity, Boolean> functionEntity)
        {
            this.functionBlock = functionBlock;
            this.functionEntity = functionEntity;
        }
        
        @Override
        public Boolean apply(MMDataProvider data, Target target)
        {
            if(target instanceof TargetBlockPos)
            {
                return this.functionBlock.apply(data, ((TargetBlockPos)target).getBlockPos());
            }
            else if(target instanceof TargetEntity)
            {
                return this.functionEntity.apply(data, ((TargetEntity)target).getEntity());
            }
            
            return true;
        }
    }
}
