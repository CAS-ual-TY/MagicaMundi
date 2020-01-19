package de.cas_ual_ty.magicamundi.node;

import de.cas_ual_ty.magicamundi.node.dataprovider.MMDataProvider;
import de.cas_ual_ty.visibilis.node.ExecContext;
import de.cas_ual_ty.visibilis.node.Node;
import de.cas_ual_ty.visibilis.node.field.Output;

public abstract class MMNode extends Node
{
    @Override
    public boolean doCalculate(ExecContext context)
    {
        if(!(context.getData() instanceof MMDataProvider))
        {
            return false;
        }
        
        return this.doCalculate((MMDataProvider)context.getData());
    }
    
    public abstract boolean doCalculate(MMDataProvider data);
    
    @Override
    public <O> O getOutputValue(Output<O> out)
    {
        return null;
    }
    
    @Override
    public String getID()
    {
        return null;
    }
}
