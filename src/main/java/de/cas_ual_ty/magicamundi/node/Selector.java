package de.cas_ual_ty.magicamundi.node;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import de.cas_ual_ty.magicamundi.provider.MMDataProvider;
import de.cas_ual_ty.magicamundi.registries.MMDataTypes;
import de.cas_ual_ty.magicamundi.target.Target;
import de.cas_ual_ty.magicamundi.util.MMUtility;
import de.cas_ual_ty.visibilis.node.NodeType;
import de.cas_ual_ty.visibilis.node.field.Input;
import de.cas_ual_ty.visibilis.node.field.Output;
import de.cas_ual_ty.visibilis.registries.VDataTypes;
import de.cas_ual_ty.visibilis.util.VUtility;

public abstract class Selector extends MMNode
{
    public final Output<Object> out1Exec;
    public final Output<List<Target>> out2TargetsList;
    public final Input<Object> in1Exec;
    
    public final List<Target> targetsList;
    
    public Selector(NodeType<?> type)
    {
        super(type);
        this.addOutput(this.out1Exec = new Output<>(this, VDataTypes.EXEC, "out1"));
        this.addOutput(this.out2TargetsList = new Output<>(this, MMDataTypes.TARGETS_LIST, "out2"));
        this.addInput(this.in1Exec = new Input<>(this, VDataTypes.EXEC, "in1"));
        this.targetsList = MMUtility.createTargetsList();
    }
    
    @Override
    public boolean doCalculate(MMDataProvider data)
    {
        return this.findTargets(data, this.targetsList);
    }
    
    @Override
    public void resetValues()
    {
        this.targetsList.clear();
        super.resetValues();
    }
    
    /**
     * Find/select all targets and add them to the given TargetsList.
     * 
     * @param list
     *            The list to add all found/selected targets to.
     * @return <b>false</b> if there was an error and the process could not be done (example: input variable was undefined or it's value not allowed or out of range).
     */
    public abstract boolean findTargets(MMDataProvider data, List<Target> list);
    
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
    public Output<Object> getOutExec(int index)
    {
        return index == 0 ? this.out1Exec : null;
    }
    
    @Override
    public float[] getColor()
    {
        return MMDataTypes.TARGETS_LIST.getColor();
    }
    
    @Override
    public float[] getTextColor()
    {
        return MMDataTypes.TARGETS_LIST.getTextColor();
    }
    
    public static NodeType.IFactory<Selector> createTypeSelector(BiConsumer<MMDataProvider, List<Target>> function)
    {
        return Selector.createTypeSelector((data, list) ->
        {
            function.accept(data, list);
            return true;
        });
    }
    
    public static NodeType.IFactory<Selector> createTypeSelector(BiFunction<MMDataProvider, List<Target>, Boolean> function)
    {
        return (type) -> new Selector(type)
        {
            @Override
            public boolean findTargets(MMDataProvider data, List<Target> list)
            {
                return function.apply(data, list);
            }
        };
    }
}
