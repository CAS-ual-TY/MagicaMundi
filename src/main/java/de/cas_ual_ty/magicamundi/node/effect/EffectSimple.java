package de.cas_ual_ty.magicamundi.node.effect;

import java.util.List;

import de.cas_ual_ty.magicamundi.node.dataprovider.MMDataProvider;
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
}
