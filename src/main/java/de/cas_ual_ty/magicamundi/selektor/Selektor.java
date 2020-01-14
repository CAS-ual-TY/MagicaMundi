package de.cas_ual_ty.magicamundi.selektor;

import java.util.List;

import de.cas_ual_ty.magicamundi.datatype.MMDataType;
import de.cas_ual_ty.magicamundi.target.Target;
import de.cas_ual_ty.magicamundi.util.MMUtility;
import de.cas_ual_ty.visibilis.datatype.DataType;
import de.cas_ual_ty.visibilis.node.ExecProvider;
import de.cas_ual_ty.visibilis.node.Node;
import de.cas_ual_ty.visibilis.node.field.Input;
import de.cas_ual_ty.visibilis.node.field.Output;
import de.cas_ual_ty.visibilis.util.VUtility;

public abstract class Selektor extends Node
{
    public final Output<Object> out1Exec;
    public final Output<List<Target>> out2TargetsList;
    public final Input<Object> in1Exec;
    
    public final List<Target> targetsList;
    
    public Selektor()
    {
        super();
        this.addOutput(this.out1Exec = new Output<>(this, DataType.EXEC, "out1"));
        this.addOutput(this.out2TargetsList = new Output<>(this, MMDataType.TARGETS_LIST, "out2"));
        this.addInput(this.in1Exec = new Input<>(this, DataType.EXEC, "in1"));
        this.targetsList = MMUtility.createTargetsList();
    }
    
    @Override
    public boolean doCalculate(ExecProvider provider)
    {
        this.targetsList.clear();
        return this.findTargets(this.targetsList);
    }
    
    /**
     * Find/select all targets and add them to the given TargetsList.
     * 
     * @param list
     *            The list to add all found/selected targets to.
     * @return <b>false</b> if there was an error and the process could not be done (example: input variable was undefined or it's value not allowed or out of range).
     */
    public abstract boolean findTargets(List<Target> list);
    
    @Override
    public <O> O getOutputValue(Output<O> out)
    {
        if(out == this.out2TargetsList)
        {
            return VUtility.cast(this.targetsList);
        }
        
        return null;
    }
    
    @Override
    public float[] getColor()
    {
        return MMDataType.TARGETS_LIST.getColor();
    }
    
    @Override
    public float[] getTextColor()
    {
        return MMDataType.TARGETS_LIST.getTextColor();
    }
}
