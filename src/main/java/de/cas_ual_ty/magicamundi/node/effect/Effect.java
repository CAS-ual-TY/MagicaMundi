package de.cas_ual_ty.magicamundi.node.effect;

import java.util.List;

import de.cas_ual_ty.magicamundi.datatype.MMDataType;
import de.cas_ual_ty.magicamundi.target.Target;
import de.cas_ual_ty.visibilis.datatype.DataType;
import de.cas_ual_ty.visibilis.node.ExecProvider;
import de.cas_ual_ty.visibilis.node.INodeExec;
import de.cas_ual_ty.visibilis.node.Node;
import de.cas_ual_ty.visibilis.node.field.Input;
import de.cas_ual_ty.visibilis.node.field.Output;

public abstract class Effect extends Node implements INodeExec
{
    public static final float[] COLOR = new float[] { 0.047F, 0.643F, 0.431F }; // #ca46e1
    public static final float[] COLOR_TEXT = new float[] { 1F, 1F, 1F };
    
    public final Output<Object> out1Exec;
    public final Input<Object> in1Exec;
    public final Input<List<Target>> in2TargetsList;
    
    public Effect()
    {
        super();
        this.addOutput(this.out1Exec = new Output<>(this, DataType.EXEC, "out1"));
        this.addInput(this.in1Exec = new Input<>(this, DataType.EXEC, "in1"));
        this.addInput(this.in2TargetsList = new Input<>(this, MMDataType.TARGETS_LIST, "in2"));
    }
    
    @Override
    public boolean doCalculate(ExecProvider provider)
    {
        return this.applyEffect(this.in2TargetsList.getValue());
    }
    
    /**
     * Apply the effect to all given targets.
     * 
     * @param list
     *            The list of targets to apply the effect to.
     * @return <b>false</b> if there was an error and the process could not be done (example: input variable was undefined or it's value not allowed or out of range).
     */
    public abstract boolean applyEffect(List<Target> list);
    
    @Override
    public <O> O getOutputValue(Output<O> out)
    {
        return null;
    }
    
    @Override
    public Output<Object> getOutExec(int index)
    {
        return index == 0 ? this.out1Exec : null;
    }
    
    @Override
    public float[] getColor()
    {
        return Effect.COLOR;
    }
    
    @Override
    public float[] getTextColor()
    {
        return Effect.COLOR_TEXT;
    }
}
