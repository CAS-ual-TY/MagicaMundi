package de.cas_ual_ty.magicamundi.effect;

import java.util.List;

import de.cas_ual_ty.magicamundi.target.Target;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class EffectEffect extends Effect
{
    public static final String KEY_EFFECT_NAME = "effectName";
    
    public net.minecraft.potion.Effect effect;
    
    public EffectEffect(net.minecraft.potion.Effect effect)
    {
        this.effect = effect;
    }
    
    public EffectEffect()
    {
    }
    
    @Override
    public boolean applyEffect(List<Target> list)
    {
        // TODO apply vanilla effects
        return false;
    }
    
    @Override
    public String getID()
    {
        return null;
    }
    
    @Override
    public void readNodeFromNBT(CompoundNBT nbt0)
    {
        ResourceLocation rl = new ResourceLocation(nbt0.getString(EffectEffect.KEY_EFFECT_NAME));
        this.effect = Registry.EFFECTS.getValue(rl).orElse(null);
        
        super.readNodeFromNBT(nbt0);
    }
    
    @Override
    public void writeNodeToNBT(CompoundNBT nbt0)
    {
        nbt0.putString(EffectEffect.KEY_EFFECT_NAME, this.effect.getRegistryName().toString());
        
        super.writeNodeToNBT(nbt0);
    }
}
