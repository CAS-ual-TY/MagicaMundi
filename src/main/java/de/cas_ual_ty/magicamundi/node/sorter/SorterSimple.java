package de.cas_ual_ty.magicamundi.node.sorter;

import java.util.List;
import java.util.function.Function;

import de.cas_ual_ty.magicamundi.node.dataprovider.MMDataProvider;
import de.cas_ual_ty.magicamundi.target.Target;
import de.cas_ual_ty.visibilis.node.NodeType;

public abstract class SorterSimple extends Sorter
{
    public SorterSimple(NodeType<?> type)
    {
        super(type);
    }
    
    @Override
    public boolean sortOut(MMDataProvider data, List<Target> list1, List<Target> list2)
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
    
    public static NodeType.IFactory<SorterSimple> createSorterSimple(Function<Target, Boolean> function)
    {
        return (type) -> new SorterSimple(type)
        {
            @Override
            public boolean keep(Target target)
            {
                return function.apply(target);
            }
        };
    }
}
