package de.cas_ual_ty.magicamundi.node.other;

import java.util.List;

import de.cas_ual_ty.magicamundi.registries.MMDataTypes;
import de.cas_ual_ty.magicamundi.target.Target;
import de.cas_ual_ty.visibilis.node.ExecContext;
import de.cas_ual_ty.visibilis.node.Node;
import de.cas_ual_ty.visibilis.node.NodeType;
import de.cas_ual_ty.visibilis.node.field.Input;
import de.cas_ual_ty.visibilis.node.field.Output;
import de.cas_ual_ty.visibilis.registries.VDataTypes;
import de.cas_ual_ty.visibilis.util.VUtility;

public class NodeIterateTargetsList extends Node
{
    public final Output<Object> out1Exec;
    public final Output<Integer> out2Index;
    public final Output<Target> out3Target;
    public final Output<Object> out4Exec;
    public final Input<Object> in1Exec;
    public final Input<List<Target>> in2TargetsList;
    
    public int index;
    public Target value;
    
    public List<Target> targets_list;
    
    public NodeIterateTargetsList(NodeType<?> type)
    {
        super(type);
        this.addOutput(this.out1Exec = new Output<>(this, VDataTypes.EXEC, "out1").setTriggerRecalculation());
        this.addOutput(this.out2Index = new Output<>(this, VDataTypes.INTEGER, "out2").setTriggerRecalculation());
        this.addOutput(this.out3Target = new Output<>(this, MMDataTypes.TARGET, "out3").setTriggerRecalculation());
        this.addOutput(this.out4Exec = new Output<>(this, VDataTypes.EXEC, "out4"));
        this.addInput(this.in1Exec = new Input<>(this, VDataTypes.EXEC, "in1"));
        this.addInput(this.in2TargetsList = new Input<>(this, MMDataTypes.TARGETS_LIST, "in2"));
    }
    
    @Override
    public Output<Object> getOutExec(int index)
    {
        this.index = index;
        
        if(this.index < this.targets_list.size())
        {
            this.value = this.targets_list.get(this.index);
            return this.out1Exec;
        }
        
        return index == this.targets_list.size() ? this.out4Exec : null;
    }
    
    @Override
    public boolean doCalculate(ExecContext context)
    {
        this.targets_list = this.in2TargetsList.getValue();
        return true;
    }
    
    @Override
    public <O> O getOutputValue(Output<O> out)
    {
        return out == this.out2Index ? VUtility.cast(this.index) : (out == this.out3Target ? VUtility.cast(this.value) : null);
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
