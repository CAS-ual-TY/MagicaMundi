package de.cas_ual_ty.magicamundi.node.sorter;

import java.util.List;

import de.cas_ual_ty.magicamundi.node.MMNode;
import de.cas_ual_ty.magicamundi.node.dataprovider.MMDataProvider;
import de.cas_ual_ty.magicamundi.registries.MMDataTypes;
import de.cas_ual_ty.magicamundi.target.Target;
import de.cas_ual_ty.magicamundi.util.MMUtility;
import de.cas_ual_ty.visibilis.node.INodeExec;
import de.cas_ual_ty.visibilis.node.field.Input;
import de.cas_ual_ty.visibilis.node.field.Output;
import de.cas_ual_ty.visibilis.registries.VDataTypes;
import de.cas_ual_ty.visibilis.util.VUtility;

public abstract class Sorter extends MMNode implements INodeExec
{
    public static final float[] COLOR = new float[] { 0.016F, 0.235F, 0.961F }; // #43cf56
    public static final float[] COLOR_TEXT = new float[] { 1F, 1F, 1F };
    
    public final Output<Object> out1Exec;
    public final Output<List<Target>> out2TargetsList;
    public final Output<List<Target>> out3TargetsList;
    public final Input<Object> in1Exec;
    public final Input<List<Target>> in2TargetsList;
    
    public List<Target> targetsList1;
    public final List<Target> targetsList2;
    
    public Sorter()
    {
        super();
        this.addOutput(this.out1Exec = new Output<>(this, VDataTypes.EXEC, "out1"));
        this.addOutput(this.out2TargetsList = new Output<>(this, MMDataTypes.TARGETS_LIST, "out2"));
        this.addOutput(this.out3TargetsList = new Output<>(this, MMDataTypes.TARGETS_LIST, "out3"));
        this.addInput(this.in1Exec = new Input<>(this, VDataTypes.EXEC, "in1"));
        this.addInput(this.in2TargetsList = new Input<>(this, MMDataTypes.TARGETS_LIST, "in2"));
        this.targetsList2 = MMUtility.createTargetsList();
    }
    
    @Override
    public boolean doCalculate(MMDataProvider data)
    {
        this.targetsList2.clear();
        this.targetsList1 = MMUtility.cloneTargetsList(this.in2TargetsList.getValue());
        return this.sortOut(data, this.targetsList1, this.targetsList2);
    }
    
    /**
     * Sort out the targets from one list and add them to the other.
     * 
     * @param list1
     *            The List<Target> instance containing all Target instances to remove false targets from.
     * @param list2
     *            The List<Target> instance to add all removed targets to.
     * @return <b>false</b> if there was an error and the process could not be done (example: input variable was undefined or it's value not allowed or out of range).
     */
    public abstract boolean sortOut(MMDataProvider data, List<Target> list1, List<Target> list2);
    
    @Override
    public <O> O getOutputValue(Output<O> out)
    {
        if(out == this.out2TargetsList)
        {
            return VUtility.cast(this.targetsList1);
        }
        else if(out == this.out3TargetsList)
        {
            return VUtility.cast(this.targetsList2);
        }
        
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
        return Sorter.COLOR;
    }
    
    @Override
    public float[] getTextColor()
    {
        return Sorter.COLOR_TEXT;
    }
}
