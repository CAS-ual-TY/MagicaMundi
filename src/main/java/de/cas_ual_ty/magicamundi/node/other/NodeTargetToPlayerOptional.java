package de.cas_ual_ty.magicamundi.node.other;

import de.cas_ual_ty.magicamundi.registries.MMDataTypes;
import de.cas_ual_ty.magicamundi.target.Target;
import de.cas_ual_ty.magicamundi.target.TargetEntity;
import de.cas_ual_ty.visibilis.node.ExecContext;
import de.cas_ual_ty.visibilis.node.Node;
import de.cas_ual_ty.visibilis.node.NodeType;
import de.cas_ual_ty.visibilis.node.field.Input;
import de.cas_ual_ty.visibilis.node.field.Output;
import de.cas_ual_ty.visibilis.registries.VDataTypes;
import de.cas_ual_ty.visibilis.util.VUtility;
import net.minecraft.entity.player.PlayerEntity;

public class NodeTargetToPlayerOptional extends Node
{
    public final Output<Object> out1Exec;
    public final Output<PlayerEntity> out2Player;
    public final Output<Object> out3Exec;
    public final Input<Target> in2Target;
    
    protected PlayerEntity value;
    
    public NodeTargetToPlayerOptional(NodeType<?> type)
    {
        super(type);
        this.addOutput(this.out1Exec = new Output<>(this, VDataTypes.EXEC, "out1"));
        this.addOutput(this.out2Player = new Output<>(this, VDataTypes.PLAYER, "out2"));
        this.addOutput(this.out3Exec = new Output<>(this, VDataTypes.EXEC, "out3"));
        this.addInput(this.in2Target = new Input<>(this, MMDataTypes.TARGET, "in2"));
    }
    
    @Override
    public boolean doCalculate(ExecContext context)
    {
        Target t = this.in2Target.getValue();
        this.value = null;
        
        if(t instanceof TargetEntity)
        {
            TargetEntity t1 = (TargetEntity)t;
            if(t1.isPlayerEntity())
            {
                this.value = t1.getPlayerEntity();
            }
        }
        
        return true;
    }
    
    @Override
    public <O> O getOutputValue(Output<O> out)
    {
        return out == this.out2Player ? VUtility.cast(this.value) : null;
    }
    
    @Override
    public Output<Object> getOutExec(int index)
    {
        return index == 0 ? (this.value == null ? this.out3Exec : this.out1Exec) : null;
    }
    
    @Override
    public float[] getColor()
    {
        return MMDataTypes.TARGET.getColor();
    }
    
    @Override
    public float[] getTextColor()
    {
        return MMDataTypes.TARGET.getTextColor();
    }
}
