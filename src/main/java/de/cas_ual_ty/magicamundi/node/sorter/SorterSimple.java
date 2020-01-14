package de.cas_ual_ty.magicamundi.node.sorter;

import java.util.List;

import de.cas_ual_ty.magicamundi.target.Target;

public abstract class SorterSimple extends Sorter
{
    public SorterSimple()
    {
    }
    
    @Override
    public boolean sortOut(List<Target> list1, List<Target> list2)
    {
        for(Target t : list1)
        {
            if(!this.keep(t))
            {
                list2.add(t);
            }
        }
        
        for(Target t : list2)
        {
            list1.remove(t);
        }
        
        return true;
    }
    
    public abstract boolean keep(Target target);
}
