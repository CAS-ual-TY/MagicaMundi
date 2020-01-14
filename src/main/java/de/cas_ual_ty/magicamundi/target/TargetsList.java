package de.cas_ual_ty.magicamundi.target;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class TargetsList extends ArrayList<Target>
{
    // TODO MM: Players, Blocks, Entities etc.
    // public ArrayList<Target> getAllPlayers
    
    @Override
    public TargetsList clone()
    {
        return (TargetsList)super.clone();
    }
}
