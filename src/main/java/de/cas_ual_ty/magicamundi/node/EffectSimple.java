package de.cas_ual_ty.magicamundi.node;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import de.cas_ual_ty.magicamundi.provider.MMDataProvider;
import de.cas_ual_ty.magicamundi.target.Target;
import de.cas_ual_ty.visibilis.node.NodeType;

public abstract class EffectSimple extends Effect
{
    public EffectSimple(NodeType<?> type)
    {
        super(type);
    }
    
    @Override
    public boolean applyEffect(MMDataProvider data, List<Target> list)
    {
        for(Target t : list)
        {
            if(!this.applyEffect(data, t))
            {
                return false;
            }
        }
        
        return true;
    }
    
    public abstract boolean applyEffect(MMDataProvider data, Target target);
    
    public static NodeType.IFactory<EffectSimple> createTypeEffectSimple(BiConsumer<MMDataProvider, Target> function)
    {
        return EffectSimple.createTypeEffectSimple((data, target) ->
        {
            function.accept(data, target);
            return true;
        });
    }
    
    public static NodeType.IFactory<EffectSimple> createTypeEffectSimple(BiFunction<MMDataProvider, Target, Boolean> function)
    {
        return (type) -> new EffectSimple(type)
        {
            @Override
            public boolean applyEffect(MMDataProvider data, Target target)
            {
                return function.apply(data, target);
            }
        };
    }
}
