package de.cas_ual_ty.magicamundi.node.effect;

import java.util.List;

import de.cas_ual_ty.magicamundi.provider.MMDataProvider;
import de.cas_ual_ty.magicamundi.target.Target;
import de.cas_ual_ty.magicamundi.target.TargetBlockPos;
import de.cas_ual_ty.magicamundi.target.TargetEntity;
import de.cas_ual_ty.visibilis.node.NodeType;
import de.cas_ual_ty.visibilis.node.field.Input;
import de.cas_ual_ty.visibilis.registries.VDataTypes;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;

public class EffectFire extends Effect
{
    public final Input<Integer> in3Integer;
    public final Input<Boolean> in4Boolean;
    public final Input<Boolean> in5Boolean;
    
    public EffectFire(NodeType<?> type)
    {
        super(type);
        this.addInput(this.in3Integer = new Input<>(this, VDataTypes.INTEGER, "in3"));
        this.addInput(this.in4Boolean = new Input<>(this, VDataTypes.BOOLEAN, "in4"));
        this.addInput(this.in5Boolean = new Input<>(this, VDataTypes.BOOLEAN, "in5"));
    }
    
    @Override
    public boolean applyEffect(MMDataProvider data, List<Target> list)
    {
        int time = this.in3Integer.getValue();
        boolean entityPos = this.in4Boolean.getValue();
        boolean block = this.in5Boolean.getValue();
        
        BlockPos pos;
        
        for(Target t : list)
        {
            if(time > 0 && t instanceof TargetEntity)
            {
                ((TargetEntity)t).getEntity().setFire(time);
                
                if(entityPos)
                {
                    pos = ((TargetBlockPos)t).getBlockPos();
                    if(data.getWorld().isAirBlock(pos))
                    {
                        data.getWorld().setBlockState(pos, Blocks.FIRE.getDefaultState());
                    }
                }
            }
            else if(block && t instanceof TargetBlockPos)
            {
                pos = ((TargetBlockPos)t).getBlockPos();
                if(data.getWorld().isAirBlock(pos))
                {
                    data.getWorld().setBlockState(pos, Blocks.FIRE.getDefaultState());
                }
            }
        }
        
        return true;
    }
}
