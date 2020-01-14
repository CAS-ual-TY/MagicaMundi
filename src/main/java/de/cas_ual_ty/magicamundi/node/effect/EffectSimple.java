package de.cas_ual_ty.magicamundi.node.effect;

import java.util.List;

import de.cas_ual_ty.magicamundi.target.Target;

public abstract class EffectSimple extends Effect
{
    public EffectSimple()
    {
    }
    
    @Override
    public boolean applyEffect(List<Target> list)
    {
        for(Target t : list)
        {
            if(!this.applyEffect(t))
            {
                return false;
            }
        }
        
        return true;
    }
    
    public abstract boolean applyEffect(Target target);
}
