package de.cas_ual_ty.magicamundi.node;

import java.util.List;
import java.util.function.BiFunction;

import de.cas_ual_ty.magicamundi.provider.MMDataProvider;
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
            if(!this.keep(data, t))
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
    
    public abstract boolean keep(MMDataProvider data, Target target);
    
    public static NodeType.IFactory<SorterSimple> createSorterSimple(BiFunction<MMDataProvider, Target, Boolean> function)
    {
        return (type) -> new SorterSimple(type)
        {
            @Override
            public boolean keep(MMDataProvider data, Target target)
            {
                return function.apply(data, target);
            }
        };
    }
}
