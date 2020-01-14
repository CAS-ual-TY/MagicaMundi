package de.cas_ual_ty.magicamundi.util;

import java.util.ArrayList;
import java.util.List;

import de.cas_ual_ty.magicamundi.target.Target;

public class MMUtility
{
    public static List<Target> createTargetsList()
    {
        return new ArrayList<>();
    }
    
    public static List<Target> cloneTargetsList(List<Target> list)
    {
        List<Target> newList = MMUtility.createTargetsList();
        newList.addAll(list);
        return newList;
    }
}
