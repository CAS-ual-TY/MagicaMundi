package de.cas_ual_ty.magicamundi.node.effect;

import de.cas_ual_ty.magicamundi.node.dataprovider.MMDataProvider;
import de.cas_ual_ty.magicamundi.target.Target;
import de.cas_ual_ty.magicamundi.target.TargetEntity;

public class EffectEffect extends EffectSimple
{
    public static final String KEY_EFFECT_NAME = "effectName";
    
    public net.minecraft.potion.Effect effect;
    
    public EffectEffect(net.minecraft.potion.Effect effect)
    {
        this.effect = effect;
    }
    
    @Override
    public boolean applyEffect(MMDataProvider data, Target target0)
    {
        if(target0 instanceof TargetEntity)
        {
            TargetEntity target = (TargetEntity)target0;
            if(target.isLivingEntity())
            {
                this.effect.affectEntity(data.getSource() instanceof TargetEntity ? ((TargetEntity)data.getSource()).getEntity() : null, data.getSource() instanceof TargetEntity ? ((TargetEntity)data.getLatestSender()).getEntity() : null, target.getLivingEntity(), 1, 1D);
            }
        }
        
        return true;
    }
    
    @Override
    public String getID()
    {
        return null;
    }
}
